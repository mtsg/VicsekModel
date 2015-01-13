import java.util.ArrayList;

public class ParticleSet {

	// メンバ
	int N = 1000;// 粒子数
	ArrayList<Particle> particleSet = new ArrayList<Particle>();


	// メソッド
	// 粒子群生成(初期配置はランダム)
	void setInit() {
		for (int i = 0; i < N; i++) {
			Particle p = new Particle();
			particleSet.add(p);
		}

	}

	// 次の位置を求める
	void nextPosition() {
		for (Particle p : particleSet) {
			p.nextPosition(particleSet);
		}

	}

	void update() {
		// 位置の更新
		for (Particle p : particleSet) {
			p.update();
		}

	}

}
