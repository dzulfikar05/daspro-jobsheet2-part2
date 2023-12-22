import java.util.Scanner;
import java.util.Arrays;
public class remain {
    static Scanner input = new Scanner(System.in);
    static String user[][] = { {"kasir", "kasir"}, {"super", "super"} };
    static String bulan [] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    static String username, password, anoString, settingTanggal, day, month, year, session, potonganPercent=null;
    static double jumlahUang, kembalian, totalBelanja = 0, potonganHarga=0;
    static String[][][][] omsetPenjualan = new String[3000][12][31][2]; /* tahun|bulan|tanggal|countTransaksi - countIncome */
    static int pilihan;
    static String[][] menuKafe; /* [i] [nama] | [stok] | [harga] | [qtyTra] */
    static String[][] voucher; /* [i] [kode] | [jumlah %]  */

    public static void main(String[] args) {
        System.out.println("=============================");
        System.out.println("| Selamat datang di Cafe JTI |");
        System.out.println("=============================");
        menu();
    }
    
    static void menu() {
        while (true) {
            System.out.println();
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

        if (user[0][0].equals(username) && user[0][1].equals(password)) {
            System.out.println("\nLogin Berhasil !");
            System.out.println("\nAnda login sebagai Kasir");
            session = "kasir";
            listmenu();
        }else if (user[1][0].equals(username) && user[1][1].equals(password)) {
            System.out.println("\nLogin Berhasil !");
            System.out.println("\nAnda login sebagai Super");
            session = "super";
            listmenu();
        } else {
            System.out.println();
            System.out.println("Login Gagal! Username atau Password Salah.");
        }
    }

    static void listmenu() {
        boolean dateCon = false;
        boolean menuCon = false;
        while (true) {
            if(session == "super"){
                System.out.println();
                System.out.println("==============");
                System.out.println("| Pilih Menu |");
                System.out.println("==============");
                System.out.println();
                System.out.println("1. Setting Tanggal");
                System.out.println("2. Tambah Menu");
                System.out.println("3. Lihat Menu");
                System.out.println("4. Transaksi");
                System.out.println("5. Lihat Omset");
                System.out.println("6. Tambah Voucher");
                System.out.println("7. Logout");
                pilihan = 0;
                System.out.print("Pilh salah satu (1/2/3/..): ");
                pilihan = input.nextInt();
                switch (pilihan) {
                    case 1: 
                        settingTanggal();
                        break;
                    case 2:
                        // menuCon = checkMenu();
                        // if(menuCon){
                            inputMenu();
                        // }
                        break;
                    case 3:
                        menuCon = checkMenu();
                        if(menuCon){
                            lihatMenu();
                        }
                        break;
                    case 4:
                        dateCon = checkSetDate();
                        menuCon = checkMenu();

                        if(dateCon && menuCon){
                            processMenu();
                            transaction();
                        }
                        break;
                    case 5:
                        omset();
                    case 6:
                        storeVoucher();
                        break;

                    case 7:
                        menu();
                    default:
                        System.out.println("\nPilihan anda tidak tersedia.");
                }
            }else if (session == "kasir"){
                System.out.println();
                System.out.println("==============");
                System.out.println("| Pilih Menu |");
                System.out.println("==============");
                System.out.println();
                System.out.println("1. Setting Tanggal");
                System.out.println("2. Tambah Menu");
                System.out.println("3. Lihat Menu");
                System.out.println("4. Transaksi");
                // System.out.println("5. Tambah Voucher");
                System.out.println("5. Logout");
                pilihan = 0;
                System.out.print("Pilh salah satu (1/2/3/..): ");
                pilihan = input.nextInt();
                System.out.println();

                switch (pilihan) {
                    case 1: 
                        settingTanggal();
                        break;
                    case 2:
                        // menuCon = checkMenu();
                        // if(menuCon){
                            inputMenu();
                        // }
                        break;
                    case 3:
                        menuCon = checkMenu();
                        if(menuCon){
                            lihatMenu();
                        }
                        break;
                    case 4:
                        dateCon = checkSetDate();
                        menuCon = checkMenu();

                        if(dateCon && menuCon){
                            processMenu();
                            transaction();
                        }
                        break;
                    // case 5:
                    //     storeVoucher();
                    //     break;
                    case 5:
                        menu();
                    default:
                        System.out.println("\nPilihan anda tidak tersedia.");
                }
            }


        }
    }

    static void storeVoucher(){
        int jumlahVoucher = 0;
        System.out.print("Masukkan jumlah voucher yang ingin ditambahkan : ");
        jumlahVoucher = input.nextInt();

        voucher = new String[jumlahVoucher][2];
            for (int i = 0; i < voucher.length; i++) {
                System.out.println();
                System.out.println("Voucher ke " + (i + 1));

                System.out.print("Masukkan kode voucher : ");
                voucher[i][0] = input.next();
                System.out.print("Masukkan diskon (satuan otomatis dalam bentuk persen) : ");
                voucher[i][1] = input.next();
                System.out.println();
            }
        while (true) {
            System.out.println("=================================");
            System.out.println("|\tKode\t|\tDiskon\t|");
            System.out.println("=================================");
            
            for (int i = 0; i < voucher.length; i++) {
                System.out.println("|\t"+voucher[i][0]+"\t|\t"+voucher[i][1]+"%\t|" );
            }
            System.out.println("=================================");

            anoString = "";
            System.out.print("Kembali (y/n) ? ");
            anoString = input.next();
            if(anoString.equalsIgnoreCase("y")){
                break;
            }
        }


    }

    static boolean checkSetDate(){
        if(settingTanggal == null){
            System.out.println("Tanggal System harus di isi terlebih dahulu. Anda dapat mengisi dengan memilih nomor 1 pada pemilihan menu.");
            return false;
        }
        return true;
    }

    static boolean checkMenu(){
        if(menuKafe == null){
            System.out.println("Menu yang dijual pada system tidak tersedia, silahkan menambahkan menu dengan memilih nomor 2 pada pemilihan menu");

            return false;
        }
        return true;
    }

    static void settingTanggal(){
        // reset Date
        settingTanggal = null;
        day = null;
        month = null;
        year = null;

        System.out.print("Masukkan tanggal setting tanggal sistem (dd/mm/yyyy): ");
        settingTanggal = input.next();

        String[] parts = settingTanggal.split("/");
        day = parts[0]; // dd
        month = parts[1]; // mm
        year = parts[2]; // yyyy
        
        while (true) {
            System.out.println();
            System.out.println("Tanggal : "+ settingTanggal);
            System.out.println();
            anoString = "";
            System.out.print("Kembali (y/n) ? ");
            anoString = input.next();
            if(anoString.equalsIgnoreCase("y")){
                break;
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
            
            pilihan = 0;
            System.out.print("Pilih menu sesuai nomor list menu: ");

            pilihan = input.nextInt();
            // if (pilihan == (menuKafe.length+1)) {
            //     break;
            // }
            storeInputMenu();
            System.out.println();
        }

    }

    static void storeInputMenu() {
        boolean checkPil = false;
        System.out.println();
        for(int i = 0; i<menuKafe.length; i++){
            if(pilihan == (i+1)){
                checkPil = true;
                int stokLama = Integer.valueOf(menuKafe[i][1]);
                int jumlah; 
                while (true) {
                    System.out.print("Masukkan jumlah yang dipesan :");
                    jumlah = input.nextInt();
                    // detect stok
                    if(stokLama < jumlah){
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
                transaction();
            }else if(pilihan == (menuKafe.length+2)){
                changePesanan();
            }
        }
        if(checkPil == false || pilihan != (menuKafe.length+1) || pilihan != (menuKafe.length+2)){
            System.out.println("Pilihan tidak valid. Silakan pilih menu yang tersedia.");
        }
    }

    static void changePesanan() {
        System.out.println();
        System.out.println("Pilih menu yang ingin anda ubah.");
        System.out.println();
        showPesanan();
        System.out.println();
        System.out.print("Pilih salah satu dengan mengetikkan kode dari menu yang dipesan : ");
        pilihan = input.nextInt();

        totalBelanja -= Integer.valueOf(menuKafe[pilihan][2]) * Integer.valueOf(menuKafe[pilihan][3]);
        menuKafe[pilihan][1] = String.valueOf(Integer.valueOf(menuKafe[pilihan][1])+Integer.valueOf(menuKafe[pilihan][3]));

        // input new qty & change data
        System.out.print("Masukkan jumlah terbaru : ");
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
        String redeem = "";
        boolean check = false;
        System.out.println("====================================================");
        System.out.println();
        System.out.println("=============");
        System.out.println("| Pembayaran |");
        System.out.println("=============");
        System.out.println();
        System.out.println("Jumlah uang yang harus anda bayarkan adalah sebesar Rp " + totalBelanja);
        
        while (true) {
            
            if(voucher != null){

                anoString = "";
                System.out.print("Apakah anda ingin menggunakan voucher (y/n) ? :");
                anoString = input.next();
                if(anoString.equalsIgnoreCase("y")){
                    System.out.println();
                    System.out.print("Masukkan kode voucher : ");
                    redeem = input.next();
                    
                    // check
                    for(int i=0; i < voucher.length; i++){
                        if(redeem.equals(voucher[i][0])){
                            check = true;
                            potonganPercent = voucher[i][1];
                        }
                    }

                    if(check == true){
                        potonganHarga = totalBelanja * Double.valueOf(potonganPercent) / 100;
                        totalBelanja = totalBelanja - potonganHarga;

                        System.out.println();
                        System.out.println("Voucher Berhasil di gunakan !");
                        System.out.println("Anda mendapatkan potongan sebesar " + potonganPercent +"% yang bernilai "+potonganHarga);
                        break;

                    }else{
                        System.out.println();
                        System.out.println("Kode Voucher tidak ditemukan. ");
                        System.out.println();
                    }
                }else{
                    break;
                }
                System.out.println("Jumlah uang yang harus anda bayarkan adalah sebesar Rp " + totalBelanja);

            } else {
                break;
            }  
        }


        System.out.println();
        System.out.print("Masukkan jumlah uang yang diberikan: ");
        jumlahUang = input.nextDouble();

        if (jumlahUang >= totalBelanja) {

            // insert omser
            // omsetHarian += totalBelanja;
            String oldCountTransaction = omsetPenjualan[Integer.valueOf(year)-1][Integer.valueOf(month)-1][Integer.valueOf(day)-1][0] ==  null ? "0" : omsetPenjualan[Integer.valueOf(year)-1][Integer.valueOf(month)-1][Integer.valueOf(day)-1][0]; 
            String oldOmsetTransaction = omsetPenjualan[Integer.valueOf(year)-1][Integer.valueOf(month)-1][Integer.valueOf(day)-1][1] == null ? "0" : omsetPenjualan[Integer.valueOf(year)-1][Integer.valueOf(month)-1][Integer.valueOf(day)-1][1]; 
            
            omsetPenjualan[Integer.valueOf(year)-1][Integer.valueOf(month)-1][Integer.valueOf(day)-1][0] = String.valueOf(Integer.valueOf(oldCountTransaction)+1);
            omsetPenjualan[Integer.valueOf(year)-1][Integer.valueOf(month)-1][Integer.valueOf(day)-1][1] = String.valueOf(Double.valueOf(oldOmsetTransaction)+totalBelanja);
            // omsetPenjualan[Integer.valueOf(year)-1][Integer.valueOf(month)-1][Integer.valueOf(day)-1][1] = String.valueOf(Integer.valueOf(oldOmsetTransaction == null ? "0" : oldOmsetTransaction)+totalBelanja);

            // count kembalian
            kembalian = kembalian(jumlahUang, totalBelanja);
            
            // status transaction 
            System.out.println();
            System.out.println("====================================================");
            System.out.println();
            System.out.println("Pembayaran Berhasil !");
            System.out.println();
            System.out.println("Terima kasih! Kembalian Anda: Rp " + kembalian);
            System.out.println();

            // validation cetak nota
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
            System.out.println("Maaf, uang yang diberikan kurang.");
            System.out.println();

        }
    }

    static void cetakNota() {
        System.out.println();
        System.out.println("=========================================================================================");
        System.out.println("|\t\t\t\t\tKafe JTI\t\t\t\t\t|");
        System.out.println("=========================================================================================");
        System.out.println("|\tPesanan\t\t|\t\tJumlah\t\t|\tSub Total\t\t|");
        System.out.println("=========================================================================================");

        for (int i = 0; i < menuKafe.length; i++) {
            if (menuKafe[i][3] != null) {
                System.out.println("|\t" + menuKafe[i][0] + "\t\t|\t\t" + menuKafe[i][3] + "\t\t|\t"+ Integer.valueOf(menuKafe[i][3]) * Integer.valueOf(menuKafe[i][2]) + "\t\t\t|");
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        if(potonganPercent != null){
            System.out.println("|\tTotal\t\t\t\t\t\t|\t" + (totalBelanja+potonganHarga) + "\t\t\t|");
            System.out.println("|\tPotongan\t\t\t\t\t|\t" + potonganHarga + "\t\t\t|");
            System.out.println("|\tTotal Akhir\t\t\t\t\t|\t" + totalBelanja + "\t\t\t|");
                    System.out.println("|\t\t\t\t\t\t\t\t\t\t\t|");

        }else{
            System.out.println("|\tTotal\t\t\t\t\t\t|\t" + totalBelanja + "\t\t\t|");
        }
        System.out.println("|\tBayar\t\t\t\t\t\t|\t" + jumlahUang + "\t\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("|\tKembalian\t\t\t\t\t|\t" + kembalian + "\t\t\t|");
        System.out.println("=========================================================================================");
        System.out.println();
        System.out.println();

    }

    static void reset(){
        totalBelanja = 0;
        jumlahUang = 0;
        potonganPercent = null;
        potonganHarga = 0;
        kembalian = 0;
        for(int i = 0; i<menuKafe.length; i++){
            menuKafe[i][3]=null;
        }
    }

    static void listAfterNota () {
        pilihan = 0;
        reset();
        System.out.println();
        System.out.println("1. Menu");
        System.out.println("2. Pemesanan");
        // System.out.println("3. Exit");
        System.out.print("Pilih salah satu (1/2): ");

        pilihan = input.nextInt();
        switch (pilihan) {
            case 1:
                listmenu();
                break;
            case 2:
                processMenu();
                break;
            
            default:
                System.out.println("\nPilihan anda tidak tersedia.");
        }
    }

    static double kembalian(double jumlah, double bayar) {
        double result = jumlah - bayar;
        return result;
    }

    static void omset(){
        while (true) {
            System.out.println("=============");
            System.out.println("| Data Omset |");
            System.out.println("=============");
            System.out.println();
            System.out.println("Jenis Omset");
            System.out.println("1. Omset Harian");
            System.out.println("2. Omset Bulanan");
            System.out.println("3. Kembali");

            pilihan = 0;
            System.out.print("Pilih salah satu (1/2/3) : ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    omsetHarian();
                    break;
                case 2:
                    omsetBulanan();
                    break;
                case 3:
                    listmenu();
                    break;
                default:
                    System.out.println("\nPilihan anda tidak tersedia.");
            }
        }

    }

    static void omsetHarian(){
        
        // input date
        String tanggal;
        System.out.println();
        System.out.print("Masukkan tanggal (dd/mm/yyyy) : ");
        tanggal = input.next();

        // split date
        String[] parts = tanggal.split("/");
        String dayF = parts[0]; // dd
        String monthF = parts[1]; // mm
        String yearF = parts[2]; // yyyy

        // show data
        while (true) {
            System.out.println();
            System.out.println("Data transaksi pada tanggal " + tanggal +" :");
            // System.out.println(omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][Integer.valueOf(dayF)-1][0] != null ? "Banyak Transaksi\t : "+  omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][Integer.valueOf(dayF)-1][0] : "Banyak Transaksi\t : -");
            // System.out.println(omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][Integer.valueOf(dayF)-1][1] != null ? "Total Pendapatan\t : "+  omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][Integer.valueOf(dayF)-1][1] : "Total Pendapatan\t : -");

            System.out.println("Banyak Transaksi\t : " + (omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][Integer.valueOf(dayF)-1][0] != null ? omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][Integer.valueOf(dayF)-1][0] : 0));
            System.out.println("Total Pendapatan\t : " + (omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][Integer.valueOf(dayF)-1][1] != null ? omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][Integer.valueOf(dayF)-1][1] : 0.0));

            System.out.println();
            anoString = "";
            System.out.println("Kembali (y/n) : ");
            anoString = input.next();
            if (anoString.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    static void omsetBulanan(){
        String tanggal;
        int countTransaction = 0;
        double countIncome = 0;
        // input date
        System.out.println();
        System.out.print("Masukkan tanggal (mm/yyyy) : ");
        tanggal = input.next(); /* 12/2023 */

        // split date
        String[] parts = tanggal.split("/");
        // String dayF = parts[0]; // dd
        String monthF = parts[0]; // mm 12
        String yearF = parts[1]; // yyyy 2023

        while (true) {
            System.out.println("Transaksi Pada Bulan ke-"+ monthF+" ("+ bulan[Integer.valueOf(monthF)-1] +")");

            for(int i = 0; i < omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1].length; i++){
                if(omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][i][0] != null){
                    countTransaction += Double.valueOf(omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][i][0]);
                    countIncome += Double.valueOf(omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][i][1]);
                }
            }

            boolean check = false;
            System.out.println("Jumlah total transaksi\t: "+ countTransaction);
            System.out.println("Jumlah total pendapatan\t: "+ countIncome);
            System.out.println("Detail Transaksi : ");
            
            System.out.println("========================================================================");
            System.out.println("|\tTanggal\t\t|\tTransaksi\t|\tPendapatan\t|");
            System.out.println("========================================================================");
            for(int i = 0; i < omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1].length; i++){
                if(omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][i][0] != null){
                    System.out.println("|\t"+(i+1)+"/"+monthF+"/"+yearF+"\t|\t" + omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][i][0] + "\t\t|\t" + omsetPenjualan[Integer.valueOf(yearF)-1][Integer.valueOf(monthF)-1][i][1]+"\t|");
                    check = true;
                }
            }
            if(check == false){
                System.out.println("|\t\t Data Kosong. ");
            }
            System.out.println("========================================================================");


            anoString = "";
            System.out.println("Kembali (y/n) : ");
            anoString = input.next();
            if (anoString.equalsIgnoreCase("y")) {
                break;
            }
        }
    }
}