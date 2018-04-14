package com.cenfotec.patrones.armadura;

import com.cenfotec.patrones.inventario.Item;

public class ArmaduraEpica extends Item{
	public ArmaduraEpica() {
		description = "";
	}

	@Override
	public double vida() {
		return 0;
	}

	@Override
	public double ataque() {
		return 0;
	}
	

}
