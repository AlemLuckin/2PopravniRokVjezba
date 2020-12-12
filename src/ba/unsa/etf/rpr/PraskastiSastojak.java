package ba.unsa.etf.rpr;

import java.util.Objects;

public class PraskastiSastojak extends Sastojak {
    public PraskastiSastojak(String nazivSastojka, int kol) {
        super(nazivSastojka, kol);
    }

    @Override
    public String toString() {
        return getKolicina() + " g " + getNaziv();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sastojak sastojak = (Sastojak) o;
        return (Objects.equals(naziv, sastojak.naziv) && Objects.equals(getClass(), sastojak.getClass()));
    }
}
