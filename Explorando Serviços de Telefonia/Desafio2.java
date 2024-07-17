import java.util.Scanner;

public class Main {

    // Função para verificar se o cliente contratou um combo completo
    public static String verificarComboCompleto(String[] servicosContratados) {
        // Variáveis para verificar a contratação de cada serviço
        boolean temMovel = false;
        boolean temBandaLarga = false;
        boolean temTV = false;

        // Iterar sobre os serviços contratados
        for (String servico : servicosContratados) {
            // Verificar qual serviço está sendo analisado e atualizar a variável correspondente
            String servicoTrim = servico.trim(); // Remove espaços em branco em volta do serviço
            if (servicoTrim.equalsIgnoreCase("movel")) {
                temMovel = true;
            } else if (servicoTrim.equalsIgnoreCase("banda larga")) {
                temBandaLarga = true;
            } else if (servicoTrim.equalsIgnoreCase("tv")) {
                temTV = true;
            }
        }

        // Verificar se todos os serviços foram contratados
        if (temMovel && temBandaLarga && temTV) {
            return "Combo Completo";
        } else {
            return "Combo Incompleto";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitando ao usuário a lista de serviços contratados
        System.out.println();
        String input = scanner.nextLine();

        // Convertendo a entrada em uma lista de strings
        String[] servicosContratados = input.split(",");

        // Verificando se o cliente contratou um combo completo
        String resultado = verificarComboCompleto(servicosContratados);

        // Exibindo o resultado
        System.out.println(resultado);

        // Fechando o scanner
        scanner.close();
    }
}

