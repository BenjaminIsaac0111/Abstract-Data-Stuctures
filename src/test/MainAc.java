//package test;
//
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//
//public class MainAc extends JFrame {
//
///**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//public static void main(String[] args) {
//    new MainAc();
//}
//
//public MainAc() {
//    super("Class Paint");       
//    setSize(800, 600);    
//    setLayout(null);
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    
//    setVisible(true);
//}
//
//public void paint(Graphics g) {
//    super.paint(g);
//    g.drawString("Hello", 200, 50);
//}
////
////}new ActionListener() {
////	public void actionPerformed(ActionEvent arg0) {
////	clicked = true;
////	repaint();
////	}