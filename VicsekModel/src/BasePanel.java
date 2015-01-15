import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BasePanel extends JPanel {

	public BasePanel() {
		BoxLayout boxlayout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(boxlayout);

	}

}
