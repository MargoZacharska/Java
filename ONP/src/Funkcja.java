import java.util.ArrayList;

import Narzedzia.ToManyArgsException;
import Narzedzia.Wyj¹tekONP;

public abstract class Funkcja extends Symbol implements Funkcyjny{
	
	protected int assigned;
	protected int ar;	
	double argumenty[]; 
	
	public Funkcja(int ar){
		this.ar = ar;
		assigned = 0;
		argumenty = new double[ar];
	}	
	
	@Override
	public int arnosc() {
		return ar;
	}

	@Override
	public int brakujaceArgumenty() {
		return ar - assigned;
	}

	@Override
	public void dodajArgument(double arg) throws Wyj¹tekONP {
		if(ar == assigned){
			throw new ToManyArgsException();
		}
		argumenty[assigned] = arg;
		assigned ++;
		
	}
}
