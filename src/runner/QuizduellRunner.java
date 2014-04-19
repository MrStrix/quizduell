package runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import quizduell.Server;
import quizduell.User;

public class QuizduellRunner {
	public static void main(String args[]) {

		

		
//		alice.newDuel(carol);

//		System.out.println();
//		bob.showDuels();
//		alice.showDuels();
	}
	
	private static String read() {
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    String string = bufferRead.readLine();
	 
		    return string;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return "";
		}
	}
}
