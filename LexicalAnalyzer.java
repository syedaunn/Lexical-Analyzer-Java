package compiler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LexicalAnalyzer {

	ArrayList<ArrayList<String>> symbolTable;
	String source_file;
	Scanner reader;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		LexicalAnalyzer compiler = new LexicalAnalyzer("E:\\input_scanner.c");
		compiler.lexicalDriver();
	}

	public LexicalAnalyzer(String input_file) {
		this.source_file = input_file;
	}

	public void lexicalDriver() throws FileNotFoundException {
		File input_sourceFile = new File(this.source_file);
		reader = new Scanner(input_sourceFile);
		int start = 0, end = 0;
		int lineNo = 0;
		while (reader.hasNextLine()) {
			lineNo++;
			String read_in = reader.nextLine();

			/*Remove Single Line Comment*/
			if ((start = read_in.indexOf("//")) != -1) {
				if (start == 0)
					continue;
				int quoteStart = read_in.indexOf("\"");
				int quoteEnd = read_in.indexOf("\"", quoteStart + 1);

				if (start < quoteStart || start > quoteEnd)
					read_in = read_in.substring(0, start);

			}
			/*Remove Block Line Comment*/
			if ((start = read_in.indexOf("/*")) != -1) {
				String a = read_in.substring(0, start);

				System.out.print("(" + lineNo + ")\t");
				System.out.println(a);

				while ((end = read_in.indexOf("*/")) == -1 && reader.hasNextLine())
					read_in = reader.nextLine();

				if ((end) != read_in.length())
					read_in = read_in.substring(end + 2, read_in.length());
				else
					continue;
			}
			
			/*Print Line for now, later process and save*/
			if (read_in.length() != 0) {
				System.out.print("(" + lineNo + ")\t");
				System.out.println(read_in);
			}
		}

	}

	/*Stubs for complete compiler*/
	
	public void generateTokens(){}
	public void initSymTable(){}
	public void symbolLookup(){}
	public void replaceMacros(){}
	public void cleanWhiteSpaces(){}
	public void writeTokenStreamtoFile(){}
	
}
