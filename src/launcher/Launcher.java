package launcher;

import javax.swing.SwingUtilities;

import view.menu.Menu;


import model.Model;

import controller.Controller;

public class Launcher {

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	Model model = new Model();
	            	Menu view = new Menu();
	            	new Controller(model, view);
	            }
	        });
	}
}
