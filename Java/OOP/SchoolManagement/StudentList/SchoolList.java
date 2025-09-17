package SchoolManagement.StudentList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import SchoolManagement.Student.*;


public class SchoolList {
    public List<School> ds = new ArrayList<>();
    School hs = new Student();
    public void addList(School e){
        ds.add(e);
    }

    public void Output(int type){
        for(School x : ds){
            if(x instanceof Student && type == 1) {
                System.out.println(x.toString());}
            else if(x instanceof Teacher && type == 2)
                    System.out.println(x.toString());
        }
    }

    public void sortName(){
        Collections.sort(ds, new Comparator<School>() {
            @Override
            public int compare(School o1,School o2){
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
}
