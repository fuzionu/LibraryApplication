package books;

import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame
{
    public ApplicationFrame()
    {
        super("Library Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(50, 50);
        setSize(800, 600);
        setVisible(true);
        setLayout(new BorderLayout());

        add(createButtonsPanel(), BorderLayout.SOUTH);
    }

    private JPanel createButtonsPanel()
    {
        JPanel panel = new JPanel();

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton changeButton = new JButton("Change");
        JButton findButton = new JButton("Find");

        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(changeButton);
        panel.add(findButton);
        return panel;
    }
}
