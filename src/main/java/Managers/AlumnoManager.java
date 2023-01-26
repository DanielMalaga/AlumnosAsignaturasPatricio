package Managers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Entidades.Alumno;

public class AlumnoManager {
	

	public void create(String nombre,String apellidos,String curso,int edad, int asignaturas) {
		Alumno alumno = new Alumno();

		alumno.setNombre(nombre);
		alumno.setApellidos(apellidos);
		alumno.setCurso(curso);
		alumno.setEdad(edad);
		alumno.setAsignaturas(asignaturas);
		
		Session session = ManagerPrincipal.sessionFactory.openSession();
		session.beginTransaction();
		session.save(alumno);
		session.getTransaction().commit();
		session.close();

	}
	
	public void insertarAlumno(Alumno a) {
		
		Session session = ManagerPrincipal.sessionFactory.openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		session.close();

	}
	
	public List<Alumno> listarAlumnos() {
		Session session = ManagerPrincipal.sessionFactory.openSession();
		return session.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList(); 
	}
	
	

}