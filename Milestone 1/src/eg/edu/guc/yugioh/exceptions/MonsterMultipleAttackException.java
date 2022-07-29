package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class MonsterMultipleAttackException extends RuntimeException  {

	public String getMessage() {
		// TODO Auto-generated method stub
		return "Can't Attack with a Monster more than once !!";
	}
}
