package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Owner map service test")
class OwnerMapServiceTest {
	
	OwnerService ownerMapService;
	PetTypeService petTypeService;
	PetService petService;
	
	@BeforeEach
	void setUp() {
		petTypeService = new PetTypeMapService();
		petService = new PetMapService();
		ownerMapService = new OwnerMapService(petTypeService, petService);
		
		System.out.println("BeforeEach 0");
	}
	
	@Test
	@DisplayName("Verify Zero Owners")
	void ownersAreZero() {
		int ownerCount = ownerMapService.findAll().size();
		assertEquals(ownerCount, 0);
	}
	
	@Nested
	@DisplayName("Pet Type - ")
	class TestCreatePetTypes {
		
		@BeforeEach
		void setUp() {
			PetType petType = new PetType(1L, "Dog");
			PetType petType2 = new PetType(2L, "Cat");
			petTypeService.save(petType);
			petTypeService.save(petType2);
			
			System.out.println("BeforeEach 1");
		}
		
		@Test
		void testPetCount() {
			assertEquals(petTypeService.findAll().size(), 2);
		}
		
		@Nested
		@DisplayName("Save Owners Tests - ")
		class SaveOwnersTest {
			
			@BeforeEach
			void setUp() {
				System.out.println("BeforeEach 2");
			}
			
			@Test
			void level2() {
				assertEquals(0,0);
			}
		}
		
	}
	
	@Test
	@DisplayName("Verify still zero")
	void ownersAreStillZero() {
		int ownerCount = ownerMapService.findAll().size();
		assertEquals(ownerCount, 0);
	}
}