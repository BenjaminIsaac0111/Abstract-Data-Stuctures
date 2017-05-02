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

import dataStructures.ListGraphics;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.EtchedBorder;

/**
 * Custom JPanel for the List tab. Contains all controls for the List
 * manipulation. It links the List functions the GUI elements.
 * 
 * @author Benjamin Wilson
 *
 */
@SuppressWarnings("serial")
public class ListPanel extends PaneLayout {

	ListGraphics List = new ListGraphics();

	private JTextField newListItem;
	private JTextPane ListDescriptionPane;
	private JTextField itemIndex;
	private JTextField getResult;

	class Canvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			List.paint(g);
		}
	}

	public ListPanel() {
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[100.00,fill][55.00,fill][100,fill]",
				"[20px][60.00px,grow,fill][60.00px,grow,fill][60.00,grow,fill][60.00,grow,fill][][60.00][baseline][31.00px,baseline][108px,grow,fill]"));
		buildLabels();
		buildButtons();
		buildTextField();
		buildPanels();

	}

	public void buildPanels() {
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(canvas, "cell 2 1 1 8,grow");

		ListDescriptionPane = new JTextPane();
		ListDescriptionPane.setBackground(UIManager.getColor("text"));
		ListDescriptionPane.setSelectionColor(Color.WHITE);
		ListDescriptionPane.setEditable(false);
		ListDescriptionPane.setFont(new Font("Courier New", Font.PLAIN, 14));
		ListDescriptionPane.setText(
				"In computer science, a List is an abstract data type that serves as a collection of elements, with two principal operations: push, which adds an element to the collection, and pop, which removes the most recently added element that was not yet removed. The order in which elements come off a List gives rise to its alternative name, LIFO (for last in, first out). Additionally, a peek operation may give access to the top without modifying the List.");
		add(ListDescriptionPane, "cell 0 9 3 1,growx,aligny bottom");
	}

	private void buildTextField() {
		itemIndex = new JTextField();
		itemIndex.setColumns(10);
		add(itemIndex, "cell 1 6,grow");

		getResult = new JTextField();
		getResult.setColumns(10);
		add(getResult, "cell 0 8 2 1,growx");

		newListItem = new JTextField();
		add(newListItem, "cell 0 6,grow");
		newListItem.setColumns(10);
	}

	private void buildLabels() {

		JLabel lblIndex = new JLabel("Index");
		add(lblIndex, "cell 1 5,growx");

		JLabel lblItem = new JLabel("Item");
		add(lblItem, "cell 0 5,growx");

		JLabel lblGetResult = new JLabel("Get result:");
		add(lblGetResult, "cell 0 7 2 1,grow");
	}

	private void buildButtons() {

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(add -> {
			doAddOperation();
			repaintGraphics();
		});
		add(btnAdd, "cell 0 1,grow");

		JButton btnAddAtIndex = new JButton("Add At Index");
		btnAddAtIndex.addActionListener(AddAtIndex -> {
			doAddAtIndexOperation();
			repaintGraphics();

		});
		add(btnAddAtIndex, "cell 1 1,grow");

		JButton btnRemoveByName = new JButton("Remove By Name");
		btnRemoveByName.addActionListener(removeByName -> {
			doRemoveByNameOperation();
			repaintGraphics();

		});
		add(btnRemoveByName, "cell 0 2,grow");

		JButton btnRemoveByIndex = new JButton("Remove By Index");
		btnRemoveByIndex.addActionListener(removeByIndex -> {
			doRemoveByIndexOperation();
			repaintGraphics();

		});
		add(btnRemoveByIndex, "cell 1 2,grow");

		JButton btnGet = new JButton("Get");
		btnGet.addActionListener(get -> {
			doGetOperation();
			repaintGraphics();

		});
		add(btnGet, "cell 0 3,grow");

		JButton btnSet = new JButton("Set");
		btnSet.addActionListener(set -> {
			doSetOperation();
			repaintGraphics();

		});
		add(btnSet, "cell 1 3,grow");

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(clear -> {
			List.clear();
			repaintGraphics();

		});
		add(btnClear, "cell 0 4 2 1,grow");

	}

	private void repaintGraphics() {
		repaintAndValidate();
	}

	private void doAddOperation() {
		String element = newListItem.getText();
		try {
			if (!element.isEmpty()) {
				List.add(element);
			}else{
				JOptionPane.showMessageDialog(this, "Invalid Item. Cannot Add!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "No Item In Text Field!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void doAddAtIndexOperation() {
		try {
			List.add(parseIndex(), newListItem.getText());
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(this, "Invalid index. Cannot Add!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void doGetOperation() {
		try {
			if (List.get(parseIndex()) != null) {
				getResult.setText(List.get(parseIndex()));
			} else {
				JOptionPane.showMessageDialog(this, "Invalid index. Cannot Get!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(this, "Index is Out of Bounds!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void doSetOperation() {
		try {
			List.set(parseIndex(), newListItem.getText());
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Nothing to set!", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(this, "Invalid Index. Nothing to set!", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void doRemoveByNameOperation() {
		if (!List.remove(newListItem.getText())) {
			JOptionPane.showMessageDialog(this, "Invalid Name. Nothing to Remove!", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void doRemoveByIndexOperation() {
		try {
			List.remove(parseIndex());
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(this, "Invalid index. Nothing to Remove!", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	private int parseIndex() {
		try {
			return Integer.parseInt(itemIndex.getText());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

}
