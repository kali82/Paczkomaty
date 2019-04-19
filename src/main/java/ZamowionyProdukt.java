//import javax.persistence.*;
//
//@Entity
//@Table(name = "zamowiony_produkt")
//
//public class ZamowionyProdukt {
//
//
//    @Column(name = "id_zamowienia", nullable = false, unique = true, insertable = false, updatable = false)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_zamowienia")
//    private int id_zamowienia;
//
//    @Column(name = "id_produktu", nullable = false, unique = true, insertable = false, updatable = false)
//    private int id_produktu;
//
//    @Column(name = "ilosc")
//    private int ilosc;
//
//    public ZamowionyProdukt() {
//    }
//
//    public ZamowionyProdukt(int id_zamowienia, int id_produktu, int ilosc) {
//        this.id_zamowienia = id_zamowienia;
//        this.id_produktu = id_produktu;
//        this.ilosc = ilosc;
//    }
//
//    public int getId_zamowienia() {
//        return id_zamowienia;
//    }
//
//    public void setId_zamowienia(int id_zamowienia) {
//        this.id_zamowienia = id_zamowienia;
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
//    public int getIlosc() {
//        return ilosc;
//    }
//
//    public void setIlosc(int ilosc) {
//        this.ilosc = ilosc;
//    }
//
//}
