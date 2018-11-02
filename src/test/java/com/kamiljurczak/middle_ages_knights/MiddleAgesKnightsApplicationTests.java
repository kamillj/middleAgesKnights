package com.kamiljurczak.middle_ages_knights;

import com.kamiljurczak.middle_ages_knights.domain.Castle;
import com.kamiljurczak.middle_ages_knights.domain.Knight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MiddleAgesKnightsApplicationTests {

	@Autowired
	Knight knight;

	@Autowired
	Castle castle;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCastle(){
		String except = "Znajduje się tu zamek Castle Black zamieszkały przez rycerza Lancelot (29). Ma zadnie: Uratuj księżniczkę";
		assertEquals(except, castle.toString());
	}

}
