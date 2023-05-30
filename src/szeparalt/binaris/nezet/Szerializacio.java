package szeparalt.binaris.nezet;

import szeparalt.binaris.modell.Kartya;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Szerializacio {

    private ArrayList<Kartya> kartyak;

    public Szerializacio() {
        kartyak = new ArrayList<>();
        feladat();
    }
    
    public void feladat() {
        feltoltes();
        tartalom("feltöltés után:");
        szerializalas();
        
        kartyak = null;
        tartalom("kartyak = null:");
        
        deszerializalas();
        tartalom("visszaolvasva:");
    }
    
    private void feltoltes() {
        Kartya k1 = new Kartya("K1", "V1");
        Kartya k2 = new Kartya("K2", "V2");
        
        kartyak.add(k1);
        kartyak.add(k2);
    }
    
    private void szerializalas() {
        FileOutputStream kiFajl;
        try {
            kiFajl = new FileOutputStream("adat.ser");
            ObjectOutputStream kiObj = new ObjectOutputStream(kiFajl);
            kiObj.writeObject(kartyak);
            kiObj.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(alap.binaris.Szerializacio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(alap.binaris.Szerializacio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    private void deszerializalas(){
        FileInputStream beFajl;
        try {
            beFajl = new FileInputStream("adat.ser");
            ObjectInputStream beObj = new ObjectInputStream(beFajl);
            kartyak = (ArrayList<Kartya>)beObj.readObject();
            beObj.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(alap.binaris.Szerializacio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(alap.binaris.Szerializacio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void tartalom(String cim) {
        System.out.println(cim);
        if (kartyak != null) {
            for (Kartya kartya : kartyak) {
                System.out.println(kartya);
            }
        } else {
            System.out.println("üres a lista");
        }
    }
}
