package compiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SymbolTable {

	ArrayList<ArrayList<String>> symbolTable;
	int index = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymbolTable test = new SymbolTable();
		test.init();
		
		System.out.println(test.getType("int"));
	}

	public void init() {
		symbolTable = new ArrayList <ArrayList <String>>();
		String keywords[] = { "auto", "break", "case", "char", "const",
				"continue", "default", "do", "double", "else", "enum",
				"extern", "float", "for", "goto", "if", "int", "long",
				"register", "return", "short", "signed", "sizeof", "static",
				"struct", "switch", "typedef", "union", "unsigned", "void",
				"volatile", "while" };

		for (int i = 0; i < keywords.length; i++) {
			symbolTable.add(new ArrayList<String>());
			symbolTable.get(index++).addAll(
					Arrays.asList(keywords[i], "reserved"));
		}
	
		
	}
	
	public void add(List c){
		
		symbolTable.add(new ArrayList<String>());
		symbolTable.get(index++).addAll(c);
	}
	
	public boolean contains(String word){
		for (ArrayList<String> elem : symbolTable) {
			if(elem.get(0).compareToIgnoreCase(word) == 0){
				return true;
			}
		}
		return false;
	}
	public boolean contains(String word, String attribute){
		for (ArrayList<String> elem : symbolTable) {
			if(elem.get(0) == word && elem.get(1) == attribute){
				return true;
			}
		}
		return false;
	}
	public void get(String word){
		
	}
	public void get(String word, String attribute){
		
	}
	
	public String getType(String word){
		for (ArrayList<String> elem : symbolTable) {
			if(elem.get(0).compareToIgnoreCase(word) ==0){
				return elem.get(1);
			}
		}
		return null;
	}
	public String getValue(String word){
		for (ArrayList<String> elem : symbolTable) {
			if(elem.get(0) == word ){
				return elem.get(2);
			}
		}
		return null;
	}
	

}
