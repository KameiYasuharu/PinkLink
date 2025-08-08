package com.example.demo.demos.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.demos.web.entity.PinDetail;

public interface PinDetailRepository extends JpaRepository<PinDetail, String> {

	PinDetail findBySbNo(String sbNo);

}