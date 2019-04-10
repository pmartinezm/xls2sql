package UI;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmSettings = new JMenuItem("Settings");
		mnOptions.add(mntmSettings);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenu mnFilters = new JMenu("Filters");
		mnHelp.add(mnFilters);
		
		JMenuItem mntmAddingFilters = new JMenuItem("Adding filters");
		mnFilters.add(mntmAddingFilters);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnChooseFile = new JButton("Choose file");
		FileDialog dialog = new FileDialog(this, "Choose a file");
		
		GridBagConstraints gbc_btnChooseFile = new GridBagConstraints();
		gbc_btnChooseFile.anchor = GridBagConstraints.SOUTH;
		gbc_btnChooseFile.insets = new Insets(0, 0, 0, 5);
		gbc_btnChooseFile.gridx = 1;
		gbc_btnChooseFile.gridy = 0;
		contentPane.add(btnChooseFile, gbc_btnChooseFile);
		
		btnChooseFile.addActionListener(new ChooseFile(dialog));
	}
}
