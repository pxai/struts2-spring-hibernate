package info.pello.struts.hola;

import com.opensymphony.xwork2.ActionSupport;

public class Saludo extends ActionSupport {
	String saludo = "";
	String lenguaje;

	@Override
	public String execute()

	{

		switch (lenguaje) {
		case "es":
			saludo = "Aupa";
			break;
		case "eu":
			saludo = "Kaixo";
			break;
		case "fr":
			saludo = "bonjour";
			break;
		case "en":
			saludo = "hi";
			break;
		default:
			return "ERROR";
		}

		return "SUCCESS";

	}

public String getSaludo()

{

return saludo;

}

}
