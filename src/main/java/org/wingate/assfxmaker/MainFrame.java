/*
 * Copyright (C) 2021 util2
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.wingate.assfxmaker;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.wingate.assfxmaker.ass.ASS;
import org.wingate.assfxmaker.ui.AssSfxTableModel;

/**
 *
 * @author util2
 */
public class MainFrame extends javax.swing.JFrame {
    
    private static final String SOFTWARE = "AssFxMaker";
    private static final String VERSION = "1.0-alpha";
    private static final String CODENAME = "\"Makkana inu\"";
    
    private final AssSfxTableModel orginModel = new AssSfxTableModel();
    private final AssSfxTableModel generatedModel = new AssSfxTableModel();

    /**
     * Creates new form MainFrame
     */
    private MainFrame() {
        initComponents();        
    }
    
    public static MainFrame launch(String... args){
        MainFrame mf = new MainFrame();
        
        mf.setSize(1200, 900);
        mf.setLocationRelativeTo(null);
        
        //--- INIT ---
        
        mf.setTitle(SOFTWARE + " :: " + VERSION + " :: " + CODENAME);
        
        mf.tblOrigin.setModel(mf.orginModel);
        mf.orginModel.setColumnSize(mf.tblOrigin);
        
        mf.tblGenerated.setModel(mf.generatedModel);
        mf.generatedModel.setColumnSize(mf.tblGenerated);
        
        for(FileFilter ff : mf.fcASS.getChoosableFileFilters()){
            mf.fcASS.removeChoosableFileFilter(ff);
        }
        mf.fcASS.addChoosableFileFilter(new FileFilter(){
            @Override
            public boolean accept(File file) {
                if(file.isDirectory()) return true;
                return file.getName().endsWith(".ass");
            }

            @Override
            public String getDescription() {
                return "ASS files";
            }
            
        });
        
        //- INIT END -
        
        mf.setVisible(true);
        
        return mf;
    }
    
    private void toggleTextModeAction(){
        if(toggleRaw.isSelected() == true){
            orginModel.setTextMode(AssSfxTableModel.TextMode.Raw);
            generatedModel.setTextMode(AssSfxTableModel.TextMode.Raw);
        }else if(toggleTags.isSelected() == true){
            orginModel.setTextMode(AssSfxTableModel.TextMode.Tag);
            generatedModel.setTextMode(AssSfxTableModel.TextMode.Tag);
        }else if(toggleTextOnly.isSelected() == true){
            orginModel.setTextMode(AssSfxTableModel.TextMode.TextOnly);
            generatedModel.setTextMode(AssSfxTableModel.TextMode.TextOnly);
        }
        tblOrigin.updateUI();
        tblGenerated.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTextMode = new javax.swing.ButtonGroup();
        fcASS = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panKaraoke = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        toggleRaw = new javax.swing.JToggleButton();
        toggleTags = new javax.swing.JToggleButton();
        toggleTextOnly = new javax.swing.JToggleButton();
        panTop = new javax.swing.JPanel();
        panOriginal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrigin = new javax.swing.JTable();
        panResult = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGenerated = new javax.swing.JTable();
        panBottom = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panDrawing = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuFileOpen = new javax.swing.JMenuItem();
        mnuFileSave = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout());

