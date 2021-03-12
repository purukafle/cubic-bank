package com.rab3tech.customer.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rab3tech.customer.service.impl.SecurityQuestionService;

/**
 * 
 * @author nagendra
 * This class for customer GUI
 *
 */
@Controller
public class PasswordController {
	
	@Autowired
	private SecurityQuestionService securityQuestionService;
	
	@GetMapping("/customer/forget/password")
	public String showForgetPassword(){
		return "/customer/forgetPass";//forgetPass.html
	}
	
	@PostMapping("/customer/forget/password")
	public String showForgetPasswordPost(@RequestParam("email") String email,Model model){
		List<String> questions=securityQuestionService.findQuestionAnswer(email);
		model.addAttribute("questions",questions);
		return "/customer/validateSecurityQuestion";//validateSecurityQuestion.html
	}
	

}
