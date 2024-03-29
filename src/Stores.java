import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.io.File;
import java.util.ArrayList;
import main_classes.Author;
import main_classes.Book;
import main_classes.BookData;
import main_classes.BooksDistributer;
import main_classes.Store;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JToggleButton;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usama
 */
public class Stores extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public Stores() {
        initComponents();
        applet = new Map();
        applet.init();
        applet.size(400,500);
        jPanel1.add(applet);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	
    	in_Stores = true;
    	in_Books = false;
    	in_Authors= false;
    	in_Store_Books = false;
    	in_Edit_Store = false;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                sel = jTable1.getSelectedRow();
                System.out.println(sel);
            }
        });
        jButton4 = new javax.swing.JButton();
        jButton4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Intro.bd.removeStore(Intro.bd.getStoresByLocation().get(sel));        		
        	     model = (DefaultTableModel) jTable1.getModel();        	      
        	     model.removeRow(sel);
        	     
        	    Stores.jPanel1.remove(Stores.applet);
     	        Stores.applet = new Map();
     	        Stores.applet.init();
     	        Stores.applet.size(400,500);
     	        Stores.jPanel1.add(Stores.applet);
     	        Stores.applet.resize(400,500);
           		
        	}
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name","City","County","Books"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        
             
        jTable1.getColumn("Books").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("Books").setCellEditor(new ButtonEditor(new JCheckBox()));



        model = (DefaultTableModel) jTable1.getModel();
      
        ArrayList<Store> array_store = Intro.bd.getStoresByLocation();

        for(Store st : array_store){
            model.addRow(new Object[]{st.getName(),st.getCity(),st.getCountry()});
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        jButton4.setText("Delete");
        
        btnAdd = new JButton();
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Store_Add s_a = new Store_Add();
        		s_a.setVisible(true);
        	}
        });
        btnAdd.setText("Add");
        
        btnEdit = new JButton();
        btnEdit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
            	Stores.in_Books = false;
            	Stores.in_Stores = false;
            	Stores.in_Authors= false;
            	Stores.in_Edit_Store = true;
            	
        		Store_Edit e_s = new Store_Edit();
        		e_s.setVisible(true);
        		     		
        	}
        });
        btnEdit.setText("Edit");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        			.addGap(31)
        			.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
        			.addGap(50)
        			.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
        			.addComponent(jButton4)
        			.addGap(31))
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton4)
        				.addComponent(btnAdd)
        				.addComponent(btnEdit))
        			.addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3.setLayout(jPanel3Layout);
        
        button = new JButton("Back");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {   
        		
        		//stores.dispose();
        		Intro.intro.setVisible(true);
        	}
        });
        
        label_1 = new JLabel("Stores");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JButton btnOnline = new JButton("OnLine");
        btnOnline.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(btnOnline.getText()=="OnLine"){
        			btnOnline.setText("OffLine");
        	        jPanel1.remove(applet);
        			applet = new Map();
        	        applet.init();
        			applet.offline = true;
        	        applet.size(400,500);
        	        jPanel1.add(applet);
                    applet.resize(400,500);
        		}
        		else{
        			btnOnline.setText("OnLine");
        	        jPanel1.remove(applet);
        			applet = new Map();
        	        applet.init();
        			applet.offline = false;
        	        applet.size(400,500);
        	        jPanel1.add(applet);
                    applet.resize(400,500);

        		}
        			
        	}
        });
        
        JButton btnRefreshMap = new JButton("Refresh Map");
        btnRefreshMap.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		jPanel1.remove(applet);
     			applet = new Map();
     	        applet.init();
     	        applet.size(400,500);
     	        jPanel1.add(applet);
                applet.resize(400,500);
        	}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btnOnline)
        					.addGap(18)
        					.addComponent(btnRefreshMap, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(6)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
        							.addContainerGap())
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        							.addGap(164))))
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(button, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
        					.addGap(38))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 397, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnOnline)
        				.addComponent(button)
        				.addComponent(btnRefreshMap))
        			.addGap(13))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                        

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
            // setTheme(String themeName, String licenseKey, String logoString)
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Black");
            
            // select the Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            }
         catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Stores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	stores = new Stores();
            	stores.setVisible(true);
                applet.resize(400,500);

            }
        });
    }

    //My Variables declaration
    private static Stores stores;
    public static int sel;
    public static boolean in_Stores, in_Books , in_Authors,in_Store_Books,in_Edit_Store;
    public static DefaultTableModel model;
    static Map applet;
    private javax.swing.JButton jButton4;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private JButton button;
    private JButton btnAdd;
    private JButton btnEdit;
    private JLabel label_1;
}


class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText("View");
        //setText((value == null) ? "View" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
        	if(Stores.in_Stores){
	        	Store_View_Books v_s_b = new Store_View_Books();
	        	v_s_b.setVisible(true);
        	}
        	else if(Stores.in_Books){
        		Book_View_Book_Authors v_b_a = new Book_View_Book_Authors();
        		v_b_a.setVisible(true);
        		
        	}
        	else if(Stores.in_Authors){
        		Author_View_Author_Books v_a_b = new Author_View_Author_Books();
        		v_a_b.setVisible(true);
        	}
        	else if(Stores.in_Store_Books){
        		Store_View_Book_Authors v_b_a = new Store_View_Book_Authors();
        		v_b_a.setVisible(true);
        	}
        	
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
