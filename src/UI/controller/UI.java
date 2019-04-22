package UI.controller;

import java.awt.FileDialog;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class UI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	protected JPanel contentPane;
	protected JMenu mnOptions;
	protected JMenuItem mntmSettings;
	protected JMenu mnHelp;
	protected JMenu mnFilters;
	protected JMenuItem mntmAddingFilters;
	protected JButton btnChooseFile;
	protected FileDialog fileDialog;
	protected JTextField txtFilePath;
	protected JButton btnValidatePath;
	protected JList listFilters;
	protected JLabel lblSelectAFile;
	protected JLabel lblSelectAFilter;
	protected JButton btnScan;
	protected JTextPane txtPaneResults;
	protected JLabel lblFileInfo;
	protected JLabel lblInfo;

	public UI() {
		setTitle("xls2sql");
		this.fileDialog = new FileDialog(this, "Select file or directory...");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		mntmSettings = new JMenuItem("Settings");
		mnOptions.add(mntmSettings);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mnFilters = new JMenu("Filters");
		mnHelp.add(mnFilters);
		
		mntmAddingFilters = new JMenuItem("Adding filters");
		mnFilters.add(mntmAddingFilters);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 150, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblSelectAFile = new JLabel("Select a file or directory");
		GridBagConstraints gbc_lblSelectAFile = new GridBagConstraints();
		gbc_lblSelectAFile.anchor = GridBagConstraints.WEST;
		gbc_lblSelectAFile.gridwidth = 3;
		gbc_lblSelectAFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectAFile.gridx = 0;
		gbc_lblSelectAFile.gridy = 0;
		contentPane.add(lblSelectAFile, gbc_lblSelectAFile);
		
		txtFilePath = new JTextField();
		txtFilePath.setBorder(new LineBorder(Color.LIGHT_GRAY));
		GridBagConstraints gbc_txtFilePath = new GridBagConstraints();
		gbc_txtFilePath.gridwidth = 6;
		gbc_txtFilePath.insets = new Insets(0, 0, 5, 0);
		gbc_txtFilePath.fill = GridBagConstraints.BOTH;
		gbc_txtFilePath.gridx = 0;
		gbc_txtFilePath.gridy = 1;
		contentPane.add(txtFilePath, gbc_txtFilePath);
		txtFilePath.setColumns(10);
		
		btnChooseFile = new JButton("Choose file");
		
		GridBagConstraints gbc_btnChooseFile = new GridBagConstraints();
		gbc_btnChooseFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChooseFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnChooseFile.anchor = GridBagConstraints.SOUTH;
		gbc_btnChooseFile.gridx = 0;
		gbc_btnChooseFile.gridy = 2;
		contentPane.add(btnChooseFile, gbc_btnChooseFile);
		
		btnValidatePath = new JButton("Validate path");
		GridBagConstraints gbc_btnValidatePath = new GridBagConstraints();
		gbc_btnValidatePath.insets = new Insets(0, 0, 5, 5);
		gbc_btnValidatePath.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnValidatePath.gridx = 1;
		gbc_btnValidatePath.gridy = 2;
		contentPane.add(btnValidatePath, gbc_btnValidatePath);
		
		lblFileInfo = new JLabel("File info:");
		GridBagConstraints gbc_lblFileInfo = new GridBagConstraints();
		gbc_lblFileInfo.anchor = GridBagConstraints.WEST;
		gbc_lblFileInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileInfo.gridx = 0;
		gbc_lblFileInfo.gridy = 4;
		contentPane.add(lblFileInfo, gbc_lblFileInfo);
		
		lblInfo = new JLabel("");
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.anchor = GridBagConstraints.WEST;
		gbc_lblInfo.gridwidth = 5;
		gbc_lblInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblInfo.gridx = 1;
		gbc_lblInfo.gridy = 4;
		contentPane.add(lblInfo, gbc_lblInfo);
		
		lblSelectAFilter = new JLabel("Select a filter");
		GridBagConstraints gbc_lblSelectAFilter = new GridBagConstraints();
		gbc_lblSelectAFilter.anchor = GridBagConstraints.WEST;
		gbc_lblSelectAFilter.gridwidth = 3;
		gbc_lblSelectAFilter.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectAFilter.gridx = 0;
		gbc_lblSelectAFilter.gridy = 6;
		contentPane.add(lblSelectAFilter, gbc_lblSelectAFilter);
		
		listFilters = new JList();
		listFilters.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_listFilters = new GridBagConstraints();
		gbc_listFilters.gridwidth = 2;
		gbc_listFilters.insets = new Insets(0, 0, 5, 5);
		gbc_listFilters.fill = GridBagConstraints.BOTH;
		gbc_listFilters.gridx = 0;
		gbc_listFilters.gridy = 7;
		contentPane.add(listFilters, gbc_listFilters);
		
		btnScan = new JButton("Scan");
		GridBagConstraints gbc_btnScan = new GridBagConstraints();
		gbc_btnScan.gridwidth = 3;
		gbc_btnScan.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnScan.insets = new Insets(0, 0, 5, 5);
		gbc_btnScan.gridx = 2;
		gbc_btnScan.gridy = 7;
		contentPane.add(btnScan, gbc_btnScan);
		
		txtPaneResults = new JTextPane();
		txtPaneResults.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_txtPaneResults = new GridBagConstraints();
		gbc_txtPaneResults.insets = new Insets(0, 0, 5, 0);
		gbc_txtPaneResults.fill = GridBagConstraints.BOTH;
		gbc_txtPaneResults.gridx = 5;
		gbc_txtPaneResults.gridy = 7;
		contentPane.add(txtPaneResults, gbc_txtPaneResults);
	}
}
