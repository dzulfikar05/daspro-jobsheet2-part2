import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Selamat datang di Cafe JTI");
        double totalBelanja = 0;

        System.out.println("Menu:");
        System.out.println("1. Paket 10.000 (2 Roti Panggang + 1 Teh Hangat)");
        System.out.println("2. Paket 15.000 (5 Gorengan + 1 Kopi Hitam + 100gr Kacang Kulit)");
        System.out.println("3. Paket 20.000 (5 Roti Panggang + 2 Kopi Susu)");

        System.out.print("Pilih menu (1/2/3): ");
        int pilihan = input.nextInt();

        if (pilihan == 1) {
            totalBelanja += 10000;
            System.out.println("Anda memesan Paket 1. Total belanja Anda: Rp " + totalBelanja);
        } else if (pilihan == 2) {
            totalBelanja += 15000;
            System.out.println("Anda memesan Paket 2. Total belanja Anda: Rp " + totalBelanja);
        } else if (pilihan == 3) {
            totalBelanja += 20000;
            System.out.println("Anda memesan Paket 3. Total belanja Anda: Rp " + totalBelanja);
        } else {
            System.out.println("Pilihan tidak valid. Silakan pilih menu yang tersedia.");
        }

        System.out.print("Masukkan jumlah uang yang diberikan: ");
        double jumlahUang = input.nextDouble();

        if (jumlahUang >= totalBelanja) {
            double kembalian = jumlahUang - totalBelanja;
            System.out.println("Terima kasih! Kembalian Anda: Rp " + kembalian);
        } else {
            System.out.println("Maaf, uang yang diberikan kurang. Transaksi dibatalkan.");
        }

        input.close();
    }
}