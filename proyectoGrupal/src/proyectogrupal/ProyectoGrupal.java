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
        do {
            System.out.println("\n===** MENÚ PRINCIPAL **====\n");
            System.out.println("====    1. CIFRADO     ====");
            System.out.println("====    2. FILTRAR     ====");
            System.out.println("==== 3. CODIGO ENIGMA  ====");
            System.out.print("\nSelecciona una opcion: ");
            opSeleccion = leer.nextInt();

            switch (opSeleccion) {
                case 1:

                    break;

                case 2:
                    System.out.println("\n===** SECCION FILTRAR **====\n");

                    System.out.print("Ingrese una frase: ");
                    String frase = leer.next();
                    System.out.print("Ingrese longitud minima: ");
                    int longitud = leer.nextInt();
                    char letrasFrase = ' ',
                     letrasPalabras = ' ';
                    String palabras = "",
                     palabrasUnidas = "";

                    String fraseReemplazada = frase.replaceAll("[,.]", "");

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
                    System.out.println("Palabras con mayor longitud a " + longitud + " son: \n" + palabrasUnidas);

                    break;

                case 3:
                    int seleccion = 0;
                    do {
                        System.out.println("\n===** CODIGO ENIGMA **====\n");
                        System.out.println("=== 1.  Encriptacion    ===");
                        System.out.println("=== 2. Desencriptacion  ===");
                        System.out.println("=== 3.    Regresar      ===");
                        System.out.print("\nSelecciona una opcion: ");
                        seleccion = leer.nextInt();
                        
                        switch(seleccion){
                            case 1:
                                
                                break;
                                
                            case 2:
                                
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
                    
                case 4:
                    System.out.println("\n==** SALIENDO DE SISTEMA **==");
                    break;
                    
                default:
                    System.out.println("\n**Selecciona una opcion valida**");
                    break;
            }

        } while (opSeleccion != 4);

    }
}
