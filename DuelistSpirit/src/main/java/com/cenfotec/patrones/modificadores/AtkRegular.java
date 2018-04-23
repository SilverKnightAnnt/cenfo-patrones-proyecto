package com.cenfotec.patrones.modificadores;

import com.cenfotec.patrones.inventario.Item;

public class AtkRegular {
	Item item;

	public AtkRegular(Item item) {
		this.item = item;
	}

	public String getDescription() {
		return item.getDescription();
	}

	public double ATK_Regular() {
		return 5 + item.ataque();
	}

}
