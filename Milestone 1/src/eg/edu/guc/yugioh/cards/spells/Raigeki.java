package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class Raigeki extends  SpellCard {

	public Raigeki(String name, String description) {
		super( name,  description);
		// TODO Auto-generated constructor stub
	}
public void action(MonsterCard monster){
	ArrayList <MonsterCard > tmp =new ArrayList <MonsterCard >();
	for(int i=0;i<getBoard().getOpponentPlayer().getField().getMonstersArea().size();i++){
		tmp.add(getBoard().getOpponentPlayer().getField().getMonstersArea().get(i));
		
		
	}
	getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(tmp);//inherent
	}
}
