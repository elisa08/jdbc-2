package fr.digi.jdbc.dao;

import java.sql.SQLException;

public class TestUpdate {

    public static void main(String[] args) throws SQLException {

        Fournisseur fournisseur= new Fournisseur("Domergues");

        FournisseurDaoJdbc fdj= new FournisseurDaoJdbc();

        fdj.update(fournisseur.getNom(),"Domergues");

    }
}
