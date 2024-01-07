import java.util.Scanner;
import java.util.InputMismatchException;
import java.sql.*;
import java.util.HashMap; 


//class induk dan implement dari interface pembeli
public class DataPembeli implements Pembeli {
    //deklarasi
    static Connection conn;
    String url = "jdbc:mysql://localhost:3306/kios";
    String nama;
    int noAntrian;
    int noJenisPupuk;
    String jenisPupuk;
    int noJenisPelanggan;
    String jenisPelanggan;
    int biaya;
    double totalBiaya;
    int bayar;
    double kembalian;

    //constructor
    public DataPembeli(){
        
    }
	//bikin objek input
	Scanner input = new Scanner(System.in);

    //override method dari interface
    //database
    @Override
    public void tampil()throws SQLException{

    }
    //database
    @Override
    public void tambah()throws SQLException{
        System.out.println("==Input Data Pelanggan");

        try{
            //nama pelanggan
            System.out.println("Masukkan Nama Pelanggan: ");
            this.nama = input.nextLine();

            //no antrian
            int fail = 0;
            //exception
            do{
                try{
                    System.out.println("Inputkan no antrian pelanggan : ");
                    this.noAntrian = input.nextInt();
                    input.nextLine();
                    if(this.noAntrian < 1){
                        System.out.println("Data salah. Mohon masukkan data yang sesuai");
                    }
                }
                catch (Exception e){
                    fail +=1;
                    if(fail > 2){
                        System.out.println("Inputan salah. silahkan masukkan data yang sesuai");
                    } else {
                        System.out.println("Mohon inputkan angka");
                    }
                    input.nextLine();
                }
             } while (this.noAntrian < 1 ); // perulangan

            //jenis pupuk
            //exception
            do{
                try{
                    //COLLECTION HASHMAP
                    HashMap<String, String> jenisPupuk = new HashMap<String, String>();
                    jenisPupuk.put("1", "Padat");
                    jenisPupuk.put("2", "Cair");
                    System.out.println(jenisPupuk); 
                    System.out.println("Inputkan Jenis Pupuk  : ");
                    this.noJenisPupuk = input.nextInt();
                    input.nextLine();
                    if(this.noJenisPupuk<1 || this.noJenisPupuk>2)
                    {
                    System.out.println("Inputan harus berupa angka 1 atau 2");
                    }
                } catch (Exception e){
                    fail += 1;
                    if (fail > 2) {
                        System.out.println("Inputan salah, periksa inputan anda");
                        } else {
                        System.out.println("Mohon Inputkan berupa angka!");
                        }
                        input.nextLine();
                        }
                        } while (this.noJenisPupuk < 1 || this.noJenisPupuk > 2); //perulangan
                        if(this.noJenisPupuk == 1){
                            this.jenisPupuk = "Padat";
                        }
                        else if(this.noJenisPupuk == 2){
                            this.jenisPupuk = "Cair";
                        }

            //macam-macam pupuk
           //COLLECTION HASHMAP
           HashMap<String, String> daftarpupuk = new HashMap<String, String>();
           daftarpupuk.put("1", "Pupuk Petroganik");
           daftarpupuk.put("2", "Pupuk Takesa");
           daftarpupuk.put("3", "Pupuk Pronik");
           System.out.println(daftarpupuk); 
            //exception
            do{
                try{
                    System.out.println("Inputkan Jenis Pupuk : ");
                    this.noJenisPupuk = input.nextInt();
                    input.nextLine();
                    if(this.noJenisPupuk<1 || this.noJenisPupuk>3)
                    {
                    System.out.println("Inputan harus angka 1/2/3");
                    }
                } catch (Exception e){
                    fail += 1;
                    if (fail > 2) {
                        System.out.println("Mohon perhatikan lagi inputan");
                        } else {
                        System.out.println("Mohon Inputkan inputan berupa angka!");
                        }
                        input.nextLine();
                        }
                        } while (this.noJenisPupuk < 1 || this.noJenisPupuk > 3); //perulangan
                        if(this.noJenisPupuk == 1){
                            this.jenisPupuk = "Pupuk Petroganik";
                        }
                        else if(this.noJenisPupuk == 2){
                            this.jenisPupuk = "Pupuk Takesa";
                        }
                        else if(noJenisPupuk == 3){
                            this.jenisPupuk = "Pupuk Pronik";
                        }

            //jenis pelanggan
            //exception
            do{
            try{
                //COLLECTION HASHMAP
                HashMap<String, String> daftarjenispelanggan = new HashMap<String, String>();
                    daftarjenispelanggan.put("1", "Umum");
                    daftarjenispelanggan.put("2", "Member");
                    System.out.println(daftarjenispelanggan); 

                System.out.println("Inputkan Jenis Pelanggan : ");
                this.noJenisPelanggan = input.nextInt();
                input.nextLine();
                if(this.noJenisPelanggan<1 || this.noJenisPelanggan>2)
                {
                System.out.println("Inputan harus angka 1/2 ");
                }
            } catch (Exception e){
                fail += 1;
                //percabangan
                if (fail > 2) {
                    System.out.println("Mohon perhatikan lagi inputan");
                    } else {
                    System.out.println("Mohon Inputkan inputan berupa angka!");
                    }
                    input.nextLine();
                    }
                    } while (this.noJenisPelanggan < 1 || this.noJenisPelanggan > 2); //perulangan
                    //percabangan
                    if(this.noJenisPelanggan == 1){
                        this.jenisPelanggan = "Umum";
                    }
                    else if(this.noJenisPelanggan == 2){
                        this.jenisPelanggan = "Member";
                    }

            //biaya
            //percabangan switch
            switch(jenisPupuk){
                case "Pupuk Petroganik" : 
                this.biaya = 30000;
                System.out.println("Biaya Pembelian : " +this.biaya);
                break;
                case "Pupuk Takesa" :
                this.biaya = 50000;
                System.out.println("Biaya Pembelian : " +this.biaya);
                break;
                case "Pupuk Pronik" :
                this.biaya = 45000;
                System.out.println("Biaya Pembelian : " +this.biaya);
                break;
            }

            //tagihan
            //percabangan if else dan proses matematika
            if(noJenisPelanggan == 1){ //umum
                this.totalBiaya = this.biaya;
                System.out.println("Tagihan : " +this.totalBiaya);
            }
            else if (noJenisPelanggan == 2) {
                this.totalBiaya = 0.7 * this.biaya; // diskon 30 persen (member) proses matematika
                System.out.println("Tagihan : " +this.totalBiaya+ "(DISKON 30%)");
            }

            //bayar
            //exception
            do{
                try{
                    System.out.println("Inputkan Bayar : ");
                    bayar = input.nextInt();
                    input.nextLine();
                    if(bayar < totalBiaya){
                        System.out.println("Mohon Inputkan angka dengan baik dan benar");
                    }
                }
                catch (Exception e){
                    fail +=1;
                    if(fail > 2){
                        System.out.println("Mohon perhatikan lagi inputan");
                    } else {
                        System.out.println("Mohon inputkan angka");
                    }
                    input.nextLine();
                }
             } while (bayar < totalBiaya ); // perulangan

             //kembalian
             //proses matematika
                this.kembalian = this.bayar - totalBiaya;
                System.out.println("Kembalian = " +this.kembalian);
           
            
            
             //database
        String sql = "INSERT INTO tagihanpelanggan (nama,no_antrian,no_jenis_pupuk, jenis_pupuk, no_jenis_pelanggan, jenis_pelanggan, biaya, tagihan, bayar, kembalian) VALUES ('"+nama+"','"+noAntrian+"','"+noJenisPupuk+"','"+jenisPupuk+"','"+noJenisPelanggan+"','"+jenisPelanggan+"','"+biaya+"','"+totalBiaya+"','"+bayar+"','"+kembalian+"')";
       conn = DriverManager.getConnection(url, "root","");
       Statement statement = conn.createStatement();
       statement.execute(sql);
       System.out.println("DATA BERHASIL DIINPUT!");
   }
   catch (SQLException e) {
       System.err.println("DATA GAGAL DIINPUT");
       System.out.println(e.getMessage());
   }
   catch (InputMismatchException e) {
       System.err.println("Inputan harus berupa angka");
            
        }
    }
    
