/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Andrea Enid Gonzalez Castillo
 */
public class AFD {
     // Definimos la función de transición como un mapa de mapas
    private Map<String, Map<Character, String>> transiciones;
    private Set<String> estados;
    private Set<Character> alfabeto;
    private String estadoInicial;
    private Set<String> estadosFinales;

    public AFD(Set<String> estados, Set<Character> alfabeto, String estadoInicial,
               Set<String> estadosFinales, Map<String, Map<Character, String>> transiciones) {
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.estadoInicial = estadoInicial;
        this.estadosFinales = estadosFinales;
        this.transiciones = transiciones;
    }

    public boolean aceptarCadena(String cadena) {
        String estadoActual = estadoInicial;

        for (char simbolo : cadena.toCharArray()) {
            if (!alfabeto.contains(simbolo)) {
                System.out.println("Símbolo no pertenece al alfabeto: " + simbolo);
                return false;
            }

            Map<Character, String> transicionesEstado = transiciones.get(estadoActual);

            if (transicionesEstado == null || !transicionesEstado.containsKey(simbolo)) {
                System.out.println("No hay transición definida para (" + estadoActual + ", " + simbolo + ")");
                return false;
            }

            estadoActual = transicionesEstado.get(simbolo);
        }

        return estadosFinales.contains(estadoActual);
    }

    
}
