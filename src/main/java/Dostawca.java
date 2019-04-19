import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "dostawca")

public class Dostawca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dostawcy", nullable = false, unique = true,
            insertable = false, updatable = false)
    private int id_dostawcy;
    @Column(name = "imie")
    private String imie;
    @Column(name = "nazwisko")
    private String nazwisko;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "haslo")
    private String haslo;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "dostawca",
            cascade = {CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.PERSIST, CascadeType.REFRESH}
    )

   private Set<Zamowienie> zamowienia = new HashSet<Zamowienie>();

    public void add(Zamowienie tempZamowienie){
        if(zamowienia ==null){
            zamowienia = new HashSet<Zamowienie>();
        }
        zamowienia.add(tempZamowienie);
        tempZamowienie.setDostawca(this);

    }

    public Dostawca(){
    }

    public Dostawca(String imie, String nazwisko, String email, String haslo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;

    }

    public int getId_dostawcy() {
        return id_dostawcy;
    }

    public void setId_dostawcy(int id_dostawcy) {
        this.id_dostawcy = id_dostawcy;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Set<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(Set<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }
}

