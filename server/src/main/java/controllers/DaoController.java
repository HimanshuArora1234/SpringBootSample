package controllers;

import entities.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Utils.SecurityUtility;
import services.UserService;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class DaoController {
    @Autowired
    private UserService userService;
    private static String SESSION_COOKIE = "suivi_client_session";
    private static String SESSION_COOKIE_VAL_OK = "OK";
    @Autowired
    private SecurityUtility securityUtility;
    

    @RequestMapping(method = RequestMethod.GET, path="/")
    public String home(HttpServletResponse response) {
    	Cookie sessionCookie;
		try {
			String val = securityUtility.encode(SESSION_COOKIE_VAL_OK);
			sessionCookie = new Cookie(SESSION_COOKIE, URLEncoder.encode(val, "UTF-8")); //Authenticating user by storing his credentials in a cookie
			sessionCookie.setMaxAge(600); //600 secs i.e. 10mins
	    	response.addCookie(sessionCookie);
	        return "index.html";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
    	
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
    public ResponseEntity<?> getAll(@CookieValue("suivi_client_session") String sessionCookie) {
    	try {
    		//Check if user authenticated using session cookie
			if (!securityUtility.decode(sessionCookie).equals(SESSION_COOKIE_VAL_OK)) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    	} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
    }
}
