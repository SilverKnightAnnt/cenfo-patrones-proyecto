package com.cenfotec.patrones.modificadores;

import com.cenfotec.patrones.inventario.Item;

public class AtkEpico {
	Item item;

	public AtkEpico(Item item) {
		this.item = item;
	}

	public String getDescription() {
		return item.getDescription();
	}

	public double ATK_Epico() {
		return 10 + item.ataque();
	}

}
