package dao;
import java.sql.Connection;
import java.sql.DriverManager; // fazer a conexão com o banco de dados
import java.sql.PreparedStatement; // Executa as querys
import java.sql.ResultSet;
import java.sql.SQLException;


//Statement - Realiza/executa as querys

public class Conexao {
    public Connection conn;
    //    MANTER A CONEXÃO COM O BANCO DE DADOS
    public PreparedStatement pstmt;
    //    EXECUTAR O COMANDO SQL
    public ResultSet rs;

    public Connection conectar() {
        try {
//        INFORMAR QUAL DRIVER DE CONEXÃO SERÁ USADO PELO DRIVEMANAGER
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    System.getenv("DB_URL"), System.getenv("DB_USER"), System.getenv("DB_PASSWORD")
                    );
            return conn;
        } catch (SQLException seq) {
            seq.printStackTrace();
            return null;
        } catch (ClassNotFoundException cnte) {
            cnte.printStackTrace();
            return null;
        }
    }

    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}