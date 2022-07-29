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

import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
import eg.edu.guc.yugioh.exceptions.MultipleMonsterAdditionException;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;
import eg.edu.guc.yugioh.gui.GUI;

@SuppressWarnings("serial")
public class MonsterButton2 extends JButton implements MouseListener {
	JFrame x;
	MonsterCard monsterCard;
	JOptionPane monsterButtonOption1;
	JOptionPane monsterButtonOption2;
	JOptionPane monsterButtonOption3;
	
	public MonsterButton2(MonsterCard monsterCard){
		this.monsterCard=monsterCard;
	}

	public MonsterCard getMonsterCard() {
		return monsterCard;
	}

	public void setMonsterCard(MonsterCard monsterCard) {
		this.monsterCard = monsterCard;
	}

	public static Object [] arrayofMomsters(ArrayList<MonsterCard> monsters){
		Object [] temp =new Object[monsters.size()+1];
		for(int i=0;i<monsters.size();i++){
			temp[i]=monsters.get(i).getName();
			
		}
		return temp;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		monsterButtonOption1=new JOptionPane();
		monsterButtonOption2=new JOptionPane();
		monsterButtonOption3=new JOptionPane();
		if(e.getClickCount()==2){
		if(GUI.getStartFrame().getPlayer2().equals(GUI.getGameBoard().getActivePlayer())){
			if(monsterCard.getMode().equals(Mode.ATTACK)){
				Object [] options1={"Declare Attack", "Change Mode"};
				String x=(String) JOptionPane.showInputDialog(null, "Choose Action","Monster Options",2,null,options1,"Declare Attaack");
				monsterButtonOption1.setVisible(true);
				if(x.equals("Declare Attack")){
					if(GUI.getStartFrame().getPlayer1().getField().getMonstersArea().isEmpty()){
						try{
						GUI.getGameBoard().getActivePlayer().declareAttack(this.monsterCard);}
						catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
							new JOptionPane();
							JOptionPane.showMessageDialog(null, p.getMessage());

							
						}
					}
					else{
						//	=GUI.getStartFrame().getPlayer1().getField().getMonstersArea()
						Object [] hisMonsterArea=arrayofMomsters(GUI.getStartFrame().getPlayer1().getField().getMonstersArea());
						String selected=(String) JOptionPane.showInputDialog(null, "Choose Monster from opponents field","Attack options",GUI.getStartFrame().getPlayer1().getField().getMonstersArea().size(),null,hisMonsterArea,null);
						monsterButtonOption2.setVisible(true);
						MonsterCard hisCard=new MonsterCard(selected,null,0,0,0);
						for(int i=0;i<GUI.getStartFrame().getPlayer1().getField().getMonstersArea().size();i++){
							if(hisCard.getName().equals(GUI.getStartFrame().getPlayer1().getField().getMonstersArea().get(i).getName())){
								hisCard=GUI.getStartFrame().getPlayer1().getField().getMonstersArea().get(i);
								
								break;	
							}
							
						}
						try{
						GUI.getGameBoard().getActivePlayer().declareAttack(monsterCard, hisCard);}
						catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
							new JOptionPane();
							JOptionPane.showMessageDialog(null, p.getMessage());

							
						}
					
					
					}
				}
				else{if(x.equals("Change Mode")){
					try{
					GUI.getGameBoard().getActivePlayer().switchMonsterMode(monsterCard);
					monsterCard.setHidden(false);
					}
					catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
						new JOptionPane();
						JOptionPane.showMessageDialog(null, p.getMessage());

						
					}
				}
				}
				
				
			}
			else{if(monsterCard.getMode().equals(Mode.DEFENSE)){
				Object [] options1={"Change Mode"};
				String x=(String) JOptionPane.showInputDialog(null, "Choose Action","Card Options",1,null,options1," Change Mode");
				monsterButtonOption3.setVisible(true);
				if(x.equals("Change Mode") ){
					try{
					GUI.getGameBoard().getActivePlayer().switchMonsterMode(monsterCard);}
					catch(DefenseMonsterAttackException | MonsterMultipleAttackException | MultipleMonsterAdditionException | NoMonsterSpaceException | NoSpellSpaceException | WrongPhaseException p){
						new JOptionPane();
						JOptionPane.showMessageDialog(null, p.getMessage());

						
					}
				}
				
				
				
			}
				
			}
			
			
			
			
		}
		
		
	//	String x=(String) monsterOption1.showInputDialog(null, "Choose Action","Spell options",2,null,options1,"Activate spell");
//		handButtonOption1.setVisible(true);
		
		GUI.Update();
	
		// TODO Auto-generated method stub
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(monsterCard!=null&&GUI.getStartFrame().getPlayer2().equals(GUI.getGameBoard().getActivePlayer()))
		GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().getCardInfo().setText("<html>"+"Name: "+monsterCard.getName()+"<br>"+"ATT: "+monsterCard.getAttackPoints()+"DFF: "+monsterCard.getDefensePoints()+" LVL: "+monsterCard.getLevel()+"</html>");
		if(monsterCard!=null&& GUI.getStartFrame().getPlayer1().equals(GUI.getGameBoard().getActivePlayer())&&!monsterCard.isHidden())
			GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().getCardInfo().setText("<html>"+"Name: "+monsterCard.getName()+"<br>"+"ATT: "+monsterCard.getAttackPoints()+"DFF: "+monsterCard.getDefensePoints()+" LVL: "+monsterCard.getLevel()+"</html>") ;}

@Override
public void mouseExited(MouseEvent e) {
	GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().getCardInfo().setText(null);
	// TODO Auto-generated method stub
	
}

	@Override
	public void mousePressed(MouseEvent e) {
		if(!monsterCard.equals(null)&&(GUI.getStartFrame().getPlayer2().equals(GUI.getGameBoard().getActivePlayer())||(GUI.getStartFrame().getPlayer1().equals(GUI.getGameBoard().getActivePlayer())&& !getMonsterCard().isHidden()))){
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
			
			
			img=ImageIO.read(new File(monsterCard.getName()+".png"));
			
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