/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogrupal;

import java.util.Scanner;

/**
 *
 * @author hnleo
 */
public class ProyectoGrupal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        leer.useDelimiter("\n");
        int opSeleccion = 0;

        // APARTADO MENU PRINCIPAL
        do {
            System.out.println("\n===** MENÚ PRINCIPAL **====\n");
            System.out.println("====    1. CIFRADO     ====");
            System.out.println("====    2. FILTRAR     ====");
            System.out.println("==== 3. CODIGO ENIGMA  ====");
            System.out.println("====    4. SALIR       ====");
            System.out.print("\nSelecciona una opcion: ");
            opSeleccion = leer.nextInt();

            switch (opSeleccion) {

                // SECCION CODIGO CESAR
                case 1:
                    System.out.println("\n===** SECCION CIFRADO **====\n");
                    int posiciones = 0;
                    System.out.print("Ingrese el texto a modificar: ");
                    String frase = leer.next();
                    boolean valido = false;
                    while (!valido) {
                        System.out.print("Ingrese posiciones a desplazar: ");
                        posiciones = leer.nextInt();
                        if (posiciones >= 0) {
                            valido = true;
                        }

                    }
                    String minABC = "abcdefghijklmnopqrstuvwxyz";
                    String mayABC = minABC.toUpperCase();
                    int longitudFrase = frase.length();
                    String fraseCompleta = "";
                    for (int i = 0; i < longitudFrase; i++) //i se inicializa en 0 para que pueda compararse con la longitud de la frase
                    {
                        char letra = frase.charAt(i);//Consigo la letra
                        if (Character.isUpperCase(letra)) //Si es upperCase
                        {
                            int posicionLetraABC = mayABC.indexOf(letra);

                            fraseCompleta += mayABC.charAt((posicionLetraABC + posiciones) % 26);

                        } else if (Character.isLowerCase(letra))//Si no es upper case
                        {
                            int posicionLetraABC = minABC.indexOf(letra);

                            fraseCompleta += minABC.charAt((posicionLetraABC + posiciones) % 26); // el %26 es para poder darle vuelta

                        } else //Si es algun caracter extra
                        {

                            fraseCompleta += letra;
                        }
                    }

                    System.out.println("La frase encriptada es: " + fraseCompleta);

                    break;

                //SECCION FILTRAR
                case 2:
                    System.out.println("\n===** SECCION FILTRAR **====\n");

                    System.out.print("Ingrese una frase: ");
                    String frase2 = leer.next();
                    System.out.print("Ingrese longitud minima: ");
                    int longitud = leer.nextInt();
                    char letrasFrase = ' ',
                     letrasPalabras = ' ';
                    String palabras = "",
                     palabrasUnidas = "";

                    String fraseReemplazada = frase2.replaceAll("[,.?!\"]", "");

                    for (int i = 0; i < fraseReemplazada.length(); i++) {
                        letrasFrase = fraseReemplazada.charAt(i);
                        if (letrasFrase != ' ') {
                            palabras += letrasFrase;
                        } else {
                            if (palabras.length() > longitud) {
                                palabrasUnidas += palabras + "\n";
                            }
                            palabras = "";
                        }

                    }
                    if (palabras.length() > longitud) {
                        palabrasUnidas += palabras + "\n";
                    } else {
                        palabras = "";
                    }

                    if (palabrasUnidas.equals("")) {
                        System.out.println("No hay palabras con longitud mayor a " + longitud);
                    }else{
                          System.out.println("Palabras con mayor longitud a " + longitud + " son: \n" + palabrasUnidas);
                    }
      
                    break;

                //SECCION CODIGO ENIGMA
                case 3:
                    int seleccion = 0;
                    String textoEncriptado = "";

                    do {
                        System.out.println("\n===** CODIGO ENIGMA **====\n");
                        System.out.println("=== 1.  Encriptacion    ===");
                        System.out.println("=== 2. Desencriptacion  ===");
                        System.out.println("=== 3.    Regresar      ===");
                        System.out.print("\nSelecciona una opcion: ");
                        seleccion = leer.nextInt();

                        switch (seleccion) {
                            case 1:
                                System.out.println("\n==* Encriptar texto *==");
                                System.out.print("\nIngrese un texto: ");
                                String palabra = leer.next();
                                String letrasPar = "",
                                 letrasImpar = "";
                                textoEncriptado = "";
                                char letra = ' ';
                                for (int i = 0; i < palabra.length(); i++) {
                                    letra = palabra.charAt(i);
                                    if (i % 2 == 0) {
                                        letrasPar += letra;
                                    } else {
                                        letrasImpar += letra;
                                    }
                                }

                                textoEncriptado = letrasPar + letrasImpar;

                                System.out.println("Texto encriptado: " + textoEncriptado);

                                break;

                            case 2:
                                int longitudTexto = 0;
                                int division = 0;
                                String textoPar,
                                 textoImpar,
                                 textoFinal = "";
                                char lePar = ' ',
                                 leImp = ' ';

                                System.out.println("\n==* Desencriptar texto *==");

                                System.out.print("Escriba una palabra a desencriptar: ");
                                String textoEncriptadoU = leer.next();
                                longitudTexto = textoEncriptadoU.length();

                                if (longitudTexto % 2 == 0) {
                                    division = longitudTexto / 2;
                                } else {
                                    division = (longitudTexto / 2) + 1;
                                }

                                textoPar = textoEncriptadoU.substring(0, division);
                                textoImpar = textoEncriptadoU.substring(division, longitudTexto);

                                for (int z = 0; z < textoPar.length(); z++) {

                                    lePar = textoPar.charAt(z);
                                    textoFinal += lePar;

                                    if (z < textoImpar.length()) {
                                        leImp = textoImpar.charAt(z);

                                        textoFinal += leImp;
                                    }

                                }

                                System.out.println("\nTexto: " + textoEncriptadoU);
                                System.out.println("Texto Desencriptado: " + textoFinal);

                                break;

                            case 3:
                                System.out.println("** Regresando.. **");
                                break;

                            default:
                                System.out.println("\n**Selecciona una opcion valida..**");
                                break;
                        }

                    } while (seleccion != 3);
                    break;

                //SALIR
                case 4:
                    System.out.println("\n==** SALIENDO DE SISTEMA **==");
                    break;
                // OPCION INVALIDA
                default:
                    System.out.println("\n**Selecciona una opcion valida**");
                    break;
            }

        } while (opSeleccion != 4);

    }
}
