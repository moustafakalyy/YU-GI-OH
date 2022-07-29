package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class EmptyFieldException extends UnexpectedFormatException {
int sourceField;
	public EmptyFieldException(String sourceFile, int sourceLine,int sourceField) {
		super(sourceFile, sourceLine);
		this.sourceField=sourceField;
		
	}
	public int getSourceField() {
		return sourceField;
	}
	public void setSourceField(int sourceField) {
		this.sourceField = sourceField;
	}
	
	public String getMessage(){
		return "There is an empty field ";
		}
	

}
