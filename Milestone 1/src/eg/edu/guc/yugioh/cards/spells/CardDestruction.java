package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class CardDestruction extends  SpellCard  {

	public CardDestruction(String name, String description) {
		super( name, description);
		// TODO Auto-generated constructor stub
	}
public void action(MonsterCard monster){
		int numberActive=getBoard().getActivePlayer().getField().getHand().size();
		int numberOpponent=getBoard().getOpponentPlayer().getField().getHand().size();
		for(int i=0;i<numberActive;i++){		
	  Card removedCard=	getBoard().getActivePlayer().getField().getHand().get(0);
	  removedCard.setLocation(Location.GRAVEYARD);
	  getBoard().getActivePlayer().getField().getGraveyard().add(removedCard);
	   	getBoard().getActivePlayer().getField().getHand().remove(0);
		}
		for(int i=0;i<numberOpponent;i++){		
			  Card removedCard=	getBoard().getOpponentPlayer().getField().getHand().get(0);
			  removedCard.setLocation(Location.GRAVEYARD);
			  getBoard().getOpponentPlayer().getField().getGraveyard().add(removedCard);
			   	getBoard().getOpponentPlayer().getField().getHand().remove(0);
				}	
		getBoard().getActivePlayer().getField().addNCardsToHand(numberActive);
		getBoard().getOpponentPlayer().getField().addNCardsToHand(numberOpponent);
		
		
		
				
	}
	
 
}
