package com.geotek.siivra.dto.response.common;


import java.io.Serializable;

public class DataResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    private String msg;
    private Integer code;
    private Object data;
    
    
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
