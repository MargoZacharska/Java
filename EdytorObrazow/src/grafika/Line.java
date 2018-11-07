package grafika;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line {
	protected Punkt poczatek, koniec;
	public Color kolor;
	public Line (Punkt pocz, Punkt kon, Color kol) { 
		this.poczatek = pocz;
		this.koniec = kon;
		this.kolor = kol;
	}
	
	public void updateEnd(Punkt p){
		koniec = p;
	}
	
	public void drawLine(Graphics g, int offsetX, int offsetY, int scale){
		g.setColor(kolor);
		((Graphics2D)g).setStroke(new BasicStroke(2));
		g.drawLine(poczatek.getX() * scale + offsetX, poczatek.getY() * scale + offsetY, koniec.getX() * scale + offsetX, koniec.getY() * scale + offsetY);
	}
}
