import java.sql.*;

public class JDBClass {

    private Connection conn = null;
    // Creating the connection using username and password provided by the user
    public JDBClass(String username, String password) throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/devoir1?" +
                "user=" + username + "&password=" + password);
    }
    // Creating a sql statement and storing the result in a ResultSet called "result"
    public ResultSet createStatement(String stat) throws SQLException {
        Statement statement = conn.createStatement();
        String sql = stat;
        ResultSet result = statement.executeQuery(sql);
        return result;
    }

    // Printing the values of the columns caled "name" from the provided ResultSet
    public void printStatement(ResultSet res) throws SQLException {
        while(res.next()) {
            System.out.println(res.getString("name"));

        }
    }
    public static void main(String[] args) throws SQLException {

     JDBClass testClass = new JDBClass("root", "root");
     ResultSet res = testClass.createStatement("SELECT * FROM emp");
     testClass.printStatement(res);
    }
}
