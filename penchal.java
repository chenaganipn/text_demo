package jdbcassessment.sql;
import java.sql.*;

public class penchal {
    public static void main(String[] args) {
        try (

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "ebookshop","Narasimha@123"); 

                Statement stmt = conn.createStatement()
        ) {

            String strSelect = "select * from books";
            System.out.println("The SQL query is: " + strSelect);
            System.out.println();

            ResultSet rset = stmt.executeQuery(strSelect);
            String query="select * from books";


            System.out.println("The records selected are:");
            int rowCount = 0;
            while(rset.next()) {
                int    id   = rset.getInt("id");
                String title = rset.getString("title");
                String author = rset.getString("author");
                double price = rset.getDouble("price");
                int    qty   = rset.getInt("qty");
                System.out.println(id +"," + author +"," + title + ", " + price + ", " + qty);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);

        } catch(SQLException ex) {
            ex.printStackTrace();
        }

    }
}