import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        TextOutput textOutput = new TextOutput();
        TextOutput.welcome();

        Scanner lectura = new Scanner(System.in);
        ConsultarPelicula consulta = new ConsultarPelicula();

        System.out.println("Choose the number of the movie (using int 1 - 6)");

        try {
            var numeroDePelicula =  Integer.valueOf(lectura.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
            System.out.println(pelicula);
            GeneradoDeArchivo generador = new GeneradoDeArchivo();
            generador.guardarJason(pelicula);
        }catch (NumberFormatException e) {
            System.out.println("Number not found "+ e.getMessage());
        }
        catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Ending the application.");
        }
    }
}
