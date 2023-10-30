import java.util.Scanner;

public class backup {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String user[] = {"kasir", "kasir"};
        String username, password;
        double jumlahUang, kembalian, totalBelanja = 0;
        String menu[] = {"kopi", "Teh", "Roti"};
        String harga[] = {"10000", "8000", "5000"};
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

                    if (user[0].equals(username) && user[1].equals(password)) {
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

                            for (int i=0; i<menu.length; i++){

                                System.out.println("|  "+(i+1)+".  |   "+ menu[i]+"                |   Rp "+harga[i]+"  |");
                            }

                            System.out.println("==============================================");
                            System.out.println();
                            System.out.println("Ketik 4 jika proses pemesanan sudah selesai.");
                            if (roti != 0 || kopi != 0 || teh != 0) {
                                System.out.println("Ketik 5 jika ingin mengubah jumlah pesanan.");
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
                            System.out.print("Pilih menu (1/2/3/4/5): ");
                            pilihan = input.nextInt();

                            System.out.println();

                            if (pilihan == 1) {
                                System.out.print("Masukkan jumlah yang dipesan :");
                                kopi += input.nextInt();
                                totalBelanja = kopi * 10000;
                                System.out.println();

                            } else if (pilihan == 2) {
                                System.out.print("Masukkan jumlah yang dipesan :");
                                teh += input.nextInt();
                                totalBelanja = teh * 8000;
                                System.out.println();

                            } else if (pilihan == 3) {
                                System.out.print("Masukkan jumlah yang dipesan :");
                                roti += input.nextInt();
                                totalBelanja = roti * 5000;
                                System.out.println();

                            } else if (pilihan == 4) {
                                break;
                            }else if (pilihan == 5) {
                                System.out.println();
                                System.out.println("Pilih menu yang ingin anda ubah.");
                                System.out.println();
                                System.out.println("1. Kopi : " + kopi);
                                System.out.println("2. Teh : " + teh);
                                System.out.println("3. Roti : " + roti);
                                System.out.println();
                                System.out.println("Pilih salah satu (1/2/3): ");
                                pilihan = input.nextInt();

                                if (pilihan == 1) {
                                    System.out.print("Masukkan jumlah terbaru:");
                                    totalBelanja = totalBelanja - (kopi * 10000);
                                    kopi = input.nextInt();
                                    System.out.println();
                                    totalBelanja = totalBelanja + (kopi * 10000);
                                    System.out.println("Data berhasil diubah !");
                                    System.out.println();
                                    System.out.println("Kopi : " + kopi);
                                    System.out.println();
                                } else if (pilihan == 2) {
                                    System.out.print("Masukkan jumlah terbaru :");
                                    totalBelanja = totalBelanja - (teh * 8000);
                                    teh = input.nextInt();
                                    totalBelanja = totalBelanja + (teh * 8000);
                                    System.out.println();
                                    System.out.println("Data berhasil diubah !");
                                    System.out.println();
                                    System.out.println("Kopi : " + kopi);
                                    System.out.println();
                                } else if (pilihan == 3) {
                                    System.out.println();
                                    System.out.print("Masukkan jumlah terbaru:");
                                    totalBelanja = totalBelanja - (roti * 5000);
                                    roti = input.nextInt();
                                    totalBelanja = totalBelanja + (roti * 5000);
                                    System.out.println();
                                    System.out.println("Data berhasil diubah !");
                                    System.out.println();
                                    System.out.println("Roti : " + roti);
                                    System.out.println();
                                }

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
                            System.out.println("--------------------------------------------------------");
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