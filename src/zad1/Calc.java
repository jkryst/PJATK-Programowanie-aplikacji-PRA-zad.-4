/**
 *
 *  @author Kryst Jakub PD3724
 *
 */

package zad1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

public class Calc  {

	public MathContext mc = new MathContext(7);
	public HashMap<String, Method> metody = new HashMap<String, Method>();
	
	
public Calc() {
	
	try {
		
		Class<?> klasa = Class.forName("java.math.BigDecimal");
	    Method dod = klasa.getMethod("add",BigDecimal.class);
	    metody.put("+", dod);
	    
	    Method odejm = klasa.getMethod("subtract",BigDecimal.class);
	    metody.put("-", odejm);
	    
	    Method mnoz = klasa.getMethod("multiply",BigDecimal.class);
	    metody.put("*", mnoz);
	    
	    Method dziel = klasa.getMethod("divide",BigDecimal.class, MathContext.class);
	    metody.put("/", dziel);

	} catch(ClassNotFoundException | NoSuchMethodException e) {}
	
	
}
	
	
public String doCalc(String cmd) {
	
	try {
	
	String s[] = cmd.split(" +");
	BigDecimal a = new BigDecimal(s[0]);
	BigDecimal b = new BigDecimal(s[2]);	
	Method dzialanie = metody.get(s[1]);
	
    try {

	 BigDecimal wynik = (BigDecimal) dzialanie.invoke(a, b);
		return wynik.toString();
	

    } catch (NumberFormatException e ) {
		
		return "Invalid command to calc";
		
	} catch (IllegalAccessException e) {
		
		return "Invalid command to calc";
		
	} catch (IllegalArgumentException e) {
		
		BigDecimal wynik;
		
		try {
			
			wynik = (BigDecimal) dzialanie.invoke(a, b, mc);
			return wynik.toString();
			
		} catch (IllegalAccessException e1) {
			return "Invalid command to calc";
			
		} catch (IllegalArgumentException e1) {
			return "Invalid command to calc";
			
		} catch (InvocationTargetException e1) {
			return "Invalid command to calc";
			
		}
		
	
	} catch (InvocationTargetException e) {
		
		return "Invalid command to calc";
	} 
    
	} catch (NumberFormatException e) {
		return "Invalid command to calc";
	}
	
}

}  
