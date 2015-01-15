import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class SliderPanel extends JPanel {

	public SliderPanel(ParticleSet ps) {

		MySlider mySlider = new MySlider(ps);

		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxLayout);

		mySlider.vSlider.setMaximumSize(new Dimension(300, 50));
		mySlider.rSlider.setMaximumSize(new Dimension(300, 50));
		mySlider.realmSlider.setMaximumSize(new Dimension(300, 50));
		this.add(mySlider.vSlider);
		this.add(mySlider.rSlider);
		this.add(mySlider.realmSlider);
	}

}
