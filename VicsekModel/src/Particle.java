import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Particle {

	// メンバ
	PointSet currentPoint = new PointSet();
	PointSet nextPoint = new PointSet();

	// 固定メンバ
	double PBC = ParticleSet.PBC;
	double v = 600;
	double r = 60;
	double realm = 100;// 向きのノイズの範囲

	// コンストラクタ
	public Particle() {
		setInit();
	}

	// メソッド
	// 初期位置決定
	public void setInit() {
		currentPoint.setLocation(Math.random() * PBC, Math.random() * PBC);
		currentPoint.theta = 0;
	}

	// 位置の更新
	public void update() {
		currentPoint = (PointSet) nextPoint.clone();
		nextPoint.point = new Point2D.Double();
		nextPoint.theta = 0;
	}

	// 次の位置を求める
	public void nextStep(ArrayList<Particle> particleSet) {

		nextPoint.theta = nextTheta(particleSet);
		nextPoint.point.x = currentPoint.point.x + v
				* Math.cos(nextPoint.theta) * MyPanel.timeStep;
		nextPoint.point.y = currentPoint.point.y + v
				* Math.sin(nextPoint.theta) * MyPanel.timeStep;

		// 周期境界条件の反映
		nextPoint.point.x = PBC <= nextPoint.point.x ? (nextPoint.point.x - PBC)
				: nextPoint.point.x;
		nextPoint.point.y = PBC <= nextPoint.point.y ? (nextPoint.point.y - PBC)
				: nextPoint.point.y;

	}

	// thetaを決定する
	public double nextTheta(ArrayList<Particle> particleSet) {
		double thetaSum = 1;
		double thetaMean = this.currentPoint.theta;

		double noise = (Math.random() - 0.5) * realm; // 向きのノイズ

		int num = 0;// r近傍内の粒子の数

		// r近傍にある粒子の向きを合算
		for (Particle particle : particleSet) {
			double distanceNorm = this.currentPoint.point
					.distance(particle.currentPoint.point);
			if (distanceNorm <= r) {
				thetaSum += particle.currentPoint.theta;
				num += 1;
			}
		}

		// 自身も含めたr近傍の粒子たちの向きの平均
		thetaMean = thetaSum / num;

		return (thetaMean + noise);
	}
}
