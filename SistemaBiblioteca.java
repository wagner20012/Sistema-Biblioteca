package app;

import java.time.LocalDate;
import java.util.Scanner;

// Classe principal que contém o método main para executar o sistema
public class SistemaBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Objeto Scanner para entrada de dados
        Biblioteca biblioteca = new Biblioteca();  // Cria uma instância de Biblioteca

        // Adicionando alguns livros à biblioteca
        biblioteca.adicionarLivro(new Livro("Dom Quixote", "Miguel de Cervantes", 1605));
        biblioteca.adicionarLivro(new Livro("1984", "George Orwell", 1949));
        biblioteca.adicionarLivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954));

        // Coleta o nome do bibliotecário
        System.out.print("Digite seu nome para se identificar como bibliotecário: ");
        String nomeBibliotecario = scanner.nextLine();
        System.out.println("Bem-vindo(a), " + nomeBibliotecario + "!");

        int opcao;  // Variável para armazenar a escolha do menu
        do {
            // Exibe o menu de opções para o usuário
            System.out.println("\n1. Registrar empréstimo");
            System.out.println("2. Verificar disponibilidade de um livro");
            System.out.println("3. Listar livros emprestados");
            System.out.println("4. Exibir todos os livros");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha após o número

            // Processa a opção escolhida
            switch (opcao) {
                case 1:
                    // Registrar um empréstimo de livro
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o nome da pessoa que está pegando o livro emprestado: ");
                    String nomeEmprestado = scanner.nextLine();
                    System.out.print("Digite a data de devolução (AAAA-MM-DD): ");
                    LocalDate dataDevolucao = LocalDate.parse(scanner.nextLine());
                    biblioteca.registrarEmprestimo(titulo, nomeEmprestado, dataDevolucao);
                    break;
                case 2:
                    // Verificar a disponibilidade de um livro
                    System.out.print("Digite o título do livro: ");
                    titulo = scanner.nextLine();
                    biblioteca.verificarDisponibilidade(titulo);
                    break;
                case 3:
                    // Listar todos os livros emprestados
                    biblioteca.listarLivrosEmprestados();
                    break;
                case 4:
                    // Exibir todos os livros da biblioteca
                    biblioteca.exibirTodosOsLivros();
                    break;
                case 5:
                    // Finalizar o programa
                    System.out.println("Encerrando o sistema. Obrigado, " + nomeBibliotecario + "!");
                    break;
                default:
                    // Mensagem para opção inválida
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();  // Fecha o Scanner para evitar vazamento de recursos
    }
}