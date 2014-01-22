package br.com.ambiciousteam.pfbistro.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.ambiciousteam.pfbistro.exceptions.MsgErrorException;
import br.com.ambiciousteam.pfbistro.logic.LogicImpl;

public class LogicImplTest {

	LogicImpl logic = new LogicImpl();

	@Before
	public void setUp() throws Exception {

	}

	@Test
	/**
	 * Este teste e para implementacao do metodo de login, 
	 * primeiro este teste retorna 'FALSE', entao a implementacao 
	 * deve retornar um 'TRUE'.
	 */
	public void testLoginWorks() {
		assertEquals(true, logic.login("Wilde", "123"));
	}

	@Test
	/**
	 * Este teste e para implementacao do metodo de login, 
	 * primeiro este teste retorna 'FALSE', entao a implementacao 
	 * deve retornar um 'TRUE', exceto quando o administrador estao errados.
	 */
	public void testLoginDontWorks() {
		assertEquals(false, logic.login("metallica", "dragonForce"));
	}

	@Test
	/**
	 * Este teste e para a implementacao do metodo 'CREATEANDCADASTREPRODUCT', 
	 * e retorna TRUE, se correto.
	 */
	public void testCreateAndCadastreProductWorks() {

		// Cria um array para verificar se createAndCadastreProduct trabalha com
		// informacoes duplicadas;
		String[] array = { "Coca-Cola", "6.50", "Bebidas" };

		assertEquals(
				true,
				logic.createAndCadastreProduct(array[0],
						Double.parseDouble(array[1]), array[2]));

	}

	@Test
	/**
	 * Este teste e para a implementacao do metodo  CREATEANDCADASTREPRODUCT, 
	 * primeiro retorna TRUE, mas o mesmo metodo nao pode salvar dados iguais no banco de dados.
	 */
	public void testCreateAndCadastreProductDontWorks() {

		String[] array = { "Coca-Cola", "6.50", "Bebidas" };

		assertEquals(
				false,
				logic.createAndCadastreProduct(array[0],
						Double.parseDouble(array[1]), array[2]));

	}

	@Test
	/**
	 * Este teste e para a implementacao do metodo  CREATEANDCADASTREPRODUCT, 
	 * primeiro retorna TRUE, mas o mesmo metodo nao pode salvar dados vazios no banco de dados.
	 */
	public void testCreateAndCadastreProductNoString() {

		String[] array = { "", "6.50", "" };

		assertEquals(
				false,
				logic.createAndCadastreProduct(array[0],
						Double.parseDouble(array[1]), array[2]));
	}

	@Test
	/**
	 * Este teste e para a implementacao do metodo REGISTERINGADMIN, 
	 * primeiro retorna TRUE, se correto.
	 */
	public void testRegisteringAdminWorks() throws MsgErrorException {
		// Cria um array para verificar se registeringAdmin funciona com
		// dois usuarios iguais;
		String[] array = { "LedZepllin", "U2" };
		assertEquals(true, logic.registeringAdmin(array[0], array[1]));

	}

	@Test
	/**
	 * Este teste e para a implementacao do metodo REGISTERINGADMIN, 
	 * primeiro retorna TRUE, mas o mesmo metodo nao pode salvar dados iguais no banco de dados.
	 */
	public void testRegisteringAdminDontWorks() throws MsgErrorException {

		// Cria um array para verificar se registeringAdmin funciona com
		// dois usuarios iguais;
		String[] array = { "Wilde", "123" };
		assertEquals(false, logic.registeringAdmin(array[0], array[1]));
	}

	@Test
	/**
	 * Este teste e para a implementacao do metodo REGISTERINGADMIN, 
	 * primeiro retorna TRUE, mas o mesmo metodo nao pode salvar dados vazios no banco de dados
	 */
	public void testRegisteringAdminNoString() throws MsgErrorException {

		// Cria um array para verificar se registeringAdmin funciona com
		// dados de usuario e senha vazios.
		String[] array = { "", "" };
		assertEquals(false, logic.registeringAdmin(array[0], array[1]));
	}
}
