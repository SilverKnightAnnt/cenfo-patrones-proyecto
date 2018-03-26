package com.cenfotec.patrones.UI;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cenfotec.patrones.entidades.*;
import com.cenfotec.patrones.gestores.*;

public class IU {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;

	int opcUser = 0;

	public static void main(String[] args) throws java.io.IOException {

		int opc;
		boolean noSalir = true;

		String[] listaMenu = { "1. Crear cuenta", "2. Iniciar sesión", "3. Salir" };

		out.println("****************************************************************");
		out.println("***************BIENVENIDO A DUELISTSPIRIT*************");
		out.println("****************************************************************");
		out.println();

		do {
			mostrarMenu(listaMenu);
			opc = leerOpcion();
			noSalir = ejecutarAccion(opc);

		} while (noSalir);

		out.println("Gracias por usar nuestro sistema, que tenga un buen dia :)");
	}

	static void mostrarMenu(String[] plista) {

		for (int i = 0; i < plista.length; i++) {
			out.println(plista[i]);
		}
		out.println();
	}

	static int leerOpcion() throws java.io.IOException {

		int opcion;

		out.print("Seleccione su opcion: ");
		opcion = Integer.parseInt(in.readLine());
		out.println();

		return opcion;
	}

	static boolean ejecutarAccion(int popcion) throws java.io.IOException {

		boolean noSalir = true;

		switch (popcion) {

		case 1:
			crearCuenta();
			break;

		case 2:
			iniciarSesion();
			break;

		case 3:

			break;

		case 4:

			break;

		case 5:

			break;

		case 6:

			break;

		case 7:

			break;

		case 8:

			break;

		case 9:

			break;

		case 10:

			noSalir = false;
			break;

		default:

			out.println("Opcion invalida");
			out.println();
			break;
		}

		return noSalir;
	}

	public static void crearCuenta() throws IOException {

		Usuario usuario = new Usuario();
		GestorUsuario gu = new GestorUsuario();

		out.println("Ingrese su correo electrónico: ");
		usuario.setCorreo(in.readLine());
		out.println("Ingrese el nombre de usuario: ");
		usuario.setNombreUsuario(in.readLine());
		out.println("Ingrese la contraseña: ");
		usuario.setContrasenna(in.readLine());

		gu.crearCuenta(usuario);

	}

	public static void iniciarSesion() throws IOException {

		Usuario usuario = new Usuario();
		GestorUsuario gu = new GestorUsuario();
		out.println("Ingrese su nombre de usuario: ");
		usuario.setNombreUsuario(in.readLine());
		out.println("Ingrese su contraseña: ");
		usuario.setContrasenna(in.readLine());

		if (gu.iniciarSesion(usuario) == true) {
			usuarioLogeado = usuario.getNombreUsuario();
			menuInicioSesion();
		} else {
			out.println("\nNombre de usuario o contraseña incorrectos.\n");
		}

	}

	static String usuarioLogeado;

	public static void menuInicioSesion() throws NumberFormatException, IOException {

		int opcion = -1;
		do {
			out.println("\n1. Nueva partida.");
			out.println("2. Cargar partida.");
			out.println("3. Cerrar sesión.\n");
			out.println("Seleccione su opción: ");
			opcion = Integer.parseInt(in.readLine());

			switch (opcion) {
			case 1:
				crearPersonaje();
				break;
			case 2:
				cargarPartida();
				break;
			case 3:
				break;
			default:
				out.println("Opción incorrecta.");

			}
		} while (opcion != 3);

	}
	
