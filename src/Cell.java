public class Cell
{
	private int x;
	private int y;
	private double distance;

	public Cell(int y, int x, int destY, int destX) {
		this.x = x;
		this.y = y;
		this.distance = Math.hypot(destX-x, destY-y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
