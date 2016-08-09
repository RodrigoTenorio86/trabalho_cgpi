/**
 *
 * @author RodrigoTenorio
 */

import java.awt.*;
import java.util.ArrayList;

public class Reta extends Ponto2D {
	private Ponto2D p1;
	private Ponto2D p2;
	private ArrayList<Ponto2D> listadepontos;
	Color cor;
	int larg = 3;

	public Reta() {
		super();
		this.p1.setX(0);
		this.p1.setY(0);
		this.p2.setX(0);
		this.p2.setY(0);
		listadepontos = new ArrayList<Ponto2D>();
	}

	public Reta(int x1, int y1, int x2, int y2) {
		setP1(new Ponto2D(x1, y1));
		setP2(new Ponto2D(x2, y2));
		listadepontos = new ArrayList<Ponto2D>();
	}

	public Reta(double x1, double y1, double x2, double y2) {
		setP1(new Ponto2D(x1, y1));
		setP2(new Ponto2D(x2, y2));
		listadepontos = new ArrayList<Ponto2D>();
	}

	public Reta(Ponto2D p1, Ponto2D p2) {
		setP2(new Ponto2D(p2));
		setP1(new Ponto2D(p1));
		listadepontos = new ArrayList<Ponto2D>();
		listadepontos.add(p1);
		listadepontos.add(p2);
		/*
		 * this.p1=p1; this.p2=p2;
		 */
	}

	// Sets

	public Ponto2D getP1() {
		return p1;
	}

	public Ponto2D getP2() {
		return p2;
	}

	public void setP1(Ponto2D p1) {
		this.p1 = p1;
	}

	public void setP2(Ponto2D p2) {
		this.p2 = p2;
	}

	public double calculaA() {
		double a;
		a = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
		return a;
	}

	public double calculaB() {
		double b;
		b = p1.getY() - (calculaA() * p1.getX());
		return b;
	}

	// Calcula a da equação da reta (y = a*x + b)
	public void calculaReta(Graphics g) {
		double b, a, x, y;
		a = calculaA();
		b = calculaB();
		// Y>X
		if (Math.abs(p2.getY() - p1.getY()) > Math.abs(p2.getX() - p1.getX())) {
			System.out.println("Y>X .");
			// Y1>Y2
			if (p1.getY() > p2.getY()) {
				System.out.println("Y1>Y2 .");
				// X1==X2
				if (p1.getX() == p2.getX()) {
					System.out.println("X1==X2 .");
					for (y = p2.getY(); y < p1.getY(); y++) {
						desenharPonto(p1.getX(), (int) y, cor, g);
						// g.clearRect((int)p1.getX(), (int) y, this.larg,
						// this.larg);

					}
				} else {
					for (y = p2.getY(); y < p1.getY(); y++) {
						desenharPonto((y - b) / a, (int) y, cor, g);
						// g.clearRect((int) ((y - b) / a), (int) y, this.larg,
						// this.larg);
					}
				}
				// Caso em que x1 = x2
			} else if (p1.getX() == p2.getX()) {

				System.out.println("X1==X2 .");
				for (y = p1.getY(); y < p2.getY(); y++) {
					desenharPonto(p1.getX(), (int) y, cor, g);
					// g.clearRect((int)p1.getX(), (int) y, this.larg,
					// this.larg);
				}
			} else {// Caso em que x1 < x2
				System.out.println("x1 < x2 .");
				for (y = p1.getY(); y < p2.getY(); y++) {
					desenharPonto((y - b) / a, (int) y, cor, g);
					// g.clearRect((int) ((y - b) / a), (int) y,this.larg,
					// this.larg);
				}
			}
			// x é maior
		} else {
			// X>Y
			System.out.println(" X>Y.");
			if (p1.getX() > p2.getX()) {
				for (x = p2.getX(); x < p1.getX(); x++) {
					desenharPonto((int) x, b + a * x, cor, g);
					// g.clearRect((int) x, (int) (b + a * x), this.larg,
					// this.larg);
				}
				// x1 = x2
				// ??????????????????????????????????????????????????????????????????????????????????
			} else if (p1.getX() == p2.getX()) {
				System.out.println(" X e maior com Reta Vertical .");
				for (x = p1.getX(); x < p2.getX(); x++) {
					desenharPonto((int) (p1.getX()), (int) (b + a * x), cor, g);
					// g.clearRect((int) (p1.getX()), (int) (b + a *
					// x),this.larg, this.larg);
				}
			} else {
				// x1 < x2
				for (x = p1.getX(); x < p2.getX(); x++) {
					desenharPonto((int) x, (int) (b + a * x), cor, g);
					// g.clearRect((int) x, (int) (b + a * x), this.larg,
					// this.larg);

				}
			}
		}

	}

