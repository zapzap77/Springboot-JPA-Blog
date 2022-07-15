package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.DbUser;
import com.cos.blog.model.RoleType;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userSerivce;

	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody DbUser user) {
		
		System.out.println("UserApiController : save !");
		user.setRole(RoleType.USER);
		userSerivce.会員登録(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);

	}
}
