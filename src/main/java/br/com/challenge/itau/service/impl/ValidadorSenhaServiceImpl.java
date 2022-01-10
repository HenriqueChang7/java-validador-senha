package br.com.challenge.itau.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import br.com.challenge.itau.service.ValidadorSenhaService;

@Service
public class ValidadorSenhaServiceImpl implements ValidadorSenhaService {

	private final String REGEX_VALIDADOR_SENHA = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{9,}$";
	private final String[] caracterEspecialArray = { "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+" };

	public ValidadorSenhaServiceImpl() {
		super();
	}

	public boolean validarSenha(String senha) {
		boolean retorno;

		if (StringUtils.isBlank(senha)) {
			retorno = false;
		} else {
			retorno = senha.matches(REGEX_VALIDADOR_SENHA) && validarCaracterEspecial(senha)
					&& validarCaracterRepetido(senha);
		}
		return retorno;
	}

	private boolean validarCaracterRepetido(String valor) {
		boolean valid = true;
		for (int i = 1; i <= valor.length(); i++) {
			int positionIni = i - 1;
			int positionFim = positionIni + 1;
			String caracter = valor.substring(positionIni, positionFim);
			if (valor.substring(positionFim).contains(caracter) && valor.length() != positionFim) {
				valid = false;
				break;
			}
		}
		return valid;
	}

	private boolean validarCaracterEspecial(String valor) {

		boolean valid = false;
		for (String caracterEspecial : caracterEspecialArray) {
			if (valor.contains(caracterEspecial)) {
				valid = true;
				break;
			}
		}

		return valid;
	}
}
