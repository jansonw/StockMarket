package global;
import java.util.Vector;

import job.JobBase;

import players.Player;

public class CurrentState {
	private static CurrentState singleton = null;
	
	private Vector<Player> playerList = new Vector<Player>();
	private int numberOfPlayers;
	
	
	private String currentNewGameMenuState;
	
	private CurrentState() {}
	
	public static CurrentState getInstance() {
		if(singleton == null) {
			singleton = new CurrentState();
		}
		return singleton;
	}
	
	public void addPlayer(String name, JobBase job) {
		playerList.add(new Player(name, job));
	}
	
	public Vector<Player> getPlayerList() {
		return this.playerList;
	}

	public String getCurrentState() {
		return currentNewGameMenuState;
	}

	public void setCurrentState(String currentNewGameMenuState) {
		this.currentNewGameMenuState = currentNewGameMenuState;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
}