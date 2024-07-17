import java.util.Arrays;
import java.util.Scanner;

// Classe para representar um serviço contratado
class Servico {
    private double valor;

    public Servico(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}

// Classe para representar o combo de serviços
class ComboServicos {
    private Servico[] servicos;
    private double desconto1, desconto2, desconto3;
    private static final double DESCONTO_ADICIONAL = 20.00;

    public ComboServicos(Servico[] servicos, double[] descontos) {
        this.servicos = servicos;
        this.desconto1 = descontos[0];
        this.desconto2 = descontos[1];
        this.desconto3 = descontos[2];
    }

    // Método para calcular o valor total do combo com descontos
    public double calcularValorTotal() {
        // Conta quantos serviços foram contratados (com valor maior que 0)
        long servicosContratados = Arrays.stream(servicos)
                .filter(servico -> servico.getValor() > 0)
                .count();

        // Aplica o desconto correspondente à quantidade de serviços contratados
        double desconto = 0.0;
        if (servicosContratados == 1) {
            desconto = desconto1;
        } else if (servicosContratados == 2) {
            desconto = desconto2;
        } else if (servicosContratados == 3) {
            desconto = desconto3;
        }

        // Calcula o valor total com desconto
        double valorComDesconto = Arrays.stream(servicos)
                .mapToDouble(Servico::getValor)
                .sum() * (1 - desconto / 100);

        // Aplica desconto adicional se todos os três serviços foram contratados
        if (servicosContratados == 3) {
            valorComDesconto -= DESCONTO_ADICIONAL;
        }

        return valorComDesconto;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura da primeira linha de entrada
        String entrada1 = scanner.nextLine();

        // Leitura da segunda linha de entrada
        String entrada2 = scanner.nextLine();

        // Processamento das entradas
        double[] valoresServicos = Arrays.stream(entrada1.split(","))
                .mapToDouble(Double::parseDouble)
                .toArray();

        double[] descontos = Arrays.stream(entrada2.split(","))
                .mapToDouble(Double::parseDouble)
                .toArray();

        // Criando objetos Servico
        Servico[] servicos = new Servico[valoresServicos.length];
        for (int i = 0; i < valoresServicos.length; i++) {
            servicos[i] = new Servico(valoresServicos[i]);
        }

        // Criando o combo de serviços
        ComboServicos combo = new ComboServicos(servicos, descontos);

        // Calculando e imprimindo o valor total com desconto
        double valorTotal = combo.calcularValorTotal();
        System.out.printf("%.2f\n", valorTotal);

        scanner.close();
    }
}

