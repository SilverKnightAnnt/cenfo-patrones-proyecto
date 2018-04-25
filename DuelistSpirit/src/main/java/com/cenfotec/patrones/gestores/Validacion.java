package com.cenfotec.patrones.gestores;

public class Validacion {

	public int accionMover(String elementoDestino) {		
		int triggerEvento = -1;
		switch(elementoDestino) {
		case "-":
			triggerEvento = 1;
			break;
		case "MR":
			triggerEvento = 2;
			break;
		case "ME":
			triggerEvento = 3;
			break;
		case "ML":
			triggerEvento = 4;
			break;
		case "WR":
			triggerEvento = 5;
			break;
		case "WE":
			triggerEvento = 6;
			break;
		case "WL":
			triggerEvento = 7;
			break;
		case "AR":
			triggerEvento = 8;
			break;
		case "AE":
			triggerEvento = 9;
			break;
		case "AL":
			triggerEvento = 10;
			break;
		case "+":
			triggerEvento = 11;
			break;
		case "M":
			triggerEvento = 12;
			break;
		case "B":
			triggerEvento = 13;
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
