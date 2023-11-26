import java.util.Scanner;

public class main {
<<<<<<< HEAD
    static Scanner input = new Scanner(System.in);
    static String user = "kasir";
    static String pass = "kasir";
    static double totalBelanja = 0;
    static int kopi = 0, teh = 0, roti = 0;
=======
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String user[] = {"kasir", "kasir"};
        String username, password;
        double jumlahUang, kembalian, totalBelanja = 0;
        String menu[] = {"kopi", "Teh", "Roti"};
        String harga[] = {"10000", "8000", "5000"};
        int pilihan, kopi = 0, teh = 0, roti = 0;
>>>>>>> master

    public static void main(String[] args) {
        System.out.println("=============================");
        System.out.println("| Selamat datang di Cafe JTI |");
        System.out.println("=============================");

        while (true) {
            System.out.println("\n1. Login\n2. Exit");
            System.out.print("Pilih salah satu (1/2): ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
<<<<<<< HEAD
                    login();
                    break;
=======
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
>>>>>>> master
                case 2:
                    return;
                default:
                    System.out.println("\nPilihan anda tidak tersedia.");
            }
        }
    }

    static void login() {
        System.out.println("\n====================================================");
        System.out.println("\n========\n| LOGIN |\n========");
        input.nextLine();
        System.out.print("Masukkan username anda :");
        String username = input.nextLine();
        System.out.print("Masukkan password anda :");
        String password = input.nextLine();

        if (user.equals(username) && pass.equals(password)) {
            System.out.println("\nLogin Berhasil !");
            processMenu();
        } else {
            System.out.println("\nLogin Gagal! Username atau Password Salah.");
        }
    }

    static void processMenu() {
        while (true) {
            System.out.println("\n====================================================");
            System.out.println("\n======\n| Menu |\n======");
            displayMenu();
            System.out.print("\nPilih menu (1/2/3/4/5): ");
            int pilihan = input.nextInt();
            System.out.println();

            if (pilihan == 4) {
                break;
            } else if (pilihan == 5) {
                modifyOrder();
            } else if (pilihan >= 1 && pilihan <= 3) {
                placeOrder(pilihan);
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih menu yang tersedia.");
            }
        }
        processPayment();
    }

    static void displayMenu() {
        System.out.println("\n==============================================");
        System.out.println("|  No  |   Makanan & Minuman   |     Harga    |");
        System.out.println("==============================================");
        System.out.println("|  1.  |   Kopi                |   Rp 10,000  |");
        System.out.println("|  2.  |   Teh                 |   Rp  8,000  |");
        System.out.println("|  3.  |   Roti                |   Rp  5,000  |");
        System.out.println("==============================================");
        System.out.println("\nKetik 4 jika proses pemesanan sudah selesai.");
        if (roti != 0 || kopi != 0 || teh != 0) {
            System.out.println("Ketik 5 jika ingin mengubah jumlah pesanan.");
            System.out.println("\nPesanan");
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
            System.out.println("\nTotal belanja Anda: Rp " + totalBelanja);
        }
    }

    static void placeOrder(int menuItem) {
        System.out.print("Masukkan jumlah yang dipesan :");
        int quantity = input.nextInt();

        switch (menuItem) {
            case 1:
                kopi += quantity;
                totalBelanja += kopi * 10000;
                break;
            case 2:
                teh += quantity;
                totalBelanja += teh * 8000;
                break;
            case 3:
                roti += quantity;
                totalBelanja += roti * 5000;
                break;
        }

        System.out.println();
    }

    static void modifyOrder() {
        System.out.println("\nPilih menu yang ingin anda ubah.");
        System.out.println("\n1. Roti : " + roti);
        System.out.println("2. Kopi : " + kopi);
        System.out.println("3. Teh : " + teh);
        System.out.print("\nPilih salah satu (1/2/3): ");
        int pilihan = input.nextInt();

        if (pilihan >= 1 && pilihan <= 3) {
            System.out.print("\nMasukkan jumlah terbaru:");
            updateQuantity(pilihan, input.nextInt());
            System.out.println("\nData berhasil diubah !");
            System.out.println("\n" + getMenuName(pilihan) + " : " + getQuantityByMenu(pilihan));
        } else {
            System.out.println("Pilihan tidak valid. Silakan pilih menu yang tersedia.");
        }
    }

    static int getQuantityByMenu(int menuItem) {
        switch (menuItem) {
            case 1:
                return kopi;
            case 2:
                return teh;
            case 3:
                return roti;
            default:
                return 0;
        }
    }

    static String getMenuName(int menuItem) {
        switch (menuItem) {
            case 1:
                return "Roti";
            case 2:
                return "Kopi";
            case 3:
                return "Teh";
            default:
                return "";
        }
    }

    static void updateQuantity(int menuItem, int newQuantity) {
        switch (menuItem) {
            case 1:
                kopi = newQuantity;
                break;
            case 2:
                teh = newQuantity;
                break;
            case 3:
                roti = newQuantity;
                break;
        }
    }

    static void processPayment() {
        System.out.println("\n====================================================");
        System.out.println("\n=============\n| Pembayaran |\n=============");
        System.out.println("\nJumlah uang yang harus anda bayarkan adalah sebesar Rp " + totalBelanja);
        System.out.print("Masukkan jumlah uang yang diberikan: ");

        while (true) {
            if (input.hasNextDouble()) {
                double jumlahUang = input.nextDouble();
                if (jumlahUang >= totalBelanja) {
                    double kembalian = jumlahUang - totalBelanja;
                    displayReceipt();
                    break;
                } else {
                    System.out.println("\n====================================================");
                    System.out.println("\nPembayaran Gagal !");
                    System.out.println("\nMaaf, uang yang diberikan kurang. Transaksi dibatalkan.");
                    System.out.println("\n====================================================");
                    break;
                }
            } else {
                System.out.println("Masukkan harus berupa angka. Silakan coba lagi.");
            }
        }
    }

    static void displayReceipt() {
        System.out.println("\n====================================================");
        System.out.println("\nPembayaran Berhasil !");
        
        double jumlahUang;
        while (true) {
            System.out.print("\nTerima kasih! Masukkan jumlah uang yang diberikan: Rp ");
            if (input.hasNextDouble()) {
                jumlahUang = input.nextDouble();
                break;
            } else {
                System.out.println("Masukkan harus berupa angka. Silakan coba lagi.");
                input.nextLine(); 
            }
        }
    
        double kembalian = jumlahUang - totalBelanja;
    
        System.out.println("Kembalian Anda: Rp " + kembalian);
        System.out.println("\n========================================================");
        System.out.println("|                        Kafe JTI                       |");
        System.out.println("========================================================");
        System.out.println("|     Pesanan          |     Jumlah    |    Sub Total   |");
        System.out.println("========================================================");
        if (kopi != 0) {
            System.out.println("|     Kopi             |       " + kopi + "       |    "
                    + kopi * 10000 + "   |");
        }
        if (teh != 0) {
            System.out.println(
                    "|     Teh              |       " + teh + "       |    " + teh * 8000 + "   |");
        }
        if (roti != 0) {
            System.out.println("|     Roti             |       " + roti + "       |    "
                    + roti * 5000 + "   |");
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("|     Total                             |   " + totalBelanja + "    |");
        System.out.println("|     Bayar                             |   " + jumlahUang + "    |");
        System.out.println("|                                                      |");
        System.out.println("|     Kembalian                         |   " + kembalian + "    |");
        System.out.println("========================================================");
        System.out.println();
    }
    
    
}
