import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Quiz quiz = new Quiz("Quiz de Conhecimentos Gerais");
        cadastrarPerguntas(quiz);

        System.out.println("=== " + quiz.getTitulo() + " ===");
        System.out.print("Quantos jogadores vao participar? ");
        int quantidadeJogadores = lerInteiro(scanner);

        for (int i = 1; i <= quantidadeJogadores; i++) {
            System.out.print("Nome do jogador " + i + ": ");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()) {
                nome = "Jogador " + i;
            }
            quiz.adicionarJogador(new Jogador(nome));
        }

        for (Jogador jogador : quiz.getJogadores()) {
            quiz.jogarRodada(jogador, scanner);
        }

        quiz.exibirRanking();
        scanner.close();
    }

    private static void cadastrarPerguntas(Quiz quiz) {
        quiz.adicionarPergunta(new Pergunta(
                "Qual selecao foi campea da Copa do Mundo de 2002?",
                Arrays.asList("Alemanha", "Brasil", "Franca", "Italia"),
                'B', 5));

        quiz.adicionarPergunta(new Pergunta(
                "Qual jogador e mundialmente conhecido pelo apelido 'CR7'?",
                Arrays.asList("Lionel Messi", "Neymar", "Cristiano Ronaldo", "Kylian Mbappe"),
                'C', 5));

        quiz.adicionarPergunta(new Pergunta(
                "Em qual pais foi realizada a Copa do Mundo de 2014?",
                Arrays.asList("Alemanha", "Brasil", "Africa do Sul", "Russia"),
                'B', 10));

        quiz.adicionarPergunta(new Pergunta(
                "Qual time venceu a final da Champions League de 2005 contra o Milan, ficando conhecida como 'Milagre de Istambul'?",
                Arrays.asList("AC Milan", "Liverpool", "Chelsea", "Real Madrid"),
                'B', 10));

        quiz.adicionarPergunta(new Pergunta(
                "Quem ganhou a Bola de Ouro no ano de 2000?",
                Arrays.asList("Zinedine Zidane", "Rivaldo", "Luis Figo", "Ronaldo Fenomeno"),
                'C', 15));

        quiz.adicionarPergunta(new Pergunta(
                "Qual selecao foi campea da Copa do Mundo de 2010, realizada na Africa do Sul?",
                Arrays.asList("Holanda", "Alemanha", "Espanha", "Uruguai"),
                'C', 15));

        quiz.adicionarPergunta(new Pergunta(
                "Quem foi o artilheiro da Copa do Mundo de 2006, na Alemanha?",
                Arrays.asList("Ronaldo Fenomeno", "Miroslav Klose", "Thierry Henry", "Fernando Torres"),
                'B', 20));

        quiz.adicionarPergunta(new Pergunta(
                "Qual clube venceu a final da Champions League de 2019 contra o Tottenham?",
                Arrays.asList("Barcelona", "Liverpool", "Manchester City", "Ajax"),
                'B', 20));

        quiz.adicionarPergunta(new Pergunta(
                "Em que ano o Leicester City conquistou o inedito titulo da Premier League?",
                Arrays.asList("2014", "2015", "2016", "2017"),
                'C', 25));

        quiz.adicionarPergunta(new Pergunta(
                "Quem foi o artilheiro (Chuteira de Ouro) da Copa do Mundo de 2018, na Russia?",
                Arrays.asList("Kylian Mbappe", "Romelu Lukaku", "Harry Kane", "Cristiano Ronaldo"),
                'C', 25));
    }

    private static int lerInteiro(Scanner scanner) {
        while (true) {
            String linha = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(linha);
                if (valor > 0) {
                    return valor;
                }
            } catch (NumberFormatException e) {
            }
            System.out.print("Digite um numero valido: ");
        }
    }
}
