import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    private String titulo;
    private List<Pergunta> perguntas;
    private List<Jogador> jogadores;

    public Quiz(String titulo) {
        this.titulo = titulo;
        this.perguntas = new ArrayList<>();
        this.jogadores = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void adicionarPergunta(Pergunta pergunta) {
        this.perguntas.add(pergunta);
    }

    public void adicionarJogador(Jogador jogador) {
        this.jogadores.add(jogador);
    }

    public void jogarRodada(Jogador jogador, Scanner scanner) {
        System.out.println("\n===== Vez de: " + jogador.getNome() + " =====");

        for (int i = 0; i < perguntas.size(); i++) {
            Pergunta pergunta = perguntas.get(i);
            System.out.println("\nPergunta " + (i + 1) + " de " + perguntas.size()
                    + " (vale " + pergunta.getPontos() + " pontos)");
            pergunta.exibir();

            System.out.print("Sua resposta: ");
            String entrada = scanner.nextLine().trim();
            char resposta = entrada.isEmpty() ? ' ' : entrada.toUpperCase().charAt(0);

            if (pergunta.verificarResposta(resposta)) {
                System.out.println("Resposta correta!");
                jogador.adicionarPontos(pergunta.getPontos());
            } else {
                System.out.println("Resposta errada! A correta era: " + pergunta.getRespostaCorreta());
                jogador.registrarErro();
            }
        }

        System.out.println("\nFim da rodada de " + jogador.getNome()
                + " - Pontuacao total: " + jogador.getPontuacao());
    }

    public List<Jogador> gerarRanking() {
        List<Jogador> ranking = new ArrayList<>(jogadores);
        ranking.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());
        return ranking;
    }

    public void exibirRanking() {
        List<Jogador> ranking = gerarRanking();

        System.out.println("\n========== RANKING FINAL ==========");
        if (ranking.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
            return;
        }

        for (int i = 0; i < ranking.size(); i++) {
            Jogador jogador = ranking.get(i);
            String posicao = (i + 1) + "o";
            System.out.println(posicao + " lugar: " + jogador);
        }

        Jogador vencedor = ranking.get(0);
        System.out.println("\nVencedor: " + vencedor.getNome()
                + " com " + vencedor.getPontuacao() + " pontos!");
        System.out.println("====================================");
    }
}
