package quizduell;

import java.util.ArrayList;

public class Server {
	private String id;
	private int currentUser;
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
	
	public void addUser(User cl) {
		boolean existingUser = false;
		for(User u : this.users) {
			if(u.equals(cl)) {
				existingUser = true;
			}
		}
		if(existingUser){
			this.currentUser = this.users.indexOf(cl);
		} else {
			this.users.add(cl);
			this.currentUser = this.users.indexOf(cl);
		}
	}

	public User currentUser() {
		return this.users.get(this.currentUser);
	}
	
	public String getUsers() {
		return this.users.toString();
	}
	
	public User getUserById(int id) {
		return this.users.get(id);
	}
	
	public String getUserList() {
		String ret = "";
		for( int i = 0; i < this.users.size(); i++ ) {
			ret += i + ") " + this.users.get(i).getName() + "\n";
		}
		return ret;
	}
	
	public String getId() {
		return this.id;
	}
}
