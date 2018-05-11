import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PicturePanel extends javax.swing.JPanel{
    private JPanel panelPictute;
    private BufferedImage originalImage = null;
    private Image image = null;
    // private BufferedImage image = null;

    public PicturePanel(){
        panelPictute = new JPanel();
        panelPictute.add(new JButton("pppp"));
    }

    public Image getImage(){
        return this.image;
    }

    public void paint(Graphics g) {
        //Image image = new ImageIcon("q2.jpg").getImage();
        g.drawImage(image,2,3,null);
    }

    public void setImage(BufferedImage image){
        this.originalImage = image;
        resize();
    }

    private void resize(){
        int w = this.getWidth();
        int h = this.getHeight();
        if((originalImage != null) && (w > 0) && (h > 0)){
            image = originalImage.getScaledInstance(w ,h , Image.SCALE_DEFAULT);
            this.repaint();
        }

    }

    public void setImageFile(File file){
        if(file == null) {
            originalImage = null;
        } else {
            try {
                 originalImage = ImageIO.read(file);
            } catch (IOException ee){
                System.out.print("Do not download pictore");
                ee.printStackTrace();
            }
            resize();
            repaint();
        }
    }
}
