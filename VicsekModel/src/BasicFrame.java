import javax.swing.JFrame;

public class BasicFrame extends JFrame {

	// メンバ
	ParticleSet ps = new ParticleSet(); // 粒子セット

	public BasicFrame() {
		// フレームに要素をつめていく
		this.setTitle("Vicsek Model");
		this.setSize(ParticleCoordinate.PBC + 2 * DrawingPanel.margin + 300,
				ParticleCoordinate.PBC + 2 * DrawingPanel.margin);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// コンポーネント準備
		BasePanel basePanel = new BasePanel();// ベースパネル
		DrawingPanel myPanel = new DrawingPanel(ps);// 粒子のモーション表示パネル
		SliderPanel slidPanel = new SliderPanel(ps);// スライダー表示パネル

		basePanel.add(myPanel);
		basePanel.add(slidPanel);

		this.add(basePanel);

	}

	public static void main(String[] args) {

		new BasicFrame().setVisible(true);
	}

}