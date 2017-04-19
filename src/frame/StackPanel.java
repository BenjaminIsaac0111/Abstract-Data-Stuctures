package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import dataStructures.StackGraphics;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.EtchedBorder;

/**
 * Custom JPanel for the stack tab. Contains all controls for the stack manipulation. It links the stack functions the GUI elements.
 * @author Benjamin Wilson
 *
 */
@SuppressWarnings("serial")
public class StackPanel extends PaneLayout {


	StackGraphics stack = new StackGraphics();

	private JTextField newStackItem;
	private JTextPane stackDescriptionPane;

	private JTextPane peekResult;

	public StackPanel() {
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[240.00,grow,fill][168.00][-50.00][640px,grow]", "[20px][60px,grow,fill][60px,grow,fill][][60.00,fill][baseline][31.00px,baseline][60px,grow,fill][108px,grow,fill]"));		
		buildLabels();
		buildButtons();
		buildTextField();
		buildPanels();

	}
	
	 public void buildPanels(){
		 Canvas canvas = new Canvas();
			canvas.setBackground(Color.WHITE);
			canvas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			add(canvas, "cell 3 1 1 7,grow");
			
			stackDescriptionPane = new JTextPane();
			stackDescriptionPane.setBackground(UIManager.getColor("text"));
			stackDescriptionPane.setSelectionColor(Color.WHITE);
			stackDescriptionPane.setEditable(false);
			stackDescriptionPane.setFont(new Font("Courier New", Font.PLAIN, 14));
			stackDescriptionPane.setText(
					"In computer science, a stack is an abstract data type that serves as a collection of elements, with two principal operations: push, which adds an element to the collection, and pop, which removes the most recently added element that was not yet removed. The order in which elements come off a stack gives rise to its alternative name, LIFO (for last in, first out). Additionally, a peek operation may give access to the top without modifying the stack.");
			add(stackDescriptionPane, "cell 0 8 4 1,growx,aligny bottom");
	 }
	 

	private void buildTextField() {
		newStackItem = new JTextField();
		add(newStackItem, "cell 0 6,grow");
		newStackItem.setColumns(10);
	}


	private void buildLabels() {
		JLabel lblResult = new JLabel("Peek result:");
		add(lblResult, "cell 0 3,alignx center");
		
		peekResult = new JTextPane();
		peekResult.setBackground(Color.WHITE);
		peekResult.setEditable(false);
		add(peekResult, "cell 0 4,grow");

		JLabel lblEnterNewStack = new JLabel("Enter new Stack Item:");
		add(lblEnterNewStack, "cell 0 5,growx,aligny center");
	}

	private void buildButtons() {
		JButton btnPop = new JButton("Pop");
		btnPop.addActionListener(pop -> {doPopOperation();});
		add(btnPop, "cell 0 1,grow");

		JButton btnPeek = new JButton("Peek");
		btnPeek.addActionListener(peek -> {doPeekOperation();});
		add(btnPeek, "cell 0 2,grow");
		
		JButton btnPush = new JButton("Push");
		btnPush.addActionListener(push -> {doPushOperation();});
		add(btnPush, "cell 0 7,grow");
	}

	 class Canvas extends JPanel {
	      @Override
	      public void paintComponent(Graphics g) {
	         super.paintComponent(g);
	         stack.paint(g);
	      }
	}
	 
	
	/**
	 * Assigned to the Pop button. Calls the pop function.
	 */
	private void doPopOperation() {
		repaintAndValidate();
		if(!stack.pop()){
			JOptionPane.showMessageDialog(this, "Empty Stack. Nothing to Pop!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Assigned to the Push button. Calls the Push function.
	 */
	private void doPushOperation() {
		if (!newStackItem.getText().isEmpty()) {
			stack.push(newStackItem.getText());
			repaintAndValidate();
		} else {
			JOptionPane.showMessageDialog(this, "Empty Text Field!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Assigned to the Peek button. Calls the Peek function.
	 */
	private void doPeekOperation() {
		if(stack.peek() == null){
			JOptionPane.showMessageDialog(this, "Empty Stack. Nothing to Peek!", "Error", JOptionPane.ERROR_MESSAGE);
		}else{
			peekResult.setText(stack.peek());
		}
	}

	
	


}