	public static void crearPersonaje() throws IOException {
		Personaje personaje = new Personaje();
		Raza raza = new Raza();
		Rol rol = new Rol();
		Profesion profesion = new Profesion();

		GestorPersonaje gp = new GestorPersonaje();
		GestorRaza gr = new GestorRaza();
		GestorRol grol = new GestorRol();
		GestorProfesion gprof = new GestorProfesion();

		System.out.println("****CREACIÓN DEL DUELISTA***");		
		personaje.setUsuario(usuarioLogeado);		
		System.out.println("Nombre del duelista: ");
		personaje.setNombre(in.readLine());
		System.out.println("\nGenero del duelista: ");
		personaje.setGenero(in.readLine());

		System.out.println("\nSeleccione la raza del duelista: ");
		listarRaza();
		System.out.println("\nEscoja el número de la raza del duelista: ");
		raza.setId_raza(Integer.parseInt(in.readLine()));
		if (gr.buscarRaza(raza) != null) {
			personaje.setRaza(gr.buscarRaza(raza).getNombre());

		}

		System.out.println("\nRol del duelista: ");
		listarRol();
		System.out.println("\nEscoja el número del rol del duelista: ");
		rol.setId_rol(Integer.parseInt(in.readLine()));
		if (grol.buscarRol(rol) != null) {
			personaje.setRol(grol.buscarRol(rol).getNombre());
		}

		System.out.println("Profesión del duelista: ");
		listarProfesion();
		System.out.println("\nEscoja el número de la profesión del duelista: ");
		profesion.setId_profesion(Integer.parseInt(in.readLine()));
		if (gprof.buscarProfesion(profesion) != null) {
			personaje.setProfesion(gprof.buscarProfesion(profesion).getNombreProfesion());
		}

		personaje.setHp_max(100);
		personaje.setHp_actual(100);
		personaje.setAtk(10);
		personaje.setNivel(0);
		personaje.setExp(0);

		gp.creacionPersonaje(personaje);

	}

	public static void listarRaza() throws IOException {
		GestorRaza gr = new GestorRaza();
		boolean isEmpty = gr.isEmpty();

		if (!isEmpty) {
			System.out.println("No hay razas registradas");
		} else {
			System.out.println("---Razas---");
			gr.getRaza();

		}
	}

	public static void listarRol() throws IOException {
		GestorRol grol = new GestorRol();
		boolean isEmpty = grol.isEmpty();

		if (!isEmpty) {
			System.out.println("No hay roles registrados");
		} else {
			System.out.println("---Roles---");
			grol.getRol();
		}
	}

	public static void listarProfesion() throws IOException {
		GestorProfesion gprof = new GestorProfesion();
		boolean isEmpty = gprof.isEmpty();

		if (!isEmpty) {
			System.out.println("No hay profesiones registradas");
		} else {
			System.out.println("---Profesiones---");
			gprof.getProfesion();
		}
	}

	public static void cargarPartida() throws IOException {
		GestorPersonaje gper = new GestorPersonaje();
		Personaje personaje = new Personaje();
		personaje.setUsuario(usuarioLogeado);
		if (gper.buscarPersonaje(personaje) != null) {
			System.out.println("---Personajes---\n");
			for (Personaje personajeEncontrado : gper.buscarPersonaje(personaje)) {
				System.out.println(personajeEncontrado.toString());
			}
			System.out.println("\nDigite el nombre del duelista para cargar:");
			String nombrePersonaje = in.readLine();
			cargarMapa(nombrePersonaje);
		}
	}

	public static void cargarMapa(String pNombrePersonaje) throws NumberFormatException, IOException {
		GestorMapa gmapa = new GestorMapa();		
		for (int i = 0; i < gmapa.getMapa().length; i++) {
		    for (int j = 0; j < gmapa.getMapa()[i].length; j++) {
		        System.out.print(gmapa.getMapa()[i][j] + " ");
		    }
		    System.out.println();
		}      
		
				
		int opcion = -1;
		do {
			System.out.println("---Opciones del mundo---\n");
			System.out.println("1. Moverse.");
			System.out.println("2. Guardar partida.");
			System.out.println("3. Cargar partida.");
			System.out.println("4. Salir.\n");
			System.out.println("Seleccione su opción: ");
			opcion = Integer.parseInt(in.readLine());

			switch (opcion) {
			case 1:
				
				break;
			case 2:
				guardarPartida(pNombrePersonaje);
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				out.println("Opción incorrecta.");

			}
		} while (opcion != 4);

	}
	
	public static void guardarPartida(String pNombrePersonaje) {
		GestorMapa gmapa = new GestorMapa();	
		gmapa.guardado(pNombrePersonaje);
	}
}