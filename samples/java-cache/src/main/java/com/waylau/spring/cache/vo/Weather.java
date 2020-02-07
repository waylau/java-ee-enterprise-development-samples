package com.waylau.spring.cache.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息.
 * 
 * @since 1.0.0 2020年2月7日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public class Weather implements Serializable {
	 
	private static final long serialVersionUID = 1L;
		
	private String city;
    private String aqi;
    private String wendu;
    private String ganmao;
	private Yesterday yesterday;
    private List<Forecast> forecast;
 
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAqi() {
		return aqi;
	}
	public void setAqi(String aqi) {
		this.aqi = aqi;
	}
	public String getWendu() {
		return wendu;
	}
	public void setWendu(String wendu) {
		this.wendu = wendu;
	}
	public String getGanmao() {
		return ganmao;
	}
	public void setGanmao(String ganmao) {
		this.ganmao = ganmao;
	}
    public Yesterday getYesterday() {
		return yesterday;
	}
	public void setYesterday(Yesterday yesterday) {
		this.yesterday = yesterday;
	}
	public List<Forecast> getForecast() {
		return forecast;
	}
	public void setForecast(List<Forecast> forecast) {
		this.forecast = forecast;
	}
}
