package eg.edu.guc.yugioh.gui;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.listeners.EndPhaseButton2;
import eg.edu.guc.yugioh.listeners.EndTurnButton2;

@SuppressWarnings("serial")
public class InfoPanel2 extends JPanel    {
	JLabel cardInfo;
	JLabel turn;
	JLabel phase;
	JLabel playerName;
	JLabel lifePoints;
	EndTurnButton2 endTurn;
	EndPhaseButton2 endPhase;
	public InfoPanel2(){ cardInfo=new JLabel();
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
	 endTurn=new EndTurnButton2();
	 endTurn.setFont(new Font("Aerial",Font.ITALIC,15));
	 endTurn.setText("END TURN");
	 endTurn.addActionListener(new EndTurnButton2());
	
	 
	 endPhase=new EndPhaseButton2();
	 endPhase.setFont(new Font("Aerial",Font.ITALIC,15));
	 endPhase.addActionListener(new EndPhaseButton2());
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

	public EndTurnButton2 getEndTurn() {
		return endTurn;
	}

	public void setEndTurn(EndTurnButton2 endTurn) {
		this.endTurn = endTurn;
	}

	public JButton getEndPhase() {
		return endPhase;
	}

	public void setEndPhase(EndPhaseButton2 endPhase) {
		this.endPhase = endPhase;
	}
	public void setPhase(String x) {
		phase.setText(x);
	}


	
	
	

}
