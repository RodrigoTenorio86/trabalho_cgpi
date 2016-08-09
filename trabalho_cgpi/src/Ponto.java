

public class Ponto {

	private double x;
	private double y;

	Ponto() {
		this.x = 0;
		this.y = 0;
	}

	Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	Ponto(Ponto p) {
		this.x = p.getX();
		this.y = p.getY();
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double calcularDistancia(Ponto p) {

		return Math.sqrt(Math.pow((p.getY() - getY()), 2)
				+ Math.pow((p.getX() - getX()), 2));

	}

}