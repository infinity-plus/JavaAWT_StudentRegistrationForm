import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class StudentRegistrationForm extends Frame implements ActionListener {
    private Button submitButton = new Button("Submit");
    private Label nameLabel = new Label("Name");
    private Label ageLabel = new Label("Age");
    private Label genderLabel = new Label("Gender");
    private Label semesterLabel = new Label("Semester");
    private TextField nameTextField = new TextField(20);
    private TextField ageTextField = new TextField(3);
    private CheckboxGroup genderCheckboxGroup = new CheckboxGroup();
    private Checkbox maleGenderCheckbox = new Checkbox("Male", false, genderCheckboxGroup);
    private Checkbox femaleGenderCheckbox = new Checkbox("Female", false, genderCheckboxGroup);
    private Checkbox otherGenderCheckbox = new Checkbox("Other", true, genderCheckboxGroup);
    private Choice semesterChoice = new Choice();

    StudentRegistrationForm(String title) {
        this.setTitle(title);
    }

    public void setupUI() {
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLayout(null);
        this.setupObjects();
    }

    private void setupObjects() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                dispose();
            }
        });
        nameLabel.setBounds(50, 50, 70, 20);
        nameTextField.setBounds(150, 50, 120, 20);
        ageLabel.setBounds(50, 100, 70, 20);
        ageTextField.setBounds(150, 100, 30, 20);
        genderLabel.setBounds(50, 150, 70, 20);
        maleGenderCheckbox.setBounds(150, 150, 70, 20);
        femaleGenderCheckbox.setBounds(150, 170, 70, 20);
        otherGenderCheckbox.setBounds(150, 190, 70, 20);
        semesterLabel.setBounds(50, 240, 70, 20);
        semesterChoice.setBounds(150, 240, 30, 20);
        for (int i = 1; i <= 8; i++)
            semesterChoice.add(Integer.toString(i));
        submitButton.setBounds(215, 300, 70, 20);
        submitButton.addActionListener(this);
        add(submitButton);
        add(nameLabel);
        add(nameTextField);
        add(ageLabel);
        add(ageTextField);
        add(genderLabel);
        add(maleGenderCheckbox);
        add(femaleGenderCheckbox);
        add(otherGenderCheckbox);
        add(semesterLabel);
        add(semesterChoice);
        add(submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        System.out.println("Name: " + nameTextField.getText());
        System.out.println("Age: " + ageTextField.getText());
        System.out.println("Gender: " + (genderCheckboxGroup.getSelectedCheckbox().getLabel()));
        System.out.println("Semester: " + semesterChoice.getSelectedItem());
    }

    public static void main(String[] args) {
        StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm("Student Registration Form");
        studentRegistrationForm.setupUI();
    }
}