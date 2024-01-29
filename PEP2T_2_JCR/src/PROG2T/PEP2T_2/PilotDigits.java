package PROG2T.PEP2T_2;

import java.util.Scanner;
public class PilotDigits {

    public static void main(String[] args) {
        DigiControl d = new DigiControl();
        DigiIban i = new DigiIban();

        Scanner teclado = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("\t\t\t\t\033[1m\033[4mPROGRAMA CUENTA BANCARIA\033[0m");
            System.out.println("\t\t\t\t\t\033[1mMenú de Opciones\033[0m");
            System.out.println("\t\t\t\t\t\033[1m================\033[0m\n");
            System.out.println("\t\ta) Generar dígitos de control");
            System.out.println("\t\tb) Verificar dígitos de control");
            System.out.println("\t\tc) Generar IBAN");
            System.out.println("\t\td) Verificar IBAN");
            System.out.println("\t\te) Salir");
            System.out.print("\t\t\t\t\tOpción: ");
            opcion = teclado.next();
            System.out.println();
            // Elegir la opción a usar
            switch (opcion) {
                case "a":
                    d.generarDigitosControl();
                    break;
                case "b":
                    d.validarDigitosControl();
                    break;
                case "c":
                    i.generarDigitosIban();
                    break;
                case "d":
                    i.validarIban();
                    break;
                case "e":
                    break;
                default:
                    System.out.println("\t\tOpción no valida, inserte nueva opción\n");
                    break;
            }
        } while (!opcion.equals("e"));
    }
}
