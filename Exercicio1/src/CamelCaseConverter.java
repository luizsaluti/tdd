import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.stream.events.Characters;

public class CamelCaseConverter {

	public static List<String> converterCamelCase(String fraseCamel) {
		List<String> palavras = null;
		if (fraseCamel != null) {
			if (fraseCamel.substring(0, 1).matches("[0-9]")) {
				throw new InicioNumericoException("String não pode iniciar com número");
			}

			for (Character c : fraseCamel.toCharArray()) {
				if (!Character.isAlphabetic(c) && !Character.isDigit(c)) {
					throw new CaracterInvalidoException("String não pode conter caracteres especiais");
				}
			}
		}

		String fraseMarcada = marcarFrase(fraseCamel);
		palavras = Arrays.asList(fraseMarcada.split("\\|"));

		return corrigeMaiusculas(palavras);
	}

	protected static String marcarFrase(String frase) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < frase.length(); i++) {
			boolean letraAtualMaiuscula = Character.isUpperCase(frase.charAt(i));
			boolean proximaLetraMinuscula = frase.length() > i + 1 && Character.isLowerCase(frase.charAt(i + 1));
			boolean letraAnteriorMinuscula = i > 0 && Character.isLowerCase(frase.charAt(i - 1));
			boolean inicioPalavraNumerica = Character.isDigit(frase.charAt(i)) && (i > 0 && Character.isAlphabetic(frase.charAt(i - 1)));
			if (letraAtualMaiuscula && (proximaLetraMinuscula || letraAnteriorMinuscula) || inicioPalavraNumerica) {
				sb.append("|");
			}

			sb.append(frase.charAt(i));
		}
		return sb.toString();
	}

	protected static List<String> corrigeMaiusculas(List<String> palavras) {
		return palavras.stream().map(palavra -> {
			boolean todasMaiusculas = true;
			String palavraCerta = palavra;
			for (Character letra : palavra.toCharArray()) {
				if (Character.isLowerCase(letra)) {
					todasMaiusculas = false;
				}
			}
			if (!todasMaiusculas) {
				palavraCerta = palavra.toLowerCase();
			}
			return palavraCerta;
		}).collect(Collectors.toList());// convertendo todas as palavras para caixa baixa
	}
}
