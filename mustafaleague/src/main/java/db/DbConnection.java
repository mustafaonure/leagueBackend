package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
	private static final String user = "postgres";
	private static final String password = "1234";
	private static final String url = "jdbc:postgresql://localhost:5433/deneme";
	private static Connection connection;

	public static Connection getConnection() {
		
		try {
			if (connection == null || connection.isClosed()) {
				DriverManager.getConnection(url, user, password);
				connection = DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static int clearQuery() {
		String clearQuery = "delete from league";

		int affectedrows = 0;

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(clearQuery)) {

            affectedrows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedrows;
    }

}
