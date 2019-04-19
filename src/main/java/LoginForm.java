import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class LoginForm {
    private JTable zamowieniaTable;
    private JButton BtnZaloguj;
    private JButton BtnDostawcy;
    private JButton BtnMojeZamowienia;
    private JPanel mainPanel;
    private JButton dodajZamowienieButton;
    private JPanel cardPanel;
    private JPanel mojeZamowieniaPanel;
    private JTable dostawcyTable;
    private JPanel dostawcyPanel;
    private JPanel demoPanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTextField uwagiField;
    private JButton dodajNoweZamowienieBtn;
    private JPanel zalogujPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton zalogujBTN;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JButton toPDF;
    private JButton pdfDostawcy;
    private JPanel loginPanel;
    private JPanel panelDemo;

    private static final Logger logger =  Logger.getLogger(LoginForm.class);

    private static EntityManagerFactory entityManagerFactory;
    private  static EntityManager entityManager;

    static Dostawca dostawca;

    static JFrame jFrame = new JFrame();

    public LoginForm() {
        cardPanel.removeAll();
        cardPanel.repaint();
        cardPanel.revalidate();

        cardPanel.add(dostawcyPanel);
        cardPanel.repaint();
        cardPanel.revalidate();

        final List<Dostawca> dostawcaList = new ArrayList<Dostawca>();

        entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.jpa" );
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
        CriteriaQuery<Dostawca> criteria = builder.createQuery(Dostawca.class);
        Root<Dostawca> dostawcaRoot = criteria.from(Dostawca.class);
        criteria.select(dostawcaRoot);

        List<Dostawca> dostwacyList = entityManager.createQuery(criteria).getResultList();

        for(int i=0; i < dostwacyList.size(); i++){
            comboBox1.addItem(dostwacyList.get(i).getImie());
        }

        CriteriaBuilder builder2 = entityManagerFactory.getCriteriaBuilder();
        CriteriaQuery<Klient> criteria2 = builder2.createQuery(Klient.class);
        final Root<Klient> klientRoot = criteria2.from(Klient.class);
        criteria2.select(klientRoot);

        final List<Klient> klienci = entityManager.createQuery(criteria2).getResultList();

        for(int i=0; i < klienci.size(); i++){
            comboBox2.addItem(klienci.get(i).getNazwisko());
        }

        CriteriaBuilder builder3 = entityManagerFactory.getCriteriaBuilder();
        CriteriaQuery<PunktOdbioru> criteria3 = builder3.createQuery(PunktOdbioru.class);
        final Root<PunktOdbioru> punktOdbioruRoot = criteria3.from(PunktOdbioru.class);
        criteria3.select(punktOdbioruRoot);

        List<PunktOdbioru> punkty = entityManager.createQuery(criteria3).getResultList();

        for(int i=0; i < punkty.size(); i++){
            comboBox3.addItem(punkty.get(i).getIlosc_miejsc());
        }


        entityManager.getTransaction().commit();

        entityManager.close();



        BtnZaloguj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                cardPanel.removeAll();
                cardPanel.repaint();
                cardPanel.revalidate();

                cardPanel.add(zalogujPanel);
                cardPanel.repaint();
                cardPanel.revalidate();


//                Zamowienie zamowienie1 = new Zamowienie("asdasd",dostawca);
//                Zamowienie zamowienie2 = new Zamowienie("asdasdasdasd", dostawca);


//
//                List<Zamowienie> zamowienia = new ArrayList<Zamowienie>();
//                Zamowienie zamowienie1 =  new Zamowienie(dostawca.getId_dostawcy(),16,17,"brak uwag",dostawca);
//                zamowienia.add(zamowienie1);
//
//                //zamowienie1.setDostawca(dostawca);
//                dostawca.add(zamowienie1);
//
//                for (int i=0; i< dostawca.getZamowienia().size(); i++){
//                    System.out.println(dostawca.getZamowienia().get(i).getId_punktu()+" UWAGI: "+ dostawca.getZamowienia().get(i).getUwagi());
//                }
//
//                entityManager.getTransaction().commit();


            }
        });
        BtnDostawcy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                dostawcyPanel.setVisible(true);

                cardPanel.removeAll();
                cardPanel.repaint();
                cardPanel.revalidate();

                cardPanel.add(dostawcyPanel);
                cardPanel.repaint();
                cardPanel.revalidate();

                entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.jpa" );
                entityManager = entityManagerFactory.createEntityManager();

                entityManager.getTransaction().begin();

                DefaultTableModel defaultTableModel = new DefaultTableModel();
                defaultTableModel.addColumn("Imie");
                defaultTableModel.addColumn("Nazwisko");
                defaultTableModel.addColumn("Email");
                defaultTableModel.addColumn("Ilość zamówień");

                CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
                CriteriaQuery<Dostawca> criteria = builder.createQuery(Dostawca.class);
                Root<Dostawca> dostawcaRoot = criteria.from(Dostawca.class);
                criteria.select(dostawcaRoot);

                List<Dostawca> dostwacyList = entityManager.createQuery(criteria).getResultList();
                for (int i = 0; i < dostwacyList.size(); i++) {
                    defaultTableModel.addRow(new String[]{dostwacyList.get(i).getImie(),
                            dostwacyList.get(i).getNazwisko(), dostwacyList.get(i).getEmail(),
                            String.valueOf(dostwacyList.get(i).getZamowienia().size())});
                }

                dostawcyTable.setModel(defaultTableModel);

                entityManager.getTransaction().commit();

                entityManager.close();



            }
        });
        BtnMojeZamowienia.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent actionEvent) {
                mojeZamowieniaPanel.setVisible(true);
                cardPanel.removeAll();
                cardPanel.repaint();
                cardPanel.revalidate();
                cardPanel.add(mojeZamowieniaPanel);
                cardPanel.repaint();
                cardPanel.revalidate();
                entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.jpa" );
                entityManager = entityManagerFactory.createEntityManager();
                entityManager.getTransaction().begin();
                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery<Zamowienie> criteriaQuery = criteriaBuilder.createQuery(Zamowienie.class);
                Root<Zamowienie> root = criteriaQuery.from(Zamowienie.class);
                criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id_dostawcy"), dostawca.getId_dostawcy()));
                TypedQuery<Zamowienie> query = entityManager.createQuery(criteriaQuery);
                List<Zamowienie> zamowienia  = query.getResultList();

                DefaultTableModel defaultTableModel = new DefaultTableModel();
                defaultTableModel.addColumn("Numer");
                defaultTableModel.addColumn("Klient");
                defaultTableModel.addColumn("Adres Odbioru");
                defaultTableModel.addColumn("Wolne miejsca");
                defaultTableModel.addColumn("Uwagi");

                for(int i=0; i < zamowienia.size(); i++){

                    defaultTableModel.addRow(new String[]{String.valueOf(zamowienia.get(i).getId_zamowienia()),
                            zamowienia.get(i).getKlient().getNazwisko(),
                            zamowienia.get(i).getPunktOdbioru().getAdres(),
                            String.valueOf(zamowienia.get(i).getPunktOdbioru().getIlosc_miejsc()),
                            zamowienia.get(i).getUwagi()});
                }
                zamowieniaTable.setModel(defaultTableModel);
                entityManager.getTransaction().commit();
                entityManager.close();

            }
        });
        dodajZamowienieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                demoPanel.setVisible(true);

                cardPanel.removeAll();
                cardPanel.repaint();
                cardPanel.revalidate();

                cardPanel.add(demoPanel);
                cardPanel.repaint();
                cardPanel.revalidate();


            }
        });
        dodajNoweZamowienieBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.jpa" );
                entityManager = entityManagerFactory.createEntityManager();

                entityManager.getTransaction().begin();

                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery<Dostawca> criteriaQuery = criteriaBuilder.createQuery(Dostawca.class);
                Root<Dostawca> root = criteriaQuery.from(Dostawca.class);
                criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("imie"), comboBox1.getSelectedItem()));
                TypedQuery<Dostawca> query = entityManager.createQuery(criteriaQuery);
                Dostawca dostawca  = query.getSingleResult();


                CriteriaBuilder criteriaBuilder2 = entityManager.getCriteriaBuilder();
                CriteriaQuery<Klient> criteriaQuery2 = criteriaBuilder2.createQuery(Klient.class);
                Root<Klient> klientRoot = criteriaQuery2.from(Klient.class);
                criteriaQuery2.select(klientRoot).where(criteriaBuilder2.equal(klientRoot.get("nazwisko"), comboBox2.getSelectedItem()));
                TypedQuery<Klient> query2 = entityManager.createQuery(criteriaQuery2);
                Klient klient  = query2.getSingleResult();



                CriteriaBuilder criteriaBuilder3 = entityManager.getCriteriaBuilder();
                CriteriaQuery<PunktOdbioru> criteriaQuery3 = criteriaBuilder3.createQuery(PunktOdbioru.class);
                Root<PunktOdbioru> punktOdbioruRoot = criteriaQuery3.from(PunktOdbioru.class);
                criteriaQuery3.select(punktOdbioruRoot).where(criteriaBuilder3.equal(punktOdbioruRoot.get("ilosc_miejsc"), comboBox3.getSelectedItem()));
                TypedQuery<PunktOdbioru> query3 = entityManager.createQuery(criteriaQuery3);
                PunktOdbioru punktOdbioru  = query3.getSingleResult();

                Zamowienie zamowienie = new Zamowienie();
                zamowienie.setKlient(klient);
                zamowienie.setDostawca(dostawca);
                zamowienie.setPunktOdbioru(punktOdbioru);
                zamowienie.setUwagi(uwagiField.getText());
                zamowienie.setId_dostawcy(dostawca.getId_dostawcy());
                zamowienie.setId_klienta(klient.getId_klienta());
                zamowienie.setId_punktu(punktOdbioru.getId_punktu());

