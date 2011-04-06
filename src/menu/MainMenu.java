package menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {
	
	private Controller controller;

	private JButton newGameButton;
	private JButton saveGameButton;
	private JButton loadGameButton;
	private JButton optionsButton;
	private JButton quitButton;
	
	private final int BORDER = 10;

	
	public MainMenu(Controller controller) {
		this.controller = controller;
		
		this.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
				
		initComponents();
		initListeners();
		
		
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
	
	private void initListeners() {
		newGameButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.handleNewGame();			
			}
			
		});
		
		quitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.handleQuitGame();			
			}
			
		});
	}
}
