
	import java.util.Scanner;
	import java.util.logging.Logger;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	
	import Narzedzia.KeyNotFoundException;
	import Narzedzia.Kolejka;
	import Narzedzia.Para;
	import Narzedzia.Slownik;
	import Narzedzia.Wyj¹tekONP;
	
	public class Main {
	
	
	private static final int clear = 0;
    private static final int clear_everything = 1;
    private static final int CALC = 2;
    private static final String EXIT = "exit";
    private static final int UNDEFINED = -1;

	public static void main(String[] args) throws KeyNotFoundException {

		
		Slownik sl = new Slownik();
		Scanner odczyt = new Scanner(System.in);
        String command = odczyt.nextLine();
        Wyrazenie wyr;
        Para p = new Para("a", 1);
        sl.Add(p);
        Para p1 = new Para("b", 2);
        sl.Add(p1);
        Para p2 = new Para("x", 3);
        sl.Add(p2);
        Para p3 = new Para("y", 4);
        sl.Add(p3);

        while(!command.equals(EXIT)){
        	switch (operacja(command)) {
			case CALC:
				try {

                    wyr = new Wyrazenie(wytnijDoONP(command), sl);

                    System.out.println( wyr.Oblicz());


                } catch (Wyj¹tekONP wyjatekONP) {
                    System.out.println( "[B£¥D] : "+ wyjatekONP.getMessage() );
                }
				break;
			case clear:
				deleteVariableFromList(sl, command);
				break;
			default:
				throw new AssertionError();
        	}
        	
        	command = odczyt.nextLine();
        }
        odczyt.close();
	}
		
	
	
	private static int operacja(String command) {
		if( command.startsWith("clear") ) {
            if (command.matches("(?i).* \\p{Alpha}\\p{Alnum}*.*")) {
                return clear;
            }
            return clear_everything;
        }
        if( command.startsWith("calc") )
            return CALC;

        return UNDEFINED;
	}
	
	
	private static String wytnijDoONP(String string) {
    	string = string.replace("calc ", "");

        if(ileZmmiennych(string) == 0)
            return string;


        int p = string.indexOf("=");

        String first = string.substring(0, p-2);

        return first;
	}
	
	private static int ileZmmiennych(String string) {
		String pattern = "\\p{Alpha}\\p{Alnum}* =";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(string);

        int count = 0;
        while(m.find()) {
            count++;
        }

        return count;
	}
	
	
	private static void deleteVariableFromList(Slownik sl, String command) throws KeyNotFoundException {
   	 command = command.replace("clear ", "");

        Matcher m = Pattern.compile("\\p{Alpha}\\p{Alnum}*").matcher(command);
        sl.remove(command);
	}
}
