
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.plaf.TableUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class ApplianceInfo extends javax.swing.JFrame {
    
    
    /**
     * Creates new form GUI
     */
    public ApplianceInfo() {
       initComponents();
       
       String []arrayFirst={"78123","La Creame Riche","Dior","10000","Dry","Unavailable","Cream"};
       String []arraySecond={"4673","Soft Moisturising Cream","Nivea","500","Dry","Unavailable","Cream"};
       String []arrayThird={"98776","Frangipani Gel","Nivea","400","Dry","Unavailable","Gel"};
       String []arrayFourth={"09876","Men Sensetive Cooling Lotion","Nivea","800","Any","Available","Cream"};
       String []arrayFifth={"67889","Joues Contranste Powder Blush","Chanel","8000","Oily","Unavailable","Powder"};
       String []arraySixth={"12243","Studio Fix Powder Plus Foundation","Mac","7000","Oily","Unavailable","Powder"};
       String []arraySeventh={"0987","L'OR DE VIE","Dior","7000","Dry","Unavailable","Cream"};
       String []arrayEighth={"789234","Dior Prestige","Dior","8000","Dry","Unavailable","Cream"};
       String []arrayNinth={"2451","Matte Vaporisateur Matifiant","Mac","2900","Any","Available","Deodrant"};
       String []arrayTenth={"837645","Gabrielle Body Cream","Chanel","8500","Any","Unavailable","Cream"};
       String []arrayEleventh={"65829","N 5 perfume","Chanel","8900","Dry","Unavailable","Deodrant"};
       String []arrayTwelveth={"51718","Boy De Chanel","Chanel","9000","Any","Available","Gel"};
       
       for (int i=0; i<7; i++){
           table.setValueAt(arrayFirst[i],0,i);
           table.setValueAt(arraySecond[i],1,i);
           table.setValueAt(arrayThird[i],2,i);
           table.setValueAt(arrayFourth[i],3,i);
           table.setValueAt(arrayFifth[i],4,i);
           table.setValueAt(arraySixth[i],5,i);
           table.setValueAt(arraySeventh[i],6,i);
           table.setValueAt(arrayEighth[i],7,i);
           table.setValueAt(arrayNinth[i],8,i);
           table.setValueAt(arrayTenth[i],9,i);
           table.setValueAt(arrayEleventh[i],10,i);
           table.setValueAt(arrayTwelveth[i],11,i);
           
           
       }
    }
       public String searchBrand(String []b,String value){
           int rowCount=table.getRowCount();
           int colCount= 0;
           
        for (String b1 : b) {
            if (b1.equals(value)) {
                for(int j=0;j<rowCount;j++){
                    if(table.getValueAt(j, 2)==value){
                        JOptionPane.showMessageDialog(null,value+" found\n" +"ProductID :"+ table.getValueAt(j, 0)+"\n"+"Name :"+table.getValueAt(j,1)+"\n"+ "Brand :"+ table.getValueAt(j,2)+"\n"+"Price :"+table.getValueAt(j,3)+"\n"+"Skin :"+table.getValueAt(j,4)+"\n"+"Discount :"+table.getValueAt(j,5),"Category",JOptionPane.INFORMATION_MESSAGE);
                        colCount+=1;
                    }
                }
                break;
            }
        }
         if(colCount==0){
             JOptionPane.showMessageDialog(rootPane, "Product not Found");
             
         }
          
          return"product";
    }
       public static void sort(int[] a)
   {  
      if (a.length <= 1) { return; }
      int[] first = new int[a.length / 2];
      int[] second = new int[a.length - first.length];
      // Copy the first half of a into first, the second half into second
      for (int i = 0; i < first.length; i++) 
      { 
         first[i] = a[i]; 
      }
      for (int i = 0; i < second.length; i++) 
      { 
         second[i] = a[first.length + i]; 
      }
      sort(first);
      sort(second);
      merge(first, second, a);
      
   }
    private static void merge(int[] first, int[] second, int[] a)
   {  
      int iFirst = 0; // Next element to consider in the first array
      int iSecond = 0; // Next element to consider in the second array
      int j = 0; // Next open position in a

      // As long as neither iFirst nor iSecond is past the end, move
      // the smaller element into a
      while (iFirst < first.length && iSecond < second.length)
      {  
         if (first[iFirst] < second[iSecond])
         {  
            a[j] = first[iFirst];
            iFirst++;
         }
         else
         {  
            a[j] = second[iSecond];
            iSecond++;
         }
         j++;
      }
   
    while (iFirst < first.length) 
      { 
         a[j] = first[iFirst]; 
         iFirst++; j++;
      }
    while (iSecond < second.length) 
      { 
         a[j] = second[iSecond]; 
         iSecond++; j++;
      }
       
   }
    
    //binary search
    public int search (int[]a,int low,int high,int value)
    {
        int rowcount=table.getRowCount();  
        
        if (low<=high)
        {
            int mid=(low+high)/2;
            
            if (a[mid]==value)
            {
                //System.out.println(value+"  Found");
                //JOptionPane.showMessageDialog(null,"found","Warning",JOptionPane.INFORMATION_MESSAGE);
                for (int z=0; z<rowcount;z++)
                {
                    if(table.getValueAt(z,3)!=null){
                    //converting the value of object string to integer
                        if (Integer.valueOf((String)table.getValueAt(z,3))==a[mid])
                        {
                        JOptionPane.showMessageDialog(null,value+" found\n" +"\n"+"ProductID :"+table.getValueAt(z,0)+"Name :"+ table.getValueAt(z,1)+"\n"+"Brand :"+table.getValueAt(z,2)+"\n"+ "Price :"+ table.getValueAt(z,3)+"\n"+"Skin :"+table.getValueAt(z,4)+"\n"+"Discount :"+table.getValueAt(z,5),"Category",JOptionPane.INFORMATION_MESSAGE);
                        
                        }
                    }
                    else
                    {
                        
                    }
                    }
                    
                
                
                return mid; 
                
            }
            else if (a[mid]<value)
            {
                return search(a,mid+1,high,value);
                
            }
            else 
            {
                return search(a,low,mid-1,value);
                
            }
          
            
        }
        else
        {
        //System.out.println("not  Found");
        JOptionPane.showMessageDialog(null,"Not found","Result",JOptionPane.INFORMATION_MESSAGE);
        
        
        }
        
        return -1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        GRUOP = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        productID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        productName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        brand = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        productPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        skinType = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        available = new javax.swing.JRadioButton();
        unavailable = new javax.swing.JRadioButton();
        categories = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchBrand = new javax.swing.JComboBox<>();
        brandSearch = new javax.swing.JButton();
        priceSearch = new javax.swing.JButton();
        searchPrice = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        manual = new javax.swing.JMenu();
        open = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        manuals = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cut = new javax.swing.JMenuItem();
        undo = new javax.swing.JMenuItem();
        redo = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        table.setForeground(new java.awt.Color(0, 153, 204));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "PRODUCT ID", "PRODUCT NAME", "BRAND", "PRICE", "SKIN TYPE", "DISCOUNT", "CATEGORIES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));

        jLabel13.setBackground(new java.awt.Color(51, 255, 204));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Cosmetic Products Information System");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jLabel2.setText("Product ID");

        productID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIDActionPerformed(evt);
            }
        });

        jLabel3.setText("Product Name");

        productName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameActionPerformed(evt);
            }
        });

        jLabel4.setText("Brand");

        brand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".......Select.......", "Nivea", "Chanel", "Dior", "Mac" }));

        jLabel5.setText("Price");

        productPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productPriceActionPerformed(evt);
            }
        });
        productPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productPriceKeyPressed(evt);
            }
        });

        jLabel6.setText("Skin Type");

        skinType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skinTypeActionPerformed(evt);
            }
        });

        jLabel7.setText("Discount");

        buttonGroup2.add(available);
        available.setText("Available");
        available.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableActionPerformed(evt);
            }
        });

        buttonGroup2.add(unavailable);
        unavailable.setText("Unavailable");
        unavailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unavailableActionPerformed(evt);
            }
        });

        categories.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categories", "Cream", "Gel", "Powder", "Deodrant" }));

        jLabel8.setText("Categories");

        add.setBackground(new java.awt.Color(255, 255, 153));
        add.setForeground(new java.awt.Color(0, 153, 153));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(255, 255, 153));
        clear.setForeground(new java.awt.Color(0, 153, 153));
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(unavailable)
                                    .addComponent(available)
                                    .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(clear)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(skinType, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(available)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(skinType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(categories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(unavailable))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(clear))
                .addGap(34, 34, 34)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Product Details");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        searchBrand.setBackground(new java.awt.Color(102, 255, 204));
        searchBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "......Select.......", "Nivea", "Chanel", "Dior", "Mac" }));

        brandSearch.setBackground(new java.awt.Color(0, 204, 51));
        brandSearch.setText("Search by Brand");
        brandSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandSearchActionPerformed(evt);
            }
        });

        priceSearch.setBackground(new java.awt.Color(0, 204, 51));
        priceSearch.setText("Search by Price");
        priceSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceSearchActionPerformed(evt);
            }
        });

        searchPrice.setBackground(new java.awt.Color(153, 255, 204));

        manual.setText("File");

        open.setText("Open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        manual.add(open);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        manual.add(save);

        manuals.setText("Manual");
        manuals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualsActionPerformed(evt);
            }
        });
        manual.add(manuals);

        jMenuBar1.add(manual);

        jMenu2.setText("Edit");
        jMenu2.setToolTipText("");

        cut.setText("Cut");
        jMenu2.add(cut);

        undo.setText("Undo");
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });
        jMenu2.add(undo);

        redo.setText("Redo");
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });
        jMenu2.add(redo);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(brandSearch)
                        .addGap(30, 30, 30)
                        .addComponent(searchBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(priceSearch)
                        .addGap(32, 32, 32)
                        .addComponent(searchPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)))
                .addContainerGap(482, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceSearch)
                            .addComponent(searchPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brandSearch))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameActionPerformed
      
    }//GEN-LAST:event_productNameActionPerformed

    private void productPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productPriceActionPerformed
        
    }//GEN-LAST:event_productPriceActionPerformed

    private void availableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableActionPerformed
        
    }//GEN-LAST:event_availableActionPerformed

    private void unavailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unavailableActionPerformed
        
    }//GEN-LAST:event_unavailableActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
          try {
           String name= productName.getText();
           String productId= productID.getText();
           String price= productPrice.getText();
           String productBrand= brand.getSelectedItem().toString();
           String skin= skinType.getText();
           String dis="";
           if(available.isSelected())
           {
                dis="Available";
                          
           }
           if(unavailable.isSelected())
           {
               dis="Unavailable";
           }
           String category= categories.getSelectedItem().toString();
           
           String product_detail[]={productId,name, productBrand,price,skin, dis, category};
           int nextRow=0;
           int rowCount=table.getRowCount();
           int colCount=table.getColumnCount();
           boolean empty = false;
           
           
           if(!name.isEmpty()){
               if(!productId.isEmpty()){
                   if(!price.isEmpty()){
                       if(brand.getSelectedIndex()!=0){
                           if(!skin.isEmpty()){
                               if(!dis.isEmpty()){
                                   if(categories.getSelectedIndex()!=0){
                                       
                                        do{
                                         String jTable=(String)table.getValueAt(nextRow, 0);
                                         if(jTable!=null && jTable.length()!=0){
                                             nextRow++;                                             
                                         }
                                         else{
                                             empty=true;
                                             
                                         }
                                         
                                       } while(nextRow<rowCount && !empty);
                                       for(int i=0; i<colCount; i++){
                                           table.setValueAt(product_detail[i],nextRow, i);
                                       }
                                    JOptionPane.showMessageDialog(rootPane, "Added successfully");
                                   }
                                   else{
                                       JOptionPane.showMessageDialog(null,"Category not selected" );
                                   }
                               }
                               else{
                                   JOptionPane.showMessageDialog(null, "Discount is not selected");
                               }
                           }   
                               else
                               {
                                   JOptionPane.showMessageDialog(null, "Skin type is empty");
                               }
                       }   
                           else{
                               JOptionPane.showMessageDialog(null,"Brand is not selected");
                           }
                   }   
                       else{
                           JOptionPane.showMessageDialog(null, "Price is empty");
                       }                  
               } 
               else{
                   JOptionPane.showMessageDialog(null, "Product ID is empty");
               }
            }
           else{
               JOptionPane.showMessageDialog(null, "Product Name is empty");
           }
          }   
           catch (Exception e) {
               JOptionPane.showMessageDialog(null,"added");
        }
    }//GEN-LAST:event_addActionPerformed

   
    private void productPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productPriceKeyPressed
        char c=evt.getKeyChar();
        if(Character.isLetter(c)){
            productPrice.setEditable(false);
         JOptionPane.showMessageDialog(null,"Add number value in price");
        }else{
            productPrice.setEditable(true);
        }
    }//GEN-LAST:event_productPriceKeyPressed

    private void brandSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandSearchActionPerformed
              int rowcount=table.getRowCount();
      String s [] = new String [rowcount];
      for (int i=0; i<rowcount; i++)
      {
          
          String check= (String) table.getValueAt(i,2);
          
          s[i]=check;
      }
      System.out.println(Arrays.toString(s));
      
      
      String value=(String) searchBrand.getSelectedItem();
      //System.out.println(value);
      ApplianceInfo nq= new ApplianceInfo();
      nq.searchBrand(s,value);        // TODO add your handling code here:
    }//GEN-LAST:event_brandSearchActionPerformed

    private void priceSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceSearchActionPerformed
        int rowcount=table.getRowCount();
      int b [] = new int [rowcount];
      for (int i=0; i<rowcount; i++)
      {
          
          String check= (String) table.getValueAt(i,3);
          
          if (check!=null && !check.isEmpty())
          {
              System.out.println(check);
              int f= Integer.parseInt(check); 
              b[i]=f;
          
          }
      }
    System.out.println(Arrays.toString(b));  
    //int [] a={9,5,4,7,2,6};
    int low=0;
    int high=rowcount;
