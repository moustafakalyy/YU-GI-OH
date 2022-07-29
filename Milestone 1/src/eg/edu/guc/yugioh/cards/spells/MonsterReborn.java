package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class MonsterReborn extends  SpellCard {

	public MonsterReborn(String name, String description) {
		super( name,  description);
		// TODO Auto-generated constructor stub
	}
public void action(MonsterCard monster){
	MonsterCard strongest= new MonsterCard(null,null,0,0,0);
	int graveyardActiveSize=getBoard().getActivePlayer().getField().getGraveyard().size();
	int graveyardOpponentSize=getBoard().getOpponentPlayer().getField().getGraveyard().size();
	ArrayList<Card> graveYard=getBoard().getActivePlayer().getField().getGraveyard();

	int index=-1;
	for(int i=0;i<graveyardActiveSize;i++){
		
	if(graveYard.get(i)instanceof MonsterCard){
		MonsterCard temp=(MonsterCard)graveYard.get(i);
		if(temp.getAttackPoints()>strongest.getAttackPoints()){
			strongest=temp;
		index=i;
		}
		
		
	}
		}
	for(int j=0;j<graveyardOpponentSize;j++){
		if(getBoard().getOpponentPlayer().getField().getGraveyard().get(j)instanceof MonsterCard){
			MonsterCard temp=(MonsterCard)getBoard().getOpponentPlayer().getField().getGraveyard().get(j);
			if(temp.getAttackPoints()>strongest.getAttackPoints()){
				strongest=temp;
				graveYard=getBoard().getOpponentPlayer().getField().getGraveyard();
			index=j;
			}
	}
	
	}
	strongest.setLocation(Location.FIELD);
	if(strongest.getName()!=null){
	getBoard().getActivePlayer().getField().getMonstersArea().add(strongest);
	if(strongest.isHidden())
		strongest.setHidden(false);
    graveYard.remove(index);}

}
}

