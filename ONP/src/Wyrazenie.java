import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Narzedzia.Kolejka;
import Narzedzia.Slownik;
import Narzedzia.SyntaxException;
import Narzedzia.Wyj¹tekONP;

public class Wyrazenie {
	private Kolejka<Symbol> kolejka;
	private Kolejka<Double> stos;
	private Slownik zmienne;
	
	public Wyrazenie(String onp, Slownik zm) throws Wyj¹tekONP{
		kolejka = new Kolejka<>();
		stos = new Kolejka<>();
		zmienne = zm;
		String[] splited = onp.split("\\s+");
		
		Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?");
		Matcher m = p.matcher("");
		
		for( String s : splited){
			if(s.equals("+")){
				kolejka.Add(new Dodaj());
			}else if(s.equals("-")){
				kolejka.Add(new Odejmij());
			}else if(s.equals("*")){
				kolejka.Add(new Pomnoz());
			}else if(s.equals("/")){
				kolejka.Add(new Podziel());
			}else if(s.equals("^")){
				kolejka.Add(new Potega());
			}else if(s.equals("abs")){
				kolejka.Add(new WartoscBezwzgledna());
			}else if(s.equals("cos")){
				kolejka.Add(new Cos());
			}else if(s.equals("sin")){
				kolejka.Add(new Sin());
			}else if(s.equals("log")){
				kolejka.Add(new Log());
			}else if(s.equals("e")){
				kolejka.Add(new E());
			}else if(m.reset(s).matches()){
				kolejka.Add(new Liczba(new Double(s)));
			}else{
				kolejka.Add(new Zmienna(s,zm));
			}
		}
	}
	
	public double Oblicz() throws Wyj¹tekONP{
		Symbol s;
		Funkcja f;
		while ((s = kolejka.GetFirst()) != null){
			if (s instanceof Operand){
				stos.Add(s.obliczWartoœæ());
			}
			else{
				f = (Funkcja) s;
				while(f.brakujaceArgumenty() > 0){
					f.dodajArgument(stos.GetLast());
				}
				
				stos.Add(f.obliczWartoœæ());
				
			}
				
		}
		double d = 0;
		d = stos.GetLast();
		if (stos.GetLast() != null){
			throw new SyntaxException();
		}
		return d;
	}
	
	public static final Logger loger = Logger.getLogger(Wyrazenie.class.getName());
	private static FileHandler fh;
	
	static
	{
	    try
	   {
	            fh = new FileHandler("calc.log", false);
	            loger.addHandler(fh);
	            SimpleFormatter formatter = new SimpleFormatter();
	            fh.setFormatter(formatter);
	            loger.setUseParentHandlers(false);
	            loger.info("Uruchomiono KalkulatorONP");
	   } catch (IOException ex)
	    	{
	       		System.err.println(ex.getMessage());
	    	} catch (SecurityException ex)
	    		{
	            	System.err.println(ex.getMessage());
	    		}
	}
}
