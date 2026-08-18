import java.util.List;

public class Pergunta {

    private String enunciado;
    private List<String> alternativas;
    private char respostaCorreta;
    private int pontos;

    public Pergunta(String enunciado, List<String> alternativas, char respostaCorreta, int pontos) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.respostaCorreta = Character.toUpperCase(respostaCorreta);
        this.pontos = pontos;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<String> alternativas) {
        this.alternativas = alternativas;
    }

    public char getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(char respostaCorreta) {
        this.respostaCorreta = Character.toUpperCase(respostaCorreta);
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public boolean verificarResposta(char respostaDoJogador) {
        return Character.toUpperCase(respostaDoJogador) == this.respostaCorreta;
    }

    public void exibir() {
        System.out.println(enunciado);
        char letra = 'A';
        for (String alternativa : alternativas) {
            System.out.println("  " + letra + ") " + alternativa);
            letra++;
        }
    }

    @Override
    public String toString() {
        return "Pergunta{enunciado='" + enunciado + "', pontos=" + pontos + "}";
    }
}
