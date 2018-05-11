import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Window  extends JFrame{
    private JButton openPictureButton;
    private JButton closeButton;
    private PicturePanel picturePanel;



    public Window(String windowName){
        super(windowName);
        JPanel panelButton = new JPanel();
        picturePanel = new PicturePanel();

        Box box = Box.createVerticalBox();
        box.add(panelButton);
        panelButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        box.add(picturePanel);
        picturePanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        //setBounds(x0, y0, xv, yv);
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelButton.setLayout(new FlowLayout());
        closeButton = new JButton("close");
        openPictureButton = new JButton("Open a Picture");
        panelButton.add(openPictureButton);
        panelButton.add(closeButton);

        openPictureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null,"open the file");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileopen.getSelectedFile();
                    Window.this.getPicturePanel().setImageFile(file);
                    //Image image = new ImageIcon(file).getImage()

                }

            }
        });
        closeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setContentPane(box);

    }
    PicturePanel getPicturePanel(){
        return picturePanel;
    }
}
