
public class CamelCaseConverter {

	public static void converterCamelCase(String fraseCamel) {
		if(fraseCamel != null) {
			if(fraseCamel.substring(0, 1).matches("[0-9]")){
				throw new InicioNumericoException("String n�o pode inicar com n�mero");
			}
		}
	}
}
