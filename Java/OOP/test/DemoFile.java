package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DemoFile {
    public List<String> pList;

    public DemoFile(){
        pList = new ArrayList<>();
    }

    //Doc du lieu tu file va add vao pList
    public void loadFromFile() throws IOException{
        //File Scanner 
        //FileReader + BufferReader
        File file = new File("test/DemoFile.txt"); 
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        if(!file.exists()){
            file.createNewFile();
        }

        
        fileReader.close();
        bufferedReader.close();
    }

    // Tu pList se duoc tai du lieu len file
    public void saveToFile(){

    }
    public static void main(String[] args) {
        
    }
}
