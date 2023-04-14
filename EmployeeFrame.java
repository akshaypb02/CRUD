import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeFrame extends Frame {

	Connection c;
	Statement statement;
	ResultSet result;

	EmployeeFrame() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			c = DriverManager.getConnection(
					"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
			statement = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			result = statement.executeQuery("select * from employeedata");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Frame f = new Frame();

		f.setBackground(new Color(0x88C8CB));
		Label applicationame = new Label("Employee CRUD");
		applicationame.setForeground(Color.black);
		applicationame.setFont(new Font("Consolas", Font.BOLD, 40));
		applicationame.setBounds(550, 50, 320, 100);

		Label empno = new Label("Emp No");
		empno.setForeground(Color.black);
		empno.setFont(new Font("Roboto", Font.CENTER_BASELINE, 20));
		empno.setBounds(120, 150, 100, 100);

		TextField empnoArea = new TextField();
		empnoArea.setEditable(true);

		empnoArea.setEnabled(true);
		empnoArea.setBackground(Color.lightGray);
		empnoArea.setFont(new Font("Consolas", Font.CENTER_BASELINE, 15));
		empnoArea.setBounds(240, 190, 300, 30);

		Label name = new Label("Name");
		name.setForeground(Color.black);
		name.setFont(new Font("Roboto", Font.CENTER_BASELINE, 20));
		name.setBounds(120, 220, 100, 100);

		TextField nameArea = new TextField();
		nameArea.setEditable(true);

		nameArea.setEnabled(true);
		nameArea.setBackground(Color.lightGray);
		nameArea.setFont(new Font("Consolas", Font.CENTER_BASELINE, 15));
		nameArea.setBounds(240, 255, 300, 30);

		Label job = new Label("Job");
		job.setForeground(Color.black);
		job.setFont(new Font("Roboto", Font.CENTER_BASELINE, 20));
		job.setBounds(120, 290, 100, 100);

		TextField jobArea = new TextField();
		jobArea.setEditable(true);

		jobArea.setEnabled(true);
		jobArea.setBackground(Color.lightGray);
		jobArea.setFont(new Font("Consolas", Font.CENTER_BASELINE, 15));
		jobArea.setBounds(240, 330, 300, 30);

		Label salary = new Label("Salary");
		salary.setForeground(Color.black);

		salary.setFont(new Font("Roboto", Font.CENTER_BASELINE, 20));
		salary.setBounds(120, 360, 100, 100);

		TextField salaryArea = new TextField();
		salaryArea.setEditable(true);

		salaryArea.setEnabled(true);
		salaryArea.setBackground(Color.lightGray);
		salaryArea.setFont(new Font("Consolas", Font.CENTER_BASELINE, 15));
		salaryArea.setBounds(240, 395, 300, 30);

		Label department = new Label("department");
		department.setForeground(Color.black);

		department.setFont(new Font("Roboto", Font.CENTER_BASELINE, 20));
		department.setBounds(120, 440, 120, 100);

		TextField departmentArea = new TextField();
		departmentArea.setEditable(true);

		departmentArea.setEnabled(true);
		departmentArea.setBackground(Color.lightGray);
		departmentArea.setFont(new Font("Consolas", Font.CENTER_BASELINE, 15));
		departmentArea.setBounds(240, 475, 300, 30);

		Button first = new Button("first");
		first.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		first.setBackground(Color.black);
		first.setForeground(Color.white);
		first.setBounds(100, 600, 100, 30);

		Button add = new Button("add");
		add.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.setBounds(100, 650, 100, 30);

		Button next = new Button("next");
		next.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setBounds(220, 600, 100, 30);

		Button edit = new Button("edit");
		edit.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		edit.setBackground(Color.black);
		edit.setForeground(Color.white);
		edit.setBounds(220, 650, 100, 30);

		Button prev = new Button("prev");
		prev.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		prev.setBackground(Color.black);
		prev.setForeground(Color.white);
		prev.setBounds(340, 600, 100, 30);

		Button delete = new Button("delete");
		delete.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		delete.setBackground(Color.black);
		delete.setForeground(Color.white);
		delete.setBounds(340, 650, 100, 30);

		Button last = new Button("last");
		last.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		last.setBackground(Color.black);
		last.setForeground(Color.white);
		last.setBounds(460, 600, 100, 30);

		Button clear = new Button("clear");
		clear.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.setBounds(580, 600, 100, 30);

		Button exit = new Button("exit");
		exit.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		exit.setBackground(Color.black);
		exit.setForeground(Color.white);
		exit.setBounds(580, 650, 100, 30);

		Button save = new Button("save");
		save.setFont(new Font("TimesNewRoman", Font.CENTER_BASELINE, 15));
		save.setBackground(Color.black);
		save.setForeground(Color.white);
		save.setBounds(460, 650, 100, 30);

		TextArea outputScreen = new TextArea("", 100, 100, TextArea.SCROLLBARS_NONE);

		outputScreen.setBounds(770, 180, 500, 500);

		outputScreen.setBackground(Color.lightGray);

		outputScreen.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
		outputScreen.setForeground(Color.black);

		outputScreen.setEditable(false);

		f.setLayout(null);

		f.add(empno);
		f.add(applicationame);
		f.add(empnoArea);
		f.add(name);
		f.add(nameArea);
		f.add(job);
		f.add(jobArea);
		f.add(salary);
		f.add(salaryArea);
		f.add(department);
		f.add(departmentArea);
		f.add(outputScreen);

		f.add(first);
		f.add(next);
		f.add(prev);
		f.add(last);
		f.add(add);
		f.add(edit);
		f.add(delete);
		f.add(save);
		f.add(clear);
		f.add(exit);
		f.setVisible(true);

		f.setSize(1600, 1600);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}
		});

		first.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					result.first();

					for (int i = 1; i <= 5; i++) {

						outputScreen.setText(outputScreen.getText() + result.getString(i) + " ");
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				outputScreen.setText(outputScreen.getText() + "\n");
			}

		});

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					while (result.next()) {

						for (int i = 1; i <= 5; i++) {

							outputScreen.setText(outputScreen.getText() + result.getString(i) + " ");
						}
						break;
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				outputScreen.setText(outputScreen.getText() + "\n");
			}

		});

		prev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (result.isBeforeFirst() || result.isFirst()) {

						outputScreen.setText(outputScreen.getText() + "nothing to move");

					} else {
						while (!result.isFirst() && result.previous()) {

							for (int i = 1; i <= 5; i++) {

								outputScreen.setText(outputScreen.getText() + result.getString(i) + " ");
							}
							break;
						}
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				outputScreen.setText(outputScreen.getText() + "\n");
			}

		});

		last.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					result.last();

					for (int i = 1; i <= 5; i++) {

						outputScreen.setText(outputScreen.getText() + result.getString(i) + " ");
					}

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

				outputScreen.setText(outputScreen.getText() + "\n");
			}

		});

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				outputScreen.setText(" ");
			}

		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}

		});

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					result.moveToInsertRow();

					PreparedStatement ps = c.prepareStatement("insert into employeedata values( ?,?,?,?,?)");

					ps.setInt(1, (int) new Integer(empnoArea.getText()));
					ps.setString(2, nameArea.getText());
					ps.setString(3, jobArea.getText());
					ps.setFloat(4, (float) new Float(salaryArea.getText()));
					ps.setString(5, departmentArea.getText());

					if (ps.executeUpdate() > 0) {
						outputScreen.setText("Updated" + "\n");
					}
					result.insertRow();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				outputScreen.setText(outputScreen.getText() + "\n");

			}

		});

		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					PreparedStatement ps = c.prepareStatement(
							"update employeedata set  name= ?,  job=?,  salary=?,  departement=?  where empno=?");

					ps.setInt(5, (int) new Integer(empnoArea.getText()));
					ps.setString(1, nameArea.getText());
					ps.setString(2, jobArea.getText());
					ps.setFloat(3, (float) new Float(salaryArea.getText()));
					ps.setString(4, departmentArea.getText());

					if (ps.executeUpdate() > 0) {
						outputScreen.setText("Updated" + "\n");
					}
					result = statement.executeQuery("select * from employeedata");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				outputScreen.setText(outputScreen.getText() + "\n");

			}

		});
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					PreparedStatement ps = c.prepareStatement("delete from  employeedata   where empno=?");

					ps.setInt(1, (int) new Integer(empnoArea.getText()));

					if (ps.executeUpdate() > 0) {
						outputScreen.setText("deleted" + "\n");
					}
					result = statement.executeQuery("select * from employeedata");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				outputScreen.setText(outputScreen.getText() + "\n");

			}

		});

	}

	// @Override
	// public void paint(Graphics g) {
	//
	// super.paint(g);
	// g.setColor(Color.black);
	// g.drawRect(10, 10, 1000, 1000);
	//
	// }

	public static void main(String[] args) {

		EmployeeFrame frame = new EmployeeFrame();

	}

}