//                CriteriaBuilder criteriaBuilder4 = entityManager.getCriteriaBuilder();
//                CriteriaQuery<Zamowienie> criteriaQuery4 = criteriaBuilder4.createQuery(Zamowienie.class);
//                Root<Zamowienie> zamowienieRoot = criteriaQuery4.from(Zamowienie.class);
//                criteriaQuery4.select(zamowienieRoot).where(criteriaBuilder.equal(root.get("id_dostawcy"), dostawca.getId_dostawcy()));
//                TypedQuery<Zamowienie> query = entityManager.createQuery(criteriaQuery);
//                List<Zamowienie> zamowienia  = query.getResultList();

               entityManager.persist(zamowienie);

               entityManager.getTransaction().commit();
               entityManager.close();
            }
        });
        zalogujBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.jpa" );
                entityManager = entityManagerFactory.createEntityManager();

                entityManager.getTransaction().begin();

                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery<Dostawca> criteriaQuery = criteriaBuilder.createQuery(Dostawca.class);
                Root<Dostawca> root = criteriaQuery.from(Dostawca.class);
                criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), textField2.getText()));
                TypedQuery<Dostawca> query = entityManager.createQuery(criteriaQuery);
                dostawca = query.getSingleResult();
                if(!(dostawca==null) && dostawca.getNazwisko().equals(textField1.getText())){
                    JOptionPane.showMessageDialog(null,"zalogowano: " + dostawca.getImie());
                }

                entityManager.getTransaction().commit();

                entityManager.close();
            }
        });
       toPDF.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent actionEvent) {
            createPdf(zamowieniaTable);
           }
       });
