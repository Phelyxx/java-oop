package uniandes.dpoo.taller6.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import uniandes.dpoo.taller6.modelo.Tablero;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener
{
	private JButton[][] matrizBotones;
	
	public PanelBotones(int tamanio)
	{
		matrizBotones = new JButton[tamanio][tamanio];
		Random numero = new Random();
		
		setLayout(new GridLayout(tamanio, tamanio));
		
		for(int i = 0; i < matrizBotones.length; i++)
		{
			for(int j = 0; j < matrizBotones.length; j++)
			{
				matrizBotones[i][j] = new JButton();
				int random = numero.nextInt(4); 
				if (random == 0)
				{
					matrizBotones[i][j].setBackground(Color.yellow);
					ImageIcon imagen = new ImageIcon("./data/luz.png");
					matrizBotones[i][j].setIcon(imagen);
					add(matrizBotones[i][j]);
				}
				else
				{
					matrizBotones[i][j].setBackground(Color.WHITE);
				}

				matrizBotones[i][j].addActionListener(this);
				matrizBotones[i][j].setActionCommand(i + "%" + j);
				
				add(matrizBotones[i][j]);
			}
		}
	}
	public void actualizar(int tamanio)
	{
		removeAll();
		matrizBotones = new JButton[tamanio][tamanio];
		Random numero = new Random();
		
		setLayout(new GridLayout(tamanio, tamanio));
		
		for(int i = 0; i < matrizBotones.length; i++)
		{
			for(int j = 0; j < matrizBotones.length; j++)
			{
				matrizBotones[i][j] = new JButton();
				int random = numero.nextInt(4); 
				if (random == 0)
				{
					matrizBotones[i][j].setBackground(Color.yellow);
					ImageIcon imagen = new ImageIcon("./data/luz.png");
					matrizBotones[i][j].setIcon(imagen);
					add(matrizBotones[i][j]);
				}
				else
				{
					matrizBotones[i][j].setBackground(Color.WHITE);
				}

				matrizBotones[i][j].addActionListener(this);
				matrizBotones[i][j].setActionCommand(i + "%" + j);
				
				add(matrizBotones[i][j]);
			}
		}
		updateUI();
		
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		Tablero tableroJuego = new Tablero(5);
		String comando = e.getActionCommand();
		String[] partes = comando.split("%");
		int fila = Integer.parseInt(partes[0]);
		int columna = Integer.parseInt(partes[1]);
		tableroJuego.jugar(fila, columna);
		tableroJuego.salvar_tablero();
		tableroJuego.desordenar(columna);
		
	}
}
