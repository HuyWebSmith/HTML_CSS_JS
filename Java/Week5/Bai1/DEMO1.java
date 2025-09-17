package Bai1;

public class DEMO1 {
    public static void main(String[] args) {
        NV ql = new NVQL("2104", "Nguyen Quang Huy", "Dai hoc", 50000000, "Cntt", 2000000);
        NV nc = new NVNC("3003", "Nguyen Huu Thang", "Dai hoc", 100, "khong co", 1000);
        NV pv = new NVPV("xxxx", "Doan Quoc Bao", "AI 10.0", 0);
        ql.nhap();
        ql.xuat();
        System.out.println();
        System.out.printf("Luong: " + ql.tinhLuong() + "\n\n");

        System.out.println("==========================================================================================");
        nc.xuat();
        System.out.println();
        System.out.printf("Luong: " + nc.tinhLuong() + "\n\n");

        System.out.println("==========================================================================================");
        pv.xuat();
        System.out.println();
        System.out.printf("Luong: " + pv.tinhLuong() + "\n\n");
    }
}
