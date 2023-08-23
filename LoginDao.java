
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao 
{
  public static ResultSet getData(String userName , String password) throws ClassNotFoundException, SQLException
  {
    String url="jdbc:mysql://localhost:3306/madam";
    String user="root";
    String pass="root";
    String query="select * from RegisterTab where userName=? and password=?";
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection(url, user, pass);
    PreparedStatement pst=con.prepareStatement(query);
    pst.setString(1,userName);
    pst.setString(2, password);
    ResultSet rs=pst.executeQuery();
    return rs;
  }
}
