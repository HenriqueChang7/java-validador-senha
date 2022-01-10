package br.com.challenge.itau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.itau.service.ValidadorSenhaService;

@RestController
@RequestMapping("validador/v1/")
public class ValidadorSenhaController {

	@Autowired
	private ValidadorSenhaService validadorSenhaService;
	
	@GetMapping("validarSenha")
	public ResponseEntity<?> validarSenha(@RequestParam("senha") String senha) {
		try {
			return ResponseEntity.ok().body(validadorSenhaService.validarSenha(senha));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
