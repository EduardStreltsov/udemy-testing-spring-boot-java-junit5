package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

@Tag("model")
public interface ModelTest {
	
	@BeforeEach
	default void beforeEachConsoleOutput(){
		System.out.println("Before each from model test interface");
	}
	
}
