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
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.wingate.assfxmaker.ass.ASS;
import org.wingate.assfxmaker.sfx.AfmLegacy;
import org.wingate.assfxmaker.ui.AssSfxTableModel;
import org.wingate.assfxmaker.ui.SfxListCellRenderer;

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
    
    private final DefaultListModel dlmSFX = new DefaultListModel();    
    private final SfxListCellRenderer sfxTreeCellRenderer = new SfxListCellRenderer();

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
        
        mf.listSFXChoice.setModel(mf.dlmSFX);
        mf.listSFXChoice.setCellRenderer(mf.sfxTreeCellRenderer);
        
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
        panSFX = new javax.swing.JPanel();
        panSFXTree = new javax.swing.JPanel();
        btnUseChosenSFX = new javax.swing.JButton();
        btnCreatePreset = new javax.swing.JButton();
        btnCreateCode = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listSFXChoice = new javax.swing.JList<>();
        panSFXCreator = new javax.swing.JPanel();
        panDrawing = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuFileOpen = new javax.swing.JMenuItem();
        mnuFileSave = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        panSFX.setPreferredSize(new java.awt.Dimension(0, 200));
        panSFX.setLayout(new java.awt.GridLayout(1, 2));

        btnUseChosenSFX.setText("Use -->");

        btnCreatePreset.setText("Create a preset");
        btnCreatePreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePresetActionPerformed(evt);
            }
        });

        btnCreateCode.setText("Create with code");
        btnCreateCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCodeActionPerformed(evt);
            }
        });

        listSFXChoice.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listSFXChoice);

        javax.swing.GroupLayout panSFXTreeLayout = new javax.swing.GroupLayout(panSFXTree);
        panSFXTree.setLayout(panSFXTreeLayout);
        panSFXTreeLayout.setHorizontalGroup(
            panSFXTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSFXTreeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSFXTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(panSFXTreeLayout.createSequentialGroup()
                        .addComponent(btnCreatePreset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(btnUseChosenSFX)))
                .addContainerGap())
        );
        panSFXTreeLayout.setVerticalGroup(
            panSFXTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSFXTreeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSFXTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUseChosenSFX)
                    .addComponent(btnCreatePreset)
                    .addComponent(btnCreateCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        panSFX.add(panSFXTree);

        javax.swing.GroupLayout panSFXCreatorLayout = new javax.swing.GroupLayout(panSFXCreator);
        panSFXCreator.setLayout(panSFXCreatorLayout);
        panSFXCreatorLayout.setHorizontalGroup(
            panSFXCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        panSFXCreatorLayout.setVerticalGroup(
            panSFXCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        panSFX.add(panSFXCreator);

        panKaraoke.add(panSFX, java.awt.BorderLayout.SOUTH);

        jTabbedPane1.addTab("Karaoke", panKaraoke);

        javax.swing.GroupLayout panDrawingLayout = new javax.swing.GroupLayout(panDrawing);
        panDrawing.setLayout(panDrawingLayout);
        panDrawingLayout.setHorizontalGroup(
            panDrawingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        panDrawingLayout.setVerticalGroup(
            panDrawingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
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
            ASS all = ASS.Read(fcASS.getSelectedFile().getPath());
            ASS karaOnlyAss = all;
            for(int i=karaOnlyAss.getEvents().size() - 1; i>=0; i--){
                String text = karaOnlyAss.getEvents().get(i).getText();
                if(text.toLowerCase().contains("{\\k") == false){
                    karaOnlyAss.getEvents().remove(i);
                }
            }
            orginModel.setAss(karaOnlyAss);
            tblOrigin.updateUI();
        }
    }//GEN-LAST:event_mnuFileOpenActionPerformed

    private void mnuFileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileSaveActionPerformed
        int z = fcASS.showSaveDialog(this);
        if(z == JFileChooser.APPROVE_OPTION){
            ASS.Save(fcASS.getSelectedFile().getPath(), generatedModel.getAss());
        }
    }//GEN-LAST:event_mnuFileSaveActionPerformed

    private void btnCreatePresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePresetActionPerformed
        dlmSFX.addElement(new AfmLegacy(AfmLegacy.Type.AFM, "Rouge", "Me", "v1.0", "Fade out"));
    }//GEN-LAST:event_btnCreatePresetActionPerformed

    private void btnCreateCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCodeActionPerformed
        dlmSFX.addElement(new AfmLegacy(AfmLegacy.Type.JavaScript, "RougeJS", "Me", "v2.0", "Fade in"));
    }//GEN-LAST:event_btnCreateCodeActionPerformed

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
    private javax.swing.JButton btnCreateCode;
    private javax.swing.JButton btnCreatePreset;
    private javax.swing.JButton btnUseChosenSFX;
    private javax.swing.JFileChooser fcASS;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList<String> listSFXChoice;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuFileOpen;
    private javax.swing.JMenuItem mnuFileSave;
    private javax.swing.JPanel panDrawing;
    private javax.swing.JPanel panKaraoke;
    private javax.swing.JPanel panOriginal;
    private javax.swing.JPanel panResult;
    private javax.swing.JPanel panSFX;
    private javax.swing.JPanel panSFXCreator;
    private javax.swing.JPanel panSFXTree;
    private javax.swing.JPanel panTop;
    private javax.swing.JTable tblGenerated;
    private javax.swing.JTable tblOrigin;
    private javax.swing.JToggleButton toggleRaw;
    private javax.swing.JToggleButton toggleTags;
    private javax.swing.JToggleButton toggleTextOnly;
    // End of variables declaration//GEN-END:variables
}
