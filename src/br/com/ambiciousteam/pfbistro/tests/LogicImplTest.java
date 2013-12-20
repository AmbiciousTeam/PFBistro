//package br.com.ambiciousteam.pfbistro.tests;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import br.com.ambiciousteam.pfbistro.logic.LogicImpl;
//import br.com.ambiciousteam.pfbistro.model.Administrator;
//
//public class LogicImplTest {
//	
//	LogicImpl logic = new LogicImpl();
//	Administrator admin = new Administrator();
//	
//	@Before
//	public void setUp() throws Exception {
//		
//	}
//
//
////	@Test
//	
//	/**
//	 *This test is for implementation LOGIN method, 
//	 * first it is returning a FALSE, then the implementation must obtain a return TRUE.
//	 */
//
////		public void testLoginWorks() {
////		assertEquals(true, logic.login(admin));
////	}
//	
//	@Test
//	
//	/**
//	 *This test is for implementation LOGIN method, 
//	 * first it is returning a TRUE, then the implementation must obtain a return FALSE,
//	 * except when administrator and password are wrong
//	 */
//	
//	public void testLoginDontWorks() {
//	assertEquals(false, logic.login(admin));
//}
//
//	@Test
//	
//	/**
//	 *This test is for implementation CREATEANDCADASTREPRODUCT method, 
//	 * first it is returning a TRUE it is correct.
//	 */
//	
//	public void testCreateAndCadastreProductWorks() {
//
//		//Create array for verifying if createAndCadastreProduct work with informations named equals;  
//				String[] array= {"Coca-Cola", "6.50", "Bebidas"};
//
//				assertEquals(true, logic.createAndCadastreProduct
//							(array[0], Double.parseDouble(array[1]), array[2]));
//				
//	}
//					
//		//In test with JUnit the program can save in database the two information, but this product can't saved.	
//				
//	@Test
//	
//	/**
//	 *This test is for implementation CREATEANDCADASTREPRODUCT method, 
//	 * first it is returning a TRUE, but the same method could not save equal data in the database.
//	 */
//	
//	public void testCreateAndCadastreProductDontWorks() {
//
//				String[] array= {"Coca-Cola", "6.50", "Bebidas"};
//
//				assertEquals(false, logic.createAndCadastreProduct
//							(array[0], Double.parseDouble(array[1]), array[2]));
//				
//	}
//	
//	@Test
//	
//	/**
//	 *This test is for implementation CREATEANDCADASTREPRODUCT method, 
//	 * first it is returning a TRUE, but the same method could not save empty data to the database.
//	 */
//	
//	public void testCreateAndCadastreProductNoString() {
//
//				String[] array= {"", "6.50", ""};
//
//				assertEquals(false, logic.createAndCadastreProduct
//							(array[0], Double.parseDouble(array[1]), array[2]));
//				
//	}
//		
//	
//	@Test
//	
//	/**
//	 *This test is for implementation REGISTERINGADMIN method, 
//	 * first it is returning a TRUE it is correct.
//	 */
//	
//	public void testRegisteringAdminWorks() {
//		
//		//Create array for verifying if registeringAdmin work with two administrators and passwords named equals;  
//		String[] array= {"Wilde", "123"};
//		assertEquals(true, logic.registeringAdmin(array[0], array[1]));
//		
//	}
//		
//				
//		//In test with JUnit the program can save in database the repeated information and saves the information "".	
//
//	@Test
//	
//	/**
//	 *This test is for implementation REGISTERINGADMIN method, 
//	 * first it is returning a TRUE, but the same method could not save equal data in the database.
//	 */
//	
//	public void testRegisteringAdminDontWorks() {
//		
//		//Create array for verifying if registeringAdmin work with two administrators and passwords named equals;  
//		String[] array= {"Wilde", "123"};
//		assertEquals(false, logic.registeringAdmin(array[0], array[1]));
//		
//	}
//
//	@Test
//	
//	/**
//	 *This test is for implementation REGISTERINGADMIN method, 
//	 * first it is returning a TRUE, but the same method could not save empty data to the database.
//	 */
//	
//	public void testRegisteringAdminNoString() {
//		
//		//Create array for verifying if registeringAdmin work with empty administrators and passwords;  
//		String[] array= {"", ""};
//		assertEquals(false, logic.registeringAdmin(array[0], array[1]));
//		
//	}
//
//
//}
