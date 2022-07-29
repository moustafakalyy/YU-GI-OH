package eg.edu.guc.yugioh.board.player;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

import java.io.IOException;
public class Field {
	private Phase phase;
	private ArrayList<MonsterCard> monstersArea;
	private ArrayList<SpellCard> spellArea ;
	private Deck deck;
	private ArrayList<Card> hand;
	 private ArrayList<Card> graveyard;
	public Field()throws IOException, UnknownCardTypeException, UnknownSpellCardException, MissingFieldException, EmptyFieldException{
		 this.monstersArea=new ArrayList<MonsterCard>();//check
		this.spellArea = new ArrayList<SpellCard>();
		 this.deck =new Deck();
		this.hand=new ArrayList<Card>();
		this.graveyard= new ArrayList<Card>();
		phase=Phase.MAIN1;
	}
	
	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public ArrayList<MonsterCard> getMonstersArea() {
		return monstersArea;
	}

	public ArrayList<SpellCard> getSpellArea() {
		return spellArea;
	}

	public Deck getDeck() {
		return deck;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public ArrayList<Card> getGraveyard() {
		return graveyard;
	}

	public void addMonsterToField(MonsterCard monster, Mode m, boolean isHidden){
		      if(monstersArea.size()<5){
		    	  
				if(m.equals(Mode.ATTACK)&&!isHidden){
					monster.setMode(m);
					monster.setHidden(false);  } 
					else{
					monster.setHidden(true);
					monster.setMode(m);}
				monster.setLocation(Location.FIELD);
				monstersArea.add(monster);
				hand.remove(monster);
				
					}
		      else{
					throw new NoMonsterSpaceException();

		      }
	}
					
	public void addMonsterToField(MonsterCard monster, Mode mode, ArrayList<MonsterCard> sacrifices){
		
		     if(monster.getLevel()<=4&&sacrifices.size()==0){
			 addMonsterToField(monster,mode,true);
			 	 
		 }
		 else{
			 if(monster.getLevel()>=5&&monster.getLevel()<=6&&sacrifices.size()==1){
				 
					 removeMonsterToGraveyard(sacrifices);
					 addMonsterToField(monster,mode,true);
					
					  } 
				 
				 
		 else{
		     if(monster.getLevel()>=7&&monster.getLevel()<=8&&sacrifices.size()==2){
					 
						 removeMonsterToGraveyard(sacrifices);  
					 addMonsterToField(monster,mode,true); 
					 
				 }
			 }
		 }
	 }
	
    public void removeMonsterToGraveyard(MonsterCard monster){
		if(!monstersArea.isEmpty()&&monstersArea.contains(monster)){
			monstersArea.remove(monster);
			graveyard.add(monster);
				
				monster.setHidden(true);
				monster.setLocation(Location.GRAVEYARD);
				
			
			}}
	
	 public void removeMonsterToGraveyard(ArrayList<MonsterCard> monsters){
		 for(int i=0;i<monsters.size();i++){
			 removeMonsterToGraveyard(monsters.get(i));
			 
		 }
	 }
	
     public void addSpellToField(SpellCard action,MonsterCard monster, boolean hidden){
			spellArea.add(action);
			hand.remove(action);
			action.setHidden(hidden);
			 action.setLocation(Location.FIELD);
							if(!action.isHidden()){
								activateSetSpell( action,monster);
							}					
		 }
							 
	 public void activateSetSpell(SpellCard action, MonsterCard monster){
		if(spellArea.contains(action)){
		 
		 action.setHidden(false);
		 action.action(monster);
		
		 removeSpellToGraveyard(action);
		 } 
		}
	 
	 public void removeSpellToGraveyard(SpellCard spell){
		 if(!spellArea.isEmpty()){
		 spellArea.remove(spell);
		 spell.setLocation(Location.GRAVEYARD);
		 graveyard.add(spell);}}	
		 
	 
	 public void removeSpellToGraveyard(ArrayList<SpellCard> spells){
		 for(int i=0;i<spells.size();i++){
			 removeSpellToGraveyard(spells.get(i));
			 
		 }
		
		 
	 }
	
     public void addCardToHand(){
	
		
		if(Card.getBoard().getActivePlayer().getField().getDeck().getDeck().size()<=0){
			Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
		}
		else{
		 Card x=deck.drawOneCard();
		x.setLocation(Location.HAND);
		hand.add(x);
		}
		
	 }
	 
     public void addNCardsToHand(int n){
		
		 if(deck.getDeck().size()>=n){ 
		hand.addAll(deck.drawNCards(n));
		for(int i=0;i<hand.size();i++){
			hand.get(i).setLocation(Location.HAND);
		}
		
		}
		 
		 else{
			Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
		}
	
		 
	 }
	 
	 
	 
	 
	 
	 }
	 




	 



