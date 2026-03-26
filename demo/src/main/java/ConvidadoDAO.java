import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConvidadoDAO {
    public void salvarNoBanco(ConvidadoVip vip, String enderecoFormatado) {
        try {
            String urlBanco = "jdbc:sqlite:banco_vip.db";
            Connection conexao = DriverManager.getConnection(urlBanco);

            String sqlCriar = "CREATE TABLE IF NOT EXISTS convidados (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "nome TEXT NOT NULL, " + "idade INTEGER, " + "endereco TEXT, " + "tipoIngresso TEXT" + ");";
            conexao.createStatement().execute(sqlCriar);

            String sql = "INSERT INTO convidados (nome, idade, endereco, tipoIngresso) VALUES (?, ?, ?, ?)";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, vip.getNome());
            comando.setInt(2, vip.getIdade());
            comando.setString(3, enderecoFormatado);
            comando.setString(4, vip.getTipoIngresso());
            comando.executeUpdate();
            conexao.close();
        } catch (Exception erroBanco) {
            System.out.println(" Erro no Banco: " + erroBanco.getMessage());
        }
    }
    public void listarTodos() {
        try {
            String urlBanco = "jdbc:sqlite:banco_vip.db";
            Connection conexao = DriverManager.getConnection(urlBanco);
            String sql = "SELECT * FROM convidados";
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            System.out.println("\n--- 📋 LISTA DE CONVIDADOS VIP ---");
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int idade = resultado.getInt("idade");
                String ingresso = resultado.getString("tipoIngresso");
                System.out.println("ID: " + id + " | Nome: " + nome + " | Idade: " + idade + " | Ingresso: " + ingresso);
            }
            System.out.println("----------------------------------\n");
            conexao.close();
        } catch (Exception erroBanco) {
            System.out.println(" Erro ao listar do Banco: " + erroBanco.getMessage());
        }
    }
    public void deletar(int id) {
        try {
            String urlBanco = "jdbc:sqlite:banco_vip.db";
            Connection conexao = DriverManager.getConnection(urlBanco);
            String sql = "DELETE FROM convidados WHERE id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            int linhasAfetadas = comando.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println(" VIP com ID " + id + " foi DELETADO com sucesso!");
            } else {
                System.out.println(" Alerta: Nenhum VIP foi encontrado com o ID " + id);
            }
            conexao.close();
        } catch (Exception erroBanco) {
            System.out.println(" Erro ao deletar do Banco: " + erroBanco.getMessage());
        }
    }
}
