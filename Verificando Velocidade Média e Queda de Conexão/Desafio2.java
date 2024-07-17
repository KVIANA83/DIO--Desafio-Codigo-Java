import java.util.Scanner;

public class Main {

    // Função para verificar queda de conexão
    public static String verificarQuedaConexao(String[] velocidades) {
        // Verifica se houve queda de conexão
        for (String velocidade : velocidades) {
            if (velocidade.trim().equals("0")) {
                return "Queda de Conexao";
            }
        }
        return "Sem Quedas";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitando ao usuário a lista de velocidades de conexão registradas a cada hora
        System.out.println();
        String input = scanner.nextLine();

        // Convertendo a entrada em uma lista de strings
        String[] velocidades = input.split(",");

        // Verificando se houve queda de conexão
        String resultado = verificarQuedaConexao(velocidades);

        // Exibindo o resultado da verificação
        System.out.println(resultado);

        scanner.close();
    }
}

