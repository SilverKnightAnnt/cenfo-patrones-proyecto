package com.cenfotec.patrones.fabricas;

import com.cenfotec.patrones.enemigo.*;

public class FabricaEnemigos {
	
	public static EnemigoRegular crearEnemigoRegular() {		
		return new EnemigoRegular();		
	}

	public static EnemigoEpico crearEnemigoEpico() {		
		return new EnemigoEpico();		
	}
	
	public static EnemigoLegendario crearEnemigoLegendario() {		
		return new EnemigoLegendario();		
	}
	
}
