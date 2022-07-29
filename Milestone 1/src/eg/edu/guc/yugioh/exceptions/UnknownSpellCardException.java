package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class UnknownSpellCardException extends UnexpectedFormatException{
	String unknownSpell;
	public UnknownSpellCardException(String sourceFile, int sourceLine,String unknownSpell) {
		super(sourceFile, sourceLine);
		this.unknownSpell=unknownSpell;
	}
	public String getUnknownSpell() {
		return unknownSpell;
	}
	public void setUnknownSpell(String unknownSpell) {
		this.unknownSpell = unknownSpell;
	}

	
	
	

}
