/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import codigo.*;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Usuario
 */
public class VistaSemantico extends javax.swing.JFrame {

    private TextLineNumber lineNumber;
    static comp analizador = null;
    /**
     * Creates new form MainWindowSintactico
     */
    public VistaSemantico() {
        try {
            Principal.generarSintaxis();
        } catch (Exception ex) {
            Logger.getLogger(VistaSemantico.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();

        this.lineNumber = new TextLineNumber(this.codeArea);
        this.lineNumber.setBorderGap(3);
        codeScroll.setRowHeaderView(this.lineNumber);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Analizador Sintactico");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codeScroll = new javax.swing.JScrollPane();
        codeArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messagesArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        treeArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultsArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        linesArea = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileOptions = new javax.swing.JMenu();
        openOption = new javax.swing.JMenuItem();
        saveOption = new javax.swing.JMenuItem();
        executeOptions = new javax.swing.JMenu();
        sintaxAnalyzer = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        codeArea.setColumns(20);
        codeArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        codeArea.setRows(5);
        codeArea.setText("int main()\n{\n\tString a = \"abc\";\n\tString b = \"un_texto\";\n\tprint(\"\");\n\tint x = 10;\n\tfloat z = 1.1;\n\tif(x == 10){\n\t\tint y = 2;\n\t}\n}\n");
        codeScroll.setViewportView(codeArea);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Mensajes");

        messagesArea.setEditable(false);
        messagesArea.setColumns(20);
        messagesArea.setRows(5);
        jScrollPane1.setViewportView(messagesArea);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setText("Árbol sintáctico");

        treeArea.setEditable(false);
        treeArea.setColumns(20);
        treeArea.setRows(5);
        jScrollPane2.setViewportView(treeArea);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel4.setText("Resultados");

        resultsArea.setEditable(false);
        resultsArea.setColumns(20);
        resultsArea.setRows(5);
        jScrollPane3.setViewportView(resultsArea);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel7.setText("Líneas analizadas: ");

        linesArea.setText("...");

        fileOptions.setText("Archivo");

        openOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openOption.setText("Abrir");
        openOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openOptionActionPerformed(evt);
            }
        });
        fileOptions.add(openOption);

        saveOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveOption.setText("Guardar");
        saveOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveOptionActionPerformed(evt);
            }
        });
        fileOptions.add(saveOption);

        jMenuBar1.add(fileOptions);

        executeOptions.setText("Ejecución");

        sintaxAnalyzer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        sintaxAnalyzer.setText("Analizar semántica");
        sintaxAnalyzer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sintaxAnalyzerActionPerformed(evt);
            }
        });
        executeOptions.add(sintaxAnalyzer);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Linear");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        executeOptions.add(jMenuItem1);

        jMenuBar1.add(executeOptions);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 468, Short.MAX_VALUE))
                            .addComponent(codeScroll))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(263, 263, 263))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(linesArea)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(codeScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(linesArea))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void openOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openOptionActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(System.getProperty("user.dir") + "/test/Semantico");
        jfc.setDialogTitle("Seleccione el codigo fuente a analizar: ");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Codigo sintactico", "txt");
        jfc.setFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            CodeCleaner code = new CodeCleaner(selectedFile);

            if (code.getFinished()) {
                this.codeArea.setText(code.getCleanCode());
                System.out.println(code.getCleanCode());
            } else {
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Seleccione un archivo valido",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_openOptionActionPerformed

    private void saveOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveOptionActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/test/Semantico");
        fileChooser.setDialogTitle("Seleccione la ruta para guardar el archivo");

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String path = fileToSave.getAbsolutePath();
            System.out.println("Save as file: " + path);

            Writer writer = null;

            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(path + ".txt"), "utf-8"));
                writer.write(this.codeArea.getText());
            } catch (IOException ex) {
                // Report
                JOptionPane.showMessageDialog(this,
                        "No se pudo guardar el archivo",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    writer.close();
                } catch (Exception ex) {/*ignore*/
                }
                JOptionPane.showMessageDialog(this,
                        "Archivo guardado",
                        "Exito",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveOptionActionPerformed

    private void sintaxAnalyzerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sintaxAnalyzerActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String code = "Programa test{ " + codeArea.getText() + "}";
        
        String byteString = code;
        String[] lines = code.split("\\r\\n|\\r|\\n");
        this.linesArea.setText(""+lines.length);
        
        try{
            InputStream stream = new ByteArrayInputStream(byteString.getBytes(StandardCharsets.UTF_8));
            System.out.println("Empezando análisis");
            
            if(analizador == null){
                analizador = new comp(stream);
            }
            else{
                analizador.ReInit(stream);
            }
            SimpleNode root = analizador.Programa();
            System.out.println("Análisis con éxito");

            ArrayList<String> arbol= new ArrayList<>();
            root.dump("",arbol);

            treeArea.setText("");
            for (int i = 0; i < arbol.size(); i++) {
                System.out.println(arbol.get(i));
                treeArea.append(arbol.get(i)+"\n");
            }
            
            this.resultsArea.setText("Análisis sintáctico exitoso");
            this.resultsArea.setForeground(new Color(0,184,52));
            this.messagesArea.setText("Sin errores de sintaxis");
            this.messagesArea.setForeground(new Color(0, 184, 52));
        }catch(ParseException e){
            System.out.println(e.getMessage());
            System.out.println("\\u005ctAnalizador ha terminado sin exito");
            resultsArea.setText("Analizado completo. El programa no cumple la sintaxis adecuada");
            resultsArea.setForeground(Color.RED);
            messagesArea.setText(e.getMessage());
            messagesArea.setForeground(Color.RED);
            
        }
    }//GEN-LAST:event_sintaxAnalyzerActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.codeArea.setText("");
        this.treeArea.setText("");
        this.messagesArea.setText("");
        this.linesArea.setText("...");
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
            java.util.logging.Logger.getLogger(VistaSemantico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaSemantico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaSemantico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaSemantico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaSemantico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea codeArea;
    private javax.swing.JScrollPane codeScroll;
    private javax.swing.JMenu executeOptions;
    private javax.swing.JMenu fileOptions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel linesArea;
    private javax.swing.JTextArea messagesArea;
    private javax.swing.JMenuItem openOption;
    private javax.swing.JTextArea resultsArea;
    private javax.swing.JMenuItem saveOption;
    private javax.swing.JMenuItem sintaxAnalyzer;
    private javax.swing.JTextArea treeArea;
    // End of variables declaration//GEN-END:variables
}
