package com.example.demo.demos.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.demos.web.entity.DesignDoc;

public interface DesignDocRepository extends JpaRepository<DesignDoc, String> {

}
