
/**
 *
 * @author RodrigoTenorio
 */

import java.awt.*;
import java.util.ArrayList;

public class Circulo extends Ponto2D {
	private Ponto2D centro;
	private double raio;
	private Color cor;
	private ArrayList<Ponto2D> listaPontos;
	int larg = 2;

	public Circulo() {
		super();
	}

	public Circulo(Ponto2D centro, double raio) {
		super();
		this.centro = centro;
		this.raio = raio;
		listaPontos = new ArrayList<Ponto2D>();
	}

	public Circulo(double x1, double y1, double raio) {
		this.raio = raio;
		setP1(new Ponto2D(x1, y1));
		listaPontos = new ArrayList<Ponto2D>();
	}

	public Circulo(double x1, double y1, Color c) {
		this.cor = c;
		setP1(new Ponto2D(x1, y1));
		listaPontos = new ArrayList<Ponto2D>();
	}

	public Circulo(Ponto2D p, Ponto2D p1) {// /?????????????????????????
		Graphics g = null;
		this.centro = p;
		this.raio = Math.sqrt(Math.pow((p.getY() - p1.getY()), 2) + Math.pow((p.getX() - p1.getX()), 2));
		listaPontos = new ArrayList<Ponto2D>();
		// desenharCirculo(g);

	}

	public void setP1(Ponto2D p) {
		this.centro = p;
	}

	public Ponto getCentro() {
		return centro;
	}

	public void setCentro(Ponto2D centro) {
		this.centro = centro;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public void calcularDistanciaRaio(Ponto2D p, Ponto2D p1) {
		Graphics g = null;
		this.centro = p;
		this.raio = Math.sqrt(Math.pow((p.getY() - p1.getY()), 2) + Math.pow((p.getX() - p1.getX()), 2));
		desenharCirculo(g);

	}

	public void desenharCirculo(Graphics g) {
		double x, y;
		// double pi = Math.PI;
		for (double alfa = 0; alfa < 360; alfa = alfa + 0.1) {
			x = raio * Math.sin(Math.toRadians(alfa)) + this.centro.getX();
			y = raio * Math.cos(Math.toRadians(alfa)) + this.centro.getY();
			desenharPonto(x, y, cor, g);
		}

	}

	public void desenharCirculo(Graphics g, Color c) {
		double x, y;
		// double pi = Math.PI;
		for (double alfa = 0; alfa < 360; alfa = alfa + 0.1) {
			x = raio * Math.sin(Math.toRadians(alfa)) + this.centro.getX();
			y = raio * Math.cos(Math.toRadians(alfa)) + this.centro.getY();
			desenharPonto(x, y, c, g);
		}

	}

	public void desenharCirculo(Graphics g, int dots) {
		double xd, yd;
		double pi = Math.PI;
		System.out.println("Centro:" + this.centro.getX() + "," + this.centro.getY());
		for (int k = 1; k <= dots; k++) {
			xd = raio * Math.cos((2 * pi / dots) * (k - 1)) + this.centro.getX();
			yd = raio * Math.sin((2 * pi / dots) * (k - 1)) + this.centro.getY();
			Ponto2D p = new Ponto2D((int) xd, (int) yd, Color.blue);
			p.desenharPonto(g);
		}

	}

	public void desenharCirculoOpt1(Graphics g, int dots) {
		double xd, yd, xd2, yd2;
		double pi = Math.PI;
		for (int k = 1; k <= dots; k++) {
			xd = raio * Math.cos((pi / 2 / dots) * (k - 1)) + this.centro.getX();

			yd = raio * Math.sin((pi / 2 / dots) * (k - 1)) + this.centro.getY();
			xd2 = xd - 2 * (xd - this.centro.getX());
			yd2 = yd - 2 * (yd - this.centro.getY());

			Ponto2D p = new Ponto2D((int) xd, (int) yd, cor);
			Ponto2D p1 = new Ponto2D((int) xd2, (int) yd, cor);
			Ponto2D p2 = new Ponto2D((int) xd, (int) yd2, cor);
			Ponto2D p3 = new Ponto2D((int) xd2, (int) yd2, cor);

			listaPontos.add(p);
			listaPontos.add(p1);
			listaPontos.add(p2);
			listaPontos.add(p3);

			p.desenharPonto(g);
			p1.desenharPonto(g);
			p2.desenharPonto(g);
			p3.desenharPonto(g);
		}

	}

	public void desenharPonto(double x, double y, Color corStr, Graphics g) {
		g.setColor(corStr);
		g.fillOval((int) x - (this.larg / 2), (int) y - (this.larg / 2), this.larg, this.larg);

	}

	public boolean pertence(int x, int y) {
		for (Ponto2D p : listaPontos) {
			if (p.pertence(x, y))
				return true;
		}

		return false;
	}

}