//
//                int row = zamowieniaTable.getSelectedRow();
//                int id_zamowienia = zamowieniaTable.getValueAt(row, 0);
//
//                Zamowienie zamowienie = (Zamowienie) entityManager.createQuery("SELECT z FROM Zamowienie z where z.id_zamowienia = :id_zamowienia").setParameter("id_zamowienia", id_zamowienia).getSingleResult();
//
//                entityManager.getTransaction().begin();
//                entityManager.remove(zamowienie);
//                entityManager.getTransaction().commit();
//            }
//
//
//        });
        pdfDostawcy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                createPdf(dostawcyTable);
            }
        });
    }

    public void createPdf(JTable table) {
        com.itextpdf.text.Document document = new Document();
        try {
            PdfWriter writer;
                writer = PdfWriter.getInstance(document,
                        new FileOutputStream("mojaTabela.pdf"));

            document.open();
            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate tp = cb.createTemplate(500, 500);
            Graphics2D g2;

            g2 = tp.createGraphicsShapes(500, 500);

            table.print(g2);
            g2.dispose();
            cb.addTemplate(tp, 30, 300);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        document.close();
    }

    public static void main(String args[]){
        LoginForm loginForm = new LoginForm();
        jFrame.setDefaultCloseOperation(3);
        jFrame.getContentPane().add(loginForm.mainPanel);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
