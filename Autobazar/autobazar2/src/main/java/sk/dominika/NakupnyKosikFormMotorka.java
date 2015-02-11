
package sk.dominika;

import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

public class NakupnyKosikFormMotorka extends javax.swing.JFrame {

  private MotorkaDao motorkaDao = DaoFactory.INSTANCE.getMotorkaDao();
  
  private MotorkaTableModel motorkaTableModel = new MotorkaTableModel();
  private TableRowSorter motorkaRowSorter = new TableRowSorter(motorkaTableModel);
  
  private Motorka motorka;
  
  private List<Motorka> zoznamMotoriek = new ArrayList<Motorka>();
  
  
    public NakupnyKosikFormMotorka(Motorka motorka,javax.swing.JFrame parent ) {
        initComponents();
        
        tabZoznam.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tabZoznamSelectionValueChanged(e);
            }
        });
         if(motorka != null){
             zoznamMotoriek.add(motorka);
         }
         
        aktualizujZoznamMotoriekVKosiku();  
    }

    NakupnyKosikFormMotorka() {
        initComponents();
    }

  
    
    public void pridajVybratuMotorku(Motorka motorka){
        zoznamMotoriek.add(motorka);
        aktualizujZoznamMotoriekVKosiku();
    }
    
    private void aktualizujZoznamMotoriekVKosiku() {
        
        if(zoznamMotoriek != null){
            for(int i = 0; i<zoznamMotoriek.size(); i++){
                motorka=zoznamMotoriek.get(i);
                motorkaTableModel.dajMotorkuSTymtoIdDoKosika(motorka.getID(), zoznamMotoriek);
            }
        }
    }
    
     private void tabZoznamSelectionValueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            if(!tabZoznam.getSelectionModel().isSelectionEmpty()) {
                btnStorno.setEnabled(true);
            } else {
                btnStorno.setEnabled(false);
            }
        }
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
        lblKosik = new javax.swing.JLabel();
        btnKupit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabZoznam = new javax.swing.JTable();
        btnStorno = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblPozadie = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblKosik.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        lblKosik.setText("Nakupny kosik");
        getContentPane().add(lblKosik, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 226, 42));

        btnKupit.setText("Kupit");
        btnKupit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKupitActionPerformed(evt);
            }
        });
        getContentPane().add(btnKupit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 78, -1));

        tabZoznam.setModel(motorkaTableModel);
        tabZoznam.setRowSorter(motorkaRowSorter);
        tabZoznam.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabZoznam.addMouseListener(new java.awt.event.MouseAdapter() {

        });
        jScrollPane1.setViewportView(tabZoznam);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 321, 186));

        btnStorno.setText("Storno");
        btnStorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStornoActionPerformed(evt);
            }
        });
        getContentPane().add(btnStorno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 70, 53));
        getContentPane().add(lblPozadie, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 390, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKupitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKupitActionPerformed
        // TODO add your handling code here:
       JOptionPane.showMessageDialog(this, "Dakujeme za vas nakup");
      
    }//GEN-LAST:event_btnKupitActionPerformed

    private void btnStornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStornoActionPerformed
       
        dispose();
    }//GEN-LAST:event_btnStornoActionPerformed

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
            java.util.logging.Logger.getLogger(NakupnyKosikFormMotorka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NakupnyKosikFormMotorka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NakupnyKosikFormMotorka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NakupnyKosikFormMotorka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NakupnyKosikFormMotorka().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKupit;
    private javax.swing.JButton btnStorno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKosik;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPozadie;
    private javax.swing.JTable tabZoznam;
    // End of variables declaration//GEN-END:variables
}
