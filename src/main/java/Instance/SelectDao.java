package Instance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SelectDao implements Dao<Vo>{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private static SelectDao instance;

    private SelectDao() {
    }
    public static SelectDao getInstance() {
        if(instance == null) {
            instance = new SelectDao();
        }
        return instance;
    }

    public String SYSDATE() {
        String sql = "SELECT SYSDATE FROM dual";
        String sysdate = null;
        try {
            con = openConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            if(rs.next()) {
                sysdate = rs.getString("SYSDATE");
                System.out.println(sysdate);

            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return sysdate;

    }
}
