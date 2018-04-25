package com.cenfotec.patrones.modificadores;

import com.cenfotec.patrones.inventario.Item;

public class VidaEpica {
	Item item;
	
	public VidaEpica(Item item) {
		this.item = item;
	}

	public String getDescription() {
		return item.getDescription();
	}
	
	public double VIDA_Epica(){
		return 10 + item.vida();
	}
}
