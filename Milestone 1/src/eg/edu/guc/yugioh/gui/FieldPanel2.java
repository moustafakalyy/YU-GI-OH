package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FieldPanel2 extends JPanel {
	MonsterAreaPanel2 monsterAreaPanel2;
	SpellAreaPanel2 spellAreaPanel2;
	HandPanel2 handPanel2;
	public FieldPanel2(){
		this.setLayout(new GridLayout(3,1,0,15));
		monsterAreaPanel2=new MonsterAreaPanel2();
		spellAreaPanel2=new SpellAreaPanel2();
		 handPanel2=new HandPanel2();
		this.add(handPanel2);
		
		this.add(spellAreaPanel2);
		this.add(monsterAreaPanel2);
	}
	
	public HandPanel2 getHandPanel2() {
		return handPanel2;
	}

	public void setHandPanel2(HandPanel2 handPanel2) {
		this.handPanel2 = handPanel2;
	}

	public MonsterAreaPanel2 getMonsterAreaPanel2() {
		return monsterAreaPanel2;
	}
	public void setMonsterAreaPanel2(MonsterAreaPanel2 monsterAreaPanel2) {
		this.monsterAreaPanel2 = monsterAreaPanel2;
	}
	public SpellAreaPanel2 getSpellAreaPanel2() {
		return spellAreaPanel2;
	}
	public void setSpellAreaPanel2(SpellAreaPanel2 spellAreaPanel2) {
		this.spellAreaPanel2 = spellAreaPanel2;
	}
	

}
