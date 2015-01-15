import java.util.ArrayList;
import java.util.Random;

public class Particle {

	// メンバ
	ParticleCoordinate currentPoint = new ParticleCoordinate();
	ParticleCoordinate nextPoint = new ParticleCoordinate();

	// 固定メンバ
	int v = 300;
	int r = 30;
	int realm = 2;// 向きのノイズの範囲

	// コンストラクタ
	public Particle() {
		setInit();
	}

	// メソッド
	// 初期位置決定
	public void setInit() {
		currentPoint.setLocation(Math.random() * ParticleCoordinate.PBC,
				Math.random() * ParticleCoordinate.PBC);
		currentPoint.theta = 0;
	}

	// 位置の更新
	public void update() {
		currentPoint.setLocation(nextPoint);
		nextPoint = new ParticleCoordinate();
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
		int num = 1;// r近傍内の粒子の数
		double thetaSum = this.currentPoint.theta;// r近傍内の粒子の向きの総和(ラジアン)
		double thetaMean = this.currentPoint.theta;// 向きの平均(ラジアン)

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

		/* ******************************************************************************* */
		// ノイズ
		Random rand = new Random();
		int noiseDeg = rand.nextInt(realm + 1) - (realm / 2); // 向きのノイズ(度)
		double noiseRad = Math.toRadians(noiseDeg);// 向きのノイズ(ラジアン)

		return (thetaMean + noiseRad);
	}
}
