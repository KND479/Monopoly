package monopoly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static monopoly.Monopoly.players;
import static monopoly.Monopoly.turn;
import static monopoly.Monopoly.spaces;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static monopoly.Player.roll1;
import static monopoly.Player.roll2;
import static monopoly.Monopoly.IMAGE_FILE;
import static monopoly.Monopoly.TITLE;

/**
 * @author r.pablo
 */
public class Board extends javax.swing.JFrame {

    public JLabel[] labels = new JLabel[8];

    private Timer musicCheck;

    /**
     * Creates new form Board
     */
    public Board() {
        initComponents();
        this.setVisible(true);
        this.setSize(1745, 2000);// change the size
        btnHouse.setEnabled(false); // set the button to be disenable so it
        // can't be used at the start
        btnSell.setEnabled(false); // set the button to be disenable so it
        // can't be used at the start

        MediaPlayer media = new MediaPlayer();
        media.playWAV("Monopoly Deluxe - Music 1.wav");
        musicCheck = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (media.isRunning() == false) {
                    media.playWAV("Monopoly Deluxe - Music 1.wav");
                }
            }
        });
        musicCheck.start();
        labels[0] = lblP1;
        labels[1] = lblP2;
        labels[2] = lblP3;
        labels[3] = lblP4;
        labels[4] = lblP5;
        labels[5] = lblP6;
        labels[6] = lblP7;
        labels[7] = lblP8;
        for (int i = 0; i < labels.length; i++) {
            labels[i].setVisible(false);
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

        lblTurn = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnHouse = new javax.swing.JButton();
        btnSell = new javax.swing.JButton();
        lblNumber = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblDeeds = new javax.swing.JLabel();
        btnEnd = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        lblP1 = new javax.swing.JLabel();
        lblP2 = new javax.swing.JLabel();
        lblP3 = new javax.swing.JLabel();
        lblP4 = new javax.swing.JLabel();
        lblP5 = new javax.swing.JLabel();
        lblP6 = new javax.swing.JLabel();
        lblP7 = new javax.swing.JLabel();
        lblP8 = new javax.swing.JLabel();
        lblDice1 = new javax.swing.JLabel();
        lblDice6 = new javax.swing.JLabel();
        lblPicture = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        lblTurn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(lblTurn);
        lblTurn.setBounds(1410, 0, 100, 20);

        btnExit.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(1320, 900, 300, 90);

        btnHouse.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btnHouse.setText("House");
        getContentPane().add(btnHouse);
        btnHouse.setBounds(1020, 900, 300, 90);

        btnSell.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btnSell.setText("Sell");
        btnSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSellActionPerformed(evt);
            }
        });
        getContentPane().add(btnSell);
        btnSell.setBounds(1320, 820, 300, 80);

        lblNumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(lblNumber);
        lblNumber.setBounds(1090, 10, 30, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setText("My Properties");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1020, 50, 130, 150);

        lblDeeds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monopoly/deeds.jpg"))); // NOI18N
        lblDeeds.setText("jLabel10");
        getContentPane().add(lblDeeds);
        lblDeeds.setBounds(1020, 50, 730, 760);

        btnEnd.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btnEnd.setText("Start");
        btnEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnd);
        btnEnd.setBounds(1020, 820, 300, 80);
        getContentPane().add(lblMessage);
        lblMessage.setBounds(1410, 20, 100, 14);

        lblP1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblP1.setForeground(new java.awt.Color(0, 204, 204));
        lblP1.setText("jLabel1");
        getContentPane().add(lblP1);
        lblP1.setBounds(640, 900, 90, 20);

        lblP2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblP2.setForeground(new java.awt.Color(0, 204, 204));
        getContentPane().add(lblP2);
        lblP2.setBounds(670, 690, 90, 14);

        lblP3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblP3.setForeground(new java.awt.Color(0, 204, 204));
        getContentPane().add(lblP3);
        lblP3.setBounds(670, 670, 90, 14);

        lblP4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblP4.setForeground(new java.awt.Color(0, 204, 204));
        getContentPane().add(lblP4);
        lblP4.setBounds(670, 710, 90, 14);

        lblP5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblP5.setForeground(new java.awt.Color(0, 204, 204));
        getContentPane().add(lblP5);
        lblP5.setBounds(670, 650, 90, 14);

        lblP6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblP6.setForeground(new java.awt.Color(0, 204, 204));
        lblP6.setText("jLabel3");
        getContentPane().add(lblP6);
        lblP6.setBounds(920, 230, 90, 14);

        lblP7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblP7.setForeground(new java.awt.Color(0, 204, 204));
        getContentPane().add(lblP7);
        lblP7.setBounds(670, 730, 90, 20);

        lblP8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblP8.setForeground(new java.awt.Color(0, 204, 204));
        getContentPane().add(lblP8);
        lblP8.setBounds(670, 630, 90, 14);
        getContentPane().add(lblDice1);
        lblDice1.setBounds(340, 480, 110, 130);
        getContentPane().add(lblDice6);
        lblDice6.setBounds(540, 480, 130, 140);

        lblPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monopoly/s-l300.jpg"))); // NOI18N
        lblPicture.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblPicture);
        lblPicture.setBounds(0, 10, 1024, 1020);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monopoly/Money1.png"))); // NOI18N
        lblBackground.setText("sa");
        getContentPane().add(lblBackground);
        lblBackground.setBounds(-30, 0, 1790, 1060);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.setVisible(false);
        JOptionPane.showMessageDialog(null, "Thanks for playing", "Monpoly", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }//GEN-LAST:event_btnExitActionPerformed


    private void btnEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndActionPerformed

        lblDice1.setVisible(false);
        lblDice6.setVisible(false);
        btnEnd.setText("End turn"); // set the text
        btnHouse.setEnabled(true); // set the button to be enable so it
        // can be used 
        btnSell.setEnabled(true); // set the button to be  enable so it
        // can be used
        if (turn == players.length) {
            turn = 0;
        } else if (turn != players.length) {
            turn++; // add the turn count
        }
        updateLabels();
        players[turn].takeTurn();
        lblDice1.setVisible(true);
        lblDice6.setVisible(true);
        lblDice1.setIcon(new javax.swing.ImageIcon("C:\\Users\\r.pablo\\Desktop\\Will and Raden FInal Project For Computer Science 30S\\Pictures\\dice" + roll1 + ".png"));
        lblDice6.setIcon(new javax.swing.ImageIcon("C:\\Users\\r.pablo\\Desktop\\Will and Raden FInal Project For Computer Science 30S\\Pictures\\dice" + roll2 + ".png"));
        updateLabels();
        System.out.println(turn);

        System.out.println("turn end");

    }//GEN-LAST:event_btnEndActionPerformed

    private void btnSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSellActionPerformed
        if (players[turn].owned == 0) {
            players[turn].output("No properties to sell!");
        } else {
            System.out.println("sell start");
            int owned = players[turn].owned;
            Space[] ownedP = findProperties();
            String[] names = new String[owned];
            for (int i = 0; i < owned; i++) {
                names[i] = ownedP[i].name;
            }
            Icon picture = new ImageIcon(IMAGE_FILE);
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Select a property to sell",
                    TITLE,
                    0,
                    0,
                    picture,
                    names,
                    0);
            ownedP[choice].sell();
            updateLabels();
        }
    }//GEN-LAST:event_btnSellActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (players[turn].owned == 0) {
            players[turn].output("No properties!");
        } else {
            Space[] ownedP = findProperties();
            int owned = players[turn].owned;
            String[] names = new String[owned];
            for (int i = 0; i < owned; i++) {
                names[i] = ownedP[i].name;
            }
            String properties = "";
            for (int i = 0; i < owned; i++) {
                properties = properties + names[i] + "\n";
            }
            players[turn].output(properties);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void startGame() {
        for (int i = 0; i < players.length; i++) {
            players[i].label.setLocation(960, (900 + players[i].YMod));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHouse;
    private javax.swing.JButton btnSell;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDeeds;
    private javax.swing.JLabel lblDice1;
    private javax.swing.JLabel lblDice6;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JLabel lblP1;
    private javax.swing.JLabel lblP2;
    private javax.swing.JLabel lblP3;
    private javax.swing.JLabel lblP4;
    private javax.swing.JLabel lblP5;
    private javax.swing.JLabel lblP6;
    private javax.swing.JLabel lblP7;
    private javax.swing.JLabel lblP8;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JLabel lblTurn;
    // End of variables declaration//GEN-END:variables

    /**
     * it updates the money
     */
    public void updateLabels() {

        // shows how munch money the player has
        lblMessage.setText("$" + Integer.toString(players[turn].cash));
        // shows the name of the player and who turn it is
        lblTurn.setText(players[turn].name + "'s turn");

    }

    private Space[] findProperties() {
        int owned = players[turn].owned;
        Space[] ownedP = new Space[owned];
        int p = 0;
        for (int i = 0; i < spaces.length; i++) {
            if (spaces[i].isProperty == true) {
                if (spaces[i].owned == true) {
                    if (spaces[i].owner == players[turn]) {
                        ownedP[p] = spaces[i];
                        p++;
                    }
                }
            }
        }
        return ownedP;
    }

}
