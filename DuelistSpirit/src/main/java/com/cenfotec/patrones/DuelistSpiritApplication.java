package com.cenfotec.patrones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cenfotec.patrones.gestores.GestorPersonaje;
import com.cenfotec.patrones.gestores.GestorProfesion;
import com.cenfotec.patrones.gestores.GestorRaza;
import com.cenfotec.patrones.gestores.GestorRol;

import java.io.*;

import javax.swing.JOptionPane;

@SpringBootApplication
public class DuelistSpiritApplication {

	public static void main(String[] args) {
		SpringApplication.run(DuelistSpiritApplication.class, args);
	}

}
