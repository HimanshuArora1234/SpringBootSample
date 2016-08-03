package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.User;
import services.UserService;

@Controller
public class DaoController {
	@Autowired
	private UserService userService;
	
    @RequestMapping("/")
    public String home() {
        return "index.html";
    }
	
    @RequestMapping("/hello")
    @ResponseBody
    public String home1() {
        return "hello !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    }
    
    @RequestMapping("/add")
	@ResponseBody
	@Transactional
	public User addUser() {
    	 User user = new User();
         user.setName("steve");
         user.setEmail("steve@gmail.com");
		return this.userService.create(user);
    }
    @GetMapping("/all")
	@ResponseBody
	@Transactional
	public List<User> getAll() {
		return this.userService.findAll();
    }
}
