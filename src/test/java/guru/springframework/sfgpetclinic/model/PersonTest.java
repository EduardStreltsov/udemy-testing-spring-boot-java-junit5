package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.RepeatedTest.LONG_DISPLAY_NAME;

class PersonTest implements ModelTest {
	
	@Test
	void groupedAssertions() {
		//given
		Person person = new Person(1L, "Joe", "Buck");
		//when
		//then
		assertAll("Test Props Set",
				() -> assertEquals(person.getFirstName(), "Joe"),
				() -> assertEquals(person.getLastName(), "Buck"));
		
	}
	@Test
	void groupedAssertionsMessages() {
		//given
		Person person = new Person(1L, "Joe", "Buck");
		//when
		//then
		assertAll("Test Props Set",
				() -> assertEquals(person.getFirstName(), "Joe", "first name failed"),
				() -> assertEquals(person.getLastName(), "Buck", "last name failed"));
		
	}
	
	@RepeatedTest(value = 10, name = "{currentRepetition} from {totalRepetitions}")
	void repeatedTest() {
		System.out.println(" ");
	}
	
	@RepeatedTest(5)
	void repeatedTestWithId(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		System.out.println(testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition());
	}
	
	@RepeatedTest(value = 10, name = LONG_DISPLAY_NAME)
	@DisplayName("Assignment")
	void repeatedTestAssignment() {
	
	}
}