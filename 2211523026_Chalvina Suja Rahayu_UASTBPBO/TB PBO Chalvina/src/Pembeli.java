import java.sql.*;
//interface dan database
public interface Pembeli {
     public void  tampil()throws SQLException;
	 public void  tambah()throws SQLException;
	 public void  ubah()throws SQLException;
	 public void  hapus()throws SQLException;
	 public void  cari()throws SQLException;
}