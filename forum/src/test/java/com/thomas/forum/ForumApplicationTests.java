package com.thomas.forum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import com.thomas.forum.service.HelloworldService;

@SpringBootTest // mvn test to trigger the spring boot env test
// simulate the server start (mvn spring-boot:run)
class ForumApplicationTests {

	@Test // can be nothing, but test the SpringBootTest
	void contextLoads() {
	}

	@Spy  // 得到一隻object 但可用when 修改 ？
	// @Mock  
	private HelloworldService helloworldService; 

	@Test
	void spyTest() {
		// Mock Method A to be 100
		Mockito.when(helloworldService.sum(10, 11)).thenReturn(100);
		
		String result = helloworldService.concat("hello", "world");  // should be helloworld100
		Assertions.assertEquals(result, "helloworld100"); 
		


	}



}
