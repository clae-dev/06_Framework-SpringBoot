package edu.kh.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.todo.model.service.TodoService;

@Controller
@RequestMapping("todo")  // "/todo" 로 시작하는 모든 요청 매핑
public class TodoController {
	
	@Autowired // DI : 의존성 주입(같은 타입 + 상속관계인 Bean을 의존성주입)
	private TodoService service;
	
	
	@PostMapping("add") //  /todo/add 로 Post 방식 요청 매핑
	public String addTodo(@RequestParam("todoTitle") String todoTitle, 
						@RequestParam("todoContent") String todoContent
						) {
		// 1. HttpServletRequest req를 통해 getParameter() 하여 얻어오기
		// 2. @RequestParam() 를 이용하여 얻어오기
		// 3. @ModelAttribute와 DTO를 이용하여 얻어오기
		
		// 서비스 메서드 호출 후 결과 반환 받기
		int result = service.addTodo(todoTitle, todoContent);
		
		// 결과에 따라 message 값 지정
		String message = null;
		
		if(result > 0) message = "할 일 추가 성공!!!";
		else 			message = "할 일 추가 실패...";
		
		return "";
	}
	
	
	
	
}