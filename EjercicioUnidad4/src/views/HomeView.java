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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.AuthController;
import controllers.ProductController;


public class HomeView extends JFrame 
{
	
	Font titulo = new Font("Cambria", Font.BOLD, 32);
	Font subtitulo = new Font("Cambria Math", Font.PLAIN, 20);
	Font mini = new Font("Cambria Math", Font.PLAIN, 14);
	
	AuthController ac;
	ProductController pc;
	
	public HomeView()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(400, 400));
	}
	
	public void home()
	{
		this.getContentPane().removeAll();
		
		this.setSize(800, 700);
		this.setTitle("Home");
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(this.WIDTH, this.HEIGHT);
		panel.setOpaque(true);
		panel.setBackground(new Color(208, 220, 242));
		panel.setLayout(new BorderLayout(20, 50));
		
		JPanel panelCentro = new JPanel();
		panelCentro.setOpaque(true);
		panelCentro.setLayout(new GridLayout(0, 4, 10, 5));
		panelCentro.setBackground(new Color(43, 107, 217));
		panelCentro.setBorder(BorderFactory.createLineBorder(new Color(25, 58, 117), 5));
		panel.add(panelCentro, BorderLayout.CENTER);
		
		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setOpaque(true);
		panelIzquierda.setLayout(new GridLayout(0, 4));
		panelIzquierda.setBackground(new Color(208, 220, 242));
		panel.add(panelIzquierda, BorderLayout.WEST);
		
		JPanel panelDerecha = new JPanel();
		panelDerecha.setOpaque(true);
		panelDerecha.setLayout(new GridLayout(0, 4));
		panelDerecha.setBackground(new Color(208, 220, 242));
		panel.add(panelDerecha, BorderLayout.EAST);
		
		JPanel panelAbajo = new JPanel();
		panelAbajo.setOpaque(true);
		panelAbajo.setLayout(new GridLayout(0, 1));
		panelAbajo.setBackground(new Color(43, 107, 217));
		panelAbajo.setBorder(BorderFactory.createLineBorder(new Color(25, 58, 117), 5));
		panel.add(panelAbajo, BorderLayout.SOUTH);
		
		
		// JLabels
		
		JLabel home = new JLabel("Home");
		home.setBackground(new Color(43, 107, 217));
		home.setForeground(Color.white);
		home.setOpaque(true);
		home.setFont(titulo);
		home.setBorder(BorderFactory.createLineBorder(new Color(25, 58, 117), 5));
		home.setHorizontalAlignment(JLabel.CENTER);
		panel.add(home, BorderLayout.NORTH);
		
		JLabel espacio = new JLabel(" ");
		espacio.setFont(titulo);
		espacio.setHorizontalAlignment(JLabel.CENTER);
		panelAbajo.add(espacio);
		
		JLabel espacio2 = new JLabel(" ");
		espacio2.setFont(titulo);
		espacio2.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio2);
		
		JLabel espacio3 = new JLabel(" ");
		espacio3.setFont(titulo);
		espacio3.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio3);
		
		JLabel espacio4 = new JLabel(" ");
		espacio4.setFont(titulo);
		espacio4.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio4);
		
		JLabel espacio5 = new JLabel(" ");
		espacio5.setFont(titulo);
		espacio5.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio5);
		
		JLabel espacio21 = new JLabel(" ");
		espacio21.setFont(titulo);
		espacio21.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio21);
		
		JLabel espacio22 = new JLabel(" ");
		espacio22.setFont(titulo);
		espacio22.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio22);
		
		JLabel espacio23 = new JLabel(" ");
		espacio23.setFont(titulo);
		espacio23.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio23);
		
		JLabel espacio24 = new JLabel(" ");
		espacio24.setFont(titulo);
		espacio24.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio24);
		
		
		JLabel hora = new JLabel("Hora: 08:23:35", new ImageIcon(getClass().getResource("images/clock.png")), JLabel.LEFT);
		hora.setBackground(new Color(43, 107, 217));
		hora.setForeground(Color.white);
		hora.setOpaque(true);
		hora.setFont(mini);
		hora.setBorder(BorderFactory.createLineBorder(Color.cyan, 3));
		hora.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(hora);
		
		JLabel messages = new JLabel("Mensajes hoy: 957", new ImageIcon(getClass().getResource("images/message.png")), JLabel.LEFT);
		messages.setBackground(new Color(43, 107, 217));
		messages.setForeground(Color.white);
		messages.setOpaque(true);
		messages.setFont(mini);
		messages.setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
		messages.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(messages);
		
		JLabel users = new JLabel("En línea: 157", new ImageIcon(getClass().getResource("images/users.png")), JLabel.LEFT);
		users.setBackground(new Color(43, 107, 217));
		users.setForeground(Color.white);
		users.setOpaque(true);
		users.setFont(mini);
		users.setBorder(BorderFactory.createLineBorder(Color.pink, 3));
		users.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(users);
		
		JLabel visitors = new JLabel("Visitas hoy: 1263", new ImageIcon(getClass().getResource("images/visitors.png")), JLabel.LEFT);
		visitors.setBackground(new Color(43, 107, 217));
		visitors.setForeground(Color.white);
		visitors.setOpaque(true);
		visitors.setFont(mini);
		visitors.setBorder(BorderFactory.createLineBorder(Color.green, 3));
		visitors.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(visitors);
		
		
		JLabel espacio6 = new JLabel(" ");
		espacio6.setFont(titulo);
		espacio6.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio6);
		
		JLabel espacio7 = new JLabel(" ");
		espacio7.setFont(titulo);
		espacio7.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio7);
		
		JLabel espacio8 = new JLabel(" ");
		espacio8.setFont(titulo);
		espacio8.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio8);
		
		JLabel espacio9 = new JLabel(" ");
		espacio9.setFont(titulo);
		espacio9.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio9);
		
		JLabel espacio15 = new JLabel(" ");
		espacio15.setFont(titulo);
		espacio15.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio15);
		
		JLabel espacio16 = new JLabel(" ");
		espacio16.setFont(titulo);
		espacio16.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio16);
		
		JLabel espacio17 = new JLabel(" ");
		espacio17.setFont(titulo);
		espacio17.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio17);
		
		JLabel espacio18 = new JLabel(" ");
		espacio18.setFont(titulo);
		espacio18.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio18);
		
		// JButtons
		
		JButton usuarios = new JButton("Usuarios");
		usuarios.setBackground(new Color(66, 119, 212));
		usuarios.setForeground(Color.white);
		usuarios.setFont(subtitulo);
		usuarios.setHorizontalAlignment(JLabel.CENTER);
		usuarios.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panelCentro.add(usuarios);
		
		usuarios.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				usuarios.setBackground(new Color(95, 138, 212));
			}
			
			public void mouseExited(MouseEvent e)
			{
				usuarios.setBackground(new Color(66, 119, 212));
			}
		});
		
		usuarios.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(panel, "Ejemplo de usuarios.", "Usuarios", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		
		JButton registros = new JButton("Registros");
		registros.setBackground(new Color(66, 119, 212));
		registros.setForeground(Color.white);
		registros.setFont(subtitulo);
		registros.setHorizontalAlignment(JLabel.CENTER);
		registros.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panelCentro.add(registros);
		
		registros.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				registros.setBackground(new Color(95, 138, 212));
			}
			
			public void mouseExited(MouseEvent e)
			{
				registros.setBackground(new Color(66, 119, 212));
			}
		});
		
		registros.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(panel, "Ejemplo de registros.", "Registros", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		
		JButton configuracion = new JButton("Configuración");
		configuracion.setBackground(new Color(66, 119, 212));
		configuracion.setForeground(Color.white);
		configuracion.setFont(subtitulo);
		configuracion.setHorizontalAlignment(JLabel.CENTER);
		configuracion.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panelCentro.add(configuracion);
		
		configuracion.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				configuracion.setBackground(new Color(95, 138, 212));
			}
			
			public void mouseExited(MouseEvent e)
			{
				configuracion.setBackground(new Color(66, 119, 212));
			}
		});
		
		configuracion.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(panel, "Ejemplo de configuración.", "Configuración", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		JButton productos = new JButton("Productos");
		productos.setBackground(new Color(66, 119, 212));
		productos.setForeground(Color.white);
		productos.setFont(subtitulo);
		productos.setHorizontalAlignment(JLabel.CENTER);
		productos.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panelCentro.add(productos);
		
		productos.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				productos.setBackground(new Color(95, 138, 212));
			}
			
			public void mouseExited(MouseEvent e)
			{
				productos.setBackground(new Color(66, 119, 212));
			}
		});
		
		productos.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				pc = new ProductController();
				pc.productos();
			}
			
		});
		
		
		JButton salir = new JButton("Salir");
		salir.setBackground(new Color(66, 119, 212));
		salir.setForeground(Color.white);
		salir.setFont(subtitulo);
		salir.setHorizontalAlignment(JLabel.CENTER);
		salir.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panelCentro.add(salir);
		
		salir.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				salir.setBackground(new Color(95, 138, 212));
			}
			
			public void mouseExited(MouseEvent e)
			{
				salir.setBackground(new Color(66, 119, 212));
			}
		});
		
		salir.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				ac = new AuthController();
				ac.login();
			}
			
		});
		
		
		// Más espacios
		
		JLabel espacio10 = new JLabel(" ");
		espacio10.setFont(titulo);
		espacio10.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio10);
		
		JLabel espacio11 = new JLabel(" ");
		espacio11.setFont(titulo);
		espacio11.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio11);
		
		JLabel espacio12 = new JLabel(" ");
		espacio12.setFont(titulo);
		espacio12.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio12);
		
		JLabel espacio13 = new JLabel(" ");
		espacio13.setFont(titulo);
		espacio13.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio13);
		
		JLabel espacio14 = new JLabel(" ");
		espacio14.setFont(titulo);
		espacio14.setHorizontalAlignment(JLabel.CENTER);
		panelCentro.add(espacio14);
		
		JLabel espacio19 = new JLabel(" ");
		espacio19.setFont(titulo);
		espacio19.setHorizontalAlignment(JLabel.CENTER);
		panelIzquierda.add(espacio19);
		
		JLabel espacio20 = new JLabel(" ");
		espacio20.setFont(titulo);
		espacio20.setHorizontalAlignment(JLabel.CENTER);
		panelDerecha.add(espacio20);
		
		
		panel.revalidate();
		panelCentro.revalidate();

		this.add(panel);
		this.repaint();
		this.setVisible(true);
	}
}
