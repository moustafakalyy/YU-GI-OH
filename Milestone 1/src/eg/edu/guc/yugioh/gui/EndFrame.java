package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

@SuppressWarnings("serial")
public class EndFrame extends JFrame implements ActionListener {
	JButton playAgain;
	JLabel Winner;
	
	public EndFrame(){
		this.setLayout(new GridLayout(2,1));
		
		this.setBounds(100,200,500,500);
		
		
		
		Winner=new JLabel();
		Winner.setLayout(new BorderLayout());
		Winner.setHorizontalTextPosition(JLabel.CENTER);
		Winner.setVerticalTextPosition(JLabel.CENTER);
		this.add(Winner);
		playAgain= new JButton();
		playAgain.setText("Play Again !");
		playAgain.setFont(new Font("Sans Serif", Font.ITALIC, 25));
Winner.setFont(new Font("Sans Serif", Font.ITALIC, 20));

		
		this.add(playAgain);
		playAgain.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public JButton getPlayAgain() {
		return playAgain;
	}

	public void setPlayAgain(JButton playAgain) {
		this.playAgain = playAgain;
	}

	public JLabel getWinner() {
		return Winner;
	}

	public void setWinner(JLabel winner) {
		Winner = winner;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			new GUI();
		} catch (UnknownCardTypeException | UnknownSpellCardException
				| MissingFieldException | EmptyFieldException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		this.setVisible(false);
		
	}
	

}
