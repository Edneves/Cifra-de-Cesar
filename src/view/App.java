package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import projetoCripto.CriarArquivo;
import projetoCripto.Criptografar;
import projetoCripto.Descriptografar;
import projetoCripto.LeArquivo;

public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setTitle("Editor de Arquivos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(86, 10, 415, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCaminho = new JLabel("Caminho:");
		lblCaminho.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblCaminho.setBounds(10, 11, 76, 14);
		panel.add(lblCaminho);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(20, 67, 481, 239);
		panel.add(textArea);
		
		JLabel lblDigiteSeuTexto = new JLabel("Digite seu Texto:");
		lblDigiteSeuTexto.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblDigiteSeuTexto.setBounds(20, 41, 143, 23);
		panel.add(lblDigiteSeuTexto);
		
// Botão Abrir		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser abrirArq = new JFileChooser();
				abrirArq.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int abrir  = abrirArq.showOpenDialog(null);
				if(abrir == JFileChooser.APPROVE_OPTION) {
				
					JOptionPane.showMessageDialog(null, "Você abriu um arquivo!");
					File endereco = abrirArq.getSelectedFile();
					textField.setText(endereco.getPath());
					String chave = JOptionPane.showInputDialog(null, "Digite a chave!");
					
					int senha = chave.length();
					textArea.setText(LeArquivo.ler(endereco.getPath().toString()));
					String texto = textArea.getText();
					textArea.setText(Descriptografar.descriptografa(senha, texto));
					
						
				}else {
					JOptionPane.showMessageDialog(null, "Você não escolheu o arquivo para abrir!");
				}	
			}
		});
		btnAbrir.setBounds(52, 317, 99, 23);
		panel.add(btnAbrir);
		
//Botão Salvar		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser salvarArq = new JFileChooser();
				salvarArq.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int salvar  = salvarArq.showSaveDialog(null);
				if(salvar == JFileChooser.APPROVE_OPTION) {
					
					File endereco = salvarArq.getSelectedFile();
					textField.setText(endereco.getPath());
					String chave = JOptionPane.showInputDialog(null, "Digite a chave!");
					int senha = chave.length();
					String texto = textArea.getText();
					
					textArea.setText(Criptografar.criptografa(senha, texto));
					CriarArquivo.escrever(endereco.toString(), textArea.getText());
					textArea.setText(texto);
					JOptionPane.showMessageDialog(null, "Você salvou o arquivo!");
					textArea.setText(null);
					
				}else {
					JOptionPane.showMessageDialog(null, "Você cancelou a operação!");
				}
			}
		});
		btnSalvar.setBounds(203, 317, 99, 23);
		panel.add(btnSalvar);
		
//Botão Criar Arquivo		
		JButton btnCriarArq = new JButton("Criar Novo Arquivo");
		btnCriarArq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser criarArq = new JFileChooser();
				criarArq.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int salvar  = criarArq.showSaveDialog(null);
				if(salvar == JFileChooser.APPROVE_OPTION) {
					
					File endereco = criarArq.getSelectedFile();
					textField.setText(endereco.getPath());
					CriarArquivo.escrever(endereco.toString(), textArea.getText());
					JOptionPane.showMessageDialog(null, "Você criou o arquivo");
					
				}else {
					JOptionPane.showMessageDialog(null, "Você desistiu de criar o arquivo!");
				}
			}
		});
		
		btnCriarArq.setBounds(347, 317, 154, 23);
		panel.add(btnCriarArq);
	}
}

