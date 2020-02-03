package com.waylau.spring.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.waylau.spring.mvc.vo.User;


/**
 * Hello 控制器.
 * 
 * @since 2020年2月3日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
	    return "Hello World! Welcome to visit waylau.com!";
	}
	
	@PostMapping(value="/upload")
	public String fileUpload(@RequestPart(value="file") MultipartFile multipartFile) throws IllegalStateException, IOException{
	    //处理逻辑
	    String path = "/fileupload/" + multipartFile.getOriginalFilename();
	    multipartFile.transferTo(new File(path));   
	    
	    return "success!";
	}
}
