import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Point2Ds {
	private Point2D[] points;

	public Point2D getPoint(int i) {
		// Return the point object at index i

		// Put your code here
		return points[i];

	}

	public void readFromFile(String filename) throws FileNotFoundException {
		// Read all points stored in filename
		// Store them in the array points

		// Put your code here
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] coor = line.split(" ");
				if (points == null) {
					points = new Point2D[1];
					points[0] = new Point2D(Double.parseDouble(coor[0]), Double.parseDouble(coor[1]));
				} else {
					int len = points.length + 1;
					Point2D[] newPoints = new Point2D[len];
					for (int i = 0; i < points.length; i++) {
						newPoints[i] = points[i];
					}

					newPoints[len - 1] = new Point2D(Double.parseDouble(coor[0]), Double.parseDouble(coor[1]));
					points = newPoints;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Point2D getClosestPointToOrigin() {
		// Return the point that is closest to the origin

		// Put your code here
		Point2D origin = new Point2D(0, 0);
		Point2D closestPoint = points[0];
		for (int i = 1; i < points.length; i++) {
			if (origin.distance(closestPoint) > origin.distance(points[i])) {
				closestPoint = points[i];
			}
		}
		return closestPoint;
	}

	public Point2D getClosestPoint(double x, double y) {
		// Return the point that is closest to x,y
		Point2D point = new Point2D(x, y);
		// Put your code here
		Point2D closestPoint = points[0];
		for (int i = 1; i < points.length; i++) {
	        if (point.distance(closestPoint) > point.distance(points[i])) {
	            closestPoint = points[i];
	        }
	    }
		return closestPoint;
	}
}
