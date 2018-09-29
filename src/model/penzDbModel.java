/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ferenc >
 */
public class penzDbModel implements IModel {

    private Connection conn;
    private PreparedStatement getAllPenzmozgas;
    private PreparedStatement AddPenzmozgas;
    private PreparedStatement getAllKategoria;
    private PreparedStatement deletePenzmozgas;
    private PreparedStatement updatePenzmozgas;
    private PreparedStatement deleteKategoria;
    private PreparedStatement updateKategoria;
    private PreparedStatement addKategoria;

    public penzDbModel(Connection conn) throws SQLException {
        this.conn = conn;

        getAllPenzmozgas = conn.prepareStatement("SELECT * FROM penzmozgas ORDER BY datum");
        AddPenzmozgas = conn.prepareStatement("INSERT INTO penzmozgas (osszeg, datum, megjegyzes, kategoria_id)"
                + "VALUES (?,?,?,?) ");
        getAllKategoria = conn.prepareStatement("SELECT * FROM kategoria ORDER BY nev");
        deletePenzmozgas = conn.prepareStatement("DELETE FROM penzmozgas WHERE id=?");
        updatePenzmozgas = conn.prepareStatement("UPDATE penzmozgas SET osszeg=?,"
                + "datum=?, megjegyzes=?, kategoria_id= ? WHERE id=?");
        addKategoria = conn.prepareStatement("INSERT INTO kategoria (nev, tipus) VALUES (?,?)");
        deleteKategoria = conn.prepareStatement("DELETE FROM kategoria WHERE id=?");
        updateKategoria = conn.prepareStatement("UPDATE kategoria SET nev=?, tipus=? WHERE id=?");

    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    @Override
    public List<Kategoria> getAllKategoria() throws SQLException {
        ResultSet rs = getAllKategoria.executeQuery();

        List<Kategoria> kategoriak = new ArrayList<>();

        while (rs.next()) {
            Kategoria kategoria = new Kategoria(rs.getInt("id"), rs.getString("nev"), rs.getInt("tipus"));
            kategoriak.add(kategoria);
        }
        rs.close();
        return kategoriak;
    }

    @Override
    public List<Kategoria> getAllKategoria(int tipus) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addKategoria(Kategoria k) throws SQLException {
        addKategoria.setString(1, k.getNev());
        addKategoria.setInt(2, k.getTipus());
        return addKategoria.executeUpdate();
    }

    @Override
    public int updateKategoria(Kategoria k) throws SQLException {
        updateKategoria.setString(1, k.getNev());
        updateKategoria.setInt(2, k.getTipus());
        updateKategoria.setInt(3, k.getId());
        
       return updateKategoria.executeUpdate();
    }

    @Override
    public int removeKategoria(Kategoria k) throws SQLException {
        deleteKategoria.setInt(1, k.getId());
        return deleteKategoria.executeUpdate();
    }

    @Override
    public List<Penzmozgas> getAllPenzmozgas() throws SQLException {
        ResultSet rs = getAllPenzmozgas.executeQuery();
        List<Penzmozgas> penzmozgasok = new ArrayList<>();

        while (rs.next()) {

            Penzmozgas penzmozgas = new Penzmozgas(rs.getInt("id"), rs.getInt("osszeg"), rs.getDate("datum").toLocalDate(),
                    rs.getString("megjegyzes"), rs.getInt("kategoria_id"));
            penzmozgasok.add(penzmozgas);

        }
        return penzmozgasok;
    }

    @Override
    public List<Penzmozgas> getAllPenzmozgas(int tipus) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Penzmozgas> getAllPenzmozgas(int tipus, Date tol, Date ig) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addPenzmozgas(Penzmozgas p) throws SQLException {

        AddPenzmozgas.setInt(1, p.getOsszeg());
        AddPenzmozgas.setDate(2, java.sql.Date.valueOf(p.getDatum()));
        AddPenzmozgas.setString(3, p.getMegjegyzes());
        AddPenzmozgas.setInt(4, p.getKategoria());
        return AddPenzmozgas.executeUpdate();
    }

    @Override
    public int updatePenzmozgas(Penzmozgas p) throws SQLException {
        updatePenzmozgas.setInt(1, p.getOsszeg());
        updatePenzmozgas.setDate(2, java.sql.Date.valueOf(p.getDatum()));
        updatePenzmozgas.setString(3, p.getMegjegyzes());
        updatePenzmozgas.setInt(4, p.getKategoria());
        updatePenzmozgas.setInt(5, p.getId());

        return updatePenzmozgas.executeUpdate();
    }

    @Override
    public int removePenzmozgas(Penzmozgas p) throws SQLException {
        deletePenzmozgas.setInt(1, p.getId());
        return deletePenzmozgas.executeUpdate();
    }

}
