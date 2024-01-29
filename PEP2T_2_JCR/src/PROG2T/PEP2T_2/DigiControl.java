package PROG2T.PEP2T_2;

import java.util.Scanner;

public class DigiControl {

    //Método para generar 2 dígitos de control
    public void generarDigitosControl(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce los 4 digitos del banco:");
        String banco = teclado.nextLine();

        System.out.println("Introduce los 4 digitos de la sucursal:");
        String sucursal = teclado.nextLine();

        System.out.println("Introduce los 10 digitos del Nº de cuenta:");
        String n_cuenta = teclado.nextLine();

        String dControl =  digitosControl(banco, sucursal, n_cuenta);
        System.out.print("2098 0008 DC1DC2 1207383832 -> ");
        System.out.println(banco + " " + sucursal + " " + dControl + " " + n_cuenta + "\n");
    }

    public String digitosControl(String banco, String sucursal, String n_cuenta){
        String tipoDigControl1 = "00" + banco + sucursal;
        String tipoDigControl2 = n_cuenta;

        int digControl1 = calcularDigitosControl(tipoDigControl1);
        int digControl2 = calcularDigitosControl(tipoDigControl2);

        String d_control =  String.valueOf(digControl1) + String.valueOf(digControl2);
        return d_control;
    }

    //Método para calcular 2 dígitos de control
    private Integer calcularDigitosControl(String digControl){
        int [] constantes = {1,2,4,8,5,10,9,7,3,6};

        char [] caracteres = digControl.toCharArray();
        int acumulado = 0;

        for (int i = 0; i < caracteres.length; i++){
            int numero = Character.getNumericValue(caracteres[i]);
            acumulado += numero * constantes[i];
        }

        int resto = 11 - acumulado % 11;
        int resultado;

        if(resto >= 0 && resto <= 9){
            resultado = resto;
        } else if( resto == 10) {
            resultado = 1;
        } else {
            resultado = 0;
        }

        return resultado;
    }

    public void validarDigitosControl(){
        Scanner teclado = new Scanner(System.in);
        DigiControl d = new DigiControl();

        System.out.println("Introduce los 4 digitos del banco:");
        String banco = teclado.nextLine();

        System.out.println("Introduce los 4 digitos de la sucursal:");
        String sucursal = teclado.nextLine();

        System.out.println("Introduce los 2 digitos del Nº de control:");
        String digitControl = teclado.nextLine();

        System.out.println("Introduce los 10 digitos del Nº de cuenta:");
        String n_cuenta = teclado.nextLine();

        String d_control = digitosControl(banco, sucursal, n_cuenta);

        String cuentaCorriente = banco + " " + sucursal + " " + digitControl + " " + n_cuenta;

        System.out.println("Número de cuenta a validar: " + cuentaCorriente);
        System.out.print("Dígitos calculados: " + d_control + " ");

        boolean verificacion = d_control.equals(digitControl);

        if(verificacion) {
            System.out.println(" Verificación: Correcta");
        } else {
            System.out.println(" Verificación: Incorrecta");
        }
    }


}
