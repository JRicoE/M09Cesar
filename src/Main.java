import java.util.Scanner;

/**
 * Created by 41008163z on 03/11/16.
 */
public class Main {
    public static void main(String[] args) {
        //Se crean dos scanners uno para las posiciones y otro para el texto
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        //Se pregunta las posiciones y el texto y se guardan en variables
        System.out.println("Escribe las posiciones que se tiene que mover hacia delante (positivo) o hacia atras (negativo): ");
        int posiciones = input.nextInt();
        System.out.println("Escribe el texto: ");
        String texto = inputString.nextLine();

        //Se crea el string final donde se guardará el texto ya desencriptado con el metodo
        String strfinal = moverLetras(texto, posiciones);

        System.out.println(strfinal);
        input.close();
    }

    /**
     * El metodo se encarga de recibir el texto y las posiciones y si el texto contiene
     * letras, sean mayusculas o minusculas, las cambia a las de la posicion seleccionada
     * del abecedario
     * @param texto Recibe el String con el texto que se quiere desencriptar
     * @param posiciones Recibe el numero de posiciones negativo o positivo que se quiere mover las letras
     * @return Devuelve el String con las letras de "texto" cambiadas
     */
    private static String moverLetras(String texto, int posiciones){

        String strfinal=""; //String que ira guardando las letras cambiadas
        char cambiada; //char donde se ira guardando la letra desencriptada
        int letra; //Esta variable guarda el codigo unicode de la letra

        for (int pos=0;pos<texto.length();pos++) { //Este for va recorriendo el String texto letra a letra

            letra = texto.codePointAt(pos); //Esta variable guarda el valor Unicode de la posicion del for del texto

            if (letra >= 97 && letra <= 122) { //Si el valor unicode esta comprendido entre las letras minusculas...

                letra = letra + posiciones; //...se le suman las posiciones

                if (letra > 122) { //Si al sumarle las posiciones la letra se pasa de la "z", se le resta 26 para que este dentro del abecedario
                    letra = letra - 26;
                }else if(letra < 97){ //Lo mismo si al restarle posiciones se pasa de la "a"
                    letra = letra + 26;
                }

                cambiada = (char)letra; //TypeCast del valor unicode de la letra a char
                strfinal = strfinal + cambiada; //Y se añade al final del string final

            }else if (letra>=65&&letra<=90) { //El mismo caso que el if anterior pero para las mayusculas

                letra = letra + posiciones;

                if (letra>90) {
                    letra = letra - 26;
                }else if(letra < 65){
                    letra = letra + 26;
                }

                cambiada = (char)letra;
                strfinal=strfinal+cambiada;

            }else { //En el caso que el valor unicode del caracter no este entre el de las letras, se añadira directamente al string final

                cambiada = (char)letra;
                strfinal = strfinal + cambiada;

            }
        }

        return strfinal;
    }
}