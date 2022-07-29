package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlayerPanel2 extends JPanel  {
	FieldPanel2 fieldPanel2;

	InfoPanel2 infoPanel2;

	EastPanel2 eastPanel2;

	public PlayerPanel2() {
		fieldPanel2 = new FieldPanel2();

		eastPanel2 = new EastPanel2();

		infoPanel2 = new InfoPanel2();

		this.setLayout(new BorderLayout(50, 50));
		this.add(fieldPanel2, BorderLayout.CENTER);

		this.add(infoPanel2, BorderLayout.WEST);
		this.add(eastPanel2, BorderLayout.EAST);

	}

	public FieldPanel2 getFieldPanel2() {
		return fieldPanel2;
	}

	public void setFieldPanel2(FieldPanel2 fieldPanel2) {
		this.fieldPanel2 = fieldPanel2;
	}

	public InfoPanel2 getInfoPanel2() {
		return infoPanel2;
	}

	public void setInfoPanel2(InfoPanel2 infoPanel2) {
		this.infoPanel2 = infoPanel2;
	}

	public EastPanel2 getEastPanel2() {
		return eastPanel2;
	}

	public void setEastPanel2(EastPanel2 eastPanel2) {
		this.eastPanel2 = eastPanel2;
	}



}
