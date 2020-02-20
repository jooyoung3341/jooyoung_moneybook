package kr.co.moneybook.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.Status;

@Mapper
public interface StatusMapper {

	//가계부 현형
	public List<Status> status_select(Map<String, Object> hashStatus);
}
