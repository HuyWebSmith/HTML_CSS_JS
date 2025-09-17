package Bai1;
public class NVPV extends NV{

    public NVPV(){
        super();
    }

    public NVPV(String maNV,String tenNV,String trinhDo,long luongCB){
        super(maNV,tenNV,trinhDo,luongCB);
    }

    public NVPV(NVPV obj){
        super(obj);
    }

    @Override
    public void nhap(){
        super.nhap();
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.println();
    }

    @Override
    public long tinhLuong(){
        return getLuongCB();
    }
}
