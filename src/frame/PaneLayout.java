package frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

public abstract class PaneLayout extends JPanel {

	private JTextField textField;

	
	private static final long serialVersionUID = -4333944189574196041L;
	
	public PaneLayout(){
		setLayout(new MigLayout("", "[240.00,grow,fill][168.00][-50.00][640px,grow]", "[20px][60px,grow,fill][60px,grow,fill][][60.00,fill][baseline][31.00px,baseline][60px,grow,fill][108px,grow,fill]"));
		
		JLabel lblOperations = new JLabel("Operations");
		lblOperations.setFont(new Font("Courier New", Font.BOLD, 14));
		add(lblOperations, "cell 0 0,alignx center,aligny baseline");
		
		buildButtons();
		
		JLabel lblResult = new JLabel("Peek result:");
		add(lblResult, "cell 0 3,alignx center");
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		add(textField, "cell 0 4,grow");
		textField.setColumns(10);
		
		JLabel lblEnterNewStack = new JLabel("Enter new Stack Item:");
		add(lblEnterNewStack, "cell 0 5,growx,aligny center");
		
//		newStackItem = new JTextField();
//		add(newStackItem, "cell 0 6,grow");
//		newStackItem.setColumns(10);
		
		
		

		
		JTextPane stackDescriptionPane = new JTextPane();
		stackDescriptionPane.setBackground(UIManager.getColor("text"));
		stackDescriptionPane.setSelectionColor(Color.WHITE);
		stackDescriptionPane.setEditable(false);
		stackDescriptionPane.setFont(new Font("Courier New", Font.PLAIN, 14));
		stackDescriptionPane.setText("In computer science, a stack is an abstract data type that serves as a collection of elements, with two principal operations: push, which adds an element to the collection, and pop, which removes the most recently added element that was not yet removed. The order in which elements come off a stack gives rise to its alternative name, LIFO (for last in, first out). Additionally, a peek operation may give access to the top without modifying the stack.");
		add(stackDescriptionPane, "cell 0 8 4 1,growx,aligny bottom");
	}

	protected void buildButtons() {
		
		JButton btnPop = new JButton("Pop");
		btnPop.addActionListener(print -> {
		});
		add(btnPop, "cell 0 1,grow");
		
		JButton btnPeek = new JButton("Peek");
		btnPeek.addActionListener(print -> {
		});
		add(btnPeek, "cell 0 2,grow");
		
		JButton btnPush = new JButton("Push");
		btnPush.addActionListener(push -> {});
		add(btnPush, "cell 0 7,grow");
	}

}
