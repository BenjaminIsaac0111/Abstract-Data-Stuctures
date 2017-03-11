package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class driver extends JFrame {

	private static final long serialVersionUID = 5110101609411824810L;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					driver frame = new driver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public driver() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);

		buildTabs();
	}

	private void buildTabs() {

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

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
