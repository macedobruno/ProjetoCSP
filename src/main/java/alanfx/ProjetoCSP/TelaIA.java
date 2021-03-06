/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Herbert
 */

package alanfx.ProjetoCSP;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CspHeuristics;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.FlexibleBacktrackingSolver;
import aima.core.search.csp.MinConflictsSolver;
import aima.core.search.csp.Variable;
import alanfx.ProjetoCSP.csp.AlocCSP;

import java.util.*;
import java.lang.*;
import alanfx.ProjetoCSP.csp.Disciplina;
import alanfx.ProjetoCSP.csp.Professor;
import alanfx.ProjetoCSP.restricoes.util.ValorAtribuido;

//import java.lang.Reflect.Array;


public class TelaIA extends javax.swing.JFrame {

    /**
     * Creates new form TelaIA
     */
    public TelaIA() {
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

        AddRestricao = new javax.swing.JButton();
        RestricaoBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableRestricao = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableProfMat = new javax.swing.JTable();
        TextAddMateria = new javax.swing.JTextField();
        AddProfessor = new javax.swing.JButton();
        ButtonAddMateria = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableAddMateria = new javax.swing.JTable();
        TextAddProfessor = new javax.swing.JTextField();
        AddPreferenciaMat = new javax.swing.JButton();
        TextPrefMat = new javax.swing.JTextField();
        TextPrefMat1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AlocHorario = new javax.swing.JButton();
        TextAddMateriaCred = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TextResticao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HorariosFixosList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        AddRestricao.setText("AddRestricao");
        AddRestricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRestricaoActionPerformed(evt);
            }
        });

        RestricaoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ProfessorDiferente", "PreferenciaDisciplina" }));
        RestricaoBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RestricaoBoxItemStateChanged(evt);
            }
        });
        RestricaoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestricaoBoxActionPerformed(evt);
            }
        });

        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Segunda", "Ter�a", "Quarta", "Quinta", "Sexta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable2.setAutoscrolls(false);
        jTable2.setCellSelectionEnabled(true);
        jTable2.setRowHeight(25);
        jTable2.setSelectionBackground(new java.awt.Color(51, 153, 255));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setText("19:00");
        jLabel2.setToolTipText("");

        jLabel3.setText("17:00");

        jLabel4.setText("21:00");

        TableRestricao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Restri��es Adicionadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableRestricao.getTableHeader().setResizingAllowed(false);
        TableRestricao.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TableRestricao);
        if (TableRestricao.getColumnModel().getColumnCount() > 0) {
            TableRestricao.getColumnModel().getColumn(0).setResizable(false);
        }

        TableProfMat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Professores", "Materia 1", "Materia 2", "Materia 3", "Materia 4", "Materia 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableProfMat.getTableHeader().setResizingAllowed(false);
        TableProfMat.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TableProfMat);

        TextAddMateria.setToolTipText("Insira o Nome do professor");

        AddProfessor.setText("AddProfessor");
        AddProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProfessorActionPerformed(evt);
            }
        });

        ButtonAddMateria.setText("AddMateria");
        ButtonAddMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddMateriaActionPerformed(evt);
            }
        });

        TableAddMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Materias Adicionadas", "Creditos", "Hor�rioFixo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableAddMateria.getTableHeader().setResizingAllowed(false);
        TableAddMateria.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(TableAddMateria);
        if (TableAddMateria.getColumnModel().getColumnCount() > 0) {
            TableAddMateria.getColumnModel().getColumn(0).setResizable(false);
            TableAddMateria.getColumnModel().getColumn(1).setResizable(false);
        }

        TextAddProfessor.setToolTipText("Insira o Nome do professor");
        TextAddProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextAddProfessorActionPerformed(evt);
            }
        });

        AddPreferenciaMat.setText("AddPreferencia");
        AddPreferenciaMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPreferenciaMatActionPerformed(evt);
            }
        });

        TextPrefMat.setToolTipText("Insira o Nome do professor");
        TextPrefMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextPrefMatActionPerformed(evt);
            }
        });

        TextPrefMat1.setToolTipText("Insira o Nome do professor");
        TextPrefMat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextPrefMat1ActionPerformed(evt);
            }
        });

        jLabel1.setText("NomeDoProfessor");

        jLabel5.setText("NomeDoProfessor");

        jLabel6.setText("MateriaPreferencia");

        jLabel7.setText("Materia");

        AlocHorario.setBackground(new java.awt.Color(255, 0, 0));
        AlocHorario.setText("Alocar Hor�rios");
        AlocHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlocHorarioActionPerformed(evt);
            }
        });

        TextAddMateriaCred.setToolTipText("");

        jLabel8.setText("Creditos");

        jButton1.setText("<<");

        jButton2.setText(">>");

        jLabel9.setText("Horarios Fixos");

        jLabel10.setText("Materia");

        HorariosFixosList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "N/A", "SEG17", "SEG19", "SEG21", "TER17", "TER19", "TER21", "QUA17", "QUA19", "QUA21", "QUI17", "QUI19", "QUI21", "SEX17", "SEX19", "SEX21", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(HorariosFixosList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(TextAddProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5)
                                .addGap(22, 22, 22)))
                        .addComponent(AddProfessor)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(TextPrefMat1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TextPrefMat, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AddPreferenciaMat))
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextAddMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextAddMateriaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(ButtonAddMateria)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RestricaoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TextResticao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(AddRestricao)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AlocHorario)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AlocHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RestricaoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AddRestricao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextResticao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonAddMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TextAddMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextAddMateriaCred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextAddProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddPreferenciaMat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextPrefMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextPrefMat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TextAddMateriaCred.getAccessibleContext().setAccessibleName("CreditoMatForm");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public List<Professor> getProfessores (){
        List <Professor> professores = new ArrayList<>();
        //professores.addAll(Arrays.asList(TableProfMat));
        for(int i = 0; i < TableProfMat.getColumnCount(); i++){
            professores.add(new Professor(TableProfMat.getValueAt(i,0).toString()));
        }
        return professores;
    }
    
    public List<Integer> getCreditos(){
        List <Integer> creditos = new ArrayList<Integer>();
        for (int i=0; i < TableAddMateria.getColumnCount(); i++){
            creditos.add(Integer.parseInt(TableAddMateria.getValueAt(i,0).toString()));
        }
        return creditos;
    }

    public List<Disciplina> getMaterias(){
        List <Disciplina> materias = new ArrayList<>();
        //List <Integer> creditos = new ArrayList<Integer>();
        //List <Disciplina> disciplinas = new ArrayList<>();
        //Disciplina discip = null;
        for(int i = 0; i < TableAddMateria.getColumnCount(); i++){
            materias.add(new Disciplina(
                    TableAddMateria.getValueAt(i,0).toString(),
                    Integer.parseInt(TableAddMateria.getValueAt(i,1).toString())
            ));
        }
        return materias;
    }
        

    public void getPreferencias(List <Professor> profs){
        String nome;
        String preferencia;
        for (int i=0; i < TableProfMat.getRowCount(); i++){
            nome = TableProfMat.getValueAt(i, 1).toString();
            if (!nome.isEmpty()){
                for (int j=1; j < TableProfMat.getColumnCount(); j++){
                    preferencia = TableProfMat.getValueAt(i, j).toString();
                    if (!preferencia.isEmpty()){
                        for (Professor p : profs) {
                            for (Disciplina disciplina : getMaterias()) {
                                if (disciplina.getNome().equals(preferencia))
                                    p.addPreferencia(disciplina); // mudar para o tipo disciplina
                            }
                        }
                    } else break;
                }
            } else break;
        }
    }

    private void AddRestricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRestricaoActionPerformed
    /*String newrestri = RestricaoBox.getSelectedItem().toString(); 
    for(int i=0 ; i<3 ; i++){
         if(TableRestricao.getValueAt(i,0) == null || (TableRestricao.getValueAt(i,0).equals(newrestri))){
             TableRestricao.setValueAt(newrestri,i,0);
             break;
         }         
     }        
    System.out.println(newrestri);
        */
    // TODO add your handling code here:
    }//GEN-LAST:event_AddRestricaoActionPerformed

    private void RestricaoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestricaoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RestricaoBoxActionPerformed

    private void AddProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProfessorActionPerformed
     String newprof = TextAddProfessor.getText();
     
     for(int i=0 ; i<15 ; i++){
         if(TableProfMat.getValueAt(i,0) == null || (TableProfMat.getValueAt(i,0).equals(newprof))){
             TableProfMat.setValueAt(newprof,i,0);
             break;
         }         
     }

    }//GEN-LAST:event_AddProfessorActionPerformed

    private void ButtonAddMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddMateriaActionPerformed
        String newmat = TextAddMateria.getText();
        int matcred = Integer.parseInt(TextAddMateriaCred.getText());
        if (!newmat.isEmpty() && !TextAddMateriaCred.getText().isEmpty()){
            for(int i=0 ; i< TableProfMat.getRowCount() ; i++){
                if(TableAddMateria.getValueAt(i,0) == null || (TableAddMateria.getValueAt(i,0).equals(newmat))){
                    TableAddMateria.setValueAt(newmat,i,0);
                    TableAddMateria.setValueAt(matcred,i,1);
                    TableAddMateria.setValueAt(HorariosFixosList.getSelectedValuesList(), i, 2);
                    break;
                }
            }
        }
       // TODO add your handling code here:
    }//GEN-LAST:event_ButtonAddMateriaActionPerformed

    private void AddPreferenciaMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPreferenciaMatActionPerformed
        String newpref = TextPrefMat.getText();
        String prof = TextPrefMat1.getText();
        Boolean x=false;
        for(int i=0 ; i<5; i++){
            if((TableAddMateria.getValueAt(i,0).equals(newpref))){
                x=true;
                break;
            }   
        }

        for(int i=0 ; i<15 ; i++){
             if(TableProfMat.getValueAt(i,0).equals(prof) && x==true){
                 for(int k=0 ; k< 5 ; k++){
                    if(TableProfMat.getValueAt(i,k) == null || TableProfMat.getValueAt(i,k).equals(newpref)) {
                        TableProfMat.setValueAt(newpref,i,k);
                    break; 
                    }                   
                }             
            }         
        }
      
    
        
        // TODO add your handling code here:
    }//GEN-LAST:event_AddPreferenciaMatActionPerformed

    private void TextAddProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextAddProfessorActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_TextAddProfessorActionPerformed

    private void TextPrefMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextPrefMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextPrefMatActionPerformed

    private void TextPrefMat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextPrefMat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextPrefMat1ActionPerformed

    private void AlocHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlocHorarioActionPerformed
        List<Disciplina> disciplinas = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        professores.addAll(getProfessores());
        disciplinas.addAll(getMaterias());
        getPreferencias(professores);
        String algorit = "MinConflictsSolver"; //Exemplo algoritmo selecionado
        List<Variable> variaveis;
        List<List<String>> valores;
        variaveis = AlocCSP.criarVariaveis(disciplinas);
        valores = AlocCSP.createValues(AlocCSP.criarProfessores(professores), AlocCSP.aulas);
        CspListener.StepCounter<Variable, List<String>> stepCounter = new CspListener.StepCounter<>();
        CspSolver<Variable, List<String>> solver;
        solver = new MinConflictsSolver<>(1000);
        solver.addCspListener(stepCounter);
        stepCounter.reset();
        Optional<Assignment<Variable, List<String>>> solution;
        Set<Optional<Assignment<Variable, List<String>>>> set = new HashSet<>();
        for (Variable var : variaveis) {
            for (List<String> val : valores) {
                CSP<Variable, List<String>> csp = new AlocCSP(disciplinas, professores, get, new ValorAtribuido<>(var, val));
                solution = solver.solve(csp);
                set.add(solution);
            }
        }
        Set<Optional<Assignment<Variable, List<String>>>> solucoesList =  set;
    }//GEN-LAST:event_AlocHorarioActionPerformed


    private void RestricaoBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RestricaoBoxItemStateChanged
        //if (RestricaoBox.getSelectedItem() != "HorarioFixo"){
        //    ComboBoxHorario.setVisible(false);
        //} else ComboBoxHorario.setVisible(true);
    }//GEN-LAST:event_RestricaoBoxItemStateChanged

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
            java.util.logging.Logger.getLogger(TelaIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaIA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPreferenciaMat;
    private javax.swing.JButton AddProfessor;
    private javax.swing.JButton AddRestricao;
    private javax.swing.JButton AlocHorario;
    private javax.swing.JButton ButtonAddMateria;
    private javax.swing.JList<String> HorariosFixosList;
    private javax.swing.JComboBox<String> RestricaoBox;
    private javax.swing.JTable TableAddMateria;
    private javax.swing.JTable TableProfMat;
    private javax.swing.JTable TableRestricao;
    private javax.swing.JTextField TextAddMateria;
    private javax.swing.JTextField TextAddMateriaCred;
    private javax.swing.JTextField TextAddProfessor;
    private javax.swing.JTextField TextPrefMat;
    private javax.swing.JTextField TextPrefMat1;
    private javax.swing.JTextField TextResticao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
