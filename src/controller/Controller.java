package controller;

import global.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import transferobject.NewGameTransferObject;
import view.game.Game;
import view.menu.Menu;
import model.Model;

public class Controller implements ActionListener{
	private Menu view;
	private Model model;
	
	private Game gameView;

	public Controller(Model model, Menu view) {
		this.view = view;
		this.model = model;
		
		view.addActionListeners(this);
	}
	
	private void setMainGameVisible(boolean visible) {
		if(gameView == null) {
			SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	gameView = new Game();
	            }
	        });
		}
		
		gameView.setVisible(visible);
	}
	
	private void handleNewGame() {
		view.showNewGameMenu();
	}
	
	private void handleQuitGame() {
		System.out.println("Goodbye!");
		System.exit(0);
	}

	private void handleNewGameMenuQuitButton() {
		model.handleQuitGame();
		view.handleQuitGame();
		view.showMainMenu();
	}

	private void handleNewGameMenuNextButton() {
		NewGameTransferObject obj = view.getNewGameTransferObject();
		
		model.handleNewGameMenuNextButton(obj.getUserInput(), obj.getSelectedJob());
		view.handleNewGameMenuNextButton();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(Listeners.MENU_NEW_GAME_BUTTON.equals(command)) {
			handleNewGame();
		}
		else if(Listeners.MENU_QUIT_GAME_BUTTON.equals(command)) {
			handleQuitGame();
		}
		else if(Listeners.NEW_GAME_NEXT_BUTTON.equals(command)) {
			handleNewGameMenuNextButton();
		}
		else if(Listeners.NEW_GAME_QUIT_BUTTON.equals(command)) {
			handleNewGameMenuQuitButton();
		}
	}
}
