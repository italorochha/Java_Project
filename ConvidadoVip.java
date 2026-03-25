public class ConvidadoVip extends Humano {
    private String tipoIngresso;

    public ConvidadoVip(String nome, int idade, String tipoIngresso) {
        super(nome, idade);
        this.tipoIngresso = tipoIngresso;
    }
    @Override
    public String gerarResumo() {
        return "Nome: " + this.nome + "\nIdade: " + this.idade + " anos\nTipo de Ingresso: " + this.tipoIngresso;
    }
    public String getNome() { return this.nome; }
    public int getIdade() { return this.idade; }
    public String getTipoIngresso() { return this.tipoIngresso; }
}