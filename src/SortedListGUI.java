import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SortedListGUI extends JFrame {

    private SortedList sortedList;

    private JTextField txtInput;
    private JTextArea textArea;

    public SortedListGUI() {

        sortedList = new SortedList();

        setTitle("Sorted List");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        txtInput = new JTextField(15);

        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");

        topPanel.add(new JLabel("String:"));
        topPanel.add(txtInput);
        topPanel.add(addButton);
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        addButton.addActionListener(e -> {
            String value = txtInput.getText();

            if (!value.isEmpty()) {
                sortedList.add(value);

                textArea.append("Added: " + value + "\n");
                textArea.append(sortedList.displayList() + "\n");

                txtInput.setText("");
            }
        });

        searchButton.addActionListener(e -> {
            String value = txtInput.getText();

            if (!value.isEmpty()) {
                textArea.append(sortedList.search(value) + "\n\n");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SortedListGUI();
    }
}