package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Recept {
    private String nazivJela;
    private List<Sastojak> sastojci = new ArrayList<>();
    private int podatak;
    private VrstaPripreme vrstaPripreme = VrstaPripreme.KUHANJE;

    public void dodajSastojak(Sastojak s) {
        sastojci.stream().filter(temp -> temp.equals(s)
        ).findFirst().ifPresentOrElse(sastojak -> sastojak.setKolicina(s.getKolicina() + sastojak.getKolicina()),
                ()->sastojci.add(s));
    }
    public Recept(String nazivJela) {
        this.nazivJela = nazivJela;
    }

    public String getNazivJela() {
        return nazivJela;
    }

    public void setNazivJela(String nazivJela) {
        this.nazivJela = nazivJela;
    }

    public List<Sastojak> getSastojci() {
        return sastojci;
    }

    public int getPodatak() {
        return podatak;
    }

    public void setPodatak(int podatak) {
        this.podatak = podatak;
    }

    public VrstaPripreme getVrstaPripreme() {
        return vrstaPripreme;
    }

    public void setVrstaPripreme(VrstaPripreme vrstaPripreme) {
        this.vrstaPripreme = vrstaPripreme;
    }


    public void izbaciSastojak(Sastojak s) {
        sastojci.stream().filter(temp -> temp.equals(s)
        ).findFirst().ifPresentOrElse(sastojak -> sastojci.remove(s),
                ()-> {
            throw new NoSuchSastojakException("Nepoznat sastojak " + s.getNaziv());
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recept recept = (Recept) o;
        return podatak == recept.podatak &&
                Objects.equals(nazivJela, recept.nazivJela) &&
                Objects.equals(sastojci, recept.sastojci) &&
                vrstaPripreme == recept.vrstaPripreme;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazivJela, sastojci, podatak, vrstaPripreme);
    }

    @Override
    public String toString() {
        return "Recept za " + nazivJela + "\n" + sastojci.stream().map(Object::toString).collect(Collectors.joining("\n")) +
                "\n" + (vrstaPripreme == VrstaPripreme.PECENJE ? "Peći na "+podatak+" stepeni" :
                vrstaPripreme == VrstaPripreme.KUHANJE ? "Kuhati "+podatak+" minuta" : "Pržiti " + podatak + " minuta");

    }
}