    //database
    @Override
    public void ubah()throws SQLException{
        
    }
    //database
    @Override
    public void hapus()throws SQLException{
        
    }
    //database
    @Override
    public void cari()throws SQLException{
        
    }
    public static Connection getCon() {
        return conn;
    }
    public static void setCon(Connection con) {
        DataPembeli.conn = con;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getNoAntrian() {
        return noAntrian;
    }
    public void setNoAntrian(int noAntrian) {
        this.noAntrian = noAntrian;
    }
    public int getNoJenisPupuk() {
        return noJenisPupuk;
    }
    public void setNoJenisPupuk(int noJenisPupuk) {
        this.noJenisPupuk = noJenisPupuk;
    }
    public String getJenisPupuk() {
        return jenisPupuk;
    }
    public void setJenisPupuk(String jenisPupuk) {
        this.jenisPupuk = jenisPupuk;
    }
    public int getNoJenisPelanggan() {
        return noJenisPelanggan;
    }
    public void setNoJenisPelanggan(int noJenisPelanggan) {
        this.noJenisPelanggan = noJenisPelanggan;
    }
    public String getJenisPelanggan() {
        return jenisPelanggan;
    }
    public void setJenisPelanggan(String jenisPelanggan) {
        this.jenisPelanggan = jenisPelanggan;
    }
    public int getBiaya() {
        return biaya;
    }
    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }
    public double getTotalBiaya() {
        return totalBiaya;
    }
    public void setTotalBiaya(double totalBiaya) {
        this.totalBiaya = totalBiaya;
    }
    public int getBayar() {
        return bayar;
    }
    public void setBayar(int bayar) {
        this.bayar = bayar;
    }
    public double getKembalian() {
        return kembalian;
    }
    public void setKembalian(double kembalian) {
        this.kembalian = kembalian;
    }
    public Scanner getInput() {
        return input;
    }
    public void setInput(Scanner input) {
        this.input = input;
    }

}