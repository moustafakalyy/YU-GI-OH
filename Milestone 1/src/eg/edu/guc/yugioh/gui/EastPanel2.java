package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EastPanel2 extends JPanel {
	GraveYardPanel2 graveyardPanel;
	DeckPanel2 deckPanel;
	public EastPanel2(){
		this.setLayout(new GridLayout(1,2));
		 graveyardPanel=new GraveYardPanel2();
		deckPanel=new DeckPanel2();
		this.add(graveyardPanel);
		this.add(deckPanel);
		
	}
	public GraveYardPanel2 getGraveyardPanel2() {
		return graveyardPanel;
	}
	public void setGraveyardPanel2(GraveYardPanel2 graveyardPanel) {
		this.graveyardPanel = graveyardPanel;
	}
	public DeckPanel2 getDeckPanel2() {
		return deckPanel;
	}
	public void setDeckPanel2(DeckPanel2 deckPanel) {
		this.deckPanel = deckPanel;
	}
	public void gravePanel1(){
		
	}

}
