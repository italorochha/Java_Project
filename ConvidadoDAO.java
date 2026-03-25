import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
            System.out.println("❌ Erro no Banco: " + erroBanco.getMessage());
        }
    }
}
