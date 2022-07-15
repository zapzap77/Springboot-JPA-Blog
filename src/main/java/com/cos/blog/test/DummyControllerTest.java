package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.DbUser;
import com.cos.blog.model.RoleType;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired // DI
	private UserRepository userRepository;

	@DeleteMapping("/dummy/user/{id}")
	public String deleteUser(@PathVariable int id) {
		try {

			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			
			return "delete fail no id";
		}

		return "delete success , id  : " + id;
	}

	@Transactional
	@PutMapping("/dummy/user/{id}")
	public DbUser updateUser(@PathVariable int id, @RequestBody DbUser requestDbUser) {
		System.out.println("id : " + id);
		System.out.println("pw : " + requestDbUser.getPassword());
		System.out.println("email : " + requestDbUser.getEmail());

		DbUser user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("fail!!!");
		});
		user.setPassword(requestDbUser.getPassword());
		user.setEmail(requestDbUser.getEmail());

		// userRepository.save(user);
		return user;
	}

	@GetMapping("/dummy/user")
	public List<DbUser> list() {
		return userRepository.findAll();
	}

	@GetMapping("/dummy/user/page")
	public List<DbUser> pageList(
			@PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		// List<DbUser> users = userRepository.findAll(pageable).getContent();
		Page<DbUser> pagingUser = userRepository.findAll(pageable);

		List<DbUser> users = pagingUser.getContent();
		return users;
	}

	@GetMapping("/dummy/DbUser/{id}")
	public DbUser detail(@PathVariable int id) {

		DbUser user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("none!! id : " + id);
			}
		});
		return user;

	}

	@PostMapping("/dummy/join")
	public String join(DbUser user) {

		System.out.println("id" + user.getId());
		System.out.println("username : " + user.getUserName());
		System.out.println("password : " + user.getPassword());
		System.out.println("email" + user.getEmail());
		System.out.println("roll" + user.getRole());
		System.out.println("createDate" + user.getCreateDate());

		user.setRole(RoleType.USER);
		userRepository.save(user);

		return "会員登録完了";
	}
}
