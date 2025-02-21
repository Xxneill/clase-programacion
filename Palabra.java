package com.mycompany.examen;

import java.util.Scanner;

public class Palabra {
    String frase;

    public void ObtieneFrase() {
        System.out.println("Este es un programa que analiza el texto y determina bla bla bla bla bla");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese una frase para ser analizada:");
        this.frase = scanner.nextLine();
    }

    public void CuentaLetras() {
        int totalLetras = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (Character.isLetter(frase.charAt(i))) {
                totalLetras++;
            }
        }
        System.out.println("Total de letras en la frase : " + totalLetras);
    }

    public void CuentaVocales() {
        int vocales = 0;
        String vocalesStr = "aeiouAEIOUáéíóúÁÉÍÓÚ";

        for (int i = 0; i < frase.length(); i++) {
            if (vocalesStr.indexOf(frase.charAt(i)) != -1) {
                vocales++;
            }
        }

        System.out.println("Cantidad de vocales: " + vocales);
    }

    public void CuentaConsonantes() {
        int consonantes = 0;

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (Character.isLetter(c) && "aeiouAEIOUáéíóúÁÉÍÓÚ".indexOf(c) == -1) {
                consonantes++;
            }
        }

        System.out.println("Cantidad de consonantes: " + consonantes);
    }

    public void CuentaPalabras() {
        int totalPalabras = 0;
        boolean enPalabra = false; // Indica si estamos en una palabra

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            if (Character.isLetter(c)) {
                // Si encontramos una letra, estamos dentro de una palabra
                enPalabra = true;
            } else if (c == ' ' && enPalabra) {
                // Si encontramos un espacio después de una palabra, contamos la palabra
                totalPalabras++;
                enPalabra = false; // Salimos de la palabra
            }
        }

        // Si la frase termina en una palabra (sin espacio al final), contamos la última palabra
        if (enPalabra) {
            totalPalabras++;
        }

        System.out.println("Cantidad total de palabras: " + totalPalabras);
    }


    public void CuentaEspacios() {
        int espacios = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                espacios++;
            }
        }

        System.out.println("Cantidad total de espacios: " + espacios);
    }

    public void EsPalindromo() {
        // Convertimos la frase a minúsculas para uniformar la comparación
        String fraseFiltrada = frase.toLowerCase();
        StringBuilder fraseSinAcentos = new StringBuilder();

        // Recorremos cada carácter de la frase y sustituimos manualmente los acentos
        for (int i = 0; i < fraseFiltrada.length(); i++) {
            char c = fraseFiltrada.charAt(i);

            // Verificamos si el carácter es una vocal acentuada y lo sustituimos
            if (c == 'á') {
                fraseSinAcentos.append('a');
            } else if (c == 'é') {
                fraseSinAcentos.append('e');
            } else if (c == 'í') {
                fraseSinAcentos.append('i');
            } else if (c == 'ó') {
                fraseSinAcentos.append('o');
            } else if (c == 'ú') {
                fraseSinAcentos.append('u');
            } else if (Character.isLetter(c)) { // Solo agregamos letras, ignorando otros caracteres
                fraseSinAcentos.append(c);
            }
        }

        // Creamos invertida
        String fraseInvertida = new StringBuilder(fraseSinAcentos).reverse().toString();

        // Sin acentos vs invertida
        if (fraseSinAcentos.toString().equals(fraseInvertida)) {
            System.out.println("La frase es un palíndromo.");
        } else {
            System.out.println("La frase no es un palíndromo.");
        }
    }

}