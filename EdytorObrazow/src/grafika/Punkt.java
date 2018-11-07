package grafika;
import java.awt.Graphics;

public class Punkt{
	private int x; //wspolrzedna pierwsza 
	private int y; //wspolrzedna druga
	
	public Punkt(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Punkt))
			return false;
		Punkt p = (Punkt)obj;
		return x == p.x && y == p.y;
	}
	
	public Punkt affineTransformation(int offsetX, int offsetY, int scale)
	{
		return new Punkt((x - offsetX) / scale, (y - offsetY) / scale);
	}
	
	@Override
	public String toString()
	{
		return String.format("(%d,%d)", x, y);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y =y;
	}

	
}
