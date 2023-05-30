package szeparalt.binaris.modell;

import java.io.Serializable;

public class Kartya implements Serializable{
    String kerdes, valasz;

    public Kartya(String kerdes, String valasz) {
        this.kerdes = kerdes;
        this.valasz = valasz;
    }

    @Override
    public String toString() {
        return "Kartya{" + "kerdes=" + kerdes + ", valasz=" + valasz + '}';
    }
    
}
