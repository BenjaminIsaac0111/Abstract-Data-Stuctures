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

import dataStructures.SetGraphics;
import net.miginfocom.swing.MigLayout;

public class SetsPanel extends PaneLayout {
	
	private static final long serialVersionUID = 1L;

	SetGraphics set = new SetGraphics();

	private JTextField item;
	private JTextPane queueDescriptionPane;

	public SetsPanel() {
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[240.00,grow,fill][168.00][-50.00][640px,grow]", "[20px][27.00px,fill][16.00px,fill][grow][39.00,grow,fill][grow,baseline][108px,grow,fill]"));		
		buildLabels();
		buildButtons();
		buildTextField();
		buildPanels();

	}
	
	 public void buildPanels(){
		 Canvas canvas = new Canvas();
			canvas.setBackground(Color.WHITE);
			canvas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			add(canvas, "cell 3 1 1 5,grow");
			
			queueDescriptionPane = new JTextPane();
			queueDescriptionPane.setBackground(UIManager.getColor("text"));
			queueDescriptionPane.setSelectionColor(Color.WHITE);
			queueDescriptionPane.setEditable(false);
			queueDescriptionPane.setFont(new Font("Courier New", Font.PLAIN, 14));
			queueDescriptionPane.setText("In computer science, a set is an abstract data type that can store certain values, without any particular order, and no repeated values. It is a computer implementation of the mathematical concept of a finite set. Unlike most other collection types, rather than retrieving a specific element from a set, one typically tests a value for membership in a set.");
			add(queueDescriptionPane, "cell 0 6 4 1,growx,aligny bottom");
			
	 }
	 

	private void buildTextField() {
		item = new JTextField();
		add(item, "cell 0 2,growx,aligny top");
		item.setColumns(10);
	}


	private void buildLabels() {
				
		JLabel lblEnterNewqueue = new JLabel("Item:");
		lblEnterNewqueue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblEnterNewqueue, "cell 0 1,growx,aligny center");
		
		
	}

	private void buildButtons() {
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(remove -> {doRemoveOperation();});
		add(btnRemove, "cell 0 4,grow");
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(push -> {doAddOperation();});
		add(btnAdd, "cell 0 3,grow");
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(push -> {doClearOperation();});
		add(btnClear, "cell 0 5,grow");
	}
	 
	/**
	 * Assigned to the Add button. Calls the additive function.
	 */
	private void doAddOperation() {
		
		if (set.add(item.getText())) {
			repaintAndValidate();
		} else {
			JOptionPane.showMessageDialog(this, "Item already in the Set!", "Warning", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Removes item from the set.
	 */
	private void doRemoveOperation() {		
		if(set.remove(item.getText())){		
			repaintAndValidate();
		}else{
			JOptionPane.showMessageDialog(this, "Empty Text Field. !", "Warning", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Assigned to the Clears button. Calls the Clear function.
	 */
	private void doClearOperation() {
		if(set.getSize() != 0){
			set.clear();
			set.setGraphicsCoordinates(240 ,480);
			repaintAndValidate();
			
		}else{
			JOptionPane.showMessageDialog(this, "Empty queue. Nothing to Clear!", "Warning", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	 @SuppressWarnings("serial")
	class Canvas extends JPanel {
	      @Override
	      public void paintComponent(Graphics g) {
	         super.paintComponent(g);
	         set.paint(g);
	      }
	}
}
