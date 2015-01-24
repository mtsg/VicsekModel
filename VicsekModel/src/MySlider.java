import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MySlider extends JSlider implements ChangeListener {

	// メンバ
	JSlider vSlider = new JSlider(30, 900, 300);
	JSlider rSlider = new JSlider(1, 100, 30);
	JSlider realmSlider = new JSlider(0, 360, 2);

	// コンストラクタ
	public MySlider() {
		this.vInit();
		this.rInit();
		this.realmInit();
	}

	public void vInit() {
		vSlider.setMajorTickSpacing(150);
		vSlider.setPaintTicks(true);
		vSlider.setPaintLabels(true);
		vSlider.addChangeListener(this);

	}

	public void rInit() {
		rSlider.setMajorTickSpacing(20);
		rSlider.setPaintTicks(true);
		rSlider.setPaintLabels(true);
		rSlider.addChangeListener(this);

	}

	public void realmInit() {

		realmSlider.setMajorTickSpacing(60);
		realmSlider.setPaintTicks(true);
		realmSlider.setPaintLabels(true);
		realmSlider.addChangeListener(this);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		for (Particle p : getPS().particleSet) {
			p.v = vSlider.getValue();
			p.r = rSlider.getValue();
			p.realm = realmSlider.getValue();

		}

	}

	// ParticleSetの取得
	public ParticleSet getPS() {
		return BasePanel.ps;
	}

}
