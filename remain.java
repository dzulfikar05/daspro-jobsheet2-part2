import java.util.Scanner;

public class remain {
    static Scanner input = new Scanner(System.in);
    static String user[] = { "kasir", "kasir" };
    static String username, password, anoString;
    static double jumlahUang, kembalian, totalBelanja = 0;
    // static String menu[][] = { { "Kopi", "10000" }, { "Teh", "8000" }, { "Roti", "5000" } };
    static int pilihan;
    // static int jumlahBeli[] = { 0, 0, 0 };
    static String[][] menuKafe;

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

    static void listmenu() {

        while (true) {
            System.out.println();
            System.out.println("==============");
            System.out.println("| Pilih Menu |");
            System.out.println("==============");
            System.out.println();
            System.out.println("1. Tambah Menu");
            System.out.println("2. Lihat Menu");
            System.out.println("3. Transaksi");
            System.out.println("4. Exit");
            pilihan = 0;
            System.out.print("Pilh salah satu (1/2/3/4): ");
            pilihan = input.nextInt();
            System.out.println();

            switch (pilihan) {
                case 1:
                    inputMenu();
                    break;
                case 2:
                    lihatMenu();
                    break;
                case 3:
                    processMenu();
                    transaction();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("\nPilihan anda tidak tersedia.");
            }

        }
    }

    static void inputMenu() {
        int jumlahMenu = 0;
        System.out.print("Masukkan jumlah menu yang ingin ditambahkan :");
        jumlahMenu = input.nextInt();

        menuKafe = new String[jumlahMenu][4];

        for (int i = 0; i < menuKafe.length; i++) {
            System.out.println();
            System.out.println("Menu ke " + (i + 1));

            System.out.print("Masukkan nama menu : ");
            menuKafe[i][0] = input.next();
            System.out.print("Masukkan stok menu : ");
            menuKafe[i][1] = input.next();
            System.out.print("Masukkan harga menu : ");
            menuKafe[i][2] = input.next();
            System.out.println();

        }
    }

    static void lihatMenu() {
        if (menuKafe.length < 1) {
            System.out.println("Data belum tersedia. Silahkan mengisi data menu terbelih dahulu.");
        } else {
            while (true) {
                System.out.println();
                System.out.println("========================================================================================");
                System.out.println("|\tNo\t|\tMakanan & Minuman\t|\tStok\t|\tHarga\t\t|");
                System.out.println("========================================================================================");

                for (int i = 0; i < menuKafe.length; i++) {
                    System.out.println("|\t" + (i + 1) + ".\t|\t" + menuKafe[i][0] + "\t\t\t|\t"+menuKafe[i][1]+"\t|\tRp " + menuKafe[i][2] + "\t\t|");
                }

                System.out.println("========================================================================================");

                anoString = "";
                System.out.print("Apakah anda ingin kembali (y/n) ? ");
                anoString = input.next();
                if (anoString.equalsIgnoreCase("y")) {
                    break;
                }
            }
        }
    }

    static void processMenu() {
        while (true) {
            System.out.println();
            System.out.println("====================================================");
            System.out.println();
            System.out.println("=======");
            System.out.println("| Menu |");
            System.out.println("=======");
            System.out.println();
            System.out.println("========================================================================================");
            System.out.println("|\tNo\t|\tMakanan & Minuman\t|\tStok\t|\tHarga\t\t|");
            System.out.println("========================================================================================");

            for (int i = 0; i < menuKafe.length; i++) {
                System.out.println("|\t" + (i + 1) + ".\t|\t" + menuKafe[i][0] + "\t\t\t|\t"+menuKafe[i][1]+"\t|\tRp " + menuKafe[i][2] + "\t\t|");
            }

            System.out.println("========================================================================================");
            System.out.println();
            System.out.println("Ketik "+ (menuKafe.length+1) +" jika proses pemesanan sudah selesai.");

            boolean pesanan = false;
            for(int i =0; i < menuKafe.length; i++){
                if(menuKafe[i][3] != null){
                    pesanan = true;
                }
            }

            if (pesanan) {
                System.out.println("Ketik "+(menuKafe.length+2)+" jika ingin mengubah jumlah pesanan.");
                System.out.println();
                System.out.println("Pesanan");
            }

            for (int i = 0; i < menuKafe.length; i++) {
                if (menuKafe[i][3] != null) {
                    System.out.println(menuKafe[i][0] + " : " + menuKafe[i][3]);
                }
            }

            if (totalBelanja != 0) {
                System.out.println();
                System.out.println("Total belanja Anda: Rp " + totalBelanja);
            }
            System.out.println();
            
            System.out.print("Pilih menu sesuai nomor list menu: ");

            pilihan = input.nextInt();
            if (pilihan == (menuKafe.length+1)) {
                break;
            }
            storeInputMenu();
            System.out.println();
        }

    }

