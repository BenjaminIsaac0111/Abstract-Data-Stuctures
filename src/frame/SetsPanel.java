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
import javax.swing.border.EtchedBorder;

import dataStructures.MySet;
import dataStructures.QueueGraphics;
import frame.QueuePanel.Canvas;
import net.miginfocom.swing.MigLayout;

public class SetsPanel extends PaneLayout {
	
	private static final long serialVersionUID = 1L;

	MySet<String> set = new MySet<String>();

	private JTextField newQueueItem;
	private JTextPane queueDescriptionPane;

	private JTextPane peekResult;

	public SetsPanel() {
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
			
			queueDescriptionPane = new JTextPane();
			queueDescriptionPane.setBackground(UIManager.getColor("text"));
			queueDescriptionPane.setSelectionColor(Color.WHITE);
			queueDescriptionPane.setEditable(false);
			queueDescriptionPane.setFont(new Font("Courier New", Font.PLAIN, 14));
			queueDescriptionPane.setText("In computer science, a set is an abstract data type that can store certain values, without any particular order, and no repeated values. It is a computer implementation of the mathematical concept of a finite set. Unlike most other collection types, rather than retrieving a specific element from a set, one typically tests a value for membership in a set.");
			add(queueDescriptionPane, "cell 0 8 4 1,growx,aligny bottom");
	 }
	 

	private void buildTextField() {
		newQueueItem = new JTextField();
		add(newQueueItem, "cell 0 6,grow");
		newQueueItem.setColumns(10);
	}


	private void buildLabels() {
		JLabel lblResult = new JLabel("Peek result:");
		add(lblResult, "cell 0 3,alignx center");
		
		peekResult = new JTextPane();
		peekResult.setBackground(Color.WHITE);
		peekResult.setEditable(false);
		add(peekResult, "cell 0 4,grow");

		JLabel lblEnterNewqueue = new JLabel("Enter new queue Item:");
		add(lblEnterNewqueue, "cell 0 5,growx,aligny center");
	}

	private void buildButtons() {
		JButton btnPop = new JButton("Remove");
		btnPop.addActionListener(remove -> {doPopOperation();});
		add(btnPop, "cell 0 1,grow");

		JButton btnPeek = new JButton("Peek");
		btnPeek.addActionListener(peek -> {doPeekOperation();});
		add(btnPeek, "cell 0 2,grow");
		
		JButton btnPush = new JButton("add");
		btnPush.addActionListener(push -> {doPushOperation();});
		add(btnPush, "cell 0 7,grow");
	}

	 class Canvas extends JPanel {
	      @Override
	      public void paintComponent(Graphics g) {
	         super.paintComponent(g);
	         //set.paint(g);
	      }
	}
	 
	/**
	 * Removes item.
	 */
	private void doPopOperation() {
		repaintAndValidate();
		if(!set.remove()){
			JOptionPane.showMessageDialog(this, "Empty queue. Nothing to Pop!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Assigned to the Push button. Calls the Push function.
	 */
	private void doPushOperation() {
		if (!newQueueItem.getText().isEmpty()) {
			set.push(newQueueItem.getText());
			repaintAndValidate();
		} else {
			JOptionPane.showMessageDialog(this, "Empty Text Field!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Assigned to the Peek button. Calls the Peek function.
	 */
	private void doPeekOperation() {
		if(set.peek() == null){
			JOptionPane.showMessageDialog(this, "Empty queue. Nothing to Peek!", "Error", JOptionPane.ERROR_MESSAGE);
		}else{
			peekResult.setText(queue.peek());
		}
	}
}
