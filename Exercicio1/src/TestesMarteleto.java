import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestesMarteleto {
	 public void recu10pera20Primeiros() {
			List<String> value = CamelCaseConverter.converterCamelCase("recu10pera20Primeiros");
			assertEquals("recu", value.get(0));
			assertEquals("10", value.get(1));
			assertEquals("pera", value.get(2));
			assertEquals("20", value.get(3));
			assertEquals("primeiros", value.get(4));
		}
		
		@Test
	  public void recuP10Pera20Primeiros() {
			List<String> value = CamelCaseConverter.converterCamelCase("recuP10Pera20Primeiros");
			assertEquals("recu", value.get(0));
			assertEquals("P", value.get(1));
			assertEquals("10", value.get(2));
			assertEquals("pera", value.get(3));
			assertEquals("20", value.get(4));
			assertEquals("primeiros", value.get(5));
		}
		
		@Test(expected=CaracterInvalidoException.class)
	  public void space10P20() {
			CamelCaseConverter.converterCamelCase(" 10P20");
		}
		
		@Test(expected=CaracterInvalidoException.class)
	  public void x10spaceP20() {
			CamelCaseConverter.converterCamelCase("x10 P20");
		}
}

