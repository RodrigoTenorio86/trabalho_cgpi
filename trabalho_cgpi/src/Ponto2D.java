/**
 *
 * @author RodrigoTenorio
 */



import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.security.spec.EllipticCurve;

public class Ponto2D extends Ponto {
	Color _cor;
	String _str;
	Color _corStr;
	Ellipse2D ov;

	int larg = 4;

	Ponto2D(Ponto p) {
		super((double) p.getX(), (double) p.getY());
        this.ov = new Ellipse2D.Double(getX(), getY(), 3, 3);
	}

	Ponto2D(int x, int y) {
		super((double) x, (double) y);
		new Ponto(x, y);
		this.ov = new Ellipse2D.Double(getX(), getY(), 3, 3);
	}

	Ponto2D(int x, int y, Color cor) {
		super((double) x, (double) y);
		setCor(cor);
		setCorStr(Color.black);
		setStr("");
		this.ov = new Ellipse2D.Double(getX(), getY(), 3, 3);
	}
	
	
	Ponto2D(double x, double y, Color cor) {
		super( x,  y);
		setCor(cor);
		setCorStr(Color.black);
		setStr("");
		this.ov = new Ellipse2D.Double(getX(), getY(), 3, 3);
	}
	

	Ponto2D(int x, int y, Color cor, String str) {
		super((double) x, (double) y);
		setCor(cor);
		setCorStr(Color.black);
		setStr(str);
		this.ov = new Ellipse2D.Double(getX(), getY(), 3, 3);
	}

	Ponto2D(Ponto2D p2d, Color cor) {
		super(p2d);
		setCor(cor);
		setCorStr(Color.black);
		setStr("");
		this.ov = new Ellipse2D.Double(getX(), getY(), 3, 3);
	}

	Ponto2D(double x1, double y1) {
		super(x1, y1);// estudar Herança
		new Ponto(x1, y1);
		this.ov = new Ellipse2D.Double(getX(), getY(), 3, 3);
	}

	Ponto2D(Ponto2D p2d) {
		super(p2d);
		setCor(Color.black);
		setCorStr(Color.black);
		setStr("");
		this.ov = new Ellipse2D.Double(getX(), getY(), 3, 3);
	}

	Ponto2D() {
		super();
		setCor(Color.black);
		setCorStr(Color.black);
		setStr("");
		this.ov = new Ellipse2D.Double(getX(), getY(), 3, 3);
	}

	private void setCor(Color cor) {
		_cor = cor;
	}

	private void setCorStr(Color corStr) {
		_corStr = corStr;
	}

	private void setStr(String str) {
		_str = str;
	}

	public void desenharPonto(Graphics g) {
		g.setColor(_cor);
		g.fillOval((int) getX() - (this.larg / 2), (int) getY() - (this.larg / 2), this.larg, this.larg);

		g.setColor(_corStr);
		g.drawString(_str, (int) getX() + larg, (int) getY());
	}

	public boolean pertence(int x, int y) {
		// TODO Auto-generated method stub
		return (ov.contains(new Point2D.Double(x,y)));
	}



}
