import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

class newDialog extends JFrame {
    public JTextField newTextName = new JTextField(20);
    public JTextField newTextAuthor = new JTextField(20);
    public JTextField newTextPublisher = new JTextField(20);
    public JTextField newTextISBN = new JTextField(20);

    public JButton confirmButton = new JButton("OK");
    public JButton cancelButton = new JButton("Cancel");

    newDialog() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(300, 300);
        setMinimumSize(this.getSize());
        this.setLayout(new FlowLayout());

        JPanel panelName = new JPanel();
        JLabel l1 = new JLabel("Name:");
        panelName.add(l1);
        panelName.add(newTextName);
        this.add(panelName);

        JPanel panelAuthor = new JPanel();
        JLabel l2 = new JLabel("Author:");
        panelAuthor.add(l2);
        panelAuthor.add(newTextAuthor);
        this.add(panelAuthor);

        JPanel panelPublisher = new JPanel();
        JLabel l3 = new JLabel("Publisher:");
        panelPublisher.add(l3);
        panelPublisher.add(newTextPublisher);
        this.add(panelPublisher);

        JPanel panelISBN = new JPanel();
        JLabel l4 = new JLabel("ISBN:");
        panelISBN.add(l4);
        panelISBN.add(newTextISBN);
        this.add(panelISBN);

        JPanel panelButton = new JPanel();
        panelButton.add(confirmButton);
        panelButton.add(cancelButton);
        this.add(panelButton);

    }
}

public class BookView extends JFrame implements ActionListener {
    private JButton buttonNew = new JButton("New");
    //    private JButton buttonDelete = new JButton("Delete");
    private JTextField textFind = new JTextField(20);
    private JButton buttonFind = new JButton("Find");
    private JList<String> listName = new JList<>();
    private JList<String> listAuthor = new JList<>();
    private JList<String> listPublisher = new JList<>();
    private JList<String> listISBN = new JList<>();
    private newDialog dialog = new newDialog();
    private BookCtrl ctrl = new BookCtrl();

    BookView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setMinimumSize(this.getSize());
        setTitle("BookSystem");

        JPanel toolBar = new JPanel();
        toolBar.add(buttonNew);
//        toolBar.add(buttonDelete);
        toolBar.add(textFind);
        toolBar.add(buttonFind);


        listName.setListData(ctrl.getVectorName());
        listName.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listAuthor.setListData(ctrl.getVectorAuthor());
        listAuthor.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listPublisher.setListData(ctrl.getVectorPublisher());
        listPublisher.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listISBN.setListData(ctrl.getVectorISBN());
        listISBN.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane paneName = new JScrollPane(listName);
        JScrollPane paneAuthor = new JScrollPane(listAuthor);
        JScrollPane panePublisher = new JScrollPane(listPublisher);
        JScrollPane paneISBN = new JScrollPane(listISBN);

        paneName.setBorder(BorderFactory.createTitledBorder("Name"));
        paneAuthor.setBorder(BorderFactory.createTitledBorder("Author"));
        panePublisher.setBorder(BorderFactory.createTitledBorder("Publisher"));
        paneISBN.setBorder(BorderFactory.createTitledBorder("ISBN"));

        this.add(toolBar);
        this.add(paneName);
        this.add(paneAuthor);
        this.add(panePublisher);
        this.add(paneISBN);

        GridBagLayout gridbaglayout = new GridBagLayout();
        this.setLayout(gridbaglayout);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 0;
        constraints.weightx = 1;
        constraints.weighty = 0;
        gridbaglayout.setConstraints(toolBar, constraints);


        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 1;
        constraints.weightx = 0.5;
        constraints.weighty = 1;
        gridbaglayout.setConstraints(paneName, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 1;
        constraints.weightx = 0.5;
        constraints.weighty = 1;
        gridbaglayout.setConstraints(paneAuthor, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 1;
        constraints.weightx = 0.5;
        constraints.weighty = 1;
        gridbaglayout.setConstraints(panePublisher, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 0;
        constraints.weightx = 0.5;
        constraints.weighty = 1;
        gridbaglayout.setConstraints(paneISBN, constraints);

        buttonNew.addActionListener(this);
        buttonFind.addActionListener(this);
        dialog.confirmButton.addActionListener(this);
        dialog.cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNew) {
            dialog.newTextName.setText("");
            dialog.newTextAuthor.setText("");
            dialog.newTextPublisher.setText("");
            dialog.newTextISBN.setText("");
            dialog.setVisible(true);
        } else if (e.getSource() == dialog.confirmButton) {
            ctrl.addItem(dialog.newTextName.getText(), dialog.newTextAuthor.getText(), dialog.newTextPublisher.getText(), dialog.newTextISBN.getText());
            dialog.setVisible(false);
            listName.setListData(ctrl.getVectorName());
            listAuthor.setListData(ctrl.getVectorAuthor());
            listPublisher.setListData(ctrl.getVectorPublisher());
            listISBN.setListData(ctrl.getVectorISBN());
        } else if (e.getSource() == dialog.cancelButton) {
            dialog.setVisible(false);
        }else if (e.getSource() == buttonFind){
            int[] find = ctrl.findItem(textFind.getText());
            listName.setSelectedIndices(find);
            listAuthor.setSelectedIndices(find);
            listPublisher.setSelectedIndices(find);
            listISBN.setSelectedIndices(find);
        }
    }

    public static void main(String[] args) {
        BookView window = new BookView();

        window.setVisible(true);
    }
}
