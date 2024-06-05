/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

/**
 *
 * @author guiho
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenuPrincipal
     */
    public FrmMenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuGerenciamentoGeral = new javax.swing.JMenu();
        jMenuItemCadastroDeFerramentas = new javax.swing.JMenuItem();
        jMenuItemCadastroDeAmigos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemEmprestimoDeFerramentas = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemGerenciamentoDeFerramentas = new javax.swing.JMenuItem();
        jMenuItemGerenciadorAmigo = new javax.swing.JMenuItem();
        jMenuItemRelatorio = new javax.swing.JMenuItem();
        jMenuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuGerenciamentoGeral.setText("Cadastrar");

        jMenuItemCadastroDeFerramentas.setText("Cadastro de Ferramentas");
        jMenuItemCadastroDeFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroDeFerramentasActionPerformed(evt);
            }
        });
        jMenuGerenciamentoGeral.add(jMenuItemCadastroDeFerramentas);

        jMenuItemCadastroDeAmigos.setText("Cadastro de Amigos");
        jMenuItemCadastroDeAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroDeAmigosActionPerformed(evt);
            }
        });
        jMenuGerenciamentoGeral.add(jMenuItemCadastroDeAmigos);

        jMenuBar1.add(jMenuGerenciamentoGeral);

        jMenu2.setText("Emprestimos");

        jMenuItemEmprestimoDeFerramentas.setText("Emprestimo de Ferramentas");
        jMenuItemEmprestimoDeFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEmprestimoDeFerramentasActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemEmprestimoDeFerramentas);

        jMenuItem1.setText("Devolver Ferramentas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Gerenciar");

        jMenuItemGerenciamentoDeFerramentas.setText("Gerenciamento de Ferramentas");
        jMenuItemGerenciamentoDeFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciamentoDeFerramentasActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGerenciamentoDeFerramentas);

        jMenuItemGerenciadorAmigo.setText("Gerenciador de Amigos");
        jMenuItemGerenciadorAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciadorAmigoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGerenciadorAmigo);

        jMenuItemRelatorio.setText("Gerenciar Emprestimos");
        jMenuItemRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemRelatorio);

        jMenuBar1.add(jMenu1);

        jMenuSobre.setText("Sobre");
        jMenuBar1.add(jMenuSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastroDeAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroDeAmigosActionPerformed
        // TODO add your handling code here:
        FrmCadastrarAmigo tela = new FrmCadastrarAmigo();

        tela.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemCadastroDeAmigosActionPerformed

    private void jMenuItemCadastroDeFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroDeFerramentasActionPerformed
        // TODO add your handling code here:
        FrmCadastrarFerramenta tela = new FrmCadastrarFerramenta();

        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroDeFerramentasActionPerformed

    private void jMenuItemGerenciamentoDeFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciamentoDeFerramentasActionPerformed
        // TODO add your handling code here:
         FrmGerenciamentoDeFerramentas objeto = new FrmGerenciamentoDeFerramentas();
         objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemGerenciamentoDeFerramentasActionPerformed

    private void jMenuItemEmprestimoDeFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEmprestimoDeFerramentasActionPerformed
        // TODO add your handling code here:
        FrmEmprestimoDeFerramentas objeto = new FrmEmprestimoDeFerramentas();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemEmprestimoDeFerramentasActionPerformed

    private void jMenuItemGerenciadorAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciadorAmigoActionPerformed
        // TODO add your handling code here:
        FrmGerenciadorAmigo amigo = new FrmGerenciadorAmigo();

        amigo.setVisible(true);
    }//GEN-LAST:event_jMenuItemGerenciadorAmigoActionPerformed

    private void jMenuItemRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioActionPerformed
        // TODO add your handling code here:
        FrmRelatorioEmprestimo menu = new FrmRelatorioEmprestimo();
        menu.setVisible (true);
    }//GEN-LAST:event_jMenuItemRelatorioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        FrmDevolverFerramentas objeto = new FrmDevolverFerramentas();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuGerenciamentoGeral;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemCadastroDeAmigos;
    private javax.swing.JMenuItem jMenuItemCadastroDeFerramentas;
    private javax.swing.JMenuItem jMenuItemEmprestimoDeFerramentas;
    private javax.swing.JMenuItem jMenuItemGerenciadorAmigo;
    private javax.swing.JMenuItem jMenuItemGerenciamentoDeFerramentas;
    private javax.swing.JMenuItem jMenuItemRelatorio;
    private javax.swing.JMenu jMenuSobre;
    // End of variables declaration//GEN-END:variables
}
