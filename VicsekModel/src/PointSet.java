import java.awt.geom.Point2D;

public class PointSet extends Point2D {

	// member
	Point2D.Double point;
	double theta;

	// 固定メンバ
	static int PBC = 600;// 周期境界条件

	// constractor
	PointSet() {
		point = new Point2D.Double();
		theta = 0;
	}

	@Override
	public double getX() {
		// 周期境界条件
		if (point.x > PBC) {
			point.x -= PBC;
		} else if (point.x < 0) {
			point.x += PBC;
		}

		return point.x;
	}

	@Override
	public double getY() {
		// 周期境界条件
		if (point.y > PBC) {
			point.y -= PBC;
		} else if (point.y < 0) {
			point.y += PBC;
		}

		return point.y;
	}

	@Override
	public void setLocation(double x, double y) {
		point.x = x;
		point.y = y;
	}

	public void setLocation(PointSet ps) {
		this.setLocation(ps.getX(), ps.getY());
		this.theta = ps.theta;
	}

}
