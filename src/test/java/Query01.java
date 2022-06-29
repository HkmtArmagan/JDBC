import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1) Driver yükle
        Class.forName("com.mysql.jdbc.Driver");

        // 2) Bağlantı olustur
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC","root","171191");
        //  okul : bağlantı yapacagımız database'in ismi

        // 3) Statement : SQL kodlarımızı yazmak icin bir nesne olustur
        Statement st = con.createStatement();

        // 4) ResultSet :
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        // Sonucları al
        while (veri.next()){

            /*        index kullanarak yaptık
            System.out.println(veri.getInt(1) + " " + veri.getString(2) + " " +
                    veri.getString(3) + " " + veri.getString(4)); */


            /*      sütun ismi kullanarak yaptık
            System.out.println(veri.getInt("okul_no") + " " +
                    veri.getString("ogrenci_ismi") + " " +
                    veri.getString("sinif") + " " +
                    veri.getString("cinsiyet"));     */

            // printf ile konsola güzelce yazdırıldı
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1), veri.getString(2),
                                                       veri.getString(3), veri.getString(4));

        }
        // 6) Kapatma
        con.close();
        st.close();
        veri.close();

    }
}
