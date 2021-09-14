package br.com.fiap.epictask.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.epictask.model.User;
import br.com.fiap.epictask.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@RequestMapping("/users/new")
	public String createUser(User user) {
		return "new-user";
	}
	
	@GetMapping("/users")
	public ModelAndView listUser() {
		List<User> users = repository.findAll();
		ModelAndView modelAndView = new ModelAndView("list-user");
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	@PostMapping("/users")
	public String saveUser(@Valid User user, BindingResult resultUser) {
		if(resultUser.hasErrors()) return "new-user";
		repository.save(user);
		return "list-user";
	}
	
	

}
