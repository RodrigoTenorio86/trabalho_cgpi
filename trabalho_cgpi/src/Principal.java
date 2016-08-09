/**
 *
 * @author RodrigoTenorio
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Principal() {

		/**
		 * Definicoes de janela
		 */
		super("Programa");
		this.setSize(500, 500);
		this.setVisible(true);

	}

	public void paint(Graphics g) {
		Ponto2D ponto[]; // coordenadas capturadas pelo mouse

		// Cria um vetor de 3 pontos
		ponto = new Ponto2D[3];

		// Define 3 pontos
		ponto[0] = new Ponto2D(100, 100, Color.blue, "P1");
		ponto[1] = new Ponto2D(200, 200, Color.red, "P2");
		ponto[2] = new Ponto2D(300, 300, Color.green, "P3");

		// Desenha os tres pontos
		ponto[0].desenharPonto(g);
		ponto[1].desenharPonto(g);
		ponto[2].desenharPonto(g);

		// x1, y1, x2,y2
		Reta r = new Reta(100, 100, 300, 200);
		r.calculaReta(g);
		r.desenharRetaDDA(100, 100, 300, 200, Color.black, g);
		;

		// x1, y1, raio
		Circulo c = new Circulo(250, 250, 100);
		c.desenharCirculo(g);
		c.desenharCirculoOpt1(g, 720);
		c.desenharCirculoOpt1(g, 360);

		Retangulo rt = new Retangulo(ponto[0], ponto[1]);
		rt.desenharRetangulo(getGraphics());

	}

	public static void main(String args[]) {
		new Principal();
	}
}
