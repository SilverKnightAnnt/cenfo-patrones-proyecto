package com.cenfotec.patrones.modificadores;

import com.cenfotec.patrones.enemigoController.Enemy;

public class EMLegendario {
	Enemy enemy;

	public EMLegendario(Enemy enemy) {
		this.enemy = enemy;
	}

	public String getDescription() {
		return enemy.getDescription();
	}

	public double EnemigoLegendarioATK() {
		return 15 + enemy.ataque();
	}
	
	public double EnemigoLegendarioVIDA() {
		return 115 + enemy.vida();
	}

}
