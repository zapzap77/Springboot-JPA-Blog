package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest1 {

	private static final String TAG = "HttpControllerTest : ";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().userName("sar").password("1234").email("bin2281@gmail.com").build();
		System.out.println(TAG + "getter : " + m.getUserName());
		 m.setUserName("sub");
		 System.out.println(TAG + "getter : " + m.getUserName());
		 return "lombok test success"; 
	}
	
	// 인터넷 브라우저 요청은 get밖에 안됌
	@GetMapping("/http/get")
	public String getTest(Member m) {
		
		return "get요청 : " + m.getId() + "," + m.getUserName() + "," + m.getPassword() + "," + m.getEmail();
	}

	@PostMapping("/http/post")
	public String postTest() {
		return "post요청";
	}

	@PutMapping("/http/put")
	public String putTest() {
		return "put요청";
	}

	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete요청";
	}

}
