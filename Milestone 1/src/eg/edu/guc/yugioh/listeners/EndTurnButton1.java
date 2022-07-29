package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import eg.edu.guc.yugioh.gui.GUI;


@SuppressWarnings("serial")
public class EndTurnButton1 extends JButton implements ActionListener {
	public EndTurnButton1(){
		
	}
	public void actionPerformed(ActionEvent e) {
		if(GUI.getStartFrame().getPlayer1().equals(GUI.getGameBoard().getActivePlayer())){
		GUI.getGameBoard().getActivePlayer().endTurn();
		
		GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().getTurn().setText("not Your turn");
		GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().getTurn().setText("Your Turn");
		GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().getPhase().setText(GUI.getGameBoard().getActivePlayer().getField().getPhase().name());
		 GUI.Update();
		
		}
	}

}
