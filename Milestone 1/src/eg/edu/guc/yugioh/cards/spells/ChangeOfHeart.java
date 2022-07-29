package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class ChangeOfHeart extends  SpellCard{

	public ChangeOfHeart(String name, String description) {
		super( name, description);
		// TODO Auto-generated constructor stub
	}
public void action(MonsterCard monster){
	
	int numberOpponent= getBoard().getOpponentPlayer().getField().getMonstersArea().size();
	if(getBoard().getActivePlayer().getField().getMonstersArea().size()<5){
	for(int i=0;i<numberOpponent;i++){
		if(monster.equals(getBoard().getOpponentPlayer().getField().getMonstersArea().get(i))){
			getBoard().getOpponentPlayer().getField().getMonstersArea().remove(monster);
			
			getBoard().getActivePlayer().getField().getMonstersArea().add(monster);
			break;
			
		}
		
	}
	}
	}
}
