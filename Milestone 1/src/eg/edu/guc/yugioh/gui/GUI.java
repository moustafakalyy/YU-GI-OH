




package eg.edu.guc.yugioh.gui;

import java.io.IOException;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

public class GUI {
	private static StartFrame startFrame;
	private static GameFrame gameFrame;
	private static Board gameBoard; 
	private static EndFrame endFrame;
	public GUI() throws UnknownCardTypeException, UnknownSpellCardException, MissingFieldException, EmptyFieldException, IOException{
		gameBoard= new Board();

		startFrame=new StartFrame();
		startFrame.setVisible(true);
		gameFrame=new GameFrame();
		
		gameFrame.setVisible(false);
		endFrame=new EndFrame();
		endFrame.setVisible(false);
		
		
	}
	public static void main (String args []) throws UnknownCardTypeException, UnknownSpellCardException, MissingFieldException, EmptyFieldException, IOException{

     new GUI();
	}

	
	public static Board getGameBoard() {
		return gameBoard;
	}

	public static void setGameBoard(Board gameBoard) {
		GUI.gameBoard = gameBoard;
	}

	public static StartFrame getStartFrame() {
		return startFrame;
	}
	public static void setStartFrame(StartFrame startFrame) {
		GUI.startFrame = startFrame;
	}
	public static GameFrame getGameFrame() {
				return gameFrame;
	}
	public static void setGameFrame(GameFrame gameFrame) {
		GUI.gameFrame = gameFrame;
	}
	
	public static EndFrame getEndFrame() {
		return endFrame;
	}
	public static void setEndFrame(EndFrame endFrame) {
		GUI.endFrame = endFrame;
	}
	public static void Update(){
		
		GUI.getGameFrame().getPlayerPanel1().getFieldPanel1().getMonsterAreaPanel1().updateMonsterAreaPanel1(GUI.getStartFrame().getPlayer1().getField().getMonstersArea());
		
		GUI.getGameFrame().getPlayerPanel2().getFieldPanel2().getMonsterAreaPanel2().updateMonsterAreaPanel2(GUI.getStartFrame().getPlayer2().getField().getMonstersArea());
	
	GUI.getGameFrame().getPlayerPanel1().getFieldPanel1().getSpellAreaPanel1().updateSpellAreaPanel1(GUI.getStartFrame().getPlayer1().getField().getSpellArea());
	
		GUI.getGameFrame().getPlayerPanel2().getFieldPanel2().getSpellAreaPanel2().updateSpellAreaPanel2(GUI.getStartFrame().getPlayer2().getField().getSpellArea());
		GUI.getGameFrame().getPlayerPanel1().getEastPanel1().getDeckPanel1().updateDeckPanel1();
		GUI.getGameFrame().getPlayerPanel2().getEastPanel2().getDeckPanel2().updateDeckPanel2();
		GUI.getGameFrame().getPlayerPanel1().getEastPanel1().getGraveyardPanel1().updategraveYardPanel();
		GUI.getGameFrame().getPlayerPanel2().getEastPanel2().getGraveyardPanel2().updategraveYardPanel();
		GUI.getGameFrame().getPlayerPanel1().getFieldPanel1().getHandPanel1().BuildHandPanel(GUI.getStartFrame().getPlayer1().getField().getHand());
		GUI.getGameFrame().getPlayerPanel2().getFieldPanel2().getHandPanel2().BuildHandPanel(GUI.getStartFrame().getPlayer2().getField().getHand());
		GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().getLifePoints().setText(""+GUI.getStartFrame().getPlayer1().getLifePoints());
		GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().getLifePoints().setText(""+GUI.getStartFrame().getPlayer2().getLifePoints());
		GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().setPhase(GUI.getStartFrame().getPlayer1().getField().getPhase().name());
		GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().setPhase(GUI.getStartFrame().getPlayer2().getField().getPhase().name());
		if(!GUI.getStartFrame().getPlayer1().getField().getGraveyard().isEmpty())
		 GUI.getGameFrame().getPlayerPanel1().getEastPanel1().getGraveyardPanel1().updategraveYardPanel();
		if(!GUI.getStartFrame().getPlayer2().getField().getGraveyard().isEmpty())
		 GUI.getGameFrame().getPlayerPanel2().getEastPanel2().getGraveyardPanel2().getGyLabel().setText(""+ GUI.getStartFrame().getPlayer2().getField().getGraveyard().get(GUI.getStartFrame().getPlayer2().getField().getGraveyard().size()-1).getName());
		if(GUI.getGameBoard().getWinner()!=null){
			
			GUI.getEndFrame().getWinner().setText("       "+GUI.getGameBoard().getWinner().getName()+" is The Winner");
			GUI.getGameFrame().setVisible(false);
			GUI.getEndFrame().setVisible(true);
			
			}
		GUI.getGameFrame().validate();
	}
	

}
