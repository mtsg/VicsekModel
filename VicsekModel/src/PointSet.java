import java.awt.geom.Point2D;

public class PointSet extends Point2D {

	// member
	Point2D.Double point;
	double theta;

	// constractor
	PointSet() {
		point = new Point2D.Double();
		theta = 0;
	}

	@Override
	public double getX() {
		return point.x;
	}

	@Override
	public double getY() {
		return point.y;
	}

	@Override
	public void setLocation(double x, double y) {
		point.x = x;
		point.y = y;
	}

}
