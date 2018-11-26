package com.zxb.java.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "com.zxb.java.core") //指定扫描的包路径
public class MySpringBootDemoApplicationTests {

	@Test
	public void contextLoads() {

	}

}
