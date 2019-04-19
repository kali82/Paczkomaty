import javax.persistence.*;


@Entity
@Table(name = "zamowienie" )

public class Zamowienie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zamowienia", nullable = false, unique = true)
    private int id_zamowienia;
    @Column(name = "id_dostawcy", insertable = false, updatable = false)
    private int id_dostawcy;
    @Column(name = "id_klienta", insertable = false, updatable = false)
    private int id_klienta;
    @Column(name = "id_punktu", insertable = false, updatable = false)
    private int id_punktu;
    @Column(name = "uwagi")
    private String uwagi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dostawcy")
    private Dostawca dostawca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_klienta")
    private Klient klient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_punktu")
    private PunktOdbioru punktOdbioru;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_produktu")
//    private Produkt produkt;

    public Zamowienie(int id_dostawcy, int id_klienta, int id_punktu, String uwagi) {
        this.id_dostawcy = id_dostawcy;
        this.id_klienta = id_klienta;
        this.id_punktu = id_punktu;
        this.uwagi = uwagi;
    }

    public Zamowienie() {
    }

//    @Override
//    public boolean equals(Object o) {
//        if(this == o) return true;
//        if(!(o instanceof Zamowienie)) return false;
//        return id_zamowienia != null && dostawca.ge
//    }


    public PunktOdbioru getPunktOdbioru() {
        return punktOdbioru;
    }

    public void setPunktOdbioru(PunktOdbioru punktOdbioru) {
        this.punktOdbioru = punktOdbioru;
    }

    public Dostawca getDostawca() {
        return dostawca;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public void setDostawca(Dostawca dostawca) {
        this.dostawca = dostawca;
    }

    public int getId_zamowienia() {
        return id_zamowienia;
    }

    public void setId_zamowienia(int id_zamowienia) {
        this.id_zamowienia = id_zamowienia;
    }

    public int getId_dostawcy() {
        return id_dostawcy;
    }

    public void setId_dostawcy(int id_dostawcy) {
        this.id_dostawcy = id_dostawcy;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public int getId_punktu() {
        return id_punktu;
    }

    public void setId_punktu(int id_punktu) {
        this.id_punktu = id_punktu;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }



    @Override
    public String toString() {
        return "Zamowienie{" +
                "id_zamowienia=" + id_zamowienia +
                ", id_dostawcy=" + id_dostawcy +
                ", id_klienta=" + id_klienta +
                ", id_punktu=" + id_punktu +
                ", uwagi='" + uwagi + '\'' +
                '}';
    }


}
