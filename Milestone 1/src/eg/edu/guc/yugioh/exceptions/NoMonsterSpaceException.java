package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoMonsterSpaceException extends NoSpaceException {
	public String getMessage() {
		// TODO Auto-generated method stub
		return "The Monster Field is Full";
	}
}
