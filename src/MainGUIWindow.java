import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainGUIWindow extends JFrame implements ActionListener, KeyListener {
    private JPanel panel;
    private JTextField percentText;
    private JButton tipIncrease;
    private JButton tipDecrease;
    private JTextField billText;
    private JTextField peopleText;
    private JTextArea total;
    private JButton calculateButton;
    private JLabel billLabel;
    private JLabel percentLabel;
    private JLabel peopleLabel;
    private JButton peopleDecrease;
    private JButton peopleIncrease;

    public MainGUIWindow() {
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(panel);
        setTitle("Tip Calculator");
        setSize(300,400);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        percentText.setText("0");
        billText.setText("0");
        peopleText.setText("0");
        tipIncrease.addActionListener(this);
        tipDecrease.addActionListener(this);
        peopleIncrease.addActionListener(this);
        peopleDecrease.addActionListener(this);
        calculateButton.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button.equals(tipIncrease)) {
            int percent = Integer.parseInt(percentText.getText());
            percentText.setText(percent + 1 + "");
        } else if (button.equals(tipDecrease)) {
            int percent = Integer.parseInt(percentText.getText());
            percentText.setText(percent - 1 + "");
        } else if (button.equals(peopleIncrease)) {
            int ppl = Integer.parseInt(peopleText.getText());
            peopleText.setText(ppl + 1 + "");
        } else if (button.equals(peopleDecrease)) {
            int ppl = Integer.parseInt(peopleText.getText());
            peopleText.setText(ppl - 1 + "");
        } else if (button.equals(calculateButton)) {
            int percent = Integer.parseInt(percentText.getText());
            int ppl = Integer.parseInt(peopleText.getText());
            double bill = Double.parseDouble(billText.getText());
            TipCalculator newBill = new TipCalculator(bill, percent, ppl);
            total.setText("Total: $" + newBill.totalBill() + "\nTotal per Person: $" + newBill.totalPerPerson());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
