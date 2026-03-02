package com.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.clg.ClgSiteApplication;


@SpringBootTest(classes = ClgSiteApplication.class)
@ActiveProfiles("test")
class ClgSiteApplicationTests {

	@Test
	void contextLoads() {
	}

}
