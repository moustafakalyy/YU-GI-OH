package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FieldPanel1 extends JPanel {
	MonsterAreaPanel1 monsterAreaPanel1;
	SpellAreaPanel1 spellAreaPanel1;
	HandPanel1 handPanel1;
	public HandPanel1 getHandPanel1() {
		return handPanel1;
	}
	public void setHandPanel1(HandPanel1 handPanel1) {
		this.handPanel1 = handPanel1;
	}
	public FieldPanel1(){
		this.setLayout(new GridLayout(3,1,0,15));
		monsterAreaPanel1=new MonsterAreaPanel1();
		spellAreaPanel1=new SpellAreaPanel1();
		handPanel1= new HandPanel1();
		
		this.add(monsterAreaPanel1);
		this.add(spellAreaPanel1);
		this.add(handPanel1);
	}
	public MonsterAreaPanel1 getMonsterAreaPanel1() {
		return monsterAreaPanel1;
	}
	public void setMonsterAreaPanel1(MonsterAreaPanel1 monsterAreaPanel) {
		this.monsterAreaPanel1 = monsterAreaPanel;
	}
	public SpellAreaPanel1 getSpellAreaPanel1() {
		return spellAreaPanel1;
	}
	public void setSpellAreaPanel1(SpellAreaPanel1 spellAreaPanel1) {
		this.spellAreaPanel1 = spellAreaPanel1;
	}

}
