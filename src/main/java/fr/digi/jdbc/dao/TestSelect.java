package fr.digi.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

public class TestSelect {
    public static void main(String[] args) throws SQLException {


        FournisseurDaoJdbc fdj= new FournisseurDaoJdbc();

        List<Fournisseur> fournisseurs= fdj.extraire();

        for(Fournisseur f : fournisseurs){

            System.out.println(f);

        }

    }
}
