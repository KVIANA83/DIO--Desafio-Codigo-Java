import java.util.Scanner;

public class Main {

    // Função para calcular a velocidade média de conexão de internet
    public static double calcularVelocidadeMedia(String[] velocidades) {
        int total = 0;

        // Percorre cada velocidade registrada
        for (String velocidade : velocidades) {
            total += Integer.parseInt(velocidade.trim()); // Converte para inteiro e soma
        }

        // Calcula a média
        double media = (double) total / velocidades.length;

        return media;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitando ao usuário a lista de velocidades de conexão registradas a cada hora
        System.out.println();
        String input = scanner.nextLine();

        // Convertendo a entrada em uma lista de strings
        String[] velocidades = input.split(",");

        // Calculando a velocidade média de conexão
        double velocidadeMedia = calcularVelocidadeMedia(velocidades);

        // Exibindo a velocidade média de conexão
        System.out.println((int) velocidadeMedia + " Mbps");

        scanner.close();
    }
}

