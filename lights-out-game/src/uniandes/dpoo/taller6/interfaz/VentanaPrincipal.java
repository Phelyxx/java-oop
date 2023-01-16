package uniandes.dpoo.taller6.interfaz;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller6.modelo.RegistroTop10;
import uniandes.dpoo.taller6.modelo.Tablero;
import uniandes.dpoo.taller6.modelo.Top10;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame
{
	private Tablero logicaTablero;
	private Top10 top10;
	private RegistroTop10 registroTop10;
	private PanelBotones tableroJuego;
	private PanelOpciones panelOpciones;
	private PanelTamanioDificultad panelTamanioDificultad;
	private PanelContador panelContador;

	public VentanaPrincipal()
	{
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		tableroJuego = new PanelBotones(5);
		add(tableroJuego, BorderLayout.CENTER);
		
		panelOpciones = new PanelOpciones(this);
		add(panelOpciones, BorderLayout.SOUTH);
		
		panelTamanioDificultad = new PanelTamanioDificultad(this);
		add(panelTamanioDificultad, BorderLayout.NORTH);
		
		panelContador = new PanelContador(this);
		add(panelContador, BorderLayout.WEST);
		
		

		
		// Esto se usa para que al cerrar la ventana se salven los resultados
		addWindowListener(new WindowAdapter()
		{
		public void windowClosing(WindowEvent e)
		{
		salvarTop10();
		}
		});

	}
	public void salvarTop10()
	{
		/*
		try
		{
			top10.salvarRecords(new File("./data/top10.csv"));
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	public static void main(String [] artgs)
	{
		FlatLightLaf.install();
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}
	public void cambiarTamanio(char seleccionado)
	{
		int tamanio = Integer.parseInt(String.valueOf(seleccionado));
		tableroJuego.actualizar(tamanio);
	}
}
