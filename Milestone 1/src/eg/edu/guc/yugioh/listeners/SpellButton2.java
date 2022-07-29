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
public class SpellButton2 extends JButton implements MouseListener {
	JFrame x;
SpellCard spellcard;
JOptionPane spellButtonOption1;
JOptionPane spellButtonOption2;
JOptionPane spellButtonOption3;

	public SpellButton2(SpellCard spellcard){
		this.spellcard=spellcard;
	}

public SpellCard getSpellcard() {
		return spellcard;
	}

	public void setSpellcard(SpellCard spellcard) {
		this.spellcard = spellcard;
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

@Override
public void mouseClicked(MouseEvent e) {
	if(GUI.getStartFrame().getPlayer2().equals(GUI.getGameBoard().getActivePlayer())&&!spellcard.equals(null)){

		spellButtonOption1=new JOptionPane();
		spellButtonOption2=new JOptionPane();
		spellButtonOption3=new JOptionPane();
	Object [] options1={"Activate Spell" };
	String x=(String) JOptionPane.showInputDialog(null, "Choose Action","Spell options",1,null,options1,"Activate spell");
	spellButtonOption1.setVisible(true);
	if(x.equals("Activate Spell")){
		if(willTakeMonster(this.spellcard)){
			if(this.spellcard.getName().equals("Change Of Heart")){
			Object [] monsterOptions=arrayofMomsters(GUI.getStartFrame().getPlayer1().getField().getMonstersArea());
			String y=(String) JOptionPane.showInputDialog(null, "Choose Monster from Opponent's Field","Monster options",monsterOptions.length,null,monsterOptions,"");
			spellButtonOption2.setVisible(true);
			MonsterCard hisCard=new MonsterCard(y,null,0,0,0);
			for(int i=0;i<GUI.getStartFrame().getPlayer1().getField().getMonstersArea().size();i++){
				if(hisCard.getName().equals(GUI.getStartFrame().getPlayer1().getField().getMonstersArea().get(i).getName())){
					hisCard=GUI.getStartFrame().getPlayer1().getField().getMonstersArea().get(i);
					break;
				}
			}
			try{
		GUI.getStartFrame().getPlayer2().activateSpell((this.spellcard), hisCard);}
			catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
				new JOptionPane();
				JOptionPane.showMessageDialog(null, p.getMessage());

				
			}
	
		}else{
			Object [] monsterOptions=arrayofMomsters(GUI.getStartFrame().getPlayer2().getField().getMonstersArea());
			String y=(String) JOptionPane.showInputDialog(null, "Choose Monster from your Field","Monster options",monsterOptions.length,null,monsterOptions,"");
			spellButtonOption2.setVisible(true);
			MonsterCard MyCard=new MonsterCard(y,null,0,0,0);
			for(int i=0;i<GUI.getStartFrame().getPlayer2().getField().getMonstersArea().size();i++){
				if(MyCard.getName().equals(GUI.getStartFrame().getPlayer2().getField().getMonstersArea().get(i).getName())){
					MyCard=GUI.getStartFrame().getPlayer2().getField().getMonstersArea().get(i);
					break;
				}
			}
			try{
		GUI.getStartFrame().getPlayer2().activateSpell((this.spellcard), MyCard);}
			catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
				new JOptionPane();
				JOptionPane.showMessageDialog(null, p.getMessage());

				
			}
			
		}
			}else{
				try{
				GUI.getStartFrame().getPlayer2().activateSpell((this.spellcard), null);}
				catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
					new JOptionPane();
					JOptionPane.showMessageDialog(null, p.getMessage());

					
				}
				GUI.Update();
			}
}
GUI.Update();	
	}
	
	
		
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	if(spellcard!=null&&GUI.getStartFrame().getPlayer2().equals(GUI.getGameBoard().getActivePlayer()))
	GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().getCardInfo().setText("Name: "+spellcard.getName());

	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().getCardInfo().setText(null);
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	if(GUI.getStartFrame().getPlayer2().equals(GUI.getGameBoard().getActivePlayer())&&!spellcard.equals(null)){
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
		
		
		img=ImageIO.read(new File(spellcard.getName()+".png"));
		
		}
	catch (IOException y) {
		// TODO Auto-generated catch block
		y.printStackTrace();
	}
	
		
	ImageIcon image=new ImageIcon(FitImage(img, 250,450));
	label.setIcon(image);
	this.validate();
}}

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
	
		
	
}}