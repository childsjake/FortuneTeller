import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Font;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl;
    JPanel iconPnl;
    JPanel displayPnl;
    JPanel controlPnl;

    JLabel titleLbl;
    ImageIcon icon;

    JTextArea displayTA;
    JScrollPane scroller;

    JButton fortuneBtn;
    JButton quitBtn;

    int newFortuneIndex;
    int oldFortuneIndex = 0;

    Random rnd = new Random();
    ArrayList<String> fortuneList;


    public FortuneTellerFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
        setLocation(screenWidth / 8, screenHeight / 8);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        fortuneList = new ArrayList<>();
        fortuneList.add("You will come into a large sum of money.");
        fortuneList.add("You will soon have an unforgettable evening with your spouse.");
        fortuneList.add("Be careful of an accident involving a frog.");
        fortuneList.add("You will have an amorous adventure");
        fortuneList.add("You will soon be making a new friend.");
        fortuneList.add("Be careful of a conflict with your boss.");
        fortuneList.add("You need to finish the task you have been putting aside.");
        fortuneList.add("You have good health and lots of vitality.");
        fortuneList.add("Your ambition outstrips your abilities.");
        fortuneList.add("Your imagination will play nasty tricks on you.");
        fortuneList.add("You will travel to far off destinations.");
        fortuneList.add("Be careful of those who misunderstand your playful nature.");
    }

    private void createIconPanel()
    {
        iconPnl = new JPanel();
        icon = new ImageIcon("src/crystalball.png");
        titleLbl = new JLabel("Fortune Teller", icon,  JLabel.CENTER);
        iconPnl.add(titleLbl);
        titleLbl.setFont(new Font("Verdana", Font.BOLD, 48));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
    }

    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayTA = new JTextArea(15,45);
        displayTA.setEditable(false);
        displayTA.setFont(new Font("Helvetica", Font.PLAIN, 30));
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);

    }

    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1,2));
        fortuneBtn = new JButton("Read My Fortune");
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
            String fortune = getRandomFortune();
            displayTA.append(fortune +"\n");

        });
        fortuneBtn.setFont(new Font("Arial", Font.PLAIN, 20));

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitBtn.setFont(new Font("Arial", Font.PLAIN, 20));

        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);

    }

    private String getRandomFortune()
    {
        newFortuneIndex = oldFortuneIndex;
        while (newFortuneIndex == oldFortuneIndex)
        {
            newFortuneIndex = rnd.nextInt(fortuneList.size());
        }
        oldFortuneIndex = newFortuneIndex;
        return fortuneList.get(newFortuneIndex);
    }


}
