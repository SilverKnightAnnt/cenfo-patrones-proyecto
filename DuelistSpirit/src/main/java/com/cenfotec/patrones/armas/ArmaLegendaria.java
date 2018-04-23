package com.cenfotec.patrones.armas;

import com.cenfotec.patrones.inventario.Item;

public class ArmaLegendaria extends Item {
	public ArmaLegendaria() {
		description = "";
	}

	@Override
	public double vida() {
		return 0;
	}

	@Override
	public double ataque() {
		return 15;
	}

}
