
/**
 * @author Tenorio
 * 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Poligono extends Ponto2D {
	private ArrayList<Ponto2D> listadepoligono;
	Reta r;

	public Poligono() {
		super();
		// TODO Auto-generated constructor stub
		listadepoligono = new ArrayList<Ponto2D>();
		this.r = new Reta();
	}

	public Poligono(Ponto2D p) {
		super(p);
		listadepoligono = new ArrayList<Ponto2D>();
		adicionaPonto(p);
		if (listadepoligono.size() > 1) {
			this.r = new Reta(listadepoligono.get(listadepoligono.size()),
					listadepoligono.get(listadepoligono.size() - 1));
		}

	}

	public void desenharPoligono(Graphics g) {

		if (listadepoligono.size() > 1) {
			this.r.desenharRetaDDA(listadepoligono.get(listadepoligono.size()),
					listadepoligono.get(listadepoligono.size() - 1), Color.black, g);
		//	this.r.desenharPonto(g);
		}
	}

	public void adicionaPonto(Ponto2D p) {
		this.listadepoligono.add(p);
	}

}
