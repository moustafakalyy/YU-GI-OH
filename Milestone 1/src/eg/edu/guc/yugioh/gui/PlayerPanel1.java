package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlayerPanel1 extends JPanel implements ActionListener {
	FieldPanel1 fieldPanel1;
	
	
	InfoPanel1 infoPanel1;
	
	EastPanel1 eastPanel1;
	public PlayerPanel1(){
		fieldPanel1=new FieldPanel1();
		
		eastPanel1=new EastPanel1();
		
		infoPanel1=new InfoPanel1();
		
		
		
		
		
		this.setLayout(new BorderLayout(50,50));
		
		this.add(fieldPanel1, BorderLayout.CENTER);
		
	
		this.add(infoPanel1,BorderLayout.WEST);
		this.add(eastPanel1, BorderLayout.EAST);
		
		
		
		
	}

	public FieldPanel1 getFieldPanel1() {
		return fieldPanel1;
	}

	public void setFieldPanel1(FieldPanel1 fieldPanel1) {
		this.fieldPanel1 = fieldPanel1;
	}

	public InfoPanel1 getInfoPanel1() {
		return infoPanel1;
	}


	public void setInfoPanel1(InfoPanel1 infoPanel1) {
		this.infoPanel1 = infoPanel1;
	}

	public EastPanel1 getEastPanel1() {
		return eastPanel1;
	}


	public void setEastPanel1(EastPanel1 eastPanel1) {
		this.eastPanel1 = eastPanel1;
	}

	@Override
	public void actionPerformed(ActionEvent e){ 
		
		
	}
	public void updateEastPanel1(){
		
	}
}
