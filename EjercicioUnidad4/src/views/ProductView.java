package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.json.simple.JSONArray;

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
		panelCentro.setLayout(new BorderLayout(20, 50));
		panelCentro.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panel.add(panelCentro, BorderLayout.CENTER);
		
		JPanel panelAbajo = new JPanel();
		panelAbajo.setOpaque(true);
		panelAbajo.setLayout(new BorderLayout(20, 50));
		panelAbajo.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		panel.add(panelAbajo, BorderLayout.SOUTH);
		
		
		// JLabels
		
		JLabel producto = new JLabel("Home");
		producto.setBackground(new Color(181, 24, 130));
		producto.setForeground(Color.white);
		producto.setOpaque(true);
		producto.setFont(titulo);
		producto.setBorder(BorderFactory.createLineBorder(new Color(138, 12, 97), 5));
		producto.setHorizontalAlignment(JLabel.CENTER);
		panel.add(producto, BorderLayout.NORTH);
		
		JLabel espacio = new JLabel("     ");
		espacio.setFont(mini);
		panel.add(espacio, BorderLayout.WEST);
		
		JLabel espacio2 = new JLabel("     ");
		espacio2.setFont(mini);
		panel.add(espacio2, BorderLayout.EAST);
		
		
		// JButtons
		
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
		
		
		// JTable
		
		Vector<String> nombreColumnas = new Vector<>();
		nombreColumnas.add("ID");
		nombreColumnas.add("Nombre");
		nombreColumnas.add("Precio");
		nombreColumnas.add("Stock");
				
		
		JTable tabla = new JTable(data, nombreColumnas);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setLocation(30, 150);
		scrollPane.setSize(920, 500);
		panel.add(scrollPane);
		
		panel.revalidate();

		this.add(panel);
		this.repaint();
		this.setVisible(true);
	}
}
