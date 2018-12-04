package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
	
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
}