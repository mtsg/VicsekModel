import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JApplet;

public class PrintVoids extends JApplet implements Runnable {

	// メンバ
	int w = ParticleSet.PBC;
	int h = ParticleSet.PBC;
	double x;
	private double xy[];
	ArrayList<PointSet> placeSet;
	private Thread t;

	// コンストラクタ
	public PrintVoids(ArrayList<Particle> particleSet) {
		for (Particle p : particleSet) {
			placeSet.add(p.currentPoint);
		}

	}

	public PrintVoids() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void init() {
		x = 0;
		w = getWidth();
		h = getHeight();
		t = new Thread(this);
		t.start();
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.WHITE);
		g2.setColor(Color.BLUE);
		g.clearRect(0, 0, w, h);
		g.fillOval((int) x, (int) x, 30, 30);
	}

	public void run() {
		while (t != null) {
			try {
				Thread.sleep(10);
				x += 1;

				x = w <= x ? 0 : x;
				repaint();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}