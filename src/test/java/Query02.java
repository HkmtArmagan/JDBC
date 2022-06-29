import java.sql.*;

public class Query02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC","root","171191");

        Statement st = con.createStatement();

        // SORU01: ÖĞRENCİLER TABLOSUNDAKİ ERKEK ÖĞRENCİ BİLGİLERİ GETİRİN

        ResultSet veri1 = st.executeQuery("select * from ogrenciler where cinsiyet = 'E'");

        while (veri1.next()){

           /*     System.out.println(veri1.getInt(1)+veri1.getString(2)
                    +veri1.getString(3)+veri1.getString(4));  */

            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri1.getInt(1),
                    veri1.getString(2), veri1.getString(3), veri1.getString(4));
        }

        System.out.println("================================================================================");
        // SORU02: ÖĞRENCİLER TABLOSUNDAKİ  9 SINIF KIZ ÖĞRENCİ BİLGİLERİ GETİRİN

        ResultSet veri2 = st.executeQuery("select * from ogrenciler where sinif = 9 and cinsiyet = 'k'");

        while (veri2.next()){
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri2.getInt(1),
                    veri2.getString(2), veri2.getString(3), veri2.getString(4));
        }
        con.close();
        st.close();
        veri1.close();
        veri2.close();
    }
}

