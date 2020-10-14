
package desktopead2020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DesktopEAD2020 {

    public static void main(String[] args) {
        // ============== Exemplo com postgres ==========================
        //String nomeDriver = "org.postgresql.Driver";
        //String localBancoDados = "jdbc:postgresql://localhost:5432/postgres";
        //String usuario = "postgres";
        //String senha = "admin";
        
        // ============== Exemplo com mysql/mariadb =======================
        String nomeDriver = "org.mariadb.jdbc.Driver";
        String localBancoDados = "jdbc:mariadb://localhost:3306/bancodados";
        String usuario = "root";
        String senha = "admin";

        Connection conexao = null;

        try {

            Class.forName(nomeDriver).newInstance();
            conexao = DriverManager.getConnection(localBancoDados, usuario, senha);

            if (conexao != null) {
                Statement st = conexao.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM alunos");

                while (rs.next()) {
                    System.out.println(rs.getString("codigo") + "   " + rs.getString("nome")+ "   " + rs.getString("endereco"));
                }

            } else {
                System.out.println("Problemas na conexão com o banco de dados!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
}
