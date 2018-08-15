import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CamelCaseConverter {

	public static List<String> converterCamelCase(String fraseCamel) {
		List<String> palavras = null;
		if (fraseCamel != null && fraseCamel.substring(0, 1).matches("[0-9]")) {
			throw new InicioNumericoException("String não pode iniciar com número");
		}

	    String fraseMarcada = marcarFrase(fraseCamel);
		palavras = Arrays.asList(fraseMarcada.split("\\|"));
	    
		return palavras.stream().map(palavra -> palavra.toLowerCase()).collect(Collectors.toList());//convertendo todas as palavras para caixa baixa
	}
	
	protected static String marcarFrase(String frase) {
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < frase.length() ; i++) {
			boolean letraAtualMaiuscula = Character.isUpperCase(frase.charAt(i)); 
			boolean proximaLetraMinuscula = frase.length() > i + 1 && Character.isLowerCase(frase.charAt(i + 1));
			boolean letraAnteriorMinuscula = i > 0 && Character.isLowerCase(frase.charAt(i - 1));
			if (letraAtualMaiuscula && (proximaLetraMinuscula || letraAnteriorMinuscula)) {
				sb.append("|");
			}
			sb.append(frase.charAt(i));
		}
		return sb.toString();
	}
}
