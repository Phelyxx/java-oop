package uniandes.dpoo.taller6.interfaz;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import uniandes.dpoo.taller6.modelo.Tablero;
@SuppressWarnings("serial")
public class PanelTamanioDificultad extends JPanel implements ItemListener, ChangeListener
{
	private VentanaPrincipal ventana;
	private JComboBox<String> cbbTamanios;
	private JLabel tamanio;
	private JLabel dificultad;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	
	public PanelTamanioDificultad(VentanaPrincipal ventanaPrincipal)
	{
		this.ventana = ventanaPrincipal;
		Color azul = new Color(53,187,235);
		setBackground(azul);
		tamanio = new JLabel( "Tamaño:");
		tamanio.setForeground(Color.white);
		add(tamanio);
		cbbTamanios = new JComboBox<String>();
        add(cbbTamanios);
        cbbTamanios.addItem("5x5");
        cbbTamanios.addItem("7x7");
        cbbTamanios.addItem("9x9");
        cbbTamanios.addItemListener(this);
		dificultad = new JLabel( "Dificultad:");
		dificultad.setForeground(Color.white);
        add( dificultad );
        ButtonGroup group = new ButtonGroup();
        facil = new JRadioButton("Fácil");
        facil.setForeground(Color.white);
        facil.addChangeListener(this);
        group.add(facil);
        medio = new JRadioButton("Medio");
        medio.setForeground(Color.white);
        medio.addChangeListener(this);
        group.add(medio);
        dificil = new JRadioButton("Díficil");
        dificil.setForeground(Color.white);
        dificil.addChangeListener(this);
        group.add(dificil);
        add(facil);
        add(medio);
        add(dificil);
	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
        if (e.getSource() == cbbTamanios) {
            String seleccionado = (String)cbbTamanios.getSelectedItem();
            setName(seleccionado);
            System.out.println(seleccionado);
            ventana.cambiarTamanio(seleccionado.charAt(0));
        }
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		Tablero tableroJuego = new Tablero(5);
		if (facil.isSelected())
		{
			tableroJuego.desordenar(12);
		}
		if (medio.isSelected())
		{
			tableroJuego.desordenar(20);
		}
		if (dificil.isSelected())
		{
			tableroJuego.desordenar(30);
		}
	}


}
