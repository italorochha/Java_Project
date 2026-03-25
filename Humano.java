public class Humano {
    protected String nome;
    protected int idade;
    public Humano(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public String gerarResumo() {
        return " Sou apenas um humano. Nome: " + this.nome + ", Idade: " + this.idade;
    }
}