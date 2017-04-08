package frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**
 * Custom JPanel for the stack tab. Contains all controls for the stack manipulation. It links the stack functions the GUI elements.
 * @author Benjamin Wilson
 *
 */
@SuppressWarnings("serial")
public class PaneLayout extends JPanel {

	public PaneLayout() {
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[240.00,grow,fill][168.00][-50.00][640px,grow]", "[20px][60px,grow,fill][60px,grow,fill][][60.00,fill][baseline][31.00px,baseline][60px,grow,fill][108px,grow,fill]"));
		buildLabels();

	}


	private void buildLabels() {
		JLabel lblOperations = new JLabel("Operations");
		lblOperations.setFont(new Font("Courier New", Font.BOLD, 14));
		add(lblOperations, "cell 0 0,alignx center,aligny baseline");

	}
	
	/**
	 * Repaints the container.
	 */
	public void repaintAndValidate() {
		revalidate();
		repaint();
	}
}
