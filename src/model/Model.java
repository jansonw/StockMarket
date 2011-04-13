package model;

import players.Player;
import global.States;
import global.CurrentState;
import job.JobBase;

public class Model {
	private CurrentState currentState = CurrentState.getInstance();

	public void handleNewGameMenuNextButton(String textField, JobBase selectedJob) {
		if(States.NEW_GAME_MENU_GET_NUM_PLAYERS.equals(currentState.getCurrentState())) {
			currentState.setNumberOfPlayers(Integer.parseInt(textField));			
			currentState.setCurrentState(States.NEW_GAME_MENU_ADD_PLAYER);
		}
		else if (States.NEW_GAME_MENU_ADD_PLAYER.equals(currentState.getCurrentState())) {
			currentState.addPlayer(textField, selectedJob);
			if(currentState.getPlayerList().size() == currentState.getNumberOfPlayers()) {
				currentState.setCurrentState(States.NEW_GAME_MENU_START_GAME);
			}
		}
		else if (States.NEW_GAME_MENU_START_GAME.equals(currentState.getCurrentState())) {
			System.out.println("Start Game!");
			
			for(Player p : currentState.getPlayerList()) {
				System.out.println(p.toString());
			}
			
//			currentState.setCurrentState(States.START_NEW_GAME);
		}
		else if(States.START_NEW_GAME.equals(currentState.getCurrentState())) {
			System.out.println("In the game!");
		}
		else {
			System.err.println("Invalid state: " + currentState.getCurrentState());
			System.exit(1);
		}
	}

	public void handleQuitGame() {
		currentState.setCurrentState(States.NEW_GAME_MENU_GET_NUM_PLAYERS);
		currentState.getPlayerList().clear();
		currentState.setNumberOfPlayers(0);	
	}
}
