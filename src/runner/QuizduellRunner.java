package runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import quizduell.Server;
import quizduell.User;

public class QuizduellRunner {
	public static void main(String args[]) {		
		Server myServer = new Server("mySuperGameServer");
		User a = new User(myServer, "a");
		User b = new User(myServer, "b");
		myServer.addUser(a);
		System.out.println(myServer.currentUser().hashCode());
		myServer.addUser(b);
		System.out.println(myServer.currentUser().hashCode());
		myServer.addUser(a);
		System.out.println(myServer.currentUser().hashCode());
		
		while(true) {
			System.out.println("Welcome to QuizDuel!\nYou have to Log in first. What's your name?");
			System.out.print("Your Name:");
			String name = read();
//			User a = new User(myServer, name);
			myServer.addUser(new User(myServer, name));
			System.out.println("Welcome to the game, "+myServer.currentUser().getName());
			System.out.println("You are currently logged in on '"+myServer.getId()+"'");
			System.out.println("You can either p)lay a game, show a u)serlist or l)ogin as another user");
			String choice = read();
			if(choice.equals("l")) {
				continue;
			}
			if(choice.equals("u")) {
				System.out.println(myServer.getUserList());
			}
			if(choice.equals("p")) {
				if(myServer.currentUser().showDuels().size() == 0) {
					System.out.println("You have no open duels, please login as another user and open a new duel");
					System.out.println("Would you like to l)ogin as another user or s)tart a new game?");
					String choiceString = read();
					if(choiceString.equals("l")) {
						continue;
					} else {
						System.out.println("With who do you want to play?");
						System.out.println(myServer.getUserList());
						String opponentName = read();
						try {
							myServer.currentUser().newDuel(myServer.getUserById(Integer.parseInt(opponentName)));
						} catch (Exception e) {
							System.out.println("Please enter a number");
						}
//						finally {
							System.out.println("New " + myServer.currentUser().showDuels());
//						}
					}
				} else {
					System.out.println("You can play in one of the following open duels:");
					System.out.println(myServer.currentUser().showDuels().toString());
				}
			}
		}
		

		
//		alice.newDuel(carol);

//		System.out.println("end");
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
