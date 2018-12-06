package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest {
	
	@Test
	void dependentAssertion() {
		Owner owner = new Owner(1L, "Joe", "Buck");
		owner.setCity("Key West");
		owner.setTelephone("123123123");
		
		assertAll("Properties Test",
				() -> assertAll("Person Properties",
						() -> assertEquals("Joe", owner.getFirstName(), "First name didn't match"),
						() -> assertEquals("Buck", owner.getLastName(), "Last name didn't match")),
				() -> assertAll("Owner Properties",
						() -> assertEquals("Key West", owner.getCity()),
						() -> assertEquals("123123123", owner.getTelephone())));
		
		
		assertThat(owner.getCity(), is("Key West"));
		
	}
}