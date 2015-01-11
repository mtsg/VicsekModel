import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class MyPanel extends JPanel implements Runnable {

	// ボールの位置
	ParticleSet ps = new ParticleSet();

	// 更新間隔
	static double timeStep = 0.01;

	public MyPanel() {
		setBackground(Color.white);
		// 10ミリ秒ごとに画面を書き換えるためのおまじない
		Thread refresh = new Thread(this);
		refresh.start();
		ps.setInit();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// アニメーションの1コマ毎の処理をここに書く

		g.setColor(Color.black);
		for (Particle p : ps.particleSet) {
			g.fillArc((int) p.currentPoint.point.x,
					(int) p.currentPoint.point.y, 30, 30,
					(int) p.currentPoint.theta, 100);
		}
	}

	// 10ミリ秒毎に画面を書き換える
	@Override
	public void run() {
		while (true) {
			repaint();
			try {
				ps.nextPosition();
				ps.update();
				Thread.sleep((int) (timeStep * 1000));
			} catch (Exception e) {
			}
		}

	}
}