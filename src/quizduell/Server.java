package quizduell;

import java.util.ArrayList;

public class Server {
	private String id;
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Duel> duels = new ArrayList<Duel>();
	
	public Server(String id) {
		super();
		this.id = id;
	}
	
	protected void addDuel(User a, User b) {
		this.duels.add(new Duel(a,b));
	}
	
	/**
	 * show all open duels for a user
	 * @return
	 */
	protected ArrayList<Duel> showOpenDuels(User user) {
		ArrayList<Duel> returnedDuels = new ArrayList<Duel>();
		for(Duel duel : this.duels) {
			if(duel.getUsers().contains(user)) {
				returnedDuels.add(duel);
			}
		}
		return returnedDuels;
	}
	
	protected void addUser(User cl) {
		this.users.add(cl);
	}
	
	public String getUsers() {
		return this.users.toString();
	}
	
	protected String getId() {
		return this.id;
	}
}
