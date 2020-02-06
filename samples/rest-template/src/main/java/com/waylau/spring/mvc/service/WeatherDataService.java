package com.waylau.spring.mvc.service;

import com.waylau.spring.mvc.vo.WeatherResponse;

/**
 * 天气数据服务.
 * 
 * @since 1.0.0 2020年2月6日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface WeatherDataService {

	/**
	 * 根据城市ID查询天气数据
	 * @param cityId
	 * @return
	 */
	WeatherResponse getDataByCityId(String cityId);
	
	/**
	 * 根据城市名称查询天气数据
	 * @param cityId
	 * @return
	 */
	WeatherResponse getDataByCityName(String cityName);
}
