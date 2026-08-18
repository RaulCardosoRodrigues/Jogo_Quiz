public class Jogador {

    private String nome;
    private int pontuacao;
    private int acertos;
    private int erros;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.acertos = 0;
        this.erros = 0;
    }

    public Jogador(String nome, int pontuacaoInicial) {
        this.nome = nome;
        this.pontuacao = pontuacaoInicial;
        this.acertos = 0;
        this.erros = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getAcertos() {
        return acertos;
    }

    public int getErros() {
        return erros;
    }

    public void adicionarPontos(int pontos) {
        if (pontos > 0) {
            this.pontuacao += pontos;
        }
        this.acertos++;
    }

    public void registrarErro() {
        this.erros++;
    }

    public void resetar() {
        this.pontuacao = 0;
        this.acertos = 0;
        this.erros = 0;
    }

    @Override
    public String toString() {
        return nome + " - " + pontuacao + " pontos (" + acertos + " acertos / " + erros + " erros)";
    }
}
