package uniandes.dpoo.taller6.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.dpoo.taller6.modelo.Tablero;

@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{
	private final static String NUEVO = "Nuevo";
	private final static String REINICIAR = "Reiniciar";
	private final static String TOP10 = "TOP10";
	private JDialog dialogo;
	private VentanaPrincipal ventana;

				
	private void agregarBoton(String comando, String texto)
	{
		JButton boton = new JButton(texto);
		boton.setForeground(Color.white);
		boton.setBackground(new Color(53,187,235));
		boton.setActionCommand(comando);
		boton.addActionListener(this);
		this.add(boton);
	}
	public PanelOpciones(VentanaPrincipal ventanaPrincipal)
	{	
		this.ventana = ventanaPrincipal;
		agregarBoton(NUEVO, "NUEVO");
		agregarBoton(REINICIAR, "REINICIAR");
		agregarBoton(TOP10, "TOP-10");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();

		if (NUEVO.equals(comando))
		{
			Tablero tableroJuego = new Tablero(5);;
		}
		else if (REINICIAR.equals(comando))
		{
			Tablero tableroJuego = new Tablero(5);;
			tableroJuego.reiniciar();
		}
		else if (TOP10.equals(comando))
		{
			dialogo = new JDialog();
			JLabel nombre = new JLabel("# Nombre");
			nombre.setForeground(Color.white);
			nombre.setBackground(new Color(53,187,235));
			nombre.setHorizontalAlignment(JLabel.CENTER);
			nombre.setOpaque(true);
			dialogo.getContentPane().add(nombre);
            dialogo.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
            dialogo.pack();
    		dialogo.setVisible(true);
		}
	}
}
