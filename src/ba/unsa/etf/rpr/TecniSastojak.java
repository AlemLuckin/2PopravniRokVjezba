package ba.unsa.etf.rpr;

import java.util.Objects;

public class TecniSastojak extends Sastojak {
    public TecniSastojak(String nazivSastojka, int kol) {
        super(nazivSastojka, kol);
    }

    @Override
    public String toString() {
        return getKolicina() + " dl " + getNaziv();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sastojak sastojak = (Sastojak) o;
        return (Objects.equals(naziv, sastojak.naziv) && Objects.equals(getClass(), sastojak.getClass()));
    }

}
