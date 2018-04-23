package com.cenfotec.patrones.armas;

import com.cenfotec.patrones.inventario.Item;

public class ArmaRegular extends Item {
	public ArmaRegular() {
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
