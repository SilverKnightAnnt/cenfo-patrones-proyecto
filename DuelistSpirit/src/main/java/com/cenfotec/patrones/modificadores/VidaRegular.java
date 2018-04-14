package com.cenfotec.patrones.modificadores;

import com.cenfotec.patrones.inventario.Item;

public class VidaRegular {
	Item item;
	
	public VidaRegular(Item item) {
		this.item = item;
	}
	
	public String getDescription() {
		return item.getDescription();
	}
	
	public double VIDA_Regular() {
		return 5 + item.vida();
	}
}
