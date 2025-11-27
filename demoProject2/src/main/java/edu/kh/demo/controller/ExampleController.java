package edu.kh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("example") // /example로 시작하는 모든 요청을 해당 컨트롤러에 매핑
@Slf4j// 라이브러리가 제공하는 로그 객체 자동생성 어노테이션
public class ExampleController {
	
	/* Servlet request < session <application
	 *  내장 객체 범위
	 * page <
	 * Model (org.springframework.ui.Model)
	 * - Spring에서 데이터 전달 역할을 하는 객체
	 * 
	 * - 기본 scope : request
	 * 
	 * - @SessionAttribute와 함께 사용 시 session scope 변환
	 * 
	 * [기본 사용법]
	 * model.addAttribute("key",value);
	 * 
	 * 
	 * */
	
	
	
	
	@GetMapping("ex1") // /example/ex1 GET 방식 요청 매핑
	public String ex1(HttpServletRequest req, Model model) {
	
		req.setAttribute("test1", "HttpServletRequest로 전달한 값"); // request scope
		model.addAttribute("test2", "Model로 전달한 값"); // request scope
		
		
		// src/main/resources/templates/example/ex1.html 로 forward
		return "example/ex1";
	}
	
}
