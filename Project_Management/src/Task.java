import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class will allow the user to add new tasks.
 *
 * @author Scott Pearson 20954512
 * @version 08/09/11
 */

public class Task extends JFrame {

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
	 * These variable store the name of the task and its description..
	 */
	static String[] taskname, description, start, finish;

	/**
	 * This variable will tell the user if the task is complete
	 * or if the task is not complete.
	 */
	private boolean complete;

	/**
	 * These variables are the JLabels for the class.
	 */
	private JLabel titleLabel, tasknameLabel, descriptionLabel, staffnameLabel,
	startLabel, finishLabel, completeLabel;

	/**
	 * These variable will allow the user to enter the task name
	 * the task description and the start and finish date.
	 */
	private JTextField tasknameText, taskdescriptionText, startText, finishText;

	/**
	 * These variables allow the user to select the
	 * staff member assigned to task.
	 */
	private JComboBox staffnameBox;

	/**
	 * This variable sets the finish value to true or false
	 * by the user selection.
	 */
	private JCheckBox finishBox;

	/**
	 * These variables will check the users information for errors
	 * and will confirm and create the task.
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
	 * This is the constructor for the task method and is used
	 * to initialise all the variables.
	 */
	public Task() {
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
		tasknameLabel = new JLabel();
		tasknameLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		descriptionLabel = new JLabel();
		descriptionLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		staffnameLabel = new JLabel();
		staffnameLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		startLabel = new JLabel();
		startLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		finishLabel = new JLabel();
		finishLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		completeLabel = new JLabel();
		completeLabel.setFont(new Font("Courier New", Font.ITALIC, 12));

		checkButton = new JButton("Check");
		checkButton.setEnabled(true);
		finishButton = new JButton("Confirm");
		finishButton.setEnabled(false);

		tasknameText = new JTextField();
		taskdescriptionText = new JTextField();
		startText = new JTextField();
		startText.setText("dd/mm/yyyy");
		finishText = new JTextField();
		finishText.setText("dd/mm/yyyy");

		staffnameBox = new JComboBox();
		staffnameBox.setEditable(true);
		staffnameBox.setEnabled(true);
		finishBox = new JCheckBox();
		finishBox.setEnabled(true);

		contentPane = (JPanel) this.getContentPane();

		titleLabel.setText("Add a new task");
		tasknameLabel.setText("Task Name");
		descriptionLabel.setText("Task Description");
		staffnameLabel.setText("Assign Staff");
		startLabel.setText("Start Date");
		finishLabel.setText("Finish Date");
		completeLabel.setText("Is Complete?");

		tasknameText.setActionCommand("taskname");
		tasknameText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textactionPerformed(e);
			}
		});

		taskdescriptionText.setActionCommand("description");
		taskdescriptionText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textactionPerformed(e);
			}
		});

		startText.setActionCommand("start");
		startText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textactionPerformed(e);
			}
		});

		finishText.setActionCommand("finish");
		finishText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textactionPerformed(e);
			}
		});


		 staffnameBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkactionPerformed(e);
			}
		});

		 finishBox.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				finishBoxButtonMouseClicked(e);
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
		addComponent(contentPane, tasknameLabel, 60, 150, 200, 25);
		addComponent(contentPane, descriptionLabel, 60, 200, 200, 25);
		addComponent(contentPane, staffnameLabel, 60, 250, 200, 25);
		addComponent(contentPane, startLabel, 60, 300, 200, 25);
		addComponent(contentPane, finishLabel, 60, 350, 200, 25);
		addComponent(contentPane, completeLabel, 60, 400, 200, 25);

		addComponent(contentPane, tasknameText, 400, 150, 200, 20);
		addComponent(contentPane, taskdescriptionText, 400, 200, 200, 20);
		addComponent(contentPane, staffnameBox, 400, 250, 200, 20);
		addComponent(contentPane, startText, 400, 300, 200, 20);
		addComponent(contentPane, finishText, 400, 350, 200, 20);
	    addComponent(contentPane, finishBox, 400, 400, 25, 20);

		addComponent(contentPane, checkButton, 400, 450, 100, 25);
	    addComponent(contentPane, finishButton, 500, 450, 100, 25);

		this.setTitle("Add Staff Member");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(WIDTH, DEPTH));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	/**
	 * This method checks if the user has entered information.
	 *
	 * @return boolean true or false value
	 */
	private boolean checkEmptyDetails() {
		boolean error = true;
		errorMessage = "Fill in these fields "
			+ "to continue\n";
		if (tasknameText.getText().equals("")) {
			errorMessage += "- taskname\n";
			error = false;
		}
		if (taskdescriptionText.getText().equals("")) {
			errorMessage += "- taskdescription\n";
			error = false;
		}
		if (startText.getText().equals("")) {
			errorMessage += "- start\n";
			error = false;
		}
		if (finishText.getText().equals("")) {
			errorMessage += "- finish\n";
			error = false;
		}
		return error;
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
						"Please fill in the details");
			} else {
				JOptionPane.showMessageDialog(null,
						"Press Finish to complete your registration");
				finishButton.setEnabled(true);
				checkButton.setEnabled(false);
			}
		}
	}

	/**
	 * This method checks the users information.
	 *
	 * @param e The event we are looking for.
	 */
	 public void finishBoxButtonMouseClicked(MouseEvent e) {
		complete = !complete;
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

		 if (e.getActionCommand() == "taskname") {
			taskname[i] = tasknameText.getText();
		} else if (e.getActionCommand() == "description") {
			description[i] = taskdescriptionText.getText();
		} else if (e.getActionCommand() == "start") {
			start[i] = startText.getText();
		} else if (e.getActionCommand() == "finish") {
			finish[i] = finishText.getText();
		}
		i++;
	}

	/**
	 * This method is the event that is processed when
	 * the user has finished entering information.
	 * @param e The event we are searching for.
	 */
	 void checkactionPerformed(ActionEvent e) {
		int i = 0;
		Staff.staffname[i] = (String) staffnameBox.getSelectedItem();
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
	 * This helper method allows the GUI window to use
	 * absolute positioning of the components that will be added.
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