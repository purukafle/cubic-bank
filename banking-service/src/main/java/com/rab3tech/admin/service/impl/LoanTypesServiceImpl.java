package com.rab3tech.admin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3tech.admin.service.LoanTypesService;
import com.rab3tech.customer.dao.repository.LoanTypesRepository;
import com.rab3tech.dao.entity.LoanTypes;
import com.rab3tech.vo.LoanTypesVO;


//Who is creating bean of it ?????? spring application context or spring container

@Service
public class LoanTypesServiceImpl implements LoanTypesService {
	
	@Autowired
	private LoanTypesRepository loanTypesRepository;
	
		
	@Override
	public void save(LoanTypesVO loanTypesVO) {
		LoanTypes loanTypes = new LoanTypes();
		BeanUtils.copyProperties(loanTypesVO, loanTypes);
		loanTypesRepository.save(loanTypes);
	}
	
	@Override
	public List<LoanTypesVO> getAll() {
		return loanTypesRepository.findAll() //List<LoanTypes>
				.stream() //Stream<LoanTypes>
				.map(loan-> { 
			LoanTypesVO loadTypesVO= new LoanTypesVO();
			BeanUtils.copyProperties(loan, loadTypesVO);
			return loadTypesVO; ////Stream<LoanTypesVO>
		}).collect(Collectors.toList());//List<LoanTypesVO>
	}

}
