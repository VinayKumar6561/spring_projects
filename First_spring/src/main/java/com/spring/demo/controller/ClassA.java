package com.spring.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ClassA {
  @GetMapping("/hi")
	public String add()
	{
		return "hellp";
	}
  @PostMapping("/vinay")
  public int postMethodName(@RequestBody PostMeth obj) {
     
      return  obj.getName1()+ obj.getName2();
  }
  @PostMapping("/vinay/p/{n1}/{n2}")
  public int Postmeth2(@PathVariable int n1,@PathVariable int n2) {
	     
      return  n1+n2;
  }

  
}
