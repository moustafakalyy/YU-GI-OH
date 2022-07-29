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
import eg.edu.guc.yugioh.listeners.MonsterButton2;

@SuppressWarnings("serial")
public class MonsterAreaPanel2 extends JPanel {

	MonsterButton2 monsterButtons2[];

	public MonsterAreaPanel2(){
		
		this.setLayout(new GridLayout(1, 5));
		monsterButtons2=new MonsterButton2[5];
		this.setLayout(new GridLayout(1, 5));
	for(int i=0;i<monsterButtons2.length;i++){
		monsterButtons2[i]=new MonsterButton2(null);
		monsterButtons2[i].addMouseListener(new MonsterButton2(null));

		this.add(monsterButtons2[i]);
	}
	
		
	}
	public void updateMonsterAreaPanel2(ArrayList <MonsterCard> monsters ){
		this.removeAll();
		monsterButtons2=new MonsterButton2[5];
		for(int i=0;i<monsterButtons2.length;i++){
			
			if(i>=monsters.size()){
			
			MonsterButton2 monsterButton= new MonsterButton2(null);
			
			monsterButtons2[i]=monsterButton;
			monsterButtons2[i].setText(null);
			monsterButton.addMouseListener(new MonsterButton2(null));

			this.add(monsterButtons2[i]);
			}else{
				MonsterButton2 monsterButton= new MonsterButton2(monsters.get(i));
				
				monsterButtons2[i]=monsterButton;
				monsterButtons2[i].setText(monsters.get(i).getName());
				monsterButton.addMouseListener(new MonsterButton2(monsters.get(i)));

				this.add(monsterButtons2[i]);
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
				monsterButtons2[i].setIcon( x );
			}
			
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


