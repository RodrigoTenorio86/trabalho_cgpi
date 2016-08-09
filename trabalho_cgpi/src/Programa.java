
/**
 *
 * @author RodrigoTenorio
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

class Programa extends JFrame implements MouseMotionListener, MouseListener {
	private OutWriter writer;
	int _x, _y;
	int elasx, elasy;
	 // static?????????????????

	// private ArrayList<Ponto2D> listaTempPnt;
	// Arraylist do tipo Ponto2D ou reta
	private ArrayList<Ponto2D> listaTempo;
	private ArrayList<Ponto2D> listaReta;
	private ArrayList<Ponto2D> listaReta2;
	private ArrayList<Circulo> listaCirculo;
	private ArrayList<Ponto2D> listaCirculo2;
	private ArrayList<Ponto2D> listaretangulo;
	private ArrayList<Ponto2D> listaPoligonos;
	Button btnretaelastica, btncirculaelastica, btnretangulo, btnlinhapoligonal, btnSalvar,btnRemover;

	String forma = "";

	public Programa() {

		/**
		 * Definicoes de janela
		 */
		super("Programa");
		// listaTempPnt = new ArrayList<Ponto2D>();
		listaTempo = new ArrayList<Ponto2D>();
		listaReta = new ArrayList<Ponto2D>();
		listaReta2 = new ArrayList<Ponto2D>();
		listaCirculo = new ArrayList<Circulo>();
		listaCirculo2 = new ArrayList<Ponto2D>();
		listaretangulo = new ArrayList<Ponto2D>();
		listaPoligonos = new ArrayList<Ponto2D>();
		writer = new OutWriter();
		// Eventos de mouse
		addMouseListener(this);
		addMouseMotionListener(this);

		Container content = getContentPane();
		content.setBackground(Color.blue);
		content.setLayout(new FlowLayout());

		btnretaelastica = new Button("Reta");
		btncirculaelastica = new Button("Circulo");
		btnretangulo = new Button("Retangulo");
		btnlinhapoligonal = new Button("Linha Poligonal");
		btnSalvar = new Button("Salvar");
		btnRemover = new Button("Remover");

		btnretaelastica.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				forma = "Retaelastica";
				listaTempo.clear(); 
				/*
				 * listaReta.clear(); listaReta2.clear();
				 */
			}
		});

		btncirculaelastica.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				forma = "Circulaelastica";
				listaTempo.clear(); 
				/*
				 * listaCirculo.clear(); listaCirculo2.clear();
				 */
			}
		});

		btnretangulo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				forma = "Retangulo";
				listaTempo.clear(); 

			}
		});

		btnlinhapoligonal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				forma = "LinhaPoligonal";
				listaTempo.clear(); 

			}
		});

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				forma = "Salvar";

			}
		});
		
		btnRemover.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				forma = "Remover";
				listaTempo.clear(); 
			}
		});

		content.add(btncirculaelastica);
		content.add(btnretaelastica);
		content.add(btnretangulo);
		content.add(btnlinhapoligonal);
		content.add(btnSalvar);
		content.add(btnRemover);
	}

	public void paint(Graphics g) {

		if (forma == "Retaelastica") {
			Ponto2D p, p1;
			// Cria um ponto
			p = new Ponto2D(_x, _y, Color.blue);
			p.desenharPonto(g);
			p1 = new Ponto2D((double) elasx, (double) elasy);

			listaReta.add(p);
			listaReta2.add(p1);
			if (listaReta.size() > 1) {
				Reta r = new Reta(p, p1);
				r.desenharRetaDDA(Color.black, getGraphics());
				r.desenharRetaDDA(listaReta.get(listaReta.size() - 2).getX(),
						listaReta.get(listaReta.size() - 2).getY(), listaReta2.get(listaReta2.size() - 2).getX(),
						listaReta2.get(listaReta2.size() - 2).getY(), getBackground(), getGraphics());

			}

		} else if (forma == "Circulaelastica") {
			Ponto2D p, p1;
			// Cria um ponto
			p = new Ponto2D(_x, _y, Color.blue);
			p.desenharPonto(g);
			p1 = new Ponto2D((double) elasx, (double) elasy);

			listaTempo.add(p);
			listaCirculo2.add(p1);
			if (listaCirculo2.size() > 1) {
				Circulo c = new Circulo(p, p1);
				c.desenharCirculo(g);
				Circulo c1 = new Circulo(listaTempo.get(listaTempo.size() - 2),
						listaCirculo2.get(listaCirculo2.size() - 2));
				c1.desenharCirculo(g, getBackground());
				listaCirculo.add(c); 
				//listaTempo.clear();
			}

		} else if (forma == "LinhaPoligonal") {
			Ponto2D p;
			// Cria um ponto
			p = new Ponto2D(_x, _y, Color.blue);
		//	p.desenharPonto(g);
			
		//	p.desenharPonto(getGraphics());
			Poligono poli;
			listaPoligonos.add(p);
			poli = new Poligono(p);
			poli.desenharPoligono(g);

		} else if (forma == "Salvar") {

			for (Ponto2D r : listaReta) {
				try {
					writer.escrever2(r, r, "Reta");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}else if(forma == "Remover"){
			Reta r;
			Circulo c;
			Retangulo rg;
			Poligono p;
			
			
            for (Circulo cRemover: listaCirculo) {
                if (cRemover.pertence(_x, _y)){
                    c=new Circulo((int)cRemover.getX(),(int)cRemover.getY(), getBackground() );
                    c.desenharCirculo(g,getBackground());
                    c.desenharCirculoOpt1(g, 240);
                    listaCirculo.remove(cRemover);
                    return;
                }
            }
			
			
		}

	}
	
	 public void drawStuff(Graphics g) {
		 for(Circulo c: listaCirculo){
			 c.desenharCirculoOpt1(g, 240);
		 }
	 }
	
	

	public static void main(String args[]) {
		Programa p = new Programa();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setSize(700, 500);
		p.setVisible(true);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent
	 * )
	 */
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		elasx = e.getX();
		elasy = e.getY();

		repaint();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent e) {
		setTitle("Programa" + " (" + e.getX() + ", " + e.getY() + ")");

		// repaint(); // redesenha

	}

	public void mousePressed(MouseEvent mouseevent) {

		if (mouseevent.getButton() == 1) {
			_x = mouseevent.getX();
			_y = mouseevent.getY();
		}
		repaint(); // redesenha
	}

	public void mouseReleased(MouseEvent e) {
		Ponto2D p, p1;
		// Cria um ponto
		p = new Ponto2D(_x, _y, Color.blue);
		p.desenharPonto(getGraphics());
		p1 = new Ponto2D((double) e.getX(), (double) e.getY());

		if (e.getButton() == 1) {
			if (forma == "Circulaelastica") {
				Circulo c = new Circulo(p, p1);
				c.desenharCirculo(getGraphics());

			} else if (forma == "Retaelastica") {
				Reta r = new Reta(p, p1);
				r.desenharRetaDDA(Color.black, getGraphics());

			} else if (forma == "Retangulo") {
				Retangulo rt = new Retangulo(p, p1);
				rt.desenharRetangulo(getGraphics());
			}

		}

		// listaReta.clear();
		// listaCirculo.clear();
		listaReta2.clear();
		listaCirculo2.clear();
		listaretangulo.clear();
		// listaretangulo2.clear();
		// listaretangulo.clear();
		// repaint(); // redesenha
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public ArrayList<Ponto2D> getListaRetaElastica() {
		return listaReta;
	}

	public void setListaRetaElastica(ArrayList<Ponto2D> listaRetaElastica) {
		this.listaReta = listaRetaElastica;
	}

	public ArrayList<Ponto2D> getListaRetaElastica2() {
		return listaReta2;
	}

	public void setListaRetaElastica2(ArrayList<Ponto2D> listaRetaElastica2) {
		this.listaReta2 = listaRetaElastica2;
	}

	public ArrayList<Circulo> getListaCirculoElatico() {
		return listaCirculo;
	}

	public void setListaCirculoElatico(ArrayList<Circulo> listaCirculoElatico) {
		this.listaCirculo = listaCirculoElatico;
	}

	public ArrayList<Ponto2D> getListaCirculoElatico2() {
		return listaCirculo2;
	}

	public void setListaCirculoElatico2(ArrayList<Ponto2D> listaCirculoElatico2) {
		this.listaCirculo2 = listaCirculoElatico2;
	}

}
