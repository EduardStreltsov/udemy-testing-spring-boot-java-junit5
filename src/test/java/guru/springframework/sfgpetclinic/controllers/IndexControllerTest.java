package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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
		assertThat(controller.index()).isEqualTo("index");
	}
	
	@Test
	@DisplayName("Test exception")
	void oupsHandler() {
		assertThrows(ValueNotFoundException.class, () -> {
			controller.oupsHandler();
		});
	}
	
	@Test
	@Disabled("Demo of timeout")
	void testTimeOut() {
		assertTimeout(Duration.ofMillis(100), () -> {
			Thread.sleep(2000);
			System.out.println("You will see this message. Single thread.");
		});
	}
	
	@Test
	@Disabled("Demo of timeout")
	void testTimeOutPreemptively() {
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			Thread.sleep(200);
			System.out.println("You won't see this message. Another thread.");
		});
	}
	
	@Test
	void testAssumptionTrue() {
		assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
	}
	
	@Test
	void testAssumptionFalse() {
		assumeTrue("GURU".equalsIgnoreCase("guru"));
	}
	
	@Test
	@EnabledOnOs(OS.MAC)
	void testMeOnMacOS() {
	}
	
	@Test
	@EnabledOnOs(OS.WINDOWS)
	void testMeOnWindows() {
	}
	
	@Test
	@EnabledOnJre(JRE.JAVA_8)
	void testMeOnJava8() {
	}
	
	@Test
	@EnabledOnJre(JRE.JAVA_11)
	void testMeOnJava11() {
	}
	
	@Test
	@EnabledIfEnvironmentVariable(named = "USER", matches = "Eduars.Streltsov")
	void testMeOnUserName() {
	}
	
	@Test
	@EnabledIfEnvironmentVariable(named = "USER", matches = "Username")
	void testMeOnSomeUser() {
	}
	
}