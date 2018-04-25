package com.cenfotec.patrones.fabricas;

import com.cenfotec.patrones.armadura.*;
import com.cenfotec.patrones.armas.*;

public class FabricaInventario {

	public static ArmaRegular crearArmaRegular() {		
		return new ArmaRegular();		
	}
	
	public static ArmaEpica crearArmaEpica() {		
		return new ArmaEpica();		
	}
	
	public static ArmaLegendaria crearArmaLegendaria() {		
		return new ArmaLegendaria();		
	}
	
	public static ArmaduraRegular crearArmaduraRegular() {		
		return new ArmaduraRegular();		
	}
	
	public static ArmaduraEpica crearArmaduraEpica() {		
		return new ArmaduraEpica();		
	}
	
	public static ArmaduraLegendaria crearArmaduraLegendaria() {		
		return new ArmaduraLegendaria();		
	}
	
	
}
