package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EastPanel1 extends JPanel {
	GraveYardPanel1 graveyardPanel;
	DeckPanel1 deckPanel;
	
	public EastPanel1(){
		this.setLayout(new GridLayout(1,2));
		
		
		 graveyardPanel=new GraveYardPanel1();
		deckPanel=new DeckPanel1();
		

		
		
		this.add(graveyardPanel);
		this.add(deckPanel);
		
		
	}
	public GraveYardPanel1 getGraveyardPanel1() {
		return graveyardPanel;
	}
	public void setGraveyardPanel1(GraveYardPanel1 graveyardPanel) {
		this.graveyardPanel = graveyardPanel;
	}
	public DeckPanel1 getDeckPanel1() {
		return deckPanel;
	}
	public void setDeckPanel1(DeckPanel1 deckPanel) {
		this.deckPanel = deckPanel;
	}



}
