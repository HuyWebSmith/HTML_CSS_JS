package Bai2;
import java.util.ArrayList;

import Bai1.*;


public class HOCVIEN {
    ArrayList<NV> hv = new ArrayList<>();

    
    public HOCVIEN() {}

    public void init(){
        hv.add(new NVQL("NV001", "Nguyen Van A", "Dai hoc", 15000000, "CNTT", 2000000));
        hv.add(new NVQL("NV002", "Tran Thi B", "Cao dang", 12000000, "Ke toan", 1500000));

        hv.add(new NVNC("NV004", "Pham Thi D", "Dai hoc", 14000000, "Quan tri", 1800000));
        hv.add(new NVNC("NV005", "Nguyen Van E", "Thac si", 20000000, "Marketing", 2500000));

        hv.add(new NVPV("2104", "Nguyen Quang Huy", "Dai hoc", 50000000));
        hv.add(new NVPV("3003", "Nguyen Huu Thang", "Dai hoc", 100));
        hv.add(new NVPV("xxxx", "Doan Quoc Bao", "AI 10.0", 0));
    }
    public void them(NV e){
        hv.add(e);
    }

    public void xuatTheoLoai(byte loai){
        for(NV x : hv)
            if(x instanceof NVQL && loai ==1 )
                x.xuat();
            else if(x instanceof NVNC && loai == 2)
                x.xuat();
            else if(x instanceof NVPV && loai == 3)
                x.xuat();
    }
}
