package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends  JFrame implements ActionListener {
	
	private PlayerPanel1 playerPanel1;
	private PlayerPanel2 playerPanel2;
	
	
	
	
	public GameFrame(){
		this.setBounds(150, 150, 400, 400);
		this.setLayout(new GridLayout(2, 1,0,25));
		 playerPanel1=new PlayerPanel1();
		
		 playerPanel2=new PlayerPanel2();
		this.add(playerPanel2);
		this.add(playerPanel1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public PlayerPanel1 getPlayerPanel1() {
		return playerPanel1;
	}

	public void setPlayerPanel1(PlayerPanel1 playerPanel1) {
		this.playerPanel1 = playerPanel1;
	}

	public PlayerPanel2 getPlayerPanel2() {
		return playerPanel2;
	}

	public void setPlayerPanel2(PlayerPanel2 playerPanel2) {
		this.playerPanel2 = playerPanel2;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
