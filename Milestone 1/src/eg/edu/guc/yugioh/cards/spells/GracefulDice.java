package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class GracefulDice extends  SpellCard {

	public GracefulDice(String name, String description) {
		super( name,  description);
		// TODO Auto-generated constructor stub
	}
public void action(MonsterCard monster){
		int randomIncrease=(int) Math.ceil(Math.random()*10);
	int monsterAreaSize=	getBoard().getActivePlayer().getField().getMonstersArea().size();
	int attackp;
			int defencep;
			for(int i=0;i<monsterAreaSize;i++){
		 attackp=	getBoard().getActivePlayer().getField().getMonstersArea().get(i).getAttackPoints();
		 defencep=	getBoard().getActivePlayer().getField().getMonstersArea().get(i).getDefensePoints();
			getBoard().getActivePlayer().getField().getMonstersArea().get(i).setAttackPoints(attackp+randomIncrease*100);
			getBoard().getActivePlayer().getField().getMonstersArea().get(i).setDefensePoints(defencep+randomIncrease*100);
		}
		
	}
}
