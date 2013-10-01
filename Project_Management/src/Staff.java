import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class will allow the user to add new staff members.
 *
 * @author Scott Pearson 20954512
 * @version 08/09/11
 */
public class Staff extends JFrame {

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
	static String[] staffname, staffid, staffrole;

	/**
	 * These variables are the JLabels for the class.
	 */
	private JLabel titleLabel, staffidLabel, staffnameLabel, roleLabel;

	/**
	 * These variables allow the user to enter the staff information.
	 */
	private JTextField idText, staffnameText, roleText;

	/**
	 * These variables will check the users information for errors
	 * and will confirm and create the staff member.
	 */
	private JButton checkButton, finishButton;

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
	 * initialise the variables.
	 */
	public Staff() {
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
		staffidLabel = new JLabel();
		staffidLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		staffnameLabel = new JLabel();
		staffnameLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		roleLabel = new JLabel();
		roleLabel.setFont(new Font("Courier New", Font.ITALIC, 12));

	    idText = new JTextField();
		staffnameText = new JTextField();
		roleText = new JTextField();

		checkButton = new JButton("Check");
		checkButton.setEnabled(true);
		finishButton = new JButton("Confirm");
		finishButton.setEnabled(false);

		contentPane = (JPanel) this.getContentPane();

		titleLabel.setText("Add a staff member");
		staffidLabel.setText("Staff ID");
		staffnameLabel.setText("Staff Name");
		roleLabel.setText("Role");

		idText.setActionCommand("id");
		idText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textactionPerformed(e);
			}
		});

		staffnameText.setActionCommand("name");
		staffnameText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textactionPerformed(e);
			}
		});

		roleText.setActionCommand("role");
		roleText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textactionPerformed(e);
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
		addComponent(contentPane, staffidLabel, 60, 150, 200, 25);
		addComponent(contentPane, staffnameLabel, 60, 200, 200, 25);
		addComponent(contentPane, roleLabel, 60, 250, 200, 25);

		addComponent(contentPane, idText, 400, 150, 200, 20);
		addComponent(contentPane, staffnameText, 400, 200, 200, 20);
		addComponent(contentPane, roleText, 400, 250, 200, 20);

		addComponent(contentPane, checkButton, 400, 350, 100, 25);
		addComponent(contentPane, finishButton, 500, 350, 100, 25);

		this.setTitle("Add Staff Member");
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

		if (e.getActionCommand() == "id") {
			staffid[i] = idText.getText();
		} else if (e.getActionCommand() == "name") {
			staffname[i] = staffnameText.getText();
		} else if (e.getActionCommand() == "role") {
			staffrole[i] = roleText.getText();
		}
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
		if (idText.getText().equals("")) {
			errorMessage += "- id\n";
			error = false;
		}
		if (staffnameText.getText().equals("")) {
			errorMessage += "- staffname\n";
			error = false;
		}
		if (roleText.getText().equals("")) {
			errorMessage += "- role\n";
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