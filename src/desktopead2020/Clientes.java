/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopead2020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wolfi
 */
public class Clientes extends javax.swing.JFrame {

    private Connection conexao = null;

    public Clientes() {
        initComponents();
        estabeleceConexao();
    }

    public void estabeleceConexao() {

        String nomeDriver = "org.postgresql.Driver";
        String localBancoDados = "jdbc:postgresql://localhost:5432/postgres";
        String usuario = "postgres";
        String senha = "admin";

        try {
            Class.forName(nomeDriver).newInstance();
            conexao = DriverManager.getConnection(localBancoDados, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spGrid = new javax.swing.JScrollPane();
        tbGrid = new javax.swing.JTable();
        btCarrega = new javax.swing.JButton();
        btDinamico = new javax.swing.JButton();
        btMostra = new javax.swing.JButton();
        btExclui = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbGrid.setToolTipText("");
        spGrid.setViewportView(tbGrid);

        btCarrega.setText("Carrega");
        btCarrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCarregaActionPerformed(evt);
            }
        });

        btDinamico.setText("Dinâmico");
        btDinamico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDinamicoActionPerformed(evt);
            }
        });

        btMostra.setText("Mostra");
        btMostra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMostraActionPerformed(evt);
            }
        });

        btExclui.setText("Exclui");
        btExclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spGrid, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(btCarrega)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDinamico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btMostra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExclui)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(spGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDinamico)
                    .addComponent(btCarrega)
                    .addComponent(btMostra)
                    .addComponent(btExclui))
                .addContainerGap(226, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCarregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCarregaActionPerformed

        Vector cabecalho = new Vector();
        cabecalho.add("ID");
        cabecalho.add("Nome");
        cabecalho.add("Endereço");

        Vector matriz = new Vector();

        try {
            if (conexao != null) {
                Statement st = conexao.createStatement();
                ResultSet rs = st.executeQuery("SELECT id, nome, endereco FROM alunos");

                while (rs.next()) {

                    Vector colunas = new Vector();
                    colunas.add(rs.getString("id"));
                    colunas.add(rs.getString("nome"));
                    colunas.add(rs.getString("endereco"));

                    matriz.add(new Vector(colunas));
                }
            } else {
                System.out.println("Problemas na conexão com o banco de dados!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        tbGrid.setModel(new DefaultTableModel(matriz, cabecalho));

    }//GEN-LAST:event_btCarregaActionPerformed

    private void btDinamicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDinamicoActionPerformed
        try {
            Vector cabecalho = new Vector();
            Vector matriz = new Vector();

            if (conexao != null) {
                Statement st = conexao.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM alunos");

                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    cabecalho.add(rs.getMetaData().getColumnName(i + 1));
                }

                while (rs.next()) {
                    Vector colunas = new Vector();
                    for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        colunas.add(rs.getString(i + 1));
                    }
                    matriz.add(new Vector(colunas));
                }
            }
            tbGrid.setModel(new DefaultTableModel(matriz, cabecalho));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btDinamicoActionPerformed

    private void btMostraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostraActionPerformed
        if (tbGrid.getSelectedRow() > -1) {
            Mens.aviso("Conteúdos: "
                    + tbGrid.getValueAt(tbGrid.getSelectedRow(), 0)
                    + tbGrid.getValueAt(tbGrid.getSelectedRow(), 1)
                    + tbGrid.getValueAt(tbGrid.getSelectedRow(), 2)
            );
        } else {
            Mens.erro("Linha não selecionada");
        }
    }//GEN-LAST:event_btMostraActionPerformed

    private void btExcluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluiActionPerformed
        if (tbGrid.getSelectedRow() > -1) {
            try {
                 Statement st = conexao.createStatement();
                 int id = Integer.parseInt(""+tbGrid.getValueAt(tbGrid.getSelectedRow(), 0));
                 st.execute("DELETE FROM alunos WHERE id='" + id + "'");
                 btCarregaActionPerformed(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btExcluiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCarrega;
    private javax.swing.JButton btDinamico;
    private javax.swing.JButton btExclui;
    private javax.swing.JButton btMostra;
    private javax.swing.JScrollPane spGrid;
    private javax.swing.JTable tbGrid;
    // End of variables declaration//GEN-END:variables
}
