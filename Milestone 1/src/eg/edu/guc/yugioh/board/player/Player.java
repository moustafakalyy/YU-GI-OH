package eg.edu.guc.yugioh.board.player;

import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
import eg.edu.guc.yugioh.exceptions.MultipleMonsterAdditionException;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;
public class Player implements Duelist {
	private String name;
	private int lifePoints;
	private Field field ;
	private int summons=0;
	
	 public Player(String name)throws IOException, UnknownCardTypeException, UnknownSpellCardException, MissingFieldException, EmptyFieldException{
		 this.name=name;
		 lifePoints=8000;
		 field=  new Field() ;
	 }
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	public String getName() {
		return name;
	}
	public Field getField() {
		return field;
	}
 public boolean summonMonster(MonsterCard monster){
	if(summons<1){
	 if(Card.getBoard().getWinner()==null){
	 if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN1)||Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN2)){
	 if(Card.getBoard().getActivePlayer()==this){
		 if(Card.getBoard().getActivePlayer().getField().getHand().contains(monster) ){
		 if(getField().getMonstersArea().size()<5){
	 getField().addMonsterToField( monster, Mode.ATTACK,  false);
	 summons++;
	 return true ;
	}else{
		throw new NoMonsterSpaceException();
	}
		 }
	 }
	 }
	 else{
		throw new WrongPhaseException();
	 }
	 }
 }else{
		throw new MultipleMonsterAdditionException();
	}
	
	 return false;
 }
		  
	 public boolean summonMonster(MonsterCard monster, ArrayList<MonsterCard> sacrifices){
		 if(getField().getMonstersArea().size()<5){

		 if(summons<1){
		 if(Card.getBoard().getWinner()==null){
			 
		 if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN1)||Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN2)){
		 if(Card.getBoard().getActivePlayer().equals(this)){
		 if(Card.getBoard().getActivePlayer().getField().getHand().contains(monster) ){
			 if(monster.getLevel()<=4&&sacrifices.size()==0){
			 getField().addMonsterToField( monster, Mode.ATTACK,sacrifices);
			 summons++;
			 	 return true;
		 }
		 else{
			 if(monster.getLevel()>=5&&monster.getLevel()<=6&&sacrifices.size()==1){
				 
				 getField().addMonsterToField(monster, Mode.ATTACK, sacrifices);
				 summons++;
					return true;
					  } 
				 
				 
		 else{
		     if(monster.getLevel()>=7&&monster.getLevel()<=8&&sacrifices.size()==2){
		    	 getField().addMonsterToField( monster, Mode.ATTACK, sacrifices);
		    	 summons++;
					 return true;
				 }
			 }
		 }
		 } 
		 }
		 }
		 else{
				throw new WrongPhaseException();
			 }
		 }
	 }else{
			throw new MultipleMonsterAdditionException();
		}
	 }else{
			throw new NoMonsterSpaceException();
		}
		 return false;
	
		 }
		  
	 public int getSummons() {
		return summons;
	}
	
public void setSummons(int summons) {
		this.summons = summons;
	}
	
