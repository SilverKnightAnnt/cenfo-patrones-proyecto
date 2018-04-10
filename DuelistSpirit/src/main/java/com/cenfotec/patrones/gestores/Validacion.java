package com.cenfotec.patrones.gestores;

public class Validacion {

	public int accionMover(String elementoDestino) {		
		int triggerEvento = -1;
		switch(elementoDestino) {
		case "-":
			triggerEvento = 1;
			break;
		}
		return triggerEvento;
	}
	
	public boolean validarMovida(int pPosicionXPersonajeActual,int pPosicionYPersonajeActual,int coordXDestino,int coordYDestino) {
		boolean movimientoPermitido = false;
		boolean xValida = false;
		boolean yValida = false;
		if ((pPosicionXPersonajeActual + 1) == coordXDestino || pPosicionXPersonajeActual == coordXDestino
				|| (pPosicionXPersonajeActual - 1) == coordXDestino) {
			xValida = true;
		}
		if ((pPosicionYPersonajeActual + 1) == coordYDestino || pPosicionYPersonajeActual == coordYDestino
				|| (pPosicionYPersonajeActual - 1) == coordYDestino) {
			yValida = true;
		}
		if(xValida == true && yValida == true) {
			movimientoPermitido = true;
		}
		return movimientoPermitido;
	}
}
