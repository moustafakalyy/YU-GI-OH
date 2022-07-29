package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class HeavyStorm extends  HarpieFeatherDuster {

	public HeavyStorm(String name, String description) {
		super(name,description);
		// TODO Auto-generated constructor stub
	}
public void action(MonsterCard monster) {// how to inherit method?
	super.action(monster);
	ArrayList <SpellCard > tmp =new ArrayList <SpellCard >();
	for(int i=0;i<getBoard().getActivePlayer().getField().getSpellArea().size();i++){
		tmp.add(getBoard().getActivePlayer().getField().getSpellArea().get(i));
		
		
	}
	
	
	getBoard().getActivePlayer().getField().removeSpellToGraveyard(tmp);
	}
}
