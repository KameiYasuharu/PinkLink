package com.example.demo.demos.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DESIGN_DOC")
public class DesignDoc {
	@Id
	@Column(name = "DESIGN_DOC_ID")
	private String designDocId;
	@Column(name = "CONST_COMPANY")
	private String constCompany;
	@Column(name = "DESIGN_DOC_STS")
	private String designDocSts;
	@Column(name = "AMOUNT_ITEM")
	private String amountItem;
}
