package br.com.challenge.itau;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.challenge.itau.service.ValidadorSenhaService;

@SpringBootTest
@AutoConfigureMockMvc
public class ValidadorSenhaControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ValidadorSenhaService validadorSenhaService;
	
	@Test
	public void validarSenhaGetException() throws Exception {
		Mockito.when(validadorSenhaService.validarSenha(Mockito.anyString())).thenThrow(RuntimeException.class);
		mockMvc.perform(get("/validador/v1/validarSenha").param("senha", "test@1234")).andExpect(status().isInternalServerError());
	}
	
	@Test
	public void validarSenhaGetFalse() throws Exception {
		Mockito.when(validadorSenhaService.validarSenha(Mockito.anyString())).thenReturn(false);
		mockMvc.perform(get("/validador/v1/validarSenha").param("senha", "test1234")).andExpect(status().isOk());
	}
	
	@Test
	public void validarSenhaGetTrue() throws Exception {
		Mockito.when(validadorSenhaService.validarSenha(Mockito.anyString())).thenReturn(true);
		mockMvc.perform(get("/validador/v1/validarSenha").param("senha", "test@1234")).andExpect(status().isOk());
	}
	
}
