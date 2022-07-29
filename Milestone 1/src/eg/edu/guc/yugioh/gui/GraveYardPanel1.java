package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.cards.Card;

@SuppressWarnings("serial")
public class GraveYardPanel1 extends JPanel {
	 BufferedImage img ;
	JLabel GyLabel;
	ArrayList<Card> graveYard;
	public GraveYardPanel1(){
		 GyLabel =new JLabel();
		 
		 GyLabel.setLayout(new BorderLayout());
		 GyLabel.setText("GraveYard");
		 GyLabel.setHorizontalTextPosition(JLabel.CENTER);
		 GyLabel.setVerticalTextPosition(JLabel.CENTER);
		 GyLabel.setForeground(Color.WHITE);
		 this.setLayout(new BorderLayout());
		
		 this.add(GyLabel,BorderLayout.CENTER );
		 graveYard=new ArrayList<Card>();
	}
public void updategraveYardPanel(){
	this.removeAll();
	 
	 GyLabel.setText("GraveYard");
	 this.add(GyLabel);
	 graveYard=GUI.getStartFrame().getPlayer1().getField().getGraveyard();
	 if(!GUI.getStartFrame().getPlayer1().getField().getGraveyard().isEmpty())
		   img = new BufferedImage(100, 200, BufferedImage.TYPE_INT_RGB);
		try {if(!graveYard.isEmpty() ){
			
			img=ImageIO.read(new File(GUI.getStartFrame().getPlayer1().getField().getGraveyard().get(GUI.getStartFrame().getPlayer1().getField().getGraveyard().size()-1).getName()+".png"));
		}
		else{
			img=ImageIO.read(new File("Card Back H.png"));
		}
		}
		
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon x=new ImageIcon(FitImage(img, 100,200));
		GyLabel.setIcon( x );
	}
	 
public ArrayList<Card> getGraveYard() {
	return graveYard;
}
public void setGraveYard(ArrayList<Card> graveYard) {
	this.graveYard = graveYard;
}
public JLabel getGyLabel() {
	return GyLabel;
}
public void setGyLabel(JLabel gyLabel) {
	GyLabel = gyLabel;
}
public static  BufferedImage FitImage( BufferedImage img ,int w,int h){
BufferedImage img1=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
Graphics2D g= img1.createGraphics();
g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
g.drawImage(img, 0, 0, w, h , null );



return img1;

	

}

}
