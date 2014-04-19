package quizduell;

import java.util.ArrayList;

public class User {
	private Server server;
	private String name;

	public User(Server server, String name) {
		super();
		this.server = server;
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	/**
	 * show all open duels
	 */
	public ArrayList<Duel> showDuels() {
		return this.server.showOpenDuels(this);
	}

	/**
	 * add new duel with given enemy
	 * @param enemy
	 */
	public void newDuel(User enemy) {
		server.addDuel(this, enemy);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void logIn() {
		this.server.addUser(this);
	}
	
	public String getServer() {
		return this.server.getId();
	}
	
	
	
}
