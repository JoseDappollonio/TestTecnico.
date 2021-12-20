package prueba.utils;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class utils {

	public Timestamp fechadeldia() {
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		Timestamp date = new Timestamp(stamp.getTime());
		return date;
	}
	
	public Boolean  ValidarMail(String Mail) {
		Pattern pattern = Pattern.compile( "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(Mail);
		return matcher.find();		
	}
	
	public Boolean ValidaPass(String pass) {
		Boolean mayusculas = false;
		Boolean numero = false;
		int contador = 0;
		Boolean minusculas = false;
		char c ;
		for (int i = 0; i<pass.length(); i++) {
			c = pass.charAt(i);
			
			if(Character.isDigit(c)) {				
				contador++;
				if (contador>=2) {
					numero=true;
				}
			}
			if(Character.isUpperCase(c)) {
				mayusculas = true;
			}
			if(Character.isLowerCase(c)) {
				minusculas = true;
			}
			
			
		}
		if(mayusculas && numero && minusculas) {		
		return true;
		}else{
			return false;
		}
		
	}
	
}
