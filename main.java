import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username, password, user = "kasir", pass = "kasir";
        double jumlahUang, kembalian, totalBelanja = 0;
        int pilihan, kopi = 0, teh = 0, roti = 0;

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
                            System.out.println("Ketik 4 jika proses pemesanan sudah selesai.");
                            if (roti != 0 || kopi != 0 || teh != 0) {
                                System.out.println();
                                System.out.println("Pesanan");
                            }
                            if (roti != 0) {
                                System.out.println("Roti : " + roti);
                            }
                            if (kopi != 0) {
                                System.out.println("Kopi : " + kopi);
                            }
                            if (teh != 0) {
                                System.out.println("Teh : " + teh);
                            }
                            if (totalBelanja != 0) {
                                System.out.println();
                                System.out.println("Total belanja Anda: Rp " + totalBelanja);
                            }
                            System.out.println();
                            System.out.print("Pilih menu (1/2/3/4): ");
                            pilihan = input.nextInt();

                            System.out.println();

                            if (pilihan == 1) {
                                System.out.print("Masukkan jumlah yang dipesan :");
                                kopi += input.nextInt();
                                totalBelanja += kopi * 10000;
                                System.out.println();

                            } else if (pilihan == 2) {
                                System.out.print("Masukkan jumlah yang dipesan :");
                                teh += input.nextInt();
                                totalBelanja += teh * 8000;
                                System.out.println();

                            } else if (pilihan == 3) {
                                System.out.print("Masukkan jumlah yang dipesan :");
                                roti += input.nextInt();
                                totalBelanja += roti * 5000;
                                System.out.println();

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
                        System.out.println("Jumlah uang yang harus anda bayarkan adalah sebesar Rp " + totalBelanja);
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
                            System.out.println("========================================================");
                            System.out.println("|                        Kafe JTI                       |");
                            System.out.println("========================================================");
                            System.out.println("|     Pesanan          |     Jumlah    |    Sub Total   |");
                            System.out.println("========================================================");
                            if (kopi != 0) {
                                System.out.println("|     Kopi             |       "+kopi+"       |    "+kopi *10000+"   |");
                            }
                            if (teh != 0) {
                                System.out.println("|     Teh              |       "+teh+"       |    "+teh *8000+"   |");
                            }
                            if (roti != 0) {
                                System.out.println("|     Roti             |       "+roti+"       |    "+roti *5000+"   |");
                            }
                            System.out.println("========================================================");
                            System.out.println("|     Total                             |   "+totalBelanja+"    |");
                            System.out.println("|     Bayar                             |   "+jumlahUang+"    |");
                            System.out.println("|                                                      |");
                            System.out.println("|     Kembalian                         |   "+kembalian+"    |");
                            System.out.println("========================================================");
                           
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