package co.alura.model;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;

public class Currency extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static JTextField cantidadField;
	
	public Currency() {
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		
		JLabel cantidad = new JLabel("Cantidad");
	    cantidad.setBounds(41, 11, 60, 14);
	    contentPane.add(cantidad);
	    
	    JLabel monedaActual = new JLabel("Moneda Actual");
	    monedaActual.setBounds(23, 49, 87, 14);
	    contentPane.add(monedaActual);
		
	    JLabel monedaNueva = new JLabel("Moneda Nueva");
	    monedaNueva.setBounds(23, 89, 87, 14);
	    contentPane.add(monedaNueva);
	    
	    cantidadField = new JTextField();
	    cantidadField.setBounds(128, 8, 150, 20);
	    contentPane.add(cantidadField);
	    cantidadField.setColumns(10);
	    
	    JComboBox<Object> comboBoxActual = new JComboBox<Object>();
	    comboBoxActual.setModel(new DefaultComboBoxModel<Object>(new String[] {"USD", "EUR", "JPY", "COP", "GBP","KRW"}));
	    comboBoxActual.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    comboBoxActual.setBounds(128, 45, 100, 22);
	    contentPane.add(comboBoxActual);
	    
	    JComboBox<Object> comboBoxNueva = new JComboBox<Object>();
	    comboBoxNueva.setModel(new DefaultComboBoxModel<Object>(new String[] {"USD", "EUR", "JPY", "COP", "GBP","KRW"}));
	    comboBoxNueva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    comboBoxNueva.setBounds(128, 85, 100, 22);
	    contentPane.add(comboBoxNueva);
	    
	    JTextPane txtpnResultado = new JTextPane();
	    txtpnResultado.setEditable(false);
	    txtpnResultado.setBounds(128, 126, 150, 20);
	    contentPane.add(txtpnResultado);
	    
	    JLabel Resultado = new JLabel("Resultado");
	    Resultado.setBounds(41, 126, 60, 14);
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
	    convertirButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    convertirButton.setBounds(295, 159, 89, 23);
	    contentPane.add(convertirButton);
	    
	    setContentPane(contentPane);
        
        // Resto del código para configurar el JFrame
	    setTitle("Conversor de Moneda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(410,230);
        setResizable(false);
	}
	public static void llamarMenu() {
		try {
			Menu menuFrame = new Menu();
		    menuFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void mostrarMensajeAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
	
	public double conversor(double amount, String actual, String nueva) {
		String[] unidades = {"USD", "EUR", "JPY", "COP", "GBP","KRW"};
		if(actual==unidades[0]) {
			if(nueva==unidades[1]) {
				return amount*0.91;
			} else if(nueva==unidades[2]) {
				return amount*142.1;
			} else if(nueva==unidades[3]) {
				return amount*4159.25;
			} else if(nueva==unidades[4]) {
				return amount*0.78;
			}else if(nueva==unidades[5]) {
				return amount*1298.66;
			}
		} else if(actual==unidades[1]){
			if(nueva==unidades[0]) {
				return amount*1.1;
			} else if(nueva==unidades[2]) {
				return amount*155.97;
			} else if(nueva==unidades[3]) {
				return amount*4565.40;
			} else if(nueva==unidades[4]) {
				return amount*0.85;
			}else if(nueva==unidades[5]) {
				return amount*1425.47;
			}
		} else if(actual==unidades[2]) {
			if(nueva==unidades[0]) {
				return amount*0.007;
			} else if(nueva==unidades[1]) {
				return amount*0.0064;
			} else if(nueva==unidades[3]) {
				return amount*29.53;
			} else if(nueva==unidades[4]) {
				return amount*0.0055;
			}else if(nueva==unidades[5]) {
				return amount*9.14;
			}
		} else if(actual==unidades[3]) {
			if(nueva==unidades[0]) {
				return amount*0.00024;
			} else if(nueva==unidades[1]) {
				return amount*0.00022;
			} else if(nueva==unidades[2]) {
				return amount*0.034;
			} else if(nueva==unidades[4]) {
				return amount*0.00019;
			}else if(nueva==unidades[5]) {
				return amount*0.31;
			}
		} else if(actual==unidades[4]) {
			if(nueva==unidades[0]) {
				return amount*1.28;
			} else if(nueva==unidades[1]) {
				return amount*1.17;
			} else if(nueva==unidades[2]) {
				return amount*182.56;
			} else if(nueva==unidades[3]) {
				return amount*5387.31;
			}else if(nueva==unidades[5]) {
				return amount*1666.91;
			}
		} else if(actual==unidades[5]) {
			if(nueva==unidades[0]) {
				return amount*0.00077;
			} else if(nueva==unidades[1]) {
				return amount*0.0007;
			} else if(nueva==unidades[2]) {
				return amount*0.11;
			} else if(nueva==unidades[3]) {
				return amount*3.23;
			}else if(nueva==unidades[4]) {
				return amount*0.000006;
			}
		}
		return amount;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Currency currencyFrame = new Currency();
				    currencyFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
}
