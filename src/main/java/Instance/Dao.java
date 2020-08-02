package Instance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.ArrayList;

public interface Dao <T extends Vo> {

    public static final String DB_USER = "tibero";
    public static final String DB_PASSWORD = "tmax";
    public static final String DB_URL = "jdbc:tibero:thin:@localhost:8629:tibero";
    public static final String DB_DRIVER_CLASS = "com.tmax.tibero.jdbc.TbDriver";

    default Connection openConnection() throws Exception {
        Class.forName(DB_DRIVER_CLASS);
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

    }

    default void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if(con != null) { con.close(); }
            if(ps != null) { ps.close(); }
            if(rs != null) { rs.close(); }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
