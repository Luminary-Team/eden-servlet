public class Main {
    public static void main(String[] args) {
        // Instanciando objeto para fazer a conexao com o banco de dados

        Conexoes conec = new Conexoes();

//        Fazendo conexão com o banco
        if (conec.conectar()){
            System.out.println("Conexão feita com sucesso");
        }else {
            System.out.println("Não foi possivel conectar");
        }

//        Inserindo dados no banco
//        if (conec.inserir(1,"fotocopia", "leoLins", "Gosto muito de vender", "123456", "11986148320", "lins.leonardo@leo.com", "Leonardo Lins Furlanis")){
//            System.out.println("Dados inseridos no banco com sucesso");
//        }else {
//            System.out.println("Não foi possivel inserir nada ao banco de dados");
//        }

//        REMOVENDO DADOS NO BANCO
//        if (conec.remover(2)){
//            System.out.println("Removido com sucesso");
//        }else {
//            System.out.println("Não foi possivel remover");
//        }
    }
}