import java.util.Scanner;
import java.sql.*;




public class Program {
    static Connection conn;
    
    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner (System.in)) {
            String inputanPengguna;
            boolean isLanjutkan = true;
            String url = "jdbc:mysql://localhost:3306/kios";
            //exception
            try{
                Tagihan tagihan = new Tagihan();
                Class.forName("com.mysql.jdbc.Driver");
                conn =DriverManager.getConnection(url,"root","");
                System.out.println("\nKONEKSI KE DATABASE SUDAH BERHASIL");
                while (isLanjutkan){ //perulangan while
                    // string replace kalimat
                    String sapa="hai";
                    String ubahkalimat = sapa.replace("hai", "\nSelamat datang :)\n");
                    System.out.println(ubahkalimat);

                        tagihan.timedate();
                        System.out.println("===PROGRAM TAGIHAN PELANGGAN===");
                        System.out.println("Pilihan Menu");
                        System.out.println("1. Lihat Data Pelanggan");
                        System.out.println("2. Tambah Data Pelanggan");
                        System.out.println("3. Ubah Data Pelanggan");
                        System.out.println("4. Hapus Data Pelanggan");
                        System.out.println("5. Cari Data Pelanggan");

                        System.out.print("\nSILAHKAN PILIH MENU 1/2/3/4/5: ");
                        inputanPengguna = input.next();
                        //percabangan switch
                        switch(inputanPengguna) {
                            case "1":
                            tagihan.tampil();
                            break;
                        case "2":
                            tagihan.tambah();
                            break;
                        case "3":
                            tagihan.ubah();
                            break;
                        case "4":
                            tagihan.hapus();
                            break;
                        case "5":
                            tagihan.cari();
                            break;
                        default:
                            System.err.println("\nMOHON INPUT DENGAN BENAR!(1-5)");
                        }

                        System.out.print("\nMasih Ingin Menggunakan Program? [y/t] ");
                        inputanPengguna = input.next();
                        isLanjutkan = inputanPengguna.equalsIgnoreCase("y");

                }

            }
            catch(ClassNotFoundException ex) {
                System.err.println("DRIVER ERROR");
                System.exit(0);
            
   }
   catch (Exception e) {
            System.err.println("KONEKSI KE DATABASE GAGAL" +e.getMessage());
}
finally{
   Penutup close = new Penutup("TERIMA KASIH","SAMPAI JUMPA KEMBALI");
   System.out.println(close.thanks);
   System.out.println(close.bye);
   System.out.println("PROGRAM SELESAI");
}
        }
}
}