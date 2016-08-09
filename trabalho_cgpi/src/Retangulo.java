import java.awt.Color;
import java.awt.Graphics;

public class Retangulo extends Ponto2D{
	private Ponto2D p1, p2, p3, p4;
	Reta r1, r2, r3, r4;

	public Retangulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	Retangulo(Ponto2D p1, Ponto2D p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = new Ponto2D(this.p2.getX(), this.p1.getY());
		this.p4 = new Ponto2D(this.p1.getX(), this.p2.getY());
	}
	
	
	public void desenharRetangulos(Graphics g){
		double x1,y1,x2,y2;
		x1=p1.getX();
		y1=p1.getY();
		x2=p2.getX();
		y2=p2.getY();
		for(int y=(int)y1;y<(int)y2;y++){
			for(int x=(int)x1;x<(int)x2;x++)desenharPonto(g);
		}
	}
	

	public void desenharRetangulo(Graphics g) {

		double difx = this.getP1().getX() - this.getP2().getX();
		double dify = this.getP1().getY() - this.getP2().getY();
		if (difx < 0) {
			difx = difx * -1;
		}
		if (dify < 0) {
			dify = dify * -1;
		}
		if ((difx > 5 && dify > 5)) {
			this.r1 = new Reta(this.getP1(), this.getP3());
			this.r2 = new Reta(this.getP3(), this.getP2());
			this.r3 = new Reta(this.getP2(), this.getP4());
			this.r4 = new Reta(this.getP4(), this.getP1());
			this.r1.desenharRetaDDA(g);
			this.r2.desenharRetaDDA(g);
			this.r3.desenharRetaDDA(g);
			this.r4.desenharRetaDDA(g);

		} else {
			System.out.println("Retangulo pequeno demais: " + (this.getP1().getX() - this.getP2().getX()) + "  "
					+ (this.getP1().getY() - this.getP2().getY()));
		}

	}
	
	
	public void desenharRetanguloCor(Graphics g,Color cor) {

		double difx = this.getP1().getX() - this.getP2().getX();
		double dify = this.getP1().getY() - this.getP2().getY();
		if (difx < 0) {
			difx = difx * -1;
		}
		if (dify < 0) {
			dify = dify * -1;
		}
		if ((difx > 5 && dify > 5)) {
			this.r1 = new Reta(this.getP1(), this.getP3());
			this.r2 = new Reta(this.getP3(), this.getP2());
			this.r3 = new Reta(this.getP2(), this.getP4());
			this.r4 = new Reta(this.getP4(), this.getP1());
			this.r1.desenharRetaDDA(cor,g);
			this.r2.desenharRetaDDA(cor,g);
			this.r3.desenharRetaDDA(cor,g);
			this.r4.desenharRetaDDA(cor,g);

		} else {
			System.out.println("Retangulo pequeno demais: " + (this.getP1().getX() - this.getP2().getX()) + "  "
					+ (this.getP1().getY() - this.getP2().getY()));
		}

	}
	
	

	public boolean pertence(int x, int y) {
		if (r1.pertenceReta(x, y) || r4.pertenceReta(x, y) || r2.pertenceReta(x, y) || r3.pertenceReta(x, y)) {
			return true;
		}
		return false;
	}
	
	

	public Ponto2D getP1() {
		return p1;
	}

	public void setP1(Ponto2D p1) {
		this.p1 = p1;
	}

	public Ponto2D getP2() {
		return p2;
	}

	public void setP2(Ponto2D p2) {
		this.p2 = p2;
	}

	public Ponto2D getP3() {
		return p3;
	}

	public void setP3(Ponto2D p3) {
		this.p3 = p3;
	}

	public Ponto2D getP4() {
		return p4;
	}

	public void setP4(Ponto2D p4) {
		this.p4 = p4;
	}

}
