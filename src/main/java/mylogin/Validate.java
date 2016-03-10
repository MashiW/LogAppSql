package mylogin;

import java.sql.*;

public class Validate {
    /**
     * @param name = name which enter by the user
     * @param pass = password which enter by the user
     * @return
     */
    public static boolean validateLog(String name, String pass) {
        /**
         * validating the username and paassword enter by the user
         */
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/db_test"; //url for the selected database
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root"; //user name for database
        String password = "root"; //password foe database
        try {

            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, password);

            // sql query for extracting username and  password from the database
            //password is encrypted by MD5
            String query = "select usrName, usrPass from tbl_user where usrName=\"" + name + "\" and usrPass=md5(\"" + pass + "\");";

            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(query);
            status = rst.first();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
}