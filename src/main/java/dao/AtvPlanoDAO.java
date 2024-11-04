package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AtvPlanoDAO {
    private Conexao conexao;
    //    Ligando a classe com o banco
    public AtvPlanoDAO(){
        this.conexao = new Conexao();
    }

//    Dando select na tabela de planos ativos para mostrar na JSP
    public ResultSet getAtvPlanos() {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement(
                    "select a.id_activate_plan, p.name, u.full_name, pl.name as plan_name, a.activation_date, a.deactivation_date, a.active_status from activate_plan a join public.\"user\" u on a.user_id = u.id_user join products p on a.product_id = p.id_product join boost_plan pl on a.plan_id = pl.id_plan order by 1;");
            return conexao.pstmt.executeQuery();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }

//    Editando status do plano ativo
    public boolean editarAtvPlan(int id, boolean status){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE ACTIVATE_PLAN SET ACTIVE_STATUS = ? WHERE ID_ACTIVATE_PLAN = ?");
            conexao.pstmt.setBoolean(1, status);
            conexao.pstmt.setInt(2, id);
            return conexao.pstmt.executeUpdate() > 0;
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return status;
        }finally {
            conexao.desconectar();
        }
    }
}
