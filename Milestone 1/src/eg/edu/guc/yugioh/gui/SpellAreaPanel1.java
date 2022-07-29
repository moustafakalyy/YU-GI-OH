package eg.edu.guc.yugioh.gui;

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

import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.listeners.SpellButton1;

@SuppressWarnings("serial")
public class SpellAreaPanel1 extends JPanel {
	
	SpellButton1 spellButtons1[];
	
	public SpellAreaPanel1(){
		
		spellButtons1=new SpellButton1[5];
		this.setLayout(new GridLayout(1, 5));
	for(int i=0;i<spellButtons1.length;i++){
		spellButtons1[i]=new SpellButton1(null);
		spellButtons1[i].addMouseListener(new SpellButton1(null));
		this.add(spellButtons1[i]);
	}
	
	}
	public void updateSpellAreaPanel1(ArrayList <SpellCard> spells ){
		this.removeAll();
		spellButtons1=new SpellButton1[5];
		for(int i=0;i<spellButtons1.length;i++){
			if(i>=spells.size()){
			SpellButton1 spellButton= new SpellButton1(null);
			
			spellButtons1[i]=spellButton;
			spellButtons1[i].setText(null);
			spellButton.addMouseListener(new SpellButton1(null));

			this.add(spellButtons1[i]);
			
			
	}else{
		SpellButton1 spellButton= new SpellButton1(spells.get(i));
		
		spellButtons1[i]=spellButton;
		spellButtons1[i].setText(spells.get(i).getName());
		spellButton.addMouseListener(new SpellButton1(spells.get(i)));

		this.add(spellButtons1[i]);
		BufferedImage img =new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
		try {if(GUI.getStartFrame().getPlayer1().equals(GUI.getGameBoard().getActivePlayer())){
			img=ImageIO.read(new File(spells.get(i).getName()+".png"));
		}
		else{
				img=ImageIO.read(new File("Card Back.png"));}
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon x=new ImageIcon(FitImage(img, 250,110));
		spellButtons1[i].setIcon( x );
	}
	
}}

public static  BufferedImage FitImage( BufferedImage img ,int w,int h){
BufferedImage img1=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
Graphics2D g= img1.createGraphics();
g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
g.drawImage(img, 0, 0, w, h , null );



return img1;

	

}
}


