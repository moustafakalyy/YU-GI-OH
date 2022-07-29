package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.gui.GUI;

@SuppressWarnings("serial")
public class EndPhaseButton2 extends JButton implements ActionListener {
	public EndPhaseButton2(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(GUI.getStartFrame().getPlayer2().equals(GUI.getGameBoard().getActivePlayer())&&!GUI.getGameBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN2)){
		GUI.getGameBoard().getActivePlayer().endPhase();
	//	GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().setPhase(GUI.getGameBoard().getActivePlayer().getField().getPhase().name());
		 GUI.Update();
		}
		}
	}


