package com.cenfotec.patrones.modificadores;

import com.cenfotec.patrones.enemigoController.Enemy;

public class EMEpico {
	Enemy enemy;

	public EMEpico(Enemy enemy) {
		this.enemy = enemy;
	}

	public String getDescription(){
		return enemy.getDescription();
	}
	
	public double EnemigoEpicoATK() {
		return 10 + enemy.ataque();
	}
	
	public double EnemigoEpicoVIDA() {
		return 110 + enemy.vida();
	}

}
