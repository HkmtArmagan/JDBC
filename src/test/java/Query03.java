import java.sql.*;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "171191");

        Statement st = con.createStatement();

        // SORU1: Bölümler tablosundan tüm kayıtları listeleyiniz.

        ResultSet veri1 = st.executeQuery("select * from bolumler");

        while (veri1.next()) {
            System.out.printf("%-6d %-15.15s %-8s\n", veri1.getInt(1), veri1.getString(2), veri1.getString(3));
        }
        System.out.println("=============================================================================");
        // SORU2:SATIS ve MUHASEBE bolumlerinde calişan personelin isimlerini ve maaşlarını, maaş ters sıralı listeleyiniz.

        ResultSet veri2 = st.executeQuery("select personel_isim, maas from personel " +
                "where bolum_id in(10,30) order by maas desc");

        while (veri2.next()) {
            System.out.printf("%-15.15s %-6d\n",
                    veri2.getString(1),
                    veri2.getInt(2));
        }
        System.out.println("=============================================================================");
        // Soru3: Tüm bölümlerde çalışan personel isimlerini, bölüm isimlerini ve maaşlarını,bölüm ve maas sıralı listeleyiniz.
        // NOT: Çalışanı olamasa bile bölüm ismi gösterilmelidir.

        ResultSet veri3 = st.executeQuery("select bolum_isim, personel_isim, maas\n" +
                "from bolumler as B left join personel as p\n" +
                "on B.bolum_id = P.bolum_id\n" +
                "order by bolum_isim desc, P.maas;");
        while (veri3.next()) {
            System.out.printf("%-10s %-10s %6d\n", veri3.getString(1),
                    veri3.getString(2), veri3.getInt(3));
        }
        System.out.println("=============================================================================");
        // SORU4: Maaşı en yüksek 10 kişinin bolümünü, adını ve maaşını listeleyiniz.

        ResultSet veri4 = st.executeQuery("select p.personel_isim, b.bolum_isim, p.maas from bolumler b " +
                "left join personel p on b.bolum_id=p.bolum_id order by maas desc limit 10");

        while (veri4.next()) {
            System.out.printf("%-15.15s %-15.15s %-8s\n", veri4.getString(1),
                    veri4.getString(2), veri4.getInt(3));
        }
        con.close();
        st.close();
        veri1.close();
        veri2.close();
        veri3.close();
        veri4.close();
    }
}
