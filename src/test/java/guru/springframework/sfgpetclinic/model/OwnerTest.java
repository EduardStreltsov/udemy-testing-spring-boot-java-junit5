package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgumentsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("model")
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
	
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@DisplayName("value source")
	@ValueSource(strings = {"Spring", "Framework", "Guru"})
	void testValueSource(String val) {
		System.out.println(val);
	}
	
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@DisplayName("value source")
	@EnumSource(OwnerType.class)
	void enumTest(OwnerType ownerType) {
		System.out.println(ownerType);
	}
	
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@DisplayName("CSV input test")
	@CsvSource({
			"FL, 1, 1",
			"OH, 2, 2",
			"2H, 2, 3",
	})
	void csvInputTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " val1 " + val1 + " val2 " + val2);
	}
	
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@DisplayName("CSV from file test")
	@CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
	void fromCsvFileTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " val1 " + val1 + " val2 " + val2);
	}
	
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@DisplayName("Method Provider Test")
	@MethodSource("getArgs")
	void fromMethodTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " val1 " + val1 + " val2 " + val2);
	}
	
	static Stream<Arguments> getArgs() {
		return Stream.of(Arguments.of("FL", 1, 1),
				Arguments.of("OH", 2, 2),
				Arguments.of("WE", 3, 5));
	}
	
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@DisplayName("Custom Provider Test")
	@ArgumentsSource(CustomArgumentsProvider.class)
	void fromCustomTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " val1 " + val1 + " val2 " + val2);
	}
	
}