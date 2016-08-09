import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class OutWriter {
	private OutputStream os;
	private OutputStreamWriter osw;
	private BufferedWriter bw;

	private FileOutputStream arquivo;
	private PrintStream printStream;

	public void escrever1(Ponto2D p, Ponto2D p1, String forma) throws IOException {
		os = new FileOutputStream("coordenadas.xml");
		osw = new OutputStreamWriter(os);
		bw = new BufferedWriter(osw);
		bw.write("<" + forma + ">" + "\n");
		bw.write("<Ponto>");
		bw.write("<" + "x" + ">" + p.getX() + "</" + "x" + ">" + "\n");
		bw.write("<" + "y" + ">" + p.getY() + "</" + "y" + ">" + "\n");
		bw.write("</Ponto>" + "\n");
		bw.write("<Ponto>");
		bw.write("<" + "x" + ">" + p1.getX() + "</" + "x" + ">" + "\n");
		bw.write("<" + "y" + ">" + p1.getY() + "</" + "y" + ">" + "\n");
		bw.write("</Ponto>" + "\n");
		bw.write("</" + forma + ">" + "\n");
		bw.close();
	}

	public void escrever2(Ponto2D p, Ponto2D p1, String forma) throws IOException {
		arquivo = new FileOutputStream("coordenadas.xml");
		printStream = new PrintStream(arquivo);
		printStream.println("<" + forma + ">" + "\n");
		printStream.println("<Ponto>");
		printStream.println("<" + "x" + ">" + p.getX() + "</" + "x" + ">" + "\n");
		printStream.println("<" + "y" + ">" + p.getY() + "</" + "y" + ">" + "\n");
		printStream.println("</Ponto>" + "\n");
		printStream.println("<Ponto>");
		printStream.println("<" + "x" + ">" + p1.getX() + "</" + "x" + ">" + "\n");
		printStream.println("<" + "y" + ">" + p1.getY() + "</" + "y" + ">" + "\n");
		printStream.println("</Ponto>" + "\n");
		printStream.println("</" + forma + ">" + "\n");
		//printStream.close();
		
	}

}
