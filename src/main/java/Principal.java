import java.util.List;

import Entidades.Alumno;
import Managers.AlumnoManager;
import Managers.ManagerPrincipal;

public class Principal {
	
	public static void main(String args[]){
		ManagerPrincipal.setup();
		
		AlumnoManager managerAlumno = new AlumnoManager();
		managerAlumno.create("Paco", "Fernandez Lopez", "DAM", 25, 3);
		
		List<Alumno> alumnos=managerAlumno.listarAlumnos();
		
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.getNombre());
		}
		
		ManagerPrincipal.exit();
	}
}
