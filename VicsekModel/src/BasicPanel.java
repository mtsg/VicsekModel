import javax.swing.JFrame;

public class BasicPanel {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setTitle("Basic Panel");
		frame.setSize(PointSet.PBC + 2 * MyPanel.margin+300, PointSet.PBC + 2
				* MyPanel.margin);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyPanel panel = new MyPanel();
		frame.getContentPane().add(panel);

		frame.setVisible(true);
	}
}