/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB1; // Nama package

/**
 * Program Sistem Keuangan Koperasi
 * Digunakan untuk mengelola transaksi keuangan koperasi seperti setor, tarik, dan cek saldo.
 * @author VivoBook
 */
public class KeuanganKoperasi { //nama class utama
    private String namaKoperasi;  
    private double totalSaldo;    
    private double sukuBunga;     
    private double biayaAdmin;    



    //method untuk menambah saldo/setor uang
    public void setor(double jumlah) {
        if (jumlah > 0) {
            totalSaldo += jumlah;
            System.out.println("Setoran sebesar Rp" + jumlah + " berhasil.");
            catatTransaksi("Setor");
        } else {
            System.out.println("Jumlah setoran harus lebih dari 0.");
        }
    }

    //method untuk menarik saldo/tarik uang
    public void tarik(double jumlah) {
        if (jumlah > 0 && totalSaldo >= (jumlah + biayaAdmin)) {
            totalSaldo -= (jumlah + biayaAdmin);
            System.out.println("Penarikan sebesar Rp" + jumlah + " berhasil. Biaya admin: Rp" + biayaAdmin);
            catatTransaksi("Tarik");
        } else {
            System.out.println("Saldo tidak mencukupi atau jumlah tidak valid.");
        }
    }

    //method untuk menghitung bunga yang akan ditambahkan ke saldo
    public void hitungBunga() {
        double bunga = (totalSaldo * sukuBunga) / 100;
        totalSaldo += bunga;
        System.out.println("Bunga sebesar Rp" + bunga + " telah ditambahkan ke saldo.");
    }

    //method untuk mengecek saldo saat ini
    public void cekSaldo() {
        System.out.println("Saldo saat ini di koperasi '" + namaKoperasi + "': Rp" + totalSaldo);
    }

    //method untuk mencatat transaksi/log transaksi
    private void catatTransaksi(String jenis) {
        System.out.println("Transaksi: " + jenis + " | Saldo saat ini: Rp" + totalSaldo);
    }

    //main method untuk menjalankan program
    public static void main(String[] args) {
        KeuanganKoperasi koperasi = new KeuanganKoperasi();
        koperasi.cekSaldo();

        koperasi.setor(500000);   
        koperasi.tarik(200000);   
        koperasi.hitungBunga();   

        //menampilkan saldo akhir
        koperasi.cekSaldo();
    }
}