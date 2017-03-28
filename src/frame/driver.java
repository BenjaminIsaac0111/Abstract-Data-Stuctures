package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;

/**
 * Start point of the program. It handles Tabs and the Top level container.
 * @author Benjamin Wilson
 *
 */
public class driver extends JFrame {

	private static final long serialVersionUID = 5110101609411824810L;



	public static void main(String[] args) {
		//Invoke later so there are no thread conflicts when redrawing.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					driver frame = new driver();//build self.
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public driver() {
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);

		buildTabs();
	}
	/**
	 * Adds tabs to the container. 
	 */
	private void buildTabs() {
		getContentPane().setLayout(new MigLayout("", "[704px,grow]", "[441px,grow]"));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "cell 0 0,grow");

		StackPanel Stack = new StackPanel();
		tabbedPane.addTab("Stack", null, Stack, null);

		StackPanel Queue = new StackPanel();
		tabbedPane.addTab("Queue", null, Queue, null);

		StackPanel List = new StackPanel();
		tabbedPane.addTab("List", null, List, null);

		StackPanel Set = new StackPanel();
		tabbedPane.addTab("Set", null, Set, null);

		StackPanel Tree = new StackPanel();
		tabbedPane.addTab("Tree", null, Tree, null);
		
	}
}
