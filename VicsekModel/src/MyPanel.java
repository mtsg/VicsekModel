import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

class MyPanel extends JPanel implements Runnable {

	// メンバ
	// ボールの位置
	ParticleSet ps = new ParticleSet();
	// 更新間隔
	static double timeStep = 0.01;
	// 余白
	static int margin = 100;

	// コンストラクタ
	public MyPanel() {
		setBackground(Color.white);
		// 10ミリ秒ごとに画面を書き換えるためのおまじない
		Thread refresh = new Thread(this);
		refresh.start();
		ps.setInit();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.translate(margin, margin);

		// アニメーションの1コマ毎の処理をここに書く

		for (Particle p : ps.particleSet) {
			printClosingLine(g);
			paintParticle(g, p);
			paintDirection(g, p);
			paintAreaOfInfluence(g, p);
		}
	}

	// 枠線の描画
	public void printClosingLine(Graphics g) {
		g.drawLine(0, 0, 0, PointSet.PBC);
		g.drawLine(0, 0, PointSet.PBC, 0);
		g.drawLine(0, PointSet.PBC, PointSet.PBC, PointSet.PBC);
		g.drawLine(PointSet.PBC, 0, PointSet.PBC, PointSet.PBC);

	}

	// 半径5の粒子の描画
	public void paintParticle(Graphics g, Particle p) {
		// 座標
		Point2D.Double cp = p.currentPoint.point;
		// 半径
		int radius = 5;
		// 色指定
		g.setColor(Color.RED);
		// 粒子描画
		g.fillOval((int) cp.x - radius, (int) cp.y - radius, radius * 2,
				radius * 2);
	}

	// 粒子の向きの描画
	public void paintDirection(Graphics g, Particle p) {
		// 向き
		double angle = p.currentPoint.theta;
		// 長さ
		int length = 20;

		// 座標
		// 始点
		Point2D.Double startingPoint = p.currentPoint.point;
		// 終点
		Point2D.Double endPoint = new Point2D.Double(length * Math.cos(angle)
				+ startingPoint.x, length * Math.sin(angle) + startingPoint.y);

		// 色指定
		g.setColor(Color.BLUE);
		// 矢印描画
		g.drawLine((int) startingPoint.x, (int) startingPoint.y,
				(int) endPoint.x, (int) endPoint.y);

	}

	// 粒子の影響範囲の描画
	public void paintAreaOfInfluence(Graphics g, Particle p) {
		// 座標
		Point2D.Double cp = p.currentPoint.point;
		// 影響半径
		int area = p.r;

		g.setColor(Color.DARK_GRAY);
		g.drawOval((int) cp.x - area, (int) cp.y - area, area * 2, area * 2);
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