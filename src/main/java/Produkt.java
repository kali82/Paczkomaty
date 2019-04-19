//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Table(name = "produkt")
//
//public class Produkt {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_produktu", nullable = false, unique = true, insertable = false, updatable = false)
//    private int id_produktu;
//    @Column(name = "ilosc_dostepnych")
//    private int ilosc_dostepnych;
//    @Column(name = "cena")
//    private Float cena;
//    @Column(name = "nazwa")
//    private String nazwa;
//    @Column(name = "wymiary")
//    private String wymiary;
//    @Column(name = "waga")
//    private String waga;
//
//    @OneToMany(
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            mappedBy = "produkt"
//    )
//    private Set<Zamowienie> zamowienia = new HashSet<Zamowienie>();
//
//    public Produkt() {
//    }
//
//    public Produkt(int ilosc_dostepnych, Float cena, String nazwa, String wymiary, String waga ) {
//        this.ilosc_dostepnych = ilosc_dostepnych;
//        this.cena = cena;
//        this.nazwa = nazwa;
//        this.wymiary = wymiary;
//        this.waga = waga;
//
//    }
//
//    public int getId_produktu() {
//        return id_produktu;
//    }
//
//    public void setId_produktu(int id_produktu) {
//        this.id_produktu = id_produktu;
//    }
//
//    public int getIlosc_dostepnych() {
//        return ilosc_dostepnych;
//    }
//
//    public void setIlosc_dostepnych(int ilosc_dostepnych) {
//        this.ilosc_dostepnych = ilosc_dostepnych;
//    }
//
//    public Float getCena() {
//        return cena;
//    }
//
//    public void setCena(Float cena) {
//        this.cena = cena;
//    }
//
//    public String getNazwa() {
//        return nazwa;
//    }
//
//    public void setNazwa(String nazwa) {
//        this.nazwa = nazwa;
//    }
//
//    public String getWymiary() {
//        return wymiary;
//    }
//
//    public void setWymiary(String wymiary) {
//        this.wymiary = wymiary;
//    }
//
//    public String getWaga() {
//        return waga;
//    }
//
//    public void setWaga(String waga) {
//        this.waga = waga;
//    }
//
//}
