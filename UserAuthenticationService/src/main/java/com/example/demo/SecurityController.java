package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/login")
public class SecurityController {
	
	@GetMapping(path = "/test", produces = "application/json")
	@ResponseBody
	public String tryLogin() {
		return "use password";

	}

	@GetMapping(path = "/private", produces = "application/json")
	@ResponseBody
	public String sayHello() {
		return "use password";

	}
}
