package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author user
 * www
 * @RequestMapping 클래스(타입) + 핸들러(메소드)
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		/**
		 * 만일 n이라는 이름의 파라미터가 없는 경우
		 * 400 bad request 에러가 발생한다.
		 */
		System.out.println(name);
		return "UserController.update()";
	} // http://localhost:8080/hellospring03/user/update?n=kim
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required=false, defaultValue="") String name,
						  @RequestParam(value="a", required=false, defaultValue="0")Integer age) {
		// int가아니고 Integer를 쓰면 아무값이 안들어왔을때 null로 들어와서 체크하기가 쉽다.
		System.out.println("===" + name + "===");
		System.out.println("===" + age + "===");
		return "UserController.update()";
	} // http://localhost:8080/hellospring03/user/update2?age=10
	
}
