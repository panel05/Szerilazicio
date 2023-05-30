package szoveges;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mentes {
    String kimenet = "Ez egy sor.";
    
    public static void main(String[] args) {
        new Mentes().feladat();
    }

    private void feladat() {
        kimenet += "\núj sor";
        fajlbaIras1();//Files
        fajlbaIras2();//Writer
        
        System.out.println("Files:");
        fajlbolOlvas1();
        System.out.println("Reader:");
        fajlbolOlvas2();
    }

    private void fajlbaIras1() {    
        try {
            Files.write(Paths.get("adat1.txt"), kimenet.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Mentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fajlbaIras2() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("adat2.txt"));
            bw.write(kimenet);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Mentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fajlbolOlvas1() {
        try {
            List<String> sorok = Files.readAllLines(Paths.get("adat1.txt"));
            System.out.println("adat1 sorai:");
            for (String sor : sorok) {
                System.out.println(sor);
            }
        } catch (IOException ex) {
            Logger.getLogger(Mentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fajlbolOlvas2() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("adat2.txt"));
            String sor;
            while((sor = br.readLine()) != null){
                System.out.println(sor);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Mentes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
