package co.alura.model;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Menu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void llamarCurrency() {
		try {
			Currency currencyFrame = new Currency();
		    currencyFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void llamarTemperature() {
		try {
			Temperature tempFrame = new Temperature();
			tempFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu menuFrame= new Menu();
				    menuFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Menu() {
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		
	    JLabel text = new JLabel("¿Qué te gustaría convertir?");
	    text.setBounds(27, 28, 170, 14);
	    contentPane.add(text);
	    
	    JRadioButton currencyButton = new JRadioButton("Moneda");
	    currencyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    currencyButton.setSelected(true);
	    currencyButton.setBounds(27, 49, 109, 23);
	    contentPane.add(currencyButton);
	    
	    JRadioButton tempButton = new JRadioButton("Temperatura");
	    tempButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    tempButton.setBounds(27, 82, 109, 23);
	    contentPane.add(tempButton);
	    
	    ButtonGroup grupo= new ButtonGroup();
	    grupo.add(currencyButton);
	    grupo.add(tempButton);
	    
	    JButton continueButton = new JButton("Continuar");
	    continueButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		setVisible(false);
	    		if (currencyButton.isSelected()) {
	    			llamarCurrency();
	    		} else if (tempButton.isSelected()) {
	    			llamarTemperature();
	    		}
	    	}
	    });
	    continueButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    continueButton.setBounds(253, 118, 89, 23);
	    contentPane.add(continueButton);
	    
	    setTitle("Conversor");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setContentPane(contentPane);
	    setLocationRelativeTo(null);
	    setResizable(false);
	    setSize(368,189);
	}
	
	
	
	
}
