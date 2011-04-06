package logic;

import players.Player;
import global.Constants;
import global.CurrentState;
import job.JobBase;
import controller.Controller;

public class Logic {
	private Controller controller;
	
	private CurrentState currentState = CurrentState.getInstance();
	
	public Logic(Controller controller) {
		this.controller = controller;
	}

	public void handleNewGameMenuNextButton(String textField, JobBase selectedJob) {
		if(Constants.NEW_GAME_MENU_GET_NUM_PLAYERS.equals(currentState.getCurrentState())) {
			currentState.setNumberOfPlayers(Integer.parseInt(textField));			
			currentState.setCurrentState(Constants.NEW_GAME_MENU_ADD_PLAYER);
		}
		else if (Constants.NEW_GAME_MENU_ADD_PLAYER.equals(currentState.getCurrentState())) {
			currentState.addPlayer(textField, selectedJob);
			if(currentState.getPlayerList().size() == currentState.getNumberOfPlayers()) {
				currentState.setCurrentState(Constants.NEW_GAME_MENU_START_GAME);
			}
		}
		else if (Constants.NEW_GAME_MENU_START_GAME.equals(currentState.getCurrentState())) {
			System.out.println("Start Game!");
			
			for(Player p : currentState.getPlayerList()) {
				System.out.println(p.toString());
			}
		}
		else {
			System.err.println("Invalid state: " + currentState.getCurrentState());
			System.exit(1);
		}
	}

	public void handleQuitGame() {
		currentState.setCurrentState(Constants.NEW_GAME_MENU_GET_NUM_PLAYERS);
		currentState.getPlayerList().clear();
		currentState.setNumberOfPlayers(0);	
	}
}
