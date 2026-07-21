package modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListePassifs {

    private ArrayList<Passif> lesPassifs;

    // Requis 5 : constructeur par initialisation
    public ListePassifs(String nomFichier) throws IOException {
        lesPassifs = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(nomFichier));
        reader.readLine(); // On saute la ligne d'en-tête

        String ligne;
        while ((ligne = reader.readLine()) != null) {
            String[] donnees = ligne.split(",");

            String id = donnees[0].trim();
            String description = donnees[1].trim();
            double solde = Double.parseDouble(donnees[2].trim());

            Passif p = new Passif(id, description, solde);
            lesPassifs.add(p);
        }

        reader.close();
    }

    // Requis 6 : nbPassifs
    public int nbPassifs() {
        return lesPassifs.size();
    }

    // Requis 7 : getIdPassif
    public String getIdPassif(int indice) {
        return lesPassifs.get(indice).id;
    }

    // Requis 8 : getDescriptionPassif
    public String getDescriptionPassif(int indice) {
        return lesPassifs.get(indice).description;
    }

    // Requis 9 : getSoldePassif
    public double getSoldePassif(int indice) {
        return lesPassifs.get(indice).solde;
    }

    // Requis 10, 11, 12 : getIndicePassif
    public int getIndicePassif(String id) {
        for (int i = 0; i < lesPassifs.size(); i++) {
            if (lesPassifs.get(i).id.equals(id)) {
                return i;
            }
        }
        return -1;
    }

    // Requis 13 : setSoldePassif
    public void setSoldePassif(String id, double nouveauSolde) {
        int indice = getIndicePassif(id);
        lesPassifs.get(indice).solde = nouveauSolde;
    }

    private class Passif {
        private String id;
        private String description;
        private double solde;

        public Passif(String id, String description, double solde) {
            this.id = id;
            this.description = description;
            this.solde = solde;
        }
    }
}