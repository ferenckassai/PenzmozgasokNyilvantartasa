/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.IModel;
import model.Kategoria;
import model.Penzmozgas;

/**
 *
 * @author ferenc
 */
public class KategoriaSzerkesztes extends javax.swing.JDialog {

    private DefaultListModel<String> dlm;
    private List<Kategoria> kategoriak;
    private List<Penzmozgas> penzmozgasok;
    private IModel model;

    public KategoriaSzerkesztes(java.awt.Frame parent, boolean modal, List<Kategoria> kategoriak,
            List<Penzmozgas> penzmozgasok, IModel model) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.kategoriak = kategoriak;
        this.penzmozgasok = penzmozgasok;
        this.model = model;
        jlKategoriak.setListData(kategoriak.toArray());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jlKategoriak = new javax.swing.JList();
        jbUj = new javax.swing.JButton();
        jbSzerkeszt = new javax.swing.JButton();
        jbTorol = new javax.swing.JButton();
        jbBezar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jlKategoriak);

        jbUj.setText("Új");
        jbUj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUjActionPerformed(evt);
            }
        });

        jbSzerkeszt.setText("Szerkeszt");
        jbSzerkeszt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSzerkesztActionPerformed(evt);
            }
        });

        jbTorol.setText("Töröl");
        jbTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTorolActionPerformed(evt);
            }
        });

        jbBezar.setBackground(java.awt.Color.orange);
        jbBezar.setText("Bezár");
        jbBezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBezarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbUj, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSzerkeszt)
                    .addComponent(jbBezar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jbUj)
                        .addGap(18, 18, 18)
                        .addComponent(jbSzerkeszt)
                        .addGap(18, 18, 18)
                        .addComponent(jbTorol)
                        .addGap(57, 57, 57)
                        .addComponent(jbBezar)
                        .addGap(10, 10, 10))
                    .addComponent(jScrollPane1))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBezarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jbBezarActionPerformed

    private void jbUjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUjActionPerformed
       UjKategoria ujKategoria = new UjKategoria(null, rootPaneCheckingEnabled, kategoriak, model);
       ujKategoria.setVisible(true);
        try {
            kategoriak = model.getAllKategoria();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Adatbázis hiba", JOptionPane.ERROR_MESSAGE);
        }
        jlKategoriak.setListData(kategoriak.toArray());
    }//GEN-LAST:event_jbUjActionPerformed

    private void jbTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTorolActionPerformed

        List<Kategoria> torlendoList = jlKategoriak.getSelectedValuesList();
        String nemTorolheto = "";
        List<Kategoria> nemTorolhetoId= new ArrayList <>();
        
        
        for (int i = 0; i < torlendoList.size(); i++) {
            for (int j = 0; j < penzmozgasok.size(); j++) {
                if (penzmozgasok.get(j).getIdKategoria() == torlendoList.get(i).getId()) {
                    nemTorolheto = nemTorolheto + torlendoList.get(i).getNev() + "\n";
                    nemTorolhetoId.add(torlendoList.get(i));
                    break;
                }
            }

        }

        if (!nemTorolhetoId.isEmpty()) {
            for (int i = 0; i < nemTorolheto.length(); i++) {
                for (int j = 0; j < torlendoList.size(); j++) {
                    if(torlendoList.get(j).getId() == nemTorolhetoId.get(i).getId()){
                        torlendoList.remove(j);
                    }
                }
            }

        }

        if (!nemTorolheto.equals("")) {
            JOptionPane.showMessageDialog(this, "Az alábbi kategóriák nem törölhetőek, mert még tartohik"
                    + "hozzájuk pénzmozgás: "+"\n" + nemTorolheto, "Nem törölhető kategóriák", JOptionPane.ERROR_MESSAGE);
        }

        if (!torlendoList.isEmpty()) {
            UIManager.put("OptionPane.yesButtonText", "Igen");
            UIManager.put("OptionPane.noButtonText", "Nem");
            int valasz = JOptionPane.showConfirmDialog(this, "Biztosan törölni akarod?", "Tuti?",
                    JOptionPane.YES_NO_OPTION);

            if (valasz == JOptionPane.YES_OPTION) {
                try {
                    for (Kategoria k : torlendoList) {
                        model.removeKategoria(k);
                    }

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(rootPane, ex, "Adatbázis hiba", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        try {
            kategoriak = model.getAllKategoria();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Adatbázis hiba", JOptionPane.ERROR_MESSAGE);
        }
        try {
            kategoriak= model.getAllKategoria();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(rootPane, ex, "Adatbázis hiba", JOptionPane.ERROR_MESSAGE);
        }
        jlKategoriak.setListData(kategoriak.toArray());
    }//GEN-LAST:event_jbTorolActionPerformed

    private void jbSzerkesztActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSzerkesztActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSzerkesztActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBezar;
    private javax.swing.JButton jbSzerkeszt;
    private javax.swing.JButton jbTorol;
    private javax.swing.JButton jbUj;
    private javax.swing.JList jlKategoriak;
    // End of variables declaration//GEN-END:variables
}
