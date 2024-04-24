package latihan_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiMySQL {

    private Connection connect;
    private final String driverName = "com.mysql.jdbc.Driver"; // Driver untuk koneksi ke MySQL

    private final String jdbc = "jdbc:mysql://";
    private final String host = "localhost:";
    private final String port = "3306/"; // Port MySQL
    private final String database = "latihan_crud"; // Nama database yang digunakan
    private final String url = jdbc + host + port + database;

    private final String username = "root"; // Username default MySQL
    private final String password = ""; // Password default MySQL

    public Connection getKoneksi() throws SQLException {
        if (connect == null) {
            try {
                Class.forName(driverName);
                System.out.println("Class driver ditemukan!");
                try {
                    connect = DriverManager.getConnection(url, username, password);
                    System.out.println("Koneksi database sukses!");
                } catch (SQLException ex) {
                    System.out.println("Koneksi database gagal: " + ex);
                    System.exit(0);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class driver tidak ditemukan, terjadi kesalahan pada: " + cnfe);
                System.exit(0);
            }
        }
        return connect;
    }
}
