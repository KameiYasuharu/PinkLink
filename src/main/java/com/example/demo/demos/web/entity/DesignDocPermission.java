package com.example.demo.demos.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DESIGN_DOC_PERMISSION")
public class DesignDocPermission {
	@Id
	@Column(name = "USR_ID")
	private String usrId;
	@Column(name = "GYM_CD_1")
	private String gymCd1;
	@Column(name = "PERMISSION_FLG_1")
	private String permissionFlg1;
	@Column(name = "GYM_CD_2")
	private String gymCd2;
	@Column(name = "PERMISSION_FLG_2")
	private String permissionFlg2;
}
