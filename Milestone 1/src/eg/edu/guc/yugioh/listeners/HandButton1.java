package eg.edu.guc.yugioh.listeners;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
import eg.edu.guc.yugioh.exceptions.MultipleMonsterAdditionException;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;
import eg.edu.guc.yugioh.gui.GUI;

@SuppressWarnings("serial")
public class HandButton1 extends JButton implements MouseListener{
Card card;
JFrame x;
JOptionPane handButtonOption1;
JOptionPane handButtonOption2;
JOptionPane handButtonOption3;
JOptionPane handButtonOption4;


public HandButton1(Card card){
	this.setOpaque(true);
	this.card=card;
}
public Card getCard() {
	return card;
}
public void setCard(Card card) {
	this.card = card;
}
public static Object [] arrayofMomsters(ArrayList<MonsterCard> monsters){
	Object [] temp =new Object[monsters.size()+1];
	for(int i=0;i<monsters.size();i++){
		temp[i]=monsters.get(i).getName();
		
	}
	return temp;
}
public static boolean willTakeMonster(SpellCard spell){
	
	switch (spell.getName()) {
	case "Card Destruction":return false;
	case "Change Of Heart":return true;		
	case "Dark Hole":return false;		
	case "Graceful Dice":return false;		
	case "Harpie's Feather Duster":return false;
		
	case "Heavy Storm":return false;
		
	case "Mage Power":return true;
		
	case "Monster Reborn":return false;	
	case "Pot of Greed":return false;		
	case "Raigeki":return false;
	default: return false;

		
}
}
public static Object [] arrayOfObjects(Object [] array,String monster){
	Object [] temp =new Object[array.length];
	for(int i=0;i<array.length;i++){
		if(((String)array[i]).equals(monster)){
			array[i]=null;
			break;
		}
	
	
	}
	
return temp;


	

	
	
}

@Override
public void mouseClicked(MouseEvent e) throws DefenseMonsterAttackException , MonsterMultipleAttackException , MultipleMonsterAdditionException , NoMonsterSpaceException , NoSpellSpaceException , WrongPhaseException {
	if(e.getClickCount()==2){
	if(GUI.getStartFrame().getPlayer1().equals(GUI.getGameBoard().getActivePlayer())){
		
		if(card instanceof SpellCard){
			handButtonOption1=new JOptionPane();
			handButtonOption2=new JOptionPane();
			handButtonOption3=new JOptionPane();
			handButtonOption4=new JOptionPane();
			Object [] options1={"Activate Spell", "Set Spell"};
			String x=(String) JOptionPane.showInputDialog(null, "Choose Action","Spell options",2,null,options1,"Activate Spell");
			handButtonOption1.setVisible(true);
			if(x.equals("Activate Spell")){
				if(willTakeMonster((SpellCard)this.card)){
					if(card.getName().equals("Change Of Heart")){
					Object [] monsterOptions=arrayofMomsters(GUI.getStartFrame().getPlayer2().getField().getMonstersArea());
					String y=(String) JOptionPane.showInputDialog(null, "Choose Monster from Opponet Field","Monster options",monsterOptions.length,null,monsterOptions,"");
					handButtonOption2.setVisible(true);
					MonsterCard hisCard=new MonsterCard(y,null,0,0,0);
					for(int i=0;i<GUI.getStartFrame().getPlayer2().getField().getMonstersArea().size();i++){
						if(hisCard.getName().equals(GUI.getStartFrame().getPlayer2().getField().getMonstersArea().get(i).getName())){
							hisCard=GUI.getStartFrame().getPlayer2().getField().getMonstersArea().get(i);
							break;
						}
					}
					try{
				GUI.getStartFrame().getPlayer1().activateSpell(((SpellCard)this.card), hisCard);}
					catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
						
						JOptionPane.showMessageDialog(null, p.getMessage());

						
					}
			
				}else{
					Object [] monsterOptions=arrayofMomsters(GUI.getStartFrame().getPlayer1().getField().getMonstersArea());
					String y=(String) JOptionPane.showInputDialog(null, "Choose Monster from Opponet Field","Monster options",monsterOptions.length,null,monsterOptions,"");
					handButtonOption2.setVisible(true);
					MonsterCard MyCard=new MonsterCard(y,null,0,0,0);
					for(int i=0;i<GUI.getStartFrame().getPlayer1().getField().getMonstersArea().size();i++){
						if(MyCard.getName().equals(GUI.getStartFrame().getPlayer1().getField().getMonstersArea().get(i).getName())){
							MyCard=GUI.getStartFrame().getPlayer1().getField().getMonstersArea().get(i);
							break;
						}
					}
					try{
				GUI.getStartFrame().getPlayer1().activateSpell(((SpellCard)this.card), MyCard);}
					catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
						
						JOptionPane.showMessageDialog(null, p.getMessage());

						
					}

					
				}
					}else{
						try{
						GUI.getStartFrame().getPlayer1().activateSpell(((SpellCard)this.card), null);}
						catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
							new JOptionPane();
							JOptionPane.showMessageDialog(null, p.getMessage());

							
						}
						GUI.Update();
					}
		}else{
			if(x.equals("Set Spell")){
				try{
				GUI.getStartFrame().getPlayer1().setSpell(((SpellCard)this.card));}
				catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
					new JOptionPane();
					JOptionPane.showMessageDialog(null, p.getMessage());

					
				}				
				//GUI.Update();

			}
		}
			
			}else{
				if(card instanceof MonsterCard){
					handButtonOption1=new JOptionPane();
					handButtonOption2=new JOptionPane();
					handButtonOption3=new JOptionPane();
					handButtonOption4=new JOptionPane();

					Object [] monsterOptions={"Summon Monster","Set Monster"};
					String x=(String) JOptionPane.showInputDialog(null, "Choose Action","Monster options",2,null,monsterOptions,"Summon Monster");
					handButtonOption1.setVisible(true);
					if(x.equals("Summon Monster")){
						if(((MonsterCard) this.card).getLevel()<=4){
							try{
							GUI.getStartFrame().getPlayer1().summonMonster((MonsterCard)this.card);}
							catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
								new JOptionPane();
								JOptionPane.showMessageDialog(null, p.getMessage());

								
							}
							
						}else{if(((MonsterCard) this.card).getLevel()>=5&&((MonsterCard) this.card).getLevel()<=8){
							Object [] howManySacrifices={"1","2"};
							String x1=(String) JOptionPane.showInputDialog(null, "Choose Number of sacrifices","Number of sacrifices",2,null,howManySacrifices,"1");
							handButtonOption4.setVisible(true);
							ArrayList<MonsterCard > sacrrifices=new ArrayList<MonsterCard >();
						//	=GUI.getStartFrame().getPlayer1().getField().getMonstersArea()
						Object [] myMonsterArea=arrayofMomsters(GUI.getStartFrame().getPlayer1().getField().getMonstersArea());
						String selected=(String) JOptionPane.showInputDialog(null, "Choose to sacrifice","Monster options",GUI.getStartFrame().getPlayer1().getField().getMonstersArea().size(),null,myMonsterArea,"Summon Monster");
						handButtonOption2.setVisible(true);
						MonsterCard myCard=new MonsterCard(selected,null,0,0,0);
						for(int i=0;i<GUI.getStartFrame().getPlayer1().getField().getMonstersArea().size();i++){
							if(myCard.getName().equals(GUI.getStartFrame().getPlayer1().getField().getMonstersArea().get(i).getName())){
								myCard=GUI.getStartFrame().getPlayer1().getField().getMonstersArea().get(i);
								sacrrifices.add(myCard);
								
								break;	
							}
							
						}
						if(((MonsterCard) this.card).getLevel()>=7&&((MonsterCard) this.card).getLevel()<=8&&x1=="2"){
							 //myMonsterArea=arrayofMomsters(GUI.getStartFrame().getPlayer1().getField().getMonstersArea());
							 @SuppressWarnings("unchecked")
							ArrayList<MonsterCard> a = (ArrayList<MonsterCard>) GUI.getStartFrame().getPlayer1().getField().getMonstersArea().clone();
							 a.remove(myCard);
						     
							Object[] secondSacrfice=arrayofMomsters(a);
							String selected2=(String) JOptionPane.showInputDialog(null, "Choose to sacrifice","Monster options",secondSacrfice.length,null,secondSacrfice,secondSacrfice[0]);
							handButtonOption3.setVisible(true);
							MonsterCard	myCard2=new MonsterCard(selected2,null,0,0,0);
							for(int i=0;i<a.size();i++){
								if(myCard2.getName().equals(a.get(i).getName())){
									myCard2=a.get(i);
									sacrrifices.add(myCard2);
									break;
									
								}
						
						}
						
						}
						try{
						GUI.getStartFrame().getPlayer1().summonMonster((MonsterCard) this.card, sacrrifices);}
						catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
							new JOptionPane();
							JOptionPane.showMessageDialog(null, p.getMessage());

							
						}

						}
						
						
						}
					
				}
			else{
				if(x.equals("Set Monster")){
					if(((MonsterCard) this.card).getLevel()<=4){
						try{
						GUI.getStartFrame().getPlayer1().setMonster((MonsterCard)this.card);}
						catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
							new JOptionPane();
							JOptionPane.showMessageDialog(null, p.getMessage());

							
						}
						
					}else{if(((MonsterCard) this.card).getLevel()>=5&&((MonsterCard) this.card).getLevel()<=8){
						Object [] howManySacrifices={"1","2"};
						String x1=(String) JOptionPane.showInputDialog(null, "Choose Number of sacrifices","Number of sacrifices",2,null,howManySacrifices,"1");
						handButtonOption4.setVisible(true);
						ArrayList<MonsterCard > sacrrifices=new ArrayList<MonsterCard >();
					//	=GUI.getStartFrame().getPlayer1().getField().getMonstersArea()
					Object [] myMonsterArea=arrayofMomsters(GUI.getStartFrame().getPlayer1().getField().getMonstersArea());
					String selected=(String) JOptionPane.showInputDialog(null, "Choose to sacrifice","Monster options",GUI.getStartFrame().getPlayer1().getField().getMonstersArea().size(),null,myMonsterArea,"Summon Monster");
					handButtonOption2.setVisible(true);
					MonsterCard myCard=new MonsterCard(selected,null,0,0,0);
					for(int i=0;i<GUI.getStartFrame().getPlayer1().getField().getMonstersArea().size();i++){
						if(myCard.getName().equals(GUI.getStartFrame().getPlayer1().getField().getMonstersArea().get(i).getName())){
							myCard=GUI.getStartFrame().getPlayer1().getField().getMonstersArea().get(i);
							sacrrifices.add(myCard);
							
							break;	
						}
						
					}
					if(((MonsterCard) this.card).getLevel()>=7&&((MonsterCard) this.card).getLevel()<=8&&x1=="2"){
						 //myMonsterArea=arrayofMomsters(GUI.getStartFrame().getPlayer1().getField().getMonstersArea());
						 @SuppressWarnings("unchecked")
						ArrayList<MonsterCard> a = (ArrayList<MonsterCard>) GUI.getStartFrame().getPlayer1().getField().getMonstersArea().clone();
						 a.remove(myCard);
					     
						Object[] secondSacrfice=arrayofMomsters(a);
						String selected2=(String) JOptionPane.showInputDialog(null, "Choose to sacrifice","Monster options",secondSacrfice.length,null,secondSacrfice,secondSacrfice[0]);
						handButtonOption3.setVisible(true);
						MonsterCard	myCard2=new MonsterCard(selected2,null,0,0,0);
						for(int i=0;i<a.size();i++){
							if(myCard2.getName().equals(a.get(i).getName())){
								myCard2=a.get(i);
								sacrrifices.add(myCard2);
								break;
								
							}
					
					}
					
					}
					try{
					GUI.getStartFrame().getPlayer1().setMonster((MonsterCard) this.card, sacrrifices);}
					catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
						new JOptionPane();
						JOptionPane.showMessageDialog(null, p.getMessage());

						
					}

					}
					
					
					}
				
			}
					
				}
			}

			
			}
		GUI.Update();
			}}
			
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	MonsterCard x = new MonsterCard(null,null,0,0,0); 
	
	 if(GUI.getStartFrame().getPlayer1().equals(GUI.getGameBoard().getActivePlayer())){
	if(card instanceof MonsterCard){
		 x=(MonsterCard)card;
	GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().getCardInfo().setText("<html>"+"Name: "+x.getName()+"<br>"+"ATT: "+x.getAttackPoints()+"DFF: "+x.getDefensePoints()+" LVL: "+x.getLevel()+"</html>");
	}
	else{if(card instanceof SpellCard ){
		GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().getCardInfo().setText("Name: "+card.getName());
		 
		
	}
		
	}}
}

