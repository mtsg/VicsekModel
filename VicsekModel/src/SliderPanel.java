import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class SliderPanel extends JPanel {

	MyLabel myLabel = null;
	MySlider mySlider = null;

	public SliderPanel() {

		myLabel = new MyLabel();
		mySlider = new MySlider();

		BoxLayout verticalBox = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(verticalBox);

		mySlider.vSlider.setMaximumSize(new Dimension(300, 50));
		mySlider.rSlider.setMaximumSize(new Dimension(300, 50));
		mySlider.realmSlider.setMaximumSize(new Dimension(300, 50));
		this.add(myLabel.vLabel);
		this.add(mySlider.vSlider);
		this.add(myLabel.rLabel);
		this.add(mySlider.rSlider);
		this.add(myLabel.realmLabel);
		this.add(mySlider.realmSlider);
	}

}
