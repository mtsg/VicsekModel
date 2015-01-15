import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MySlider extends JSlider implements ChangeListener {

	// メンバ
	ParticleSet ps = null;
	JSlider vSlider = new JSlider(30, 900, 300);
	JSlider rSlider = new JSlider(1, 100, 30);
	JSlider realmSlider = new JSlider(0, 360, 2);

	// コンストラクタ
	public MySlider(ParticleSet ps) {
		this.ps = ps;
		this.vInit();
		this.rInit();
		this.realmInit();
	}

	public void vInit() {
		vSlider.setMajorTickSpacing(20);
		vSlider.setPaintTicks(true);
		vSlider.setPaintLabels(true);
		vSlider.addChangeListener(this);

	}

	public void rInit() {
		rSlider.setLabelTable(rSlider.createStandardLabels(20));
		rSlider.setPaintTicks(true);
		rSlider.setPaintLabels(true);
		rSlider.addChangeListener(this);

	}

	public void realmInit() {

		realmSlider.setMajorTickSpacing(20);
		realmSlider.setPaintTicks(true);
		realmSlider.setPaintLabels(true);
		realmSlider.addChangeListener(this);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		for (Particle p : ps.particleSet) {
			p.v = vSlider.getValue();
			p.r = rSlider.getValue();
			p.realm = realmSlider.getValue();

		}

	}
}
