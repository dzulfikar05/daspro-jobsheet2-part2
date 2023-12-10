import java.util.Scanner;

public class remain {
    static Scanner input = new Scanner(System.in);
    static String user[] = { "kasir", "kasir" };
    static String username, password;
    static double jumlahUang, kembalian, totalBelanja = 0;
    static String menu[][] = { { "Kopi", "10000" }, { "Teh", "8000" }, { "Roti", "5000" } };
    static int pilihan, kopi = 0, teh = 0, roti = 0, harga[] = { 10000, 8000, 5000 };
    static int jumlahBeli[] = { 0, 0, 0 };

    public static void main(String[] args) {
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
                    login();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("\nPilihan anda tidak tersedia.");
            }
        }
    }

    static void login() {
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
            System.out.println("\nLogin Berhasil !");

            listmenu();
           

        } else {
            System.out.println();
            System.out.println("Login Gagal! Username atau Password Salah.");
        }
    }
    static void listmenu(){
        while (true) {
             System.out.println();
            System.out.println("==============");
            System.out.println("| Pilih Menu |");
            System.out.println("==============");
            System.out.println();
            System.out.println("1. Tambah Menu");
            System.out.println("2. Transaksi");
            System.out.println("3. Exit");
            pilihan = 0;
            System.out.print("Pilh salah satu (1/2/3): ");
            pilihan = input.nextInt();
            System.out.println();
            
            switch (pilihan) {
                case 1:
                    // login();
                    // break;
                case 2:
                    processMenu();
                    transaction();
                case 3:
                    return;
                default:
                    System.out.println("\nPilihan anda tidak tersedia.");
            }

        }
    }

    static void processMenu() {
        while (true) {
            System.out.println();
            System.out.println("====================================================");
            System.out.println();
            System.out.println("\t=======");
            System.out.println("\t| Menu |");
            System.out.println("\t=======");
            System.out.println();
            System.out.println("\t=========================================================================");
            System.out.println("\t|\tNo\t|\tMakanan & Minuman\t|\tHarga\t\t|");
            System.out.println("\t=========================================================================");
            
            for (int i = 0; i < menu.length; i++) {
                System.out.println("\t|\t" + (i + 1) + ".\t|\t" + menu[i][0] + "\t\t\t|\tRp " + menu[i][1] + "\t\t|");
            }
            
            System.out.println("\t=========================================================================");
            System.out.println();
            System.out.println("Ketik 4 jika proses pemesanan sudah selesai.");

            if (jumlahBeli[0] != 0 || jumlahBeli[1] != 0 || jumlahBeli[2] != 0) {
                System.out.println("Ketik 5 jika ingin mengubah jumlah pesanan.");
                System.out.println();
                System.out.println("Pesanan");
            }

            for (int i = 0; i < menu.length; i++) {
                if (jumlahBeli[i] != 0) {
                    System.out.println(menu[i][0] + " : " + jumlahBeli[i]);
                }
            }

            if (totalBelanja != 0) {
                System.out.println();
                System.out.println("Total belanja Anda: Rp " + totalBelanja);
            }
            System.out.println();
            System.out.print("Pilih menu (1/2/3/4/5): ");
            pilihan = input.nextInt();
            if (pilihan == 4) {
                break;
            }
            storeInputMenu();
            System.out.println();
        }

    }

    static void storeInputMenu() {
        System.out.println();

        if (pilihan == 1) {
            System.out.print("Masukkan jumlah yang dipesan :");
            jumlahBeli[0] += input.nextInt();
            totalBelanja += jumlahBeli[0] * harga[0];
            System.out.println();

        } else if (pilihan == 2) {
            System.out.print("Masukkan jumlah yang dipesan :");
            jumlahBeli[1] += input.nextInt();
            totalBelanja += jumlahBeli[1] * harga[1];
            System.out.println();

        } else if (pilihan == 3) {
            System.out.print("Masukkan jumlah yang dipesan :");
            jumlahBeli[2] += input.nextInt();
            totalBelanja += jumlahBeli[2] * harga[2];
            System.out.println();

        } else if (pilihan == 4) {
            return;
        } else if (pilihan == 5) {
            changePesanan();
        } else {
            System.out.println("Pilihan tidak valid. Silakan pilih menu yang tersedia.");
        }
    }

    static void changePesanan() {
        System.out.println();
        System.out.println("Pilih menu yang ingin anda ubah.");
        System.out.println();
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i][0] + " : " + jumlahBeli[i]);

        }
        System.out.println();
        System.out.println("Pilih salah satu (1/2/3): ");
        pilihan = input.nextInt();

        for (int i = 0; i < menu.length; i++) {
            if (pilihan == (i + 1)) {
                System.out.print("Masukkan jumlah terbaru:");
                totalBelanja = totalBelanja - (jumlahBeli[i] * harga[i]);
                jumlahBeli[i] = input.nextInt();
                System.out.println();
                totalBelanja = totalBelanja + (jumlahBeli[i] * harga[i]);
                System.out.println("Data berhasil diubah !");
                System.out.println();
                System.out.println(menu[i][i] + " : " + jumlahBeli[i]);
                System.out.println();
            }
        }
    }

    static void transaction() {
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

            kembalian = kembalian(jumlahUang, totalBelanja);
            System.out.println();
            System.out.println("====================================================");
            System.out.println();
            System.out.println("Pembayaran Berhasil !");
            System.out.println();
            System.out.println("Terima kasih! Kembalian Anda: Rp " + kembalian);
            System.out.println();

            cetakNota();

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
    }

    static void cetakNota() {

      
        System.out.println("\t=========================================================================================");
        System.out.println("\t|\t\t\t\t\tKafe JTI\t\t\t\t\t|");
        System.out.println("\t=========================================================================================");
        System.out.println("\t|\tPesanan\t\t|\t\tJumlah\t\t|\tSub Total\t\t|");
        System.out.println("\t=========================================================================================");

        for (int i = 0; i < menu.length; i++) {
            if (jumlahBeli[i] != 0) {
                System.out.println("\t|\t" + menu[i][0] + "\t\t|\t\t" + jumlahBeli[i] + "\t\t|\t" + jumlahBeli[i] * harga[i] + "\t\t\t|");
            }
        }

        System.out.println("\t-----------------------------------------------------------------------------------------");
        System.out.println("\t|\tTotal\t\t\t\t\t\t|\t" + totalBelanja + "\t\t\t|");
        System.out.println("\t|\tBayar\t\t\t\t\t\t|\t" + jumlahUang + "\t\t\t|");
        System.out.println("\t|\t\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t|\tKembalian\t\t\t\t\t|\t" + kembalian + "\t\t\t|");
        System.out.println("\t=========================================================================================");
    }

    static double kembalian(double jumlah, double bayar) {
        double result = jumlah - bayar;
        return result;
    }

}