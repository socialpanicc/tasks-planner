import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppFrame extends JFrame {
    private TitleBar title;
    private ButtonPanel btnPanel;
    private JButton addTask;
    private JButton clear;
    private List list;
    public AppFrame(){
        this.setSize(400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        title = new TitleBar();
        btnPanel = new ButtonPanel();
        list = new List();
        this.add(title, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.SOUTH);
        this.add(list, BorderLayout.CENTER);

        addTask = btnPanel.getAddTask();
        clear=btnPanel.getClear();

        addListeners();


    }
    public void addListeners(){
        addTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Task task = new Task();
               list.add(task);
               list.updateNumbers();

               task.getDone().addMouseListener(new MouseAdapter() {
                   @Override
                   public void mouseClicked(MouseEvent e) {
                       task.changeState();
                       revalidate();
                   }
               });
               revalidate();
            }
        });
    }
}
