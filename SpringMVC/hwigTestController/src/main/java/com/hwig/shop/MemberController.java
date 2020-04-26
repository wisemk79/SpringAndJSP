package com.hwig.shop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class MemberController {
	
	@RequestMapping(value="/mlogin/login", method=RequestMethod.POST)
	public Map<String, Boolean> login() {
		Map<String, Boolean> result = new HashMap<String,Boolean>();
		result.put("isLogged", false);
		
		return result;
	}
}
