import java.util.Scanner;

public class mainv1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Selamat datang di Cafe JTI");
        double jumlahUang, kembalian, totalBelanja = 0;
        int pilihan;

        while (true) {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Kopi (Rp 10,000)");
            System.out.println("2. Teh (Rp 8,000)");
            System.out.println("3. Roti (Rp 5,000)");
            System.out.println("4. Selesai Memesan");

            System.out.print("Pilih menu (1/2/3/4): ");
            pilihan = input.nextInt();

            System.out.println();

            if (pilihan == 1) {
                totalBelanja += 10000;
            } else if (pilihan == 2) {
                totalBelanja += 8000;
            } else if (pilihan == 3) {
                totalBelanja += 5000;
            } else if (pilihan == 4) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih menu yang tersedia.");
            }

            System.out.println();
            System.out.println("Total belanja Anda: Rp " + totalBelanja);
        }

        System.out.print("Masukkan jumlah uang yang diberikan: ");
        jumlahUang = input.nextDouble();

        if (jumlahUang >= totalBelanja) {
            kembalian = jumlahUang - totalBelanja;
            System.out.println("Terima kasih! Kembalian Anda: Rp " + kembalian);
        } else {
            System.out.println("Maaf, uang yang diberikan kurang. Transaksi dibatalkan.");
        }

    }
}