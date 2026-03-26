import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaCadastro {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Sistema VIP Ultimate - Arquitetura MVC");
        janela.setSize(500, 500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(null);

        JLabel rotuloNome = new JLabel("Nome do VIP:");
        rotuloNome.setBounds(20, 20, 200, 30);
        JTextField campoNome = new JTextField();
        campoNome.setBounds(20, 50, 250, 30);

        JLabel rotuloIdade = new JLabel("Idade:");
        rotuloIdade.setBounds(20, 90, 200, 30);
        JTextField campoIdade = new JTextField();
        campoIdade.setBounds(20, 120, 100, 30);

        JLabel rotuloCEP = new JLabel("CEP (Somente números):");
        rotuloCEP.setBounds(20, 160, 200, 30);
        JTextField campoCEP = new JTextField();
        campoCEP.setBounds(20, 190, 150, 30);

        JLabel TipoIngresso = new JLabel("Tipo de Ingresso:");
        TipoIngresso.setBounds(20, 230, 200, 30);
        JTextField campoTipoIngresso = new JTextField();
        campoTipoIngresso.setBounds(20, 260, 150, 30);

        JButton botaoAdicionar = new JButton("Salvar no Banco");
        botaoAdicionar.setBounds(20, 300, 150, 40);
        JButton botaoListar = new JButton("Listar no Terminal");
        botaoListar.setBounds(180, 300, 150, 40);
        JButton botaoDeletar = new JButton("Deletar VIP");
        botaoDeletar.setBounds(340, 300, 130, 40);

        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String idadeString = campoIdade.getText();
                String cep = campoCEP.getText();
                String tipoIngresso = campoTipoIngresso.getText();
                int idadeConvertida = Integer.parseInt(idadeString);

                ConvidadoVip vip = new ConvidadoVip(nome, idadeConvertida, tipoIngresso);

                String enderecoFormatado = "Endereço não encontrado";
                try {
                    String url = "https://viacep.com.br/ws/" + cep + "/json/";
                    HttpClient cliente = HttpClient.newHttpClient();
                    HttpRequest pedido = HttpRequest.newBuilder().uri(URI.create(url)).build();
                    HttpResponse<String> bandeja = cliente.send(pedido, HttpResponse.BodyHandlers.ofString());
                    String json = bandeja.body();
                    String rua = json.split("\"logradouro\": \"")[1].split("\"")[0];
                    String bairro = json.split("\"bairro\": \"")[1].split("\"")[0];
                    String uf = json.split("\"uf\": \"")[1].split("\"")[0];
                    enderecoFormatado = rua + " (" + bairro + " - " + uf + ")";
                } catch (Exception erroInternet) {
                    System.out.println("Erro de conexão ou CEP inválido.");
                }

                ConvidadoDAO dao = new ConvidadoDAO();
                dao.salvarNoBanco(vip, enderecoFormatado);

                var mensagemFinal = " Salvo no SQLite com Sucesso!\n\n" + vip.gerarResumo() + "\nEndereço: " + enderecoFormatado;
                JOptionPane.showMessageDialog(null, mensagemFinal);

                campoNome.setText("");
                campoIdade.setText("");
                campoCEP.setText("");
                campoTipoIngresso.setText("");
            }
        });

        botaoListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConvidadoDAO dao = new ConvidadoDAO();
                dao.listarTodos();
            }
        });
        botaoDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idDigitado = JOptionPane.showInputDialog(null, "Digite o ID do VIP que deseja apagar:");
                if (idDigitado != null && !idDigitado.isEmpty()) {
                    int idParaApagar = Integer.parseInt(idDigitado);
                    ConvidadoDAO dao = new ConvidadoDAO();
                    dao.deletar(idParaApagar);

                    JOptionPane.showMessageDialog(null, "Comando de exclusão executado para o ID: " + idParaApagar + ".\nOlhe o terminal para confirmar!");
                }
            }
        });

        janela.add(rotuloNome); janela.add(campoNome);
        janela.add(rotuloIdade); janela.add(campoIdade);
        janela.add(rotuloCEP); janela.add(campoCEP);
        janela.add(TipoIngresso); janela.add(campoTipoIngresso);
        janela.add(botaoAdicionar);
        janela.add(botaoListar);
        janela.add(botaoDeletar);
        janela.setVisible(true);
    }
}