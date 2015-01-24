import javax.swing.JFrame;

public class BasicFrame extends JFrame {

	// メンバ
	BasePanel basePanel = new BasePanel();// ベースパネル

	public BasicFrame() {
		// フレームに要素をつめていく
		this.setTitle("Vicsek Model");
		this.setSize(ParticleCoordinate.PBC + 2 * DrawingPanel.margin + 300,
				ParticleCoordinate.PBC + 2 * DrawingPanel.margin);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		this.add(basePanel);

	}

	public static void main(String[] args) {

		new BasicFrame().setVisible(true);
	}

}