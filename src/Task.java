import javax.swing.*;
import java.awt.*;

public class Task extends JPanel {
    private JLabel index;
    private JTextField taskName;
    private JButton done;
    private boolean checked;
    Task(){
        this.setPreferredSize(new Dimension(40, 300));
        this.setLayout(new BorderLayout());
        checked=false;
        index= new JLabel("");
        index.setPreferredSize(new Dimension(20, 20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index, BorderLayout.WEST);

        taskName=new JTextField("Your task here");
        taskName.setBorder(BorderFactory.createEmptyBorder());
        this.add(taskName, BorderLayout.CENTER);

        done = new JButton("done");
        done.setPreferredSize(new Dimension(40, 20));
        done.setBorder(BorderFactory.createEmptyBorder());

        this.add(done, BorderLayout.EAST);

    }
    public void changeIndex(int number){
        this.index.setText(number+"");
        this.revalidate();
    }
    public JButton getDone(){
        return done;
    }
    public void changeState(){
        this.setBackground(Color.green);
        taskName.setBackground(Color.green);
        checked=true;
    }
}
