package overWack;

import javax.swing.JFrame;

public class OverWack extends JFrame {
	public OverWack() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Panel());
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle("OverWack");
	}

	public static void main(String[] args) {
		new OverWack();
	}
}
