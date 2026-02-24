import java.util.*;

enum Status {
    DITERIMA, DICUCI, DISETRIKA, SELESAI, DIAMBIL
}

class LaundryItem {
    String jenis;
    int jumlah;

    public LaundryItem(String jenis, int jumlah) {
        this.jenis = jenis;
        this.jumlah = jumlah;
    }

    public String toString() {
        return jenis + " (" + jumlah + " pcs)";
    }
}

class LaundryOrder {
    private static int counter = 1;
    String id;
    String nama;
    String asrama;
    double berat;
    Status status;
    List<LaundryItem> items = new ArrayList<>();

    public LaundryOrder(String nama, String asrama, double berat) {
        if (nama.isEmpty() || asrama.isEmpty()) {
            throw new IllegalArgumentException("Nama dan Asrama wajib diisi!");
        }

        if (berat > 7) {
            throw new IllegalArgumentException("Berat melebihi 7kg!");
        }

        this.id = "LD" + counter++;
        this.nama = nama;
        this.asrama = asrama;
        this.berat = berat;
        this.status = Status.DITERIMA;
    }

    void tambahItem(String jenis, int jumlah) {
        items.add(new LaundryItem(jenis, jumlah));
    }

    void tampilkan() {
        System.out.println("\n===== DETAIL LAUNDRY =====");
        System.out.println("ID       : " + id);
        System.out.println("Nama     : " + nama);
        System.out.println("Asrama   : " + asrama);
        System.out.println("Berat    : " + berat + " kg");
        System.out.println("Status   : " + status);
        System.out.println("Detail Pakaian:");
        for (LaundryItem item : items) {
            System.out.println(" - " + item);
        }
    }
}

public class Driver3 {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<LaundryOrder> data = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== SISTEM LAUNDRY DEL ===");
            System.out.println("1. Tambah Laundry");
            System.out.println("2. Lihat Semua");
            System.out.println("3. Cari Laundry");
            System.out.println("4. Update Status");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            int pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1 -> tambahLaundry();
                case 2 -> lihatSemua();
                case 3 -> cariLaundry();
                case 4 -> updateStatus();
                case 5 -> {
                    System.out.println("Program selesai.");
                    return;
                }
                default -> System.out.println("Menu tidak valid!");
            }
        }
    }

    static void tambahLaundry() {
        try {
            System.out.print("Nama: ");
            String nama = sc.nextLine();

            System.out.print("Asrama: ");
            String asrama = sc.nextLine();

            System.out.print("Berat (max 7kg): ");
            double berat = sc.nextDouble();
            sc.nextLine();

            LaundryOrder order = new LaundryOrder(nama, asrama, berat);

            System.out.print("Berapa jenis pakaian? ");
            int jumlah = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < jumlah; i++) {
                System.out.print("Jenis: ");
                String jenis = sc.nextLine();
                System.out.print("Jumlah: ");
                int jml = sc.nextInt();
                sc.nextLine();
                order.tambahItem(jenis, jml);
            }

            data.add(order);
            System.out.println("Laundry berhasil ditambahkan dengan ID: " + order.id);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        }
    }

    static void lihatSemua() {
        if (data.isEmpty()) {
            System.out.println("Belum ada data laundry.");
            return;
        }

        for (LaundryOrder order : data) {
            order.tampilkan();
        }
    }

    static void cariLaundry() {
        System.out.print("Masukkan ID atau Nama: ");
        String keyword = sc.nextLine();

        for (LaundryOrder order : data) {
            if (order.id.equalsIgnoreCase(keyword) ||
                order.nama.equalsIgnoreCase(keyword)) {
                order.tampilkan();
                return;
            }
        }
        System.out.println("Laundry tidak ditemukan!");
    }

    static void updateStatus() {
        System.out.print("Masukkan ID: ");
        String id = sc.nextLine();

        for (LaundryOrder order : data) {
            if (order.id.equalsIgnoreCase(id)) {
                System.out.println("1. DICUCI");
                System.out.println("2. DISETRIKA");
                System.out.println("3. SELESAI");
                System.out.println("4. DIAMBIL");
                System.out.print("Pilih status: ");
                int s = sc.nextInt();
                sc.nextLine();

                switch (s) {
                    case 1 -> order.status = Status.DICUCI;
                    case 2 -> order.status = Status.DISETRIKA;
                    case 3 -> order.status = Status.SELESAI;
                    case 4 -> order.status = Status.DIAMBIL;
                    default -> System.out.println("Pilihan salah!");
                }

                System.out.println("Status berhasil diperbarui!");
                return;
            }
        }
        System.out.println("ID tidak ditemukan!");
    }
}
