package br.com.challenge.itau;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.challenge.itau.service.ValidadorSenhaService;

@SpringBootTest
public class ValidadorSenhaServiceTest {

	@Autowired
	ValidadorSenhaService validadorSenhaService;
	
	@Test
	public void validarSenhaEmpty() {
		String senha = "";
		boolean isValid = validadorSenhaService.validarSenha(senha);	
		assertFalse(isValid);
	}
	
	@Test
	public void validarSenhaNull() {
		String senha = null;
		boolean isValid = validadorSenhaService.validarSenha(senha);
		
		assertFalse(isValid);
	}
	
	@Test
	public void validarSenhaCaracterRepetido() {
		String senha = "Teste@1234";
		boolean isValid = validadorSenhaService.validarSenha(senha);
		
		assertFalse(isValid);
	}
	
	@Test
	public void validarSenhaNoveCaracter() {
		String senha = "Teste@12";
		boolean isValid = validadorSenhaService.validarSenha(senha);
		
		assertFalse(isValid);
	}
	
	@Test
	public void validarSenhaLetraMaiuscula() {
		String senha = "teste@12345";
		boolean isValid = validadorSenhaService.validarSenha(senha);
		
		assertFalse(isValid);
	}
	
	@Test
	public void validarSenhaLetraMinuscula() {
		String senha = "TESTE@12345";
		boolean isValid = validadorSenhaService.validarSenha(senha);
		
		assertFalse(isValid);
	}
	
	@Test
	public void validarSenhaCaracterEspecial() {
		String senha = "Testa12345";
		boolean isValid = validadorSenhaService.validarSenha(senha);
		
		assertFalse(isValid);
	}
	
	@Test
	public void validarSenha() {
		String senha = "Test@$!*&#^()+-12345";
		boolean isValid = validadorSenhaService.validarSenha(senha);
		
		assertTrue(isValid);
	}
	
}
