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
	  
	  
	  String frase2 = "nomeComposto";
	  List<String> frases2 = CamelCaseConverter.converterCamelCase(frase2);
	  assertEquals("nome", frases2.get(0));
	  assertEquals("composto", frases2.get(1));
	  
  }
  
  @Test
  public void conferePalavrasComSigla() {
	  String frase = "testeCPFIndividuo";
	  List<String> frases = CamelCaseConverter.converterCamelCase(frase);
	  assertEquals("teste", frases.get(0));
	  assertEquals("CPF", frases.get(1));
	  assertEquals("individuo", frases.get(2));
  }
  
  @Test
  public void confereUmaPalavra() {
	  String frase = "nome";
	  List<String> frases = CamelCaseConverter.converterCamelCase(frase);
	  assertEquals("nome", frases.get(0));
  }
  
  @Test
  public void confereUmaSigla() {
	  String frase = "CPF";
	  List<String> frases = CamelCaseConverter.converterCamelCase(frase);
	  assertEquals("CPF", frases.get(0));
  }
  
  @Test
  public void confereFraseComNumeros() {
	  String frase = "recupera10Primeiros";
	  List<String> frases = CamelCaseConverter.converterCamelCase(frase);
	  assertEquals("recupera", frases.get(0));
	  assertEquals("10", frases.get(1));
	  assertEquals("primeiros", frases.get(2));
  }
}