@Override
public void mouseExited(MouseEvent e) {
	GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().getCardInfo().setText(null);
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	if(GUI.getStartFrame().getPlayer1().equals(GUI.getGameBoard().getActivePlayer())){
	 x=new JFrame();
	x.setLayout(new BorderLayout());
	JLabel label=new JLabel();
	label.setLayout(new BorderLayout());
	x.setVisible(true);
	x.setSize(250, 460);
	label.setSize(250,450);
	x.add(label);
	
	BufferedImage img =new BufferedImage(250, 450, BufferedImage.TYPE_INT_RGB);
	try {
		
		
		img=ImageIO.read(new File(card.getName()+".png"));
		
		}
	catch (IOException y) {
		// TODO Auto-generated catch block
		y.printStackTrace();
	}
	
		
	ImageIcon image=new ImageIcon(FitImage(img, 250,450));
	label.setIcon(image);
	this.validate();}
}

@Override
public void mouseReleased(MouseEvent e) {
		x.setVisible(true);
	x.dispose();
	
}
public static  BufferedImage FitImage( BufferedImage img ,int w,int h){
	BufferedImage img1=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	Graphics2D g= img1.createGraphics();
	g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	g.drawImage(img, 0, 0, w, h , null );
	
	
	
	return img1;
	
		
	
}



}