import javax.swing.JFrame;

public class BasicPanel {

	// メンバ
	static ParticleSet ps = new ParticleSet(); // 粒子セット
	static JFrame frame = new JFrame();// フレーム

	// フレーム要素
	static MyPanel panel = new MyPanel(ps);
	static MySlider mSlider = new MySlider(ps);

	public static void main(String[] args) {

		// フレームに要素をつめていく
		frame.setTitle("Vicsek Model");
		frame.setSize(ParticleParameter.PBC + 2 * MyPanel.margin + 300, ParticleParameter.PBC + 2
				* MyPanel.margin);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// frame.getContentPane().setLayout(new GridLayout(0, 2));
		frame.getContentPane().add(panel);
		panel.add(mSlider.slider1);
		panel.add(mSlider.slider2);
		panel.add(mSlider.slider3);

		frame.setVisible(true);
	}

}