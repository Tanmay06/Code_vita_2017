import java.util.Stack;
import java.util.Scanner;

class StringLine{

	String line;

	StringLine(String in){
		line = in;
	}

	boolean checkLine(){

		Stack<Character> open = new Stack<Character>();

		char[] lineArray = this.line.toCharArray();

		for(int i = 0 ; i < lineArray.length; i++){

			//System.out.println(lineArray[i]);

			switch(lineArray[i]){

				case '(':
				case '[':
				case '{':
				case '/':
				case '<':
					open.push(lineArray[i]);
					break;

				case ')':
					if(open.isEmpty() || open.pop() != '(')
						return false;
						break;
				
				case ']':
					if(open.isEmpty() || open.pop() != '[')
						return false;
						break;


				case '}':
					if(open.isEmpty() || open.pop() != '{')
						return false;
						break;


				case '\\':
					if(open.isEmpty() || open.pop() != '/')
						return false;
						break;


				case '>':
					if(open.isEmpty() || open.pop() != '<')
						return false;
						break;

				case '@':
					if(lineArray[i+1] == '*'){
						i += 2;
						while( !(lineArray[i] == '*' && lineArray[i+1] == '@'))
							i++;
						i += 2;
					}
					break;

				default:

			}
		}

		return open.isEmpty();
	}
}

class cvr2_17_d {
	
	public static void main(String[] args) {
		
		Scanner scanIn = new Scanner(System.in);

		int noOfLines = Integer.parseInt(scanIn.nextLine());

		StringLine[] lines = new StringLine[noOfLines];

		for(int i = 0 ; i < noOfLines; i++){
			lines[i] = new StringLine(scanIn.nextLine());
		}

		for(StringLine each : lines){

			if(each.checkLine())
				System.out.println("True");
			else
				System.out.println("False");
		}
	}
}