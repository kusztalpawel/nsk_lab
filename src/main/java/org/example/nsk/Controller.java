package org.example.nsk;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {
    /*private static final double[][] N01_TABLE = {
            {0.5000, 0.5040, 0.5080, 0.5120, 0.5160, 0.5199, 0.5239, 0.5279, 0.5319, 0.5359},
            {0.5398, 0.5438, 0.5478, 0.5517, 0.5557, 0.5596, 0.5636, 0.5675, 0.5714, 0.5753},
            {0.5793, 0.5832, 0.5871, 0.5910, 0.5918, 0.5987, 0.6026, 0.6064, 0.6103, 0.6141},
            {0.6179, 0.6217, 0.6255, 0.6293, 0.6331, 0.6368, 0.6406, 0.6443, 0.6480, 0.6517},
            {0.6554, 0.6591, 0.6628, 0.6664, 0.6700, 0.6736, 0.6772, 0.6808, 0.6844, 0.6879},
            {0.6915, 0.6950, 0.6985, 0.7019, 0.7054, 0.7088, 0.7123, 0.7157, 0.7190, 0.7224},
            {0.7257, 0.7291, 0.7324, 0.7357, 0.7389, 0.7422, 0.7454, 0.7486, 0.7517, 0.7549},
            {0.7580, 0.7611, 0.7642, 0.7673, 0.7703, 0.7734, 0.7764, 0.7794, 0.7823, 0.7852},
            {0.7881, 0.7910, 0.7939, 0.7967, 0.7995, 0.8023, 0.8051, 0.8078, 0.8106, 0.8133},
            {0.8159, 0.8186, 0.8212, 0.8238, 0.8264, 0.8289, 0.8315, 0.8340, 0.8365, 0.8389},
            {0.8413, 0.8438, 0.8461, 0.8485, 0.8508, 0.8531, 0.8554, 0.8577, 0.8599, 0.8621},
            {0.8643, 0.8665, 0.8686, 0.8708, 0.8729, 0.8749, 0.8770, 0.8790, 0.8810, 0.8830},
            {0.8849, 0.8869, 0.8888, 0.8907, 0.8925, 0.8944, 0.8962, 0.8980, 0.8997, 0.90147},
            {0.90320, 0.90490, 0.90658, 0.90824, 0.90988, 0.91147, 0.91309, 0.91466, 0.91621, 0.91774},
            {0.91924, 0.92073, 0.92220, 0.92364, 0.92507, 0.92647, 0.92785, 0.92922, 0.93056, 0.93189},
            {0.93319, 0.93448, 0.93574, 0.93699, 0.93822, 0.93943, 0.94062, 0.94179, 0.94295, 0.94408},
            {0.94520, 0.94630, 0.94738, 0.94845, 0.94950, 0.95053, 0.95154, 0.95254, 0.95352, 0.95449},
            {0.95543, 0.95637, 0.95728, 0.95818, 0.95907, 0.95994, 0.96060, 0.96164, 0.96246, 0.96327},
            {0.96407, 0.96485, 0.96562, 0.96638, 0.96712, 0.96784, 0.96856, 0.96926, 0.96993, 0.97062},
            {0.97128, 0.97193, 0.97257, 0.97320, 0.97381, 0.97441, 0.97500, 0.97558, 0.97615, 0.97670}};

    private static final double[][] N01_TABLE2 = {
            {0.97725, 0.002, 0.002, 0.002, 0.002, 0.002, 0.002, 0.002, 0.002, 0.002},
            {0.98214, 0.002, 0.002, 0.002, 0.002, 0.002, 0.002, 0.002, 0.002, 0.002},
            {0.98619, 0.002, 0.002, 0.002, 0.002, 0.002, 0.002, 0.002, 0.002, 0.002},
            {0.98928, 0.002, 0.002, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001},
            {0.99180, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001},
            {0.99379, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001}};

    private static final double[][] N01_TABLE3 = {
            {0.99865, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001, 0.001, 0.0001},
            {0.99976, 0.0001, 0.0001, 0.0001, 0.0001, 0.0001, 0.0001, 0.0001, 0.0001, 0.0001},
            {0.9999683},
            {0.9999966},
            {0.99999971},
            {0.999999981},
    };*/

    @FXML
    private TextField txtLiczbaObiektow;

    @FXML
    private TextField txtCzasyNaprawy;

    @FXML
    private TextField txtAlfa;

    @FXML
    private Label lblWynik;

    @FXML
    protected void onClick() {
        try {
            int r = Integer.parseInt(txtLiczbaObiektow.getText().trim());
            double alfa = Double.parseDouble(txtAlfa.getText().trim());

            //Wczytywanie i sortowanie czasów naprawy
            List<Double> czasy = Arrays.stream(txtCzasyNaprawy.getText()
                            .split("[,;\\s]+"))
                    .filter(s -> !s.isEmpty())
                    .map(Double::parseDouble)
                    .sorted()
                    .collect(Collectors.toList());

            if (czasy.size() != r) {
                lblWynik.setText("Błąd: liczba czasów nie zgadza się z liczbą obiektów!");
                return;
            }

            //Obliczanie s*, tn*, s^2, s, tn
            double srednia = czasy.stream().mapToDouble(Double::doubleValue).average().orElse(0);
            double odchylenie = Math.sqrt(czasy.stream().mapToDouble(t -> Math.pow(t - srednia, 2)).sum() / (czasy.size() - 1));

            double s2 = Math.log(Math.pow((odchylenie / srednia),2) + 1);
            double s = Math.sqrt(s2);
            double tsrednie = srednia / Math.exp(0.5 * s2); // ~tn = srednia / exp(1/2*s^2)

            System.out.println("alfa=" + alfa + " tn*=" + srednia + " s*=" + odchylenie + " s^2=" + s2 + " ~tn=" + tsrednie + ", s =" + s);

            //Wyznaczanie  F*, u(i) oraz FH
            List<Double> femp = new ArrayList<>();
            List<Double> fteor = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                double t = czasy.get(i);

                long count = czasy.stream().filter(x -> x <= t).count();
                double f = (double) count / r;

                double u = (Math.log(t / tsrednie)) / s;
                //double fh = standardNormalCDF(u);

                femp.add(f);
                //fteor.add(fh);

                System.out.printf("tn(%d)=%.2f, r[tn]=%d, F* = %.3f, u = %.3f %n", i + 1, t, count, f, u );
            }

            /*
            double dr = 0.0;
            for (int i = 0; i < r; i++) {
                dr = Math.max(dr, Math.abs(femp.get(i) - fteor.get(i)));
            }

            // --- 4️⃣ Wartość krytyczna dla testu KS ---
            double dKryt = kolmogorowKryt(r, alfa);

            // --- 5️⃣ Wypisz wynik ---
            StringBuilder wynik = new StringBuilder();
            wynik.append(String.format("dr = %.4f, dr(1-α)=%.4f%n", dr, dKryt));

            if (dr < dKryt) {
                wynik.append("Czas napraw obiektu jest zgodny z rozkładem logarytmo-normalnym.");
            } else {
                wynik.append("Czas napraw obiektu nie jest zgodny z rozkładem logarytmo-normalnym.");
            }

            lblWynik.setText(wynik.toString());*/

        } catch (Exception ex) {
            System.out.println(ex);
            lblWynik.setText("Błąd danych wejściowych: ");
        }
    }

    //Wybieranie dystrybuanty z tablicy
    /*private double standardNormalCDF(double u) {
        double pom = Math.abs(u);

        int kolumna;
        int wiersz;

        if(pom < 2){
            kolumna = (int) (pom * 10);
            wiersz = (int) ((pom * 100) % 10);
            if(u < 0){
                return 1 - N01_TABLE[kolumna][wiersz];
            } else {
                return N01_TABLE[kolumna][wiersz];
            }
        }

        if(pom > 2 && pom < 2.5){
            kolumna = (int) ((pom - 2) / 0.1);
            wiersz = (int) ((pom * 100) % 10);

            return N01_TABLE2[kolumna][wiersz];

        }

        if(pom > 2.5){
            if(pom < 3)
                return 0.001;

            kolumna = (int) ((pom - 2.5) / 0.5);
            wiersz = (int) ((pom * 100) % 10);

            return N01_TABLE3[kolumna][wiersz];
        }

        return -1;
    }*/
}
