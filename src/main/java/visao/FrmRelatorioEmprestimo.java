package visao;

import static dao.AmigoDAO.ListaAmigo;
import modelo.Emprestimo;
import static dao.FerramentaDAO.ListaFerramentas;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashMap;
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
        this.AtualizarAmigoMaisRepetido();
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
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JBApagar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

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
                "Id Emprestimo", "Nome Amigo", "Nome Ferramenta", "Data Inicio", "Data Devolução", "Ativo"
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nome do Amigo :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Nome do Ferramenta :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Data Inicio :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Data Devolução :");

        JBApagar.setText("Apagar");
        JBApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBApagarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8)
                                    .addGap(527, 527, 527))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JBApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel10))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel9))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(6, 6, 6)
                                            .addComponent(JLId)
                                            .addGap(213, 213, 213)
                                            .addComponent(jLabel4)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLId)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JBApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        // Cancela a ação
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JTEmprestimosAtivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTEmprestimosAtivosMouseClicked
        // TODO add your handling code here:
       try {
            if (this.JTEmprestimosAtivos.getSelectedRow() != -1) {
                int selectedRow = this.JTEmprestimosAtivos.getSelectedRow();

                Object idObj = this.JTEmprestimosAtivos.getValueAt(selectedRow, 0);
                Object nomeAmigoObj = this.JTEmprestimosAtivos.getValueAt(selectedRow, 1);
                Object nomeFerramentaObj = this.JTEmprestimosAtivos.getValueAt(selectedRow, 2);
                Object dataEmpObj = this.JTEmprestimosAtivos.getValueAt(selectedRow, 3);
                Object dataDevObj = this.JTEmprestimosAtivos.getValueAt(selectedRow, 4);

                JLId.setText(idObj != null ? idObj.toString() : "");
                JLId.setVisible(true);
                jLabel8.setText(nomeAmigoObj != null ? nomeAmigoObj.toString() : "");
                jLabel9.setText(nomeFerramentaObj != null ? nomeFerramentaObj.toString() : "");
                jLabel10.setText(dataEmpObj != null ? dataEmpObj.toString() : "");
                jLabel11.setText(dataDevObj != null ? dataDevObj.toString() : "FERRAMENTA NUNCA DEVOLVIDA");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao selecionar empréstimo: " + e.getMessage());
        }    
    }//GEN-LAST:event_JTEmprestimosAtivosMouseClicked

    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBApagarActionPerformed

        emprestimo.deleteEmprestimoBD(Integer.parseInt(JLId.getText()));
        JLId.setVisible(false);
        jLabel8.setText("");
        jLabel9.setText("");
        jLabel10.setText("");
        jLabel11.setText("");
        this.CarregaListaEmprestimo();
    }//GEN-LAST:event_JBApagarActionPerformed

            
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
ArrayList<Ferramenta> listaFerramentas = ferramenta.ListaFerramenta();
ArrayList<Amigo> listaAmigos = amigo.ListaAmigo();

for (int i = 0; i < listaEmprestimo.size(); i++) {
    String nomeFerramenta = "";
    String nomeAmigo = ""; 
    
   
    for (Ferramenta ferramenta : listaFerramentas) {
        if (ferramenta.getIdFerramentas() == listaEmprestimo.get(i).getIdFerramentas()) {
            nomeFerramenta = ferramenta.getNomeFerramentas(); 
            break; 
        }
    }
    
    // Procura o amigo correspondente ao ID do empréstimo
    for (Amigo amigo : listaAmigos) {
        if (amigo.getIdAmigo() == listaEmprestimo.get(i).getIdAmigo()) {
            nomeAmigo = amigo.getNomeAmigo(); 
            break; 
        }
    }
    
   
    model.addRow(new Object[]{
        listaEmprestimo.get(i).getIdEmprestimo(),
        
        nomeAmigo, 
        nomeFerramenta, 
        listaEmprestimo.get(i).getDataEmp(),
        listaEmprestimo.get(i).getDataDev(),
        listaEmprestimo.get(i).emprestimoAtivo(listaEmprestimo.get(i).getIdEmprestimo())
    });
}
}

private String amigoMaisRepetido() {
        HashMap<String, Integer> countMap = new HashMap<>();
        String amigoMaisRepetido = "";
        int maxCount = 0;

        for (int i = 0; i < JTEmprestimosAtivos.getRowCount(); i++) {
            String nomeAmigo = JTEmprestimosAtivos.getValueAt(i, 1).toString();
            countMap.put(nomeAmigo, countMap.getOrDefault(nomeAmigo, 0) + 1);
            int count = countMap.get(nomeAmigo);
            if (count > maxCount) {
                maxCount = count;
                amigoMaisRepetido = nomeAmigo;
            }
        }

        return amigoMaisRepetido;
    }
        
        private void AtualizarAmigoMaisRepetido() {
        String amigoMaisRepetido = amigoMaisRepetido();
        jLabel4.setText("Amigo que mais fez empréstimos: " + amigoMaisRepetido);
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
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JLabel JLId;
    private javax.swing.JTable JTEmprestimosAtivos;
    private javax.swing.JTable JTEmprestimosRealizados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
