package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Kuhar {
    Map<String, Recept> mapa = new HashMap<>();

    public void dodajRecept(Recept r) {
        mapa.put(r.getNazivJela(), r);
    }
    public int brojRecepata(){
        return mapa.size();
    }
    public Recept dajRecept(String jelo) {
        return mapa.get(jelo);
    }
    public ArrayList<Recept> filtriraj(Predicate<Recept> f){
        return mapa.values().stream().filter(f).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Recept> receptiSaSastojkom(Sastojak sastojak) {
        return mapa.values().stream().filter(recept ->
                recept.getSastojci().stream().anyMatch(sastojak1 ->
                        sastojak.getNaziv().equals(sastojak1.getNaziv()))).collect(Collectors.toCollection(ArrayList::new));
    }
}
