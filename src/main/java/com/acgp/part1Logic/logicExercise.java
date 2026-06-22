package com.acgp.part1Logic;

import java.util.ArrayList;
import java.util.List;

public class logicExercise {

    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();

        numeros.add(4);
        numeros.add(2);
        numeros.add(7);
        numeros.add(2);
        numeros.add(4);
        numeros.add(9);
        numeros.add(1);

        List<Integer> resultado = new ArrayList<>();

        System.out.println("Entrada: " + numeros);
        System.out.println("Resultado inicial: " + resultado);

        for (int numero : numeros) {
            boolean existe = false;

            for (int valor : resultado) {
                if (valor == numero) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                resultado.add(numero);
            }
        }
        for (int i = 0; i < resultado.size() - 1; i++) {

            int indiceMenor = i;

            for (int j = i + 1; j < resultado.size(); j++) {

                if (resultado.get(j) < resultado.get(indiceMenor)) {
                    indiceMenor = j;
                }
            }

            int temporal = resultado.get(i);
            resultado.set(i, resultado.get(indiceMenor));
            resultado.set(indiceMenor, temporal);
        }

        System.out.println("Resultado final: " + resultado);
    }
}
