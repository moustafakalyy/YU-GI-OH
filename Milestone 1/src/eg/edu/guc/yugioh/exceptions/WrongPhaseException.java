package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class WrongPhaseException extends RuntimeException  {
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Can't perform this action in this phase!!";
	}

}
