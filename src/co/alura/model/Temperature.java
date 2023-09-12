package co.alura.model;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Temperature extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField cantidadField;
	
	public static void llamarMenu() {
		try {
			Menu menuFrame = new Menu();
		    menuFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperature frame = new Temperature();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Temperature() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
		JLabel cantidad = new JLabel("Temperatura");
	    cantidad.setBounds(23, 11, 68, 14);
	    contentPane.add(cantidad);
	    
	    JLabel monedaActual = new JLabel("Unidad Actual");
	    monedaActual.setBounds(23, 49, 87, 14);
	    contentPane.add(monedaActual);
		
	    JLabel monedaNueva = new JLabel("Unidad Nueva");
	    monedaNueva.setBounds(23, 89, 87, 14);
	    contentPane.add(monedaNueva);
	    
	    
	    
	    cantidadField = new JTextField();
	    cantidadField.setBounds(128, 8, 150, 20);
	    contentPane.add(cantidadField);
	    cantidadField.setColumns(10);
	    
	    JComboBox<Object> comboBoxActual = new JComboBox<Object>();
	    comboBoxActual.setModel(new DefaultComboBoxModel<Object>(new String[] {"Grados Celsius (°C)", "Grados Fahrenheit (°F)", "Kelvin (K)"}));
	    comboBoxActual.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    comboBoxActual.setBounds(128, 45, 137, 22);
	    contentPane.add(comboBoxActual);
	    
	    JComboBox<Object> comboBoxNueva = new JComboBox<Object>();
	    comboBoxNueva.setModel(new DefaultComboBoxModel<Object>(new String[] {"Grados Celsius (°C)", "Grados Fahrenheit (°F)", "Kelvin (K)"}));
	    comboBoxNueva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    comboBoxNueva.setBounds(128, 85, 137, 22);
	    contentPane.add(comboBoxNueva);
	    
	    JTextPane txtpnResultado = new JTextPane();
	    txtpnResultado.setEditable(false);
	    txtpnResultado.setBounds(128, 126, 150, 20);
	    contentPane.add(txtpnResultado);
	    
	    JLabel Resultado = new JLabel("Resultado");
	    Resultado.setBounds(23, 126, 60, 14);
	    contentPane.add(Resultado);
	    
	    JButton volverButton = new JButton("Volver Atrás");
	    volverButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		setVisible(false);
	    		llamarMenu();
	    	}
	    });
	    volverButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    volverButton.setBounds(23, 159, 114, 23);
	    contentPane.add(volverButton);
	    
	    JButton convertirButton = new JButton("Convertir");
	    convertirButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    convertirButton.setBounds(295, 159, 89, 23);
	    convertirButton.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    		double currency=0;
	    		try {
					currency= Double.parseDouble(cantidadField.getText());
					txtpnResultado.setText(String.valueOf(conversor(currency, comboBoxActual.getSelectedItem().toString(),comboBoxNueva.getSelectedItem().toString())));
				} catch (Exception e2) {
					mostrarMensajeAdvertencia("El valor que estás ingresando no es valido");
				}
	    	}
	    });
	    contentPane.add(convertirButton);
	    
	    setContentPane(contentPane);
        
        // Resto del código para configurar el JFrame
	    setTitle("Conversor de Moneda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(410,230);
        setResizable(false);
	}
	public static void mostrarMensajeAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
	public double conversor(double temp, String actual, String nueva) {
		String[] unidades = {"Grados Celsius (°C)", "Grados Fahrenheit (°F)", "Kelvin (K)"};
		if(actual==unidades[0]&&nueva==unidades[1]) {
			return temp*1.8+32;
		} else if(actual==unidades[0]&&nueva==unidades[2]){
			return temp+273.15;
		} else if(actual==unidades[1]&&nueva==unidades[0]) {
			return (temp-32)/1.8;
		} else if(actual==unidades[1]&&nueva==unidades[2]) {
			return 5*(temp-32)/9 + 273.15;
		} else if(actual==unidades[2]&&nueva==unidades[0]) {
			return temp-273.15;
		} else if(actual==unidades[2]&&nueva==unidades[1]) {
			return 1.8*(temp - 273.15) + 32;
		}
		return temp;
	}
}
