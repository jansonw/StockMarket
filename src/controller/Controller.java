package controller;

import job.JobBase;
import logic.Logic;
import menu.Gui;

public class Controller {
	private Gui gui;
	private Logic logic;

	public Controller() {
		gui = new Gui(this);
		logic = new Logic(this);
	}
	
	public void handleNewGame() {
		gui.showNewGameMenu();
	}
	
	public void handleQuitGame() {
		System.out.println("Goodbye!");
		System.exit(0);
	}

	public void handleNewGameMenuQuitButton() {
		logic.handleQuitGame();
		gui.handleQuitGame();
		gui.showMainMenu();
	}

	public void handleNewGameMenuNextButton(String textField, JobBase selectedJob) {
		logic.handleNewGameMenuNextButton(textField, selectedJob);
		gui.handleNewGameMenuNextButton();
	}
}
