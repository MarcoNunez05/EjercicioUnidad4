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

import org.json.simple.JSONArray;

import controllers.HomeController;
import controllers.ProductController;

public class ProductView extends JFrame 
{
	Font titulo = new Font("Cambria", Font.BOLD, 32);
	Font subtitulo = new Font("Cambria Math", Font.PLAIN, 20);
	Font mini = new Font("Cambria Math", Font.PLAIN, 14);
	
	ProductController pc;

	public ProductView()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(400, 400));
	}
	
	public void product(Vector<Vector<String>> data)
	{
		this.getContentPane().removeAll();
		
		this.setSize(800, 700);
		this.setTitle("Productos");
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(this.WIDTH, this.HEIGHT);
		panel.setOpaque(true);
		panel.setBackground(new Color(230, 181, 214));
		panel.setLayout(new BorderLayout(20, 50));
		
		JPanel panelCentro = new JPanel();
		panelCentro.setOpaque(true);
		panelCentro.setLayout(new BorderLayout(20, 10));
		panelCentro.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panel.add(panelCentro, BorderLayout.CENTER);
		
		JPanel panelArriba = new JPanel();
		panelArriba.setOpaque(true);
		panelArriba.setLayout(new BorderLayout());
		panelArriba.setBorder(BorderFactory.createLineBorder(new Color(138, 12, 97), 5));
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
		
		JLabel producto = new JLabel("Productos");
		producto.setForeground(Color.white);
		producto.setBackground(new Color(138, 12, 97));
		producto.setOpaque(true);
		producto.setFont(titulo);
		producto.setHorizontalAlignment(JLabel.CENTER);
		panelArriba.add(producto, BorderLayout.CENTER);
		
		JLabel espacio = new JLabel("     ");
		espacio.setFont(mini);
		panel.add(espacio, BorderLayout.WEST);
		
		JLabel espacio2 = new JLabel("     ");
		espacio2.setFont(mini);
		panel.add(espacio2, BorderLayout.EAST);
		
		JLabel espacio12 = new JLabel("                           ");
		espacio12.setBackground(new Color(138, 12, 97));
		espacio12.setOpaque(true);
		espacio12.setFont(mini);
		panelArriba.add(espacio12, BorderLayout.EAST);
		
		
		// JButtons y JLabels del Header
		
		JButton actualizar = new JButton("Actualizar");
		actualizar.setBackground(new Color(191, 61, 149));
		actualizar.setForeground(Color.white);
		actualizar.setFont(subtitulo);
		actualizar.setHorizontalAlignment(JLabel.CENTER);
		actualizar.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panelAbajo.add(actualizar, BorderLayout.CENTER);
		
		actualizar.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				actualizar.setBackground(new Color(189, 104, 161));
			}
			
			public void mouseExited(MouseEvent e)
			{
				actualizar.setBackground(new Color(191, 61, 149));
			}
		});
		
		actualizar.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				pc = new ProductController();
				product(pc.actualizar());
			}
			
		});
		
		JButton regresar = new JButton("Regresar");
		regresar.setBackground(new Color(191, 61, 149));
		regresar.setForeground(Color.white);
		regresar.setFont(subtitulo);
		regresar.setHorizontalAlignment(JLabel.CENTER);
		regresar.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panelArriba.add(regresar, BorderLayout.WEST);
		
		regresar.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				regresar.setBackground(new Color(189, 104, 161));
			}
			
			public void mouseExited(MouseEvent e)
			{
				regresar.setBackground(new Color(191, 61, 149));
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
		
			
		JLabel IDLabel = new JLabel("ID:");
		IDLabel.setForeground(Color.black);
		IDLabel.setFont(subtitulo);
		IDLabel.setHorizontalAlignment(JLabel.CENTER);
		panelHeader.add(IDLabel);
		
		JLabel espacio4 = new JLabel("         ");
		panelHeader.add(espacio4);
		
		JTextField id = new JTextField();
		panelHeader.add(id);
		
		JLabel espacio3 = new JLabel("         ");
		panelHeader.add(espacio3);
		
		
		JButton borrar = new JButton("Eliminar objeto con ID");
		borrar.setBackground(new Color(110, 35, 86));
		borrar.setForeground(Color.white);
		borrar.setFont(subtitulo);
		borrar.setHorizontalAlignment(JLabel.CENTER);
		borrar.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelHeader.add(borrar);
		
		borrar.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				borrar.setBackground(new Color(107, 57, 90));
			}
			
			public void mouseExited(MouseEvent e)
			{
				borrar.setBackground(new Color(110, 35, 86));
			}
		});
		
		borrar.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int p = JOptionPane.showConfirmDialog(panel, "¿Quieres borrar el producto con la ID " + id.getText() + "?", "Eliminar producto", JOptionPane.YES_NO_OPTION);
				if (p == 0)
				{
					pc = new ProductController();		
					pc.delete(id.getText());				
					product(pc.actualizar());
				}
			}
			
		});
		
		
		JButton nuevo = new JButton("Nuevo Producto");
		nuevo.setBackground(new Color(191, 61, 149));
		nuevo.setForeground(Color.white);
		nuevo.setFont(subtitulo);
		nuevo.setHorizontalAlignment(JLabel.CENTER);
		nuevo.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelHeader.add(nuevo);
		
		nuevo.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				nuevo.setBackground(new Color(189, 104, 161));
			}
			
			public void mouseExited(MouseEvent e)
			{
				nuevo.setBackground(new Color(191, 61, 149));
			}
		});
		
		nuevo.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				pc = new ProductController();
				
				pc.addView();
			}
			
		});
		
		
		// JTable
		
		Vector<String> nombreColumnas = new Vector<>();
		nombreColumnas.add("ID");
		nombreColumnas.add("Nombre");
		nombreColumnas.add("Descripción");
		nombreColumnas.add("Precio");
		nombreColumnas.add("Stock");
		
		JTable tabla = new JTable(data, nombreColumnas);	
		JScrollPane scrollPane = new JScrollPane(tabla);
		panelCentro.add(scrollPane, BorderLayout.CENTER);
		
		panel.revalidate();

		this.add(panel);
		this.repaint();
		this.setVisible(true);
	}
	
	public void addProduct()
	{
		this.setSize(500, 500);
		this.setTitle("Añadir producto");
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
		
		JLabel producto = new JLabel("Añadir producto");
		producto.setBackground(new Color(181, 24, 130));
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
		
		
		JLabel descLabel = new JLabel("Descripción:");
		descLabel.setForeground(Color.black);
		descLabel.setFont(subtitulo);
		descLabel.setHorizontalAlignment(JLabel.LEFT);
		panel2.add(descLabel);
		
		JTextArea desc = new JTextArea();
		panel2.add(desc);
		
		
		JLabel espacio4 = new JLabel("         ");
		panel3.add(espacio4);
		
		JLabel espacio5 = new JLabel("         ");
		panel3.add(espacio5);

		
		JLabel precioLabel = new JLabel("Precio:");
		precioLabel.setForeground(Color.black);
		precioLabel.setFont(subtitulo);
		precioLabel.setHorizontalAlignment(JLabel.LEFT);
		panel3.add(precioLabel);
		
		JTextField precio = new JTextField();
		panel3.add(precio);
		
		
		JLabel espacio6 = new JLabel("         ");
		panel3.add(espacio6);
		
		
		JLabel stockLabel = new JLabel("Stock:");
		stockLabel.setForeground(Color.black);
		stockLabel.setFont(subtitulo);
		stockLabel.setHorizontalAlignment(JLabel.LEFT);
		panel4.add(stockLabel);
		
		JTextField stock = new JTextField();
		panel4.add(stock);
		
		
		JLabel espacio9 = new JLabel("         ");
		panel4.add(espacio9);
		
		JLabel espacio10 = new JLabel("         ");
		panel4.add(espacio10);
		
		JLabel espacio11 = new JLabel("         ");
		panel4.add(espacio11);
		
		
		// JButton
		
		JButton cancel = new JButton("Cancelar");
		cancel.setBackground(new Color(110, 35, 86));
		cancel.setForeground(Color.white);
		cancel.setFont(subtitulo);
		cancel.setHorizontalAlignment(JLabel.CENTER);
		cancel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panel5.add(cancel);
		
		cancel.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				cancel.setBackground(new Color(107, 57, 90));
			}
			
			public void mouseExited(MouseEvent e)
			{
				cancel.setBackground(new Color(110, 35, 86));
			}
		});
		
		cancel.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				
				pc = new ProductController();
				pc.productos();		
			}
			
		});
		
		
		JButton add = new JButton("Añadir");
		add.setBackground(new Color(191, 61, 149));
		add.setForeground(Color.white);
		add.setFont(subtitulo);
		add.setHorizontalAlignment(JLabel.CENTER);
		add.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panel5.add(add);
		
		add.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				add.setBackground(new Color(189, 104, 161));
			}
			
			public void mouseExited(MouseEvent e)
			{
				add.setBackground(new Color(191, 61, 149));
			}
		});
		
		add.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				
				pc = new ProductController();
				pc.add(nombre.getText(), desc.getText(), precio.getText(), stock.getText());	
			}
			
		});
		
		
		this.add(panel);
		this.repaint();
		this.setVisible(true);
	}
}
