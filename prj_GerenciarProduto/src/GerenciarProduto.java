import model.Categoria;
import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarProduto {

    private List<Produto> produtos;
    private List<Categoria> categorias;
    private Scanner sc;

    public GerenciarProduto() {
        this.produtos = new ArrayList<>();
        this.categorias = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        GerenciarProduto gerenciador = new GerenciarProduto();
        gerenciador.iniciarMenu();
    }

    private void iniciarMenu() {
        int opcao;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Cadastrar categoria");
            System.out.println("2. Cadastrar produto");
            System.out.println("3. Dar entrada no produto no estoque");
            System.out.println("4. Dar saída do produto do estoque");
            System.out.println("5. Mostrar o saldo disponível de todos os produtos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarCategoria();
                    break;
                case 2:
                    cadastrarProduto();
                    break;
                case 3:
                    darEntradaEstoque();
                    break;
                case 4:
                    darSaidaEstoque();
                    break;
                case 5:
                    mostrarSaldo();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarCategoria() {
        System.out.print("Digite o código da categoria: ");
        int codigoCategoria = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o nome da categoria: ");
        String nomeCategoria = sc.nextLine();

        Categoria categoria = new Categoria(codigoCategoria, nomeCategoria);
        categorias.add(categoria);

        System.out.println("Categoria cadastrada com sucesso!");
    }

    private void cadastrarProduto() {
        System.out.print("Digite o código do produto: ");
        int codigoProduto = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = sc.nextLine();
        System.out.print("Digite o preço do produto: ");
        double precoProduto = sc.nextDouble();
        sc.nextLine();
        System.out.print("Digite a quantidade em estoque do produto: ");
        int quantidadeProduto = sc.nextInt();
        sc.nextLine();

        // Mostrar categorias disponíveis
        System.out.println("\nCategorias disponíveis:");
        for (Categoria categoria : categorias) {
            System.out.println(categoria.getCodigoCategoria() + ". " + categoria.getNome());
        }
        System.out.print("Digite o código da categoria do produto: ");
        int codigoCategoria = sc.nextInt();

        Categoria categoriaProduto = null;
        for (Categoria categoria : categorias) {
            if (categoria.getCodigoCategoria() == codigoCategoria) {
                categoriaProduto = categoria;
                break;
            }
        }

        if (categoriaProduto != null) {
            Produto produto = new Produto(codigoProduto, nomeProduto, precoProduto, quantidadeProduto, categoriaProduto);
            produtos.add(produto);

            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Categoria não encontrada. Cadastre a categoria primeiro.");
        }
    }

    private void darEntradaEstoque() {
        System.out.print("Digite o código do produto: ");
        int codigoProduto = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha
        System.out.print("Digite a quantidade de entrada no estoque: ");
        int qtdEntrada = sc.nextInt();

        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigoProduto) {
                produto.entradaEstoque(qtdEntrada);
                System.out.println("Entrada de estoque realizada com sucesso!");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    private void darSaidaEstoque() {
        System.out.print("Digite o código do produto: ");
        int codigoProduto = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha
        System.out.print("Digite a quantidade de saída do estoque: ");
        int qtdSaida = sc.nextInt();

        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigoProduto) {
                produto.saidaEstoque(qtdSaida);
                System.out.println("Saída de estoque realizada com sucesso!");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    private void mostrarSaldo() {
        System.out.println("\nSaldo disponível de todos os produtos:");
        for (Produto produto : produtos) {
            System.out.println("Produto: " + produto.getNome() + ", Saldo: " + produto.getSaldo());
        }
    }
}
