package reference.material;
import java.awt.*;import java.awt.event.*;import javax.swing.*;
/* GridGUI demonstrates separation of functionality
   from GUI design by using MVC architecture */

// first comes the root class that builds the architecture
public class GridGUI
{
  public static void main(String args[])
  {
    GridGUIModel model=new GridGUIModel();
    GridGUIView view=new GridGUIView("GridGUI MVC Demo");
    GridGUIController controller=new GridGUIController(model,view);
  }
}

// Model contains the functionality (properties and methods)
class GridGUIModel
{
  public void exit() {System.exit(0);}
  public void run()
  {
    JOptionPane.showMessageDialog(null,"I hear you!",
    "Message Dialog",JOptionPane.PLAIN_MESSAGE);
  }
}

// View is where the GUI is built
class GridGUIView extends JFrame
{
  JButton run=new JButton("Run the Utility");
  JButton exit=new JButton("Exit After Save");
  JPanel buttons=new JPanel();
  GridGUIView(String title) // the constructor
  {
    super(title);setBounds(100,100,250,150);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    buttons.setLayout(new GridLayout(4,1,2,2));
    buttons.add(run);buttons.add(exit);
    this.getContentPane().add("Center",buttons);
    setVisible(true);
  }
  //method to add ActionListener passed by Controller to buttons
  public void buttonActionListeners(ActionListener al)
  {
   run.setActionCommand("run");run.addActionListener(al);
   exit.setActionCommand("exit");exit.addActionListener(al);
  }
}

// the controller listens for actions and reacts
class GridGUIController implements  ActionListener
{
  GridGUIModel model; GridGUIView view;
  public GridGUIController(GridGUIModel model,GridGUIView view)
  {
    // create the model and the GUI view
    this.model=model;this.view=view;
    // Add action listener from this class to view buttons
    view.buttonActionListeners(this);
  }
  // Provide interactions for actions performed in the view
  public void actionPerformed(ActionEvent ae)
  {
    String action_com=ae.getActionCommand();
    char c=action_com.charAt(0);switch(c)
    {
    case 'r':model.run();break;
    case 'e':model.exit();break;
    }
  }
}