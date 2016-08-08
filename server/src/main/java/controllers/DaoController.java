package controllers;

import entities.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import services.UserService;

import java.util.List;

import javax.validation.Valid;

@Controller
public class DaoController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, path="/")
    public String home() {
        return "index.html";
    }

    @RequestMapping(method = RequestMethod.GET, path="/hello")
    @ResponseBody
    public String home1() {
        return "hello !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    }

    @RequestMapping(method = RequestMethod.POST, value="/add", headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional(readOnly = true)
    public User addUser(@Valid @RequestBody User user, BindingResult bindingResults) throws Exception {
    	if (bindingResults.hasErrors()) {
    		throw new Exception("Input invalid");
	     } else {
	    	 return this.userService.create(user);
	     }
	}

    @ApiOperation(value = "getAll", nickname = "getAll")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/all")
    @ResponseBody
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return this.userService.findAll();
    }
}