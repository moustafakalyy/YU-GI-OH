package eg.edu.guc.yugioh.exceptions;



@SuppressWarnings("serial")
public class DefenseMonsterAttackException extends RuntimeException  {

	
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Can't Attack With a Monster in Deffence !!";
	}
}
