package Week4.bai2.src;
import java.util.ArrayList;

import CONNGUOI;
import HOCVIEN;
import Week4.bai1.lib.*;;


public class DANHSACH {
    ArrayList<CONNGUOI> ds = new ArrayList<>();
    
    public void them(CONNGUOI e){
        ds.add(e);
    }

    public void xuathv(){
        for(CONNGUOI x : ds)
            if(x instanceof HOCVIEN)
                x.output();

    }
}
