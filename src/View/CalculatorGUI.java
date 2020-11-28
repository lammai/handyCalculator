package View;

import Controller.*;
import Model.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Arrays;
import static View.BinHexCLI.performCalculation;
import static View.BinHexCLI.splitCalculation;

/**
 * This class is the GUI for the handy calculator. It includes
 * every component's placement and event handling.
 * @author Lam Mai
 * @version 3.0
 * @since 11-21-2020
 */
public class CalculatorGUI extends JFrame {

    public final CardLayout cardLayout;

    /**
     * The constructor setup every components with default values and placements.
     */
    public CalculatorGUI() {
        initComponents();
        jScrollPane1.setBorder(null);
        hexResultScroll.setBorder(null);
        bandwidthResultScroll.setBorder(null);
        outputDetailScroll.setBorder(null);
        browseFile = new JFileChooser();
        browseFile.setCurrentDirectory(new File("C:\\"));
        browseFile.setFileFilter(new FileNameExtensionFilter(".txt", "txt", "text"));
        cardLayout = (CardLayout)(calcMainPane.getLayout());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * Responsible for setting up GUI components position and functionalities.
     */
    private void initComponents() {

        JPanel rootPane = new JPanel();
        JPanel selectionPane = new JPanel();
        binaryTab = new JPanel();
        JLabel binaryLabel = new JLabel();
        hexTab = new JPanel();
        JLabel hexLabel = new JLabel();
        bandwidthTab = new JPanel();
        JLabel bandwidthLabel = new JLabel();
        fileIOTab = new JPanel();
        JLabel fileIOlabel = new JLabel();
        JLabel topLogo = new JLabel();
        JLabel closeButton = new JLabel();
        JLabel minimizeButton = new JLabel();
        calcMainPane = new JPanel();
        JPanel welcomePane = new JPanel();
        JPanel binaryPane = new JPanel();
        JPanel binCalcPane = new JPanel();
        JLabel calcEntryText = new JLabel();
        calculationEntry = new JTextField();
        JLabel equalButton = new JLabel();
        JLabel clearButton = new JLabel();
        JLabel binaryCalculationHeader = new JLabel();
        calcInvalidText = new JLabel();
        JPanel binToDecPane = new JPanel();
        JLabel bin2DecHeader = new JLabel();
        JLabel binValueText = new JLabel();
        binValueEntry = new JTextField();
        JLabel equalBin2Dec = new JLabel();
        JLabel clearBin2Dec = new JLabel();
        JPanel decToBinPane = new JPanel();
        JLabel dec2BinHeader = new JLabel();
        JLabel decValueText = new JLabel();
        decValueEntry = new JTextField();
        JLabel equalDec2Bin = new JLabel();
        JLabel clearDec2Bin = new JLabel();
        decimalBinInvalidText = new JLabel();
        JPanel resultPane = new JPanel();
        JLabel dec2BinHeader1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        binResultArea = new JTextArea();
        JPanel hexPane = new JPanel();
        JPanel hexCalcPane = new JPanel();
        JLabel hexCalcText = new JLabel();
        hexCalcEntry = new JTextField();
        JLabel hexCalcEqual = new JLabel();
        JLabel hexCalcClear = new JLabel();
        JLabel hexCalcHeader = new JLabel();
        hexCalcInvalid = new JLabel();
        JPanel hexToDecPane = new JPanel();
        JLabel hex2DecHeader = new JLabel();
        JLabel hexValueText = new JLabel();
        hexValueEntry = new JTextField();
        JLabel equalHex2Dec = new JLabel();
        JLabel clearHex2Dec = new JLabel();
        JPanel decToHexPane = new JPanel();
        JLabel dec2HexHeader = new JLabel();
        JLabel decValueText1 = new JLabel();
        decValueEntry1 = new JTextField();
        JLabel equalDec2Hex = new JLabel();
        JLabel clearDec2Hex = new JLabel();
        decHexInvalid = new JLabel();
        JPanel hexResultPane = new JPanel();
        JLabel hexResultHeader = new JLabel();
        hexResultScroll = new JScrollPane();
        hexResultArea = new JTextArea();
        JPanel bandwidthPane = new JPanel();
        JPanel bandwidthActionPane = new JPanel();
        JPanel dataConvertPane = new JPanel();
        JLabel dataText = new JLabel();
        dataEntry = new JTextField();
        dataUnitCombo = new JComboBox<>();
        JLabel dataEqualButton = new JLabel();
        JLabel dataClearButton = new JLabel();
        JPanel downUpPane = new JPanel();
        JLabel fileSizeText = new JLabel();
        fileSizeEntry = new JTextField();
        fileSizeUnit = new JComboBox<>();
        JLabel downUpEqual = new JLabel();
        JLabel downUpClear = new JLabel();
        JLabel bandwidthText = new JLabel();
        bandwidthEntry = new JTextField();
        bandwidthUnit = new JComboBox<>();
        JPanel webBandwidthPane = new JPanel();
        JLabel pageViewText = new JLabel();
        pageViewEntry = new JTextField();
        pageViewUnit = new JComboBox<>();
        JLabel webBandwidthEqual = new JLabel();
        JLabel webBandwidthClear = new JLabel();
        JLabel avgPageSizeText = new JLabel();
        avgPageSizeEntry = new JTextField();
        avgPageSizeUnit = new JComboBox<>();
        redunFactorEntry = new JTextField();
        JLabel redunFactorText = new JLabel();
        JPanel hostBandwidthPane = new JPanel();
        monthlyUseEntry = new JTextField();
        JLabel monthlyUseText = new JLabel();
        monthlyUseUnit = new JComboBox<>();
        JLabel bandwidthHostingText = new JLabel();
        bandwidthHostingEntry = new JTextField();
        bandwidthHostingUnit = new JComboBox<>();
        JLabel hostingEqual = new JLabel();
        JLabel hostingClear = new JLabel();
        JLabel bothWaysConvertIcon = new JLabel();
        JLabel bandwidthResultHeader = new JLabel();
        bandwidthResultScroll = new JScrollPane();
        bandwidthResultArea = new JTextArea();
        JPanel filePane = new JPanel();
        JButton browseButton = new JButton();
        JLabel fileIOheader = new JLabel();
        outputDetailScroll = new JScrollPane();
        outputDetailArea = new JTextArea();
        pathEntry = new JTextField();
        JLabel pathText = new JLabel();
        JLabel fillerImage = new JLabel();
        JLabel welcomeImage = new JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        rootPane.setBackground(new Color(51, 51, 51));
        rootPane.setPreferredSize(new Dimension(900, 600));
        rootPane.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                rootPaneMouseDragged(evt);
            }
        });
        rootPane.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                rootPaneMousePressed(evt);
            }
        });

        selectionPane.setBackground(new Color(26, 26, 26));
        selectionPane.setPreferredSize(new Dimension(300, 600));

        binaryTab.setBackground(new Color(15, 15, 15));
        binaryTab.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        binaryTab.setPreferredSize(new Dimension(144, 54));
        binaryTab.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                binaryTabMouseEntered();
            }
            public void mouseExited(MouseEvent evt) {
                binaryTabMouseExited();
            }
            public void mousePressed(MouseEvent evt) {
                binaryTabMousePressed();
            }
        });

        binaryLabel.setFont(new Font("Consolas", Font.BOLD, 14)); // NOI18N
        binaryLabel.setForeground(new Color(255, 255, 255));
        binaryLabel.setIcon(new ImageIcon(getClass().getResource("/images/icons8_binary_file_25px.png"))); // NOI18N
        binaryLabel.setText("Binary");
        binaryTab.add(binaryLabel);

        hexTab.setBackground(new Color(15, 15, 15));
        hexTab.setPreferredSize(new Dimension(318, 54));
        hexTab.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                hexTabMouseEntered();
            }
            public void mouseExited(MouseEvent evt) {
                hexTabMouseExited();
            }
            public void mousePressed(MouseEvent evt) {
                hexTabMousePressed();
            }
        });

        hexLabel.setFont(new Font("Consolas", Font.BOLD, 14)); // NOI18N
        hexLabel.setForeground(new Color(255, 255, 255));
        hexLabel.setIcon(new ImageIcon(getClass().getResource("/images/icons8_hexadecimal_25px.png"))); // NOI18N
        hexLabel.setText("Hexadecimal");
        hexTab.add(hexLabel);

        bandwidthTab.setBackground(new Color(15, 15, 15));
        bandwidthTab.setPreferredSize(new Dimension(196, 54));
        bandwidthTab.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                bandwidthTabMouseEntered();
            }
            public void mouseExited(MouseEvent evt) {
                bandwidthTabMouseExited();
            }
            public void mousePressed(MouseEvent evt) {
                bandwidthTabMousePressed();
            }
        });

        bandwidthLabel.setFont(new Font("Consolas", Font.BOLD, 14)); // NOI18N
        bandwidthLabel.setForeground(new Color(255, 255, 255));
        bandwidthLabel.setIcon(new ImageIcon(getClass().getResource("/images/icons8_outgoing_data_25px.png"))); // NOI18N
        bandwidthLabel.setText("Bandwidth");
        bandwidthTab.add(bandwidthLabel);

        fileIOTab.setBackground(new Color(15, 15, 15));
        fileIOTab.setPreferredSize(new Dimension(196, 54));
        fileIOTab.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                fileIOTabMouseEntered();
            }
            public void mouseExited(MouseEvent evt) {
                fileIOTabMouseExited();
            }
            public void mousePressed(MouseEvent evt) {
                fileIOTabMousePressed();
            }
        });

        fileIOlabel.setFont(new Font("Consolas", Font.BOLD, 14)); // NOI18N
        fileIOlabel.setForeground(new Color(255, 255, 255));
        fileIOlabel.setIcon(new ImageIcon(getClass().getResource("/images/icons8_txt_25px.png"))); // NOI18N
        fileIOlabel.setText("File I/O");
        fileIOTab.add(fileIOlabel);

        topLogo.setHorizontalAlignment(SwingConstants.RIGHT);
        topLogo.setIcon(new ImageIcon(getClass().getResource("/images/topLogoAsset 30.png"))); // NOI18N

        fillerImage.setIcon(new ImageIcon(getClass().getResource("/images/fillerAsset 24.png"))); // NOI18N

        GroupLayout selectionPaneLayout = new GroupLayout(selectionPane);
        selectionPane.setLayout(selectionPaneLayout);
        selectionPaneLayout.setHorizontalGroup(
                selectionPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(binaryTab, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hexTab, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(bandwidthTab, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fileIOTab, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(selectionPaneLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(topLogo, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, selectionPaneLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fillerImage)
                                .addContainerGap())
        );
        selectionPaneLayout.setVerticalGroup(
                selectionPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(selectionPaneLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(topLogo)
                                .addGap(0, 0, 0)
                                .addComponent(binaryTab, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(hexTab, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(bandwidthTab, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(fileIOTab, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(fillerImage)
                                .addContainerGap())
        );

        closeButton.setIcon(new ImageIcon(getClass().getResource("/images/icons8_close_window_25px.png"))); // NOI18N
        closeButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                closeButtonMousePressed();
            }
        });

        minimizeButton.setIcon(new ImageIcon(getClass().getResource("/images/icons8_minimize_window_25px.png"))); // NOI18N
        minimizeButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                minimizeButtonMousePressed();
            }
        });

        calcMainPane.setLayout(new CardLayout());

        welcomePane.setBackground(new Color(51, 51, 51));

        welcomeImage.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeImage.setIcon(new ImageIcon(getClass().getResource("/images/welcomeImageAsset 28.png"))); // NOI18N

        GroupLayout welcomePaneLayout = new GroupLayout(welcomePane);
        welcomePane.setLayout(welcomePaneLayout);
        welcomePaneLayout.setHorizontalGroup(
                welcomePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, welcomePaneLayout.createSequentialGroup()
                                .addContainerGap(141, Short.MAX_VALUE)
                                .addComponent(welcomeImage)
                                .addGap(150, 150, 150))
        );
        welcomePaneLayout.setVerticalGroup(
                welcomePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePaneLayout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(welcomeImage)
                                .addContainerGap(210, Short.MAX_VALUE))
        );

        calcMainPane.add(welcomePane, "card6");

        binaryPane.setBackground(new Color(51, 51, 51));
        binaryPane.setLayout(new GridLayout(4, 1));

        binCalcPane.setBackground(new Color(51, 51, 51));

        calcEntryText.setForeground(new Color(255, 255, 255));
        calcEntryText.setText("Input Binary Calculation:");

        calculationEntry.setText("1010 + 1010");
        calculationEntry.setPreferredSize(new Dimension(300, 30));
        calculationEntry.setSelectionColor(new Color(204, 204, 204));
        calculationEntry.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                calculationEntryFocusGained();
            }
        });
        calculationEntry.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                calculationEntryKeyTyped(evt);
            }
        });

        equalButton.setIcon(new ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        equalButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                equalButtonMouseClicked();
            }
        });

        clearButton.setIcon(new ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        clearButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                clearButtonMouseClicked();
            }
        });

        binaryCalculationHeader.setFont(new Font("Corbel Light", Font.PLAIN, 24)); // NOI18N
        binaryCalculationHeader.setForeground(new Color(255, 255, 255));
        binaryCalculationHeader.setHorizontalAlignment(SwingConstants.TRAILING);
        binaryCalculationHeader.setIcon(new ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        binaryCalculationHeader.setText("Binary Calculation");
        binaryCalculationHeader.setHorizontalTextPosition(SwingConstants.LEFT);

        calcInvalidText.setForeground(new Color(255, 51, 51));
        calcInvalidText.setText("Invalid input!");
        calcInvalidText.setVisible(false);

        GroupLayout binCalcPaneLayout = new GroupLayout(binCalcPane);
        binCalcPane.setLayout(binCalcPaneLayout);
        binCalcPaneLayout.setHorizontalGroup(
                binCalcPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(binCalcPaneLayout.createSequentialGroup()
                                .addGroup(binCalcPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(binCalcPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(binaryCalculationHeader))
                                        .addGroup(binCalcPaneLayout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(calcEntryText)
                                                .addGap(5, 5, 5)
                                                .addGroup(binCalcPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(binCalcPaneLayout.createSequentialGroup()
                                                                .addGap(0, 0, 0)
                                                                .addComponent(calcInvalidText)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(equalButton)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(clearButton))
                                                        .addComponent(calculationEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(70, Short.MAX_VALUE))
        );
        binCalcPaneLayout.setVerticalGroup(
                binCalcPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, binCalcPaneLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(binaryCalculationHeader)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(binCalcPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(binCalcPaneLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(calcEntryText))
                                        .addComponent(calculationEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(binCalcPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(equalButton)
                                        .addComponent(clearButton)
                                        .addComponent(calcInvalidText))
                                .addContainerGap())
        );

        binaryPane.add(binCalcPane);

        binToDecPane.setBackground(new Color(51, 51, 51));

        bin2DecHeader.setFont(new Font("Corbel Light", Font.PLAIN, 24)); // NOI18N
        bin2DecHeader.setForeground(new Color(255, 255, 255));
        bin2DecHeader.setHorizontalAlignment(SwingConstants.TRAILING);
        bin2DecHeader.setIcon(new ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        bin2DecHeader.setText("Binary to Decimal");
        bin2DecHeader.setHorizontalTextPosition(SwingConstants.LEFT);

        binValueText.setForeground(new Color(255, 255, 255));
        binValueText.setText("Binary value:");

        binValueEntry.setText("1000001");
        binValueEntry.setPreferredSize(new Dimension(300, 30));
        binValueEntry.setSelectionColor(new Color(204, 204, 204));
        binValueEntry.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                binValueEntryFocusGained();
            }
        });
        binValueEntry.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                binValueEntryKeyTyped(evt);
            }
        });

        equalBin2Dec.setIcon(new ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        equalBin2Dec.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                equalBin2DecMouseClicked();
            }
        });

        clearBin2Dec.setIcon(new ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        clearBin2Dec.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                clearBin2DecMouseClicked();
            }
        });

        GroupLayout binToDecPaneLayout = new GroupLayout(binToDecPane);
        binToDecPane.setLayout(binToDecPaneLayout);
        binToDecPaneLayout.setHorizontalGroup(
                binToDecPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(binToDecPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bin2DecHeader)
                                .addContainerGap(72, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, binToDecPaneLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(binToDecPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(binToDecPaneLayout.createSequentialGroup()
                                                .addComponent(equalBin2Dec)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clearBin2Dec))
                                        .addGroup(binToDecPaneLayout.createSequentialGroup()
                                                .addComponent(binValueText)
                                                .addGap(5, 5, 5)
                                                .addComponent(binValueEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(101, 101, 101))
        );
        binToDecPaneLayout.setVerticalGroup(
                binToDecPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, binToDecPaneLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(bin2DecHeader)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(binToDecPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(binToDecPaneLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(binValueText))
                                        .addComponent(binValueEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(binToDecPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(equalBin2Dec)
                                        .addComponent(clearBin2Dec))
                                .addGap(16, 16, 16))
        );

        binaryPane.add(binToDecPane);

        decToBinPane.setBackground(new Color(51, 51, 51));

        dec2BinHeader.setFont(new Font("Corbel Light", Font.PLAIN, 24)); // NOI18N
        dec2BinHeader.setForeground(new Color(255, 255, 255));
        dec2BinHeader.setHorizontalAlignment(SwingConstants.TRAILING);
        dec2BinHeader.setIcon(new ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        dec2BinHeader.setText("Decimal to Binary");
        dec2BinHeader.setHorizontalTextPosition(SwingConstants.LEFT);

        decValueText.setForeground(new Color(255, 255, 255));
        decValueText.setText("Decimal value:");

        decValueEntry.setText("12345");
        decValueEntry.setPreferredSize(new Dimension(300, 30));
        decValueEntry.setSelectionColor(new Color(204, 204, 204));
        decValueEntry.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                decValueEntryFocusGained();
            }
        });
        decValueEntry.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                decValueEntryKeyTyped(evt);
            }
        });

        equalDec2Bin.setIcon(new ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        equalDec2Bin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                equalDec2BinMouseClicked();
            }
        });

        clearDec2Bin.setIcon(new ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        clearDec2Bin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                clearDec2BinMouseClicked();
            }
        });

        decimalBinInvalidText.setForeground(new Color(255, 51, 51));
        decimalBinInvalidText.setText("Invalid input!");
        decimalBinInvalidText.setVisible(false);

        GroupLayout decToBinPaneLayout = new GroupLayout(decToBinPane);
        decToBinPane.setLayout(decToBinPaneLayout);
        decToBinPaneLayout.setHorizontalGroup(
                decToBinPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(decToBinPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dec2BinHeader)
                                .addContainerGap(72, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, decToBinPaneLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(decValueText)
                                .addGap(5, 5, 5)
                                .addGroup(decToBinPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(decToBinPaneLayout.createSequentialGroup()
                                                .addComponent(decimalBinInvalidText)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(equalDec2Bin)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clearDec2Bin))
                                        .addComponent(decValueEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(101, 101, 101))
        );
        decToBinPaneLayout.setVerticalGroup(
                decToBinPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, decToBinPaneLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(dec2BinHeader)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(decToBinPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(decToBinPaneLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(decValueText))
                                        .addComponent(decValueEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(decToBinPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(decToBinPaneLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(decToBinPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(equalDec2Bin)
                                                        .addComponent(clearDec2Bin)))
                                        .addGroup(decToBinPaneLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(decimalBinInvalidText)))
                                .addGap(16, 16, 16))
        );

        binaryPane.add(decToBinPane);

        resultPane.setBackground(new Color(51, 51, 51));

        dec2BinHeader1.setFont(new Font("Corbel Light", Font.PLAIN, 24)); // NOI18N
        dec2BinHeader1.setForeground(new Color(255, 255, 255));
        dec2BinHeader1.setHorizontalAlignment(SwingConstants.TRAILING);
        dec2BinHeader1.setIcon(new ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        dec2BinHeader1.setText("Result");
        dec2BinHeader1.setHorizontalTextPosition(SwingConstants.LEFT);

        binResultArea.setEditable(false);
        binResultArea.setBackground(new Color(51, 51, 51));
        binResultArea.setColumns(20);
        binResultArea.setFont(new Font("Consolas", Font.PLAIN, 14)); // NOI18N
        binResultArea.setForeground(new Color(255, 255, 255));
        binResultArea.setRows(5);
        binResultArea.setBorder(null);
        binResultArea.setSelectionColor(new Color(0, 0, 0));
        jScrollPane1.setViewportView(binResultArea);

        GroupLayout resultPaneLayout = new GroupLayout(resultPane);
        resultPane.setLayout(resultPaneLayout);
        resultPaneLayout.setHorizontalGroup(
                resultPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
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
                resultPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(resultPaneLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(dec2BinHeader1)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );

        binaryPane.add(resultPane);

        calcMainPane.add(binaryPane, "binaryCard");

        hexPane.setBackground(new Color(51, 51, 51));
        hexPane.setLayout(new GridLayout(4,1));

        hexCalcPane.setBackground(new Color(51, 51, 51));

        hexCalcText.setForeground(new Color(255, 255, 255));
        hexCalcText.setText("Input Hex Calculation:");

        hexCalcEntry.setText("EA + BAD");
        hexCalcEntry.setPreferredSize(new Dimension(300, 30));
        hexCalcEntry.setSelectionColor(new Color(204, 204, 204));
        hexCalcEntry.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                hexCalcEntryFocusGained();
            }
        });
        hexCalcEntry.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                hexCalcEntryKeyTyped(evt);
            }
        });

        hexCalcEqual.setIcon(new ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        hexCalcEqual.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                hexCalcEqualMouseClicked();
            }
        });

        hexCalcClear.setIcon(new ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        hexCalcClear.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                hexCalcClearMouseClicked();
            }
        });

        hexCalcHeader.setFont(new Font("Corbel Light", Font.PLAIN, 24)); // NOI18N
        hexCalcHeader.setForeground(new Color(255, 255, 255));
        hexCalcHeader.setHorizontalAlignment(SwingConstants.TRAILING);
        hexCalcHeader.setIcon(new ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        hexCalcHeader.setText("Hex Calculation");
        hexCalcHeader.setHorizontalTextPosition(SwingConstants.LEFT);

        hexCalcInvalid.setForeground(new Color(255, 51, 51));
        hexCalcInvalid.setText("Invalid input!");
        hexCalcInvalid.setVisible(false);

        GroupLayout hexCalcPaneLayout = new GroupLayout(hexCalcPane);
        hexCalcPane.setLayout(hexCalcPaneLayout);
        hexCalcPaneLayout.setHorizontalGroup(
                hexCalcPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(hexCalcPaneLayout.createSequentialGroup()
                                .addGroup(hexCalcPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(hexCalcPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(hexCalcHeader))
                                        .addGroup(hexCalcPaneLayout.createSequentialGroup()
                                                .addGap(72, 72, 72)
                                                .addComponent(hexCalcText)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(hexCalcPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(hexCalcPaneLayout.createSequentialGroup()
                                                                .addComponent(hexCalcInvalid)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(hexCalcEqual)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(hexCalcClear))
                                                        .addComponent(hexCalcEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(95, Short.MAX_VALUE))
        );
        hexCalcPaneLayout.setVerticalGroup(
                hexCalcPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, hexCalcPaneLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(hexCalcHeader)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(hexCalcPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(hexCalcPaneLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(hexCalcText))
                                        .addComponent(hexCalcEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hexCalcPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(hexCalcEqual)
                                        .addComponent(hexCalcClear)
                                        .addComponent(hexCalcInvalid))
                                .addContainerGap())
        );

        hexPane.add(hexCalcPane);

        hexToDecPane.setBackground(new Color(51, 51, 51));

        hex2DecHeader.setFont(new Font("Corbel Light", Font.PLAIN, 24)); // NOI18N
        hex2DecHeader.setForeground(new Color(255, 255, 255));
        hex2DecHeader.setHorizontalAlignment(SwingConstants.TRAILING);
        hex2DecHeader.setIcon(new ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        hex2DecHeader.setText("Hex to Decimal");
        hex2DecHeader.setHorizontalTextPosition(SwingConstants.LEFT);

        hexValueText.setForeground(new Color(255, 255, 255));
        hexValueText.setText("Hex value:");

        hexValueEntry.setText("1F1F1F");
        hexValueEntry.setPreferredSize(new Dimension(300, 30));
        hexValueEntry.setSelectionColor(new Color(204, 204, 204));
        hexValueEntry.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                hexValueEntryFocusGained();
            }
        });
        hexValueEntry.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                hexValueEntryKeyTyped(evt);
            }
        });

        equalHex2Dec.setIcon(new ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        equalHex2Dec.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                equalHex2DecMouseClicked();
            }
        });

        clearHex2Dec.setIcon(new ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        clearHex2Dec.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                clearHex2DecMouseClicked();
            }
        });

        GroupLayout hexToDecPaneLayout = new GroupLayout(hexToDecPane);
        hexToDecPane.setLayout(hexToDecPaneLayout);
        hexToDecPaneLayout.setHorizontalGroup(
                hexToDecPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(hexToDecPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(hex2DecHeader)
                                .addContainerGap(97, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, hexToDecPaneLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(hexToDecPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(hexToDecPaneLayout.createSequentialGroup()
                                                .addComponent(equalHex2Dec)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clearHex2Dec))
                                        .addGroup(hexToDecPaneLayout.createSequentialGroup()
                                                .addComponent(hexValueText)
                                                .addGap(5, 5, 5)
                                                .addComponent(hexValueEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(101, 101, 101))
        );
        hexToDecPaneLayout.setVerticalGroup(
                hexToDecPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, hexToDecPaneLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(hex2DecHeader)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hexToDecPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(hexToDecPaneLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(hexValueText))
                                        .addComponent(hexValueEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hexToDecPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(equalHex2Dec)
                                        .addComponent(clearHex2Dec))
                                .addGap(16, 16, 16))
        );

        hexPane.add(hexToDecPane);

        decToHexPane.setBackground(new Color(51, 51, 51));

        dec2HexHeader.setFont(new Font("Corbel Light", Font.PLAIN, 24)); // NOI18N
        dec2HexHeader.setForeground(new Color(255, 255, 255));
        dec2HexHeader.setHorizontalAlignment(SwingConstants.TRAILING);
        dec2HexHeader.setIcon(new ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        dec2HexHeader.setText("Decimal to Hex");
        dec2HexHeader.setHorizontalTextPosition(SwingConstants.LEFT);

        decValueText1.setForeground(new Color(255, 255, 255));
        decValueText1.setText("Decimal value:");

        decValueEntry1.setText("12345");
        decValueEntry1.setPreferredSize(new Dimension(300, 30));
        decValueEntry1.setSelectionColor(new Color(204, 204, 204));
        decValueEntry1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                decValueEntry1FocusGained();
            }
        });
        decValueEntry1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                decValueEntryKeyTyped(evt);
            }
        });

        equalDec2Hex.setIcon(new ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        equalDec2Hex.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                equalDec2HexMouseClicked();
            }
        });

        clearDec2Hex.setIcon(new ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        clearDec2Hex.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                clearDec2HexMouseClicked();
            }
        });

        decHexInvalid.setForeground(new Color(255, 51, 51));
        decHexInvalid.setText("Invalid input!");
        decHexInvalid.setVisible(false);

        GroupLayout decToHexPaneLayout = new GroupLayout(decToHexPane);
        decToHexPane.setLayout(decToHexPaneLayout);
        decToHexPaneLayout.setHorizontalGroup(
                decToHexPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(decToHexPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dec2HexHeader)
                                .addContainerGap(97, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, decToHexPaneLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(decValueText1)
                                .addGap(5, 5, 5)
                                .addGroup(decToHexPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(decToHexPaneLayout.createSequentialGroup()
                                                .addComponent(decHexInvalid)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(equalDec2Hex)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clearDec2Hex))
                                        .addComponent(decValueEntry1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(101, 101, 101))
        );
        decToHexPaneLayout.setVerticalGroup(
                decToHexPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, decToHexPaneLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(dec2HexHeader)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(decToHexPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(decToHexPaneLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(decValueText1))
                                        .addComponent(decValueEntry1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(decToHexPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(equalDec2Hex)
                                        .addComponent(clearDec2Hex)
                                        .addComponent(decHexInvalid))
                                .addGap(16, 16, 16))
        );

        hexPane.add(decToHexPane);

        hexResultPane.setBackground(new Color(51, 51, 51));

        hexResultHeader.setFont(new Font("Corbel Light", Font.PLAIN, 24)); // NOI18N
        hexResultHeader.setForeground(new Color(255, 255, 255));
        hexResultHeader.setHorizontalAlignment(SwingConstants.TRAILING);
        hexResultHeader.setIcon(new ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        hexResultHeader.setText("Result");
        hexResultHeader.setHorizontalTextPosition(SwingConstants.LEFT);

        hexResultArea.setEditable(false);
        hexResultArea.setBackground(new Color(51, 51, 51));
        hexResultArea.setColumns(20);
        hexResultArea.setFont(new Font("Consolas", Font.PLAIN, 14)); // NOI18N
        hexResultArea.setForeground(new Color(255, 255, 255));
        hexResultArea.setRows(5);
        hexResultArea.setBorder(null);
        hexResultArea.setSelectionColor(new Color(0, 0, 0));
        hexResultScroll.setViewportView(hexResultArea);

        GroupLayout hexResultPaneLayout = new GroupLayout(hexResultPane);
        hexResultPane.setLayout(hexResultPaneLayout);
        hexResultPaneLayout.setHorizontalGroup(
                hexResultPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
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
                hexResultPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(hexResultPaneLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(hexResultHeader)
                                .addGap(0, 0, 0)
                                .addComponent(hexResultScroll, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
        );

        hexPane.add(hexResultPane);

        calcMainPane.add(hexPane, "hexCard");

        bandwidthPane.setBackground(new Color(51, 51, 51));

        bandwidthActionPane.setBackground(new Color(51, 51, 51));
        bandwidthActionPane.setLayout(new GridLayout(2, 2));

        dataConvertPane.setBackground(new Color(51, 51, 51));
        dataConvertPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Data Unit Converter"), "Data Unit Converter", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Corbel Light", Font.PLAIN, 18), new Color(255, 255, 255))); // NOI18N

        dataText.setForeground(new Color(255, 255, 255));
        dataText.setText("Data Value:");

        dataEntry.setText("500");
        dataEntry.setPreferredSize(new Dimension(7, 24));
        dataEntry.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                dataEntryFocusGained();
            }
        });
        dataEntry.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        dataUnitCombo.setModel(new DefaultComboBoxModel<>(SizeUnit.Size.values()));
        dataUnitCombo.setSelectedIndex(7);  // set default selection to Megabytes (MB)

        dataEqualButton.setIcon(new ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        dataEqualButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                dataEqualButtonMouseClicked();
            }
        });

        dataClearButton.setIcon(new ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        dataClearButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                dataClearButtonMouseClicked();
            }
        });

        GroupLayout dataConvertPaneLayout = new GroupLayout(dataConvertPane);
        dataConvertPane.setLayout(dataConvertPaneLayout);
        dataConvertPaneLayout.setHorizontalGroup(
                dataConvertPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, dataConvertPaneLayout.createSequentialGroup()
                                .addGroup(dataConvertPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(dataConvertPaneLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(dataEqualButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dataClearButton))
                                        .addGroup(GroupLayout.Alignment.LEADING, dataConvertPaneLayout.createSequentialGroup()
                                                .addComponent(dataEntry, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dataUnitCombo, 0, 116, Short.MAX_VALUE))
                                        .addComponent(dataText, GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, 0))
        );
        dataConvertPaneLayout.setVerticalGroup(
                dataConvertPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(dataConvertPaneLayout.createSequentialGroup()
                                .addComponent(dataText)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dataConvertPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(dataEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dataUnitCombo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dataConvertPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(dataEqualButton)
                                        .addComponent(dataClearButton))
                                .addGap(0, 67, Short.MAX_VALUE))
        );

        bandwidthActionPane.add(dataConvertPane);

        downUpPane.setBackground(new Color(51, 51, 51));
        downUpPane.setBorder(BorderFactory.createTitledBorder(null, "Download/Upload Time Calculator", TitledBorder.RIGHT, TitledBorder.DEFAULT_POSITION, new Font("Corbel Light", Font.PLAIN, 18), new Color(255, 255, 255))); // NOI18N

        fileSizeText.setForeground(new Color(255, 255, 255));
        fileSizeText.setText("File Size:");

        fileSizeEntry.setText("500");
        fileSizeEntry.setPreferredSize(new Dimension(7, 24));
        fileSizeEntry.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                fileSizeEntryFocusGained();
            }
        });
        fileSizeEntry.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
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

        downUpEqual.setIcon(new ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        downUpEqual.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                downUpEqualMouseClicked();
            }
        });

        downUpClear.setIcon(new ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        downUpClear.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                downUpClearMouseClicked();
            }
        });

        bandwidthText.setForeground(new Color(255, 255, 255));
        bandwidthText.setText("Bandwidth:");

        bandwidthEntry.setText("5");
        bandwidthEntry.setPreferredSize(new Dimension(7, 24));
        bandwidthEntry.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                bandwidthEntryFocusGained();
            }
        });
        bandwidthEntry.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        bandwidthUnit.setModel(new DefaultComboBoxModel<>(RateUnit.Rate.values()));
        bandwidthUnit.setSelectedIndex(2);  // Set default selection to Mbit/s

        GroupLayout downUpPaneLayout = new GroupLayout(downUpPane);
        downUpPane.setLayout(downUpPaneLayout);
        downUpPaneLayout.setHorizontalGroup(
                downUpPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, downUpPaneLayout.createSequentialGroup()
                                .addGroup(downUpPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(downUpPaneLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(downUpEqual)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(downUpClear))
                                        .addGroup(GroupLayout.Alignment.LEADING, downUpPaneLayout.createSequentialGroup()
                                                .addComponent(fileSizeEntry, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fileSizeUnit, 0, 120, Short.MAX_VALUE))
                                        .addComponent(fileSizeText, GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.LEADING, downUpPaneLayout.createSequentialGroup()
                                                .addComponent(bandwidthEntry, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bandwidthUnit, 0, 120, Short.MAX_VALUE))
                                        .addComponent(bandwidthText, GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, 0))
        );
        downUpPaneLayout.setVerticalGroup(
                downUpPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(downUpPaneLayout.createSequentialGroup()
                                .addComponent(fileSizeText)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(downUpPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(fileSizeEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fileSizeUnit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(bandwidthText)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(downUpPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bandwidthEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bandwidthUnit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(downUpPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(downUpEqual)
                                        .addComponent(downUpClear))
                                .addContainerGap())
        );

        bandwidthActionPane.add(downUpPane);

        webBandwidthPane.setBackground(new Color(51, 51, 51));
        webBandwidthPane.setBorder(BorderFactory.createTitledBorder(null, "Website Bandwidth Calculator", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Corbel Light", Font.PLAIN, 18), new Color(255, 255, 255))); // NOI18N

        pageViewText.setForeground(new Color(255, 255, 255));
        pageViewText.setText("Page Views:");

        pageViewEntry.setText("5000");
        pageViewEntry.setPreferredSize(new Dimension(7, 24));
        pageViewEntry.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                pageViewEntryFocusGained();
            }
        });
        pageViewEntry.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        pageViewUnit.setModel(new DefaultComboBoxModel<>(TimeUnit.Time.values()));
        pageViewUnit.setSelectedIndex(3);

        webBandwidthEqual.setIcon(new ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        webBandwidthEqual.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                webBandwidthEqualMouseClicked();
            }
        });

        webBandwidthClear.setIcon(new ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        webBandwidthClear.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                webBandwidthClearMouseClicked();
            }
        });

        avgPageSizeText.setForeground(new Color(255, 255, 255));
        avgPageSizeText.setText("Average Page Size:");

        avgPageSizeEntry.setText("500");
        avgPageSizeEntry.setPreferredSize(new Dimension(7, 24));
        avgPageSizeEntry.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                avgPageSizeEntryFocusGained();
            }
        });
        avgPageSizeEntry.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        redunFactorEntry.setText("2");
        redunFactorEntry.setPreferredSize(new Dimension(7, 24));
        redunFactorEntry.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                redunFactorEntryFocusGained();
            }
        });
        redunFactorEntry.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        redunFactorText.setForeground(new Color(255, 255, 255));
        redunFactorText.setText("Redundancy Factor:");

        GroupLayout webBandwidthPaneLayout = new GroupLayout(webBandwidthPane);
        webBandwidthPane.setLayout(webBandwidthPaneLayout);
        webBandwidthPaneLayout.setHorizontalGroup(
                webBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(webBandwidthPaneLayout.createSequentialGroup()
                                .addComponent(pageViewEntry, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pageViewUnit, 0, 120, Short.MAX_VALUE))
                        .addGroup(webBandwidthPaneLayout.createSequentialGroup()
                                .addComponent(avgPageSizeEntry, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avgPageSizeUnit, 0, 120, Short.MAX_VALUE))
                        .addGroup(webBandwidthPaneLayout.createSequentialGroup()
                                .addGroup(webBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(pageViewText, GroupLayout.Alignment.LEADING)
                                        .addComponent(avgPageSizeText, GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(webBandwidthPaneLayout.createSequentialGroup()
                                .addGroup(webBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(redunFactorText)
                                        .addComponent(redunFactorEntry, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(webBandwidthEqual)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(webBandwidthClear))
        );
        webBandwidthPaneLayout.setVerticalGroup(
                webBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(webBandwidthPaneLayout.createSequentialGroup()
                                .addComponent(pageViewText)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(webBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(pageViewEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pageViewUnit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(webBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(webBandwidthPaneLayout.createSequentialGroup()
                                                .addComponent(avgPageSizeText)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(webBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(avgPageSizeEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(avgPageSizeUnit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(redunFactorText)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(redunFactorEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(webBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(webBandwidthEqual)
                                                .addComponent(webBandwidthClear)))
                                .addGap(23, 23, 23))
        );

        bandwidthActionPane.add(webBandwidthPane);

        hostBandwidthPane.setBackground(new Color(51, 51, 51));
        hostBandwidthPane.setBorder(BorderFactory.createTitledBorder(null, "Hosting Bandwidth Converter", TitledBorder.RIGHT, TitledBorder.DEFAULT_POSITION, new Font("Corbel Light", Font.PLAIN, 18), new Color(255, 255, 255))); // NOI18N

        monthlyUseEntry.setText("1000");
        monthlyUseEntry.setPreferredSize(new Dimension(7, 24));
        monthlyUseEntry.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                monthlyUseEntryFocusGained();
            }
        });
        monthlyUseEntry.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        monthlyUseText.setForeground(new Color(255, 255, 255));
        monthlyUseText.setText("Monthly Usage:");

        bandwidthHostingText.setForeground(new Color(255, 255, 255));
        bandwidthHostingText.setText("Bandwidth:");

        bandwidthHostingEntry.setPreferredSize(new Dimension(7, 24));
        bandwidthHostingEntry.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                bandwidthHostingEntryFocusGained();
            }
        });
        bandwidthHostingEntry.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                onlyPositiveNumbers(evt);
            }
        });

        bandwidthHostingUnit.setModel(new DefaultComboBoxModel<>(RateUnit.Rate.values()));

        hostingEqual.setIcon(new ImageIcon(getClass().getResource("/images/icons8_equals_36px.png"))); // NOI18N
        hostingEqual.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                hostingEqualMouseClicked();
            }
        });

        hostingClear.setIcon(new ImageIcon(getClass().getResource("/images/icons8_clear_symbol_36px.png"))); // NOI18N
        hostingClear.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                hostingClearMouseClicked();
            }
        });

        bothWaysConvertIcon.setIcon(new ImageIcon(getClass().getResource("/images/icons8_up_down_arrow_36px.png"))); // NOI18N
        bothWaysConvertIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                bothWaysConvertIconMouseClicked();
            }
        });

        GroupLayout hostBandwidthPaneLayout = new GroupLayout(hostBandwidthPane);
        hostBandwidthPane.setLayout(hostBandwidthPaneLayout);
        hostBandwidthPaneLayout.setHorizontalGroup(
                hostBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, hostBandwidthPaneLayout.createSequentialGroup()
                                .addComponent(bandwidthHostingEntry, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bandwidthHostingUnit, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(hostBandwidthPaneLayout.createSequentialGroup()
                                .addGroup(hostBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(hostBandwidthPaneLayout.createSequentialGroup()
                                                .addComponent(monthlyUseEntry, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(GroupLayout.Alignment.TRAILING, hostBandwidthPaneLayout.createSequentialGroup()
                                                .addComponent(bothWaysConvertIcon)
                                                .addGap(56, 56, 56)))
                                .addGroup(hostBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(hostBandwidthPaneLayout.createSequentialGroup()
                                                .addComponent(hostingEqual)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(hostingClear)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(monthlyUseUnit, 0, 120, Short.MAX_VALUE)))
                        .addGroup(hostBandwidthPaneLayout.createSequentialGroup()
                                .addGroup(hostBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(monthlyUseText)
                                        .addComponent(bandwidthHostingText))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        hostBandwidthPaneLayout.setVerticalGroup(
                hostBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(hostBandwidthPaneLayout.createSequentialGroup()
                                .addComponent(monthlyUseText)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hostBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(monthlyUseEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(monthlyUseUnit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(hostBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(hostingEqual)
                                        .addComponent(hostingClear)
                                        .addComponent(bothWaysConvertIcon))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bandwidthHostingText)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hostBandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bandwidthHostingEntry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bandwidthHostingUnit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        bandwidthActionPane.add(hostBandwidthPane);

        bandwidthResultHeader.setFont(new Font("Corbel Light", Font.PLAIN, 24)); // NOI18N
        bandwidthResultHeader.setForeground(new Color(255, 255, 255));
        bandwidthResultHeader.setHorizontalAlignment(SwingConstants.TRAILING);
        bandwidthResultHeader.setIcon(new ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        bandwidthResultHeader.setText("Result");
        bandwidthResultHeader.setHorizontalTextPosition(SwingConstants.LEFT);

        bandwidthResultArea.setEditable(false);
        bandwidthResultArea.setBackground(new Color(51, 51, 51));
        bandwidthResultArea.setColumns(20);
        bandwidthResultArea.setFont(new Font("Consolas", Font.PLAIN, 12)); // NOI18N
        bandwidthResultArea.setForeground(new Color(255, 255, 255));
        bandwidthResultArea.setRows(5);
        bandwidthResultArea.setBorder(null);
        bandwidthResultArea.setSelectionColor(new Color(0, 0, 0));
        bandwidthResultScroll.setViewportView(bandwidthResultArea);

        GroupLayout bandwidthPaneLayout = new GroupLayout(bandwidthPane);
        bandwidthPane.setLayout(bandwidthPaneLayout);
        bandwidthPaneLayout.setHorizontalGroup(
                bandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bandwidthActionPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, bandwidthPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bandwidthResultScroll)
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, bandwidthPaneLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bandwidthResultHeader)
                                .addGap(65, 65, 65))
        );
        bandwidthPaneLayout.setVerticalGroup(
                bandwidthPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(bandwidthPaneLayout.createSequentialGroup()
                                .addComponent(bandwidthActionPane, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bandwidthResultHeader)
                                .addGap(0, 0, 0)
                                .addComponent(bandwidthResultScroll, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );

        calcMainPane.add(bandwidthPane, "bandwidthCard");

        filePane.setBackground(new Color(51, 51, 51));

        fileIOheader.setFont(new Font("Corbel Light", Font.PLAIN, 24)); // NOI18N
        fileIOheader.setForeground(new Color(255, 255, 255));
        fileIOheader.setHorizontalAlignment(SwingConstants.TRAILING);
        fileIOheader.setIcon(new ImageIcon(getClass().getResource("/images/Club 6Asset 11.png"))); // NOI18N
        fileIOheader.setText("Batch Operation");
        fileIOheader.setHorizontalTextPosition(SwingConstants.LEFT);

        pathText.setFont(new Font("Consolas", Font.PLAIN, 12)); // NOI18N
        pathText.setForeground(new Color(255, 255, 255));
        pathText.setText("Path to Text File:");

        pathEntry.setText("C:\\Users\\ExampleUser\\Desktop\\exampleFile.txt");
        pathEntry.setEditable(false);

        browseButton.setText("Browse...");
        browseButton.addActionListener(this::browseButtonActionPerformed);

        outputDetailScroll.setToolTipText("");

        outputDetailArea.setEditable(false);
        outputDetailArea.setBackground(new Color(51, 51, 51));
        outputDetailArea.setColumns(20);
        outputDetailArea.setFont(new Font("Consolas", Font.PLAIN, 12)); // NOI18N
        outputDetailArea.setForeground(new Color(255, 255, 255));
        outputDetailArea.setRows(5);
        outputDetailArea.setBorder(null);
        outputDetailArea.setSelectionColor(new Color(0, 0, 0));
        outputDetailScroll.setViewportView(outputDetailArea);

        GroupLayout filePaneLayout = new GroupLayout(filePane);
        filePane.setLayout(filePaneLayout);
        filePaneLayout.setHorizontalGroup(
                filePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(filePaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(filePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(filePaneLayout.createSequentialGroup()
                                                .addComponent(outputDetailScroll)
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, filePaneLayout.createSequentialGroup()
                                                .addGap(0, 33, Short.MAX_VALUE)
                                                .addGroup(filePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, filePaneLayout.createSequentialGroup()
                                                                .addGroup(filePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(pathText)
                                                                        .addComponent(fileIOheader))
                                                                .addGap(66, 66, 66))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, filePaneLayout.createSequentialGroup()
                                                                .addComponent(pathEntry, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(browseButton)
                                                                .addGap(48, 48, 48))))))
        );
        filePaneLayout.setVerticalGroup(
                filePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(filePaneLayout.createSequentialGroup()
                                .addComponent(fileIOheader)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pathText)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(filePaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(pathEntry, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(browseButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outputDetailScroll, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
        );

        calcMainPane.add(filePane, "fileCard");

        GroupLayout rootPaneLayout = new GroupLayout(rootPane);
        rootPane.setLayout(rootPaneLayout);
        rootPaneLayout.setHorizontalGroup(
                rootPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(rootPaneLayout.createSequentialGroup()
                                .addComponent(selectionPane, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(rootPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(calcMainPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(rootPaneLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(minimizeButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(closeButton))))
        );
        rootPaneLayout.setVerticalGroup(
                rootPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(rootPaneLayout.createSequentialGroup()
                                .addGroup(rootPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(closeButton)
                                        .addComponent(minimizeButton))
                                .addGap(0, 0, 0)
                                .addComponent(calcMainPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(selectionPane, GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(rootPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(rootPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void rootPaneMousePressed(MouseEvent evt) {
        xx = evt.getX();
        yy = evt.getY();
    }

    private void rootPaneMouseDragged(MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx, y-yy);
    }

    private void minimizeButtonMousePressed() {
        setState(JFrame.ICONIFIED);
    }

    private void closeButtonMousePressed() {
        System.exit(0);
    }

    private void fileIOTabMousePressed() {
        cardLayout.show(calcMainPane, "fileCard");
        setTabColor(fileIOTab);
        resetTabColor(binaryTab);
        resetTabColor(hexTab);
        resetTabColor(bandwidthTab);
    }

    private void bandwidthTabMousePressed() {
        cardLayout.show(calcMainPane, "bandwidthCard");
        setTabColor(bandwidthTab);
        resetTabColor(binaryTab);
        resetTabColor(hexTab);
        resetTabColor(fileIOTab);
    }

    private void hexTabMousePressed() {
        cardLayout.show(calcMainPane, "hexCard");
        setTabColor(hexTab);
        resetTabColor(binaryTab);
        resetTabColor(bandwidthTab);
        resetTabColor(fileIOTab);
    }

    private void binaryTabMousePressed() {
        cardLayout.show(calcMainPane, "binaryCard");
        setTabColor(binaryTab);
        resetTabColor(hexTab);
        resetTabColor(bandwidthTab);
        resetTabColor(fileIOTab);
    }

    private void binaryTabMouseEntered() {
        Color previousColor = binaryTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            setHoverColor(binaryTab);
    }

    private void binaryTabMouseExited() {
        Color previousColor = binaryTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            resetTabColor(binaryTab);
    }

    private void hexTabMouseEntered() {
        Color previousColor = hexTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            setHoverColor(hexTab);
    }

    private void hexTabMouseExited() {
        Color previousColor = hexTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            resetTabColor(hexTab);
    }

    private void bandwidthTabMouseEntered() {
        Color previousColor = bandwidthTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            setHoverColor(bandwidthTab);
    }

    private void bandwidthTabMouseExited() {
        Color previousColor = bandwidthTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            resetTabColor(bandwidthTab);
    }

    private void fileIOTabMouseEntered() {
        Color previousColor = fileIOTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            setHoverColor(fileIOTab);
    }

    private void fileIOTabMouseExited() {
        Color previousColor = fileIOTab.getBackground();
        if (!previousColor.equals(new Color(51,51,51)))
            resetTabColor(fileIOTab);
    }

    // --------------------Binary calculator-----------------------
    private void calculationEntryKeyTyped(KeyEvent evt) {
        // Not allowing any keys besides 0s and 1s, space, and operators
        char c = evt.getKeyChar();
        if ("01+-*/ ".indexOf(c) == -1) {
            evt.consume();
        }
    }

    private boolean firstFocusCalc = true;
    private void calculationEntryFocusGained() {
        if (firstFocusCalc) {
            calculationEntry.setText("");   //Careful: if user never focus on textField, getText() will return the default String: "1010 + 1010"
            firstFocusCalc = false;
        }
    }

    private boolean firstFocusBin = true;
    private void binValueEntryFocusGained() {
        if (firstFocusBin) {
            binValueEntry.setText("");
            firstFocusBin = false;
        }
    }

    private void binValueEntryKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if ("01".indexOf(c) == -1) {
            evt.consume();
        }
    }

    private boolean firstFocusDecB = true;
    private void decValueEntryFocusGained() {
        if (firstFocusDecB) {
            decValueEntry.setText("");
            firstFocusDecB = false;
        }
    }

    private void decValueEntryKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if ("-0123456789".indexOf(c) == -1) {
            evt.consume();
        }
    }

    private void clearButtonMouseClicked() {
        calculationEntry.setText("");
    }

    private void equalButtonMouseClicked() {
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

    private void clearBin2DecMouseClicked() {
        binValueEntry.setText("");
    }

    private void equalBin2DecMouseClicked() {
        if (!binValueEntry.getText().isEmpty()) {
            String convertedDec = new BinaryCalculator(new Binary(binValueEntry.getText())).toDecimal().getValue();
            binResultArea.append(String.format("Binary: %s\nDecimal: %s\n-----------------------------\n", binValueEntry.getText(), convertedDec));
        }
    }

    private void clearDec2BinMouseClicked() {
        decValueEntry.setText("");
    }

    private void equalDec2BinMouseClicked() {
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
    private void hexCalcEntryFocusGained() {
        if (firstFocusHexCalc) {
            hexCalcEntry.setText("");
            firstFocusHexCalc = false;
        }
    }

    private void hexCalcEntryKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if ("0123456789ABCDEFabcdef+-*/ ".indexOf(c) == -1) {
            evt.consume();
        }
    }

    private void hexCalcEqualMouseClicked() {
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

    private void hexCalcClearMouseClicked() {
        hexCalcEntry.setText("");
    }

    private boolean firstFocusHex = true;
    private void hexValueEntryFocusGained() {
        if (firstFocusHex) {
            hexValueEntry.setText("");
            firstFocusHex = false;
        }
    }

    private void hexValueEntryKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if ("0123456789ABCDEFabcdef".indexOf(c) == -1) {
            evt.consume();
        }
    }

    private void equalHex2DecMouseClicked() {
        if (!hexValueEntry.getText().isEmpty()) {
            String convertedDec = new HexCalculator(new Hex(hexValueEntry.getText())).toDecimal().getValue();
            hexResultArea.append(String.format("Hex: %s\nDecimal: %s\n-----------------------------\n", hexValueEntry.getText(), convertedDec));
        }
    }

    private void clearHex2DecMouseClicked() {
        hexValueEntry.setText("");
    }

    private boolean firstFocusDecH = true;
    private void decValueEntry1FocusGained() {
        if (firstFocusDecH) {
            decValueEntry1.setText("");
            firstFocusDecH = false;
        }
    }

    private void equalDec2HexMouseClicked() {
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

    private void clearDec2HexMouseClicked() {
        decValueEntry1.setText("");
    }
    //--------------------END of Hex calculator-----------------------


    //--------------------Bandwidth calculator-----------------------
    private boolean firstFocusData = true;
    private void dataEntryFocusGained() {
        if (firstFocusData) {
            dataEntry.setText("");
            firstFocusData = false;
        }
    }

    private void dataEqualButtonMouseClicked() {
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

    private void dataClearButtonMouseClicked() {
        dataEntry.setText("");
    }

    private boolean firstFocusFileSize = true;
    private void fileSizeEntryFocusGained() {
        if (firstFocusFileSize) {
            fileSizeEntry.setText("");
            firstFocusFileSize = false;
        }
    }

    private boolean firstFocusDUBandwidth = true;
    private void bandwidthEntryFocusGained() {
        if (firstFocusDUBandwidth) {
            bandwidthEntry.setText("");
            firstFocusDUBandwidth = false;
        }
    }

    private void downUpEqualMouseClicked() {
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

    private void downUpClearMouseClicked() {
        fileSizeEntry.setText("");
        bandwidthEntry.setText("");
    }

    private boolean firstFocusPgVw = true;
    private void pageViewEntryFocusGained() {
        if (firstFocusPgVw) {
            pageViewEntry.setText("");
            firstFocusPgVw = false;
        }
    }

    private boolean firstFocusAvgPg = true;
    private void avgPageSizeEntryFocusGained() {
        if (firstFocusAvgPg) {
            avgPageSizeEntry.setText("");
            firstFocusAvgPg = false;
        }
    }

    private boolean firstFocusRedun = true;
    private void redunFactorEntryFocusGained() {
        if (firstFocusRedun) {
            redunFactorEntry.setText("");
            firstFocusRedun = false;
        }
    }

    private void webBandwidthEqualMouseClicked() {
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

    private void webBandwidthClearMouseClicked() {
        pageViewEntry.setText("");
        avgPageSizeEntry.setText("");
        redunFactorEntry.setText("");
    }

    private boolean firstFocusMonthly = true;
    private void monthlyUseEntryFocusGained() {
        if (firstFocusMonthly) {
            monthlyUseEntry.setText("");
            firstFocusMonthly = false;
        }
    }

    private boolean firstFocusBWHosting = true;
    private void bandwidthHostingEntryFocusGained() {
        if (firstFocusBWHosting) {
            bandwidthHostingEntry.setText("");
            firstFocusBWHosting = false;
        }
    }

    private void hostingEqualMouseClicked() {
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

    private void hostingClearMouseClicked() {
        monthlyUseEntry.setText("");
        bandwidthHostingEntry.setText("");
    }

    private void bothWaysConvertIconMouseClicked() {
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
    private void browseButtonActionPerformed(ActionEvent evt) {
        int returnVal = browseFile.showOpenDialog(this);
        if (browseFile.getSelectedFile().getName().contains(".txt")) {
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
    }
    //--------------------END of FILE IO---------------------------

    //--------------------UTILITIES---------------------------
    private void onlyPositiveNumbers(KeyEvent evt) {
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
    // --------------------END OF UTILITIES---------------------------

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //display the GUI
        EventQueue.invokeLater(() -> new CalculatorGUI().setVisible(true));
    }

    private int xx, yy; // for moving window
    private final JFileChooser browseFile;
    private JTextField avgPageSizeEntry;
    private JComboBox<SizeUnit.Size> avgPageSizeUnit;
    private JTextField bandwidthEntry;
    private JTextField bandwidthHostingEntry;
    private JComboBox<RateUnit.Rate> bandwidthHostingUnit;
    private JTextArea bandwidthResultArea;
    private JScrollPane bandwidthResultScroll;
    private JPanel bandwidthTab;
    private JComboBox<RateUnit.Rate> bandwidthUnit;
    private JTextField binValueEntry;
    private JPanel binaryTab;
    private JLabel calcInvalidText;
    private JPanel calcMainPane;
    private JTextField calculationEntry;
    private JTextField dataEntry;
    private JComboBox<SizeUnit.Size> dataUnitCombo;
    private JLabel decHexInvalid;
    private JTextField decValueEntry;
    private JTextField decValueEntry1;
    private JLabel decimalBinInvalidText;
    private JPanel fileIOTab;
    private JTextField fileSizeEntry;
    private JComboBox<SizeUnit.Size> fileSizeUnit;
    private JTextField hexCalcEntry;
    private JLabel hexCalcInvalid;
    private JTextArea hexResultArea;
    private JScrollPane hexResultScroll;
    private JPanel hexTab;
    private JTextField hexValueEntry;
    private JScrollPane jScrollPane1;
    private JTextField monthlyUseEntry;
    private JComboBox<SizeUnit.Size> monthlyUseUnit;
    private JTextArea outputDetailArea;
    private JScrollPane outputDetailScroll;
    private JTextField pageViewEntry;
    private JComboBox<TimeUnit.Time> pageViewUnit;
    private JTextField pathEntry;
    private JTextField redunFactorEntry;
    private JTextArea binResultArea;
}
