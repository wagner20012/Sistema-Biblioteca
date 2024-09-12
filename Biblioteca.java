package app;

import java.time.LocalDate;
import java.util.ArrayList;

// Classe Biblioteca para gerenciar os livros
class Biblioteca {
    private ArrayList<Livro> livros;  // Lista de livros na biblioteca

    // Construtor inicializa a lista de livros
    public Biblioteca() {
        livros = new ArrayList<>();
    }

    // Método para adicionar um novo livro à biblioteca
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    // Método para registrar um empréstimo de um livro pelo título
    public void registrarEmprestimo(String titulo, String nomeEmprestado, LocalDate dataDevolucao) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && !livro.isEmprestado()) {
                livro.registrarEmprestimo(nomeEmprestado, dataDevolucao);
                System.out.println("Empréstimo registrado com sucesso!");
                return;  // Finaliza a execução do método após o empréstimo
            }
        }
        // Mensagem caso o livro não seja encontrado ou já esteja emprestado
        System.out.println("Livro não encontrado ou já emprestado.");
    }

    // Método para verificar se um livro está disponível
    public void verificarDisponibilidade(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                if (livro.isEmprestado()) {
                    System.out.println("O livro \"" + titulo + "\" está emprestado.");
                } else {
                    System.out.println("O livro \"" + titulo + "\" está disponível.");
                }
                return;  // Finaliza a execução do método após encontrar o livro
            }
        }
        // Mensagem caso o livro não seja encontrado
        System.out.println("Livro não encontrado.");
    }

    // Método para listar todos os livros que estão emprestados
    public void listarLivrosEmprestados() {
        System.out.println("Livros emprestados:");
        for (Livro livro : livros) {
            if (livro.isEmprestado()) {
                livro.exibirDetalhes();
            }
        }
    }

    // Método para exibir todos os livros da biblioteca, emprestados ou não
    public void exibirTodosOsLivros() {
        System.out.println("Todos os livros na biblioteca:");
        for (Livro livro : livros) {
            livro.exibirDetalhes();
        }
    }
}

