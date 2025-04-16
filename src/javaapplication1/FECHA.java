/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
public class FECHA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cadena = scanner.nextLine();

        Set<String> estados = new HashSet<>(Arrays.asList(
                "q0", "q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9", "q9a", "q9b", "q10"
        ));
        Set<Character> alfabeto = new HashSet<>(Arrays.asList(
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '/'
        ));
        String estadoInicial = "q0";
        Set<String> estadosFinales = new HashSet<>(Arrays.asList("q10"));

        Map<String, Map<Character, String>> transiciones = new HashMap<>();

        
        for (String estado : estados) {
            transiciones.put(estado, new HashMap<>());
        }

        
        transiciones.get("q0").put('0', "q1"); 
        transiciones.get("q0").put('1', "q1"); 
        transiciones.get("q0").put('2', "q1"); 
        transiciones.get("q0").put('3', "q2");

        
        for (char d = '1'; d <= '9'; d++) {
            transiciones.get("q1").put(d, "q3");
        }
        transiciones.get("q2").put('0', "q3");
        transiciones.get("q2").put('1', "q3");

        
        transiciones.get("q3").put('/', "q4");

        
        transiciones.get("q4").put('0', "q5"); 
        transiciones.get("q4").put('1', "q6"); 

        
        for (char d = '1'; d <= '9'; d++) {
            transiciones.get("q5").put(d, "q7");
        }
        transiciones.get("q6").put('0', "q7"); 
        transiciones.get("q6").put('1', "q7"); 
        transiciones.get("q6").put('2', "q7"); 

       
        transiciones.get("q7").put('/', "q8");

        
        for (char d = '0'; d <= '9'; d++) {
            transiciones.get("q8").put(d, "q9");
            transiciones.get("q9").put(d, "q9a");
            transiciones.get("q9a").put(d, "q9b");
            transiciones.get("q9b").put(d, "q10");
        }

        AFD afd = new AFD(estados, alfabeto, estadoInicial, estadosFinales, transiciones);

        if (afd.aceptarCadena(cadena)) {
            System.out.println("Fecha válida");
        } else {
            System.out.println("Fecha inválida");
        }

    }

}
