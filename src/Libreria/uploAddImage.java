package Libreria;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class uploAddImage extends javax.swing.JFrame {

    private File archivo;
    private JFileChooser abrirArchivo;
    private static String urlOrigen = null;
    private static byte[] imageByte = null;

    public static byte[] getImageByte() {
        return imageByte;
    }

    public void cargarImagen(JLabel label) {
        abrirArchivo = new JFileChooser();
        abrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivos de Imagen", "jpg", "png", "gif"));
        int respuesta = abrirArchivo.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            try {
                archivo = abrirArchivo.getSelectedFile();
                urlOrigen = archivo.getAbsolutePath();
                Image foto = getToolkit().getImage(urlOrigen);
                foto = foto.getScaledInstance(140, 140, 1);
                label.setIcon(new ImageIcon(foto));
                BufferedImage bimage = ImageIO.read(archivo);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(bimage, "png", bos);
                imageByte = bos.toByteArray(); 
            } catch (IOException ex) {
            }
        }
    }
    public byte [] getTransFoto(JLabel label){
        ByteArrayOutputStream baos = null;
        try {
            Icon ico = label.getIcon();
            //Crear un buffered image
            BufferedImage buferredimage = new BufferedImage(ico.getIconWidth(), ico.getIconHeight(),
                    BufferedImage.TYPE_INT_RGB);
            baos = new ByteArrayOutputStream();
            ImageIO.write(buferredimage, "png", baos);
        } catch (IOException e) {
        }
        return baos.toByteArray();
    }
    public void byteImage(JLabel label, byte [] imgFoto){
        try {
            Image foto;
            BufferedImage image;
            ByteArrayInputStream bis = new ByteArrayInputStream(imgFoto);
            image = ImageIO.read(bis);
            foto = new ImageIcon(image).getImage(); 
            foto = foto.getScaledInstance(140, 140, 1);
            label.setIcon(new ImageIcon(foto));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
