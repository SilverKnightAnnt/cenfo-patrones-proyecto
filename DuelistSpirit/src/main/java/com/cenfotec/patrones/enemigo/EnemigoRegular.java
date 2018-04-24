package com.cenfotec.patrones.enemigo;


import com.cenfotec.patrones.entidades.Enemigo;

public class EnemigoRegular extends Enemigo {
	public EnemigoRegular() {
		super("Enemigo Regular", 20, 20, 5);
	}
	
	/*public EnemigoRegular() {
		description = "Enemigo Regular";
	}

	@Override
	public double vida() {

		return 0;
	}

	@Override
	public double ataque() {

		return 0;
	}*/

}
