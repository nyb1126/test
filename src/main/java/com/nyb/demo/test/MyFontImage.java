package com.nyb.demo.test;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 11:19 2020/6/2
 * @Modified By:
 */
public class MyFontImage {

    public static void createFongImg(String string,String inputPath,String outPath){
        String base = string;
        try{
            BufferedImage image = ImageIO.read(new File(inputPath));
            BufferedImage newImage = new BufferedImage(image.getWidth(),image.getHeight(),image.getType());
            Graphics2D graphics2D = (Graphics2D) newImage.getGraphics();
            graphics2D.setFont(new Font("宋体",Font.BOLD,12));
            int index = 0;
            for(int y = 0; y < image.getHeight(); y += 12){
                for (int x = 0; x < image.getWidth(); x += 12){
                    int pxcolor = image.getRGB(x,y);
                    int r = (pxcolor & 0xff0000) >> 16,
                            g = (pxcolor & 0xff00) >> 8,
                            b = pxcolor & 0xff;
                    graphics2D.setColor(new Color(r, g, b));
                    graphics2D.drawString(String.valueOf(base.charAt(index % base.length())), x, y);
                    index++;
                }
            }
            ImageIO.write(newImage, "JPG", new FileOutputStream(outPath));
        }catch (Exception e){
            e.printStackTrace();
        }
    };
    public static void main(String args[]){
        String string = "我爱你";
        String inputPath = "C:\\Users\\nyb\\Desktop\\新建文件夹\\请坐.jpg";
        String outPath = "C:\\Users\\nyb\\Desktop\\新建文件夹\\temp.jpg";
        MyFontImage.createFongImg(string,inputPath,outPath);
        System.out.println("OK");
    }
}
