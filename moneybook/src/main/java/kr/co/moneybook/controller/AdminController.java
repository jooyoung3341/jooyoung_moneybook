package kr.co.moneybook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.moneybook.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	//관리자페이지 이동
	@RequestMapping(value="moneybook/admin", method=RequestMethod.GET)
	public String admin(HttpServletRequest request) {
		return "admin/admin";
	}
}
