package compiler;

public class Driver {

	public static void main(String[] args) {
		
		Lexer scanner_c = new Lexer("E:\\Work\\CS\\semester 7\\compiler construction"
				+ "\\lab\\input_scanner_.c");
	//	Lexer scanner_h = new Lexer("E:\\Work\\CS\\semester 7\\compiler construction"
	//			+ "\\lab\\input_scanner_.h");
	
	
		scanner_c.generateTokens();
	}
	
}
