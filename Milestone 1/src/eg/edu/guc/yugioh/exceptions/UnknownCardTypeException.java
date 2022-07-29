package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class UnknownCardTypeException extends UnexpectedFormatException {
	String unknownType;
	public UnknownCardTypeException(String sourceFile, int sourceLine,String unknownType) {
		super(sourceFile, sourceLine);
		this.unknownType=unknownType;
		
	}
	public String getUnknownType() {
		return unknownType;
	}
	public void setUnknownType(String unknownType) {
		this.unknownType = unknownType;
	}
	

}
