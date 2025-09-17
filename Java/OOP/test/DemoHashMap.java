package test;

import java.util.HashMap;
import java.util.Map;

public class DemoHashMap {

    public static void main(String[] args){
        //bang gia trung
    //Ga nho = 2500
    //Ga trung = 3000
    // Ga lon = 3600
    // Ga ta =3200
    // vit lon song = 50000
    // vit lon chinh = 5300

    Map<String , Integer> bangGia = new HashMap<>();

    bangGia.put("Ga nho",2500);
    bangGia.put("Ga trung", 3000);
    bangGia.put("Ga lon", 3600);
    bangGia.put("Ga ta", 3200);
    bangGia.put("Ga lon song", 5000);
    bangGia.put("Ga lon chin", 5300);

    
    System.out.println(bangGia);

    // in val ma key enter vao
    System.out.println(bangGia.get("Ga ta"));

    // in tat ca val
    System.out.println(bangGia.values());


    //dung  for each run tat ca map
    for(String ga : bangGia.keySet()){
            System.out.println(ga + "-" + bangGia.get(ga));
        }

    // check key va val co nam in map neu cco tra ve true kh co tra ve false
    System.out.println(bangGia.containsKey("Ga lon"));
    System.out.println(bangGia.containsValue(50000));

    System.out.println(bangGia.putIfAbsent("Trung muoi", 5000));
    System.out.println(bangGia);

    
    }
}
