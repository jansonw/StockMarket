package menu;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class Gui extends JFrame {	
	private Controller controller;
	
	private JPanel currentPanel;
	private MainMenu mainMenu;
	private NewGameMenu newGameMenu;
	
	public Gui(Controller controller) {
		this.controller = controller;
		
		mainMenu = new MainMenu(controller);
		newGameMenu = new NewGameMenu(controller);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Stock Market Game");
		this.setResizable(false);
		
		currentPanel = mainMenu;
		this.setContentPane(currentPanel);
		this.pack();
		this.setVisible(true);
	}
	
	public void showMainMenu() {
		currentPanel.setVisible(false);
		currentPanel = mainMenu;
		this.setContentPane(currentPanel);
		
		this.pack();
		this.repaint();
		currentPanel.setVisible(true);		
	}
	
	public void showNewGameMenu() {
		currentPanel.setVisible(false);
		currentPanel = newGameMenu;
		this.setContentPane(currentPanel);
		
		this.pack();		
		this.repaint();
		currentPanel.setVisible(true);		
	}

	public void handleNewGameMenuNextButton() {
		newGameMenu.handleNewGameMenuNextButton();
		
		this.repaint();
		this.pack();
	}

	public void handleQuitGame() {
		newGameMenu.handleQuitGame();		
	}
}
