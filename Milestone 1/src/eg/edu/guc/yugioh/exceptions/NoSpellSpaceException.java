package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoSpellSpaceException extends NoSpaceException {
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Spell Field is Full !!";
	}
}
