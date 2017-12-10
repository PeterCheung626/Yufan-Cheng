
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shenghu
 */
public class MoviePage extends javax.swing.JFrame {
    //private static Movie movie;
    /**
     * Creates new form MovieWindow
     */
    
    
    public MoviePage(Movie m) {
        //movie = m;
        initComponents();
        this.setLocationRelativeTo(null);
        title.setText(m.getTitle());
        if(m.getReleaseDate() == null) {
            year.setText("");
        } else {
            year.setText("(" + m.getReleaseDate().getYear() + ")");
        }
        
        try {
            URL url = new URL(m.getPoster());
            ImageIcon icon = new ImageIcon(ImageIO.read(url));
            ImageIcon newIcon = new ImageIcon(icon.getImage().getScaledInstance(300, 372, Image.SCALE_DEFAULT));
            poster.setIcon(newIcon);
        } catch(IOException ex) {

        }
        
        GridLayout layout = new GridLayout(9, 1);
        layout.setVgap(10);
        jPanel3.setLayout(layout);
        id.setText("<html><strong><font color=rgb(0,0,0)>ID: </font></strong>" + m.getId() + "</html>");
        
        //concatenate keywords, at most 3
        if(m.getKeywords() == null) {
            keywords.setText("<html><strong><font color=rgb(0,0,0)>Keywords: </font></strong>" + "N/A" + "</html>");
        } else {
            StringBuilder sb1 = new StringBuilder();
            int count1 = 0;
            for(String str : m.getKeywords()) {
                sb1.append(str + "/");
                count1++;
                if(count1 > 2) break;
            }
            sb1.deleteCharAt(sb1.length() - 1);
            keywords.setText("<html><strong><font color=rgb(0,0,0)>Keywords: </font></strong>" + sb1.toString() + "</html>");      
        }
        
        if(m.getDirector() == null) {
            director.setText("<html><strong><font color=rgb(0,0,0)>Director: </font></strong>" + "N/A" + "</html>");
        } else {
            director.setText("<html><strong><font color=rgb(0,0,0)>Director: </font></strong>" + m.getDirector() + "</html>");
        }
        
        
        if(m.getCast() == null) {
            cast.setText("<html><strong><font color=rgb(0,0,0)>Cast: </font></strong>" + "N/A" + "</html>");
        } else {
            //concatenate cast, at most 3  
            StringBuilder sb2 = new StringBuilder();
            int count2 = 0;
            for (String str : m.getCast()) {
                sb2.append(str + "/");
                count2++;
                if (count2 > 2) {
                    break;
                }
            }
            sb2.deleteCharAt(sb2.length() - 1);
            cast.setText("<html><strong><font color=rgb(0,0,0)>Cast: </font></strong>" + sb2.toString() + "</html>");   
        }

        if(m.getGenres() == null) {
            genre.setText("<html><strong><font color=rgb(0,0,0)>Genre: </font></strong>" + "N/A" + "</html>");
        } else {
            //concatenate genres , at most 3
            StringBuilder sb3 = new StringBuilder();
            int count3 = 0;
            for (String str : m.getGenres()) {
                sb3.append(str + "/");
                count3++;
                if (count3 > 2) {
                    break;
                }
            }
            sb3.deleteCharAt(sb3.length() - 1);
            genre.setText("<html><strong><font color=rgb(0,0,0)>Genre: </font></strong>" + sb3.toString() + "</html>");
        }
        
        if(m.getProductCountry() == null) {
            productionCountry.setText("<html><strong><font color=rgb(0,0,0)>Production Country: </font></strong>" + "N/A" + "</html>");
        } else {
            //concatenate country , at most 3
            StringBuilder sb4 = new StringBuilder();
            int count4 = 0;
            for (String str : m.getProductCountry()) {
                sb4.append(str + "/");
                count4++;
                if (count4 > 2) {
                    break;
                }
            }
            sb4.deleteCharAt(sb4.length() - 1);
            productionCountry.setText("<html><strong><font color=rgb(0,0,0)>Production Country: </font></strong>" + sb4.toString() + "</html>");
        }
        
        if(m.getLanguages() == null) {
            langauge.setText("<html><strong><font color=rgb(0,0,0)>Language: </font></strong>" + "N/A" + "</html>");
        } else {
            //concatenate language , at most 3
            StringBuilder sb5 = new StringBuilder();
            int count5 = 0;
            for (String str : m.getLanguages()) {
                sb5.append(str + "/");
                count5++;
                if (count5 > 2) {
                    break;
                }
            }
            sb5.deleteCharAt(sb5.length() - 1);
            langauge.setText("<html><strong><font color=rgb(0,0,0)>Language: </font></strong>" + sb5.toString() + "</html>");
        }
        
        if(m.getReleaseDate() == null) {
            releaseDate.setText("<html><strong><font color=rgb(0,0,0)>Released Date: </font></strong>" + "N/A" + "</html>");
        } else {
            releaseDate.setText("<html><strong><font color=rgb(0,0,0)>Released Date: </font></strong>" + m.getReleaseDate().toString() + "</html>");
        }
        
        runtime.setText("<html><strong><font color=rgb(0,0,0)>Runtime: </font></strong>" + m.getRunTime() + "min</html>");
        
        if(m.getOverview() == null || m.getOverview().isEmpty()) {
            overview.setText("<html><strong><font color=rgb(0,0,0) size=\"5\">Overview: </font></strong>"+ "N/A" + "</html>");
        } else {
            overview.setText("<html><strong><font color=rgb(0,0,0) size=\"5\">Overview: </font></strong>"+ m.getOverview() + "</html>");  
            overview.setPreferredSize(new Dimension(500, 500));
        }
        
        jTextField.setText("<html><strong>Ratings</strong></html>");
        ratings.setText(String.valueOf(m.getRatings()));
        
        add1.setToolTipText("click to add to watchlist");
        add2.setToolTipText("click to add to likelist");
        
        cards.setLayout(new GridLayout());
        int count5 = 0;
        for(Movie movie : m.getSimilarMovies()) {
            System.out.println(movie.getPoster());
            MoviePanel similarMovie = new MoviePanel(movie);
            cards.add(similarMovie);
            count5++;
            if(count5 > 4) break;
        }
        
        
//        JPanel control = new JPanel();
//        control.add(new JButton(new AbstractAction("\u22b2Prev") {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CardLayout cl = (CardLayout) cards.getLayout();
//                cl.previous(cards);
//            }
//        }));
//
//        control.add(new JButton(new AbstractAction("Next\u22b3") {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CardLayout cl = (CardLayout) cards.getLayout();
//                cl.next(cards);
//            }
//        }));
//        //jPanel1.setLayout(BorderLayout.CENTER);
//        .add(control, BorderLayout.SOUTH);
        
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        year = new javax.swing.JLabel();
        poster = new javax.swing.JLabel();
        add1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        keywords = new javax.swing.JLabel();
        director = new javax.swing.JLabel();
        cast = new javax.swing.JLabel();
        genre = new javax.swing.JLabel();
        productionCountry = new javax.swing.JLabel();
        releaseDate = new javax.swing.JLabel();
        runtime = new javax.swing.JLabel();
        langauge = new javax.swing.JLabel();
        overview = new javax.swing.JLabel();
        jTextField = new javax.swing.JLabel();
        ratings = new javax.swing.JLabel();
        add2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cards = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 600));

        title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title.setText("jLabel1");

        year.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        year.setText("jLabel1");

        poster.setBackground(new java.awt.Color(255, 0, 51));

        add1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add1.setForeground(new java.awt.Color(204, 204, 204));
        add1.setIcon(new javax.swing.ImageIcon("/Users/shenghu/Desktop/CIT 591/591 project/square.png")); // NOI18N
        add1.setBorder(null);
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(320, 400));

        id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        id.setForeground(new java.awt.Color(0, 169, 217));
        id.setText("jLabel1hrihregheoeohe");

        keywords.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        keywords.setForeground(new java.awt.Color(0, 169, 217));
        keywords.setText("jLabel1");

        director.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        director.setForeground(new java.awt.Color(0, 169, 217));
        director.setText("jLabel1");

        cast.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cast.setForeground(new java.awt.Color(0, 169, 217));
        cast.setText("jLabel1");

        genre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        genre.setForeground(new java.awt.Color(0, 169, 217));
        genre.setText("jLabel1");

        productionCountry.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productionCountry.setForeground(new java.awt.Color(0, 169, 217));
        productionCountry.setText("jLabel1");

        releaseDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        releaseDate.setForeground(new java.awt.Color(0, 169, 217));
        releaseDate.setText("jLabel1");

        runtime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        runtime.setForeground(new java.awt.Color(0, 169, 217));
        runtime.setText("jLabel1");

        langauge.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        langauge.setForeground(new java.awt.Color(0, 169, 217));
        langauge.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keywords)
                    .addComponent(id)
                    .addComponent(director)
                    .addComponent(cast)
                    .addComponent(productionCountry)
                    .addComponent(genre)
                    .addComponent(releaseDate)
                    .addComponent(runtime)
                    .addComponent(langauge))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(keywords)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(director)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(genre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(langauge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productionCountry)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(releaseDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runtime)
                .addGap(0, 108, Short.MAX_VALUE))
        );

        overview.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        overview.setForeground(new java.awt.Color(0, 169, 217));
        overview.setText("jLabel1");

        jTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField.setText("Ratings");

        ratings.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        ratings.setForeground(new java.awt.Color(0, 169, 217));
        ratings.setIcon(new javax.swing.ImageIcon("/Users/shenghu/Desktop/CIT 591/591 project/star.png")); // NOI18N
        ratings.setText("Ratings");

        add2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add2.setForeground(new java.awt.Color(204, 204, 204));
        add2.setIcon(new javax.swing.ImageIcon("/Users/shenghu/Desktop/CIT 591/591 project/square.png")); // NOI18N
        add2.setBorder(null);
        add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Similar Movies");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(year)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(poster, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(add1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(add2)))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ratings, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(overview, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title)
                    .addComponent(year))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jTextField)
                        .addGap(18, 18, 18)
                        .addComponent(ratings))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(poster, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add1)
                            .addComponent(add2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(overview)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        cards.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout cardsLayout = new javax.swing.GroupLayout(cards);
        cards.setLayout(cardsLayout);
        cardsLayout.setHorizontalGroup(
            cardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        cardsLayout.setVerticalGroup(
            cardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add1ActionPerformed

    private void add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add2ActionPerformed

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
            java.util.logging.Logger.getLogger(MoviePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MoviePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MoviePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MoviePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //id=221782/222820/197207 handle exception
                ExactSearchEngine ese = new ExactSearchEngine(268);
                ese.connect();
                Movie mo = ese.getMovie();
                new MoviePage(mo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add1;
    private javax.swing.JButton add2;
    private javax.swing.JPanel cards;
    private javax.swing.JLabel cast;
    private javax.swing.JLabel director;
    private javax.swing.JLabel genre;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jTextField;
    private javax.swing.JLabel keywords;
    private javax.swing.JLabel langauge;
    private javax.swing.JLabel overview;
    private javax.swing.JLabel poster;
    private javax.swing.JLabel productionCountry;
    private javax.swing.JLabel ratings;
    private javax.swing.JLabel releaseDate;
    private javax.swing.JLabel runtime;
    private javax.swing.JLabel title;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables
}
