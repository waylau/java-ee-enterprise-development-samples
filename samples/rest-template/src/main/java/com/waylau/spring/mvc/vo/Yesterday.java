package com.waylau.spring.mvc.vo;

import java.io.Serializable;

/**
 * 昨日天气信息.
 * 
 * @since 1.0.0 2020年2月6日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public class Yesterday implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;

	public Yesterday() {

	}
	
    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getFx() {
		return fx;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getFl() {
		return fl;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
