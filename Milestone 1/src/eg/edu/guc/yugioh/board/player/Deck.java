package eg.edu.guc.yugioh.board.player;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.CardDestruction;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.DarkHole;
import eg.edu.guc.yugioh.cards.spells.GracefulDice;
import eg.edu.guc.yugioh.cards.spells.HarpieFeatherDuster;
import eg.edu.guc.yugioh.cards.spells.HeavyStorm;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.MonsterReborn;
import eg.edu.guc.yugioh.cards.spells.PotOfGreed;
import eg.edu.guc.yugioh.cards.spells.Raigeki;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Deck {
	private static ArrayList<Card> monsters;
	private static ArrayList<Card> spells;
	private static String monstersPath="Database-Monsters.csv";
	private static String spellsPath="Database-Spells.csv";
	private ArrayList<Card> deck;

	public Deck() throws IOException , FileNotFoundException,UnknownCardTypeException,UnknownSpellCardException,MissingFieldException, EmptyFieldException {
		Deck.monsters = new ArrayList<Card>();
		Deck.spells = new ArrayList<Card>();
	//monstersPath="Database-Monsters.csv";
	// spellsPath="Database-Spells.csv";
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		//String monsterPath=sc.nextLine();
	    try{
	    spells = loadCardsFromFile(spellsPath);
		}
		catch(FileNotFoundException|UnknownCardTypeException|UnknownSpellCardException|MissingFieldException|EmptyFieldException e ){
			
			e.getMessage();
         System.out.println("Please enter a correct path:");
         setSpellsPath(sc.nextLine());
         try{
     	    spells = loadCardsFromFile(spellsPath);

         }
         catch(FileNotFoundException|UnknownCardTypeException|UnknownSpellCardException|MissingFieldException|EmptyFieldException  f){
        	 f.getMessage();
        	 System.out.println("Please enter a correct path:");
        	 setSpellsPath(sc.nextLine());
             try{
          	    spells = loadCardsFromFile(spellsPath);

             }
             catch (FileNotFoundException|UnknownCardTypeException|UnknownSpellCardException|MissingFieldException|EmptyFieldException  g){
            	 g.getMessage();
            	 System.out.println("Please enter a correct path:");
            	 setSpellsPath(sc.nextLine());
                 try{
              	    spells = loadCardsFromFile(spellsPath);

                 }
                 catch (FileNotFoundException|UnknownCardTypeException|UnknownSpellCardException|MissingFieldException|EmptyFieldException  k){
                	
                	 throw k;
                 }

            	 
             }
         }
		}
	    try{
			monsters = loadCardsFromFile(monstersPath);
			}
			catch(FileNotFoundException|UnknownCardTypeException|MissingFieldException|EmptyFieldException  e){
				e.getMessage();
	         System.out.println("Please enter a correct path:");
	         setMonstersPath(sc.nextLine());
	         try{
	     	    monsters = loadCardsFromFile(monstersPath);

	         }
	         catch(FileNotFoundException|UnknownCardTypeException|MissingFieldException|EmptyFieldException  f){
	        	 f.getMessage();
	        	 System.out.println("Please enter a correct path:");
	             setMonstersPath(sc.nextLine());
	             try{
	            	 monsters = loadCardsFromFile(monstersPath);

	             }
	             catch (FileNotFoundException|UnknownCardTypeException|MissingFieldException|EmptyFieldException  g){
	            	 g.getMessage();
	            	 System.out.println("Please enter a correct path:");
	                 setMonstersPath(sc.nextLine());
	                 try{
	                	 monsters = loadCardsFromFile(monstersPath);

	                 }
	                 catch (FileNotFoundException|UnknownCardTypeException|MissingFieldException|EmptyFieldException  k){
	                	
	                	 throw k;
	                 }

	            	 
	             }
	         }
			}
		
		
		

		this.deck = new ArrayList<Card>();
		
		
		buildDeck(monsters, spells);
		shuffleDeck();
		
		
	}
	
	public static String getMonstersPath() {
		return monstersPath;
	}

	public static void setMonstersPath(String monstersPath) {
		Deck.monstersPath = monstersPath;
	}

	public static String getSpellsPath() {
		return spellsPath;
	}

	public static void setSpellsPath(String spellsPath) {
		Deck.spellsPath = spellsPath;
	}

	public static ArrayList<Card> getMonsters() {
		return monsters;
	}

	public static void setMonsters(ArrayList<Card> monsters) {
		Deck.monsters = monsters;
	}

	public static ArrayList<Card> getSpells() {
		return spells;
	}

	public static void setSpells(ArrayList<Card> spells) {
		Deck.spells = spells;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public ArrayList<Card> loadCardsFromFile(String path) throws IOException,UnknownCardTypeException ,UnknownSpellCardException,MissingFieldException, EmptyFieldException {
		ArrayList<Card> temp = new ArrayList<Card>();
		String[] array;
		String currentLine = "";
		FileReader fileReader = new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
int count=0;
		while ((currentLine = br.readLine()) != null) {
			count++;
			array = currentLine.split(",");
		
			if (array[0].equals("Monster")) {
				if(array.length==6){
					int x=isemptyField(array);
				if(x<0){
					temp.add(new MonsterCard(array[1], array[2], Integer.parseInt(array[5]), Integer.parseInt(array[3]),Integer.parseInt(array[4])));
				}else{
					br.close();
					x++;
					throw new  EmptyFieldException( path, count,x);
					
				}
				}
				else{
					br.close();

					throw new MissingFieldException( path,  count);
				}
			} else {
				if (array[0].equals("Spell")) {
					if(array.length==3){
						int x=isemptyField(array);
						if(x<0){
					switch (array[1]) {
					case "Card Destruction":
						temp.add(new CardDestruction(array[1], array[2]));
						break;
					case "Change Of Heart":
						temp.add(new ChangeOfHeart(array[1], array[2]));
						break;
					case "Dark Hole":
						temp.add(new DarkHole(array[1], array[2]));
						break;
					case "Graceful Dice":
						temp.add(new GracefulDice(array[1], array[2]));
						break;
					case "Harpie's Feather Duster":
						temp.add(new HarpieFeatherDuster(array[1], array[2]));
						break;
					case "Heavy Storm":
						temp.add(new HeavyStorm(array[1], array[2]));
						break;
					case "Mage Power":
						temp.add(new MagePower(array[1], array[2]));
						break;
					case "Monster Reborn":
						temp.add(new MonsterReborn(array[1], array[2]));
						break;
					case "Pot of Greed":
						temp.add(new PotOfGreed(array[1], array[2]));
						break;
					case "Raigeki":
						temp.add(new Raigeki(array[1], array[2]));
						break;
						default: throw new UnknownSpellCardException( path,  count, array[1]);
					}
					}
						else{
							br.close();
							x++;
							throw new  EmptyFieldException( path, count,x);
						}
					}
					else{
						br.close();
						throw new  MissingFieldException( path, count);
						
					 }	
				}
				else{
					br.close();
					throw new UnknownCardTypeException( path,  count, array[0]);
					
				 }
			}
		}
		br.close();
		return temp;

	}

    public static int isemptyField(String [] array ){
	for(int i=0;i<array.length;i++){
		if(array[i]==null||array[i].equals("")||array[i].equals(" ")){
			return i;
		}
	}
	return -1;
	
	
	
	
	
	
	
}
	
    private void buildDeck(ArrayList<Card> monsters, ArrayList<Card> spells) {
		ArrayList<Card> monsterS = new ArrayList <Card>();
		ArrayList<Card> spellS = new ArrayList <Card>();
		monsterS = monsters;
		spellS = spells;

		for (int i = 0; i < 15; i++) {
			int RandomValue = (int) Math.floor(Math.random() * monsterS.size());
			MonsterCard x =(MonsterCard) monsterS.get(RandomValue);
	       	MonsterCard m = new MonsterCard(x.getName(),x.getDescription(),x.getLevel(),x.getAttackPoints(),x.getDefensePoints());	
			m.setLocation(Location.DECK);
	       	deck.add(m);
			
		}
		for (int j = 0; j < 5; j++) {
			int RandomValue = (int) Math.floor(Math.random() * spellS.size());
			SpellCard x = (SpellCard)spells.get(RandomValue);
			String a =x.getName();
			x.setLocation(Location.DECK);
			switch (a) {
			case "Card Destruction":
				deck.add(new CardDestruction(x.getName(), x.getDescription()));
				break;
			case "Change Of Heart":
				deck.add(new ChangeOfHeart(x.getName(), x.getDescription()));
				break;
			case "Dark Hole":
				deck.add(new DarkHole(x.getName(), x.getDescription()));
				break;
			case "Graceful Dice":
				deck.add(new GracefulDice(x.getName(), x.getDescription()));
				break;
			case "Harpie's Feather Duster":
				deck.add(new HarpieFeatherDuster(x.getName(), x.getDescription()));
				break;
			case "Heavy Storm":
				deck.add(new HeavyStorm(x.getName(), x.getDescription()));
				break;
			case "Mage Power":
				deck.add(new MagePower(x.getName(), x.getDescription()));
				break;
			case "Monster Reborn":
				deck.add(new MonsterReborn(x.getName(), x.getDescription()));
				break;
			case "Pot of Greed":
				deck.add(new PotOfGreed(x.getName(), x.getDescription()));
				break;
			case "Raigeki":
				deck.add(new Raigeki(x.getName(), x.getDescription()));
				break;
			}
		
			
		}
		
		}

	private void shuffleDeck() {
		Collections.shuffle(deck);

	}

	public ArrayList<Card> drawNCards(int n) {
		
		ArrayList<Card> draw = new ArrayList<Card>();
		
		for(int i=0;i<n;i++) {
			
			draw.add(deck.get(0));
			
            deck.remove(0);
			
			

		}

		return draw;
	}

	public Card drawOneCard() {
		
		
		Card x = deck.get(0);
				deck.remove(0);
		
		return x;
	}
	

}