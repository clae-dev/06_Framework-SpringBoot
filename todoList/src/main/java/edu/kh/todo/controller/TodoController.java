package edu.kh.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.service.TodoService;

@Controller
@RequestMapping("todo")   // "/todo"로 시작하는 모든 요청 매핑
public class TodoController {
   
   @Autowired   // DI : 의존성 주입(같은 타입 + 상속관계인 Bean을 의존성주입)
   private TodoService service;
   
   @PostMapping("add") //   /todo/add로 Post 방식 요청 매핑
   public String addTodo(@RequestParam("todoTitle") String todoTitle, 
                  @RequestParam("todoContent") String todoContent,
                  RedirectAttributes ra) {
      
      int result = service.addTodo(todoTitle, todoContent);
      
      String message = null;
      
      if(result > 0) {
         message = "할 일 추가 성공 ㅇㅅㅇ";
      } else {
         message = "할 일 추가 실패;;";
      }
      
      ra.addFlashAttribute("message", message);
      
      return "redirect:/";   // 메인페이지로 재요청(리다이렉트)
   }
   
   @GetMapping("detail")
   public String todoDetail(@RequestParam("todoNo") int todoNo, 
                            Model model,
                            RedirectAttributes ra) {
      
      Todo todo = service.todoDetail(todoNo);
      
      String path = null;
      
      // 조회 결과가 있을 경우 detail.html forward
      if(todo != null) {
         
         // ✅ 화면에서 사용할 데이터 model에 담기
         model.addAttribute("todo", todo);
         
         path = "todo/detail";
         
      } else {
         // 조회 결과가 없을 경우 메인페이지로 redirect
         path = "redirect:/";
         ra.addFlashAttribute("message",
               "해당 할 일이 존재하지 않습니다");
      }
      
      // ✅ 모든 경우에 대해 String 리턴!
      return path;
   }

}