//    int value=5;

    
    ApplianceInfo nc = new ApplianceInfo();
    nc.sort(b);
    //System.out.println(Arrays.toString(b));
    int value = Integer.parseInt(searchPrice.getText());
    /*Scanner n = new Scanner(System.in);
    System.out.println("enter the value ");
    int value= n.nextInt();*/
    nc.search(b,low,high,value);
    }//GEN-LAST:event_priceSearchActionPerformed

    private void productIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIDActionPerformed

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redoActionPerformed

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        String filePath="C:/Users/Dell/Desktop/data.txt";
        try {
            BufferedReader bufferreader=new BufferedReader(new FileReader(filePath));
            String fline=bufferreader.readLine().trim();
            String [] colName=fline.split(",");
            DefaultTableModel model=(DefaultTableModel) table.getModel();
            model.setColumnIdentifiers(colName);
            Object[] tabLines=bufferreader.lines().toArray();
            
            for(int i=0;i<tabLines.length;i++){
                String line= tabLines[i].toString().trim();
                String [] dataRow= line.split(",");
                model.addRow(dataRow);
            
            }                   
                      
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            
        }
    // TODO add your handling code here:
    }//GEN-LAST:event_openActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_undoActionPerformed

    private void manualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualsActionPerformed
        File file=new File("C:/Users/Dell/Desktop/manual.pdf");
        try {
            Desktop.getDesktop().open(file);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "File not found");
        }
 // TODO add your handling code here:
    }//GEN-LAST:event_manualsActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        productID.setText("");
        productName.setText("");
        skinType.setText("");
        productPrice.setText("");
        brand.setSelectedIndex(0);
        categories.setSelectedIndex(0);
        buttonGroup2.clearSelection();
        searchPrice.setText("");
        searchBrand.setSelectedIndex(0);
    }//GEN-LAST:event_clearActionPerformed

    private void skinTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skinTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skinTypeActionPerformed

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
            java.util.logging.Logger.getLogger(ApplianceInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplianceInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplianceInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplianceInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplianceInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GRUOP;
    private javax.swing.JButton add;
    private javax.swing.JRadioButton available;
    private javax.swing.JComboBox<String> brand;
    private javax.swing.JButton brandSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> categories;
    private javax.swing.JButton clear;
    private javax.swing.JMenuItem cut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu manual;
    private javax.swing.JMenuItem manuals;
    private javax.swing.JMenuItem open;
    private javax.swing.JButton priceSearch;
    private javax.swing.JTextField productID;
    private javax.swing.JTextField productName;
    private javax.swing.JTextField productPrice;
    private javax.swing.JMenuItem redo;
    private javax.swing.JMenuItem save;
    private javax.swing.JComboBox<String> searchBrand;
    private javax.swing.JTextField searchPrice;
    private javax.swing.JTextField skinType;
    private javax.swing.JTable table;
    private javax.swing.JRadioButton unavailable;
    private javax.swing.JMenuItem undo;
    // End of variables declaration//GEN-END:variables

    
}
