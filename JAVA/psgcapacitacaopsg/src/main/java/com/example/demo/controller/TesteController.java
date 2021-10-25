package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teste")
public class TesteController {
	static int x;
	@GetMapping("/get")
	public String testar() {
		
		System.out.println(x++);
		return "Teste Realizado com sucesso";
	
		
	}
}
