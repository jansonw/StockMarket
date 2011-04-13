package view.menu;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import transferobject.NewGameTransferObject;

@SuppressWarnings("serial")
public class Menu extends JFrame {	
	
	private JPanel currentPanel;
	private MainMenu mainMenu;
	private NewGameMenu newGameMenu;
	
	public Menu() {
		mainMenu = new MainMenu();
		newGameMenu = new NewGameMenu();
		
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
	
	public void addActionListeners(ActionListener listener) {
		mainMenu.addActionListeners(listener);
		newGameMenu.addActionListeners(listener);
	}

	public NewGameTransferObject getNewGameTransferObject() {
		return newGameMenu.getNewGameTransferObject();
	}
}
