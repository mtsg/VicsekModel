import java.util.ArrayList;

public class Particle {

	// メンバ
	ParticleParameter currentPoint = new ParticleParameter();
	ParticleParameter nextPoint = new ParticleParameter();

	// 固定メンバ
	double v = 300;
	int r = 30;
	double realm = 2;// 向きのノイズの範囲

	// コンストラクタ
	public Particle() {
		setInit();
	}

	// メソッド
	// 初期位置決定
	public void setInit() {
		currentPoint.setLocation(Math.random() * ParticleParameter.PBC, Math.random()
				* ParticleParameter.PBC);
		currentPoint.theta = 0;
	}

	// 位置の更新
	public void update() {
		// currentPoint.point.x = nextPoint.getX();
		// currentPoint.point.y = nextPoint.getY();
		// currentPoint.theta = nextPoint.theta;
		currentPoint.setLocation(nextPoint);
		nextPoint = new ParticleParameter();
	}

	// 次の位置を求める
	public void nextPosition(ArrayList<Particle> particleSet) {

		nextPoint.theta = nextTheta(particleSet);
		nextPoint.point.x = currentPoint.point.x + v
				* Math.cos(nextPoint.theta) * MyPanel.timeStep;
		nextPoint.point.y = currentPoint.point.y + v
				* Math.sin(nextPoint.theta) * MyPanel.timeStep;

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
