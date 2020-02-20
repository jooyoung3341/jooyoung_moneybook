package kr.co.moneybook.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.Expense;
import kr.co.moneybook.domain.Status;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.mapper.StatusMapper;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	private StatusMapper statusMapper;
	
	//가계부 현황
	@Override
	public List<Status> status_select(HttpServletRequest request) {
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();				
		String insert_date = request.getParameter("insert_date");
			
		Map<String, Object> hashStatus = new HashMap<String, Object>();
		hashStatus.put("insert_date", insert_date);
		hashStatus.put("moneybook_name", moneybook_name);
		
		return statusMapper.status_select(hashStatus);
	}

}
