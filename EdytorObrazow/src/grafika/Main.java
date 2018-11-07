package grafika;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicArrowButton;

public class Main {

	public static void main(String[] args) {
		
		
		
		  JFrame mainFrame = new JFrame("Edytor obrazow");
	      mainFrame.setSize(1400,600);
	      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      mainFrame.setLayout(new BorderLayout());
	      
	      //String[] colornames = {"BLACK", "BLUE", "CYAN", "DARK GRAY", "GRAY", "GREEN", "LIGHT GRAY", "MAGENTA", "ORANGE", "PINK", "RED", "YELLOW"};
	      Color[] colors = {Color.black, Color.BLUE, Color.cyan, Color.DARK_GRAY, Color.gray, Color.GREEN, Color.LIGHT_GRAY, Color.magenta, Color.orange,
	    		  Color.pink, Color.red, Color.yellow};
	      JList<Color> colorList = new JList<>(colors);
	      
	      JToolBar toolBar = new JToolBar();
	      JPanel panel = new JPanel();
	      JLabel mousePosition = new JLabel();
	      PaintPanel panelMalarski = new PaintPanel(mousePosition);

	      JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	      scrollPane.setPreferredSize(new Dimension(20, 300));
	      
	      colorList.setVisibleRowCount(12);
	      colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      
	      mainFrame.add(colorList, BorderLayout.WEST);
	      mainFrame.add(new JScrollPane(panelMalarski), BorderLayout.CENTER);
	      
	      JButton scaleDown = new JButton();
	      try {
	    	    Image img = ImageIO.read(new File("C:\\Users\\GosiaZ\\Desktop\\rozrywka\\zwiastuny\\minus-round.png"));
	    	    Image img2 = img.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
	    	    scaleDown.setIcon(new ImageIcon(img2));
	    	  } catch (Exception ex) {
	    	    System.out.println(ex);
	    	  }
	      BasicArrowButton moveUp = new BasicArrowButton(BasicArrowButton.NORTH);
	      BasicArrowButton moveDown = new BasicArrowButton(SwingConstants.SOUTH);
	      BasicArrowButton moveRight = new BasicArrowButton(SwingConstants.EAST);
	      BasicArrowButton moveLeft = new BasicArrowButton(SwingConstants.WEST);
	      JButton scaleUp = new JButton();
	      try {
	    	    Image img = ImageIO.read(new File("C:\\Users\\GosiaZ\\Desktop\\rozrywka\\zwiastuny\\Science-Plus2-Math-icon.png"));
	    	    Image img2 = img.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
	    	    scaleUp.setIcon(new ImageIcon(img2));
	    	  } catch (Exception ex) {
	    	    System.out.println(ex);
	    	  }
	      //JButton moveDown = new JButton("v");
	      //JButton moveUp = new JButton("^");
	      //JButton moveRight = new JButton(">");
	      //JButton moveLeft = new JButton("<");
	      JButton filePicker = new JButton("Open file");
	      JButton colorChooser = new JButton("colors");
	      
	      //toolBar.add(arrowUP);
	      //toolBar.add(arrowDown);
	      //toolBar.add(arrowRight);
	      //toolBar.add(arrowLeft);
	      toolBar.add(scaleUp);
	      toolBar.add(scaleDown);
	      toolBar.add(moveDown);
	      toolBar.add(moveUp);
	      toolBar.add(moveLeft);
	      toolBar.add(moveRight);
	      toolBar.add(filePicker);
	      toolBar.add(colorChooser);
	      
	      mainFrame.add(scrollPane, BorderLayout.EAST);
	      mainFrame.add(toolBar, BorderLayout.PAGE_START);
	      mainFrame.add(panel, BorderLayout.SOUTH);
	   
	      panel.add(mousePosition, BorderLayout.EAST);
	      
	      
	      colorList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				panelMalarski.currentColor = colorList.getSelectedValue();
			}
		});
	      
	      colorChooser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JColorChooser colorChooser = new JColorChooser();
				Color color = colorChooser.showDialog(mainFrame, "42", Color.BLACK);
		        if(color != null)
		        {
		        	panelMalarski.currentColor = color;
		        	colorList.clearSelection();
		        }
			}
		});
	      
	      
	      filePicker.addActionListener(new ActionListener() {
	    	  
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fc = new JFileChooser();
				fc.setAcceptAllFileFilterUsed(false);
				fc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
				
				int returnVal = fc.showOpenDialog(fc);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            panelMalarski.readImage(file);
		        }
			}
		});
	      
	      scaleUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelMalarski.scaleUp();
			}
		});
	      
	      scaleDown.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelMalarski.scaleDown();
			}
		});
	      
	      moveDown.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelMalarski.moveDown();
			}
		});
	      
	      moveUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelMalarski.moveUp();
			}
		});
	      
	      moveRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelMalarski.moveRight();
			}
		});
	      
	      moveLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelMalarski.moveLeft();
			}
		});
	      
	      mainFrame.setVisible(true); 
	}

}
