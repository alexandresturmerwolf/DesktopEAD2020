
package desktopead2020;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mbMenuPrincipal = new javax.swing.JMenuBar();
        mmCadastros = new javax.swing.JMenu();
        miClientes = new javax.swing.JMenuItem();
        miFornecedores = new javax.swing.JMenuItem();
        mmMovimentos = new javax.swing.JMenu();
        mmSobre = new javax.swing.JMenu();
        miAutor = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIstema ZYZ");

        mmCadastros.setText("Cadastros");

        miClientes.setText("Clientes");
        miClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miClientesActionPerformed(evt);
            }
        });
        mmCadastros.add(miClientes);

        miFornecedores.setText("Fornecedores");
        mmCadastros.add(miFornecedores);

        mbMenuPrincipal.add(mmCadastros);

        mmMovimentos.setText("Movimentos");
        mbMenuPrincipal.add(mmMovimentos);

        mmSobre.setMnemonic('A');
        mmSobre.setText("Sobre");
        mmSobre.setToolTipText("Informações sobre o autor");

        miAutor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        miAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desktopead2020/coruja.gif"))); // NOI18N
        miAutor.setMnemonic('A');
        miAutor.setText("Autor");
        mmSobre.add(miAutor);

        miSair.setText("Sair do Sistema");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        mmSobre.add(miSair);

        mbMenuPrincipal.add(mmSobre);

        setJMenuBar(mbMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        dispose();
    }//GEN-LAST:event_miSairActionPerformed

    private void miClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miClientesActionPerformed
        Clientes cli = new Clientes();
        cli.setVisible(true);
    }//GEN-LAST:event_miClientesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar mbMenuPrincipal;
    private javax.swing.JMenuItem miAutor;
    private javax.swing.JMenuItem miClientes;
    private javax.swing.JMenuItem miFornecedores;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenu mmCadastros;
    private javax.swing.JMenu mmMovimentos;
    private javax.swing.JMenu mmSobre;
    // End of variables declaration//GEN-END:variables
}
