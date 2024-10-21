package model;
public class Admin {
    private int id_admin;
    private String nomeCompleto;
    private String email;
    private String senha;

    public Admin(int id, String nomeCompleto, String email, String senha ) {
        this.id_admin = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
    }
    public String toString() {
        return "\nid_admin: " + this.id_admin +
                "\nnomeCompleto: " + this.nomeCompleto +
                "\nemail: " + this.email +
                "\nsenha: " + this.senha;
    }

    // Getters
    public int getId_admin() {
        return this.id_admin;
    }
    public String getNomeCompleto() {
        return this.nomeCompleto;
    }
    public String getEmail() {
        return this.email;
    }
    public String getSenha() {
        return this.senha;
    }

}
