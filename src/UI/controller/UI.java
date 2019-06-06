package UI.controller;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class UI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	protected JPanel contentPane;
	protected JButton btnChooseFile;
	protected FileDialog fileDialog;
	protected JList listFilters;
	protected JLabel lblSelectAFile;
	protected JLabel lblSelectAFilter;
	protected JButton btnScan;
	protected JTextPane txtPaneResults;
	protected JLabel lblFileInfo;
	protected JScrollPane scrollPane;
	protected JScrollPane scrollPane_1;
	protected JButton btnAddAction;
	protected JButton btnRemoveAction;
	protected JButton btnGenerate;
	protected JScrollPane scrollPane_2;
	protected JList listActions;
	protected JLabel lblRutaDeSalida;
	protected JTextField txtOutput;
	protected JLabel lblInfo;

	public UI() {
		setTitle("xls2sql");
		this.fileDialog = new FileDialog(this, "Select file or directory...");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 20, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 15, 15, 12, 24, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblSelectAFile = new JLabel("Seleccione un fichero ");
		GridBagConstraints gbc_lblSelectAFile = new GridBagConstraints();
		gbc_lblSelectAFile.anchor = GridBagConstraints.WEST;
		gbc_lblSelectAFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectAFile.gridx = 0;
		gbc_lblSelectAFile.gridy = 0;
		contentPane.add(lblSelectAFile, gbc_lblSelectAFile);
		
		btnChooseFile = new JButton("Seleccionar archivo");
		
		GridBagConstraints gbc_btnChooseFile = new GridBagConstraints();
		gbc_btnChooseFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChooseFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnChooseFile.anchor = GridBagConstraints.SOUTH;
		gbc_btnChooseFile.gridx = 1;
		gbc_btnChooseFile.gridy = 0;
		contentPane.add(btnChooseFile, gbc_btnChooseFile);
		
		lblFileInfo = new JLabel("Informaci\u00F3n del archivo:");
		GridBagConstraints gbc_lblFileInfo = new GridBagConstraints();
		gbc_lblFileInfo.anchor = GridBagConstraints.WEST;
		gbc_lblFileInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileInfo.gridx = 0;
		gbc_lblFileInfo.gridy = 1;
		contentPane.add(lblFileInfo, gbc_lblFileInfo);
		
		lblInfo = new JLabel("");
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblInfo.gridx = 1;
		gbc_lblInfo.gridy = 1;
		contentPane.add(lblInfo, gbc_lblInfo);
		
		lblRutaDeSalida = new JLabel("Ruta de salida:");
		GridBagConstraints gbc_lblRutaDeSalida = new GridBagConstraints();
		gbc_lblRutaDeSalida.anchor = GridBagConstraints.WEST;
		gbc_lblRutaDeSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblRutaDeSalida.gridx = 0;
		gbc_lblRutaDeSalida.gridy = 2;
		contentPane.add(lblRutaDeSalida, gbc_lblRutaDeSalida);
		
		txtOutput = new JTextField();
		GridBagConstraints gbc_txtOutput = new GridBagConstraints();
		gbc_txtOutput.gridwidth = 3;
		gbc_txtOutput.anchor = GridBagConstraints.NORTH;
		gbc_txtOutput.insets = new Insets(0, 0, 5, 0);
		gbc_txtOutput.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOutput.gridx = 1;
		gbc_txtOutput.gridy = 2;
		contentPane.add(txtOutput, gbc_txtOutput);
		txtOutput.setColumns(10);
		
		lblSelectAFilter = new JLabel("Seleccione un filtro o configure un script");
		GridBagConstraints gbc_lblSelectAFilter = new GridBagConstraints();
		gbc_lblSelectAFilter.anchor = GridBagConstraints.WEST;
		gbc_lblSelectAFilter.gridwidth = 3;
		gbc_lblSelectAFilter.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectAFilter.gridx = 0;
		gbc_lblSelectAFilter.gridy = 4;
		contentPane.add(lblSelectAFilter, gbc_lblSelectAFilter);
		
		btnScan = new JButton("Generar SQL");
		GridBagConstraints gbc_btnScan = new GridBagConstraints();
		gbc_btnScan.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnScan.anchor = GridBagConstraints.NORTH;
		gbc_btnScan.insets = new Insets(0, 0, 5, 5);
		gbc_btnScan.gridx = 2;
		gbc_btnScan.gridy = 5;
		contentPane.add(btnScan, gbc_btnScan);
		
		scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridheight = 4;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 3;
		gbc_scrollPane_2.gridy = 5;
		contentPane.add(scrollPane_2, gbc_scrollPane_2);
		
		listActions = new JList();
		listActions.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_2.setViewportView(listActions);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 5;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		listFilters = new JList();
		scrollPane.setViewportView(listFilters);
		listFilters.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnAddAction = new JButton("A\u00F1adir acci\u00F3n");
		GridBagConstraints gbc_btnAadirAccin = new GridBagConstraints();
		gbc_btnAadirAccin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAadirAccin.anchor = GridBagConstraints.NORTH;
		gbc_btnAadirAccin.insets = new Insets(0, 0, 5, 5);
		gbc_btnAadirAccin.gridx = 2;
		gbc_btnAadirAccin.gridy = 6;
		contentPane.add(btnAddAction, gbc_btnAadirAccin);
		
		btnRemoveAction = new JButton("Quitar acci\u00F3n");
		GridBagConstraints gbc_btnQuitarAccin = new GridBagConstraints();
		gbc_btnQuitarAccin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuitarAccin.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuitarAccin.gridx = 2;
		gbc_btnQuitarAccin.gridy = 7;
		contentPane.add(btnRemoveAction, gbc_btnQuitarAccin);
		
		btnGenerate = new JButton("Generar DB");
		GridBagConstraints gbc_btnGenerarDb = new GridBagConstraints();
		gbc_btnGenerarDb.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGenerarDb.anchor = GridBagConstraints.NORTH;
		gbc_btnGenerarDb.insets = new Insets(0, 0, 5, 5);
		gbc_btnGenerarDb.gridx = 2;
		gbc_btnGenerarDb.gridy = 8;
		contentPane.add(btnGenerate, gbc_btnGenerarDb);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 4;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 9;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		txtPaneResults = new JTextPane();
		scrollPane_1.setViewportView(txtPaneResults);
		txtPaneResults.setBorder(new LineBorder(new Color(0, 0, 0)));
	}
}
