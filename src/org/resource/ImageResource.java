package org.resource;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.graphics.Render;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;


public class ImageResource {

    
    private Texture texture =null;

    
    private BufferedImage image=null;


    public ImageResource(String path ) {
        URL url=ImageResource.class.getResource(path);


        try {
            image=ImageIO.read(url);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(image!=null) {
            image.flush();
        }
    }

    public Texture GetTexture() {

        if(image==null) {
            return null;
        }
        if(texture==null) {
            texture=AWTTextureIO.newTexture(Render.getProfile(), image, true);
        }
        return texture;
    }
}