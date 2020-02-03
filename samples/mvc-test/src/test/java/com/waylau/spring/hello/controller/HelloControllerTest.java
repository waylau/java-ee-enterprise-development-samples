/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.hello.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



/**
 * HelloController Test.
 * 
 * @since 1.0.0 2020年2月2日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@ExtendWith(value={SpringExtension.class})
@ContextConfiguration("classpath:spring.xml")
@WebAppConfiguration
public class HelloControllerTest {

	MockMvc mockMvc;

    @BeforeEach
    void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

	@Test
    void testHello() throws Exception {
        this.mockMvc.perform(get("/hello")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(content().string("Hello World! Welcome to visit waylau.com!"));
            ;
    }
}