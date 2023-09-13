/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectosimulacion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class MultiplicadorConstante extends javax.swing.JFrame {

    DefaultTableModel modelo;
    
    public MultiplicadorConstante() {
        initComponents();
        setBounds(700,100,485,820);
    }

    public void generar(String nombre) throws FileNotFoundException, DocumentException{
     if(!(X0.getText().isEmpty() || (a.getText().isEmpty()) || (N.getText().isEmpty() || (n.getText().isEmpty())))){  
        //FileOutputStream archivo=new FileOutputStream(nombre + ".pdf");
        Document documento=new Document() ;
        PdfWriter.getInstance(documento,new FileOutputStream("E://CopyData//Report//"+nombre+".pdf"));
        documento.open();
        
        Paragraph parrafo=new Paragraph("Metodo Multiplicador Constante");
        parrafo.setAlignment(1);
        documento.add(parrafo);
        
        documento.add(new Paragraph("Semilla: "+X0.getText()));
        documento.add(new Paragraph("A: "+a.getText()));
        documento.add(new Paragraph("Cantidad: "+N.getText()));
        documento.add(new Paragraph("Cantidad de Digitos: "+n.getText()));
        //documento.add(new Paragraph("Resultado: "+modelo));
        //pdf tabla
        documento.add(Chunk.NEWLINE);
        PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            PdfPCell numero = new PdfPCell(new Phrase("Nº"));
           numero.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell resul = new PdfPCell(new Phrase("Valor Xi"));
            resul.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell rn = new PdfPCell(new Phrase("Valor Ri"));
            rn.setBackgroundColor(BaseColor.ORANGE);
            
            tabla.addCell(numero);
            tabla.addCell(resul);  
             tabla.addCell(rn);  
            
        String semilla1 = X0.getText();
        String semilla2 = a.getText();
        
        
        int cant= Integer.parseInt(N.getText());
        int tam1 = semilla1.length();
        int tam2 = semilla2.length();
        n.setText(String.valueOf(tam1));
        int numero1 = Integer.parseInt(semilla1);
        int numero2 = Integer.parseInt(semilla2);
        
        modelo = (DefaultTableModel) this.jTable1.getModel();
        
        for (int i = 0; i < cant; i++) {
            int numero3 = numero1 * numero2;
            String snumero3 = Integer.toString(numero3);
            int tam3 = snumero3.length();
            int primerc = (tam3 - tam1) / 2;

            String snumero4 = snumero3.substring(primerc, primerc + tam1);
            System.out.println(i + ". " + snumero4);
            numero1 = Integer.parseInt(snumero4);

            //Object datos[] = new Object[] {i,snumero4,"0."+snumero4};
            //modelo.addRow(datos);
            tabla.addCell(String.valueOf(i));
            tabla.addCell(snumero4);
            tabla.addCell("0."+snumero4);
        }
            documento.add(Chunk.NEWLINE);
            documento.add(tabla);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Sumatoria de Ri: "+lblRi.getText()));
            documento.add(new Paragraph("Z: "+txtZ.getText()));
            documento.add(new Paragraph("Promedio r: "+lblR.getText()));
            documento.add(new Paragraph("Limite superior: "+lblLS.getText()));
            documento.add(new Paragraph("Limite inferior: "+lblLI.getText()));
            documento.add(new Paragraph("Resultado: "+lblResul.getText()));
            documento.add(Chunk.NEWLINE);
            
        documento.close();
        JOptionPane.showMessageDialog(null,"Archivo PDF creado correctamente","Informacion",1);
    
    }else{
    JOptionPane.showMessageDialog(null,"Debe llenar todos los campos","Atencion",2);
}
    }
    
    public void abrir(String nombre){
        try{
            File path= new File("E://CopyData//Report//"+nombre+".pdf");
            Desktop.getDesktop().open(path);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Atencion", 2);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        n = new javax.swing.JLabel();
        X0 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        N = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblRi = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtZ = new javax.swing.JTextField();
        btnCalculo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblR = new javax.swing.JLabel();
        lblLI = new javax.swing.JLabel();
        lblLS = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblResul = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel1.setText("MULTIPLICADOR CONSTANTE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 35, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel2.setText("INTRODUZCA LOS DATOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 83, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel3.setText("SEMILLA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 115, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel4.setText("A:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 115, -1, -1));
        getContentPane().add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 109, 124, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel5.setText("DIGITOS:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 153, -1, -1));
        getContentPane().add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 153, 30, 18));
        getContentPane().add(X0, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 109, 112, -1));

        jButton1.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButton1.setText("CALCULAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 184, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel7.setText("CANTIDAD:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 151, -1, -1));
        getContentPane().add(N, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 145, 70, -1));

        jButton2.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButton2.setText("ATRAS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 184, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Valor Xi", "Valor Ri"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 226, 437, 362));

        jButton3.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButton3.setText("NUEVO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 184, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectosimulacion/logoitc (2).jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton5.setText("ABRIR PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 183, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel8.setText("PRUEBA DE MEDIAS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 600, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel9.setText("Ri:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 626, -1, -1));
        getContentPane().add(lblRi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 100, 27));

        jLabel11.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel11.setText("Z:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 630, -1, -1));
        getContentPane().add(txtZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 621, 116, 32));

        btnCalculo.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        btnCalculo.setText("CALCULAR");
        btnCalculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 622, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel10.setText("r:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel12.setText("LIMITE INFERIOR:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel13.setText("LIMITE SUPERIOR:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 740, -1, -1));
        getContentPane().add(lblR, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, 103, 24));
        getContentPane().add(lblLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 690, 102, 25));
        getContentPane().add(lblLS, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 730, 96, 29));

        jLabel14.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel14.setText("RESULTADO:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 690, -1, -1));
        getContentPane().add(lblResul, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 720, 204, 37));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //System.out.print("Semilla 1: ");
        String semilla1 = X0.getText();

        //System.out.print("Semilla 2: ");
        String semilla2 = a.getText();
        
        System.out.println("Introduzca la cantidada de numeros a generar: ");
        int cant= Integer.parseInt(N.getText());

        int tam1 = semilla1.length();
        int tam2 = semilla2.length();

        //System.out.println("Dígitos: " + tam1);
        n.setText(String.valueOf(tam1));

        int numero1 = Integer.parseInt(semilla1);
        int numero2 = Integer.parseInt(semilla2);
        
        modelo = (DefaultTableModel) this.jTable1.getModel();
        double cont=0;
        for (int i = 0; i < cant; i++) {
            int numero3 = numero1 * numero2;
            String snumero3 = Integer.toString(numero3);
            int tam3 = snumero3.length();
            int primerc = (tam3 - tam1) / 2;

            String snumero4 = snumero3.substring(primerc, primerc + tam1);
            System.out.println(i + ". " + snumero4);
            numero1 = Integer.parseInt(snumero4);
            
            double r= (double)numero1/10000;
            //System.out.println(r);
            cont+=r;
            
            Object datos[] = new Object[] {i,snumero4,"0."+snumero4};
            modelo.addRow(datos);
        }
        lblRi.setText(String.format("%.4f",cont));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       X0.setText(null);
       N.setText(null);
       a.setText(null);
       n.setText(null);
       txtZ.setText(null);
       lblRi.setText(null);
        lblR.setText(null);
        lblLI.setText(null);
        lblLS.setText(null);
        lblResul.setText(null);
       modelo.setRowCount(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new Principal().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String nom=jLabel1.getText();
        try{
        generar(nom);
        if(!X0.getText().isEmpty())
            abrir(nom);
        else
            JOptionPane.showMessageDialog(null," ** Campo nombre vacio\n ** no se encuentra ese archivo con ese nombre","Atencion",2);
       }catch(FileNotFoundException ex){
           Logger.getLogger(MultiplicadorConstante.class.getName()).log(Level.SEVERE,null,ex);
       }catch(DocumentException ex){
           Logger.getLogger(MultiplicadorConstante.class.getName()).log(Level.SEVERE,null,ex);
  
        }        
   
         
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnCalculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoActionPerformed
        //PRUEBA DE MEDIAS
        double ri=Double.parseDouble(lblRi.getText());//sumatoria de ri
        double z= Double.parseDouble(txtZ.getText());//calculo z
        int n=Integer.parseInt(N.getText());//cantidad de numeros o valores en ri
        
        double r=ri/n; //calculo de promedios
        lblR.setText(String.format("%.4f", r));//impresion en interfaz de calculo de promedios
        
        double LI=(0.5)-(z*(1/Math.sqrt(12*n)));//calculo del limite inferios
        double LS=(0.5)+(z*(1/Math.sqrt(12*n)));//calculo del limite superior
       lblLI.setText(String.format("%.4f", LI));//impresion en la interfaz
       lblLS.setText(String.format("%.4f", LS));//impresion en la interfaz
       //evaluar si r esta entre el Limite superior y Limite inferior
       if(r<LS && r>LI){
           lblResul.setText("La hipotesis se acepta");
       }else{
           lblResul.setText("La hipotesis no se acepta");
       }
    }//GEN-LAST:event_btnCalculoActionPerformed

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
            java.util.logging.Logger.getLogger(MultiplicadorConstante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MultiplicadorConstante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MultiplicadorConstante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MultiplicadorConstante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MultiplicadorConstante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField N;
    private javax.swing.JTextField X0;
    private javax.swing.JTextField a;
    private javax.swing.JButton btnCalculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblLI;
    private javax.swing.JLabel lblLS;
    private javax.swing.JLabel lblR;
    private javax.swing.JLabel lblResul;
    private javax.swing.JLabel lblRi;
    private javax.swing.JLabel n;
    private javax.swing.JTextField txtZ;
    // End of variables declaration//GEN-END:variables

}
