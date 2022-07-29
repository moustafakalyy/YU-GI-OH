package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class UnexpectedFormatException extends Exception {
	String sourceFile;
	int sourceLine;
	public UnexpectedFormatException(String sourceFile, int sourceLine){
		super("sourceFile+sourceLine");
		this.sourceFile=sourceFile;
		this.sourceLine=sourceLine;
	}
	public String getSourceFile() {
		return sourceFile;
	}
	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}
	public int getSourceLine() {
		return sourceLine;
	}
	public void setSourceLine(int sourceLine) {
		this.sourceLine = sourceLine;
	}
	//public void getMessage(){
		
	//}
	
	
}
