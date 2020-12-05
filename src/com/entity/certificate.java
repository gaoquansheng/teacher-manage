package com.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class certificate {
	private int certificate_id;
	private String user_idno;
	private String certificate_name;
	private String certificate_org;
	private Date certificate_enddate;
	private String certificate_photo;
	private String certificate_no;
	private MultipartFile certificate_photo_src;
	public String getCertificate_no() {
		return certificate_no;
	}
	public void setCertificate_no(String certificate_no) {
		this.certificate_no = certificate_no;
	}
	public Date getCertificate_enddate() {
		return certificate_enddate;
	}
	public void setCertificate_enddate(Date certificate_enddate) {
		this.certificate_enddate = certificate_enddate;
	}
	public String getCertificate_org() {
		return certificate_org;
	}
	public void setCertificate_org(String certificate_org) {
		this.certificate_org = certificate_org;
	}
	public String getCertificate_name() {
		return certificate_name;
	}
	public void setCertificate_name(String certificate_name) {
		this.certificate_name = certificate_name;
	}
	public String getUser_idno() {
		return user_idno;
	}
	public void setUser_idno(String user_idno) {
		this.user_idno = user_idno;
	}
	public int getCertificate_id() {
		return certificate_id;
	}
	public void setCertificate_id(int certificate_id) {
		this.certificate_id = certificate_id;
	}
	public String getCertificate_photo() {
		return certificate_photo;
	}
	public void setCertificate_photo(String certificate_photo) {
		this.certificate_photo = certificate_photo;
	}
	public MultipartFile getCertificate_photo_src() {
		return certificate_photo_src;
	}
	public void setCertificate_photo_src(MultipartFile certificate_photo_src) {
		this.certificate_photo_src = certificate_photo_src;
	}
	

	

}
