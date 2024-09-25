import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexoes{
    private Connection conexao;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public boolean conectar(){
        try {
            //Informando qual driver é utilizado
            Class.forName("org.postgresql.Driver");

            //Criando a conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:postgresql://dpg-cqvm1flsvqrc73c5rshg-a.oregon-postgres.render.com:5432/edencrud", "edencrud_user", "9LF0xYsRgU6wmMdCtqYKJdrSvcU0ffqG");

        }catch (SQLException sel){
            sel.printStackTrace();
            return false;
        }catch (ClassNotFoundException cnt){
            cnt.printStackTrace();
            return false;
        }
        return true;
    }

    public void desconectar(){
        try {
            if (conexao != null && !conexao.isClosed()){
                conexao.close();
            }
        }catch (SQLException sqe){
            sqe.printStackTrace();
        }
    }

    public boolean inserir(int cod, String foto, String nome_perfil, String avaliacao, String senha, String telefone, String email, String nome_completo){

        try {

            pstmt = conexao.prepareStatement("INSERT INTO USUARIO VALUES ( ?, ?, ? , ?, ?, ?, ?, ?)");
            pstmt.setInt(1, cod);
            pstmt.setString(2, foto);
            pstmt.setString(3, nome_perfil);
            pstmt.setString(4, avaliacao);
            pstmt.setString(5, senha);
            pstmt.setString(6, telefone);
            pstmt.setString(7, email);
            pstmt.setString(8, nome_completo);

            return pstmt.executeUpdate() > 0;
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return false;
        }
        finally {
            desconectar();
        }
    }

    public boolean remover(int codigo){
        try {
            pstmt = conexao.prepareStatement("DELETE FROM USUARIO WHERE id_usuario = ?");
            pstmt.setInt(1, codigo);
            return pstmt.executeUpdate() > 0;
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return false;
        }finally {
            desconectar();
        }
    }


}
