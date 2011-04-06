package menu;

import global.Constants;
import global.CurrentState;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import job.DeepSeaDiver;
import job.Doctor;
import job.JobBase;
import job.Policeman;
import job.Prospector;

import controller.Controller;

@SuppressWarnings("serial")
public class NewGameMenu extends JPanel {
	private Controller controller;
	
	private CurrentState currentState = CurrentState.getInstance();
	
	private JLabel mainLabel;
	private JTextField textField;

	private JRadioButton radioPoliceman;
	private JRadioButton radioDoctor;
	private JRadioButton radioDeepSeaDiver;
	private JRadioButton radioProspector;

	private ButtonGroup jobGroup;

	private JButton nextButton;
	private JButton exitButton;
	
	private final int BORDER = 10;
	
	public NewGameMenu(Controller controller) {
		this.controller = controller;
		
		this.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
		
		initComponents();
		initListeners();
		currentState.setCurrentState(Constants.NEW_GAME_MENU_GET_NUM_PLAYERS);
		initialize();
	}
	
	private void initComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
				
		mainLabel = new JLabel("Enter Number of Players", JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;		
		this.add(mainLabel, c);
		
		textField = new JTextField();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.insets = new Insets(5, 0, 0, 0);
		this.add(textField, c);
		
		
		jobGroup = new ButtonGroup();
		
		radioPoliceman = new JRadioButton("Policeman");
		radioPoliceman.setSelected(true);
		jobGroup.add(radioPoliceman);
	
		radioDoctor = new JRadioButton("Doctor");
		jobGroup.add(radioDoctor);
		
		radioDeepSeaDiver = new JRadioButton("Deep Sea Diver");
		jobGroup.add(radioDeepSeaDiver);
		
		radioProspector = new JRadioButton("Prospector");
		jobGroup.add(radioProspector);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.insets = new Insets(5, 0, 0, 0);
		
		this.add(radioPoliceman, c);
		
		c.gridx = 1;
		this.add(radioDoctor, c);
		
		c.gridx = 0;
		c.gridy = 3;
		this.add(radioDeepSeaDiver, c);
		
		c.gridx = 1;
		this.add(radioProspector, c);
		
		nextButton = new JButton("Okay");
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(15, 0, 0, 0);
		c.fill = GridBagConstraints.NONE;
		this.add(nextButton, c);
		
		exitButton = new JButton("Quit");
		c.gridx = 1;
		this.add(exitButton, c);		
	}
	
	private void initListeners() {
		nextButton.addActionListener(new ActionListener() {
						
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim() != null) {
					controller.handleNewGameMenuNextButton(textField.getText().trim(), findSelectedJob());		
				}					
			}
			
		});
		
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.handleNewGameMenuQuitButton();			
			}
			
		});
	}
	
	private JobBase findSelectedJob() {
		JobBase returnJob = null;

		if (radioPoliceman.isSelected()) {
			returnJob = new Policeman();
		} else if (radioDoctor.isSelected()) {
			returnJob = new Doctor();
		} else if (radioDeepSeaDiver.isSelected()) {
			returnJob = new DeepSeaDiver();
		} else if (radioProspector.isSelected()) {
			returnJob = new Prospector();
		} else {
			System.out.println("ERROR - No job is selected!");
		}

		return returnJob;
	}

	public void handleNewGameMenuNextButton() {
		if(Constants.NEW_GAME_MENU_GET_NUM_PLAYERS.equals(currentState.getCurrentState())) {
			initialize();
		}
		else if (Constants.NEW_GAME_MENU_ADD_PLAYER.equals(currentState.getCurrentState())) {
			mainLabel.setText("Enter Player Name");
			nextButton.setText("Add Player");
			showJobRadioButtons(true);
		}
		else if (Constants.NEW_GAME_MENU_START_GAME.equals(currentState.getCurrentState())) {
			nextButton.setText("Start Game");
			mainLabel.setText("Click \"Start Game\"!");
			showJobRadioButtons(false);
			textField.setVisible(false);
		}
		else {
			System.err.println("Invalid state: " + currentState.getCurrentState());
			System.exit(1);
		}
		textField.setText("");
	}
	
	private void showJobRadioButtons(boolean flag) {
		radioPoliceman.setVisible(flag);
		radioDoctor.setVisible(flag);
		radioDeepSeaDiver.setVisible(flag);
		radioProspector.setVisible(flag);
	}

	public void handleQuitGame() {
		initialize();
	}
	
	private void initialize() {
		mainLabel.setText("Enter Number of Players");
		nextButton.setText("Okay");
		textField.setVisible(true);
		showJobRadioButtons(false);	
	}
}