        panKaraoke.setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        bgTextMode.add(toggleRaw);
        toggleRaw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AFM-NormalMode.png"))); // NOI18N
        toggleRaw.setSelected(true);
        toggleRaw.setToolTipText("Raw text");
        toggleRaw.setFocusable(false);
        toggleRaw.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toggleRaw.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toggleRaw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleRawActionPerformed(evt);
            }
        });
        jToolBar1.add(toggleRaw);

        bgTextMode.add(toggleTags);
        toggleTags.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AFM-ItemsMode.png"))); // NOI18N
        toggleTags.setToolTipText("Text with tags");
        toggleTags.setFocusable(false);
        toggleTags.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toggleTags.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toggleTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleTagsActionPerformed(evt);
            }
        });
        jToolBar1.add(toggleTags);

        bgTextMode.add(toggleTextOnly);
        toggleTextOnly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AFM-StripMode.png"))); // NOI18N
        toggleTextOnly.setToolTipText("Stripped text");
        toggleTextOnly.setFocusable(false);
        toggleTextOnly.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toggleTextOnly.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toggleTextOnly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleTextOnlyActionPerformed(evt);
            }
        });
        jToolBar1.add(toggleTextOnly);

        panKaraoke.add(jToolBar1, java.awt.BorderLayout.NORTH);

        panTop.setPreferredSize(new java.awt.Dimension(0, 500));
        panTop.setLayout(new java.awt.GridLayout(1, 2));

        panOriginal.setLayout(new java.awt.BorderLayout());

        tblOrigin.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblOrigin);

        panOriginal.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panTop.add(panOriginal);

        panResult.setLayout(new java.awt.BorderLayout());

        tblGenerated.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblGenerated);

        panResult.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        panTop.add(panResult);

        panKaraoke.add(panTop, java.awt.BorderLayout.CENTER);

        panBottom.setPreferredSize(new java.awt.Dimension(883, 400));
        panBottom.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Effects", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Code", jPanel2);

        panBottom.add(jTabbedPane2, java.awt.BorderLayout.CENTER);

        panKaraoke.add(panBottom, java.awt.BorderLayout.SOUTH);

        jTabbedPane1.addTab("Karaoke", panKaraoke);

        javax.swing.GroupLayout panDrawingLayout = new javax.swing.GroupLayout(panDrawing);
        panDrawing.setLayout(panDrawingLayout);
        panDrawingLayout.setHorizontalGroup(
            panDrawingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 904, Short.MAX_VALUE)
        );
        panDrawingLayout.setVerticalGroup(
            panDrawingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Drawing", panDrawing);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        mnuFile.setText("File");

        mnuFileOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuFileOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Aegisub tiny.png"))); // NOI18N
        mnuFileOpen.setText("Open...");
        mnuFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileOpenActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileOpen);

        mnuFileSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuFileSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Aegisub tiny.png"))); // NOI18N
        mnuFileSave.setText("Save...");
        mnuFileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileSaveActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileSave);

        jMenuBar1.add(mnuFile);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toggleRawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleRawActionPerformed
        toggleTextModeAction();
    }//GEN-LAST:event_toggleRawActionPerformed

    private void toggleTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleTagsActionPerformed
        toggleTextModeAction();
    }//GEN-LAST:event_toggleTagsActionPerformed

    private void toggleTextOnlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleTextOnlyActionPerformed
        toggleTextModeAction();
    }//GEN-LAST:event_toggleTextOnlyActionPerformed

    private void mnuFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileOpenActionPerformed
        int z = fcASS.showOpenDialog(this);
        if(z == JFileChooser.APPROVE_OPTION){
            orginModel.removeAll();
            orginModel.setAss(ASS.Read(fcASS.getSelectedFile().getPath()));
            tblOrigin.updateUI();
        }
    }//GEN-LAST:event_mnuFileOpenActionPerformed

    private void mnuFileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileSaveActionPerformed
        int z = fcASS.showSaveDialog(this);
        if(z == JFileChooser.APPROVE_OPTION){
            ASS.Save(fcASS.getSelectedFile().getPath(), generatedModel.getAss());
        }
    }//GEN-LAST:event_mnuFileSaveActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgTextMode;
    private javax.swing.JFileChooser fcASS;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuFileOpen;
    private javax.swing.JMenuItem mnuFileSave;
    private javax.swing.JPanel panBottom;
    private javax.swing.JPanel panDrawing;
    private javax.swing.JPanel panKaraoke;
    private javax.swing.JPanel panOriginal;
    private javax.swing.JPanel panResult;
    private javax.swing.JPanel panTop;
    private javax.swing.JTable tblGenerated;
    private javax.swing.JTable tblOrigin;
    private javax.swing.JToggleButton toggleRaw;
    private javax.swing.JToggleButton toggleTags;
    private javax.swing.JToggleButton toggleTextOnly;
    // End of variables declaration//GEN-END:variables
}
