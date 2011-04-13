package view.game;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends JFrame {	
	
	public Game() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Stock Market Game");
		this.setResizable(false);
		this.setSize(100, 100);
	}
	
}
