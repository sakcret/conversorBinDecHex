/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conversorbindechex;

/**
 *
 * @author jarc
 */
abstract public class Conversor {
    
    static int binarioToDecimal(String binario){
        double coeficiente= Math.pow(2,binario.length()-1);
        int decimal_str=0;
        
        for(int i=0; i<binario.length();i++){
            String tmp=String.valueOf(binario.charAt(i));
            int digito_binario=(int)Integer.parseInt(tmp);
            decimal_str=decimal_str+digito_binario* (int)coeficiente;
            coeficiente=coeficiente/2;
         }
        return decimal_str;
    }
    
    static String decimalToBinario(int decimal){
        int cociente=0;
        String resultado="";
        do{
        cociente= decimal/2;
        int residuo=decimal%2;
        decimal=cociente;
        resultado=residuo+resultado;
        }while(cociente>0);
        return resultado;
    }
    
    static int hexadecimalToDecimal(String hexadecimal){
        int suma = 0;
        //invertir cadena en hexadecimal Ejemplo 2A  en A2
        StringBuilder hexadecimal_reverse = new StringBuilder(hexadecimal).reverse();
        for (int i = 0; i < hexadecimal_reverse.length(); i++) {
            char char_at = hexadecimal_reverse.charAt(i);
            if (char_at == 'A'||char_at=='a') {
                suma += 10 * Math.pow(16, i);
            } else if (char_at=='B'||char_at=='b') {
                suma += 11 * Math.pow(16, i);
            } else if (char_at=='C' ||char_at=='c') {
                suma += 12 * Math.pow(16, i);
            } else if (char_at=='D'||char_at=='d') {
                suma += 13 * Math.pow(16, i);
            } else if (char_at=='E'||char_at=='e') {
                suma += 14 * Math.pow(16, i);
            } else if (char_at=='F'||char_at=='f') {
                suma += 15 * Math.pow(16, i);
            }else{
                suma+=(Integer.parseInt(char_at+""))* Math.pow(16, i);;
            }
        }
        return suma;
    }
    
    static String decimalToHexadecimal(int decimal){
        int cociente = 0;
        String str_hexadecimal = "";
        do {
            int residuo = 0;
            residuo = decimal % 16;
            cociente = decimal / 16;
            decimal = cociente;
            if (residuo == 10) {
                str_hexadecimal = "A" + str_hexadecimal;
            } else if (residuo == 11) {
                str_hexadecimal = "B" + str_hexadecimal;
            } else if (residuo == 12) {
                str_hexadecimal = "C" + str_hexadecimal;
            } else if (residuo == 13) {
                str_hexadecimal = "D" + str_hexadecimal;
            } else if (residuo == 14) {
                str_hexadecimal = "E" + str_hexadecimal;
            } else if (residuo == 15) {
                str_hexadecimal = "F" + str_hexadecimal;
            } else {
                str_hexadecimal = residuo + str_hexadecimal;
            }
        } while(decimal>0);
        return str_hexadecimal;
    }
}
