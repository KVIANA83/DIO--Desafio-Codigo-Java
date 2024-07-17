import java.util.Scanner;

public class CalculadoraCredito {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Processa múltiplos casos de teste
        while (scanner.hasNextLine()) {
            // Lê o número de ligações
            int n = Integer.parseInt(scanner.nextLine().trim());
            double totalCredito = 0.0;

            // Processa cada ligação
            for (int i = 0; i < n; i++) {
                String[] dadosLigacao = scanner.nextLine().trim().split(",");
                int duracao = Integer.parseInt(dadosLigacao[0].trim());
                String tipoLigacao = dadosLigacao[1].trim();
                double valorPorMinuto = Double.parseDouble(dadosLigacao[2].trim());

                // Calcula o custo da ligação
                double custoLigacao = duracao * valorPorMinuto;
                
                // Aplica regras adicionais de custo por tipo de ligação, se necessário
                if (tipoLigacao.equals("")) {
                    // Exemplo de regra adicional: 10% de desconto para ligações locais
                    custoLigacao *= 0.90; // Aplica desconto de 10%
                } else if (tipoLigacao.equals("")) {
                    // Exemplo de regra adicional: custo adicional para ligações de longa distância
                    custoLigacao += 5.0; // Adiciona um custo fixo de 5 unidades
                }

                // Adiciona ao total do crédito
                totalCredito += custoLigacao;
            }

            // Formata o resultado com duas casas decimais e imprime
            System.out.printf("%.2f%n", totalCredito);
        }

        scanner.close();
    }
}

