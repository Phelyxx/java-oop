package uniandes.dpoo.taller6.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import uniandes.dpoo.taller6.modelo.Tablero;

@SuppressWarnings("serial")
public class PanelContador extends JPanel
{
	private VentanaPrincipal ventana;
	
	public PanelContador(VentanaPrincipal ventanaPrincipal)
	{
		Tablero tableroJuego = new Tablero(5);
		this.ventana = ventanaPrincipal;
		int jugadas = tableroJuego.darJugadas();
		String jugadastr = String.valueOf(jugadas);
		jugadastr = " " + jugadastr + " ";
		JLabel contador = new JLabel(jugadastr);
		setLayout(new BorderLayout());
		this.add(contador, BorderLayout.CENTER);
		
	}
}
