package com.cenfotec.patrones.modificadores;

import com.cenfotec.patrones.inventario.Item;

public class AtkLegendaria {
	Item item;
	
	public AtkLegendaria(Item item) {
		this.item = item;
	}
	
	public String getDescription() {
		return item.getDescription();
	}
	
	public double ATK_Legendario() {
		return 15 + item.ataque();
	}
}

