package com.main.dto;

public class EmployeeStatsDto {
	private String branch;
	private int num;
	public EmployeeStatsDto() {
		
	}
	public EmployeeStatsDto(String branch, int num) {
		super();
		this.branch = branch;
		this.num = num;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "EmployeeStatusDto [branch=" + branch + ", num=" + num + "]";
	}
	
	
	
	
}
