package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class HarpieFeatherDuster extends  SpellCard {

	public HarpieFeatherDuster(String name, String description) {
		super( name,  description);
		// TODO Auto-generated constructor stub
	}
public void action(MonsterCard monster){
	
	ArrayList <SpellCard > tmp =new ArrayList <SpellCard >();
	for(int i=0;i<getBoard().getOpponentPlayer().getField().getSpellArea().size();i++){
		tmp.add(getBoard().getOpponentPlayer().getField().getSpellArea().get(i));
		
		
	}
	getBoard().getOpponentPlayer().getField().removeSpellToGraveyard(tmp);
	}
}
