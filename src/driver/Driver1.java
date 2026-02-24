import java.util.*;

public class Driver1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Map<String, String> namaMenu = new HashMap<>();
        Map<String, Integer> hargaMenu = new HashMap<>();

        namaMenu.put("NGS", "Nasi Goreng Spesial");
        hargaMenu.put("NGS", 15000);

        namaMenu.put("AP", "Ayam Penyet");
        hargaMenu.put("AP", 20000);

        namaMenu.put("SA", "Sate Ayam");
        hargaMenu.put("SA", 25000);

        namaMenu.put("BU", "Bakso Urat");
        hargaMenu.put("BU", 18000);

        namaMenu.put("MAP", "Mie Ayam Pangsit");
        hargaMenu.put("MAP", 15000);

        namaMenu.put("GG", "Gado-Gado");
        hargaMenu.put("GG", 15000);

        namaMenu.put("SAM", "Soto Ayam");
        hargaMenu.put("SAM", 17000);

        namaMenu.put("RD", "Rendang Daging");
        hargaMenu.put("RD", 25000);

        namaMenu.put("IB", "Ikan Bakar");
        hargaMenu.put("IB", 35000);

        namaMenu.put("NUK", "Nasi Uduk Komplit");
        hargaMenu.put("NUK", 20000);

        // Untuk menyimpan data sementara
        List<String> listNama = new ArrayList<>();
        List<Integer> listPorsi = new ArrayList<>();
        List<Integer> listHarga = new ArrayList<>();
        List<Integer> listTotal = new ArrayList<>();

        int totalBayar = 0;

        // ================= INPUT DULU =================
        while (true) {
            String kode = input.nextLine();

            if (kode.equals("END")) {
                break;
            }

            int porsiButet = Integer.parseInt(input.nextLine());
            int porsiUcok = porsiButet * 2;
            int totalPorsi = porsiButet + porsiUcok;

            String nama = namaMenu.get(kode);
            int harga = hargaMenu.get(kode);
            int total = harga * totalPorsi;

            listNama.add(nama);
            listPorsi.add(totalPorsi);
            listHarga.add(harga);
            listTotal.add(total);

            totalBayar += total;
        }

        // ================= OUTPUT STRUK =================
        System.out.printf("%-25s %5s %10s %10s\n",
                "Menu", "Porsi", "Harga", "Total");
        System.out.println("==============================================================");

        for (int i = 0; i < listNama.size(); i++) {
            System.out.printf("%-25s %5d %10d %10d\n",
                    listNama.get(i),
                    listPorsi.get(i),
                    listHarga.get(i),
                    listTotal.get(i));
        }

        System.out.println("==============================================================");
        System.out.printf("%-42s %10d\n", "Total Pembayaran", totalBayar);

        input.close();
    }
}
