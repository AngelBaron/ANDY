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

        // Inicializar todos los estados con un HashMap vacío
        for (String estado : estados) {
            transiciones.put(estado, new HashMap<>());
        }

        // Día: primer dígito
        transiciones.get("q0").put('0', "q1"); // 01-09
        transiciones.get("q0").put('1', "q1"); // 10-19
        transiciones.get("q0").put('2', "q1"); // 20-29
        transiciones.get("q0").put('3', "q2"); // 30-31

        // Día: segundo dígito
        for (char d = '1'; d <= '9'; d++) {
            transiciones.get("q1").put(d, "q3"); // 01-09, 11-19, etc.
        }
        transiciones.get("q2").put('0', "q3"); // 30
        transiciones.get("q2").put('1', "q3"); // 31

        // Separador
        transiciones.get("q3").put('/', "q4");

        // Mes: primer dígito
        transiciones.get("q4").put('0', "q5"); // 01-09
        transiciones.get("q4").put('1', "q6"); // 10-12

        // Mes: segundo dígito
        for (char d = '1'; d <= '9'; d++) {
            transiciones.get("q5").put(d, "q7"); // 01-09
        }
        transiciones.get("q6").put('0', "q7"); // 10
        transiciones.get("q6").put('1', "q7"); // 11
        transiciones.get("q6").put('2', "q7"); // 12

        // Separador
        transiciones.get("q7").put('/', "q8");

        // Año: 4 dígitos cualquiera
        for (char d = '0'; d <= '9'; d++) {
            transiciones.get("q8").put(d, "q9");
            transiciones.get("q9").put(d, "q9a");
            transiciones.get("q9a").put(d, "q9b");
            transiciones.get("q9b").put(d, "q10");
        }

        AFD afd = new AFD(estados, alfabeto, estadoInicial, estadosFinales, transiciones);

        if (afd.aceptarCadena(cadena)) {
            System.out.println("Fecha válida ✅");
        } else {
            System.out.println("Fecha inválida ❌");
        }

    }

}
