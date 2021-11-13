package fr.digi.jdbc.dao;

import java.sql.SQLException;

public class TestInsertion {

    public static void main(String[] args) throws SQLException {

        Fournisseur fournisseur= new Fournisseur("Domergues");

        FournisseurDaoJdbc fdj= new FournisseurDaoJdbc();

        fdj.insert(fournisseur);

    }

}
