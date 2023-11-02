import java.util.Scanner;

public class backup {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String user[] = {"kasir", "kasir"};
        String username, password;
        double jumlahUang, kembalian, totalBelanja = 0;
        String menu[][] = {{"Kopi", "10000"}, {"Teh", "8000"}, {"Roti", "5000"}};
        int  pilihan, kopi = 0, teh = 0, roti = 0, harga[] = {10000, 8000, 5000};
        int jumlahBeli[]= {0, 0, 0};
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

                                System.out.println("|  "+(i+1)+".  |   "+ menu[i][0]+"                |   Rp "+menu[i][1]+"  |");
                            }

                            System.out.println("==============================================");
                            System.out.println();
                            System.out.println("Ketik 4 jika proses pemesanan sudah selesai.");
                            if (jumlahBeli[0] != 0 || jumlahBeli[1] != 0 || jumlahBeli[2] != 0) {
                                System.out.println("Ketik 5 jika ingin mengubah jumlah pesanan.");
                                System.out.println();
                                System.out.println("Pesanan");
                            }

                            for (int i = 0; i<menu.length; i++){
                                if (jumlahBeli[i] != 0) {
                                    System.out.println( menu[i][0]+" : " + jumlahBeli[i]);
                                }
                            }
                            // if (jumlahBeli[0] != 0) {
                            //     System.out.println( menu[0]+" : " + kopi);
                            // }
                            // if (jumlahBeli[1] != 0) {
                            //     System.out.println( menu[1]+" : " + teh);
                            // }
                            // if (jumlahBeli[2] != 0) {
                            //     System.out.println( menu[2]+" : " + roti);
                            // }

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
                                break;
                            }else if (pilihan == 5) {
                                System.out.println();
                                System.out.println("Pilih menu yang ingin anda ubah.");
                                System.out.println();
                                for (int i = 0; i<menu.length; i++){
                                    System.out.println( (i+1)+". "+menu[i][0]+" : " + jumlahBeli[i]);
                                    
                                }
                                // System.out.println("1. Kopi : " + kopi);
                                // System.out.println("2. Teh : " + teh);
                                // System.out.println("3. Roti : " + roti);
                                System.out.println();
                                System.out.println("Pilih salah satu (1/2/3): ");
                                pilihan = input.nextInt();

                                if (pilihan == 1) {
                                    System.out.print("Masukkan jumlah terbaru:");
                                    totalBelanja = totalBelanja - (jumlahBeli[0] * harga[0]);
                                    jumlahBeli[0] = input.nextInt();
                                    System.out.println();
                                    totalBelanja = totalBelanja + (jumlahBeli[0] * harga[0]);
                                    System.out.println("Data berhasil diubah !");
                                    System.out.println();
                                    System.out.println(menu[0][0]+" : " + jumlahBeli[0]);
                                    System.out.println();
                                } else if (pilihan == 2) {
                                    System.out.print("Masukkan jumlah terbaru :");
                                    totalBelanja = totalBelanja - (jumlahBeli[1] * harga[1]);
                                    jumlahBeli[1] = input.nextInt();
                                    totalBelanja = totalBelanja + (jumlahBeli[1] * harga[1]);
                                    System.out.println();
                                    System.out.println("Data berhasil diubah !");
                                    System.out.println();
                                    System.out.println(menu[1][0]+" : " + jumlahBeli[1]);
                                    System.out.println();
                                } else if (pilihan == 3) {
                                    System.out.println();
                                    System.out.print("Masukkan jumlah terbaru:");
                                    totalBelanja = totalBelanja - (jumlahBeli[2] * harga[2]);
                                    jumlahBeli[2] = input.nextInt();
                                    totalBelanja = totalBelanja + (jumlahBeli[2] * harga[2]);
                                    System.out.println();
                                    System.out.println("Data berhasil diubah !");
                                    System.out.println();
                                    System.out.println(menu[2][0]+" : " + jumlahBeli[2]);
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

                            for(int i=0; i<menu.length; i++){
                                if (jumlahBeli[i] != 0) {
                                    System.out.println("|     "+menu[i][0]+"             |       "+jumlahBeli[i]+"       |    "+jumlahBeli[i] *harga[i]+"   |");
                                }

                            }
                            // if (teh != 0) {
                            //     System.out.println("|     "+menu[1][1]+"              |       "+jumlahBeli[1]+"       |    "+jumlahBeli[1] *8000+"   |");
                            // }
                            // if (roti != 0) {
                            //     System.out.println("|     "+menu[2][1]+"             |       "+jumlahBeli[2]+"       |    "+jumlahBeli[2] *5000+"   |");
                            // }
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