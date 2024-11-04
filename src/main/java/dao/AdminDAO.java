package dao;

import Security.VerificationInfomation;
import model.Plan;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    private Conexao conexao;

//    Ligando a classe com o banco
    public AdminDAO() {
        this.conexao = new Conexao();
    }

//    Serve para verificar se existe um administrador para logar para a área restrita
    public String verificarAdmin(String email, String senha) {
        conexao.conectar();
        String nomeAdmin = null;

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT FULL_NAME FROM ADMINISTRATOR WHERE EMAIL = ? AND PASSWORD = ?");
            conexao.pstmt.setString(1, email);
            conexao.pstmt.setString(2, senha);
            conexao.rs = conexao.pstmt.executeQuery();
            if (conexao.rs.next()) {
                nomeAdmin = conexao.rs.getString("FULL_NAME");
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        } finally {
            conexao.desconectar();
        }

        return nomeAdmin;
    }

//    Pegando apenas o ID do administrador
    public ResultSet getId() {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("select distinct id_administrator from administrator order by 1");
            return conexao.pstmt.executeQuery();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }

//    Pegando todos os administradores para mostrar na JSP
    public ResultSet getAdms() {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM ADMINISTRATOR ORDER BY ID_ADMINISTRATOR");
            return conexao.pstmt.executeQuery();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }

//    Adicionando administradores no banco
    public boolean adicionarAdmin(String nomeCompleto, String email, String senha) {
        conexao.conectar();
        VerificationInfomation vef = new VerificationInfomation();
        try {
            if (vef.validarEmail(email) && vef.validarSenha(senha) && vef.validarNome(nomeCompleto)) {
                senha = vef.hashSenha(senha);  // Garante a senha codificada em SHA-256

                conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO ADMINISTRATOR(full_name, email, password) VALUES (?, ?, ?)");
                conexao.pstmt.setString(1, nomeCompleto);
                conexao.pstmt.setString(2, email);
                conexao.pstmt.setString(3, senha);

                return conexao.pstmt.executeUpdate() > 0;

            } else {
                System.out.println("Falha na validação de dados do administrador.");
                return false;
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

//    Método utilizado para editar a senha
    public ResultSet compararHash(int id){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("SELECT PASSWORD FROM ADMINISTRATOR WHERE ID_ADMINISTRATOR = ?");
            conexao.pstmt.setInt(1, id);
            return conexao.pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    //    METODO PARA EDITAR O ADMINISTRADOR
    public boolean editarAdmin(int id, String nomeCompleto, String email, String senha) {
        conexao.conectar();
        VerificationInfomation vef = new VerificationInfomation();
        String senhaBanco = null;
        try {
            ResultSet rs = compararHash(id);
//            MÉTODO PARA RACHAR SENHA
            while (rs.next()) {
                senhaBanco = rs.getString("PASSWORD");
            }
//            CASO A SENHA RECEBIDA SEJA IGUAL A SENHA DO BANCO, ELE DEIXA A SENHA NORMAL, CASO CONTRÁRIO, ELE FAZ O REGEX E DEPOIS FAZ O HASH DA SENHA
            if (senha.equals(senhaBanco)) {
                senha = senhaBanco;
            }else{
                if (vef.validarSenha(senha)) {
                    senha = vef.hashSenha(senha);
                }
            }
            conexao.pstmt = conexao.conn.prepareStatement("update administrator set full_name = ?, email = ?, password = ? where id_administrator = ? ");
            conexao.pstmt.setString(1, nomeCompleto);
            conexao.pstmt.setString(2, email);
            conexao.pstmt.setString(3, senha);
            conexao.pstmt.setInt(4, id);

            return conexao.pstmt.executeUpdate() > 0;
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }
    //    METODO PARA REMOVER O ADMINISTRADOR
    public boolean removeAdmin(int id) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM ADMINISTRATOR WHERE ID_ADMINISTRATOR = ?");
            conexao.pstmt.setInt(1, id);
            return conexao.pstmt.executeUpdate() > 0;
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }
}