package visao;

import static dao.AmigoDAO.ListaAmigo;
import modelo.Emprestimo;
import dao.EmprestimoDAO;
import static dao.EmprestimoDAO.ListaEmprestimo;
import static dao.FerramentaDAO.ListaFerramentas;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import modelo.Amigo;
import modelo.Ferramenta;

public class FrmRelatorioEmprestimo extends javax.swing.JFrame {

    private Emprestimo emprestimo;
    private Amigo amigo;
    private Ferramenta ferramenta;

    
    public FrmRelatorioEmprestimo() {
        initComponents();
        this.emprestimo = new Emprestimo();
        this.ferramenta = new Ferramenta();
        this.amigo = new Amigo();
        this.CarregaListaEmprestimo();
    }

    /**
     * Este método é chamado de dentro do construtor para inicializar o formulário.
     * AVISO: NÃO modifique este código. O conteúdo deste método é sempre
     * regenerado pelo Editor de Formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        JTEmprestimosRealizados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTEmprestimosAtivos = new javax.swing.JTable();
        JBCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLId = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JTFNomeAmigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JTFNomeFerramenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTFDataEmp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JTFDataEmp1 = new javax.swing.JTextField();

        JTEmprestimosRealizados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Ferramenta", "Tempo", "ID"
            }
        ));
        jScrollPane2.setViewportView(JTEmprestimosRealizados);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Gerenciador de Emprestimos");

        JTEmprestimosAtivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Emprestimo", "Nome Amigo", "Id/Nome Ferramenta", "Data Inicio", "Data Devolução", "Ativo"
            }
        ));
        JTEmprestimosAtivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTEmprestimosAtivosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTEmprestimosAtivos);

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Amigo que mais fez emprestimos :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Id do Empréstimo :");

        JLId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLId.setText("0");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nome do Amigo :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Nome do Ferramenta :");

        JTFNomeFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeFerramentaActionPerformed(evt);
            }
        });

        jLabel2.setText("Data Inicio :");

        JTFDataEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFDataEmpActionPerformed(evt);
            }
        });

        jLabel5.setText("Data Emprestimo :");

        JTFDataEmp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFDataEmp1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFDataEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTFDataEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFNomeFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFNomeAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLId)
                                .addGap(237, 237, 237)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JLId)
                        .addComponent(jLabel4))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JTFNomeAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JTFNomeFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFDataEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JTFDataEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        // Cancela a ação
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JTFNomeFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeFerramentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNomeFerramentaActionPerformed

    private void JTEmprestimosAtivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTEmprestimosAtivosMouseClicked
        // TODO add your handling code here:
       if (this.JTEmprestimosAtivos.getSelectedRow() != -1) {
            JLId.setText(JTEmprestimosAtivos.getValueAt(this.JTEmprestimosAtivos.getSelectedRow(),0).toString());
            JLId.setVisible(true);
            JTFNomeAmigo.setText(JTEmprestimosAtivos.getValueAt(this.JTEmprestimosAtivos.getSelectedRow(),1).toString());
            JTFNomeFerramenta.setText(JTEmprestimosAtivos.getValueAt(this.JTEmprestimosAtivos.getSelectedRow(),2).toString());
            JTFDataEmp1.setText(JTEmprestimosAtivos.getValueAt(this.JTEmprestimosAtivos.getSelectedRow(),3).toString());
            JTFDataEmp.setText(JTEmprestimosAtivos.getValueAt(this.JTEmprestimosAtivos.getSelectedRow(),4).toString());
            
            
            
        }
    }//GEN-LAST:event_JTEmprestimosAtivosMouseClicked

    private void JTFDataEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFDataEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFDataEmpActionPerformed

    private void JTFDataEmp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFDataEmp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFDataEmp1ActionPerformed
    private int getIdFerramentaPorNome(String nomeFerramenta) {
    for (Ferramenta ferramenta : ListaFerramentas) {
        if (ferramenta.getNomeFerramentas().equals(nomeFerramenta)) {
            return ferramenta.getIdFerramentas();
        }
    }
    return -1; // Retorna -1 se não encontrar
    }
    
    private int getIdAmigoPorNome(String nomeAmigo) {
    for (Amigo amigo : ListaAmigo) {
        if (amigo.getNomeAmigo().equals(nomeAmigo)) {
            return amigo.getIdAmigo();
        }
    }
    return -1; // Retorna -1 se não encontrar
}
    
    
    

public void CarregaListaEmprestimo() {
DefaultTableModel model = (DefaultTableModel) JTEmprestimosAtivos.getModel();
model.setRowCount(0);
ArrayList<Emprestimo> listaEmprestimo = emprestimo.ListaEmprestimo();
ArrayList<Ferramenta> listaFerramentas = ferramenta.ListaFerramenta(); // Supondo que você tenha uma lista de ferramentas
ArrayList<Amigo> listaAmigos = amigo.ListaAmigo(); // Supondo que você tenha uma lista de amigos

for (int i = 0; i < listaEmprestimo.size(); i++) {
    String nomeFerramenta = ""; // Variável para armazenar o nome da ferramenta
    String nomeAmigo = ""; // Variável para armazenar o nome do amigo
    
    // Procura a ferramenta correspondente ao ID do empréstimo
    for (Ferramenta ferramenta : listaFerramentas) {
        if (ferramenta.getIdFerramentas() == listaEmprestimo.get(i).getIdFerramentas()) {
            nomeFerramenta = ferramenta.getNomeFerramentas(); // Obtém o nome da ferramenta
            break; // Sai do loop assim que encontrar a ferramenta
        }
    }
    
    // Procura o amigo correspondente ao ID do empréstimo
    for (Amigo amigo : listaAmigos) {
        if (amigo.getIdAmigo() == listaEmprestimo.get(i).getIdAmigo()) {
            nomeAmigo = amigo.getNomeAmigo(); // Obtém o nome do amigo
            break; // Sai do loop assim que encontrar o amigo
        }
    }
    
    // Adiciona uma nova linha à tabela com os dados do empréstimo, nome do amigo e nome da ferramenta
    model.addRow(new Object[]{
        listaEmprestimo.get(i).getIdEmprestimo(),
        nomeAmigo, // Nome do amigo ao invés do ID
        nomeFerramenta, // Nome da ferramenta ao invés do ID
        listaEmprestimo.get(i).getDataEmp(),
        listaEmprestimo.get(i).getDataDev(),
        listaEmprestimo.get(i).emprestimoAtivo(listaEmprestimo.get(i).getIdEmprestimo())
    });
}
}







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
            java.util.logging.Logger.getLogger(FrmRelatorioEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorioEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorioEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorioEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRelatorioEmprestimo().setVisible(true);
            }
        });
    }

   



    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCancelar;
    private javax.swing.JLabel JLId;
    private javax.swing.JTable JTEmprestimosAtivos;
    private javax.swing.JTable JTEmprestimosRealizados;
    private javax.swing.JTextField JTFDataEmp;
    private javax.swing.JTextField JTFDataEmp1;
    private javax.swing.JTextField JTFNomeAmigo;
    private javax.swing.JTextField JTFNomeFerramenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
