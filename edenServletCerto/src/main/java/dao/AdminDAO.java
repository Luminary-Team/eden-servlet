package dao;

import controller.Conexao;
import model.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AdminDAO {
    private Conexao conexao;
    public AdminDAO(){
        this.conexao = new Conexao();
    }
    public String verificarAdmin(String email, String senha){
        conexao.conectar();
        String nomeAdmin = null;

        try{
            conexao.pstmt = conexao.conn.prepareStatement("SELECT FULL_NAME FROM ADMINISTRATOR WHERE EMAIL = ? AND PASSWORD = ?");
            conexao.pstmt.setString(1, email);
            conexao.pstmt.setString(2, senha);
            conexao.rs = conexao.pstmt.executeQuery();
            if (conexao.rs.next()){
                nomeAdmin = conexao.rs.getString("FULL_NAME");
            } else {
                System.out.println("Nenhum resultado encontrado para o email e senha fornecidos.");
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        } finally {
            conexao.desconectar();
        }

        return nomeAdmin;
    }

    public ResultSet getId(){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("select distinct id_administrator from administrator order by 1 desc");
            return conexao.pstmt.executeQuery();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }

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

    // colocar objeto nos inserts
    public boolean adicionarAdmin(int id, String nomeCompleto, String email, String senha){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO ADMINISTRATOR VALUES (?,?,?,?)");
            conexao.pstmt.setInt(1, id);
            conexao.pstmt.setString(2, nomeCompleto);
            conexao.pstmt.setString(3, email);
            conexao.pstmt.setString(4, senha);

            return conexao.pstmt.executeUpdate() > 0;

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

    // método para pegar apenas um admin utilizado na editarAdmin
    public ResultSet getAdm(int id) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM ADMINISTRATOR WHERE ID_ADMINISTRATOR = ?");
            conexao.pstmt.setInt(1, id);
            return conexao.pstmt.executeQuery();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }

//    METODO PARA REMOVER O ADMINISTRADOR
    public boolean removeAdmin(int id){
        conexao.conectar();
        try{
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

//    METODO PARA EDITAR O ADMINISTRADOR

    public boolean editarAdmin(int id, String nome, String email, String senha){
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("update administrator set full_name = ?, email = ?, password = ? where id_administrator = ? ");
            conexao.pstmt.setString(1, nome);
            conexao.pstmt.setString(2, email);
            conexao.pstmt.setString(3, senha);
            conexao.pstmt.setInt(4, id);

            return conexao.pstmt.executeUpdate() > 0;

        }catch (SQLException sqe){
            sqe.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }
}
