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

import dataStructures.MyBinaryTree;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.EtchedBorder;

/**
 * Custom JPanel for the stack tab. Contains all controls for the stack
 * manipulation. It links the stack functions the GUI elements.
 * 
 * @author Benjamin Wilson
 *
 */
@SuppressWarnings("serial")
public class TreePanel extends PaneLayout {

	MyBinaryTree<String> tree = new MyBinaryTree<String>();

	private JTextField newItem;
	private JTextPane stackDescriptionPane;

	private JTextPane peekResult;

	class Canvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//tree.paint(g);
		}
	}

	public TreePanel() {
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[240.00,fill][660.00px,grow]",
				"[20px][60px,grow,fill][60px,grow,fill][56.00,grow,fill][8.00,fill][baseline][22.00px,baseline][42.00px,fill][108px,grow,fill]"));
		buildLabels();
		buildButtons();
		buildPanels();

	}

	public void buildPanels() {
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(canvas, "cell 1 1 1 7,grow");
		newItem = new JTextField();
		add(newItem, "cell 0 7,grow");
		newItem.setColumns(10);

		stackDescriptionPane = new JTextPane();
		stackDescriptionPane.setBackground(UIManager.getColor("text"));
		stackDescriptionPane.setSelectionColor(Color.WHITE);
		stackDescriptionPane.setEditable(false);
		stackDescriptionPane.setFont(new Font("Courier New", Font.PLAIN, 14));
		stackDescriptionPane.setText(
				"In computer science, a binary tree is a tree data structure in which each node has at most two children, which are referred to as the left child and the right child. A recursive definition using just set theory notions is that a (non-empty) binary tree is a triple (L, S, R), where L and R are binary trees or the empty set and S is a singleton set. Some authors allow the binary tree to be the empty set as well.");
		add(stackDescriptionPane, "cell 0 8 4 1,growx,aligny bottom");
	}

	private void buildLabels() {

		JLabel lblItem = new JLabel("Item:");
		add(lblItem, "cell 0 6,growx,aligny center");
		
		JLabel lblResult = new JLabel("Found result:");
		add(lblResult, "cell 0 4,alignx center");
	}

	private void buildButtons() {
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(Find -> {
			doFindOperation();
		});
		add(btnFind, "cell 0 3,grow");

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(Insert -> {
			doInsertOperation();
		});
		add(btnInsert, "cell 0 1,grow");

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(Delete -> {
			doDeleteOperation();
		});
		add(btnDelete, "cell 0 2,grow");

		peekResult = new JTextPane();
		peekResult.setBackground(Color.WHITE);
		peekResult.setEditable(false);
		add(peekResult, "cell 0 5,grow");


	}

	/**
	 * Assigned to the Insert button. Calls the Insert function.
	 */
	private void doInsertOperation() {
		repaintAndValidate();
		if (true) {
			JOptionPane.showMessageDialog(this, "Empty Field . Nothing to Pop!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		//tree.delete(element);
	}

	/**
	 * Assigned to the Delete button. Calls the Delete function.
	 */
	private void doDeleteOperation() {
		if (!newItem.getText().isEmpty()) {
			tree.addNode(1, newItem.getText());
			repaintAndValidate();
		} else {
			JOptionPane.showMessageDialog(this, "Empty Text Field!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Assigned to the Find button. Calls the Find function.
	 */
	private void doFindOperation() {
//		if (tree.find() == null) {
//			JOptionPane.showMessageDialog(this, "Empty Tree. Nothing to Peek!", "Error", JOptionPane.ERROR_MESSAGE);
//		} else {
//			peekResult.setText(tree.peek());
//		}
	}

}
