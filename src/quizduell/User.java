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
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((server == null) ? 0 : server.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (server == null) {
			if (other.server != null)
				return false;
		} else if (!server.equals(other.server))
			return false;
		return true;
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
		if(this.equals(enemy))
			throw new IllegalArgumentException("You cannot duel yourself");
		server.addDuel(this, enemy);		
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getServer() {
		return this.server.getId();
	}
	
	
	
}
