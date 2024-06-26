/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Amigo;
import modelo.Emprestimo;
import modelo.Ferramenta;

/**
 * Cria um vinculo com o Emprestimo , Amigo e ferramentas.
 * 
 */
public class FrmDevolverFerramentas extends javax.swing.JFrame {
    
    private Emprestimo emprestimo;
    private Amigo amigo;
    private Ferramenta ferramenta;

    /**
     * Cria o FrmDevolverFerramentas, iniciando todos os seus componentes.
     */
    public FrmDevolverFerramentas() {
        emprestimo = new Emprestimo();
        amigo = new Amigo();
        ferramenta = new Ferramenta();
        initComponents();
        this.carregaCBEmprestimo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTFData = new javax.swing.JTextField();
        JTFData.setVisible(false);
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setVisible(false);
        JTFMes = new javax.swing.JTextField();
        JTFMes.setVisible(false);
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setVisible(false);
        JTFAno = new javax.swing.JTextField();
        JTFAno.setVisible(false);
        JBCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JBCadastrar = new javax.swing.JButton();
        JCBEmprestimo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JCBTipoRegistro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTFData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFDataActionPerformed(evt);
            }
        });
        JTFData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFDataKeyTyped(evt);
            }
        });

        jLabel3.setText("/");

        JTFMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFMesActionPerformed(evt);
            }
        });
        JTFMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFMesKeyTyped(evt);
            }
        });

        jLabel4.setText("/");

        JTFAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFAnoActionPerformed(evt);
            }
        });

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Emprestimo:");

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        JCBEmprestimo.setMaximumRowCount(999);

        jLabel2.setText("Data da Devolução");

        JCBTipoRegistro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data Atual", "Data Especifica" }));
        JCBTipoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBTipoRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(JBCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFMes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFAno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCBEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(JCBTipoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCBTipoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(JTFAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCancelar)
                    .addComponent(JBCadastrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFDataActionPerformed

    private void JTFDataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFDataKeyTyped
        if (JTFData.getText().length() == 1) {
            JTFMes.requestFocus();
        }
    }//GEN-LAST:event_JTFDataKeyTyped

    private void JTFMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFMesActionPerformed

    private void JTFMesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFMesKeyTyped
        if (JTFMes.getText().length() == 1) {
            JTFAno.requestFocus();
        }
    }//GEN-LAST:event_JTFMesKeyTyped

    private void JTFAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFAnoActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    /**
     * Cadastra um amigo, pra lista de Emprestimo Ativo,.
     * 
     * @param evt apertar o botão cadastar. 
     */
    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed
     int posicaoEmprestimo = JCBEmprestimo.getSelectedIndex();
        ArrayList<Emprestimo> listaEmprestimo = emprestimo.getListaEmprestimoAtivo();
        Emprestimo emp = new Emprestimo();
        String data = "";
        switch (JCBTipoRegistro.getSelectedIndex()) {
            case 0:
                data = LocalDate.now() + "";
                break;
            case 1:
                data = JTFAno.getText() + "-" + JTFMes.getText() + "-" + JTFData.getText();
        }
        if (emp.updateEmprestimoDB(listaEmprestimo.get(posicaoEmprestimo).getIdEmprestimo(), listaEmprestimo.get(posicaoEmprestimo).getIdAmigo(), listaEmprestimo.get(posicaoEmprestimo).getIdFerramentas(), listaEmprestimo.get(posicaoEmprestimo).getDataEmp(), data + "")) {
            JOptionPane.showMessageDialog(null, "Devolucao cadastrada com sucesso");
            JCBEmprestimo.removeAllItems();
            this.carregaCBEmprestimo();
        } else {

        }
    }//GEN-LAST:event_JBCadastrarActionPerformed

    /*
    * Faz com que ao escolher, data especifica no menu de seleção de data, aparece os JavaTextField para digitar a data.
    */
    private void JCBTipoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBTipoRegistroActionPerformed
        int tipo = JCBTipoRegistro.getSelectedIndex();
        switch (tipo) {
            case 1:
            JTFData.setVisible(true);
            JTFMes.setVisible(true);
            JTFAno.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            break;
            case 0:
            JTFData.setVisible(false);
            JTFMes.setVisible(false);
            JTFAno.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
        }
    }//GEN-LAST:event_JCBTipoRegistroActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDevolverFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDevolverFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDevolverFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDevolverFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDevolverFerramentas().setVisible(true);
            }
        });
    }
/*
    Carrega a tabela dos emprestimos.
    */
    public void carregaCBEmprestimo() {
        Emprestimo emprestimo = new Emprestimo();
        ArrayList<Emprestimo> listaEmprestimo = emprestimo.getListaEmprestimoAtivo();
        ArrayList<Amigo> listaAmigo = amigo.ListaAmigo();
        ArrayList<Ferramenta> listaFerramenta = ferramenta.ListaFerramenta();

        for (Emprestimo objeto : listaEmprestimo) {
            JCBEmprestimo.addItem(objeto.getIdEmprestimo() + " - " + listaAmigo.get(objeto.getIdAmigo() - 1).getNomeAmigo() + " - " + listaFerramenta.get(objeto.getIdFerramentas() - 1).getNomeFerramentas());
        }
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JComboBox<String> JCBEmprestimo;
    private javax.swing.JComboBox<String> JCBTipoRegistro;
    private javax.swing.JTextField JTFAno;
    private javax.swing.JTextField JTFData;
    private javax.swing.JTextField JTFMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
