package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class DarkHole extends  Raigeki{

	public DarkHole(String name, String description) {
		super( name,  description);
		// TODO Auto-generated constructor stub
	}
public void action(MonsterCard monster){
	super.action(monster);
	ArrayList <MonsterCard > x =new ArrayList <MonsterCard >();
	for(int i=0;i<getBoard().getActivePlayer().getField().getMonstersArea().size();i++){
		x.add(getBoard().getActivePlayer().getField().getMonstersArea().get(i));
		
		
	}

	
	getBoard().getActivePlayer().getField().removeMonsterToGraveyard(x);
	
	}
}
