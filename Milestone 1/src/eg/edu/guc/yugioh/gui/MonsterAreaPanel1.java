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

import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.listeners.MonsterButton1;

@SuppressWarnings("serial")
public class MonsterAreaPanel1 extends JPanel {
	
	MonsterButton1 monsterButtons1[];
	
	public MonsterAreaPanel1(){
		
		monsterButtons1=new MonsterButton1[5];
		this.setLayout(new GridLayout(1, 5));
	for(int i=0;i<monsterButtons1.length;i++){
		monsterButtons1[i]=new MonsterButton1(null);
		monsterButtons1[i].addMouseListener(new MonsterButton1(null));
		this.add(monsterButtons1[i]);
	}
	
	}
	public void updateMonsterAreaPanel1(ArrayList <MonsterCard> monsters ) {
		this.removeAll();
		monsterButtons1=new MonsterButton1[5];
		if(monsters!=null){
		for(int i=0;i<5;i++){
			if(i>=monsters.size()){
				
			
			MonsterButton1 monsterButton= new MonsterButton1(null);
			
			monsterButtons1[i]=monsterButton;
			monsterButtons1[i].setText(null);
			monsterButton.addMouseListener(new MonsterButton1(null));

			this.add(monsterButtons1[i]);
			}else{
				MonsterButton1 monsterButton= new MonsterButton1(monsters.get(i));
				
				monsterButtons1[i]=monsterButton;
				monsterButtons1[i].setText(monsters.get(i).getName());
				monsterButton.addMouseListener(new MonsterButton1(monsters.get(i)));

				this.add(monsterButtons1[i]);
				BufferedImage img =new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
				try {
					if(monsters.get(i).getMode().equals(Mode.ATTACK))
					img=ImageIO.read(new File(monsters.get(i).getName()+".png"));
					else{
						if(monsters.get(i).getMode().equals(Mode.DEFENSE)&&monsters.get(i).isHidden())
						img=ImageIO.read(new File("Card Back H .png"));
						else{
							if(monsters.get(i).getMode().equals(Mode.DEFENSE)&&!monsters.get(i).isHidden())
								img=ImageIO.read(new File(monsters.get(i).getName()+" H .png"));
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ImageIcon x=new ImageIcon(FitImage(img, 250,110));
				monsterButtons1[i].setIcon( x );
			}
			
		}}
	
	}
	public static  BufferedImage FitImage( BufferedImage img ,int w,int h){
		BufferedImage img1=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g= img1.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(img, 0, 0, w, h , null );
		
		
		
		return img1;
		
			
		
	}
}


