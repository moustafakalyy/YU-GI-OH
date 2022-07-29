package eg.edu.guc.yugioh.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

@SuppressWarnings("serial")
public class StartFrame extends JFrame implements ActionListener {
	JButton startButton;
	Player player1;
	Player player2;
	JTextField textField1;
	JTextField textField2;
	JLabel l1;
	JLabel l2;
	Image img;
	public StartFrame() throws IOException, UnknownCardTypeException, UnknownSpellCardException, MissingFieldException, EmptyFieldException{
		this.setBounds(200, 100, 500, 500);
		this.setLayout(new GridLayout(10, 5));
		
		this.setIconImage(new ImageIcon("Start.png").getImage());
		//this.setBackground(getIconImage());
		startButton=new JButton();
		
		startButton.addActionListener(this);
		startButton.setFont(new Font("Aerial",Font.ITALIC,25));
		
		textField1=new JTextField();
		textField1.setFont(new Font("Aerial",Font.ITALIC,25));
		textField2=new JTextField();
		textField2.setFont(new Font("Aerial",Font.ITALIC,25));
		l1=new JLabel();
		l2=new JLabel();
		l1.setFont(new Font("Aerial",Font.ITALIC,25));
		l2.setFont(new Font("Aerial",Font.ITALIC,25));
			
		startButton.setBounds(180, 180, 100, 100);
		startButton.setText("LETS START THE DUEL");
		l1.setText("Ener First Player's name");
		l2.setText("Ener Second Player's name");
		
		//startButton.setSize(100, 500);

		
		textField1.setSize(100,100);
		textField1.setBounds(0, 180, 100, 100);
		textField2.setBounds(480, 180, 100, 100);

	
		
		this.getContentPane().add(startButton);
		this.getContentPane().add(l1);
		this.getContentPane().add(textField1);
		this.getContentPane().add(l2);
		this.getContentPane().add(textField2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
	}
	


public Player getPlayer1() {
	return player1;
}

public void setPlayer1(Player player1) {
	this.player1 = player1;
}

public Player getPlayer2() {
	return player2;
}

public void setPlayer2(Player player2) {
	this.player2 = player2;
}

@Override 
public void  actionPerformed(ActionEvent f){
	
	try {
		player1 = new Player(textField1.getText());
		GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().getPlayerName().setText((textField1.getText()));
		GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().getLifePoints().setText(""+player1.getLifePoints());

	} catch (UnknownCardTypeException | UnknownSpellCardException
			| MissingFieldException | EmptyFieldException | IOException e) {
		
		e.printStackTrace();
	}
	try {
		player2 = new Player(textField2.getText());
		GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().getPlayerName().setText((textField2.getText()));;
		GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().getLifePoints().setText(""+player2.getLifePoints());

	} catch (UnknownCardTypeException | UnknownSpellCardException
			| MissingFieldException | EmptyFieldException | IOException e) {
	
		e.printStackTrace();
	}
	
	
	this.setVisible(false);

	GUI.getGameFrame().setVisible(true);
	
	GUI.getGameBoard().startGame(player1,player2);
	if(player1.equals(GUI.getGameBoard().getActivePlayer())){
		GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().getTurn().setText(" Your turn");
		GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().getTurn().setText("not Your Turn");
		GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().setPhase(GUI.getGameBoard().getActivePlayer().getField().getPhase().name());
		GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().setPhase(GUI.getGameBoard().getActivePlayer().getField().getPhase().name());
	}
	else{
		GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().getTurn().setText(" Your turn");
		GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().getTurn().setText("not Your Turn");
		GUI.getGameFrame().getPlayerPanel1().getInfoPanel1().setPhase(GUI.getGameBoard().getActivePlayer().getField().getPhase().name());
		GUI.getGameFrame().getPlayerPanel2().getInfoPanel2().setPhase(GUI.getGameBoard().getActivePlayer().getField().getPhase().name());
	}
	
	
     //GUI.getGameFrame().getPlayerPanel1().getEastPanel1().getDeckPanel().getCardsCount().setText(""+ player1.getField().getDeck().getDeck().size());
	GUI.Update();
    
	


	
     GUI.getGameFrame().getPlayerPanel1().getFieldPanel1().getHandPanel1().BuildHandPanel(player1.getField().getHand());
     GUI.getGameFrame().getPlayerPanel2().getFieldPanel2().getHandPanel2().BuildHandPanel(player2.getField().getHand());
    
}





}
