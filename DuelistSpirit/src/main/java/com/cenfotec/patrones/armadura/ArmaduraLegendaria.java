package com.cenfotec.patrones.armadura;

import com.cenfotec.patrones.inventario.Item;

public class ArmaduraLegendaria extends Item{
	public ArmaduraLegendaria() {
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
