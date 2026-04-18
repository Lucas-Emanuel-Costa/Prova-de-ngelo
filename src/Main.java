import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner scanner = new Scanner(System.in)) {
            String nome = scanner.nextLine();
            double preco = scanner.nextDouble();
            int quantidadeInicial = scanner.nextInt();
            int quantidadeVendida = scanner.nextInt();

            Produto produto = new Produto(nome, preco, quantidadeInicial);
            OperacaoEstoque operacao = new VendaProduto();

            System.out.println("Produto: " + produto.getNome());
            System.out.printf("Preço: R$ %.2f%n", produto.getPreco());
            System.out.println("Estoque antes da venda: " + produto.getQuantidadeEmEstoque() + " unidades");

            boolean vendaRealizada = operacao.processar(produto, quantidadeVendida);

            if (vendaRealizada) {
                System.out.println("Venda realizada: " + quantidadeVendida + " unidades");
            } else {
                System.out.println("Estoque insuficiente para realizar a venda.");
            }

            System.out.println("Estoque atualizado: " + produto.getQuantidadeEmEstoque() + " unidades");
        }
    }
}
