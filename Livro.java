package app;

import java.time.LocalDate;

// Classe Livro para representar um livro na biblioteca
class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean emprestado;
    private String nomeEmprestado;
    private LocalDate dataDevolucao;

    // Construtor para inicializar os atributos do livro
    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.emprestado = false;  // Inicialmente, o livro não está emprestado
        this.nomeEmprestado = null;
        this.dataDevolucao = null;
    }

    // Métodos getter para acessar atributos do livro
    public String getTitulo() {
        return titulo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    // Método para registrar o empréstimo de um livro
    public void registrarEmprestimo(String nomeEmprestado, LocalDate dataDevolucao) {
        this.emprestado = true;  // Marca o livro como emprestado
        this.nomeEmprestado = nomeEmprestado;
        this.dataDevolucao = dataDevolucao;
    }

    // Método para devolver o livro, tornando-o disponível novamente
    public void devolverLivro() {
        this.emprestado = false;
        this.nomeEmprestado = null;
        this.dataDevolucao = null;
    }

    // Método para exibir os detalhes do livro, incluindo status de empréstimo
    public void exibirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de Publicação: " + anoPublicacao);
        if (emprestado) {
            System.out.println("Emprestado para: " + nomeEmprestado);
            System.out.println("Data de Devolução: " + dataDevolucao);
        } else {
            System.out.println("Disponível");
        }
        System.out.println();  // Linha em branco para organização visual
    }
}