package com.cenfotec.patrones.UI;

import java.io.*;
import java.util.ArrayList;

import com.cenfotec.patrones.armadura.ArmaduraEpica;
import com.cenfotec.patrones.armas.Arma;
import com.cenfotec.patrones.armas.ArmaEpica;
import com.cenfotec.patrones.enemigo.EnemigoEpico;
import com.cenfotec.patrones.entidades.*;
import com.cenfotec.patrones.fabricas.FabricaElementos;
import com.cenfotec.patrones.fabricas.FabricaGestores;
import com.cenfotec.patrones.gestores.*;
import com.cenfotec.patrones.inventario.Item;

public class IU {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;

	int opcUser = 0;

	public static void main(String[] args) throws Exception {

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

	static boolean ejecutarAccion(int popcion) throws Exception {

		boolean noSalir = true;

		switch (popcion) {

		case 1:
			crearCuenta();
			break;

		case 2:
			iniciarSesion();
			break;

		case 3:
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

		Usuario usuario = FabricaElementos.crearUsuario();
		GestorUsuario gu = FabricaGestores.crearGestorUsuario();

		out.println("Ingrese su correo electrónico: ");
		usuario.setCorreo(in.readLine());
		out.println("Ingrese el nombre de usuario: ");
		usuario.setNombreUsuario(in.readLine());
		out.println("Ingrese la contraseña: ");
		usuario.setContrasenna(in.readLine());

		gu.crearCuenta(usuario);

	}

	public static void iniciarSesion() throws Exception {

		Usuario usuario = FabricaElementos.crearUsuario();
		GestorUsuario gu = FabricaGestores.crearGestorUsuario();
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

	public static void menuInicioSesion() throws Exception {

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

		Personaje personaje = FabricaElementos.crearPersonaje();
		Raza raza = FabricaElementos.crearRaza();
		Rol rol = FabricaElementos.crearRol();
		Profesion profesion = FabricaElementos.crearProfesion();

		GestorPersonaje gp = FabricaGestores.crearGestorPersonaje();
		GestorRaza gr = FabricaGestores.crearGestorRaza();
		GestorRol grol = FabricaGestores.crearGestorRol();
		GestorProfesion gprof = FabricaGestores.crearGestorProfesion();

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
		GestorRaza gr = FabricaGestores.crearGestorRaza();
		boolean isEmpty = gr.isEmpty();

		if (!isEmpty) {
			System.out.println("No hay razas registradas");
		} else {
			System.out.println("---Razas---");
			gr.getRaza();

		}
	}

	public static void listarRol() throws IOException {
		GestorRol grol = FabricaGestores.crearGestorRol();
		boolean isEmpty = grol.isEmpty();

		if (!isEmpty) {
			System.out.println("No hay roles registrados");
		} else {
			System.out.println("---Roles---");
			grol.getRol();
		}
	}

	public static void listarProfesion() throws IOException {
		GestorProfesion gprof = FabricaGestores.crearGestorProfesion();
		boolean isEmpty = gprof.isEmpty();

		if (!isEmpty) {
			System.out.println("No hay profesiones registradas");
		} else {
			System.out.println("---Profesiones---");
			gprof.getProfesion();
		}
	}

	public static void cargarPartida() throws Exception {
		GestorPersonaje gper = FabricaGestores.crearGestorPersonaje();
		Personaje personaje = FabricaElementos.crearPersonaje();
		personaje.setUsuario(usuarioLogeado);
		if (gper.buscarPersonajeUsuario(personaje) != null) {
			System.out.println("---Personajes---\n");
			for (Personaje personajeEncontrado : gper.buscarPersonajeUsuario(personaje)) {
				System.out.println(personajeEncontrado.toString());
			}
			System.out.println("\nDigite el nombre del duelista con el cual desea jugar:");
			String nombrePersonaje = in.readLine();
			personaje.setNombre(nombrePersonaje);
			if (gper.buscarPersonajeNombre(personaje).isEmpty()) {
				System.out.println("\nDicho personaje no existe.");
			} else {
				personajeEnJuego = gper.buscarPersonajeNombre(personaje).get(0);
				listarPartidasPersonaje(nombrePersonaje);
			}
		}
	}

	static Personaje personajeEnJuego;

	public static void listarPartidasPersonaje(String pNombrePersonaje) throws Exception {
		GestorMapa gmapa = FabricaGestores.crearGestorMapa();
		ArrayList<String> listaPartidasExistentes = gmapa.listarCargasDisponibles(pNombrePersonaje);
		if (listaPartidasExistentes != null) {
			for (String partida : listaPartidasExistentes) {
				System.out.println(partida.toString());
			}
			System.out.println("\nDigite el número de la partida a cargar:");
			int numeroPartida = Integer.parseInt(in.readLine());
			mostrarMapaCargado(pNombrePersonaje, numeroPartida);
		} else {
			cargarMapaBase(pNombrePersonaje);
		}
	}

	static int posicionXActualPersonaje = -1;
	static int posicionYActualPersonaje = -1;

	public static void imprimirMapa(String[][] mapaPorImprimir) {
		for (int x = 0; x < mapaPorImprimir.length; x++) {
			for (int y = 0; y < mapaPorImprimir[x].length; y++) {
				if (mapaPorImprimir[x][y].equals("P")) {
					posicionXActualPersonaje = x;
					posicionYActualPersonaje = y;
				}
				System.out.print(mapaPorImprimir[x][y] + "\t");
			}
			System.out.println();
		}
	}

	public static void mostrarMapaCargado(String pNombrePersonaje, int pNumeroPartida) throws Exception {
		GestorMapa gmapa = FabricaGestores.crearGestorMapa();
		String[][] mapaCargado = gmapa.cargarPartida(pNombrePersonaje, pNumeroPartida);

		if (mapaCargado != null) {
			imprimirMapa(mapaCargado);
			mostrarMenuMundo(posicionXActualPersonaje, posicionYActualPersonaje, pNombrePersonaje, mapaCargado);
		} else {
			System.out.println("\nNo existe dicha partida.");
		}
	}

	public static void cargarMapaBase(String pNombrePersonaje) throws Exception {
		GestorMapa gmapa = FabricaGestores.crearGestorMapa();
		String[][] mapaBase = gmapa.obtenerMapaBase();
		imprimirMapa(mapaBase);
		mostrarMenuMundo(posicionXActualPersonaje, posicionYActualPersonaje, pNombrePersonaje, mapaBase);
	}

	public static void mostrarMenuMundo(int pPosicionXPersonajeActual, int pPosicionYPersonajeActual,
			String pPersonajeActual, String[][] pMapaActual) throws Exception {
		int opcion = -1;
		do {

			System.out.println("---Opciones del menú---\n");
			System.out.println("1. Moverse.");
			System.out.println("2. Guardar partida.");
			System.out.println("3. Cargar partida.");
			System.out.println("4. ATACAR!!!!");
			System.out.println("5. Rejuntar objeto");
			System.out.println("5. Salir.\n");
			System.out.println("Seleccione su opción: ");
			opcion = Integer.parseInt(in.readLine());

			switch (opcion) {
			case 1:
				moverJugador(posicionXActualPersonaje, posicionYActualPersonaje, pMapaActual);
				break;
			case 2:
				guardarPartida(pPersonajeActual);
				break;
			case 3:
				listarPartidasPersonaje(pPersonajeActual);
				break;
			case 4:
				peleaEnemigo();
				break;
			case 5:
				menuInventario(personajeEnJuego);
				break;
			default:
				out.println("Opción incorrecta.");

			}
		} while (opcion != 4);
	}

	static String[][] mapaGenerado;

	public static void moverJugador(int pPosicionXPersonajeActual, int pPosicionYPersonajeActual,
			String[][] pMapaActual) throws Exception {

		Validacion validaciones = FabricaGestores.crearValidacion();
		mapaGenerado = pMapaActual;

		System.out.println("Digite la coordenada a la cual desea moverse: (separada por ',' Ejm: 3,5)");
		String coordenadas = in.readLine();
		String[] coordenada = coordenadas.split(",");
		int coordXDestino = Integer.parseInt(coordenada[0]);
		int coordYDestino = Integer.parseInt(coordenada[1]);
		boolean validacionMovida = validaciones.validarMovida(pPosicionXPersonajeActual, pPosicionYPersonajeActual,
				coordXDestino, coordYDestino);
		int evento = validaciones.accionMover(mapaGenerado[coordXDestino][coordYDestino]);
		if (validacionMovida == true) {
			procesarEvento(evento, pPosicionXPersonajeActual, pPosicionYPersonajeActual, coordXDestino, coordYDestino);
			imprimirMapa(mapaGenerado);
		} else {
			System.out.println("\nCoordenada inválida.");
		}
	}

	public static void procesarEvento(int triggerEvento, int pPosicionXPersonajeActual, int pPosicionYPersonajeActual,
			int coordXDestino, int coordYDestino) {

		switch (triggerEvento) {
		case 1:
			moverNormal(pPosicionXPersonajeActual, pPosicionYPersonajeActual, coordXDestino, coordYDestino);
			break;
		}
	}

	public static void moverNormal(int pPosicionXPersonajeActual, int pPosicionYPersonajeActual, int coordXDestino,
			int coordYDestino) {

		mapaGenerado[pPosicionXPersonajeActual][pPosicionYPersonajeActual] = "-";
		mapaGenerado[coordXDestino][coordYDestino] = "P";
		posicionXActualPersonaje = coordXDestino;
		posicionYActualPersonaje = coordYDestino;

	}

	public static void guardarPartida(String pNombrePersonaje) {
		GestorMapa gmapa = FabricaGestores.crearGestorMapa();
		gmapa.guardarPartida(pNombrePersonaje, mapaGenerado);
	}

	public static void peleaEnemigo() throws Exception {
		int opc;
		boolean noSalir = true;

		String[] listaMenuPelea = { "1. Atacar", "2. Huir", "3. Salir" };
    
		if(noSalir == true) {
			mostrarMenu(listaMenuPelea);
			opc = leerOpcionPelea();
			noSalir = ejecutarAccionPelea(opc);
		}

		out.println("Hasta luego, duelista");
	}

	static int leerOpcionPelea() throws java.io.IOException {

		int opcion;

		out.print("Seleccione su opcion: ");
		opcion = Integer.parseInt(in.readLine());
		out.println();

		return opcion;
	}

	static boolean ejecutarAccionPelea(int popcion) throws Exception {

		boolean noSalir = true;

		switch (popcion) {

		case 1:
			Combate(personajeEnJuego);
			break;

		case 2:
			iniciarSesion();
			break;

		case 3:
			noSalir = false;
			break;

		default:

			out.println("Opcion invalida");
			out.println();
			break;
		}

		return noSalir;
	}

	public static void Combate(Personaje pPersonajeEnJuego) {
    
		EnemigoEpico enemigo = new EnemigoEpico();
		System.out.println("Encontraste a un enemigo " + enemigo.getTipo());

		do {
			cambioTurno(pPersonajeEnJuego, enemigo);
		} while (isCombateActivo(pPersonajeEnJuego, enemigo));

	}

	public static void cambioTurno(Personaje personaje, Enemigo enemigo) {

		if (personaje.getHp_actual() >= enemigo.getHp_actual()) {
			System.out.println("Has atacado a " + enemigo.getTipo() + " " + personaje.getHp_actual());
			enemigo.quitarVida(personaje.getAtk());

			if (enemigo.isAlive()) {
				System.out.println(enemigo.getTipo() + "El enemigo ataca de vuelta!" + enemigo.getHp_actual());
				personaje.quitarVida(enemigo.getAtk());
			}
		} else {
			System.out.println("El enemigo te ha atacado " + personaje.getHp_actual());
			personaje.quitarVida(enemigo.getAtk());
			if (personaje.isAlive()) {
				System.out.println("Has atacado devuelta a: " + enemigo.getTipo() + "" + enemigo.getHp_actual());
				enemigo.quitarVida(personaje.getAtk());
			}
		}

	}

	public static boolean isCombateActivo(Personaje personaje, Enemigo enemigo) {
		if (personaje.isAlive() && enemigo.isAlive()) {
			return true;
		} else if (!personaje.isAlive()) {
			System.out.println(
					"GAME OVER" + " " + "Te ha vencido: " + enemigo.getTipo() + " " + enemigo.getHp_actual() + "\n");
			System.out.println("Vida Personaje " + personaje.getHp_actual());
			System.out.println("Vida enemigo " + enemigo.getHp_actual());
			return false;
		} else {
			System.out.println("¡Felidades! Has vencido a: " + enemigo.getTipo() + "\n");
			System.out.println("Vida Personaje " + personaje.getHp_actual());
			System.out.println("Vida enemigo " + enemigo.getHp_actual());
			return false;
		}
	}

	public static void menuInventario(Personaje pPersonajeEnJuego) throws IOException {
		ArmaEpica armaEpica = new ArmaEpica();

		int opcion;
		opcion = -1;

		out.println("Has encontrado: " + armaEpica.getNombre() + "\n");
		out.println("1. Agregar al inventario");
		out.println("2. Ignorar y continuar");
		out.print("Digite la opcion" + "\n");
		opcion = Integer.parseInt(in.readLine());
		procesarOpcionInventario(opcion);

	}

	public static void procesarOpcionInventario(int pOpcion) throws IOException {

		switch (pOpcion) {
		case 1:
			pickUpInventario(personajeEnJuego);
			break;
		case 2:
			break;

		default:
			out.println("Opción inválida");
		}
	}

	public static void pickUpInventario(Personaje pPersonajeEnJuego) {

		ArmaEpica armaEpica = new ArmaEpica();
		System.out.println(" ");
		System.out.println("Has obtenido: " + armaEpica.getNombre());

		accionPickUp(pPersonajeEnJuego, armaEpica);

	}

	public static void accionPickUp(Personaje pPersonajeEnJuego, Inventario objeto) {
		pPersonajeEnJuego.agregarInventario(objeto.getVida(), objeto.getAtaque());
		System.out.println("Vida: " + personajeEnJuego.getHp_actual());
		System.out.println("Ataque: " + personajeEnJuego.getAtk());
		System.out.println(" ");
	}

}
