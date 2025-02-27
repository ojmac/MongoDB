package mongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import mongodb.entity.Coche;
import mongodb.entity.Conductor;
import mongodb.entity.PermisoCirc;
import mongodb.entity.Reparacion;

public class Control {

	static Scanner sc = new Scanner(System.in);
	static Scanner sct = new Scanner(System.in);

	/*
	 * Crear documentos, buscar por id y eliminar documentos de la base de datos
	 * para los tres tipos de relaciones abordadas en dicho ejercicio
	 */

	public void registrarCoche(Coche coche) {

		Practica practica = new Practica();
		practica.conectar();

		practica.guardarCoche(coche);

		practica.guardarPermiso(coche.getPermisoCirc());

		practica.desconectar();

		System.out.println("Coche registrado correctamente");
	}

	public void registrarConductor(Conductor conductor) {

		Practica practica = new Practica();
		practica.conectar();

		practica.guardarConductor(conductor);

		practica.desconectar();

		System.out.println("Conductor registrado correctamente");
	}

	public void registrarReparacion(Reparacion reparacion) {

		Practica practica = new Practica();
		practica.conectar();

		practica.guardarReparacion(reparacion);

		practica.desconectar();

		System.out.println("Reparación registrada correctamente");
	}

	public Document buscarDocXId() {

		Practica practica = new Practica();
		practica.conectar();
		Document doc = new Document();

		System.out.println("\n¿Qué tipo de Documento quiere recuperar? \n " + "\n 1 --> Coche \n "
				+ "2 --> Conductor \n " + "3 --> Permiso\n " + "4 --> Reparación\n");

		int seleccion = elegir(1, 4);

		switch (seleccion) {

		case 1:

			String matricula;
			do {
				System.out.println("¿Cuál es la matrícula del coche que desea recuperar?\n");
				matricula = sct.nextLine();
				doc = practica.buscarCochePorId(matricula);

				if (doc == null) {
					System.out.println("No existe ese coche. Inténtelo de nuevo.\n");
				}

			} while (doc == null);
			break;

		case 2:
			do {
				System.out.println("¿Cuál es el id del conductor requerido?\n");
				String idCond = sct.nextLine();
				doc = practica.buscarConductorPorId(idCond);

				if (doc == null) {
					System.out.println("No existe ese conductor. Inténtelo de nuevo.\n");
				}
			} while (doc == null);
			break;

		case 3:
			do {
				System.out.println("¿Cuál es el número identificatico del permiso de circulación solicitado?\n");
				String numId = sct.nextLine();
				doc = practica.buscarPermisoPorId(numId);
				if (doc == null) {
					System.out.println("No existe ese numero de permiso. Inténtelo de nuevo.\n");
				}
			} while (doc == null);
			break;

		case 4:
			do {

				System.out.println("Teclee el número de la reparación que busca: \n");
				int numRep = sc.nextInt();
				doc = practica.buscarReparacionPorId(numRep);

				if (doc == null) {
					System.out.println("reparación inexistente, por favor ingrese un número correcto.. \n");
				}
			} while (doc == null);
			break;
		}

		if (doc != null) {

			System.out.println("Quiere ver los datos por pantalla?");
			String resp = siONo();

			if (resp.equalsIgnoreCase("s")) {

				verDetalleDoc(doc, seleccion);

			}
		} else {
			System.out.println("Código introducido erróneo");
		}
		practica.desconectar();
		return doc;

	}

	public void eliminarDocsPorId() {

		Practica practica = new Practica();
		practica.conectar();
		Document doc = new Document();

		System.out.println("\n¿Qué tipo de Documento quiere eliminar? \n\n " + "1 --> Coche \n " + "2 --> Conductor \n "
				+ "3 --> Permiso\n " + "4 --> Reparación\n ");

		int seleccion = elegir(1, 4);

		switch (seleccion) {
		case 1:
			System.out.println("¿Cuál es la matrícula del coche que desea borrar?\n");
			String matricula = sct.nextLine();
			doc = practica.buscarCochePorId(matricula);
			if (doc == null) {
				System.out.println("No existe ese conductor\n");

			} else {
				practica.borrarCoche(matricula);
				System.out.println("Documento eliminado correctamente");
			}

			break;
		case 2:
			System.out.println("¿Cuál es el id del conductor a dar de baja?\n");
			String idCond = sct.nextLine();
			doc = practica.buscarConductorPorId(idCond);
			if (doc == null) {
				System.out.println("No existe ese conductor\n");

			} else {
				practica.borrarConductor(idCond);
				System.out.println("Documento conductor eliminado correctamente");
			}

			break;
		case 3:
			System.out.println("¿Cuál es el número identificatico del permiso de circulación que se debe anular?\n");
			System.out.println("INFO: se eliminará automaitcamente el coche asociado a ese permiso");
			String numId = sct.nextLine();
			doc = practica.buscarPermisoPorId(numId);
			if (doc == null) {
				System.out.println("No existe esa permiso\n");

			} else {
				practica.borrarPermiso(numId);
				System.out.println("Documento Permiso eliminado correctamente");
			}

			break;
		case 4:

			System.out.println("Teclee el número de la reparación que desea borrar: \n");
			int numRep = sc.nextInt();
			doc = practica.buscarReparacionPorId(numRep);
			if (doc == null) {
				System.out.println("No existe esa reparación\n");

			} else {
				practica.borrarReparación(numRep);
				System.out.println("Documento eliminado correctamente");

			}
			break;
		}

	}

