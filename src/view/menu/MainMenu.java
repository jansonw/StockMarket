package view.menu;

import global.Listeners;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {
	private JButton newGameButton;
	private JButton saveGameButton;
	private JButton loadGameButton;
	private JButton optionsButton;
	private JButton quitButton;
	
	private final int BORDER = 10;

	
	public MainMenu() {
		this.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
				
		initComponents();		
	}
	
	private void initComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		
		newGameButton = new JButton("New Game");
		c.gridy = 0;
		this.add(newGameButton, c);
		
		c.insets = new Insets(5, 0, 0, 0);
		
		saveGameButton = new JButton("Save Game");
		c.gridy = 1;
		this.add(saveGameButton, c);
		
		loadGameButton = new JButton("Load Game");
		c.gridy = 2;
		this.add(loadGameButton, c);
		
		optionsButton = new JButton("Options");
		c.gridy = 3;
		this.add(optionsButton, c);
		
		quitButton = new JButton("Quit Game");
		c.gridy = 4;
		this.add(quitButton, c);
	}

	public void addActionListeners(ActionListener listener) {
		newGameButton.setActionCommand(Listeners.MENU_NEW_GAME_BUTTON);
		newGameButton.addActionListener(listener);
		
		quitButton.setActionCommand(Listeners.MENU_QUIT_GAME_BUTTON);
		quitButton.addActionListener(listener);
	}
}
