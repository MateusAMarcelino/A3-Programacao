/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import java.sql.*;
import dao.Utilitario;
import javax.swing.*;
import modelo.Emprestimo;
import modelo.Ferramenta;

/**
 *
 * @author guiho
 */
public class FrmEmprestimoDeFerramentas extends javax.swing.JFrame {

    private Emprestimo objetoemprestimo;
    private Utilitario ut;
    private Ferramenta fe;
    /**
     * Creates new form FrmEmprestimoDeFerramentas
     */
    public FrmEmprestimoDeFerramentas() {
        initComponents();
        this.objetoemprestimo = new Emprestimo();
        this.ut = new Utilitario();
        this.fe = new Ferramenta();
        inicializarJBCNomeAmigo();
        inicializarJBCNomeFerramenta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTFDataEmprestimo = new javax.swing.JTextField();
        JBConfirmar = new javax.swing.JButton();
        JBCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jCBNomeAmigo = new javax.swing.JComboBox<>();
        jCBNomeFerramenta = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Empréstimo de Ferramentas");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome do Amigo:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Data do Empréstimo:");

        JTFDataEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFDataEmprestimoActionPerformed(evt);
            }
        });

        JBConfirmar.setText("Confirmar");
        JBConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfirmarActionPerformed(evt);
            }
        });

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nome da Ferramenta:");

        jCBNomeAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBNomeAmigoActionPerformed(evt);
            }
        });

        jCBNomeFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBNomeFerramentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JBConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(JTFDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 45, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jCBNomeAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBNomeFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBNomeAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBNomeFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(JTFDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFDataEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFDataEmprestimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFDataEmprestimoActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void inicializarJBCNomeAmigo(){
        try{
            //conexao com o banco de dados
           Statement stmt = ut.getConexao().createStatement();
           //seleciona a coluna nome da tabela amigos
            ResultSet res = stmt.executeQuery("SELECT nome FROM tb_amigos");
            //inserindo os nomes no jComboBox
            while (res.next()) {
                String nome = res.getString("nome");
                jCBNomeAmigo.addItem(nome);
            }
            
            stmt.close();
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
        }
    }
    
    private void inicializarJBCNomeFerramenta(){
        try{
            //conexao com o banco de dados
           Statement stmt = ut.getConexao().createStatement();
           //seleciona a coluna nome da tabela ferramentas
            ResultSet res = stmt.executeQuery("SELECT NomeFerramentas FROM tb_ferramentas");
            //inserindo os ids no jComboBox
            while (res.next()) {
                String NomeFerramentas = res.getString("NomeFerramentas");
                jCBNomeFerramenta.addItem(NomeFerramentas);
            }
            
            stmt.close();
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
        }     
    }
    private void JBConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfirmarActionPerformed
        // TODO add your handling code here:
        try{
            String nome = jCBNomeAmigo.getItemAt(jCBNomeAmigo.getSelectedIndex());
            int Id = jCBNomeFerramenta.getSelectedIndex() +1;
            int data = 0;
            
            if(this.JTFDataEmprestimo.getText().length() <6){
                throw new Mensagem("A data deve conter 6 caracteres");
            }else{
                data = Integer.parseInt(this.JTFDataEmprestimo.getText());
            }
            if(fe.getDisponibilidadeFerramenta() == false){
                JOptionPane.showMessageDialog(null, "A ferramenta está sendo utilizada, selecione outra ferramenta.");
            } else if (this.objetoemprestimo.insertEmprestimoBD(nome, Id, data)){
                JOptionPane.showMessageDialog(null, "Empréstimo registrado com sucesso!");
                fe.emprestar();
                //limpa os campos da interfac
                this.JTFDataEmprestimo.setText("");
            }
            System.out.println(this.objetoemprestimo.getListaEmprestimo().toString());
            
        } catch (Mensagem erro){
            JOptionPane.showMessageDialog(null,erro.getMessage());
        } catch (NumberFormatException erro2){
            JOptionPane.showMessageDialog(null, "Informe um número valido.");
        }
           
            
        
        
    }//GEN-LAST:event_JBConfirmarActionPerformed

    private void jCBNomeAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBNomeAmigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBNomeAmigoActionPerformed

    private void jCBNomeFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBNomeFerramentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBNomeFerramentaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmEmprestimoDeFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEmprestimoDeFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEmprestimoDeFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEmprestimoDeFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEmprestimoDeFerramentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBConfirmar;
    private javax.swing.JTextField JTFDataEmprestimo;
    private javax.swing.JComboBox<String> jCBNomeAmigo;
    private javax.swing.JComboBox<String> jCBNomeFerramenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
