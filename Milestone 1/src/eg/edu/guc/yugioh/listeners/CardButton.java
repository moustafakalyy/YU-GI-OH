package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import eg.edu.guc.yugioh.cards.Card;

@SuppressWarnings("serial")
public class CardButton extends JButton implements ActionListener {
Card cards;
	public CardButton(Card cards){
		this.cards=cards;
	}


public Card getCard() {
		return cards;
	}


	public void setCard(Card cards) {
		this.cards = cards;
	}


@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
