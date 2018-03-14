package com.cenfotec.patrones.UI;

import java.io.*;

public class IU{
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;


	int opcUser=0;
	
	public static void main(String[] args)throws java.io.IOException{
		
		int opc;
		boolean noSalir = true, create;
		
		String[] listaMenu={"1. Crear cuenta",
							"2. Iniciar sesión",
							"3. Nueva partida",
							"4. Cargar partida",
							"5. Salir"};
							
		out.println("****************************************************************");
		out.println("***************BIENVENIDO A DUELISTSPIRIT*************");
		out.println("****************************************************************");
		out.println();	
		
		
		do{
			mostrarMenu(listaMenu);
			opc = leerOpcion();
			noSalir = ejecutarAccion(opc);

		}while (noSalir);
		
		out.println("Gracias por usar nuestro sistema, que tenga un buen dia :)");
	}

	static void mostrarMenu(String[] plista){
		
		for(int i=0;i<plista.length;i++){
			out.println(plista[i]);
		}
		out.println();
	}

	static int leerOpcion()throws java.io.IOException{
				
		int opcion;

		out.print("Seleccione su opcion: ");
		opcion = Integer.parseInt(in.readLine());
		out.println();

		return opcion;
	}


	static boolean ejecutarAccion(int popcion)throws java.io.IOException{


		boolean noSalir = true;
				
				switch(popcion){
			

			case 1:
				
				break;

			case 2:

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
}