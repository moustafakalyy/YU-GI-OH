package eg.edu.guc.yugioh.cards;

public class MonsterCard extends Card {
	 private int level;
	 private int defensePoints;
	private int attackPoints;
	private  Mode mode;
	private int attacks;
	private int switchingMode;
	 public int getSwitchingMode() {
		return switchingMode;
	}
	public void setSwitchingMode(int switchingMode) {
		this.switchingMode = switchingMode;
	}
	public MonsterCard(String name, String description, int level, int attack, int defence){
		 super(name,description);
		  this.level =level;
		 this.attackPoints=attack;
		 this.defensePoints=defence;
		 this.mode=Mode.DEFENSE;
		  attacks=0;
		  switchingMode=0;
	 }
	public int getDefensePoints() {
		return defensePoints;
	}
	public int getAttacks() {
		return attacks;
	}
	public void setAttacks(int attacks) {
		this.attacks = attacks;
	}
	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}
	public int getAttackPoints()  {
		return attackPoints;
	}
	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}
	public Mode getMode() {
		return mode;
	}
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	public int getLevel() {
		return level;
	}
	public void action(MonsterCard monster){
		//if(this.getMode().equals(Mode.DEFENSE)){
			//this.setMode(Mode.ATTACK);
			//this.setHidden(false);
			if(monster.getMode().equals(Mode.ATTACK)){
				if(this.getAttackPoints()>monster.getAttackPoints()){
					Card.getBoard().getOpponentPlayer().setLifePoints(Card.getBoard().getOpponentPlayer().getLifePoints()-(this.getAttackPoints()-monster.getAttackPoints()));
					Card.getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
				}else{if(this.getAttackPoints()<monster.getAttackPoints()){
					Card.getBoard().getActivePlayer().setLifePoints(Card.getBoard().getActivePlayer().getLifePoints()-(monster.getAttackPoints()-this.getAttackPoints()));
				Card.getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
				}
			else{if(this.getAttackPoints()==monster.getAttackPoints()){
				Card.getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
				Card.getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
				
			}
			}}
				
			}
			else{
				if(monster.getMode().equals(Mode.DEFENSE)){
					if(this.getAttackPoints()>monster.getDefensePoints()){
						Card.getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
					}
					else{
						if(this.getAttackPoints()==monster.getDefensePoints()){
							
						}
						else{
							if(this.getAttackPoints()<monster.getDefensePoints()){
								Card.getBoard().getActivePlayer().setLifePoints(Card.getBoard().getActivePlayer().getLifePoints()-(monster.getDefensePoints()-this.getAttackPoints()));
							}
						}
					}
				}
			}
		if(Card.getBoard().getActivePlayer().getLifePoints()<=0){
			Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
		}else{
			if(Card.getBoard().getOpponentPlayer().getLifePoints()<=0){
				Card.getBoard().setWinner(Card.getBoard().getActivePlayer());
			}
		}
		
			//getBoard().getActivePlayer().getLifePoints();
			//getBoard().getOpponentPlayer().getLifePoints();
			
	}
		
	
	public void action(){
		if(Card.getBoard().getOpponentPlayer().getField().getMonstersArea().size()==0){
		Card.getBoard().getOpponentPlayer().setLifePoints(Card.getBoard().getOpponentPlayer().getLifePoints()-this.getAttackPoints());
		if(Card.getBoard().getActivePlayer().getLifePoints()<=0){
			Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
		}else{
			if(Card.getBoard().getOpponentPlayer().getLifePoints()<=0){
				Card.getBoard().setWinner(Card.getBoard().getActivePlayer());
			}
		}
		//getBoard().getActivePlayer().getLifePoints();
		//getBoard().getOpponentPlayer().getLifePoints();
	}
	} 
	}

