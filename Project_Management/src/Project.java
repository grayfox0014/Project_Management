import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * This class will allow the user to add new projects.
 *
 * @author Scott Pearson 20954512
 * @version 08/09/11
 */

public class Project extends JFrame {

	/**
	 * This variable is used to set a serial version UID.
	 */
	static final long serialVersionUID = 0L;

	/**
	 * Size constant for the width of the window.
	 */
	static final int WIDTH = 800;

	/**
	 * Size constant for the depth of the window.
	 */
	static final int DEPTH = 600;

	/**
	 * These variables will store the name id and role
	 * of the staff member.
	 */
	private static String[] projname;

	/**
	 * These variables are the JLabels for the class.
	 */
	private JLabel titleLabel, projnameLabel, projmanagerLabel,
	staffLabel, taskLabel;

	/**
	 * These variables will check the users information for errors
	 * and will confirm and create the project.
	 */
	private JButton checkButton, finishButton;

	/**
	 * This variable will allow the user to enter the project name.
	 */
	private static JTextField projnameText;

	/**
	 * These variables allow the user to select the project manager.
	 */
	private JComboBox projmanagerBox, staffmemberBox, taskBox;

	/**
	 * This variable is the content on the gui window.
	 */
	private JPanel contentPane;

	/**
	 * This will be the error message displayed.
	 */
	private String errorMessage;


	/**
	 * This is the constructor for the class and is used to
	 * initialise the variables and set them to what the user
	 * inputs into the system.
	 */
	public Project() {
		super();
		this.setSize(WIDTH, HEIGHT);
		initializeComponent();
		this.setVisible(true);
	}

	/**
	 * This method sets up all the variables as UI
	 * components so they are displayed to the user.
	 */
	private void initializeComponent() {
		titleLabel = new JLabel();
		titleLabel.setFont(new Font("Rockwell", Font.BOLD, 18));
		projnameLabel = new JLabel();
		projnameLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		projmanagerLabel = new JLabel();
		projmanagerLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		staffLabel = new JLabel();
		staffLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		taskLabel = new JLabel();
		taskLabel.setFont(new Font("Courier New", Font.ITALIC, 12));

		checkButton = new JButton("Check");
		checkButton.setEnabled(true);
		finishButton = new JButton("Confirm");
		finishButton.setEnabled(false);

		projnameText = new JTextField();

		projmanagerBox = new JComboBox();
		projmanagerBox.setEditable(true);
		projmanagerBox.setEnabled(true);

		staffmemberBox = new JComboBox();
		staffmemberBox.setEditable(true);
		staffmemberBox.setEnabled(true);

		taskBox = new JComboBox();
		taskBox.setEditable(true);
		taskBox.setEnabled(true);

		contentPane = (JPanel) this.getContentPane();

		titleLabel.setText("Add a new project");
		projnameLabel.setText("Project Name");
		projmanagerLabel.setText("Project Manager");
		staffLabel.setText("Staff");
		taskLabel.setText("Project Tasks");

		projnameText.setActionCommand("projname");
		projnameText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textactionPerformed(e);
			}
		});

		projmanagerBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkactionPerformed(e);
			}
		});

		staffmemberBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkactionPerformed(e);
			}
		});

		taskBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkactionPerformed(e);
			}
		});

		checkButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				checkButtonMouseClicked(e);
    		}
    	});

		finishButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				finishButtonMouseClicked(e);
    		}
    	});

		contentPane.setLayout(null);
		contentPane.setBackground(new Color(61, 169, 106));

		addComponent(contentPane, titleLabel, 300, 40, 800, 25);
		addComponent(contentPane, projnameLabel, 60, 150, 200, 25);
		addComponent(contentPane, projmanagerLabel, 60, 200, 200, 25);
		addComponent(contentPane, staffLabel, 60, 250, 200, 25);
		addComponent(contentPane, taskLabel, 60, 300, 200, 25);

		addComponent(contentPane, projnameText, 400, 150, 200, 20);
		addComponent(contentPane, projmanagerBox, 400, 200, 200, 20);
		addComponent(contentPane, staffmemberBox, 400, 250, 200, 20);
		addComponent(contentPane, taskBox, 400, 300, 200, 20);

		addComponent(contentPane, checkButton, 400, 350, 100, 25);
		addComponent(contentPane, finishButton, 500, 350, 100, 25);

		this.setTitle("Add new project");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(WIDTH, DEPTH));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	/**
	 * This method checks the users information.
	 *
	 * @param e The event we are looking for.
	 */
	public void checkButtonMouseClicked(MouseEvent e) {
		if ((checkButton.isEnabled())) {
			System.out.println("\njcheckButton_mouseClicked"
					+ "(MouseEvent e) called.");
			if (!(checkEmptyDetails())) {
				JOptionPane.showMessageDialog(null,
						errorMessage);
			} else {
				JOptionPane.showMessageDialog(null,
						"Press Finish to complete your registration");
				finishButton.setEnabled(true);
				checkButton.setEnabled(false);
			}
		}
	}

	/**
	 * This method sets up the text fields so the system can
	 * process the users text.
	 *
	 * @param e the text field that we are looking for.
	 */
	private void textactionPerformed(ActionEvent e) {
		int i = 0;
		String cmd = e.getActionCommand();
		System.out.println(cmd);

		if (e.getActionCommand() == "projname") {
			projname[i] = projnameText.getText();
		}
		i++;
	}

	/**
	 * This method is the event that is processed when
	 * the user has finished entering information.
	 * @param e The event we are searching for.
	 */
	 private void checkactionPerformed(ActionEvent e) {
		int i = 0;
		Staff.staffname[i] = (String) projmanagerBox.getSelectedItem();
		i++;
		Staff.staffname[i] = (String) staffmemberBox.getSelectedItem();
		Task.taskname[i] = (String) taskBox.getSelectedItem();
		i++;
	}

	/**
	 * This method is the event that is processed when
	 * the user has finished entering information.
	 *
	 * @param e The event we are searching for.
	 */
	public void finishButtonMouseClicked(MouseEvent e) {
		if ((finishButton.isEnabled())) {
			System.out.println("\njnextButton_mouseClicked"
					+ "(MouseEvent e) called.");
			this.dispose();
			new ProjectGUI();
		}
	}

	/**
	 * This method checks if the user has entered information.
	 *
	 * @return boolean true or false value
	 */
	private boolean checkEmptyDetails() {
		boolean error = true;
		errorMessage = "Fill in these fields "
			+ "to continue OR enter a valid\n";
		if (projnameText.getText().equals("")) {
			errorMessage += "- projname\n";
			error = false;
		}
		return error;
	}

	/**
	 * This helper method allows the GUI window to use
	 * absolute positioning of the components that will be added.
	 *
	 * @param container The window boundaries.
	 * @param c The type of component being added.
	 * @param x The location of the component (window width).
	 * @param y The location of the component (window height).
	 * @param width The width of the component size.
	 * @param height The height of the component size.
	 */
	private void addComponent(Container container, Component c,
			int x, int y, int width, int height) {
		c.setBounds(x, y, width, height);
		container.add(c);
	}
}