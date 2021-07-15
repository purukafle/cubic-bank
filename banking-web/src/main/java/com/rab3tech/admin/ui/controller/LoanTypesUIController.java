package com.rab3tech.admin.ui.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rab3tech.admin.service.LoanTypesService;
import com.rab3tech.vo.LoanTypesVO;

@Controller
@RequestMapping("/admin")
@Scope("singleton")
//@CrossOrigin()
public class LoanTypesUIController {
	
	
	@Autowired
	private LoanTypesService loanTypesService;
	
	
	@GetMapping("/loantype")
	public String showuploadLoanType(Model model) {
		LoanTypesVO loantypeVO=new LoanTypesVO();
		model.addAttribute("loantypeVO",loantypeVO);
		//model is used to send data from controller to UI
		return "admin/loantype"; 
	}
	
	
	@PostMapping("/loantype")
	public String uploadLoanType(@ModelAttribute LoanTypesVO loanTypesVO,Model model) {
		loanTypesVO.setDoe(new Timestamp(new Date().getTime()));
		LoanTypesVO loantypeVO=new LoanTypesVO();
		loanTypesService.save(loanTypesVO);
		model.addAttribute("loantypeVO",loantypeVO);
		model.addAttribute("message","Hi record is added successfully!!");
		return "admin/loantype"; 
	}
}
