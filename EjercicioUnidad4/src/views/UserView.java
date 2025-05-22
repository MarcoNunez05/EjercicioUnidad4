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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.HomeController;
import controllers.ProductController;
import controllers.UserController;
import models.User;

public class UserView extends JFrame 
{
	Font titulo = new Font("Cambria", Font.BOLD, 32);
	Font subtitulo = new Font("Cambria Math", Font.PLAIN, 20);
	Font mini = new Font("Cambria Math", Font.PLAIN, 14);
	
	public UserView() 
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(400, 400));
	}
	
	public void showAllUsers(ArrayList<User> users)
	{
		this.getContentPane().removeAll();
		
		this.setSize(900, 700);
		this.setTitle("Usuarios");
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(this.WIDTH, this.HEIGHT);
		panel.setOpaque(true);
		panel.setBackground(new Color(181, 230, 221));
		panel.setLayout(new BorderLayout(20, 50));
		
		JPanel panelCentro = new JPanel();
		panelCentro.setOpaque(true);
		panelCentro.setLayout(new BorderLayout(20, 10));
		panelCentro.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panel.add(panelCentro, BorderLayout.CENTER);
		
		JPanel panelArriba = new JPanel();
		panelArriba.setOpaque(true);
		panelArriba.setLayout(new BorderLayout());
		panelArriba.setBorder(BorderFactory.createLineBorder(new Color(88, 224, 215), 5));
		panel.add(panelArriba, BorderLayout.NORTH);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setLayout(new GridLayout(0, 2, 20, 10));
		panelCentro.add(panelHeader, BorderLayout.NORTH);
		
		JPanel panelAbajo = new JPanel();
		panelAbajo.setOpaque(true);
		panelAbajo.setLayout(new BorderLayout(20, 50));
		panelAbajo.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panel.add(panelAbajo, BorderLayout.SOUTH);
		
		
		// JLabels
		
		JLabel usuarios = new JLabel("Usuarios");
		usuarios.setForeground(Color.white);
		usuarios.setBackground(new Color(88, 224, 215));
		usuarios.setOpaque(true);
		usuarios.setFont(titulo);
		usuarios.setHorizontalAlignment(JLabel.CENTER);
		panelArriba.add(usuarios, BorderLayout.CENTER);
		
		JLabel espacio = new JLabel("     ");
		espacio.setFont(mini);
		panel.add(espacio, BorderLayout.WEST);
		
		JLabel espacio2 = new JLabel("     ");
		espacio2.setFont(mini);
		panel.add(espacio2, BorderLayout.EAST);
		
		JLabel espacio3 = new JLabel("                           ");
		espacio3.setBackground(new Color(88, 224, 215));
		espacio3.setOpaque(true);
		espacio3.setFont(mini);
		panelArriba.add(espacio3, BorderLayout.EAST);
		
		
		// JButton
		
		JButton actualizar = new JButton("Actualizar");
		actualizar.setBackground(new Color(61, 191, 182));
		actualizar.setForeground(Color.white);
		actualizar.setFont(subtitulo);
		actualizar.setHorizontalAlignment(JLabel.CENTER);
		actualizar.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panelAbajo.add(actualizar, BorderLayout.CENTER);
		
		actualizar.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				actualizar.setBackground(new Color(123, 224, 217));
			}
			
			public void mouseExited(MouseEvent e)
			{
				actualizar.setBackground(new Color(61, 191, 182));
			}
		});
		
		actualizar.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				UserController uc = new UserController();
				showAllUsers(uc.actualizar());
			}
			
		});
		
		JButton regresar = new JButton("Regresar");
		regresar.setBackground(new Color(61, 191, 182));
		regresar.setForeground(Color.white);
		regresar.setFont(subtitulo);
		regresar.setHorizontalAlignment(JLabel.CENTER);
		regresar.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panelArriba.add(regresar, BorderLayout.WEST);
		
		regresar.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				regresar.setBackground(new Color(123, 224, 217));
			}
			
			public void mouseExited(MouseEvent e)
			{
				regresar.setBackground(new Color(61, 191, 182));
			}
		});
		
		regresar.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				HomeController hm = new HomeController();
				hm.home();
			}
			
		});
			
		
		JButton nuevo = new JButton("Nuevo usuario");
		nuevo.setBackground(new Color(61, 191, 182));
		nuevo.setForeground(Color.white);
		nuevo.setFont(subtitulo);
		nuevo.setHorizontalAlignment(JLabel.CENTER);
		nuevo.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelHeader.add(nuevo);
		
		nuevo.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				nuevo.setBackground(new Color(123, 224, 217));
			}
			
			public void mouseExited(MouseEvent e)
			{
				nuevo.setBackground(new Color(61, 191, 182));
			}
		});
		
		nuevo.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				
				UserController uc = new UserController();
				uc.addUser();
			}
			
		});
		
		
		// JTable
		Vector<Vector<String>> listaUsuarios = new Vector<>();
		
		for (User user : users) 
		{
			Vector<String> datosUsuario = new Vector<String>();
			datosUsuario.add(String.valueOf(user.id));
			datosUsuario.add(user.name);
			datosUsuario.add(user.email);
			datosUsuario.add(user.role);
			datosUsuario.add(user.phone);
			datosUsuario.add(String.valueOf(user.create_at));
			datosUsuario.add(String.valueOf(user.update_at));
			
			listaUsuarios.add(datosUsuario);
		}
		
		Vector<String> nombreColumnas = new Vector<>();
		nombreColumnas.add("ID");
		nombreColumnas.add("Nombre");
		nombreColumnas.add("Email");
		nombreColumnas.add("Rol");
		nombreColumnas.add("Teléfono");
		nombreColumnas.add("Creado en:");
		nombreColumnas.add("Actualizado en:");
		
		JTable tabla = new JTable(listaUsuarios, nombreColumnas);	
		JScrollPane scrollPane = new JScrollPane(tabla);
		panelCentro.add(scrollPane, BorderLayout.CENTER);
		
		panel.revalidate();

		this.add(panel);
		this.repaint();
		this.setVisible(true);

	}
	
	
	public void addUser()
	{
		this.setSize(500, 500);
		this.setTitle("Añadir usuario");
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(this.WIDTH, this.HEIGHT);
		panel.setLayout(new BorderLayout(20, 10));
		
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(0, 1, 10, 0));
		panel.add(panelCentro, BorderLayout.CENTER);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0, 2, 10, 0));
		panelCentro.add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 2, 10, 0));
		panelCentro.add(panel2);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(0, 2, 10, 0));
		panelCentro.add(panel3);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(0, 2, 10, 0));
		panelCentro.add(panel4);
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(0, 2, 10, 0));
		panelCentro.add(panel5);
	
		
		// JLabels
		
		JLabel producto = new JLabel("Añadir usuario");
		producto.setBackground(new Color(88, 224, 215));
		producto.setForeground(Color.white);
		producto.setOpaque(true);
		producto.setFont(titulo);
		producto.setBorder(BorderFactory.createLineBorder(new Color(138, 12, 97), 1));
		producto.setHorizontalAlignment(JLabel.CENTER);
		panel.add(producto, BorderLayout.NORTH);
		
		JLabel espacio12 = new JLabel("         ");
		panel.add(espacio12, BorderLayout.EAST);
		
		JLabel espacio13 = new JLabel("         ");
		panel.add(espacio13, BorderLayout.WEST);
		
		JLabel espacio14 = new JLabel("         ");
		panel.add(espacio14, BorderLayout.SOUTH);
		
		
		// JLabels y JTextFields
		
		JLabel espacio7 = new JLabel("         ");
		panel1.add(espacio7);
		
		JLabel espacio8 = new JLabel("         ");
		panel1.add(espacio8);
		
		
		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setForeground(Color.black);
		nombreLabel.setFont(subtitulo);
		nombreLabel.setHorizontalAlignment(JLabel.LEFT);
		panel1.add(nombreLabel);
		
		JTextField nombre = new JTextField();
		panel1.add(nombre);
		
		JLabel espacio = new JLabel("         ");
		panel1.add(espacio);
		
		JLabel espacio2 = new JLabel("         ");
		panel1.add(espacio2);
		
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setForeground(Color.black);
		emailLabel.setFont(subtitulo);
		emailLabel.setHorizontalAlignment(JLabel.LEFT);
		panel2.add(emailLabel);
		
		JTextField email = new JTextField();
		panel2.add(email);
		
		
		JLabel espacio4 = new JLabel("         ");
		panel3.add(espacio4);
		
		JLabel espacio5 = new JLabel("         ");
		panel3.add(espacio5);

		
		JLabel rolLabel = new JLabel("Rol:");
		rolLabel.setForeground(Color.black);
		rolLabel.setFont(subtitulo);
		rolLabel.setHorizontalAlignment(JLabel.LEFT);
		panel3.add(rolLabel);
		
		JTextField rol = new JTextField();
		panel3.add(rol);
		
		
		JLabel espacio6 = new JLabel("         ");
		panel3.add(espacio6);
		
		
		JLabel phoneLabel = new JLabel("Teléfono:");
		phoneLabel.setForeground(Color.black);
		phoneLabel.setFont(subtitulo);
		phoneLabel.setHorizontalAlignment(JLabel.LEFT);
		panel4.add(phoneLabel);
		
		JTextField phone = new JTextField();
		panel4.add(phone);
		
		
		JLabel espacio9 = new JLabel("         ");
		panel4.add(espacio9);
		
		JLabel espacio10 = new JLabel("         ");
		panel4.add(espacio10);
		
		JLabel espacio11 = new JLabel("         ");
		panel4.add(espacio11);
		
		
		// JButton
		
		JButton cancel = new JButton("Cancelar");
		cancel.setBackground(new Color(45, 128, 122));
		cancel.setForeground(Color.white);
		cancel.setFont(subtitulo);
		cancel.setHorizontalAlignment(JLabel.CENTER);
		cancel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panel5.add(cancel);
		
		cancel.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				cancel.setBackground(new Color(65, 158, 152));
			}
			
			public void mouseExited(MouseEvent e)
			{
				cancel.setBackground(new Color(45, 128, 122));
			}
		});
		
		cancel.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				
				UserController uc = new UserController();
				uc.showUsers();
			}
			
		});
		
		
		JButton add = new JButton("Añadir");
		add.setBackground(new Color(61, 191, 182));
		add.setForeground(Color.white);
		add.setFont(subtitulo);
		add.setHorizontalAlignment(JLabel.CENTER);
		add.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panel5.add(add);
		
		add.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				add.setBackground(new Color(123, 224, 217));
			}
			
			public void mouseExited(MouseEvent e)
			{
				add.setBackground(new Color(61, 191, 182));
			}
		});
		
		add.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			
				UserController uc = new UserController();
				
				uc.add(nombre.getText(), email.getText(), rol.getText(), phone.getText());
				
				uc.showUsers();
			}
			
		});
		
		
		this.add(panel);
		this.repaint();
		this.setVisible(true);
	}
}
