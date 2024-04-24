package latihan_crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {

    private String id, nama, alamat;
    private Connection CRUDkoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;

    public CRUD() {
        try {
            KoneksiMySQL connection = new KoneksiMySQL();
            CRUDkoneksi = connection.getKoneksi();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public ResultSet tampilData() {
        CRUDquery = "SELECT * FROM siswa";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (SQLException ex) {
            System.out.println("Gagal menampilkan data: " + ex);
        }
        return CRUDhasil;
    }

    public void simpanData(String id, String nama, String alamat) {
        CRUDquery = "INSERT INTO siswa VALUES(?,?,?)";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);
            CRUDpsmt.setString(2, nama);
            CRUDpsmt.setString(3, alamat);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (SQLException ex) {
            System.out.println("Gagal menyimpan data: " + ex);
        }
    }

    public void ubahData(String id, String nama, String alamat) {
        CRUDquery = "UPDATE siswa SET nama=?, alamat=? WHERE id=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nama);
            CRUDpsmt.setString(2, alamat);
            CRUDpsmt.setString(3, id);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (SQLException ex) {
            System.out.println("Gagal mengubah data: " + ex);
        }
    }

    public void hapusData(String id) {
        CRUDquery = "DELETE FROM siswa WHERE id=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (SQLException ex) {
            System.out.println("Gagal menghapus data: " + ex);
        }
    }

}
