package com.cenfotec.patrones.modificadores;

import com.cenfotec.patrones.inventario.Item;

public class VidaLegendaria {
	Item item;
	
	public VidaLegendaria(Item item) {
		this.item = item;
	}

	public String getDescription() {
		return item.getDescription();
	}
	
	public double VIDA_Legendaria() {
		return 15 + item.vida();
	}
}
