package eg.edu.guc.yugioh.gui;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.listeners.EndPhaseButton1;
import eg.edu.guc.yugioh.listeners.EndTurnButton1;

@SuppressWarnings("serial")
public class InfoPanel1 extends JPanel  {
	JLabel cardInfo;
	JLabel turn;
	JLabel phase;
	JLabel playerName;
	JLabel lifePoints;
	EndTurnButton1 endTurn;
	EndPhaseButton1 endPhase;
	public InfoPanel1(){
	 cardInfo=new JLabel();
	 cardInfo.setText("cardInfo");
	 cardInfo.setFont(new Font("Aerial",Font.ITALIC,10));
	 turn=new JLabel();
	 turn.setText("turn");
	 turn.setFont(new Font("Aerial",Font.ITALIC,15));
	 phase=new JLabel();
	 phase.setFont(new Font("Aerial",Font.ITALIC,15));
	 phase.setText("phase");
	
	 playerName=new JLabel();
	 playerName.setFont(new Font("Aerial",Font.ITALIC,15));
	 playerName.setText("player name");
	 lifePoints=new JLabel();
	 lifePoints.setText("life points");
	 lifePoints.setFont(new Font("Aerial",Font.ITALIC,20));
	 endTurn=new EndTurnButton1();
	 endTurn.setFont(new Font("Aerial",Font.ITALIC,15));
	 endTurn.setText("END TURN");
	 endTurn.addActionListener(new EndTurnButton1());
	
	 
	 endPhase=new EndPhaseButton1();
	 endPhase.setFont(new Font("Aerial",Font.ITALIC,15));
	 endPhase.addActionListener(new EndPhaseButton1());
	 endPhase.setText("END PHASE");
	 
	 this.setLayout(new GridLayout(7, 1));
	 this.add(cardInfo);
	 this.add(turn);
	 this.add(phase);
	 this.add(playerName);
	 this.add(lifePoints);
	 this.add(endTurn);
	 this.add(endPhase);
	 
	 
	 
	 
	}
	
	public JLabel getCardInfo() {
		return cardInfo;
	}
	public void setCardInfo(JLabel cardInfo) {
		this.cardInfo = cardInfo;
	}
	public JLabel getTurn() {
		return turn;
	}
	public void setTurn(JLabel turn) {
		this.turn = turn;
	}
	public JLabel getPhase() {
		return phase;
	}
	
	public JLabel getPlayerName() {
		return playerName;
	}
	public void setPlayerName(JLabel playerName) {
		this.playerName = playerName;
	}
	public JLabel getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(JLabel lifePoints) {
		this.lifePoints = lifePoints;
	}
	public JButton getEndTurn() {
		return endTurn;
	}
	public void setEndTurn(EndTurnButton1 endTurn) {
		this.endTurn = endTurn;
	}
	public JButton getEndPhase() {
		return endPhase;
	}
	public void setEndPhase(EndPhaseButton1 endPhase) {
		this.endPhase = endPhase;
	}
	public void setPhase(String x) {
		phase.setText(x);
	}
	
	

}
