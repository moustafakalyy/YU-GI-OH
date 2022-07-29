package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class MultipleMonsterAdditionException extends RuntimeException  {

	public String getMessage() {
		// TODO Auto-generated method stub
		return "You can add only one monster per turn !!";
	}
}
