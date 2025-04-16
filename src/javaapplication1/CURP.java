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
public class CURP {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String cadena = scanner.nextLine();

        Set<String> estados = new HashSet<>();
        Set<Character> alfabeto = new HashSet<>();
        for (int i = 0; i <= 18; i++) {
            estados.add("q" + i);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            alfabeto.add(c);
        }
        for (char c = '0'; c <= '9'; c++) {
            alfabeto.add(c);
        }

        String estadoInicial = "q0";
        Set<String> estadosFinales = new HashSet<>(Arrays.asList("q18"));

        Map<String, Map<Character, String>> transiciones = new HashMap<>();
        for (String estado : estados) {
            transiciones.put(estado, new HashMap<>());
        }

        for (int i = 0; i < 18; i++) {
            String actual = "q" + i;
            String siguiente = "q" + (i + 1);
            for (Character c : alfabeto) {
                transiciones.get(actual).put(c, siguiente);
            }
        }

        AFD afdCURP = new AFD(estados, alfabeto, estadoInicial, estadosFinales, transiciones);
        System.out.println(afdCURP.aceptarCadena(cadena) ? "CURP valida" : "CURP invalida ");
    }
}
