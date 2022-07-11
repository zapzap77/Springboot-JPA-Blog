package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

	//정적파일만 찾을 수 있음
	
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		//파일리턴 기본경로 : src/main/resources/static
		//리턴값 앞에 "/",  controller는 파일을 리턴함
		return "/home.html";
	}
	
	@GetMapping("/temp/image")
	public String tempImg() {
		return "/a.png";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		// prefix , sufix가 붙음
		
		return "test";
	}
}
