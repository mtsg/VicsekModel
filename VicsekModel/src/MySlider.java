import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MySlider extends JSlider implements ChangeListener {

	// メンバ
	ParticleSet ps = null;
	JSlider slider1 = new JSlider();
	JSlider slider2 = new JSlider();
	JSlider slider3 = new JSlider();

	// コンストラクタ
	public MySlider(ParticleSet ps) {
		this.ps = ps;
		this.init();
	}

	public void init() {

		slider1.setMajorTickSpacing(10);
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.addChangeListener(this);

		slider2.setLabelTable(slider2.createStandardLabels(20));
		slider2.setPaintLabels(true);
		slider2.addChangeListener(this);

		slider3.setMajorTickSpacing(10);
		slider3.setPaintTicks(true);
		slider3.setLabelTable(slider3.createStandardLabels(20));
		slider3.setPaintLabels(true);
		slider2.addChangeListener(this);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		for (Particle p : ps.particleSet) {
			// p.v = slider1.getValue();
			// p.r = slider2.getValue();
			// p.realm = slider3.getValue();

		}

	}
}
