
import java.util.Scanner;
import java.sql.*;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 

public class Tagihan extends DataPembeli {
    static Connection conn;
    String url = "jdbc:mysql://localhost:3306/kios";
    Scanner input = new Scanner(System.in);
    
    //date
    public void timedate(){
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy || HH:mm:ss");   
        String formattedDate = waktu.format(myFormatObj);
        System.out.println("Waktu : " + formattedDate);
    }

   
     //database
     @Override
     public void tampil() throws SQLException{
        System.out.println("\n==TAMPILAN INFO PELANGGAN==");
        String sql ="SELECT * FROM tagihanpelanggan";
        conn = DriverManager.getConnection(url,"root","");
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

        while(result.next()){
            System.out.print("\nNama Pelanggan\t : ");
            System.out.print(result.getString("nama"));
			System.out.print("\nNo Antrian: ");
            System.out.print(result.getInt("no_antrian"));
            System.out.print("\nNo Jenis Pupuk\t : ");
            System.out.print(result.getInt("no_jenis_pupuk"));
            System.out.print("\nJenis Pupuk\t : ");
            System.out.print(result.getString("jenis_pupuk"));
            System.out.print("\nNo Jenis Pelanggan\t : ");
            System.out.print(result.getInt("no_jenis_pelanggan"));
            System.out.print("\nJenis Pelanggan\t : ");
            System.out.print(result.getString("jenis_pelanggan"));
            System.out.print("\nBiaya\t\t : ");
            System.out.print(result.getInt("biaya"));
            System.out.print("\nTagihan\t\t : ");
            System.out.print(result.getDouble("tagihan"));
            System.out.print("\nBayar\t\t : ");
            System.out.print(result.getInt("bayar"));
            System.out.print("\nKembalian\t : ");
            System.out.print(result.getDouble("kembalian"));
            System.out.print("\n");
		}
     }

     //database
     @Override
    public void ubah()throws SQLException{
        System.out.println("==UPDATE DATA PELANGGAN==");
        try {
            tampil();
            System.out.print("\nMasukkan Nomor Antrian Pelanggan yang akan di ubah : ");
            Integer noAntrian = Integer.parseInt(input.nextLine());
            
            String sql = "SELECT * FROM tagihanpelanggan WHERE no_antrian = " +noAntrian;
            conn = DriverManager.getConnection(url, "root", "");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            if(result.next()){
                
                System.out.print("Nama baru ["+result.getString("nama")+"]\t: ");
                String nama = input.nextLine();
                   
                sql = "UPDATE tagihanpelanggan SET nama='"+nama+"' WHERE no_antrian='"+noAntrian+"'";
                //System.out.println(sql);

                if(statement.executeUpdate(sql) > 0){
                    System.out.println("Berhasil memperbaharui data Pelanggan ("+noAntrian+")");
                }
            } 
            statement.close();        
        } 
		catch (SQLException e) {
        	System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());
        }
	
    }
    //database
    @Override
    public void hapus()throws SQLException{
         System.out.println("==HAPUS DATA PELANGGAN==");
		
		try{
	        tampil();
            System.out.print("\nInput No Antrian Pelanggan : ");
            String keyword = input.nextLine();
	        
	        String sql = "DELETE FROM tagihanpelanggan WHERE no_antrian LIKE '%"+keyword+"%'";
	        conn = DriverManager.getConnection(url,"root","");
	        Statement statement = conn.createStatement();
	        //ResultSet result = statement.executeQuery(sql);
	        
	        if(statement.executeUpdate(sql) > 0){
	            System.out.println("Data Pelanggan Sudah Dihapus");
	        } 
	   }
		catch(SQLException e){
	        System.out.println("Penghapusan Data Gagal");
	    }
        catch(Exception e){
            System.out.println("Input data yang benar!");
        }
    }
    //database
    @Override
    public void cari()throws SQLException{
        System.out.println("==CARI DATA PELANGGAN==");
				
		System.out.print("Masukkan Nama Pelanggan yang ingin dilihat : ");    
		String keyword = input.nextLine();
		
		String sql = "SELECT * FROM tagihanpelanggan WHERE nama LIKE '%"+keyword+"%'";
		conn = DriverManager.getConnection(url,"root","");
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql); 
                
        while(result.next()){
            System.out.print("\nNama Pelanggan\t : ");
            System.out.print(result.getString("nama"));
			System.out.print("\nNomor Antrian: ");
            System.out.print(result.getInt("no_antrian"));
            System.out.print("\nNo Jenis Pupuk\t : ");
            System.out.print(result.getString("no_jenis_pupuk"));
            System.out.print("\nJenis Pupuk: ");
            System.out.print(result.getString("jenis_pupuk"));
            System.out.print("\nBiaya\t\t : ");
            System.out.print(result.getString("biaya"));
            System.out.print("\nTagihan\t\t : ");
            System.out.print(result.getDouble("tagihan"));
            System.out.print("\nBayar\t\t : ");
            System.out.print(result.getInt("bayar"));
            System.out.print("\nKembalian\t : ");
            System.out.print(result.getDouble("kembalian"));
            System.out.print("\n");
        } 
    }     
    
}