	// Ver en pantalla los detalles de un documento en forma de clase
	private void verDetalleDoc(Document doc, int seleccion) {

		Practica practica = new Practica();
		practica.conectar();

		switch (seleccion) {

		case 1:
			Coche c = practica.documentToCoche(doc);
			System.out.println(c);
			break;
		case 2:
			Conductor cond = practica.documentToConductor(doc);
			System.out.println(cond);
			break;
		case 3:
			PermisoCirc permiso = practica.documentToPermiso(doc);
			System.out.println(permiso);
			break;
		case 4:
			Reparacion rep = practica.documentToReparacion(doc);
			System.out.println(rep);
			break;

		}
		practica.desconectar();
	}

	// Obtener la información de todos los documentos de la entidad principal
	public List<Coche> obtObjsCoche() {

		Practica practica = new Practica();
		practica.conectar();

		List<Coche> coches = new ArrayList();

		List<Document> docs = practica.obtenerTodosLosCoches();

		for (Document doc : docs) {

			coches.add(practica.documentToCoche(doc));
		}

		for (Coche c : coches) {
			
			System.out.println(c);
		}
		System.out.println("Objetos Coche recuperados y almacenados en un array");
		return coches;

	}

	// Obtener la información de todos los documentos de la entidad secundaria
	public List<Reparacion> obtObjsReparacion() {

		Practica practica = new Practica();
		practica.conectar();

		List<Reparacion> reparaciones = new ArrayList();

		List<Document> docs = practica.obtenerTodosLosReparaciones();

		for (Document doc : docs) {

			reparaciones.add(practica.documentToReparacion(doc));
		}
		for (Reparacion r : reparaciones) {
			
			System.out.println(r);
		}
		System.out.println("Documentos Reparación recuperados y almacenados en un array");
		return reparaciones;

	}
	/*
	 * Obtener la información de los documentos de una entidad añadiendo algún
	 * criterio de búsqueda en la entidad principal (cada cuál decide el criterio,
	 * pero lo indica en un comentario sobre la implementación correspondiente)
	 */

	// Obtener todas las reparaciones de coches de una marca específica
	public List<Reparacion> obtenerReparacionesPorMarca(String marca) {
		Practica practica = new Practica();
		practica.conectar();

		List<Document> coches = practica.obtenerCochesPorMarca(marca);
		List<Reparacion> reparaciones = new ArrayList<>();

		for (Document coche : coches) {
			String matricula = coche.getString("_matricula");
			List<Document> reparacionesCoche = practica.obtenerReparacionesPorMatricula(matricula);

			for (Document repDoc : reparacionesCoche) {
				reparaciones.add(practica.documentToReparacion(repDoc));
				System.out.println(practica.documentToReparacion(repDoc));
			}
		}

		practica.desconectar();
		return reparaciones;
	}

	/*
	 * Obtener la información de los documentos de una entidad utilizando las
	 * relaciones entre entidades (haciendo referencia a algún atributo de la
	 * entidad secundaria)
	 */

	// Obtener todos los coches que han sufrido una reparación de más de x euros
	public List<Coche> obtenerCochesConReparacionesCostosas(double precioMinimo) {
		Practica practica = new Practica();
		practica.conectar();

		List<Document> docsReparaciones = practica.obtenerReparacionesConPrecioMayor(precioMinimo);
		List<String> matriculasCoches = new ArrayList<>();

		for (Document docReparacion : docsReparaciones) {
			String matriculaCoche = docReparacion.getString("matriculaCoche");
			if (!matriculasCoches.contains(matriculaCoche)) {
				matriculasCoches.add(matriculaCoche);
				
			}
		}

		List<Coche> coches = new ArrayList<>();

		for (String matricula : matriculasCoches) {
			Document docCoche = practica.buscarCochePorId(matricula);
			if (docCoche != null) {
				coches.add(practica.documentToCoche(docCoche));
				System.out.println(practica.documentToCoche(docCoche));
			}
		}

		practica.desconectar();
		return coches;
	}

	public void resetBD() {
		Practica practica = new Practica();
		practica.conectar();

		practica.borrarBaseDeDatos();

		practica.desconectar();

	}

	// Eleción númerica con rango, a prueba de errores
	public static int elegir(int i, int j) {

		boolean ok = false;

		System.out.println("\nElija una opcion entre " + i + " y " + j);

		int eleccion = 1;

		while (!ok) {

			try {
				eleccion = sc.nextInt();
				ok = true;

			} catch (Exception e) {
				System.err.println("\nDebe de introducir un número, pruebe otra vez..");
				sc.nextLine();
				ok = false;

			}
			if (eleccion < i || eleccion > j) {
				System.err.println("\nNúmero fuera de rango, pruebe de nuevo.. ");
				ok = false;
			}
		}
		return eleccion;
	}

	// Elección si o no a prueba de errores
	public static String siONo() {
		boolean incorrecto = true;
		String resp = "";

		while (incorrecto) {
			System.out.println("(s/n)");
			resp = sct.nextLine();
			if (resp.equalsIgnoreCase("s") || resp.equalsIgnoreCase("n")) {
				incorrecto = false;
			} else {
				System.err.println("Debe introducir \'s\' ó \'n\'");
				incorrecto = true;
			}
		}
		return resp;
	}

}
