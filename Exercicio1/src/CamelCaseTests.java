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
}
