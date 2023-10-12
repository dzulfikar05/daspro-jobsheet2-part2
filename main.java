import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username, password, user = "kasir", pass = "kasir";
        double jumlahUang, kembalian, totalBelanja = 0;
        int pilihan;

        System.out.println("=============================");
        System.out.println("| Selamat datang di Cafe JTI |");
        System.out.println("=============================");
        while (true) {
            System.out.println("");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.println();
            System.out.print("Pilih salah satu (1/2) : ");
            pilihan = input.nextInt();
            System.out.println();
            switch (pilihan) {
                case 1:
                    System.out.println("====================================================");
                    System.out.println();
                    System.out.println("========");
                    System.out.println("| LOGIN |");
                    System.out.println("========");
                    System.out.println();
                    input.nextLine();
                    System.out.print("Masukkan username anda :");
                    username = input.nextLine();
                    System.out.print("Masukkan password anda :");
                    password = input.nextLine();

                    if (user.equals(username) && pass.equals(password)) {
                        System.out.println();
                        System.out.println("Login Berhasil !");
                        System.out.println();
                        while (true) {
                            System.out.println("====================================================");
                            System.out.println();
                            System.out.println("=======");
                            System.out.println("| Menu |");
                            System.out.println("=======");
                            System.out.println();
                            System.out.println("==============================================");
                            System.out.println("|  No  |   Makanan & Minuman   |     Harga    |");
                            System.out.println("==============================================");
                            System.out.println("|  1.  |   Kopi                |   Rp 10,000  |");
                            System.out.println("|  2.  |   Teh                 |   Rp  8,000  |");
                            System.out.println("|  3.  |   Roti                |   Rp  5,000  |");
                            System.out.println("==============================================");
                            System.out.println();
                            System.out.println("Ketik 4 jika anda sudah selesai memesan.");
                            System.out.println();
                            if (totalBelanja != 0){
                                System.out.println("Total belanja Anda: Rp " + totalBelanja);
                            }
                            System.out.println();
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
                        }
                        System.out.println("====================================================");
                        System.out.println();
                        System.out.println("=============");
                        System.out.println("| Pembayaran |");
                        System.out.println("=============");
                        System.out.println();
                        System.out.print("Masukkan jumlah uang yang diberikan: ");
                        jumlahUang = input.nextDouble();

                        if (jumlahUang >= totalBelanja) {
                            kembalian = jumlahUang - totalBelanja;
                            System.out.println();
                            System.out.println("====================================================");
                            System.out.println();
                            System.out.println("Pembayaran Berhasil !");
                            System.out.println();
                            System.out.println("Terima kasih! Kembalian Anda: Rp " + kembalian);
                            System.out.println();
                        } else {
                            System.out.println();
                            System.out.println("====================================================");
                            System.out.println();
                            System.out.println("Pembayaran Gagal !");
                            System.out.println();
                            System.out.println("Maaf, uang yang diberikan kurang. Transaksi dibatalkan.");
                            System.out.println();

                        }
                    } else {
                        System.out.println();
                        System.out.println("Login Gagal! Username atau Password Salah.");
                        break;
                    }
                case 2:
                    return;
                default:
                    System.out.println("Pilihan anda tidak tersedia.");
            }

        }
    }
}