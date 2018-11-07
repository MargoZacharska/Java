package grafika;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PaintPanel extends JPanel implements MouseMotionListener, MouseListener{

	Stack<Line> lineStack = new Stack<>();
	Stack<Punkt> pointStack = new Stack<>();
	BufferedImage img = null;
	Image img2;
	Punkt pTmp = null;
	int scale = 1;
	int offsetX = 0;
	int offsetY = 0;
	public Color currentColor;
	int x;
	int y;
	private String stringInfo;
	JLabel label;
	
	public PaintPanel(JLabel mousePosition) {
		//setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
		this.label = mousePosition;
		
		try {
		    img = ImageIO.read(new File("C:\\Users\\GosiaZ\\Desktop\\rozrywka\\zwiastuny\\IMG_20170815_203356.png"));
		    img2 = img;
		} catch (IOException e) {
		}
	}
	
	public void readImage(File file){
		try {
		    img = ImageIO.read(file);
		    img2 = img;
		    scale = 1;
		    offsetX= 0;
		    offsetY = 0;
		    lineStack.removeAllElements();
		    repaint();
		} catch (IOException e) {
		}
	}
	
	public void moveLeft()
	{
		if(offsetX + img.getWidth() * scale / 12 < 0)
			offsetX += img.getWidth() * scale / 12;
		else
			offsetX = 0;
		repaint();
	}
	public void moveRight()
	{
		
		offsetX -= img.getWidth() * scale / 12;
		repaint();
	}
	public void moveUp()
	{
		if(offsetY + img.getHeight() * scale / 12 < 0)
			offsetY += img.getHeight() * scale / 12;
		else
			offsetY = 0;
		repaint();
	}
	public void moveDown()
	{
		offsetY -= img.getHeight() * scale / 12;
		repaint();
	}
	public void scaleUp()
	{
		if(scale < 8)
		{
			scale++;
			//offsetX *= 1.0 * scale / (scale + 1);
			//offsetY *= 1.0 * scale / (scale + 1);
		}
		img2 =  img.getScaledInstance(img.getWidth() * scale,img.getHeight() * scale, BufferedImage.SCALE_DEFAULT);
		this.repaint();
	}
	public void scaleDown()
	{
		if(scale > 1){
			scale--;
		}
		img2 =  img.getScaledInstance(img.getWidth() * scale,img.getHeight() * scale, BufferedImage.SCALE_DEFAULT);
		this.repaint();
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img2, offsetX, offsetY, null);
		for (Line line : lineStack) {
			line.drawLine(g, offsetX, offsetY, scale);
		}
	}

	public void paintingPoint(MouseEvent e){
		Punkt pCurrent = new Punkt(e.getX(), e.getY());
		if(pTmp != null)
		{
			lineStack.push(new Line(pTmp.affineTransformation(offsetX, offsetY, scale), pCurrent.affineTransformation(offsetX, offsetY, scale), currentColor));
		}
		pTmp = pCurrent;
		
		this.repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		pTmp = new Punkt(e.getX(), e.getY());
		paintingPoint(e);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		pTmp = null;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		pTmp = null;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		paintingPoint(e);
		Punkt p = new Punkt(e.getX(), e.getY());
		x = e.getX();
		y = e.getY();
		
		stringInfo = "X: " + x + "Y: " + y;
		label.setText(stringInfo);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("X : " + e.getX());
	    //System.out.println("Y : " + e.getY());
		Punkt p = new Punkt(e.getX(), e.getY());
		x = e.getX();
		y = e.getY();
		
		
		stringInfo = "X: " + x + "Y: " + y;
		label.setText(stringInfo);
	}
	

	public String printPoint(){
		return stringInfo;
		
	}
	
}
