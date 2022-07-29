package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.gui.GUI;

@SuppressWarnings("serial")
public class EndPhaseButton1 extends JButton implements ActionListener{
	public EndPhaseButton1(){
		}

	public void actionPerformed(ActionEvent e) {
		
		if(GUI.getStartFrame().getPlayer1().equals(GUI.getGameBoard().getActivePlayer())&&!GUI.getGameBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN2)){
			
		GUI.getGameBoard().getActivePlayer().endPhase();}
		
		//GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().setPhase(GUI.getGameBoard().getActivePlayer().getField().getPhase().name());
		 
	
		GUI.Update();
	
	
	}
}
