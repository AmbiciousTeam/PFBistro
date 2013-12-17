package br.com.ambiciousteam.pfbistro.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.ambiciousteam.pfbistro.logic.LogicImpl;
import br.com.ambiciousteam.pfbistro.model.Administrator;

public class LogicImplTest {
	
	LogicImpl logic = new LogicImpl();
	Administrator admin = new Administrator();
	
	@Before
	public void setUp() throws Exception {
		
	}


	@Test
		public void testLoginWorks() {
		assertEquals(true, logic.login(admin));
	}
	
	@Test
	public void testLoginDontWorks() {
	assertEquals(false, logic.login(admin));
}

	@Test
	public void testCreateAndCadastreProductWorks() {

		//Create array for verifying if createAndCadastreProduct work with informations named equals;  
				String[] array= {"Coca-Cola", "6.50", "Bebidas"};

				assertEquals(true, logic.createAndCadastreProduct
							(array[0], Double.parseDouble(array[1]), array[2]));
				
	}
					
		//In test with JUnit the program can save in database the two information, but this product can't saved.	
				
	@Test
	public void testCreateAndCadastreProductDontWorks() {

				String[] array= {"Coca-Cola", "6.50", "Bebidas"};

				assertEquals(false, logic.createAndCadastreProduct
							(array[0], Double.parseDouble(array[1]), array[2]));
				
	}
	
	@Test
	public void testCreateAndCadastreProductNoString() {

				String[] array= {"", "6.50", ""};

				assertEquals(false, logic.createAndCadastreProduct
							(array[0], Double.parseDouble(array[1]), array[2]));
				
	}
		
	
	@Test
	public void testRegisteringAdminWorks() {
		
		//Create array for verifying if registeringAdmin work with two administrators and passwords named equals;  
		String[] array= {"Wilde", "123"};
		assertEquals(true, logic.registeringAdmin(array[0], array[1]));
		
	}
		
				
		//In test with JUnit the program can save in database the repeated information and saves the information "".	

	@Test
	public void testRegisteringAdminDontWorks() {
		
		//Create array for verifying if registeringAdmin work with two administrators and passwords named equals;  
		String[] array= {"Wilde", "123"};
		assertEquals(false, logic.registeringAdmin(array[0], array[1]));
		
	}

	@Test
	public void testRegisteringAdminNoString() {
		
		//Create array for verifying if registeringAdmin work with two administrators and passwords named equals;  
		String[] array= {"", ""};
		assertEquals(false, logic.registeringAdmin(array[0], array[1]));
		
	}


}
