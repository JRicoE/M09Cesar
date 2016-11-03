import java.util.Scanner;

/**
 * Created by 41008163z on 03/11/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Escribe las posiciones que se tiene que mover hacia delante (positivo) o hacia atras (negativo): ");
        int posiciones = input.nextInt();
        System.out.println("Escribe la palabra o frase: ");
        String texto = input.next();

        String strfinal= moverLetras(texto, posiciones);

        System.out.println(strfinal);
        input.close();
    }

    
    private static String moverLetras(String texto, int posiciones){

        String strfinal="";
        char[] cambiada;
        int letra;

        for (int pos=0;pos<texto.length();pos++) {

            letra = texto.codePointAt(pos);

            if (letra >= 97 && letra <= 122) {

                letra = letra + posiciones;

                if (letra > 122) {
                    letra = letra - 26;
                }else if(letra < 97){
                    letra = letra + 26;
                }

                cambiada = Character.toChars(letra);

                strfinal = strfinal + cambiada[0];

            }else if (letra>=65&&letra<=90) {
                letra = letra + posiciones;

                if (letra>90) {
                    letra = letra - 26;
                }else if(letra < 65){
                    letra = letra + 26;
                }

                cambiada = Character.toChars(letra);

                strfinal=strfinal+cambiada[0];
            }
        }

        return strfinal;
    }

}