    static void storeInputMenu() {
        System.out.println();
        for(int i = 0; i<menuKafe.length; i++){
            if(pilihan == (i+1)){
                int stokLama = Integer.valueOf(menuKafe[i][1]);
                int jumlah; 
                while (true) {
                    System.out.print("Masukkan jumlah yang dipesan :");
                    jumlah = input.nextInt();
                    // detect stok
                    if(stokLama <= jumlah){
                        System.out.println("Stok tidak mencukupi.");
                        System.out.println();
                    }else{
                        break;
                    }
                }

                // insert qty
                int jumlahLama = menuKafe[i][3] == null ? 0 : Integer.valueOf(menuKafe[i][3]);
                menuKafe[i][3] =  String.valueOf(jumlahLama + jumlah); 

                // set total
                totalBelanja += Integer.valueOf(menuKafe[i][2]) * Integer.valueOf(menuKafe[i][3]);

                // stock min
                menuKafe[i][1] = String.valueOf(stokLama-jumlah);


            }else if(pilihan == (menuKafe.length+1)){
                return;
            }else if(pilihan == (menuKafe.length+2)){
                changePesanan();
            }
        }
        // if(pilihan != (menuKafe.length+1) || pilihan != (menuKafe.length+2)){
            // System.out.println("Pilihan tidak valid. Silakan pilih menu yang tersedia.");
        // }
    }

    static void changePesanan() {
        System.out.println();
        System.out.println("Pilih menu yang ingin anda ubah.");
        System.out.println();
        showPesanan();
        System.out.println();
        System.out.println("Pilih salah satu dengan mengetikkan kode dari menu yang dipesan : ");
        pilihan = input.nextInt();

        totalBelanja -= Integer.valueOf(menuKafe[pilihan][2]) * Integer.valueOf(menuKafe[pilihan][3]);
        menuKafe[pilihan][1] = String.valueOf(Integer.valueOf(menuKafe[pilihan][1])+Integer.valueOf(menuKafe[pilihan][3]));

        // input new qty & change data
        System.out.print("Masukkan jumlah terbaru:");
        menuKafe[pilihan][3] = String.valueOf(input.nextInt());
        menuKafe[pilihan][1] = String.valueOf(Integer.valueOf(menuKafe[pilihan][1])-Integer.valueOf(menuKafe[pilihan][3]));
        
        // change total
        totalBelanja += Integer.valueOf(menuKafe[pilihan][2]) * Integer.valueOf(menuKafe[pilihan][3]);

        System.out.println("Data berhasil diubah !");
        showPesanan();
     
    }

    static void showPesanan(){
        System.out.println("=================================================================");
        System.out.println("|\tNo\t|\tItem\t|\tJumlah\t|\tKode\t|");
        System.out.println("=================================================================");
        for (int i = 0; i < menuKafe.length; i++) {
            if(menuKafe[i][3] != null){

                System.out.println("|\t"+(i+1)+"\t|\t"+menuKafe[i][0]+"\t|\t" + menuKafe[i][3]+"\t|\t"+i+"\t|");
            }
        }
        System.out.println("=================================================================");
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

            anoString = "";
            System.out.print("Cetak Nota (y/n) ? ");
            anoString = input.next();
            if(anoString.equalsIgnoreCase("y")){
                cetakNota();
                listAfterNota();
            }else{
                listAfterNota();
            }
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
        System.out.println();
        System.out.println("\t=========================================================================================");
        System.out.println("\t|\t\t\t\t\tKafe JTI\t\t\t\t\t|");
        System.out.println("\t=========================================================================================");
        System.out.println("\t|\tPesanan\t\t|\t\tJumlah\t\t|\tSub Total\t\t|");
        System.out.println("\t=========================================================================================");

        for (int i = 0; i < menuKafe.length; i++) {
            if (menuKafe[i][3] != null) {
                System.out.println("\t|\t" + menuKafe[i][0] + "\t\t|\t\t" + menuKafe[i][3] + "\t\t|\t"+ Integer.valueOf(menuKafe[i][3]) * Integer.valueOf(menuKafe[i][2]) + "\t\t\t|");
            }
        }

        System.out.println("\t-----------------------------------------------------------------------------------------");
        System.out.println("\t|\tTotal\t\t\t\t\t\t|\t" + totalBelanja + "\t\t\t|");
        System.out.println("\t|\tBayar\t\t\t\t\t\t|\t" + jumlahUang + "\t\t\t|");
        System.out.println("\t|\t\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t|\tKembalian\t\t\t\t\t|\t" + kembalian + "\t\t\t|");
        System.out.println("\t=========================================================================================");
        System.out.println();
        System.out.println();

    }

    static void reset(){
        totalBelanja = 0;
        jumlahUang = 0;
        kembalian = 0;
        for(int i = 0; i<menuKafe.length; i++){
            menuKafe[i][3]=null;
        }
    }

    static void listAfterNota () {
        pilihan = 0;
        reset();
        System.out.println("1. Menu");
        System.out.println("2. Pemesanan");
        System.out.println("3. Exit");
        System.out.print("Pilih salah satu (1/2): ");

        pilihan = input.nextInt();
        switch (pilihan) {
            case 1:
                listmenu();
                break;
            case 2:
                processMenu();
                break;
            case 3:
                return;
            default:
                System.out.println("\nPilihan anda tidak tersedia.");
        }
    }

    static double kembalian(double jumlah, double bayar) {
        double result = jumlah - bayar;
        return result;
    }

}