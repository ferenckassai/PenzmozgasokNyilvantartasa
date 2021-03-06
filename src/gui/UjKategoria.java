/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.IModel;
import model.Kategoria;

/**
 *
 * @author ferenc
 */
public class UjKategoria extends javax.swing.JDialog {

    /**
     * Creates new form UjKategoria
     */
    private List<Kategoria> kategoriak;
    private IModel model;

    public UjKategoria(java.awt.Frame parent, boolean modal, List<Kategoria> kategoriak, IModel model) {
        super(parent, modal);
        this.kategoriak = kategoriak;
        this.model = model;
        initComponents();
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBmegse = new javax.swing.JButton();
        jbOK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbTipus = new javax.swing.JComboBox();
        tfNev = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBmegse.setBackground(java.awt.Color.orange);
        jBmegse.setText("Mégse");
        jBmegse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmegseActionPerformed(evt);
            }
        });

        jbOK.setText("OK");
        jbOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOKActionPerformed(evt);
            }
        });

        jLabel1.setText("Név");

        jLabel2.setText("Típus");

        cbTipus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kiadás", "Bevétel" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipus, 0, 211, Short.MAX_VALUE)
                            .addComponent(tfNev)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBmegse)))
                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBmegse, jbOK});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBmegse)
                    .addComponent(jbOK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBmegseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmegseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jBmegseActionPerformed

    private void jbOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOKActionPerformed

        String nev = "";
        boolean oldName = false;
        nev = tfNev.getText();

        int tipus = 2;
        String sTipus = (String) cbTipus.getSelectedItem();

        if (sTipus.equals("Kiadás")) {
            tipus = 1;

        } else {
            tipus = 0;

        }

        if (nev.equals("")) {
            JOptionPane.showMessageDialog(this, "Add meg a kiadás nevét!", "Add meg a neve", JOptionPane.ERROR_MESSAGE);
        }

        if (!nev.equals("")) {

            for (Kategoria k : kategoriak) {

                if (k.getNev().equals(nev)) {
                    JOptionPane.showMessageDialog(this, "Adj meg új nevet!", "Ilyen név már van", JOptionPane.ERROR_MESSAGE);
                    oldName = true;
                }
            }
        }

        if (!oldName) {

            try {
                Kategoria ujKategoria = new Kategoria(nev, tipus);

                model.addKategoria(ujKategoria);

                this.setVisible(false);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex, "Adatbázis hiba", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_jbOKActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbTipus;
    private javax.swing.JButton jBmegse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbOK;
    private javax.swing.JTextField tfNev;
    // End of variables declaration//GEN-END:variables
}
