package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class MagePower extends  SpellCard {

	public MagePower(String name, String description) {
		super( name,  description);
		// TODO Auto-generated constructor stub
	}
public void action(MonsterCard monster){
		int spellAreaSize=getBoard().getActivePlayer().getField().getSpellArea().size();
		int increasePoints=(spellAreaSize)*500;
		int indexOfMonster=getBoard().getActivePlayer().getField().getMonstersArea().indexOf(monster); // may be an error ???
		int attackp=	getBoard().getActivePlayer().getField().getMonstersArea().get(indexOfMonster).getAttackPoints();
		int defencep=	getBoard().getActivePlayer().getField().getMonstersArea().get(indexOfMonster).getDefensePoints();
		getBoard().getActivePlayer().getField().getMonstersArea().get(indexOfMonster).setDefensePoints(defencep+increasePoints);
		getBoard().getActivePlayer().getField().getMonstersArea().get(indexOfMonster).setAttackPoints(attackp+increasePoints);
	}
}
