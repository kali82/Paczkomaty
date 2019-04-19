import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "punkt_odbioru")
public class PunktOdbioru implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_punktu", nullable = false, unique = true, insertable = false, updatable = false)
    private int id_punktu;
    @Column(name = "ilosc_miejsc")
    private int ilosc_miejsc;
    @Column(name = "Oznaczenie")
    private String oznaczenie;
    @Column(name = "adres")
    private String adres;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "punktOdbioru",
            cascade = {CascadeType.MERGE, CascadeType.DETACH,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    private Set<Zamowienie> zamowienia = new HashSet<Zamowienie>();

    public PunktOdbioru() {
    }

    public PunktOdbioru(int ilosc_miejsc, String oznaczenie, String adres) {
        this.ilosc_miejsc = ilosc_miejsc;
        this.oznaczenie = oznaczenie;
        this.adres = adres;
    }

    public int getId_punktu() {
        return id_punktu;
    }

    public void setId_punktu(int id_punktu) {
        this.id_punktu = id_punktu;
    }

    public int getIlosc_miejsc() {
        return ilosc_miejsc;
    }

    public void setIlosc_miejsc(int ilosc_miejsc) {
        this.ilosc_miejsc = ilosc_miejsc;
    }

    public String getOznaczenie() {
        return oznaczenie;
    }

    public void setOznaczenie(String oznaczenie) {
        this.oznaczenie = oznaczenie;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
