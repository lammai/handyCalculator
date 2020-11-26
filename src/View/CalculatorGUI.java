/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import Model.*;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import static View.BinHexCLI.performCalculation;
import static View.BinHexCLI.splitCalculation;

/**
 *
 * @author Kusanagi
 */
public class CalculatorGUI extends javax.swing.JFrame {

    /**
     * Creates new form CalculatorGUI
     */
    CardLayout cardLayout;

    public CalculatorGUI() {
        initComponents();
        jScrollPane1.setBorder(null);
        hexResultScroll.setBorder(null);
        bandwidthResultScroll.setBorder(null);
        outputDetailScroll.setBorder(null);
        browseFile = new javax.swing.JFileChooser();
        browseFile.setCurrentDirectory(new File("C:\\"));
        browseFile.setFileFilter(new FileNameExtensionFilter(".txt", "txt", "text"));
        cardLayout = (CardLayout)(calcMainPane.getLayout());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        rootPane = new javax.swing.JPanel();
        selectionPane = new javax.swing.JPanel();
        binaryTab = new javax.swing.JPanel();
        binaryLabel = new javax.swing.JLabel();
        hexTab = new javax.swing.JPanel();
        hexLabel = new javax.swing.JLabel();
        bandwidthTab = new javax.swing.JPanel();
        bandwidthLabel = new javax.swing.JLabel();
        fileIOTab = new javax.swing.JPanel();
        fileIOlabel = new javax.swing.JLabel();
        topLogo = new javax.swing.JLabel();
        closeButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        calcMainPane = new javax.swing.JPanel();
        welcomePane = new javax.swing.JPanel();
        binaryPane = new javax.swing.JPanel();
        binCalcPane = new javax.swing.JPanel();
        calcEntryText = new javax.swing.JLabel();
        calculationEntry = new javax.swing.JTextField();
        equalButton = new javax.swing.JLabel();
        clearButton = new javax.swing.JLabel();
        binaryCalculationHeader = new javax.swing.JLabel();
        calcInvalidText = new javax.swing.JLabel();
        binToDecPane = new javax.swing.JPanel();
        bin2DecHeader = new javax.swing.JLabel();
        binValueText = new javax.swing.JLabel();
        binValueEntry = new javax.swing.JTextField();
        equalBin2Dec = new javax.swing.JLabel();
        clearBin2Dec = new javax.swing.JLabel();
        decToBinPane = new javax.swing.JPanel();
        dec2BinHeader = new javax.swing.JLabel();
        decValueText = new javax.swing.JLabel();
        decValueEntry = new javax.swing.JTextField();
        equalDec2Bin = new javax.swing.JLabel();
        clearDec2Bin = new javax.swing.JLabel();
        decimalBinInvalidText = new javax.swing.JLabel();
        resultPane = new javax.swing.JPanel();
        dec2BinHeader1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        binResultArea = new javax.swing.JTextArea();
        hexPane = new javax.swing.JPanel();
        hexCalcPane = new javax.swing.JPanel();
        hexCalcText = new javax.swing.JLabel();
        hexCalcEntry = new javax.swing.JTextField();
        hexCalcEqual = new javax.swing.JLabel();
        hexCalcClear = new javax.swing.JLabel();
        hexCalcHeader = new javax.swing.JLabel();
        hexCalcInvalid = new javax.swing.JLabel();
        hexToDecPane = new javax.swing.JPanel();
        hex2DecHeader = new javax.swing.JLabel();
        hexValueText = new javax.swing.JLabel();
        hexValueEntry = new javax.swing.JTextField();
        equalHex2Dec = new javax.swing.JLabel();
        clearHex2Dec = new javax.swing.JLabel();
        decToHexPane = new javax.swing.JPanel();
        dec2HexHeader = new javax.swing.JLabel();
        decValueText1 = new javax.swing.JLabel();
        decValueEntry1 = new javax.swing.JTextField();
        equalDec2Hex = new javax.swing.JLabel();
        clearDec2Hex = new javax.swing.JLabel();
        decHexInvalid = new javax.swing.JLabel();
        hexResultPane = new javax.swing.JPanel();
        hexResultHeader = new javax.swing.JLabel();
        hexResultScroll = new javax.swing.JScrollPane();
        hexResultArea = new javax.swing.JTextArea();
        bandwidthPane = new javax.swing.JPanel();
        bandwidthActionPane = new javax.swing.JPanel();
        dataConvertPane = new javax.swing.JPanel();
        dataText = new javax.swing.JLabel();
        dataEntry = new javax.swing.JTextField();
        dataUnitCombo = new JComboBox<>();
        dataEqualButton = new javax.swing.JLabel();
        dataClearButton = new javax.swing.JLabel();
        downUpPane = new javax.swing.JPanel();
        fileSizeText = new javax.swing.JLabel();
        fileSizeEntry = new javax.swing.JTextField();
        fileSizeUnit = new JComboBox<>();
        downUpEqual = new javax.swing.JLabel();
        downUpClear = new javax.swing.JLabel();
        bandwidthText = new javax.swing.JLabel();
        bandwidthEntry = new javax.swing.JTextField();
        bandwidthUnit = new JComboBox<>();
        webBandwidthPane = new javax.swing.JPanel();
        pageViewText = new javax.swing.JLabel();
        pageViewEntry = new javax.swing.JTextField();
        pageViewUnit = new JComboBox<>();
        webBandwidthEqual = new javax.swing.JLabel();
        webBandwidthClear = new javax.swing.JLabel();
        avgPageSizeText = new javax.swing.JLabel();
        avgPageSizeEntry = new javax.swing.JTextField();
        avgPageSizeUnit = new JComboBox<>();
        redunFactorEntry = new javax.swing.JTextField();
        redunFactorText = new javax.swing.JLabel();
        hostBandwidthPane = new javax.swing.JPanel();
        monthlyUseEntry = new javax.swing.JTextField();
        monthlyUseText = new javax.swing.JLabel();
        monthlyUseUnit = new JComboBox<>();
        bandwidthHostingText = new javax.swing.JLabel();
        bandwidthHostingEntry = new javax.swing.JTextField();
        bandwidthHostingUnit = new JComboBox<>();
        hostingEqual = new javax.swing.JLabel();
        hostingClear = new javax.swing.JLabel();
        bothWaysConvertIcon = new javax.swing.JLabel();
        bandwidthResultHeader = new javax.swing.JLabel();
        bandwidthResultScroll = new javax.swing.JScrollPane();
        bandwidthResultArea = new javax.swing.JTextArea();
        filePane = new javax.swing.JPanel();
        browseButton = new javax.swing.JButton();
        fileIOheader = new javax.swing.JLabel();
        outputDetailScroll = new javax.swing.JScrollPane();
        outputDetailArea = new javax.swing.JTextArea();
        pathEntry = new javax.swing.JTextField();
        pathText = new javax.swing.JLabel();
        fillerImage = new javax.swing.JLabel();
        welcomeImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        rootPane.setBackground(new java.awt.Color(51, 51, 51));
        rootPane.setPreferredSize(new java.awt.Dimension(900, 600));
        rootPane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                rootPaneMouseDragged(evt);
            }
        });
        rootPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rootPaneMousePressed(evt);
            }
        });

        selectionPane.setBackground(new java.awt.Color(26, 26, 26));
        selectionPane.setPreferredSize(new java.awt.Dimension(318, 500));

        binaryTab.setBackground(new java.awt.Color(15, 15, 15));
        binaryTab.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        binaryTab.setPreferredSize(new java.awt.Dimension(144, 54));
        binaryTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                binaryTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                binaryTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                binaryTabMousePressed(evt);
            }
        });

        binaryLabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        binaryLabel.setForeground(new java.awt.Color(255, 255, 255));
        binaryLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_binary_file_25px.png"))); // NOI18N
        binaryLabel.setText("Binary");
        binaryTab.add(binaryLabel);

        hexTab.setBackground(new java.awt.Color(15, 15, 15));
        hexTab.setPreferredSize(new java.awt.Dimension(318, 54));
        hexTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hexTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hexTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hexTabMousePressed(evt);
            }
        });

        hexLabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        hexLabel.setForeground(new java.awt.Color(255, 255, 255));
        hexLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_hexadecimal_25px.png"))); // NOI18N
        hexLabel.setText("Hexadecimal");
        hexTab.add(hexLabel);

        bandwidthTab.setBackground(new java.awt.Color(15, 15, 15));
        bandwidthTab.setPreferredSize(new java.awt.Dimension(196, 54));
        bandwidthTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bandwidthTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bandwidthTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bandwidthTabMousePressed(evt);
            }
        });

        bandwidthLabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        bandwidthLabel.setForeground(new java.awt.Color(255, 255, 255));
        bandwidthLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_outgoing_data_25px.png"))); // NOI18N
        bandwidthLabel.setText("Bandwidth");
        bandwidthTab.add(bandwidthLabel);

        fileIOTab.setBackground(new java.awt.Color(15, 15, 15));
        fileIOTab.setPreferredSize(new java.awt.Dimension(196, 54));
        fileIOTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fileIOTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fileIOTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fileIOTabMousePressed(evt);
            }
        });

        fileIOlabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        fileIOlabel.setForeground(new java.awt.Color(255, 255, 255));
        fileIOlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_txt_25px.png"))); // NOI18N
        fileIOlabel.setText("File I/O");
        fileIOTab.add(fileIOlabel);

        topLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/topLogoAsset 18.png"))); // NOI18N

        fillerImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fillerAsset 24.png"))); // NOI18N

        javax.swing.GroupLayout selectionPaneLayout = new javax.swing.GroupLayout(selectionPane);
        selectionPane.setLayout(selectionPaneLayout);
        selectionPaneLayout.setHorizontalGroup(
                selectionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(binaryTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hexTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bandwidthTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fileIOTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(selectionPaneLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(topLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectionPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(fillerImage))
        );
        selectionPaneLayout.setVerticalGroup(
                selectionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(selectionPaneLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(topLogo)
                                .addGap(0, 0, 0)
                                .addComponent(binaryTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(hexTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(bandwidthTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(fileIOTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(fillerImage)
                                .addContainerGap())
        );

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_close_window_25px.png"))); // NOI18N
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeButtonMousePressed(evt);
            }
        });

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_minimize_window_25px.png"))); // NOI18N
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizeButtonMousePressed(evt);
            }
        });

        calcMainPane.setLayout(new java.awt.CardLayout());

        welcomePane.setBackground(new java.awt.Color(51, 51, 51));

        welcomeImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/welcomeImageAsset 28.png"))); // NOI18N

        javax.swing.GroupLayout welcomePaneLayout = new javax.swing.GroupLayout(welcomePane);
        welcomePane.setLayout(welcomePaneLayout);
        welcomePaneLayout.setHorizontalGroup(
                welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomePaneLayout.createSequentialGroup()
                                .addContainerGap(150, Short.MAX_VALUE)
                                .addComponent(welcomeImage)
                                .addGap(150, 150, 150))
        );
        welcomePaneLayout.setVerticalGroup(
                welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePaneLayout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(welcomeImage)
                                .addContainerGap(229, Short.MAX_VALUE))
        );

        calcMainPane.add(welcomePane, "card6");

        binaryPane.setBackground(new java.awt.Color(51, 51, 51));
        binaryPane.setLayout(new java.awt.GridLayout(4, 1));

        binCalcPane.setBackground(new java.awt.Color(51, 51, 51));

        calcEntryText.setForeground(new java.awt.Color(255, 255, 255));
        calcEntryText.setText("Input Binary Calculation:");

        calculationEntry.setText("1010 + 1010");
        calculationEntry.setPreferredSize(new java.awt.Dimension(300, 30));
        calculationEntry.setSelectionColor(new java.awt.Color(204, 204, 204));
        calculationEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                calculationEntryFocusGained(evt);
            }
        });
        calculationEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                calculationEntryKeyTyped(evt);
            }
        });

        equalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        equalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equalButtonMouseClicked(evt);
            }
        });

        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
        });

        binaryCalculationHeader.setFont(new java.awt.Font("Corbel Light", 0, 24)); // NOI18N
        binaryCalculationHeader.setForeground(new java.awt.Color(255, 255, 255));
        binaryCalculationHeader.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        binaryCalculationHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        binaryCalculationHeader.setText("Binary Calculation");
        binaryCalculationHeader.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        calcInvalidText.setForeground(new java.awt.Color(255, 51, 51));
        calcInvalidText.setText("Invalid input!");
        calcInvalidText.setVisible(false);

        javax.swing.GroupLayout binCalcPaneLayout = new javax.swing.GroupLayout(binCalcPane);
        binCalcPane.setLayout(binCalcPaneLayout);
        binCalcPaneLayout.setHorizontalGroup(
                binCalcPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(binCalcPaneLayout.createSequentialGroup()
                                .addGroup(binCalcPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(binCalcPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(binaryCalculationHeader))
                                        .addGroup(binCalcPaneLayout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(calcEntryText)
                                                .addGap(5, 5, 5)
                                                .addGroup(binCalcPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(binCalcPaneLayout.createSequentialGroup()
                                                                .addGap(0, 0, 0)
                                                                .addComponent(calcInvalidText)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(equalButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(clearButton))
                                                        .addComponent(calculationEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(70, Short.MAX_VALUE))
        );
        binCalcPaneLayout.setVerticalGroup(
                binCalcPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, binCalcPaneLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(binaryCalculationHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(binCalcPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(binCalcPaneLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(calcEntryText))
                                        .addComponent(calculationEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(binCalcPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(equalButton)
                                        .addComponent(clearButton)
                                        .addComponent(calcInvalidText))
                                .addContainerGap())
        );

        binaryPane.add(binCalcPane);

        binToDecPane.setBackground(new java.awt.Color(51, 51, 51));

        bin2DecHeader.setFont(new java.awt.Font("Corbel Light", 0, 24)); // NOI18N
        bin2DecHeader.setForeground(new java.awt.Color(255, 255, 255));
        bin2DecHeader.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        bin2DecHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        bin2DecHeader.setText("Binary to Decimal");
        bin2DecHeader.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        binValueText.setForeground(new java.awt.Color(255, 255, 255));
        binValueText.setText("Binary value:");

        binValueEntry.setText("1000001");
        binValueEntry.setPreferredSize(new java.awt.Dimension(300, 30));
        binValueEntry.setSelectionColor(new java.awt.Color(204, 204, 204));
        binValueEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                binValueEntryFocusGained(evt);
            }
        });
        binValueEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                binValueEntryKeyTyped(evt);
            }
        });

        equalBin2Dec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        equalBin2Dec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equalBin2DecMouseClicked(evt);
            }
        });

        clearBin2Dec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        clearBin2Dec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBin2DecMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout binToDecPaneLayout = new javax.swing.GroupLayout(binToDecPane);
        binToDecPane.setLayout(binToDecPaneLayout);
        binToDecPaneLayout.setHorizontalGroup(
                binToDecPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(binToDecPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bin2DecHeader)
                                .addContainerGap(72, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, binToDecPaneLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(binToDecPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(binToDecPaneLayout.createSequentialGroup()
                                                .addComponent(equalBin2Dec)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clearBin2Dec))
                                        .addGroup(binToDecPaneLayout.createSequentialGroup()
                                                .addComponent(binValueText)
                                                .addGap(5, 5, 5)
                                                .addComponent(binValueEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(101, 101, 101))
        );
        binToDecPaneLayout.setVerticalGroup(
                binToDecPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, binToDecPaneLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(bin2DecHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(binToDecPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(binToDecPaneLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(binValueText))
                                        .addComponent(binValueEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(binToDecPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(equalBin2Dec)
                                        .addComponent(clearBin2Dec))
                                .addGap(16, 16, 16))
        );

        binaryPane.add(binToDecPane);

        decToBinPane.setBackground(new java.awt.Color(51, 51, 51));

        dec2BinHeader.setFont(new java.awt.Font("Corbel Light", 0, 24)); // NOI18N
        dec2BinHeader.setForeground(new java.awt.Color(255, 255, 255));
        dec2BinHeader.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dec2BinHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        dec2BinHeader.setText("Decimal to Binary");
        dec2BinHeader.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        decValueText.setForeground(new java.awt.Color(255, 255, 255));
        decValueText.setText("Decimal value:");

        decValueEntry.setText("12345");
        decValueEntry.setPreferredSize(new java.awt.Dimension(300, 30));
        decValueEntry.setSelectionColor(new java.awt.Color(204, 204, 204));
        decValueEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                decValueEntryFocusGained(evt);
            }
        });
        decValueEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                decValueEntryKeyTyped(evt);
            }
        });

        equalDec2Bin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        equalDec2Bin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equalDec2BinMouseClicked(evt);
            }
        });

        clearDec2Bin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        clearDec2Bin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearDec2BinMouseClicked(evt);
            }
        });

        decimalBinInvalidText.setForeground(new java.awt.Color(255, 51, 51));
        decimalBinInvalidText.setText("Invalid input!");
        decimalBinInvalidText.setVisible(false);

        javax.swing.GroupLayout decToBinPaneLayout = new javax.swing.GroupLayout(decToBinPane);
        decToBinPane.setLayout(decToBinPaneLayout);
        decToBinPaneLayout.setHorizontalGroup(
                decToBinPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(decToBinPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dec2BinHeader)
                                .addContainerGap(72, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, decToBinPaneLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(decValueText)
                                .addGap(5, 5, 5)
                                .addGroup(decToBinPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(decToBinPaneLayout.createSequentialGroup()
                                                .addComponent(decimalBinInvalidText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(equalDec2Bin)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clearDec2Bin))
                                        .addComponent(decValueEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(101, 101, 101))
        );
        decToBinPaneLayout.setVerticalGroup(
                decToBinPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, decToBinPaneLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(dec2BinHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(decToBinPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(decToBinPaneLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(decValueText))
                                        .addComponent(decValueEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(decToBinPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(decToBinPaneLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(decToBinPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(equalDec2Bin)
                                                        .addComponent(clearDec2Bin)))
                                        .addGroup(decToBinPaneLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(decimalBinInvalidText)))
                                .addGap(16, 16, 16))
        );

        binaryPane.add(decToBinPane);

        resultPane.setBackground(new java.awt.Color(51, 51, 51));

        dec2BinHeader1.setFont(new java.awt.Font("Corbel Light", 0, 24)); // NOI18N
        dec2BinHeader1.setForeground(new java.awt.Color(255, 255, 255));
        dec2BinHeader1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dec2BinHeader1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        dec2BinHeader1.setText("Result");
        dec2BinHeader1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        binResultArea.setEditable(false);
        binResultArea.setBackground(new java.awt.Color(51, 51, 51));
        binResultArea.setColumns(20);
        binResultArea.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        binResultArea.setForeground(new java.awt.Color(255, 255, 255));
        binResultArea.setRows(5);
        binResultArea.setBorder(null);
        binResultArea.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(binResultArea);

        javax.swing.GroupLayout resultPaneLayout = new javax.swing.GroupLayout(resultPane);
        resultPane.setLayout(resultPaneLayout);
        resultPaneLayout.setHorizontalGroup(
                resultPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(resultPaneLayout.createSequentialGroup()
                                .addContainerGap(123, Short.MAX_VALUE)
                                .addComponent(dec2BinHeader1)
                                .addGap(69, 69, 69))
                        .addGroup(resultPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
        );
        resultPaneLayout.setVerticalGroup(
                resultPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(resultPaneLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(dec2BinHeader1)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );

        binaryPane.add(resultPane);

        calcMainPane.add(binaryPane, "binaryCard");

        hexPane.setBackground(new java.awt.Color(51, 51, 51));
        hexPane.setLayout(new java.awt.GridLayout(4,1));

        hexCalcPane.setBackground(new java.awt.Color(51, 51, 51));

        hexCalcText.setForeground(new java.awt.Color(255, 255, 255));
        hexCalcText.setText("Input Hex Calculation:");

        hexCalcEntry.setText("EA + BAD");
        hexCalcEntry.setPreferredSize(new java.awt.Dimension(300, 30));
        hexCalcEntry.setSelectionColor(new java.awt.Color(204, 204, 204));
        hexCalcEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hexCalcEntryFocusGained(evt);
            }
        });
        hexCalcEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hexCalcEntryKeyTyped(evt);
            }
        });

        hexCalcEqual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        hexCalcEqual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hexCalcEqualMouseClicked(evt);
            }
        });

        hexCalcClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        hexCalcClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hexCalcClearMouseClicked(evt);
            }
        });

        hexCalcHeader.setFont(new java.awt.Font("Corbel Light", 0, 24)); // NOI18N
        hexCalcHeader.setForeground(new java.awt.Color(255, 255, 255));
        hexCalcHeader.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        hexCalcHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        hexCalcHeader.setText("Hex Calculation");
        hexCalcHeader.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        hexCalcInvalid.setForeground(new java.awt.Color(255, 51, 51));
        hexCalcInvalid.setText("Invalid input!");
        hexCalcInvalid.setVisible(false);

        javax.swing.GroupLayout hexCalcPaneLayout = new javax.swing.GroupLayout(hexCalcPane);
        hexCalcPane.setLayout(hexCalcPaneLayout);
        hexCalcPaneLayout.setHorizontalGroup(
                hexCalcPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hexCalcPaneLayout.createSequentialGroup()
                                .addGroup(hexCalcPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(hexCalcPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(hexCalcHeader))
                                        .addGroup(hexCalcPaneLayout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(hexCalcText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(hexCalcPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(hexCalcPaneLayout.createSequentialGroup()
                                                                .addComponent(hexCalcInvalid)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(hexCalcEqual)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(hexCalcClear))
                                                        .addComponent(hexCalcEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(95, Short.MAX_VALUE))
        );
        hexCalcPaneLayout.setVerticalGroup(
                hexCalcPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hexCalcPaneLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(hexCalcHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(hexCalcPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(hexCalcPaneLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(hexCalcText))
                                        .addComponent(hexCalcEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hexCalcPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hexCalcEqual)
                                        .addComponent(hexCalcClear)
                                        .addComponent(hexCalcInvalid))
                                .addContainerGap())
        );

        hexPane.add(hexCalcPane);

        hexToDecPane.setBackground(new java.awt.Color(51, 51, 51));

        hex2DecHeader.setFont(new java.awt.Font("Corbel Light", 0, 24)); // NOI18N
        hex2DecHeader.setForeground(new java.awt.Color(255, 255, 255));
        hex2DecHeader.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        hex2DecHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        hex2DecHeader.setText("Hex to Decimal");
        hex2DecHeader.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        hexValueText.setForeground(new java.awt.Color(255, 255, 255));
        hexValueText.setText("Hex value:");

        hexValueEntry.setText("1F1F1F");
        hexValueEntry.setPreferredSize(new java.awt.Dimension(300, 30));
        hexValueEntry.setSelectionColor(new java.awt.Color(204, 204, 204));
        hexValueEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hexValueEntryFocusGained(evt);
            }
        });
        hexValueEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hexValueEntryKeyTyped(evt);
            }
        });

        equalHex2Dec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        equalHex2Dec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equalHex2DecMouseClicked(evt);
            }
        });

        clearHex2Dec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        clearHex2Dec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearHex2DecMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hexToDecPaneLayout = new javax.swing.GroupLayout(hexToDecPane);
        hexToDecPane.setLayout(hexToDecPaneLayout);
        hexToDecPaneLayout.setHorizontalGroup(
                hexToDecPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hexToDecPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(hex2DecHeader)
                                .addContainerGap(97, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hexToDecPaneLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(hexToDecPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(hexToDecPaneLayout.createSequentialGroup()
                                                .addComponent(equalHex2Dec)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clearHex2Dec))
                                        .addGroup(hexToDecPaneLayout.createSequentialGroup()
                                                .addComponent(hexValueText)
                                                .addGap(5, 5, 5)
                                                .addComponent(hexValueEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(101, 101, 101))
        );
        hexToDecPaneLayout.setVerticalGroup(
                hexToDecPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hexToDecPaneLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(hex2DecHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hexToDecPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(hexToDecPaneLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(hexValueText))
                                        .addComponent(hexValueEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hexToDecPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(equalHex2Dec)
                                        .addComponent(clearHex2Dec))
                                .addGap(16, 16, 16))
        );

        hexPane.add(hexToDecPane);

        decToHexPane.setBackground(new java.awt.Color(51, 51, 51));

        dec2HexHeader.setFont(new java.awt.Font("Corbel Light", 0, 24)); // NOI18N
        dec2HexHeader.setForeground(new java.awt.Color(255, 255, 255));
        dec2HexHeader.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dec2HexHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        dec2HexHeader.setText("Decimal to Hex");
        dec2HexHeader.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        decValueText1.setForeground(new java.awt.Color(255, 255, 255));
        decValueText1.setText("Decimal value:");

        decValueEntry1.setText("12345");
        decValueEntry1.setPreferredSize(new java.awt.Dimension(300, 30));
        decValueEntry1.setSelectionColor(new java.awt.Color(204, 204, 204));
        decValueEntry1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                decValueEntry1FocusGained(evt);
            }
        });
        decValueEntry1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                decValueEntryKeyTyped(evt);
            }
        });

        equalDec2Hex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        equalDec2Hex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equalDec2HexMouseClicked(evt);
            }
        });

        clearDec2Hex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        clearDec2Hex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearDec2HexMouseClicked(evt);
            }
        });

        decHexInvalid.setForeground(new java.awt.Color(255, 51, 51));
        decHexInvalid.setText("Invalid input!");
        decHexInvalid.setVisible(false);

        javax.swing.GroupLayout decToHexPaneLayout = new javax.swing.GroupLayout(decToHexPane);
        decToHexPane.setLayout(decToHexPaneLayout);
        decToHexPaneLayout.setHorizontalGroup(
                decToHexPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(decToHexPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dec2HexHeader)
                                .addContainerGap(97, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, decToHexPaneLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(decValueText1)
                                .addGap(5, 5, 5)
                                .addGroup(decToHexPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(decToHexPaneLayout.createSequentialGroup()
                                                .addComponent(decHexInvalid)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(equalDec2Hex)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clearDec2Hex))
                                        .addComponent(decValueEntry1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(101, 101, 101))
        );
        decToHexPaneLayout.setVerticalGroup(
                decToHexPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, decToHexPaneLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(dec2HexHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(decToHexPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(decToHexPaneLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(decValueText1))
                                        .addComponent(decValueEntry1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(decToHexPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(equalDec2Hex)
                                        .addComponent(clearDec2Hex)
                                        .addComponent(decHexInvalid))
                                .addGap(16, 16, 16))
        );

        hexPane.add(decToHexPane);

        hexResultPane.setBackground(new java.awt.Color(51, 51, 51));

        hexResultHeader.setFont(new java.awt.Font("Corbel Light", 0, 24)); // NOI18N
        hexResultHeader.setForeground(new java.awt.Color(255, 255, 255));
        hexResultHeader.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        hexResultHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        hexResultHeader.setText("Result");
        hexResultHeader.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        hexResultArea.setEditable(false);
        hexResultArea.setBackground(new java.awt.Color(51, 51, 51));
        hexResultArea.setColumns(20);
        hexResultArea.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        hexResultArea.setForeground(new java.awt.Color(255, 255, 255));
        hexResultArea.setRows(5);
        hexResultArea.setBorder(null);
        hexResultArea.setSelectionColor(new java.awt.Color(0, 0, 0));
        hexResultScroll.setViewportView(hexResultArea);

        javax.swing.GroupLayout hexResultPaneLayout = new javax.swing.GroupLayout(hexResultPane);
        hexResultPane.setLayout(hexResultPaneLayout);
        hexResultPaneLayout.setHorizontalGroup(
                hexResultPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hexResultPaneLayout.createSequentialGroup()
                                .addContainerGap(123, Short.MAX_VALUE)
                                .addComponent(hexResultHeader)
                                .addGap(69, 69, 69))
                        .addGroup(hexResultPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(hexResultScroll)
                                .addContainerGap())
        );
        hexResultPaneLayout.setVerticalGroup(
                hexResultPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hexResultPaneLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(hexResultHeader)
                                .addGap(0, 0, 0)
                                .addComponent(hexResultScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
        );

        hexPane.add(hexResultPane);

        calcMainPane.add(hexPane, "hexCard");

        bandwidthPane.setBackground(new java.awt.Color(51, 51, 51));

        bandwidthActionPane.setBackground(new java.awt.Color(51, 51, 51));
        bandwidthActionPane.setLayout(new java.awt.GridLayout(2, 2));

        dataConvertPane.setBackground(new java.awt.Color(51, 51, 51));
        dataConvertPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Data Unit Converter"), "Data Unit Converter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Corbel Light", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        dataText.setForeground(new java.awt.Color(255, 255, 255));
        dataText.setText("Data Value:");

        dataEntry.setText("500");
        dataEntry.setPreferredSize(new java.awt.Dimension(7, 24));
        dataEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dataEntryFocusGained(evt);
            }
        });
        dataEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        dataUnitCombo.setModel(new DefaultComboBoxModel<>(SizeUnit.Size.values()));
        dataUnitCombo.setSelectedIndex(7);  // set default selection to Megabytes (MB)

        dataEqualButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        dataEqualButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataEqualButtonMouseClicked(evt);
            }
        });

        dataClearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        dataClearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataClearButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dataConvertPaneLayout = new javax.swing.GroupLayout(dataConvertPane);
        dataConvertPane.setLayout(dataConvertPaneLayout);
        dataConvertPaneLayout.setHorizontalGroup(
                dataConvertPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataConvertPaneLayout.createSequentialGroup()
                                .addGroup(dataConvertPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(dataConvertPaneLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(dataEqualButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dataClearButton))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dataConvertPaneLayout.createSequentialGroup()
                                                .addComponent(dataEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dataUnitCombo, 0, 116, Short.MAX_VALUE))
                                        .addComponent(dataText, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, 0))
        );
        dataConvertPaneLayout.setVerticalGroup(
                dataConvertPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dataConvertPaneLayout.createSequentialGroup()
                                .addComponent(dataText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dataConvertPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dataEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dataUnitCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dataConvertPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dataEqualButton)
                                        .addComponent(dataClearButton))
                                .addGap(0, 67, Short.MAX_VALUE))
        );

        bandwidthActionPane.add(dataConvertPane);

        downUpPane.setBackground(new java.awt.Color(51, 51, 51));
        downUpPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Download/Upload Time Calculator", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Corbel Light", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        fileSizeText.setForeground(new java.awt.Color(255, 255, 255));
        fileSizeText.setText("File Size:");

        fileSizeEntry.setText("500");
        fileSizeEntry.setPreferredSize(new java.awt.Dimension(7, 24));
        fileSizeEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fileSizeEntryFocusGained(evt);
            }
        });
        fileSizeEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        SizeUnit.Size[] units = SizeUnit.Size.values();
        for (int i = 5; i < units.length; i++) {    // Only add Bytes to Terabytes to the combo box
            fileSizeUnit.addItem(units[i]);
            avgPageSizeUnit.addItem(units[i]);
            monthlyUseUnit.addItem(units[i]);
        }
        fileSizeUnit.setSelectedIndex(2);   // set default selection to Megabytes (MB)
        avgPageSizeUnit.setSelectedIndex(1);   // set default selection to Kilobytes (KB)

        downUpEqual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        downUpEqual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downUpEqualMouseClicked(evt);
            }
        });

        downUpClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        downUpClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downUpClearMouseClicked(evt);
            }
        });

        bandwidthText.setForeground(new java.awt.Color(255, 255, 255));
        bandwidthText.setText("Bandwidth:");

        bandwidthEntry.setText("5");
        bandwidthEntry.setPreferredSize(new java.awt.Dimension(7, 24));
        bandwidthEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bandwidthEntryFocusGained(evt);
            }
        });
        bandwidthEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        bandwidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(RateUnit.Rate.values()));
        bandwidthUnit.setSelectedIndex(2);  // Set default selection to Mbit/s

        javax.swing.GroupLayout downUpPaneLayout = new javax.swing.GroupLayout(downUpPane);
        downUpPane.setLayout(downUpPaneLayout);
        downUpPaneLayout.setHorizontalGroup(
                downUpPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, downUpPaneLayout.createSequentialGroup()
                                .addGroup(downUpPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(downUpPaneLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(downUpEqual)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(downUpClear))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, downUpPaneLayout.createSequentialGroup()
                                                .addComponent(fileSizeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fileSizeUnit, 0, 120, Short.MAX_VALUE))
                                        .addComponent(fileSizeText, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, downUpPaneLayout.createSequentialGroup()
                                                .addComponent(bandwidthEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bandwidthUnit, 0, 120, Short.MAX_VALUE))
                                        .addComponent(bandwidthText, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, 0))
        );
        downUpPaneLayout.setVerticalGroup(
                downUpPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(downUpPaneLayout.createSequentialGroup()
                                .addComponent(fileSizeText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(downUpPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fileSizeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fileSizeUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(bandwidthText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(downUpPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bandwidthEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bandwidthUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(downUpPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(downUpEqual)
                                        .addComponent(downUpClear))
                                .addContainerGap())
        );

        bandwidthActionPane.add(downUpPane);

        webBandwidthPane.setBackground(new java.awt.Color(51, 51, 51));
        webBandwidthPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Website Bandwidth Calculator", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Corbel Light", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        pageViewText.setForeground(new java.awt.Color(255, 255, 255));
        pageViewText.setText("Page Views:");

        pageViewEntry.setText("5000");
        pageViewEntry.setPreferredSize(new java.awt.Dimension(7, 24));
        pageViewEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pageViewEntryFocusGained(evt);
            }
        });
        pageViewEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        pageViewUnit.setModel(new javax.swing.DefaultComboBoxModel<>(TimeUnit.Time.values()));
        pageViewUnit.setSelectedIndex(3);

        webBandwidthEqual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        webBandwidthEqual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                webBandwidthEqualMouseClicked(evt);
            }
        });

        webBandwidthClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        webBandwidthClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                webBandwidthClearMouseClicked(evt);
            }
        });

        avgPageSizeText.setForeground(new java.awt.Color(255, 255, 255));
        avgPageSizeText.setText("Average Page Size:");

        avgPageSizeEntry.setText("500");
        avgPageSizeEntry.setPreferredSize(new java.awt.Dimension(7, 24));
        avgPageSizeEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                avgPageSizeEntryFocusGained(evt);
            }
        });
        avgPageSizeEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        redunFactorEntry.setText("2");
        redunFactorEntry.setPreferredSize(new java.awt.Dimension(7, 24));
        redunFactorEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                redunFactorEntryFocusGained(evt);
            }
        });
        redunFactorEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        redunFactorText.setForeground(new java.awt.Color(255, 255, 255));
        redunFactorText.setText("Redundancy Factor:");

        javax.swing.GroupLayout webBandwidthPaneLayout = new javax.swing.GroupLayout(webBandwidthPane);
        webBandwidthPane.setLayout(webBandwidthPaneLayout);
        webBandwidthPaneLayout.setHorizontalGroup(
                webBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(webBandwidthPaneLayout.createSequentialGroup()
                                .addComponent(pageViewEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pageViewUnit, 0, 120, Short.MAX_VALUE))
                        .addGroup(webBandwidthPaneLayout.createSequentialGroup()
                                .addComponent(avgPageSizeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avgPageSizeUnit, 0, 120, Short.MAX_VALUE))
                        .addGroup(webBandwidthPaneLayout.createSequentialGroup()
                                .addGroup(webBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(pageViewText, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(avgPageSizeText, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(webBandwidthPaneLayout.createSequentialGroup()
                                .addGroup(webBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(redunFactorText)
                                        .addComponent(redunFactorEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(webBandwidthEqual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(webBandwidthClear))
        );
        webBandwidthPaneLayout.setVerticalGroup(
                webBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(webBandwidthPaneLayout.createSequentialGroup()
                                .addComponent(pageViewText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(webBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pageViewEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pageViewUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(webBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(webBandwidthPaneLayout.createSequentialGroup()
                                                .addComponent(avgPageSizeText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(webBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(avgPageSizeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(avgPageSizeUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(redunFactorText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(redunFactorEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(webBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(webBandwidthEqual)
                                                .addComponent(webBandwidthClear)))
                                .addGap(23, 23, 23))
        );

        bandwidthActionPane.add(webBandwidthPane);

        hostBandwidthPane.setBackground(new java.awt.Color(51, 51, 51));
        hostBandwidthPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hosting Bandwidth Converter", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Corbel Light", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        monthlyUseEntry.setText("1000");
        monthlyUseEntry.setPreferredSize(new java.awt.Dimension(7, 24));
        monthlyUseEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                monthlyUseEntryFocusGained(evt);
            }
        });
        monthlyUseEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        monthlyUseText.setForeground(new java.awt.Color(255, 255, 255));
        monthlyUseText.setText("Monthly Usage:");

        bandwidthHostingText.setForeground(new java.awt.Color(255, 255, 255));
        bandwidthHostingText.setText("Bandwidth:");

        bandwidthHostingEntry.setPreferredSize(new java.awt.Dimension(7, 24));
        bandwidthHostingEntry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bandwidthHostingEntryFocusGained(evt);
            }
        });
        bandwidthHostingEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        bandwidthHostingUnit.setModel(new javax.swing.DefaultComboBoxModel<>(RateUnit.Rate.values()));

        hostingEqual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        hostingEqual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hostingEqualMouseClicked(evt);
            }
        });

        hostingClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        hostingClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hostingClearMouseClicked(evt);
            }
        });

        bothWaysConvertIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_up_down_arrow_36px.png"))); // NOI18N
        bothWaysConvertIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bothWaysConvertIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hostBandwidthPaneLayout = new javax.swing.GroupLayout(hostBandwidthPane);
        hostBandwidthPane.setLayout(hostBandwidthPaneLayout);
        hostBandwidthPaneLayout.setHorizontalGroup(
                hostBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hostBandwidthPaneLayout.createSequentialGroup()
                                .addComponent(bandwidthHostingEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bandwidthHostingUnit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(hostBandwidthPaneLayout.createSequentialGroup()
                                .addGroup(hostBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(hostBandwidthPaneLayout.createSequentialGroup()
                                                .addComponent(monthlyUseEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hostBandwidthPaneLayout.createSequentialGroup()
                                                .addComponent(bothWaysConvertIcon)
                                                .addGap(56, 56, 56)))
                                .addGroup(hostBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(hostBandwidthPaneLayout.createSequentialGroup()
                                                .addComponent(hostingEqual)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(hostingClear)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(monthlyUseUnit, 0, 120, Short.MAX_VALUE)))
                        .addGroup(hostBandwidthPaneLayout.createSequentialGroup()
                                .addGroup(hostBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(monthlyUseText)
                                        .addComponent(bandwidthHostingText))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        hostBandwidthPaneLayout.setVerticalGroup(
                hostBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hostBandwidthPaneLayout.createSequentialGroup()
                                .addComponent(monthlyUseText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hostBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(monthlyUseEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(monthlyUseUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(hostBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hostingEqual)
                                        .addComponent(hostingClear)
                                        .addComponent(bothWaysConvertIcon))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bandwidthHostingText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hostBandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bandwidthHostingEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bandwidthHostingUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        bandwidthActionPane.add(hostBandwidthPane);

        bandwidthResultHeader.setFont(new java.awt.Font("Corbel Light", 0, 24)); // NOI18N
        bandwidthResultHeader.setForeground(new java.awt.Color(255, 255, 255));
        bandwidthResultHeader.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        bandwidthResultHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        bandwidthResultHeader.setText("Result");
        bandwidthResultHeader.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        bandwidthResultArea.setEditable(false);
        bandwidthResultArea.setBackground(new java.awt.Color(51, 51, 51));
        bandwidthResultArea.setColumns(20);
        bandwidthResultArea.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        bandwidthResultArea.setForeground(new java.awt.Color(255, 255, 255));
        bandwidthResultArea.setRows(5);
        bandwidthResultArea.setBorder(null);
        bandwidthResultArea.setSelectionColor(new java.awt.Color(0, 0, 0));
        bandwidthResultScroll.setViewportView(bandwidthResultArea);

        javax.swing.GroupLayout bandwidthPaneLayout = new javax.swing.GroupLayout(bandwidthPane);
        bandwidthPane.setLayout(bandwidthPaneLayout);
        bandwidthPaneLayout.setHorizontalGroup(
                bandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bandwidthActionPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bandwidthPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bandwidthResultScroll)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bandwidthPaneLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bandwidthResultHeader)
                                .addGap(65, 65, 65))
        );
        bandwidthPaneLayout.setVerticalGroup(
                bandwidthPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bandwidthPaneLayout.createSequentialGroup()
                                .addComponent(bandwidthActionPane, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bandwidthResultHeader)
                                .addGap(0, 0, 0)
                                .addComponent(bandwidthResultScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );

        calcMainPane.add(bandwidthPane, "bandwidthCard");

        filePane.setBackground(new java.awt.Color(51, 51, 51));

        fileIOheader.setFont(new java.awt.Font("Corbel Light", 0, 24)); // NOI18N
        fileIOheader.setForeground(new java.awt.Color(255, 255, 255));
        fileIOheader.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        fileIOheader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        fileIOheader.setText("Batch Operation");
        fileIOheader.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        pathText.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        pathText.setForeground(new java.awt.Color(255, 255, 255));
        pathText.setText("Path to Text File:");

        pathEntry.setText("C:\\Users\\ExampleUser\\Desktop\\exampleFile.txt");
        pathEntry.setEditable(false);

        browseButton.setText("Browse...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        outputDetailScroll.setToolTipText("");

        outputDetailArea.setEditable(false);
        outputDetailArea.setBackground(new java.awt.Color(51, 51, 51));
        outputDetailArea.setColumns(20);
        outputDetailArea.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        outputDetailArea.setForeground(new java.awt.Color(255, 255, 255));
        outputDetailArea.setRows(5);
        outputDetailArea.setBorder(null);
        outputDetailArea.setSelectionColor(new java.awt.Color(0, 0, 0));
        outputDetailScroll.setViewportView(outputDetailArea);

        javax.swing.GroupLayout filePaneLayout = new javax.swing.GroupLayout(filePane);
        filePane.setLayout(filePaneLayout);
        filePaneLayout.setHorizontalGroup(
                filePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(filePaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(filePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(filePaneLayout.createSequentialGroup()
                                                .addComponent(outputDetailScroll)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filePaneLayout.createSequentialGroup()
                                                .addGap(0, 33, Short.MAX_VALUE)
                                                .addGroup(filePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filePaneLayout.createSequentialGroup()
                                                                .addGroup(filePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(pathText)
                                                                        .addComponent(fileIOheader))
                                                                .addGap(66, 66, 66))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filePaneLayout.createSequentialGroup()
                                                                .addComponent(pathEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(browseButton)
                                                                .addGap(48, 48, 48))))))
        );
        filePaneLayout.setVerticalGroup(
                filePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(filePaneLayout.createSequentialGroup()
                                .addComponent(fileIOheader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pathText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(filePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pathEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(browseButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outputDetailScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
        );

        calcMainPane.add(filePane, "fileCard");

        javax.swing.GroupLayout rootPaneLayout = new javax.swing.GroupLayout(rootPane);
        rootPane.setLayout(rootPaneLayout);
        rootPaneLayout.setHorizontalGroup(
                rootPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(rootPaneLayout.createSequentialGroup()
                                .addComponent(selectionPane, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(rootPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(calcMainPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(rootPaneLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(minimizeButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(closeButton))))
        );
        rootPaneLayout.setVerticalGroup(
                rootPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(rootPaneLayout.createSequentialGroup()
                                .addGroup(rootPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(closeButton)
                                        .addComponent(minimizeButton))
                                .addGap(0, 0, 0)
                                .addComponent(calcMainPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(selectionPane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rootPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rootPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>

    private void rootPaneMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        xx = evt.getX();
        yy = evt.getY();
    }

    private void rootPaneMouseDragged(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx, y-yy);
    }

    private void minimizeButtonMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }

    private void closeButtonMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }

    private void fileIOTabMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        cardLayout.show(calcMainPane, "fileCard");
        setTabColor(fileIOTab);
        resetTabColor(binaryTab);
        resetTabColor(hexTab);
        resetTabColor(bandwidthTab);
    }

    private void bandwidthTabMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        cardLayout.show(calcMainPane, "bandwidthCard");
        setTabColor(bandwidthTab);
        resetTabColor(binaryTab);
        resetTabColor(hexTab);
        resetTabColor(fileIOTab);
    }

    private void hexTabMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        cardLayout.show(calcMainPane, "hexCard");
        setTabColor(hexTab);
        resetTabColor(binaryTab);
        resetTabColor(bandwidthTab);
        resetTabColor(fileIOTab);
    }

    private void binaryTabMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        cardLayout.show(calcMainPane, "binaryCard");
        setTabColor(binaryTab);
        resetTabColor(hexTab);
        resetTabColor(bandwidthTab);
        resetTabColor(fileIOTab);
    }

    private void binaryTabMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        Color previousColor = binaryTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            setHoverColor(binaryTab);
    }

    private void binaryTabMouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        Color previousColor = binaryTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            resetTabColor(binaryTab);
    }

    private void hexTabMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        Color previousColor = hexTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            setHoverColor(hexTab);
    }

    private void hexTabMouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        Color previousColor = hexTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            resetTabColor(hexTab);
    }

    private void bandwidthTabMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        Color previousColor = bandwidthTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            setHoverColor(bandwidthTab);
    }

    private void bandwidthTabMouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        Color previousColor = bandwidthTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            resetTabColor(bandwidthTab);
    }

    private void fileIOTabMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        Color previousColor = fileIOTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            setHoverColor(fileIOTab);
    }

    private void fileIOTabMouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        Color previousColor = fileIOTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            resetTabColor(fileIOTab);
    }

    // --------------------Binary calculator-----------------------
    private void calculationEntryKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        // Not allowing any keys besides 0s and 1s, space, and operators
        char c = evt.getKeyChar();
        if ("01+-*/ ".indexOf(c) == -1) {
            evt.consume();
        }
    }

    private boolean firstFocusCalc = true;
    private void calculationEntryFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusCalc) {
            calculationEntry.setText("");   //Careful: if user never focus on textField, getText() will return the default String: "1010 + 1010"
            firstFocusCalc = false;
        }
    }

    private boolean firstFocusBin = true;
    private void binValueEntryFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusBin) {
            binValueEntry.setText("");
            firstFocusBin = false;
        }
    }

    private void binValueEntryKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ("01".indexOf(c) == -1) {
            evt.consume();
        }
    }

    private boolean firstFocusDecB = true;
    private void decValueEntryFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusDecB) {
            decValueEntry.setText("");
            firstFocusDecB = false;
        }
    }

    private void decValueEntryKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ("-0123456789".indexOf(c) == -1) {
            evt.consume();
        }
    }

    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        calculationEntry.setText("");
    }

    private void equalButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        String input = calculationEntry.getText();
        String regex = "[0-1]+[\\s]*[-+*/][\\s]*[0-1]+";
        if (input.matches(regex)) {
            calcInvalidText.setVisible(false);
            String[] calculation = splitCalculation(input);     // 0 - first variable, 1 - operator, 2 - second variable
            Binary num1 = new Binary(calculation[0]);
            if (calculation[2] == null) {
                calcInvalidText.setVisible(true);
            } else {
                String[] result = performCalculation(num1, calculation[1], calculation[2]);
                binResultArea.append(String.format("%s %s %s =\n%s\n%s\n-----------------------------\n", calculation[0],calculation[1],calculation[2], result[0], result[1]));
            }
        } else {
            calcInvalidText.setVisible(true);
        }
    }

    private void clearBin2DecMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        binValueEntry.setText("");
    }

    private void equalBin2DecMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add Binary to Decimal conversion:
        if (!binValueEntry.getText().isEmpty()) {
            String convertedDec = new BinaryCalculator(new Binary(binValueEntry.getText())).toDecimal().getValue();
            binResultArea.append(String.format("Binary: %s\nDecimal: %s\n-----------------------------\n", binValueEntry.getText(), convertedDec));
        }
    }

    private void clearDec2BinMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        decValueEntry.setText("");
    }

    private void equalDec2BinMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        String regex = "[-]?[0-9]+";
        if (decValueEntry.getText().matches(regex)) {
            decimalBinInvalidText.setVisible(false);
            String convertedBin = new DecimalCalculator(new Decimal(decValueEntry.getText())).toBinary().getValue();
            binResultArea.append(String.format("Decimal: %s\nBinary: %s\n-----------------------------\n", decValueEntry.getText(), convertedBin));
        } else {
            //show invalid text label
            decimalBinInvalidText.setVisible(true);
        }
    }
    // --------------------END of Binary calculator-----------------------

    // --------------------Hex calculator-----------------------
    private boolean firstFocusHexCalc = true;
    private void hexCalcEntryFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusHexCalc) {
            hexCalcEntry.setText("");
            firstFocusHexCalc = false;
        }
    }

    private void hexCalcEntryKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ("0123456789ABCDEFabcdef+-*/ ".indexOf(c) == -1) {
            evt.consume();
        }
    }

    private void hexCalcEqualMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        String input = hexCalcEntry.getText().toUpperCase();
        String regex = "[0-9A-F]+[\\s]*[-+*/][\\s]*[0-9A-F]+";
        if (input.matches(regex)) {
            hexCalcInvalid.setVisible(false);
            String[] calculation = splitCalculation(input);     // 0 - first variable, 1 - operator, 2 - second variable
            Hex num1 = new Hex(calculation[0]);
            if (calculation[2] == null) {
                hexCalcInvalid.setVisible(true);
            } else {
                String[] result = performCalculation(num1, calculation[1], calculation[2]);
                hexResultArea.append(String.format("%s %s %s =\n%s\n%s\n-----------------------------\n", calculation[0],calculation[1],calculation[2], result[0], result[1]));
            }
        } else {
            hexCalcInvalid.setVisible(true);
        }
    }

    private void hexCalcClearMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        hexCalcEntry.setText("");
    }

    private boolean firstFocusHex = true;
    private void hexValueEntryFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusHex) {
            hexValueEntry.setText("");
            firstFocusHex = false;
        }
    }

    private void hexValueEntryKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ("0123456789ABCDEFabcdef".indexOf(c) == -1) {
            evt.consume();
        }
    }

    private void equalHex2DecMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        if (!hexValueEntry.getText().isEmpty()) {
            String convertedDec = new HexCalculator(new Hex(hexValueEntry.getText())).toDecimal().getValue();
            hexResultArea.append(String.format("Hex: %s\nDecimal: %s\n-----------------------------\n", hexValueEntry.getText(), convertedDec));
        }
    }

    private void clearHex2DecMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        hexValueEntry.setText("");
    }

    private boolean firstFocusDecH = true;
    private void decValueEntry1FocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusDecH) {
            decValueEntry1.setText("");
            firstFocusDecH = false;
        }
    }

    private void equalDec2HexMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        String regex = "[-]?[0-9]+";
        if (decValueEntry1.getText().matches(regex)) {
            decHexInvalid.setVisible(false);
            String convertedHex = new DecimalCalculator(new Decimal(decValueEntry1.getText())).toHex().getValue();
            hexResultArea.append(String.format("Decimal: %s\nHex: %s\n-----------------------------\n", decValueEntry1.getText(), convertedHex));
        } else {
            //show invalid text label
            decHexInvalid.setVisible(true);
        }
    }

    private void clearDec2HexMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        decValueEntry1.setText("");
    }
    //--------------------END of Hex calculator-----------------------


    //--------------------Bandwidth calculator-----------------------
    private boolean firstFocusData = true;
    private void dataEntryFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusData) {
            dataEntry.setText("");
            firstFocusData = false;
        }
    }

    private void dataEqualButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        if (!dataEntry.getText().isEmpty()) {
            SizeUnit.Size valueUnit = (SizeUnit.Size) dataUnitCombo.getSelectedItem();
            SizeUnit data = new SizeUnit(dataEntry.getText(), valueUnit);

            SizeUnit.Size[] units = SizeUnit.Size.values();
            bandwidthResultArea.append(String.format("%s %s is equivalent to any of the following:\n",data.getValue(), data.getUnit().label));
            for (SizeUnit.Size unit : units) {         // Convert one data unit to every other data units.
                if (unit != data.getUnit()) {
                    String result = ""+((Double.parseDouble(data.getValue()) * (data.getUnit().toBits / unit.toBits)));
                    result = result.contains(".") ? result.replaceAll("0*$","").replaceAll("\\.$","") : result; // Remove 0s trails
                    bandwidthResultArea.append(String.format("%s %s\n", result, unit.toString()));
                }
            }
            bandwidthResultArea.append("-----------------------------\n");
        }
    }

    private void dataClearButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        dataEntry.setText("");
    }

    private boolean firstFocusFileSize = true;
    private void fileSizeEntryFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusFileSize) {
            fileSizeEntry.setText("");
            firstFocusFileSize = false;
        }
    }

    private boolean firstFocusDUBandwidth = true;
    private void bandwidthEntryFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusDUBandwidth) {
            bandwidthEntry.setText("");
            firstFocusDUBandwidth = false;
        }
    }

    private void downUpEqualMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        if (!fileSizeEntry.getText().isEmpty() && !bandwidthEntry.getText().isEmpty()) {
            String fileSize = fileSizeEntry.getText();
            SizeUnit.Size fileSizeU = (SizeUnit.Size)fileSizeUnit.getSelectedItem();
            String bandwidth = bandwidthEntry.getText();
            RateUnit.Rate bandwidthU = (RateUnit.Rate)bandwidthUnit.getSelectedItem();

            DownloadUploadCalculator downUp = new DownloadUploadCalculator(new SizeUnit(fileSize, fileSizeU),
                    new RateUnit(bandwidth, bandwidthU));
            String[] results = downUp.calculate();
            bandwidthResultArea.append("Download or upload time needed is:\n" + Arrays.toString(results) + "\n-----------------------------\n");
        }
    }

    private void downUpClearMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        fileSizeEntry.setText("");
        bandwidthEntry.setText("");
    }

    private boolean firstFocusPgVw = true;
    private void pageViewEntryFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusPgVw) {
            pageViewEntry.setText("");
            firstFocusPgVw = false;
        }
    }

    private boolean firstFocusAvgPg = true;
    private void avgPageSizeEntryFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusAvgPg) {
            avgPageSizeEntry.setText("");
            firstFocusAvgPg = false;
        }
    }

    private boolean firstFocusRedun = true;
    private void redunFactorEntryFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusRedun) {
            redunFactorEntry.setText("");
            firstFocusRedun = false;
        }
    }

    private void webBandwidthEqualMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        if (!pageViewEntry.getText().isEmpty() && !avgPageSizeEntry.getText().isEmpty() && !redunFactorEntry.getText().isEmpty()) {
            String pageView = pageViewEntry.getText();
            TimeUnit.Time pageViewU = (TimeUnit.Time)pageViewUnit.getSelectedItem();
            String avgPgSize = avgPageSizeEntry.getText();
            SizeUnit.Size avgPgSizeU = (SizeUnit.Size)avgPageSizeUnit.getSelectedItem();
            double redunFactor = Double.parseDouble(redunFactorEntry.getText());

            WebsiteBandwidthCalculator webCalc = new WebsiteBandwidthCalculator(new TimeUnit(pageView, pageViewU),
                    new SizeUnit(avgPgSize, avgPgSizeU), redunFactor);
            String[] result = webCalc.calculate();
            bandwidthResultArea.append(String.format("Actual bandwidth needed is:\n %s or %s\n", result[0], result[1]));
            bandwidthResultArea.append(String.format("With redundancy factor of %.2f, the bandwidth needed is:\n %s or %s\n-----------------------------\n",
                    redunFactor, result[2], result[3]));
        }
    }

    private void webBandwidthClearMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        pageViewEntry.setText("");
        avgPageSizeEntry.setText("");
        redunFactorEntry.setText("");
    }

    private boolean firstFocusMonthly = true;
    private void monthlyUseEntryFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusMonthly) {
            monthlyUseEntry.setText("");
            firstFocusMonthly = false;
        }
    }

    private boolean firstFocusBWHosting = true;
    private void bandwidthHostingEntryFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        if (firstFocusBWHosting) {
            bandwidthHostingEntry.setText("");
            firstFocusBWHosting = false;
        }
    }

    private void hostingEqualMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        HostingBandwidthCalculator hostCalc;
        if (!monthlyUseEntry.getText().isEmpty() && !bandwidthHostingEntry.getText().isEmpty() ||
            !monthlyUseEntry.getText().isEmpty() && bandwidthHostingEntry.getText().isEmpty()) {
            String monthlyUsage = monthlyUseEntry.getText();
            SizeUnit.Size monthlyUsageU = (SizeUnit.Size)monthlyUseUnit.getSelectedItem();
            RateUnit.Rate bandwidthRateU = (RateUnit.Rate)bandwidthHostingUnit.getSelectedItem();
            hostCalc = new HostingBandwidthCalculator(new SizeUnit(monthlyUsage, monthlyUsageU), bandwidthRateU);
            bandwidthResultArea.append(String.format("%s %s is equivalent to %s\n-----------------------------\n", monthlyUsage, (monthlyUsageU != null ? monthlyUsageU.label : "?") +" per month", hostCalc.convert()));
        } else if (monthlyUseEntry.getText().isEmpty() && !bandwidthHostingEntry.getText().isEmpty()) {
            String bandwidth = bandwidthHostingEntry.getText();
            RateUnit.Rate bandwidthU = (RateUnit.Rate)bandwidthHostingUnit.getSelectedItem();
            SizeUnit.Size monthlyUseU = (SizeUnit.Size)monthlyUseUnit.getSelectedItem();
            hostCalc = new HostingBandwidthCalculator(new RateUnit(bandwidth, bandwidthU), monthlyUseU);
            bandwidthResultArea.append(String.format("%s %s is equivalent to %s\n-----------------------------\n", bandwidth, bandwidthU != null ? bandwidthU.label : "?", hostCalc.convert()));
        }
    }

    private void hostingClearMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        monthlyUseEntry.setText("");
        bandwidthHostingEntry.setText("");
    }

    private void bothWaysConvertIconMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        if (monthlyUseEntry.getText().isEmpty() && !bandwidthHostingEntry.getText().isEmpty()) {
            String input = bandwidthHostingEntry.getText();
            monthlyUseEntry.setText(input);
            bandwidthHostingEntry.setText("");
        } else {
            String input = monthlyUseEntry.getText();
            monthlyUseEntry.setText("");
            bandwidthHostingEntry.setText(input);
        }
    }
    //--------------------END of Bandwidth calculator-----------------------

    //--------------------FILE IO---------------------------
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int returnVal = browseFile.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String path = browseFile.getSelectedFile().getPath();
            pathEntry.setText(path);
            String outPath;
            String fileName;
            if (path.lastIndexOf("/") < 0 && path.lastIndexOf("\\") < 0) {
                fileName = path.substring(0 ,path.lastIndexOf(".txt"));
                outPath = fileName+"-output.txt";
            } else {
                // Give the output the original input name with output.txt at the end
                fileName = path.substring(1 + path.lastIndexOf("/") + path.lastIndexOf("\\"),path.lastIndexOf(".txt"));
                int slashIndex = path.lastIndexOf("/") > 0 ? path.lastIndexOf("/")+1 : path.lastIndexOf("\\")+1;
                outPath = path.substring(0, slashIndex-1)+fileName+"-output.txt";
            }
            FileIO fileIO = new FileIO(path, outPath, outputDetailArea);
            fileIO.processFile();
            outputDetailArea.append(outPath+"\n");
        } else {
            pathEntry.setText("");
        }
    }
    //--------------------END of FILE IO---------------------------
    private void onlyPositiveNumbers(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if ("0123456789".indexOf(c) == -1) {
            evt.consume();
        }
    }

    //Setting tab color when selected
    private void setTabColor(JPanel panel) {
        panel.setBackground(new Color(51,51,51));
    }

    //Setting hover color
    private void setHoverColor(JPanel panel) {
        panel.setBackground(new Color(30,30,30));
    }

    //Resetting tab color to normal when not selected
    private void resetTabColor(JPanel panel) {
        panel.setBackground(new Color(15,15,15));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Metal look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Metal".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculatorGUI().setVisible(true);
            }
        });
    }

    private int xx, yy; // for moving window
    private final javax.swing.JFileChooser browseFile;
    // Variables declaration - do not modify
    private javax.swing.JTextField avgPageSizeEntry;
    private javax.swing.JLabel avgPageSizeText;
    private JComboBox<SizeUnit.Size> avgPageSizeUnit;
    private javax.swing.JPanel bandwidthActionPane;
    private javax.swing.JTextField bandwidthEntry;
    private javax.swing.JTextField bandwidthHostingEntry;
    private javax.swing.JLabel bandwidthHostingText;
    private JComboBox<RateUnit.Rate> bandwidthHostingUnit;
    private javax.swing.JLabel bandwidthLabel;
    private javax.swing.JLabel fileIOlabel;
    private javax.swing.JPanel bandwidthPane;
    private javax.swing.JTextArea bandwidthResultArea;
    private javax.swing.JLabel bandwidthResultHeader;
    private javax.swing.JScrollPane bandwidthResultScroll;
    private javax.swing.JPanel bandwidthTab;
    private javax.swing.JLabel bandwidthText;
    private JComboBox<RateUnit.Rate> bandwidthUnit;
    private javax.swing.JLabel bin2DecHeader;
    private javax.swing.JPanel binCalcPane;
    private javax.swing.JPanel binToDecPane;
    private javax.swing.JTextField binValueEntry;
    private javax.swing.JLabel binValueText;
    private javax.swing.JLabel binaryCalculationHeader;
    private javax.swing.JLabel binaryLabel;
    private javax.swing.JPanel binaryPane;
    private javax.swing.JPanel binaryTab;
    private javax.swing.JLabel bothWaysConvertIcon;
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel calcEntryText;
    private javax.swing.JLabel calcInvalidText;
    private javax.swing.JPanel calcMainPane;
    private javax.swing.JTextField calculationEntry;
    private javax.swing.JLabel clearBin2Dec;
    private javax.swing.JLabel clearButton;
    private javax.swing.JLabel clearDec2Bin;
    private javax.swing.JLabel clearDec2Hex;
    private javax.swing.JLabel clearHex2Dec;
    private javax.swing.JLabel closeButton;
    private javax.swing.JLabel dataClearButton;
    private javax.swing.JPanel dataConvertPane;
    private javax.swing.JTextField dataEntry;
    private javax.swing.JLabel dataEqualButton;
    private javax.swing.JLabel dataText;
    private JComboBox<SizeUnit.Size> dataUnitCombo;
    private javax.swing.JLabel dec2BinHeader;
    private javax.swing.JLabel dec2BinHeader1;
    private javax.swing.JLabel dec2HexHeader;
    private javax.swing.JLabel decHexInvalid;
    private javax.swing.JPanel decToBinPane;
    private javax.swing.JPanel decToHexPane;
    private javax.swing.JTextField decValueEntry;
    private javax.swing.JTextField decValueEntry1;
    private javax.swing.JLabel decValueText;
    private javax.swing.JLabel decValueText1;
    private javax.swing.JLabel decimalBinInvalidText;
    private javax.swing.JLabel downUpClear;
    private javax.swing.JLabel downUpEqual;
    private javax.swing.JPanel downUpPane;
    private javax.swing.JLabel equalBin2Dec;
    private javax.swing.JLabel equalButton;
    private javax.swing.JLabel equalDec2Bin;
    private javax.swing.JLabel equalDec2Hex;
    private javax.swing.JLabel equalHex2Dec;
    private javax.swing.JPanel fileIOTab;
    private javax.swing.JLabel fileIOheader;
    private javax.swing.JPanel filePane;
    private javax.swing.JTextField fileSizeEntry;
    private javax.swing.JLabel fileSizeText;
    private JComboBox<SizeUnit.Size> fileSizeUnit;
    private javax.swing.JLabel hex2DecHeader;
    private javax.swing.JLabel hexCalcClear;
    private javax.swing.JTextField hexCalcEntry;
    private javax.swing.JLabel hexCalcEqual;
    private javax.swing.JLabel hexCalcHeader;
    private javax.swing.JLabel hexCalcInvalid;
    private javax.swing.JPanel hexCalcPane;
    private javax.swing.JLabel hexCalcText;
    private javax.swing.JLabel hexLabel;
    private javax.swing.JPanel hexPane;
    private javax.swing.JTextArea hexResultArea;
    private javax.swing.JLabel hexResultHeader;
    private javax.swing.JPanel hexResultPane;
    private javax.swing.JScrollPane hexResultScroll;
    private javax.swing.JPanel hexTab;
    private javax.swing.JPanel hexToDecPane;
    private javax.swing.JTextField hexValueEntry;
    private javax.swing.JLabel hexValueText;
    private javax.swing.JPanel hostBandwidthPane;
    private javax.swing.JLabel hostingClear;
    private javax.swing.JLabel hostingEqual;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JTextField monthlyUseEntry;
    private javax.swing.JLabel monthlyUseText;
    private JComboBox<SizeUnit.Size> monthlyUseUnit;
    private javax.swing.JTextArea outputDetailArea;
    private javax.swing.JScrollPane outputDetailScroll;
    private javax.swing.JTextField pageViewEntry;
    private javax.swing.JLabel pageViewText;
    private JComboBox<TimeUnit.Time> pageViewUnit;
    private javax.swing.JTextField pathEntry;
    private javax.swing.JLabel pathText;
    private javax.swing.JTextField redunFactorEntry;
    private javax.swing.JLabel redunFactorText;
    private javax.swing.JTextArea binResultArea;
    private javax.swing.JPanel resultPane;
    private javax.swing.JPanel rootPane;
    private javax.swing.JPanel selectionPane;
    private javax.swing.JLabel topLogo;
    private javax.swing.JLabel webBandwidthClear;
    private javax.swing.JLabel webBandwidthEqual;
    private javax.swing.JPanel webBandwidthPane;
    private javax.swing.JPanel welcomePane;
    private javax.swing.JLabel fillerImage;
    private javax.swing.JLabel welcomeImage;
    // End of variables declaration
}
