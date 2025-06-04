package src.control;

   import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Funcoes {

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/academia?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "1234"; 

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERRO: Driver MySQL não encontrado!");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.err.println("ERRO NA CONEXÃO:");
            throw new RuntimeException("Falha na conexão", e);
        }
    }
}
