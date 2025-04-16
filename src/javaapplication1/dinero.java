/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Andrea Enid Gonzalez Castillo
 */
public class dinero {

    public static void main(String[] args) {
        //la cadena a evaluar
        Scanner scanner = new Scanner(System.in);
        String cadena = scanner.nextLine();
        
        //primero vamos a definir estados del autlmata
        Set<String> estados = new HashSet<>(Arrays.asList("q0", "q1", "q2", "q3", "q4", "q5"));
        //definimos su alfabeto
        Set<Character> alfabeto = new HashSet<>(Arrays.asList(
                '$', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'
        ));
        //aqui es su estado inicial
        String estadoInicial = "q0";
        //el unico estado final es q5
        Set<String> estadosFinales = new HashSet<>(Arrays.asList("q5"));
        //aqui agregamos las transiciones que puede o que tiene el automata
        Map<String, Map<Character, String>> transiciones = new HashMap<>();
        for (String estado : estados) {
            transiciones.put(estado, new HashMap<>());
        }

        transiciones.get("q0").put('$', "q1");

        for (char d = '0'; d <= '9'; d++) {
            transiciones.get("q1").put(d, "q2");
            transiciones.get("q2").put(d, "q2");
        }

        transiciones.get("q2").put('.', "q3");

        for (char d = '0'; d <= '9'; d++) {
            transiciones.get("q3").put(d, "q4");
            transiciones.get("q4").put(d, "q5");
        }

        AFD afdMonto = new AFD(estados, alfabeto, estadoInicial, estadosFinales, transiciones);
        //con una validacion ternaria se logra en una linea saber si es valido
        System.out.println(afdMonto.aceptarCadena(cadena) ? "Monto válido" : "Monto inválido");

    }
}