public boolean setMonster(MonsterCard monster){
		 
		if(summons<1){
		 if(Card.getBoard().getWinner()==null){
		 if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN1)||Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN2)){
		 if(Card.getBoard().getActivePlayer().equals(this)){
		 if(getField().getMonstersArea().size()<5){
			 getField().addMonsterToField( monster, Mode.DEFENSE ,  true);
			 summons++;
			 return true ;
			}else{
				throw new NoMonsterSpaceException();
			}
		 }
		 }
		 else{
				throw new WrongPhaseException();
			 }
		 }
	}
		else{
			throw new MultipleMonsterAdditionException();
		}
		
		 
		 return false;
		 
	 }
		 
	 public boolean setMonster(MonsterCard monster, ArrayList<MonsterCard> sacrifices){
		 if(getField().getMonstersArea().size()<5){
		 if(summons<1){
		 if(Card.getBoard().getWinner()==null){
		 if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN1)||Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN2)){
		 if(Card.getBoard().getActivePlayer().equals(this)){
		 if(monster.getLevel()<=4&&sacrifices.size()==0){
			 getField().addMonsterToField( monster, Mode.DEFENSE ,sacrifices);
			 summons++;
			 	 return true;
		 }
		 else{
			 if(monster.getLevel()>=5&&monster.getLevel()<=6&&sacrifices.size()==1){
				 
				 getField().addMonsterToField(monster, Mode.DEFENSE, sacrifices);
				 summons++;
					return true;
					  } 
				 
				 
		 else{
		     if(monster.getLevel()>=7&&monster.getLevel()<=8&&sacrifices.size()==2){
		    	 getField().addMonsterToField( monster, Mode.DEFENSE, sacrifices);
		    	 summons++;
					 return true;
				 }
			 }
		 }}
		 }
		 else{
				throw new WrongPhaseException();
			 }
		 }
		 }
	 
		 else{
				throw new MultipleMonsterAdditionException();
			}}
		 else{
				throw new NoMonsterSpaceException();
			}
		 
		 return false;
		 
	 }
		 
	 public boolean setSpell(SpellCard spell){
		 if(Card.getBoard().getWinner()==null){
		 if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN1)||Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN2)){
		 if(Card.getBoard().getActivePlayer().equals(this)){
			 if(Card.getBoard().getActivePlayer().getField().getHand().contains(spell) ){
		 if(getField().getSpellArea().size()<5){
			getField().addSpellToField(spell,null, true);
			return true;
		 }else{
				throw new NoSpellSpaceException();

		 }
		 }
		 }
		 }
		 else{
				throw new WrongPhaseException();
			 }
		 }
		 return false;
	 }
		 
	 public boolean activateSpell(SpellCard spell, MonsterCard monster){
		 if(Card.getBoard().getWinner()==null){
		 if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN1)||Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN2)){

		 if(this.equals(Card.getBoard().getActivePlayer())){
		 if(spell.getLocation().equals(Location.HAND )&& setSpell(spell)){
			 getField().activateSetSpell(spell,monster);
			 return true;
			 }
		 if(spell.getLocation()==Location.FIELD){
			 getField().activateSetSpell(spell,monster);
			 return true;
		 
			 
		 }}
		 }
		 else{
				throw new WrongPhaseException();
			 }
		 }
	 return false;
	 }
	
	 public boolean declareAttack(MonsterCard activeMonster, MonsterCard opponentMonster){
		 if(activeMonster.getMode()==Mode.ATTACK){
		 if(Card.getBoard().getWinner()==null){
			 if(activeMonster.getAttacks()==0){
		 if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE)){
		 if(Card.getBoard().getActivePlayer().equals(this)){
			activeMonster.setHidden(false);
			
			 activeMonster.action(opponentMonster);
			 activeMonster.setAttacks(1);
		return true;
		 }
		 }
		 else{
				throw new WrongPhaseException();
			 }
		 }
			 else{
					throw new MonsterMultipleAttackException();
				 }
			 
		 }}
		 else{
				throw new DefenseMonsterAttackException();
			 }
		 return false;
	 }
		 
	 public boolean declareAttack(MonsterCard activeMonster){
		if(activeMonster.getMode()==Mode.ATTACK){
		 if(Card.getBoard().getWinner()==null){
			 if(activeMonster.getAttacks()==0){
		 
		 if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE)){
		 if(Card.getBoard().getActivePlayer().equals(this)){
			 activeMonster.setHidden(false);
				
				activeMonster.action();
				 activeMonster.setAttacks(1);
		return true;
		 }
		 }
		 else{
				throw new WrongPhaseException();
			 }
		 }
			 else{
					throw new MonsterMultipleAttackException();
				 }
		}}
		else{
			throw new DefenseMonsterAttackException();
		 }
		 return false;
	 }
		 
	 public void addCardToHand(){
		 if(Card.getBoard().getWinner()==null){
		 if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN1)){

		 if(Card.getBoard().getActivePlayer().equals(this)){
		 getField().addCardToHand();}
		 }
		 else{
				throw new WrongPhaseException();
			 }
		 }
		 }
		 
	 public void addNCardsToHand(int n){
		 if(Card.getBoard().getActivePlayer().equals(this)){
		 if(Card.getBoard().getWinner()==null){
			 if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN1)||Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN2)){
		 if(Card.getBoard().getActivePlayer().getField().getDeck().getDeck().size()<=n){
			 n=Card.getBoard().getActivePlayer().getField().getDeck().getDeck().size();
			 
				 getField().addNCardsToHand(n);
				 Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
				
		 }
		 }
			 else{
					throw new WrongPhaseException();
				 }
		 }
		 }
		 
		 if(Card.getBoard().getWinner()==null){
		 if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN1)){

		 if(Card.getBoard().getActivePlayer().equals(this)){
			 
		getField().addNCardsToHand(n);
		//for(int i=0;i<Card.getBoard().getActivePlayer().getField().getDeck().getDeck().size();i++){
			//Card.getBoard().getActivePlayer().getField().getDeck().getDeck().get(i).setLocation(Location.DECK);
	//	}/
		}
		 }
		 else{
				throw new WrongPhaseException();
			 }
		 }
		 }
		 
	 public void endPhase() {
		 if(Card.getBoard().getWinner()==null){
		 if(getField().getPhase().equals(Phase.MAIN1)){
			 getField().setPhase(Phase.BATTLE);
		 }
		 else{
			 if(getField().getPhase().equals(Phase.BATTLE)){
				 getField().setPhase(Phase.MAIN2);
			 }
			 else{
				 if(getField().getPhase().equals(Phase.MAIN2)){
					 Card.getBoard().nextPlayer();
				 }
			 }
		 }
		 }
}
		 
	 public boolean endTurn(){
		 if(Card.getBoard().getWinner()==null){
		 if(Card.getBoard().getActivePlayer().equals(this)){
			 Card.getBoard().nextPlayer();
			 return true;
		}
		 }
		 return false;
		 
		
		
		 
	 }
		 
	 public boolean switchMonsterMode(MonsterCard monster){
		 
		 if(Card.getBoard().getWinner()==null&&monster.getSwitchingMode()==0){
		 if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN1)||Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.MAIN2)){

		 if(Card.getBoard().getActivePlayer().equals(this)){
		 if(monster.getMode().equals(Mode.ATTACK)&&monster.isHidden()== false&&monster.getLocation().equals(Location.FIELD)){
			 monster.setMode(Mode.DEFENSE);
			 monster.setSwitchingMode(1);
			 return true;
		 }
		 else{
			 if(monster.getMode().equals(Mode.DEFENSE)&&monster.isHidden()== true&&monster.getLocation().equals(Location.FIELD)){
				 monster.setHidden(false);
				 monster.setMode(Mode.ATTACK);
				 monster.setSwitchingMode(1);
				 return true;
				 
			 }
			 else{
				 if(monster.getMode().equals(Mode.DEFENSE)&&!monster.isHidden()== true&&monster.getLocation().equals(Location.FIELD)){
					 monster.setMode(Mode.ATTACK);
					 monster.setSwitchingMode(1);
					 return true;
				 }
			 }
			
			 }}
		 }
		 else{
				throw new WrongPhaseException();
			 }
		 }
	     
		 return false; 
	 }
	


}
