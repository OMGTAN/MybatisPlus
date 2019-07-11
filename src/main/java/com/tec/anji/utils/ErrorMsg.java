package com.tec.anji.utils;

public enum ErrorMsg {
	
	PK_IS_NULL("SYS_001", "主键不能为空！"),
	
	
	WHSTATIONNO_IS_NULL("BUSS_001", "仓库站台编号不能为空！");
	
	
	
	private final String errCode;
	private final String description;
	
	private ErrorMsg(String errCode, String description) {
		this.errCode = errCode;
		this.description = description;
	}

	public String getErrCode() {
		return errCode;
	}

	public String getDescription() {
		return description;
	}

}
