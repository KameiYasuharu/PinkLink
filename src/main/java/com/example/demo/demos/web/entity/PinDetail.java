package com.example.demo.demos.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pin_detail")
public class PinDetail {

	//設備番号
	@Id
	@Column(name = "sb_no")
	private String sbNo;

	//緯度
	@Column(name = "ido")
	private double ido;

	//経度
	//@Column(name = "keido")
	private double keido;

	//ダミー項目
	@Column(name = "dummy_item")
	private String dummyItem;

	//設計図有無フラグ
	@Column(name = "design_flg")
	private String designFlg;

	//写真有無フラグ
	@Column(name = "photo_flg")
	private String photoFlg;

	public String getSbNo() {
		return sbNo;
	}

	public void setSbNo(String sbNo) {
		this.sbNo = sbNo;
	}

	public double getIdo() {
		return ido;
	}

	public void setIdo(double ido) {
		this.ido = ido;
	}

	public double getKeido() {
		return keido;
	}

	public void setKeido(double keido) {
		this.keido = keido;
	}

	public String getDummyItem() {
		return dummyItem;
	}

	public void setDummyItem(String dummyItem) {
		this.dummyItem = dummyItem;
	}

	public String getDesignFlg() {
		return designFlg;
	}

	public void setDesignFlg(String designFlg) {
		this.designFlg = designFlg;
	}

	public String getPhotoFlg() {
		return photoFlg;
	}

	public void setPhotoFlg(String photoFlg) {
		this.photoFlg = photoFlg;
	}
}