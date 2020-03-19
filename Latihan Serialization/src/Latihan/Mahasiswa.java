/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Latihan;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author Dwi Fauzi
 */
public class Mahasiswa {
    public static void main(String[] args) throws ClassNotFoundException {
        FileOutputStream fos;
        ObjectOutputStream oos;
        FileInputStream fis;
        ObjectInputStream ois;
        
        try {
            Scanner s = new Scanner(System.in).useDelimiter("\n");
            System.out.print("Masukan NIM : ");
                int nim = s.nextInt();
            System.out.print("Masukan Nama : ");
            //Pattern p = Pattern.compile("[a-zA-Z ]+")
            String nama = s.next();
            System.out.println("=>"+nama);
            Data data = new Data (nim,nama);
             File f = new File("data.ser");
                if (f.exists()) {
                    //f.delete();
            }
                
          fos = new FileOutputStream(f);
          oos = new ObjectOutputStream(fos);
             oos.writeObject(data);
             oos.close();
             fos.close();
             
           fis = new FileInputStream(f);
           ois = new ObjectInputStream(fis);
           Object obj = ois.readObject();    
           Data input = (Data) obj;
           ois.close();
           fis.close();
            System.out.println(input.getNama());
        } catch (Exception e) {
            System.err.println(""+e.getMessage());
        }
    }
    static class Data implements Serializable{
    
    int nim;
    String nama;
    public  Data(int _nim, String _nama){
            nim = _nim;
            nama = _nama;
        
        }

        public int getNim() {
            return nim;
        }

        public String getNama() {
            return nama;
        }

        @Override
        public String toString() {
            return "Data{" + "nim=" + nim +"\n"+
                    ", nama=" + nama + '}';
        }
    
    }
}
