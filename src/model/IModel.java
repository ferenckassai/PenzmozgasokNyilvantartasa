/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author javaoktatashu
 */
public interface IModel {
    List<Kategoria> getAllKategoria() throws SQLException;
    List<Kategoria> getAllKategoria(int tipus)throws SQLException;
    int addKategoria(Kategoria k)throws SQLException;
    int updateKategoria(Kategoria k)throws SQLException;
    int removeKategoria(Kategoria k)throws SQLException;
    
    List<Penzmozgas> getAllPenzmozgas()throws SQLException;
    List<Penzmozgas> getAllPenzmozgas(int tipus)throws SQLException;
    List<Penzmozgas> getAllPenzmozgas(int tipus,Date tol,Date ig)throws SQLException;
   
       
    int addPenzmozgas(Penzmozgas p)throws SQLException;
    int updatePenzmozgas(Penzmozgas p)throws SQLException;
    int removePenzmozgas(Penzmozgas p)throws SQLException;
    void close()  throws SQLException;
}
