package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import models.AuthModel;

public class AuthView extends JFrame
{
	Font titulo = new Font("Cambria", Font.BOLD, 32);
	Font subtitulo = new Font("Cambria Math", Font.PLAIN, 20);
	Font mini = new Font("Cambria Math", Font.PLAIN, 14);
	
	private JTextField nombre;
	private JPasswordField password;
	private AuthModel modelo;	
	
	public AuthView()
	{
		modelo = new AuthModel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(400, 400));
	}
	
	public void login()
	{
		this.setSize(800, 730);
		this.setTitle("Login");
		this.setLocationRelativeTo(null);
		
		JPanel panelAfuera = new JPanel();
		panelAfuera.setLocation(0, 0);
		panelAfuera.setSize(this.WIDTH, this.HEIGHT);
		panelAfuera.setOpaque(true);
		panelAfuera.setBackground(new Color(61, 98, 219));
		panelAfuera.setLayout(null);
		
		JPanel panelAdentro = new JPanel();
		panelAdentro.setLocation(160, 90);
		panelAdentro.setSize(470, 450);
		panelAdentro.setOpaque(true);
		panelAdentro.setLayout(null);
		panelAdentro.setBackground(Color.white);
		panelAdentro.setBorder(new LineBorder(new Color(16, 47, 125), 6));
		
		
		// JLabels
		
		JLabel bienvenida = new JLabel("Bienvenido/a");
		bienvenida.setSize(210, 40);
		bienvenida.setLocation(285, 10);
		bienvenida.setBackground(new Color(43, 107, 217));
		bienvenida.setForeground(Color.white);
		bienvenida.setOpaque(true);
		bienvenida.setFont(titulo);
		bienvenida.setHorizontalAlignment(JLabel.CENTER);
		panelAfuera.add(bienvenida);
		
		JLabel accede = new JLabel("Accede con tu cuenta");
		accede.setSize(320, 40);
		accede.setLocation(75, 15);
		accede.setFont(titulo);
		accede.setHorizontalAlignment(JLabel.CENTER);
		panelAdentro.add(accede);
		
		JLabel labelNombre = new JLabel("E-mail o nombre de usuario:");
		labelNombre.setSize(250, 20);
		labelNombre.setLocation(90, 100);
		labelNombre.setFont(subtitulo);
		labelNombre.setHorizontalAlignment(JLabel.LEFT);
		panelAdentro.add(labelNombre);
		
		JLabel labelPassword = new JLabel("Contraseña:");
		labelPassword.setSize(180, 20);
		labelPassword.setLocation(90, 210);
		labelPassword.setFont(subtitulo);
		labelPassword.setHorizontalAlignment(JLabel.LEFT);
		panelAdentro.add(labelPassword);
		
		JLabel olvidar = new JLabel("¿Olvidó su contraseña?");
		olvidar.setSize(150, 20);
		olvidar.setLocation(250, 290);
		olvidar.setFont(mini);
		olvidar.setForeground(new Color(78, 118, 245));
		olvidar.setHorizontalAlignment(JLabel.LEFT);
		panelAdentro.add(olvidar);
		
		JLabel labelRegistro = new JLabel("¿No tienes una cuenta?");
		labelRegistro.setSize(150, 20);
		labelRegistro.setLocation(325, 560);
		labelRegistro.setFont(mini);
		labelRegistro.setForeground(Color.white);
		labelRegistro.setHorizontalAlignment(JLabel.LEFT);
		panelAfuera.add(labelRegistro);
		
		
		// JTextField
		
		nombre = new JTextField();
		nombre.setSize(300, 40);
		nombre.setLocation(90, 130);
		nombre.setLayout(null);
		nombre.setBorder(new LineBorder(Color.black, 3, true));
		panelAdentro.add(nombre);
		
		
		
		// JPasswordField
		
		password = new JPasswordField();
		password.setSize(300, 40);
		password.setLocation(90, 240);
		password.setLayout(null);
		password.setBorder(new LineBorder(Color.black, 3, true));
		panelAdentro.add(password);
		
		
		// JCheckBox
		
		JCheckBox recordar = new JCheckBox("Recordarme");
		recordar.setSize(120, 20);
		recordar.setLocation(90, 290);
		recordar.setOpaque(false);
		recordar.setLayout(null);
		recordar.setFont(mini);
		panelAdentro.add(recordar);
		
		
		// JButton
		
		JButton acceder = new JButton("Acceder");
		acceder.setSize(130, 50);
		acceder.setLocation(170, 350);
		acceder.setBackground(new Color(11, 156, 154));
		acceder.setForeground(Color.white);
		acceder.setFont(subtitulo);
		acceder.setLayout(null);
		acceder.setBorder(new LineBorder(Color.black, 3, true));
		panelAdentro.add(acceder);
		
		JButton registrar = new JButton("Regístrate");
		registrar.setSize(130, 50);
		registrar.setLocation(330, 590);
		registrar.setBackground(new Color(11, 60, 219));
		registrar.setForeground(Color.white);
		registrar.setFont(subtitulo);
		registrar.setLayout(null);
		registrar.setBorder(new LineBorder(Color.black, 3, true));
		panelAfuera.add(registrar);
		
		// Le ponemos un evento de Mouse a los botones
		
		acceder.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				acceder.setBackground(new Color(97, 186, 186));
			}
			
			public void mouseExited(MouseEvent e)
			{
				acceder.setBackground(new Color(11, 156, 154));
			}
		});
		
		registrar.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				registrar.setBackground(new Color(41, 83, 217));
			}
			
			public void mouseExited(MouseEvent e)
			{
				registrar.setBackground(new Color(11, 60, 219));
			}
		});
		
		// Le ponemos un ActionListener a los botones
		
		acceder.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				boolean p1 = false, p2 = false;
				String pass = new String(password.getPassword());
				
				if (nombre.getText().equals("") || nombre.getText().trim().isEmpty())
					nombre.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				else
				{
					nombre.setBorder(BorderFactory.createLineBorder(Color.green, 5));
					p1 = true;
				}
				
				if (password.getPassword().length < 6 || pass.trim().isEmpty())
					password.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				else
				{
					password.setBorder(BorderFactory.createLineBorder(Color.green, 5));
					p2 = true;
				}
				
				if (p1 && p2)
				{
					if (modelo.autenticar(nombre.getText(), pass))
						JOptionPane.showMessageDialog(panelAfuera, "Bienvenido de vuelta, admin!", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
					else
	 					JOptionPane.showMessageDialog(panelAfuera, "Nombre de usuario o contraseña incorrectos.", "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
				}
			}
				
		});
		
		registrar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
			}
			
		});
		
		
		// ImageIcon
		
		JLabel imagenUsuario = new JLabel(new ImageIcon(getClass().getResource("images/user.png")));
		imagenUsuario.setSize(32, 32);
		imagenUsuario.setLocation(50, 133);
		panelAdentro.add(imagenUsuario);
		
		JLabel imagenClave = new JLabel(new ImageIcon(getClass().getResource("images/lock.png")));
		imagenClave.setSize(32, 32);
		imagenClave.setLocation(50, 242);
		panelAdentro.add(imagenClave);
		
		JLabel imagenOjo = new JLabel(new ImageIcon(getClass().getResource("images/eye.png")));
		imagenOjo.setSize(32, 32);
		imagenOjo.setLocation(400, 244);
		panelAdentro.add(imagenOjo);
		

		panelAdentro.revalidate();
		
		panelAfuera.add(panelAdentro);
		
		panelAfuera.revalidate();
		
		this.add(panelAfuera);
		
		this.repaint();
		this.setVisible(true);
	}
}
