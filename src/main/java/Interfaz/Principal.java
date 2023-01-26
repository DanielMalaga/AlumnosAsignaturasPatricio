package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Alumno;
import Managers.AlumnoManager;
import Managers.ManagerPrincipal;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextField txtAsignaturas;
	private JTextField txtCurso;
	AlumnoManager managerAlumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Principal frame = new Principal();
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
	public Principal() {
		ManagerPrincipal.setup();
		managerAlumno = new AlumnoManager();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(125, 31, 188, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(125, 76, 188, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(41, 31, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(41, 79, 46, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(41, 122, 46, 14);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(125, 119, 188, 20);
		contentPane.add(txtEdad);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				managerAlumno.create(txtNombre.getText(), txtApellidos.getText(), txtCurso.getText(), Integer.parseInt( txtEdad.getText()), Integer.parseInt( txtAsignaturas.getText()));
			}
		});
		btnCrear.setBounds(164, 297, 89, 23);
		contentPane.add(btnCrear);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Alumno> alumnos=managerAlumno.listarAlumnos();
				for (Alumno alumno : alumnos) {
					System.out.println(alumno.getNombre());
				}
			}
		});
		btnListar.setBounds(384, 297, 89, 23);
		contentPane.add(btnListar);
		
		JLabel lblAsignaturas = new JLabel("Asignaturas");
		lblAsignaturas.setBounds(41, 168, 74, 14);
		contentPane.add(lblAsignaturas);
		
		txtAsignaturas = new JTextField();
		txtAsignaturas.setColumns(10);
		txtAsignaturas.setBounds(125, 165, 188, 20);
		contentPane.add(txtAsignaturas);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(41, 216, 74, 14);
		contentPane.add(lblCurso);
		
		txtCurso = new JTextField();
		txtCurso.setColumns(10);
		txtCurso.setBounds(125, 213, 188, 20);
		contentPane.add(txtCurso);
	}
}
