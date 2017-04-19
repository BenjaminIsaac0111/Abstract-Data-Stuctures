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

import dataStructures.QueueGraphics;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class QueuePanel extends PaneLayout {
	QueueGraphics queue = new QueueGraphics();

	private JTextField newQueueItem;
	private JTextPane queueDescriptionPane;

	private JTextPane peekResult;

	public QueuePanel() {
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
			queueDescriptionPane.setText("In computer science, a queue is a particular kind of abstract data type or collection in which the entities in the collection are kept in order and the principal (or only) operations on the collection are the addition of entities to the rear terminal position, known as enqueue, and removal of entities from the front terminal position, known as dequeue. This makes the queue a First-In-First-Out (FIFO) data structure. In a FIFO data structure, the first element added to the queue will be the first one to be removed. This is equivalent to the requirement that once a new element is added, all elements that were added before have to be removed before the new element can be removed. Often a peek or front operation is also entered, returning the value of the front element without dequeuing it. A queue is an example of a linear data structure, or more abstractly a sequential collection.");
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
	         queue.paint(g);
	      }
	}
	 
	/**
	 * Removes item.
	 */
	private void doPopOperation() {
		repaintAndValidate();
		if(!queue.remove()){
			JOptionPane.showMessageDialog(this, "Empty queue. Nothing to Pop!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Assigned to the Push button. Calls the Push function.
	 */
	private void doPushOperation() {
		if (!newQueueItem.getText().isEmpty()) {
			queue.push(newQueueItem.getText());
			repaintAndValidate();
		} else {
			JOptionPane.showMessageDialog(this, "Empty Text Field!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Assigned to the Peek button. Calls the Peek function.
	 */
	private void doPeekOperation() {
		if(queue.peek() == null){
			JOptionPane.showMessageDialog(this, "Empty queue. Nothing to Peek!", "Error", JOptionPane.ERROR_MESSAGE);
		}else{
			peekResult.setText(queue.peek());
		}
	}
}
