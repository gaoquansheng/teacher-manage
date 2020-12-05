package com.entity;

import java.util.Date;

public class workexperience {
	private int work_id;
	private String user_idno;
	private Date start_date;
	private Date end_date;
	private String work_org;
	private String work_duty;
	public int getWork_id()
	{
		return work_id;
	}
	public void setWork_id(int work_id) {
		this.work_id = work_id;
	}
	public String getUser_idno() {
		return user_idno;
	}
	public void setUser_idno(String user_idno) {
		this.user_idno = user_idno;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getWork_org() {
		return work_org;
	}
	public void setWork_org(String work_org) {
		this.work_org = work_org;
	}
	public String getWork_duty() {
		return work_duty;
	}
	public void setWork_duty(String work_duty) {
		this.work_duty = work_duty;
	}


}
