package fr.digi.jdbc.dao;

import java.sql.SQLException;

public class TestDelete {

    public static void main(String[] args) throws SQLException {

        Fournisseur fournisseur= new Fournisseur("Domergues");

        FournisseurDaoJdbc fdj= new FournisseurDaoJdbc();

        fdj.delete(fournisseur);






    }

}