	public void desenharPonto(double x, double y, Color corStr, Graphics g) {
		g.setColor(corStr);
		g.fillOval((int) x - (this.larg / 2), (int) y - (this.larg / 2), this.larg, this.larg);

	}

	public void desenharRetaDDA(int xa, int ya, int xb, int yb, Color cor, Graphics g) {//

		int dx = xb - xa, dy = yb - ya, steps, k;
		float xIncr, yIncr, x = xa, y = ya;
		if (Math.abs(dx) > Math.abs(dy))
			steps = Math.abs(dx);
		else
			steps = Math.abs(dy);
		xIncr = dx / (float) steps;
		yIncr = dy / (float) steps;
		desenharPonto(Math.round(x), Math.round(y), cor, g);
		for (k = 0; k < steps; k++) {
			x += xIncr;
			y += yIncr;
			desenharPonto(Math.round(x), Math.round(y), cor, g);
		}
	}

	public void desenharRetaDDA(Ponto2D p1, Ponto2D p2, Color cor, Graphics g) {//
		int xa = (int) p1.getX();
		int ya = (int) p1.getY();
		int yb = (int) p2.getY();
		int xb = (int) p2.getX();
		listadepontos.add(p1);
		listadepontos.add(p2);
		int dx = xb - xa, dy = yb - ya, steps, k;
		float xIncr, yIncr, x = xa, y = ya;
		if (Math.abs(dx) > Math.abs(dy))
			steps = Math.abs(dx);
		else
			steps = Math.abs(dy);
		xIncr = dx / (float) steps;
		yIncr = dy / (float) steps;
		desenharPonto(Math.round(x), Math.round(y), cor, g);
		for (k = 0; k < steps; k++) {
			x += xIncr;
			y += yIncr;
			desenharPonto(Math.round(x), Math.round(y), cor, g);
		}
	}

	public void desenharRetaDDA(double xa, double ya, double xb, double yb, Color cor, Graphics g) {//

		double dx = xb - xa, dy = yb - ya, steps, k;
		double xIncr, yIncr, x = xa, y = ya;
		if (Math.abs(dx) > Math.abs(dy))
			steps = Math.abs(dx);
		else
			steps = Math.abs(dy);
		xIncr = dx / (float) steps;
		yIncr = dy / (float) steps;
		desenharPonto(Math.round(x), Math.round(y), cor, g);
		for (k = 0; k < steps; k++) {
			x += xIncr;
			y += yIncr;
			desenharPonto(Math.round(x), Math.round(y), cor, g);
		}
	}

	public void desenharRetaDDA(Color cor, Graphics g) {//
		double xa = p1.getX();
		double ya = p1.getY();
		double yb = p2.getY();
		double xb = p2.getX();
		listadepontos.add(p1);
		listadepontos.add(p2);
		double dx = xb - xa, dy = yb - ya, steps, k;
		double xIncr, yIncr, x = xa, y = ya;
		if (Math.abs(dx) > Math.abs(dy))
			steps = Math.abs(dx);
		else
			steps = Math.abs(dy);
		xIncr = dx / (float) steps;
		yIncr = dy / (float) steps;
		desenharPonto(Math.round(x), Math.round(y), cor, g);
		for (k = 0; k < steps; k++) {
			x += xIncr;
			y += yIncr;
			desenharPonto(Math.round(x), Math.round(y), cor, g);
		}
	}

