/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import DAO.DAOMarca;
import Modelo.Marca;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class FormMarca extends javax.swing.JDialog
{

    DAOMarca dao = new DAOMarca();

    public void atualizaTabela()
    {
        listobjetos.clear();
        listobjetos.addAll(dao.getLista());
        int linha = listobjetos.size() - 1;
        if (linha >= 0)
        {
            tblobjetos.setRowSelectionInterval(linha, linha);
            tblobjetos.scrollRectToVisible(
                    tblobjetos.getCellRect(linha, linha, true));
        }

    }

    private void trataEdicao(boolean editando)
    {
        btncancelar.setEnabled(editando);
        btnsalvar.setEnabled(editando);
        btneditar.setEnabled(!editando);
        btnexcluir.setEnabled(!editando);
        btnnovo.setEnabled(!editando);
        btnfechar.setEnabled(!editando);
        btnprimeiro.setEnabled(!editando);
        btnultimo.setEnabled(!editando);
        btnanterior.setEnabled(!editando);
        btnproximo.setEnabled(!editando);
        txtnome.setEditable(editando);

        txttipo.setEditable(editando);
        tblobjetos.setEnabled(!editando);

    }

    public boolean validaCampos()
    {
        if (!(txtnome.getText().length() > 0))
        {

            JOptionPane.showMessageDialog(null, "Insira o nome da marca");
            txtnome.requestFocus();
            return false;
        }

        if (!(txttipo.getText().length() > 0))
        {

            JOptionPane.showMessageDialog(null, "Insira o tipo da marca");
            txttipo.requestFocus();
            return false;
        }

        return true;
    }

    /**
     * Creates new form FormPessoa
     */
    public FormMarca(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        atualizaTabela();
        trataEdicao(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        listobjetos = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Marca>())
        ;
        painelnavegacao = new javax.swing.JPanel();
        btnprimeiro = new javax.swing.JButton();
        btnfechar = new javax.swing.JButton();
        btnanterior = new javax.swing.JButton();
        btnproximo = new javax.swing.JButton();
        btnultimo = new javax.swing.JButton();
        abas = new javax.swing.JTabbedPane();
        abalistagem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblobjetos = new javax.swing.JTable();
        abadados = new javax.swing.JPanel();
        painelacoes = new javax.swing.JPanel();
        btnnovo = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalvar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnome = new javax.swing.JTextField();
        txttipo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelnavegacao.setBackground(new java.awt.Color(8, 77, 110));
        painelnavegacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Navegação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        painelnavegacao.setForeground(new java.awt.Color(51, 51, 51));
        painelnavegacao.setLayout(new java.awt.GridLayout(1, 0));

        btnprimeiro.setBackground(new java.awt.Color(255, 255, 255));
        btnprimeiro.setForeground(new java.awt.Color(51, 51, 51));
        btnprimeiro.setText("Primeiro");
        btnprimeiro.setBorder(null);
        btnprimeiro.setBorderPainted(false);
        btnprimeiro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnprimeiroActionPerformed(evt);
            }
        });
        painelnavegacao.add(btnprimeiro);

        btnfechar.setBackground(new java.awt.Color(255, 255, 255));
        btnfechar.setForeground(new java.awt.Color(51, 51, 51));
        btnfechar.setText("Fechar");
        btnfechar.setBorder(null);
        btnfechar.setBorderPainted(false);
        btnfechar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnfecharActionPerformed(evt);
            }
        });
        painelnavegacao.add(btnfechar);

        btnanterior.setBackground(new java.awt.Color(255, 255, 255));
        btnanterior.setForeground(new java.awt.Color(51, 51, 51));
        btnanterior.setText("Anterior");
        btnanterior.setBorder(null);
        btnanterior.setBorderPainted(false);
        btnanterior.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnanteriorActionPerformed(evt);
            }
        });
        painelnavegacao.add(btnanterior);

        btnproximo.setBackground(new java.awt.Color(255, 255, 255));
        btnproximo.setForeground(new java.awt.Color(51, 51, 51));
        btnproximo.setText("Próximo");
        btnproximo.setBorder(null);
        btnproximo.setBorderPainted(false);
        btnproximo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnproximoActionPerformed(evt);
            }
        });
        painelnavegacao.add(btnproximo);

        btnultimo.setBackground(new java.awt.Color(255, 255, 255));
        btnultimo.setForeground(new java.awt.Color(51, 51, 51));
        btnultimo.setText("Último");
        btnultimo.setBorder(null);
        btnultimo.setBorderPainted(false);
        btnultimo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnultimoActionPerformed(evt);
            }
        });
        painelnavegacao.add(btnultimo);

        abas.setBackground(new java.awt.Color(51, 51, 51));
        abas.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        abalistagem.setBackground(new java.awt.Color(51, 51, 51));
        abalistagem.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));

        tblobjetos.setBackground(new java.awt.Color(8, 77, 110));
        tblobjetos.setForeground(new java.awt.Color(255, 255, 255));
        tblobjetos.setAlignmentX(0.0F);
        tblobjetos.setAlignmentY(0.0F);
        tblobjetos.setCellSelectionEnabled(true);
        tblobjetos.setGridColor(new java.awt.Color(102, 102, 102));
        tblobjetos.setRowHeight(20);
        tblobjetos.setSelectionBackground(new java.awt.Color(8, 77, 110));
        tblobjetos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblobjetos.setShowHorizontalLines(false);
        tblobjetos.setShowVerticalLines(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listobjetos, tblobjetos);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblobjetos);
        tblobjetos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        abalistagem.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        abas.addTab("Listagem", abalistagem);

        abadados.setBackground(new java.awt.Color(218, 218, 218));

        painelacoes.setBackground(new java.awt.Color(255, 255, 255));
        painelacoes.setLayout(new java.awt.GridLayout(1, 0));

        btnnovo.setBackground(new java.awt.Color(8, 77, 110));
        btnnovo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnnovo.setForeground(new java.awt.Color(255, 255, 255));
        btnnovo.setText("Novo");
        btnnovo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnnovoActionPerformed(evt);
            }
        });
        painelacoes.add(btnnovo);

        btneditar.setBackground(new java.awt.Color(8, 77, 110));
        btneditar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btneditar.setForeground(new java.awt.Color(255, 255, 255));
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btneditarActionPerformed(evt);
            }
        });
        painelacoes.add(btneditar);

        btncancelar.setBackground(new java.awt.Color(8, 77, 110));
        btncancelar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btncancelarActionPerformed(evt);
            }
        });
        painelacoes.add(btncancelar);

        btnsalvar.setBackground(new java.awt.Color(8, 77, 110));
        btnsalvar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnsalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnsalvar.setText("Salvar");
        btnsalvar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnsalvarActionPerformed(evt);
            }
        });
        painelacoes.add(btnsalvar);

        btnexcluir.setBackground(new java.awt.Color(8, 77, 110));
        btnexcluir.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnexcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnexcluir.setText("Excluir");
        btnexcluir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnexcluirActionPerformed(evt);
            }
        });
        painelacoes.add(btnexcluir);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Id");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Tipo");

        txtid.setEditable(false);
        txtid.setBackground(new java.awt.Color(218, 218, 218));
        txtid.setForeground(new java.awt.Color(51, 51, 51));
        txtid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 77, 110), 1, true));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblobjetos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.id}"), txtid, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtid.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtidActionPerformed(evt);
            }
        });

        txtnome.setBackground(new java.awt.Color(218, 218, 218));
        txtnome.setForeground(new java.awt.Color(51, 51, 51));
        txtnome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 77, 110), 1, true));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblobjetos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), txtnome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txttipo.setBackground(new java.awt.Color(218, 218, 218));
        txttipo.setForeground(new java.awt.Color(51, 51, 51));
        txttipo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 77, 110), 1, true));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblobjetos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.tipo}"), txttipo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout abadadosLayout = new javax.swing.GroupLayout(abadados);
        abadados.setLayout(abadadosLayout);
        abadadosLayout.setHorizontalGroup(
            abadadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
            .addGroup(abadadosLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(abadadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addGroup(abadadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtnome, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttipo))
                .addGap(29, 555, Short.MAX_VALUE))
        );
        abadadosLayout.setVerticalGroup(
            abadadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abadadosLayout.createSequentialGroup()
                .addComponent(painelacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(abadadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abadadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abadadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 198, Short.MAX_VALUE))
        );

        abas.addTab("Dados", abadados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelnavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(abas, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelnavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abas, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnanteriorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnanteriorActionPerformed
    {//GEN-HEADEREND:event_btnanteriorActionPerformed
        int linhaSelecionada = tblobjetos.getSelectedRow();

        if (linhaSelecionada - 1 >= 0)
        {
            linhaSelecionada--;
        }

        tblobjetos.setRowSelectionInterval(linhaSelecionada, linhaSelecionada);
        tblobjetos.scrollRectToVisible(tblobjetos.getCellRect(linhaSelecionada, 0, true));
    }//GEN-LAST:event_btnanteriorActionPerformed

    private void btnfecharActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnfecharActionPerformed
    {//GEN-HEADEREND:event_btnfecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnfecharActionPerformed

    private void btnprimeiroActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnprimeiroActionPerformed
    {//GEN-HEADEREND:event_btnprimeiroActionPerformed
        tblobjetos.setRowSelectionInterval(0, 0);
        tblobjetos.scrollRectToVisible(tblobjetos.getCellRect(0, 0, true));
    }//GEN-LAST:event_btnprimeiroActionPerformed

    private void btnproximoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnproximoActionPerformed
    {//GEN-HEADEREND:event_btnproximoActionPerformed
        int linhaSelecionada = tblobjetos.getSelectedRow();

        if (linhaSelecionada + 1 <= tblobjetos.getRowCount())
        {
            linhaSelecionada++;
        }

        tblobjetos.setRowSelectionInterval(linhaSelecionada, linhaSelecionada);
        tblobjetos.scrollRectToVisible(tblobjetos.getCellRect(linhaSelecionada, 0, true));
    }//GEN-LAST:event_btnproximoActionPerformed

    private void btnultimoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnultimoActionPerformed
    {//GEN-HEADEREND:event_btnultimoActionPerformed
        int linhaSelecionada = tblobjetos.getRowCount() - 1;

        tblobjetos.setRowSelectionInterval(linhaSelecionada, linhaSelecionada);
        tblobjetos.scrollRectToVisible(tblobjetos.getCellRect(linhaSelecionada, 0, true));
    }//GEN-LAST:event_btnultimoActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtidActionPerformed
    {//GEN-HEADEREND:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnexcluirActionPerformed
    {//GEN-HEADEREND:event_btnexcluirActionPerformed
        int opcao = JOptionPane.showOptionDialog(null, "Confirma a exclusão?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]
        {
            "Sim", "Não"
        }, "Sim");
        if (opcao == 0)
        {
            int linhaSelecionada = tblobjetos.getSelectedRow();
            Marca obj = listobjetos.get(linhaSelecionada);
            dao.remover(obj);
            atualizaTabela();
        }

    }//GEN-LAST:event_btnexcluirActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnsalvarActionPerformed
    {//GEN-HEADEREND:event_btnsalvarActionPerformed
        if (validaCampos())
        {
            int linhaSelecianada = tblobjetos.getSelectedRow();
            Marca obj;
            obj = listobjetos.get(linhaSelecianada);
            dao.salvar(obj);
            trataEdicao(false);
            atualizaTabela();
        }

    }//GEN-LAST:event_btnsalvarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btncancelarActionPerformed
    {//GEN-HEADEREND:event_btncancelarActionPerformed
        trataEdicao(false);
        atualizaTabela();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btneditarActionPerformed
    {//GEN-HEADEREND:event_btneditarActionPerformed
        trataEdicao(true);
        txtnome.requestFocus();
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnnovoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnnovoActionPerformed
    {//GEN-HEADEREND:event_btnnovoActionPerformed
        listobjetos.add((Marca) new Marca());
        int linha = listobjetos.size() - 1;
        tblobjetos.setRowSelectionInterval(linha, linha);
        txtnome.requestFocus();
        trataEdicao(true);
    }//GEN-LAST:event_btnnovoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(FormMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FormMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FormMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FormMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                FormMarca dialog = new FormMarca(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abadados;
    private javax.swing.JPanel abalistagem;
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton btnanterior;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnfechar;
    private javax.swing.JButton btnnovo;
    private javax.swing.JButton btnprimeiro;
    private javax.swing.JButton btnproximo;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JButton btnultimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<Marca> listobjetos;
    private javax.swing.JPanel painelacoes;
    private javax.swing.JPanel painelnavegacao;
    private javax.swing.JTable tblobjetos;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txttipo;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}