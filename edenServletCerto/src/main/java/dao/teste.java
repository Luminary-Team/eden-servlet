package dao;

import model.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class teste {
    public static void main(String[] args) {
        AdminDAO ad = new AdminDAO();

        List<Admin> adminList = new ArrayList<>();

        try{
            ResultSet rs = ad.getAdms();
            while (rs.next()){
                int id = rs.getInt("ID_ADMINISTRATOR");
                String nome = rs.getString("FULL_NAME");
                String email = rs.getString("EMAIL");
                String senha = rs.getString("PASSWORD");
                adminList.add(new Admin(id, nome, email, senha));
            }
        }catch (SQLException sqe){
            sqe.printStackTrace();
            System.out.println("Erro ao carregar os admins");
        }

        System.out.println(adminList);
    }
}
