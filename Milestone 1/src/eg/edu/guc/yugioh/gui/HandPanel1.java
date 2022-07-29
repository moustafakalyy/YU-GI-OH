package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;








import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.listeners.HandButton1;

@SuppressWarnings("serial")
public class HandPanel1 extends JPanel {
	private ArrayList<HandButton1> handButtons1;
	//ArrayList<Card> cards;
	public HandPanel1(){
			this.setLayout(new GridLayout (1,10));
		
		
		
		
		
		
	}
	
	public void BuildHandPanel(ArrayList<Card> cards){
		this.removeAll();
		handButtons1=new ArrayList<HandButton1>();
		for(int i=0;i<cards.size();i++){
			HandButton1 handButton= new HandButton1(cards.get(i));
			handButton.setSize(new Dimension(200, 100));
			
			

			handButtons1.add(handButton);
			BufferedImage img=null ;
			try {
				if(GUI.getStartFrame().getPlayer1().equals(GUI.getGameBoard().getActivePlayer())){
					img = ImageIO.read(new File(cards.get(i).getName()+".png"));
				}
				else{
			    img = ImageIO.read(new File("Card Back H.png"));}
			   
			    
			} catch (IOException e) {
			    e.printStackTrace();
			}
			
			ImageIcon imageIcon = new ImageIcon(FitImage(img,200,100));
			handButton.setIcon(imageIcon);
			
			handButtons1.get(i).setText(cards.get(i).getName());
			handButton.addMouseListener(new HandButton1(cards.get(i)));

			this.add(handButtons1.get(i));
			this.validate();
			
		}
		
	}
	public static  BufferedImage FitImage( BufferedImage img ,int w,int h){
		BufferedImage img1=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g= img1.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(img, 0, 0, w, h , null );
		
		
		
		return img1;
		
			
		
	}
	

}
