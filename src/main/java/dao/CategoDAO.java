package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoDAO {
    private Conexao conexao;

    //    Ligando a classe com o banco
    public CategoDAO(){
        this.conexao = new Conexao();
    }

//    Select para mostrar todas as categorias e mandar para a JSP
    public ResultSet getCategorias(){
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM CATEGORIES order by 1");
            return conexao.pstmt.executeQuery();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }

//    Adicionando nova categoria no banco
    public boolean adicionarCategoria(String category, String description){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO CATEGORIES(category, description ) VALUES (?,?)");
            conexao.pstmt.setString(1,category);
            conexao.pstmt.setString(2,description);


            return conexao.pstmt.executeUpdate() > 0;

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }
    //    METODO PARA REMOVER O CATEGORIA
    public boolean removeCategory(int pk_id){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM CATEGORIES WHERE PK_ID = ?");
            conexao.pstmt.setInt(1, pk_id);
            return conexao.pstmt.executeUpdate() > 0;
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

//    METODO PARA EDITAR O CATEGORIA
    public boolean editarCategory(int pk_id, String category, String description){
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE CATEGORIES SET CATEGORY = ?, DESCRIPTION = ? WHERE PK_ID = ? ");
            conexao.pstmt.setString(1, category);
            conexao.pstmt.setString(2, description);
            conexao.pstmt.setInt(3, pk_id);

            return conexao.pstmt.executeUpdate() > 0;

        }catch (SQLException sqe){
            sqe.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

}
