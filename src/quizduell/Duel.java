package quizduell;

import java.util.ArrayList;

public class Duel {
	private ArrayList<User> users = new ArrayList<User>();

	public Duel(User a, User b) {
		super();
		this.users.add(a);
		this.users.add(b);
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Duel [users=" + users + "]";
	}
	
	
}
