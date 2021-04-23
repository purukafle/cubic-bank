package com.rab3tech.customer.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rab3tech.dao.entity.Branch;

/**
 * 
 * @author javahunk
 * My dao layer is ready!
 *
 */
public interface BranchRepository extends JpaRepository<Branch, Integer> {

	public Optional<Branch> findByIfsc(String ifsc);
	public Optional<Branch> findByCode(String code);
	public Optional<Branch> findByName(String name);
}
