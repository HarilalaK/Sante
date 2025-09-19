package com.sante.medical.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Indique que cette classe est une API rest
@RequestMapping("/api") //prefixe de tous les endpoint
public class HelloController {
	
	 	@GetMapping("/hello") // Cet endpoint répondra aux requêtes GET sur /api/hello
	 	public Map<String, String> sayHello() {
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Bonjour, mon backend Spring Boot fonctionne !");
	        response.put("status", "success");
	        return response;
	    }
	
}
