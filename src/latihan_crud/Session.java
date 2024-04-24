package latihan_crud;

public class Session {

    private static String UserID, Nama, StatusLogin;

    public static void setUserID(String UserID) {
        Session.UserID = UserID;
    }

    public static String getUserID() {
        return UserID;
    }

    public static void setNama(String Nama) {
        Session.Nama = Nama;
    }

    public static String getNama() {
        return Nama;
    }

    public static void setStatusLogin(String StatusLogin) {
        Session.StatusLogin = StatusLogin;
    }

    public static String getStatusLogin() {
        return StatusLogin;
    }

}
