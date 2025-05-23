package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import models.AuthModel;
import controllers.HomeController;

public class AuthView extends JFrame
{
	Font titulo = new Font("Cambria", Font.BOLD, 32);
	Font subtitulo = new Font("Cambria Math", Font.PLAIN, 20);
	Font mini = new Font("Cambria Math", Font.PLAIN, 14);
	
	private JTextField nombre;
	private JPasswordField password;
	private AuthModel modelo;
	private HomeController hm;
	
	public AuthView()
	{
		hm = new HomeController();
		modelo = new AuthModel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(400, 400));
	}
	
	public void login()
	{
		this.getContentPane().removeAll();
		
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
					{
						dispose();
						hm.home();
					}
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
				register();
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
	
	public void register()
	{
		this.getContentPane().removeAll();
		
		this.setSize(500, 800);
		this.setTitle("Registro");
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(this.WIDTH, this.HEIGHT);
		panel.setOpaque(true);
		panel.setLayout(null);
		panel.setBackground(new Color(152, 190, 250));
		
		// JLabels
		
		JLabel registro = new JLabel("Registro");
		registro.setSize(160, 40);
		registro.setLocation(160, 10);
		registro.setBackground(new Color(83, 143, 237));
		registro.setOpaque(true);
		registro.setFont(titulo);
		registro.setHorizontalAlignment(JLabel.CENTER);
		panel.add(registro);
		
		JLabel labelNombre = new JLabel("Nombre de usuario:");
		labelNombre.setSize(190, 30);
		labelNombre.setLocation(165, 90);
		labelNombre.setFont(subtitulo);
		labelNombre.setHorizontalAlignment(JLabel.LEFT);
		panel.add(labelNombre);
		
		JLabel labelBio = new JLabel("Escriba una breve biografía:");
		labelBio.setSize(250, 30);
		labelBio.setLocation(130, 190);
		labelBio.setFont(subtitulo);
		labelBio.setHorizontalAlignment(JLabel.LEFT);
		panel.add(labelBio);
		
		JLabel labelPreferencia = new JLabel("Escoja sus preferencias:");
		labelPreferencia.setSize(250, 30);
		labelPreferencia.setLocation(150, 355);
		labelPreferencia.setFont(subtitulo);
		labelPreferencia.setHorizontalAlignment(JLabel.LEFT);
		panel.add(labelPreferencia);
		
		JLabel labelTerminos = new JLabel("¿Usted acepta los términos?");
		labelTerminos.setSize(250, 30);
		labelTerminos.setLocation(130, 455);
		labelTerminos.setFont(subtitulo);
		labelTerminos.setHorizontalAlignment(JLabel.LEFT);
		panel.add(labelTerminos);
		
		JLabel labelColonia = new JLabel("Elija su colonia:");
		labelColonia.setSize(250, 30);
		labelColonia.setLocation(175, 550);
		labelColonia.setFont(subtitulo);
		labelColonia.setHorizontalAlignment(JLabel.LEFT);
		panel.add(labelColonia);
		
		
		// JTextField
		
		JTextField nombre = new JTextField();
		nombre.setSize(300, 30);
		nombre.setLocation(90, 130);
		nombre.setLayout(null);
		panel.add(nombre);
		
		
		// JTextArea
		
		JTextArea bio = new JTextArea();
		bio.setSize(400, 100);
		bio.setLocation(40, 230);
		bio.setLayout(null);
		panel.add(bio);
		
		
		// JCheckBox
		
		JCheckBox dulces = new JCheckBox("Dulces");
		dulces.setSize(80, 20);
		dulces.setLocation(100, 395);
		dulces.setOpaque(false);
		dulces.setLayout(null);
		dulces.setFont(mini);
		panel.add(dulces);
		
		JCheckBox salado = new JCheckBox("Salado");
		salado.setSize(80, 20);
		salado.setLocation(210, 395);
		salado.setOpaque(false);
		salado.setLayout(null);
		salado.setFont(mini);
		panel.add(salado);
		
		JCheckBox saludable = new JCheckBox("Saludable");
		saludable.setSize(100, 20);
		saludable.setLocation(315, 395);
		saludable.setOpaque(false);
		saludable.setLayout(null);
		saludable.setFont(mini);
		panel.add(saludable);
		
		
		// JRadioButton
		
		ButtonGroup terminos = new ButtonGroup();
		
		JRadioButton terms1 = new JRadioButton("Acepto los términos");
		terms1.setLocation(80, 485);
		terms1.setSize(150, 40);
		terms1.setOpaque(false);
		panel.add(terms1);
		
		JRadioButton terms2 = new JRadioButton("Rechazo los términos");
		terms2.setLocation(260, 485);
		terms2.setSize(180, 40);
		terms2.setOpaque(false);
		panel.add(terms2);
		
		terminos.add(terms1);
		terminos.add(terms2);
		
		// JComboBox
		
		String [] coloniasDataSet = {"Centro", "Villas del encanto", "Pedregal", "Agua escondida", "Balandra"};
		
		JComboBox colonias = new JComboBox(coloniasDataSet);
		colonias.setLocation(150, 590);
		colonias.setSize(180, 40);
		colonias.setLayout(null);
		panel.add(colonias);
		
		
		// JButton
		
		JButton registrarse = new JButton("Crear cuenta");
		registrarse.setSize(300, 50);
		registrarse.setLocation(90, 670);
		registrarse.setFont(subtitulo);
		registrarse.setLayout(null);
		panel.add(registrarse);
		
		JButton volver = new JButton("Volver");
		volver.setSize(90, 30);
		volver.setLocation(20, 15);
		volver.setFont(mini);
		volver.setLayout(null);
		panel.add(volver);
	
		// Le ponemos un ActionListener a los botones
		
		registrarse.addActionListener(new ActionListener()  
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				terms1.setBorderPainted(true);
				dulces.setBorderPainted(true);
				boolean p1 = false, p2 = false, p3 = false, p4 = false;
				
				if (nombre.getText().equals("") || nombre.getText().trim().isEmpty())
					nombre.setBorder(BorderFactory.createLineBorder(Color.red, 3));
				else
				{
					nombre.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					p1 = true;
				}
				
				if (bio.getText().equals(""))
					bio.setBorder(BorderFactory.createLineBorder(Color.red, 3));
				else
				{
					bio.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					p2 = true;
				}
				
				if (dulces.isSelected() || salado.isSelected() || saludable.isSelected())
				{
					dulces.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					p3 = true;
				}
				else
					dulces.setBorder(BorderFactory.createLineBorder(Color.red, 3));
				
				if (terms1.isSelected())
				{
					terms1.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					p4 = true;
				}
				else
					terms1.setBorder(BorderFactory.createLineBorder(Color.red, 3));
				
				if (p1 && p2 && p3 && p4)
				{
					String pref = "";
					
					if (dulces.isSelected())
						pref = "Dulces";
					
					if (salado.isSelected())
						if (dulces.isSelected())
							pref += ", Salado";
						else
							pref += "Salado";
					
					if (saludable.isSelected())
						if (dulces.isSelected() || salado.isSelected())
							pref += ", Saludable";
						else
							pref += "Saludable";
					
					
					modelo.register(nombre.getText(), bio.getText(), pref, colonias.getSelectedItem().toString());
				}
				
				
			}
			
		});
		
		volver.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				login();
			}
			
		});
		
		panel.revalidate();

		this.add(panel);
		this.repaint();
	}
	
	public void formulario()
	{
		this.getContentPane().removeAll();
		
		this.setSize(700, 800);
		this.setTitle("Formulario");
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(this.WIDTH, this.HEIGHT);
		panel.setOpaque(true);
		panel.setLayout(null);
		
		
		// JLabels
		
		JLabel tituloForm = new JLabel("Formulario de Registro");
		tituloForm.setSize(400, 40);
		tituloForm.setLocation(145, 10);
		tituloForm.setBackground(Color.DARK_GRAY);
		tituloForm.setForeground(Color.white);
		tituloForm.setOpaque(true);
		tituloForm.setFont(titulo);
		tituloForm.setHorizontalAlignment(JLabel.CENTER);
		panel.add(tituloForm);
		
		JLabel labelNombre = new JLabel("Nombres:");
		labelNombre.setSize(100, 40);
		labelNombre.setLocation(130, 90);
		labelNombre.setForeground(Color.black);
		labelNombre.setFont(subtitulo);
		labelNombre.setHorizontalAlignment(JLabel.CENTER);
		panel.add(labelNombre);
		
		JLabel labelApellidos = new JLabel("Apellidos:");
		labelApellidos.setSize(100, 40);
		labelApellidos.setLocation(130, 160);
		labelApellidos.setForeground(Color.black);
		labelApellidos.setFont(subtitulo);
		labelApellidos.setHorizontalAlignment(JLabel.CENTER);
		panel.add(labelApellidos);
		
		JLabel labelEmpresa = new JLabel("Empresa/Institución:");
		labelEmpresa.setSize(200, 40);
		labelEmpresa.setLocation(30, 230);
		labelEmpresa.setForeground(Color.black);
		labelEmpresa.setFont(subtitulo);
		labelEmpresa.setHorizontalAlignment(JLabel.CENTER);
		panel.add(labelEmpresa);
		
		JLabel labelAmbito = new JLabel("Ámbito de la empresa:");
		labelAmbito.setSize(200, 40);
		labelAmbito.setLocation(27, 290);
		labelAmbito.setForeground(Color.black);
		labelAmbito.setFont(subtitulo);
		labelAmbito.setHorizontalAlignment(JLabel.CENTER);
		panel.add(labelAmbito);
		
		JLabel labelCargo = new JLabel("Cargo:");
		labelCargo.setSize(100, 40);
		labelCargo.setLocation(145, 360);
		labelCargo.setForeground(Color.black);
		labelCargo.setFont(subtitulo);
		labelCargo.setHorizontalAlignment(JLabel.CENTER);
		panel.add(labelCargo);
		
		JLabel labelUsuario = new JLabel("Nombre de usuario:");
		labelUsuario.setSize(200, 40);
		labelUsuario.setLocation(35, 430);
		labelUsuario.setForeground(Color.black);
		labelUsuario.setFont(subtitulo);
		labelUsuario.setHorizontalAlignment(JLabel.CENTER);
		panel.add(labelUsuario);
		
		JLabel labelPassword = new JLabel("Contraseña:");
		labelPassword.setSize(150, 40);
		labelPassword.setLocation(95, 500);
		labelPassword.setForeground(Color.black);
		labelPassword.setFont(subtitulo);
		labelPassword.setHorizontalAlignment(JLabel.CENTER);
		panel.add(labelPassword);
		
		JLabel labelRPassword = new JLabel("Repetir contraseña:");
		labelRPassword.setSize(175, 40);
		labelRPassword.setLocation(50, 570);
		labelRPassword.setForeground(Color.black);
		labelRPassword.setFont(subtitulo);
		labelRPassword.setHorizontalAlignment(JLabel.CENTER);
		panel.add(labelRPassword);
		
		JLabel labelCorreo = new JLabel("Correo electrónico:");
		labelCorreo.setSize(175, 40);
		labelCorreo.setLocation(50, 640);
		labelCorreo.setForeground(Color.black);
		labelCorreo.setFont(subtitulo);
		labelCorreo.setHorizontalAlignment(JLabel.CENTER);
		panel.add(labelCorreo);
		
		
		// JTextField
		
		nombre = new JTextField();
		nombre.setSize(300, 40);
		nombre.setLocation(240, 90);
		nombre.setLayout(null);
		nombre.setBorder(new LineBorder(Color.black, 3, true));
		panel.add(nombre);
		
		JTextField apellidos = new JTextField();
		apellidos.setSize(300, 40);
		apellidos.setLocation(240, 160);
		apellidos.setLayout(null);
		apellidos.setBorder(new LineBorder(Color.black, 3, true));
		panel.add(apellidos);
		
		JTextField empresa = new JTextField();
		empresa.setSize(300, 40);
		empresa.setLocation(240, 230);
		empresa.setLayout(null);
		empresa.setBorder(new LineBorder(Color.black, 3, true));
		panel.add(empresa);
		
		JTextField cargo = new JTextField();
		cargo.setSize(300, 40);
		cargo.setLocation(240, 360);
		cargo.setLayout(null);
		cargo.setBorder(new LineBorder(Color.black, 3, true));
		panel.add(cargo);
		
		JTextField usuario = new JTextField();
		usuario.setSize(300, 40);
		usuario.setLocation(240, 430);
		usuario.setLayout(null);
		usuario.setBorder(new LineBorder(Color.black, 3, true));
		panel.add(usuario);
		
		password = new JPasswordField();
		password.setSize(300, 40);
		password.setLocation(240, 500);
		password.setLayout(null);
		password.setBorder(new LineBorder(Color.black, 3, true));
		panel.add(password);
		
		JPasswordField RPassword = new JPasswordField();
		RPassword.setSize(300, 40);
		RPassword.setLocation(240, 570);
		RPassword.setLayout(null);
		RPassword.setBorder(new LineBorder(Color.black, 3, true));
		panel.add(RPassword);
		
		JTextField correo = new JTextField();
		correo.setSize(300, 40);
		correo.setLocation(240, 640);
		correo.setLayout(null);
		correo.setBorder(new LineBorder(Color.black, 3, true));
		panel.add(correo);
		
		
		// JComboBox
		
		String [] stringAmbito = {"Tecnología", "Salud", "Educación", "Comercio", "Otro"};
		
		JComboBox ambito = new JComboBox(stringAmbito);
		ambito.setLocation(240, 290);
		ambito.setSize(300, 40);
		ambito.setLayout(null);
		panel.add(ambito);
		
		
		// JButton
		
		JButton registrarse = new JButton("Regístrate");
		registrarse.setSize(130, 40);
		registrarse.setLocation(275, 700);
		registrarse.setBackground(Color.darkGray);
		registrarse.setForeground(Color.white);
		registrarse.setFont(subtitulo);
		registrarse.setLayout(null);
		registrarse.setBorder(new LineBorder(Color.black, 3, true));
		panel.add(registrarse);
		
		registrarse.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				registrarse.setBackground(Color.gray);
			}
			
			public void mouseExited(MouseEvent e)
			{
				registrarse.setBackground(Color.darkGray);
			}
		});
		
		registrarse.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String pass = new String(password.getPassword());
				String RPass = new String(RPassword.getPassword());
				
				Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(pass); 
				
				if (nombre.getText().matches("[a-zA-Z\\s]+"))
					if (apellidos.getText().matches("[a-zA-Z\\s]+"))
						if (empresa.getText().matches("[a-zA-Z0-9\\s]+"))
							if (cargo.getText().matches("[a-zA-Z\\s]+"))
								if (usuario.getText().matches("[a-zA-Z0-9\\s]+"))
									if (pass.matches("\\S+") && m.find())
										if (RPass.equals(pass))
											if (correo.getText().matches("\\S+"))
												try 
												{
													modelo.registrar(nombre.getText(), apellidos.getText(), empresa.getText(), ambito.getSelectedItem().toString(), cargo.getText(), usuario.getText(), pass, correo.getText());
												} 
												catch (IOException e1) 
												{
													System.out.println("Error: " + e1.getMessage());
												}
											else
												JOptionPane.showMessageDialog(panel, "El correo no tiene que tener espacios", "Caracteres inválidos", JOptionPane.ERROR_MESSAGE);
										else
											JOptionPane.showMessageDialog(panel, "Las contraseñas tienen que coincidir", "Caracteres inválidos", JOptionPane.ERROR_MESSAGE);
									else
										JOptionPane.showMessageDialog(panel, "La contraseña tiene que tener al menos un caracter especial y no puede tener espacios", "Caracteres inválidos", JOptionPane.ERROR_MESSAGE);
								else
									JOptionPane.showMessageDialog(panel, "El nombre de usuario solo puede tener letras, números y espacios", "Caracteres inválidos", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog(panel, "El cargo solo puede tener letras y espacios", "Caracteres inválidos", JOptionPane.ERROR_MESSAGE);
						else
							JOptionPane.showMessageDialog(panel, "La empresa/institución solo puede tener letras, números y espacios", "Caracteres inválidos", JOptionPane.ERROR_MESSAGE);
					else
						JOptionPane.showMessageDialog(panel, "Los apellidos solo puede tener letras y espacios", "Caracteres inválidos", JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(panel, "El nombre solo puede tener letras y espacios", "Caracteres inválidos", JOptionPane.ERROR_MESSAGE);
			}
			
		});
		
		
		panel.revalidate();

		this.add(panel);
		this.repaint();
		this.setVisible(true);
	}
}
