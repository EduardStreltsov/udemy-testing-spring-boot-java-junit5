package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IndexControllerTest {
	
	IndexController controller;
	
	@BeforeEach
	void setUp() {
		controller = new IndexController();
	}
	
	@Test
	@DisplayName("Test Proper View name is returned for index page")
	void index() {
		assertEquals("index", controller.index());
		assertEquals("index", controller.index(), "Wrong");
		assertEquals("index", controller.index(), () -> "Another expensive message" + " make me if you want to evaluate something");
	}
	
	@Test
	@DisplayName("Test exception")
	void oupsHandler() {
		assertTrue("notimplemented".equals(controller.oupsHandler()), () -> "this is some expensive " +
																		  "Message " +
																		  "for my test");
	}

}