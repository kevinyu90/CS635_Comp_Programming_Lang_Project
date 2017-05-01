import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProgrammingProject {

	public static void main(String[] args) {
		System.out.println("Please input a CNF(Chomsky Normal Form A -> aBcdE): ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		Queue<String> qStrings = new LinkedList<>();
		System.out.println("===========================================================");
		System.out.println("Input: ");
		System.out.println(input);		
		System.out.println("Output: ");
		// step 1
		stepOne(input, qStrings);
		// step 2
		while(!qStrings.isEmpty()){
			stepTwo(qStrings.poll(), qStrings);
		}
	}
	//    Step 1
	public static void stepOne(String input, Queue<String> qStrings){
		String[] temp = input.split("->");
		String before = temp[0].trim();
		String after = temp[1].trim();
		String first = after.substring(0, 1);
		String rest = after.substring(1);
		
		System.out.print(before+" -> ");
		if(!isANonterminal(first)){
			qStrings.add(first);
			System.out.print("<"+first+">");
		} else {
			System.out.print(first);
		}
		if(!isANonterminal(rest)){
			qStrings.add(rest);
			System.out.println("<"+rest+">");
		} else {
			System.out.println(rest);
		}
	}
	// 		Step 2
	public static void stepTwo(String input, Queue<String> qStrings){
		if(input.length() == 1){
			System.out.println("<"+input+"> -> "+input);
			return;
		} 			
		String first = input.substring(0, 1);
		String rest = input.substring(1);
		System.out.print("<"+input+"> -> ");
		if(!isANonterminal(first)){
			qStrings.add(first);
			System.out.print("<"+first+">");
		} else {
			System.out.print(first);
		}
		if(!isANonterminal(rest)){
			qStrings.add(rest);
			System.out.println("<"+rest+">");
		} else {
			System.out.println(rest);
		}
	}
	
	public static boolean isANonterminal(String input){
		// length > 1
		if(input.length()>1)	return false;
				
		if(Character.isUpperCase(input.charAt(0)))	return true;		
		return false;
	}
}
