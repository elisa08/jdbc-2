package fr.digi.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc implements FournisseurDao{

    ResourceBundle props= ResourceBundle.getBundle("db");
    String url= props.getString("jdbc.url");
    String user= props.getString("jdbc.user");
    String pass= props.getString("jdbc.password");


    @Override
    public List<Fournisseur> extraire() {

        try(Connection connect= DriverManager.getConnection(url, user, pass)) {
            List<Fournisseur> fournisseurs= new ArrayList<>();
            Statement statement= connect.createStatement();
            ResultSet resultat= statement.executeQuery("SELECT * FROM fournisseur");

            while(resultat.next()){

                String nom= resultat.getString("NOM");

                Fournisseur fournisseur= new Fournisseur(nom);
                fournisseurs.add(fournisseur);

            }
            return fournisseurs;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

        @Override
    public void insert(Fournisseur f) {

        try(Connection connect= DriverManager.getConnection(url, user, pass)) {

             String nom2 = f.getNom();

            Statement state= connect.createStatement();

            int resultat= state.executeUpdate("INSERT INTO fournisseur (nom) VALUE ('"+ nom2 +"')");

            System.out.println(resultat);

            state.close();


        } catch (SQLException e) {

             System.out.println(e.getMessage());

        }


    }

    @Override
    public int update(String ancienNom, String nouveauNom) {

        try(Connection connect= DriverManager.getConnection(url, user, pass)) {

            Statement state= connect.createStatement();

            int resultat= state.executeUpdate("UPDATE fournisseur SET nom='"+nouveauNom+"' WHERE nom='"+ancienNom+"'");

            System.out.println(resultat);

            state.close();

            return resultat;



        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }


        return 0;
    }

    @Override
    public boolean delete(Fournisseur f) {

        try(Connection connect= DriverManager.getConnection(url, user, pass)) {

            Statement state= connect.createStatement();

            int resultat= state.executeUpdate("DELETE FROM fournisseur WHERE nom='"+f.getNom()+"'");

            System.out.println(resultat);

            state.close();



        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }


        return false;
    }
}
