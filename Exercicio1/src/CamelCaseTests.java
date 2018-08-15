import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

public class CamelCaseTests {
	
  @Test(expected=InicioNumericoException.class)
  public void rejeitaInicioNumerico() {
	  String numero = "10";
	  CamelCaseConverter.converterCamelCase(numero);
  }
  
  @Test
  public void aceitaInicioNaoNumerico() {
	  String palavraIniciadaPorLetra = "abc";
	  CamelCaseConverter.converterCamelCase(palavraIniciadaPorLetra);
  }
  
  @Test
  public void marcarPalavra() {
	  String frase = "testeCamelCase";
	  assertEquals("teste|Camel|Case",CamelCaseConverter.marcarFrase(frase));
  }

  @Test
  public void marcarPalavraComSigla() {
	  String fraseComSigla = "numeroCPFContribuinte";
	  assertEquals("numero|CPF|Contribuinte",CamelCaseConverter.marcarFrase(fraseComSigla));
  }
  
  @Test
  public void divideEmArray() {
	  String frase = "testeCamelCase";
	  List<String> frases = CamelCaseConverter.converterCamelCase(frase);
	  assertTrue(frases.size() == 3);
  }
  
  @Test
  public void conferePalavrasNormais() {
	  String frase = "testeCamelCase";
	  List<String> frases = CamelCaseConverter.converterCamelCase(frase);
	  assertEquals("teste", frases.get(0));
	  assertEquals("camel", frases.get(1));
	  assertEquals("case", frases.get(2));
  }
}
