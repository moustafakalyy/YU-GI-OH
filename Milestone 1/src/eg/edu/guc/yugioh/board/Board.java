package eg.edu.guc.yugioh.board;

import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class Board{
	private  Player activePlayer;
	private Player opponentPlayer;
	 private Player winner;

public Board(){
	Card.setBoard(this);
}


public Player getActivePlayer() {
	return activePlayer;
}


public void setActivePlayer(Player activePlayer) {
	this.activePlayer = activePlayer;
}


public Player getOpponentPlayer() {
	return opponentPlayer;
}


public void setOpponentPlayer(Player opponentPlayer) {
	this.opponentPlayer = opponentPlayer;
}

public Player getWinner() {

	return winner;
}

public void setWinner(Player winner) {
	this.winner = winner;
}

public void whoStarts(Player p1, Player p2){

	int x1= (int)Math.round(Math.random() * 1);
	if(x1==1){
		activePlayer=p2;
		opponentPlayer=p1;
	}else{if(x1==0){
		activePlayer=p1;
		opponentPlayer=p2;}
	}


}

public void startGame(Player p1, Player p2){
	
	p1.getField().addNCardsToHand(5);
	p2.getField().addNCardsToHand(5);
	whoStarts(p1,p2);
	activePlayer.getField().addCardToHand();
	
	
	
}

public void nextPlayer(){
	Player temp;
	getActivePlayer().setSummons(0);
	
	temp=activePlayer;
	activePlayer=opponentPlayer;
	opponentPlayer=temp;
	
	activePlayer.getField().addCardToHand();
	for(int i =0;i<activePlayer.getField().getMonstersArea().size();i++){
		activePlayer.getField().getMonstersArea().get(i).setAttacks(0);
		activePlayer.getField().getMonstersArea().get(i).setSwitchingMode(0);
	}
	for(int i =0;i<opponentPlayer.getField().getMonstersArea().size();i++){
		opponentPlayer.getField().getMonstersArea().get(i).setAttacks(0);
		opponentPlayer.getField().getMonstersArea().get(i).setSwitchingMode(0);
	}
	activePlayer.getField().setPhase(Phase.MAIN1);  //// checked now
	opponentPlayer.getField().setPhase(Phase.MAIN1);     //// checked now
}
	
	
	
}



