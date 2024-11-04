package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanosDAO {
    private Conexao conexao;

    //    Ligando a classe com o banco
    public PlanosDAO(){
        this.conexao = new Conexao();
    }

//    Select para mostrar todos os planos e mostrar na JSP
    public ResultSet getPlanos(){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM BOOST_PLAN order by 1");
            return conexao.pstmt.executeQuery();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }

//    Adicionando plano no banco
    public boolean adicionarPlano(String name, String description, double price, int duration_days){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO BOOST_PLAN(NAME, DESCRIPTION, PRICE, DURATION_DAYS) VALUES (?,?,?,?)");
            conexao.pstmt.setString(1,name);
            conexao.pstmt.setString(2,description);
            conexao.pstmt.setDouble(3, price);
            conexao.pstmt.setInt(4,duration_days);

            return conexao.pstmt.executeUpdate() > 0;

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

    //    METODO PARA REMOVER O CATEGORIA
    public boolean removePlan(int id_plan){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM BOOST_PLAN WHERE ID_PLAN = ?");
            conexao.pstmt.setInt(1, id_plan);
            return conexao.pstmt.executeUpdate() > 0;
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

    //    METODO PARA EDITAR O CATEGORIA
    public boolean editarPlan(int id_plan, String name, String description, Double price, int duration_days){
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE BOOST_PLAN SET NAME = ?, DESCRIPTION = ?, PRICE = ?, DURATION_DAYS = ? WHERE ID_PLAN = ? ");
            conexao.pstmt.setString(1, name);
            conexao.pstmt.setString(2, description);
            conexao.pstmt.setDouble(3, price);
            conexao.pstmt.setInt(4, duration_days);
            conexao.pstmt.setInt(5, id_plan);

            return conexao.pstmt.executeUpdate() > 0;

        }catch (SQLException sqe){
            sqe.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }
}
