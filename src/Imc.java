import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Imc implements ActionListener {
	
	JLabel label;
	JLabel label2;
	JLabel resposta;
	JTextField altura;
	JTextField peso;
	
	JButton limpar;
	
	ImageIcon img;
	ImageIcon img1;
	ImageIcon img2;
	ImageIcon img3;
	ImageIcon img4;
	ImageIcon img5;
	ImageIcon img6;
	ImageIcon img7;
	
	public Imc() {
		
		JFrame frame = new JFrame("IMC");
		frame.setVisible(true);
		frame.setSize(650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		label = new JLabel("Altura (cm): ");
		frame.add(label);
		
		altura = new JTextField(10);
		altura.addActionListener(this);
		altura.setActionCommand("Enter");
		frame.add(altura);
		
		label2 = new JLabel("Peso (Kg): ");
		frame.add(label2);
		
		peso = new JTextField(10);
		peso.addActionListener(this);
		peso.setActionCommand("Enter");
		frame.add(peso);
		
		JButton button = new JButton("Calcular");
		button.addActionListener(this);
//		button.setActionCommand("Enter");
		frame.add(button);
		
		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(this);
		frame.add(limpar);

		img = new ImageIcon("img/imc.jpg");
		img1 = new ImageIcon("img/imc01.jpg");
		img2 = new ImageIcon("img/imc02.jpg");
		img3 = new ImageIcon("img/imc03.jpg");
		img4 = new ImageIcon("img/imc04.jpg");
		img5 = new ImageIcon("img/imc05.jpg");
		img6 = new ImageIcon("img/imc06.jpg");
		img7 = new ImageIcon("img/imc07.jpg");
		
		resposta = new JLabel(img);
		frame.add(resposta);

	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {

				new Imc();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		float alt = Integer.parseInt(altura.getText());
		float pes = Integer.parseInt(peso.getText());
		float alturaCM = (alt/100) * (alt/100);
		float calculoImc = (pes/alturaCM);
		 
		
		if(e.getActionCommand().equalsIgnoreCase("Calcular")) {
		
		if(altura.getText().equals("") && peso.getText().equals("")) {
			resposta.setText("Digite um valor para altura e peso!");
		}
		
		if(calculoImc < 17){
		
			resposta.setIcon(img1);
		}else
		if(calculoImc < 19) {
			resposta.setIcon(img2);
		}else
		if(calculoImc < 25) {
			resposta.setIcon(img3);
		}else
		if(calculoImc  < 30) {
			resposta.setIcon(img4);
		}else
		if(calculoImc < 35) {
			resposta.setIcon(img5);
		}else
		if(calculoImc < 40) {
			resposta.setIcon(img6);
		}else
		if(calculoImc > 40) {
			resposta.setIcon(img6);
			}
		
			
		}
		if(e.getActionCommand().equalsIgnoreCase("Limpar")) { 
		altura.setText("");
		peso.setText("");
		}
		
	}

}






