import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MainFrame extends Frame {

	Connection c;
	Statement statement;

	MainFrame() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			c = DriverManager.getConnection(
					"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Frame f = new Frame();
		f.setBackground(Color.CYAN);
		f.setFont(new Font("Consolas", Font.BOLD, 40));

		Label applicationname = new Label("CRUD");
		applicationname.setBounds(600, 50, 200, 100);

		Label createlabel = new Label("Create");
		createlabel.setBounds(100, 175, 200, 100);

		Label updatelabel = new Label("Update");
		updatelabel.setBounds(100, 275, 200, 100);

		Label readlabel = new Label("Read");
		readlabel.setBounds(100, 375, 200, 100);

		Label deletelabel = new Label("Delete");
		deletelabel.setBounds(100, 475, 200, 100);

		TextArea createArea = new TextArea();

		createArea.setBounds(300, 200, 800, 50);
		createArea.setFont(new Font("Consolas", Font.BOLD, 15));

		TextArea updateArea = new TextArea();
		updateArea.setBounds(300, 300, 800, 50);
		updateArea.setFont(new Font("Consolas", Font.BOLD, 15));

		TextArea readArea = new TextArea();
		readArea.setBounds(300, 400, 800, 50);
		readArea.setFont(new Font("Consolas", Font.BOLD, 15));

		TextArea deleteArea = new TextArea();
		deleteArea.setBounds(300, 500, 800, 50);
		deleteArea.setFont(new Font("Consolas", Font.BOLD, 15));

		Button create = new Button("create");
		create.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		create.setBackground(Color.yellow);
		create.setForeground(Color.black);
		create.setBounds(1200, 200, 50, 30);

		Button update = new Button("update");
		update.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		update.setBackground(Color.BLUE);
		update.setForeground(Color.white);
		update.setBounds(1200, 300, 50, 30);

		Button read = new Button("read");
		read.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		read.setBackground(Color.black);
		read.setForeground(Color.white);
		read.setBounds(1200, 400, 50, 30);

		Button delete = new Button("delete");
		delete.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		delete.setBackground(Color.red);
		delete.setForeground(Color.white);
		delete.setBounds(1200, 500, 50, 30);

		TextArea outputScreen = new TextArea();
		outputScreen.setEditable(false);
		outputScreen.setBounds(200, 600, 1000, 250);
		outputScreen.setFocusable(false);
		outputScreen.setFont(new Font("TimesNewRoman", Font.LAYOUT_LEFT_TO_RIGHT, 15));

		outputScreen.setBackground(Color.black);
		outputScreen.setForeground(Color.white);

		f.setLayout(null);
		f.add(applicationname);
		f.add(createlabel);
		f.add(updatelabel);
		f.add(readlabel);
		f.add(deletelabel);
		f.add(createArea);
		f.add(updateArea);
		f.add(readArea);
		f.add(deleteArea);
		f.add(create);
		f.add(update);
		f.add(read);
		f.add(delete);
		f.add(outputScreen);

		f.setVisible(true);
		f.setSize(1600, 1600);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}
		});

		read.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				outputScreen.setText(outputScreen.getText() + "\n \n");
				String s = readArea.getText();

				readArea.setText("");

				try {
					statement = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					ResultSet ret = statement.executeQuery(s);

					ResultSetMetaData metadata = ret.getMetaData();

					int columnsNumber = metadata.getColumnCount();
					//
					// outputScreen.setText("" + count);
					int j = 1;

					while (ret.next()) {
						// Print one row
						for (int i = 1; i <= columnsNumber; i++) {

							outputScreen.setText(outputScreen.getText() + ret.getString(i) + " "); // Print one element
																									// of a row

						}

						// Move to the next line to print the next row.
						outputScreen.setText(outputScreen.getText() + "\n");
					}

				} catch (SQLException e1) {
					outputScreen.setText("unable to delete the table or poor query \n");
					e1.printStackTrace();
				}

			}

		});

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = deleteArea.getText();

				deleteArea.setText("");

				try {
					statement = c.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					int ret = statement.executeUpdate(s);

					if (ret == 0) {
						outputScreen.setText("table deleted\n");

					}

				} catch (SQLException e1) {
					outputScreen.setText("unable to delete the table or poor query \n");
					e1.printStackTrace();
				}

			}

		});
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = updateArea.getText();
				updateArea.setText("");

				try {
					statement = c.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					int ret = statement.executeUpdate(s);

					outputScreen.setText(ret + " rows updated \n");

				} catch (SQLException e1) {
					outputScreen.setText("poor result or wrong query \n");
					e1.printStackTrace();
				}

			}

		});
		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = createArea.getText();
				createArea.setText("");

				try {
					statement = c.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					int ret = statement.executeUpdate(s);

					if (ret == 0) {
						outputScreen.setText("Table created \n");

					}

				} catch (SQLException e1) {
					outputScreen.setText("Table already exits or poor query \n");
					e1.printStackTrace();
				}

			}
		});

	}

	public static void main(String[] args) {
		MainFrame frameobj = new MainFrame();

	}

}
