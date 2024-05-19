import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestApplication2 extends JFrame {
    JTextField resultTextField;

    public TestApplication2() {
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();

        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Вікно виконнання завдання");
        this.setLayout(layout);

        JLabel label1 = new JLabel("Сила (F): ");
        constraints.gridx = 10;
        constraints.gridy = 1;
        this.add(label1, constraints);

        JTextField textField1 = new JTextField(8);
        constraints.gridx = 10;
        constraints.gridy = 0;
        this.add(textField1, constraints);

        JLabel label2 = new JLabel("Відстань (S): ");
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(label2, constraints);

        JTextField textField2 = new JTextField(8);
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(textField2, constraints);

        JButton calculateButton = new JButton("Обрахунок");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double force = Double.parseDouble(textField1.getText());
                double distance = Double.parseDouble(textField2.getText());

                double work = force * distance;
                resultTextField.setText(String.format("%.2f", work));
            }
        });
        constraints.gridx = 1;
        constraints.gridy = 4;
        this.add(calculateButton, constraints);

        this.setVisible(true);

        JLabel resultLabel = new JLabel("Результат: ");
        constraints.gridx = 1;
        constraints.gridy = 8;
        this.add(resultLabel, constraints);

        resultTextField = new JTextField(5);
        constraints.gridx = 1;
        constraints.gridy = 10;
        this.add(resultTextField, constraints);
        resultTextField.setEditable(false);
    }

    public static TestApplication2 createAndShow() {
        TestApplication2 app = new TestApplication2();
        app.setVisible(true);
        return app;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShow();
            }
        });
    }
}