	public void desenharRetaDDA(Graphics g) {//

		double xa = p1.getX();
		double ya = p1.getY();
		double yb = p2.getY();
		double xb = p2.getX();

		listadepontos.add(p1);
		listadepontos.add(p2);

		double dx = xb - xa, dy = yb - ya, steps, k;
		double xIncr, yIncr, x = xa, y = ya;
		if (Math.abs(dx) > Math.abs(dy))
			steps = Math.abs(dx);
		else
			steps = Math.abs(dy);
		xIncr = dx / (float) steps;
		yIncr = dy / (float) steps;
		desenharPonto(Math.round(x), Math.round(y), cor, g);
		for (k = 0; k < steps; k++) {
			x += xIncr;
			y += yIncr;
			desenharPonto(Math.round(x), Math.round(y), cor, g);
		}
	}

	public boolean pertenceReta(int x, int y) {
		for (Ponto2D p : listadepontos) {
			if (p.pertence(x, y))
				return true;
		}
		return false;
	}

}

/*
 * 
 * 
 * public void calculaReta(Graphics g) { double b, a, y, x;
 * 
 * // x1 = x2 if (p1.getX() == p2.getX()) {
 * 
 * for (y = p1.getY(); y < p2.getY(); y++) { x = p1.getX(); desenharPonto(x, y,
 * cor, g); }
 * 
 * // y1 = y2 } else if (p1.getY() == p2.getY()) {
 * 
 * for (x = p1.getX(); x < p2.getX(); x++) { y = p1.getY(); desenharPonto(x, y,
 * cor, g); } // X1>X2 } else if (p1.getX() > p2.getX()) { a = (p2.getY() -
 * p1.getY()) / (p2.getX() - p1.getX()); b = p1.getY() - (a * p1.getX()); for (x
 * = p2.getX(); x < p1.getX(); x++) { y = a * x + b; desenharPonto(x, y, cor,
 * g); } // y1>Y2 ww?????????????????????????? } else if (p1.getY() > p2.getY())
 * { /* a = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX()); b = p1.getY() -
 * (a * p1.getX()); for (y = p2.getY(); y < p1.getY(); y++) { x=p1.getX();
 * desenharPonto(x, y, cor, g);
 * 
 * // }
 * 
 * } else if ((p1.getX() != p2.getX()) && (p1.getY() != p2.getY())) { a =
 * (p2.getY() - p1.getY()) / (p2.getX() - p1.getX()); b = p1.getY() - (a *
 * p1.getX()); for (x = p1.getX(); x < p2.getX(); x++) { y = a * x + b;
 * desenharPonto(x, y, cor, g); } }
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Mudança 16_08
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * if (p1.getX() == p2.getX()) {
 * 
 * for (y = p1.getY(); y < p2.getY(); y++) { x = p1.getX(); desenharPonto(x, y,
 * cor, g); }
 * 
 * // y1 = y2 } else if (p1.getY() == p2.getY()) {
 * 
 * for (x = p1.getX(); x < p2.getX(); x++) { y = p1.getY(); desenharPonto(x, y,
 * cor, g); } // X1>X2 } else if (p1.getX() > p2.getX()) { a = calculaA(); b =
 * calculaB(); for (x = p2.getX(); x < p1.getX(); x++) { y = a * x + b;
 * desenharPonto(x, y, cor, g); } // y1>Y2 ww?????????????????????????? } else
 * if (p1.getY() > p2.getY()) { /* a = (p2.getY() - p1.getY()) / (p2.getX() -
 * p1.getX()); b = p1.getY() - (a * p1.getX()); for (y = p2.getY(); y <
 * p1.getY(); y++) { x=p1.getX(); desenharPonto(x, y, cor, g);
 * 
 * // }
 * 
 * } else if ((p1.getX() != p2.getX()) && (p1.getY() != p2.getY())) {
 * 
 * for (x = p1.getX(); x < p2.getX(); x++) { y = a * x + b; desenharPonto(x, y,
 * cor, g); } }
 */
