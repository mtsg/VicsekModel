import javax.swing.JFrame;

public class BasicPanel {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setTitle("Basic Panel");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyPanel panel = new MyPanel();
		frame.getContentPane().add(panel);

		frame.setVisible(true);
	}
}