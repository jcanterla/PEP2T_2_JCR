package PROG2T.PEP2T_2;

import java.math.BigInteger;
import java.util.Scanner;

public class DigiIban {

    // Método para generar el IBAN
    public void generarDigitosIban(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce los 4 digitos del banco:");
        String banco = teclado.nextLine();

        System.out.println("Introduce los 4 digitos de la sucursal:");
        String sucursal = teclado.nextLine();

        System.out.println("Introduce los 2 digitos del Nº de control:");
        String digitControl = teclado.nextLine();

        System.out.println("Introduce los 10 digitos del Nº de cuenta:");
        String n_cuenta = teclado.nextLine();

        String iban = calcularDigitosIban(banco, sucursal, digitControl, n_cuenta);

        System.out.print("El resultado que se mostrará en pantalla séra: ");
        System.out.println(iban + " " + banco + " " + digitControl + " " + n_cuenta + "\n");
    }

    public String calcularDigitosIban(String banco, String sucursal, String digitControl, String n_cuenta) {

        String cadena = banco + sucursal + digitControl + n_cuenta;

        cadena += "1428";

        cadena += "00";

        BigInteger secuencia = new BigInteger(cadena);

        BigInteger resto = secuencia.remainder(new BigInteger("97"));

        BigInteger resuelto = new BigInteger("98").subtract(resto);
        String numS = resuelto.toString();
        Integer resueltoF = Integer.parseInt(numS);
        String digitoIban;

        if(resueltoF >= 0 && resueltoF <= 9) {
            digitoIban = "ES0" + resuelto;
        }else {
            digitoIban = "ES" + String.valueOf(resueltoF);
        }

        return digitoIban;
    }

    public void validarIban() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce los 4 digitos correspondiente al IBAN:");
        String digitIban = teclado.nextLine();

        System.out.println("Introduce los 4 digitos del banco:");
        String banco = teclado.nextLine();

        System.out.println("Introduce los 4 digitos de la sucursal:");
        String sucursal = teclado.nextLine();

        System.out.println("Introduce los 2 digitos del Nº de control:");
        String digitControl = teclado.nextLine();

        System.out.println("Introduce los 10 digitos del Nº de cuenta:");
        String n_cuenta = teclado.nextLine();

        String cadena = calcularDigitosIban(banco, sucursal, digitControl, n_cuenta);

        String iban = digitIban + " " + banco + " " + sucursal + " " + digitControl + " " + n_cuenta;

        System.out.println("Número de cuenta a validar: " + iban);
        System.out.print("IBAN calculado: " + cadena + " ");

        boolean verificacion = cadena.equals(digitIban);

        if(verificacion) {
            System.out.println(" Verificación: Correcta\n");
        } else {
            System.out.println(" Verificación: Incorrecta\n");
        }

    }

}
