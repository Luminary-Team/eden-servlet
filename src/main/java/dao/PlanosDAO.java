package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanosDAO {
    private Conexao conexao;

    public PlanosDAO(){
        this.conexao = new Conexao();
    }

    public ResultSet getPlanos(){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM BOOST_PLAN");
            return conexao.pstmt.executeQuery();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }

    public boolean adicionarPlano(String name, String description, double price, int duration_days){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO INFORMATIVE(NAME, DESCRIPTION, PRICE, DURATION_DAYS) VALUES (?,?,?,?)");
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

    public ResultSet getId_plan(){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("select distinct id_paln from boost_plan order by 1 desc");
            return conexao.pstmt.executeQuery();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }


    // método para pegar apenas um admin utilizado na editarCategory
    public ResultSet getPlan(int id_plan) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM BOOST_PLAN WHERE ID_PLAN = ?");
            conexao.pstmt.setInt(1, id_plan);
            return conexao.pstmt.executeQuery();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
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
            conexao.pstmt = conexao.conn.prepareStatement("update informative_articles set name = ?, description = ?, price = ?, duration_days = ? where id_plan = ? ");
            conexao.pstmt.setString(1, name);
            conexao.pstmt.setString(2, description);
            conexao.pstmt.setDouble(3, price);
            conexao.pstmt.setInt(4, id_plan);

            return conexao.pstmt.executeUpdate() > 0;

        }catch (SQLException sqe){
            sqe.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }
}
