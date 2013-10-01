import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class will display all the project information.
 * The class uses JFrame to allow the user to enter information
 * into a GUI which is more user friendly.
 *
 * @author Scott Pearson 20954512
 * @version 08/09/11
 */

public class ProjectGUI extends JFrame {

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
	 * The variables of the J label that will be used.
	 */
	private JLabel welcomeLabel, newProject, newStaff, newTask, checkTask;

	/**
	 * These variables are all the J buttons that will be used.
	 */
	private JButton addProject, addStaff, addTask, viewTask;

	/**
	 * This variable is the content on the gui window.
	 */
	private JPanel contentPane;

	/**
	 * This constructor will set up the GUI window
	 * and initialise all the GUI components.
	 */
	public ProjectGUI() {
		super();
		this.setSize(WIDTH, DEPTH);
		initializeComponent();
		this.setVisible(true);
	}

	/**
	 * This method sets up all the variables as UI
	 * components so they are displayed to the user.
	 */
	private void initializeComponent() {
		welcomeLabel = new JLabel();
		welcomeLabel.setFont(new Font("Rockwell", Font.BOLD, 18));
		newProject = new JLabel();
		newProject.setFont(new Font("Courier New", Font.ITALIC, 12));
		newStaff = new JLabel();
		newStaff.setFont(new Font("Courier New", Font.ITALIC, 12));
		newTask = new JLabel();
		newTask.setFont(new Font("Courier New", Font.ITALIC, 12));
		checkTask = new JLabel();
		checkTask.setFont(new Font("Courier New", Font.ITALIC, 12));

		addProject = new JButton();
		addProject.setEnabled(false);
		addProject.setBackground(Color.black);
		addStaff = new JButton();
		addStaff.setEnabled(false);
		addStaff.setBackground(Color.black);
		addTask = new JButton();
		addTask.setEnabled(false);
		addTask.setBackground(Color.black);
		viewTask = new JButton();
		viewTask.setEnabled(false);
		viewTask.setBackground(Color.black);

		contentPane = (JPanel) this.getContentPane();

		welcomeLabel.setText("Welcome to SP Management System");

		newProject.setText("Create a New Project ---->");
		newStaff.setText("Add New Staff Members ---->");
		newTask.setText("Add a New Task ---->");
		checkTask.setText("Check Task Deadlines ---->");

		addProject.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				addProjectMouseClicked(e);
    		}
    	});

		addStaff.addMouseListener(new MouseAdapter() {
    		public void mouseClicked(MouseEvent e) {
    			addStaffMouseClicked(e);
    		}
    	});

		addTask.addMouseListener(new MouseAdapter() {
    		public void mouseClicked(MouseEvent e) {
    			addTaskMouseClicked(e);
    		}
    	});

		viewTask.addMouseListener(new MouseAdapter() {
    		public void mouseClicked(MouseEvent e) {
    			viewTaskMouseClicked(e);
    		}
    	});

		contentPane.setLayout(null);
		contentPane.setBackground(new Color(61, 169, 106));

		addComponent(contentPane, welcomeLabel, 250, 40, 800, 25);
		addComponent(contentPane, newProject, 60, 150, 200, 25);
		addComponent(contentPane, newStaff, 60, 200, 200, 25);
		addComponent(contentPane, newTask, 60, 250, 200, 25);
		addComponent(contentPane, checkTask, 60, 300, 200, 25);

		addComponent(contentPane, addProject, 400, 150, 60, 20);
		addComponent(contentPane, addStaff, 400, 200, 60, 20);
		addComponent(contentPane, addTask, 400, 250, 60, 20);
		addComponent(contentPane, viewTask, 400, 300, 60, 20);

		this.setTitle("SP Management");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(WIDTH, DEPTH));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	/**
	 * This method will implement the listener and tell
	 * the listener to create a new instance of the Project class.
	 *
	 * @param e The mouse event that needs to be searched for.
	 */
	public void addProjectMouseClicked(MouseEvent e) {
		addProject.setEnabled(true);
		if ((addProject.isEnabled())) {
			System.out.println("\njnextButton_mouseClicked"
					+ "(MouseEvent e) called.");

			this.dispose();
			new Project();
		}
	}

	/**
	 * This method will implement the listener and tell
	 * the listener to create a new instance of the Staff class.
	 *
	 * @param e The mouse event that needs to be searched for.
	 */
	public void addStaffMouseClicked(MouseEvent e) {
		addStaff.setEnabled(true);
		if ((addStaff.isEnabled())) {
			System.out.println("\njnextButton_mouseClicked"
					+ "(MouseEvent e) called.");
			this.dispose();
			new Staff();
		}
	}

	/**
	 * This method will implement the listener and tell
	 * the listener to create a new instance of the Task class.
	 *
	 * @param e The mouse event that needs to be searched for.
	 */
	public void addTaskMouseClicked(MouseEvent e) {
		addTask.setEnabled(true);
		if ((addTask.isEnabled())) {
			System.out.println("\njnextButton_mouseClicked"
					+ "(MouseEvent e) called.");
			this.dispose();
			new Task();
		}
	}

	/**
	 * This method will implement the listener and tell
	 * the listener to create a new instance of the Task class.
	 *
	 * @param e The mouse event that needs to be searched for.
	 */
	public void viewTaskMouseClicked(MouseEvent e) {
		viewTask.setEnabled(true);
		if ((viewTask.isEnabled())) {
			System.out.println("\njnextButton_mouseClicked"
					+ "(MouseEvent e) called.");
			this.dispose();
			new Task();
		}
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

	/**
	 * This is the main method which will initialise this class.
	 *
	 * @param args The arguments that the operating system provides.
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(false);
		JDialog.setDefaultLookAndFeelDecorated(true);
		new ProjectGUI();
	}
}
