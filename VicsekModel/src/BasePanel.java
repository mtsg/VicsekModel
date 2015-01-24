import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BasePanel extends JPanel {

	// コンポーネント準備
	public static ParticleSet ps = new ParticleSet(); // 粒子セット
	DrawingPanel drawingPanel = new DrawingPanel();// 粒子のモーション表示パネル
	SliderPanel sliderPanel = new SliderPanel();// スライダー表示パネル

	public BasePanel() {
		BoxLayout boxlayout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(boxlayout);

		this.add(drawingPanel);
		this.add(sliderPanel);

	}

	ParticleSet getParticleSet(ParticleSet ps) {
		return ps;
	}

}
