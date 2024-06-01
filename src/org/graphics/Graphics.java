package org.graphics;

import org.resource.ImageResource;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public class Graphics {


    public static float red =1;
    public static float green =1;
    public static float blue =1;
    public static float alpha =1;
    public static float rotation=0;


    public static void DrawImage (ImageResource image,float x,float y,float width,float height) {
        GL2 gl= Eventlistener.gl;

        Texture tex=image.GetTexture();
        if(tex!=null) {
            gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
        }
        gl.glTranslatef(x, y, 0);
        gl.glRotatef(rotation, 0, 0, 1);
        gl.glColor4f(red, green, blue,alpha);


        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0, 1);
        gl.glVertex2f(-width/2,-height/2);
        gl.glTexCoord2f(1, 1);
        gl.glVertex2f(width/2,  -height/2);
        gl.glTexCoord2f(1, 0);
        gl.glVertex2f(width/2, height/2);
        gl.glTexCoord2f(0, 0);
        gl.glVertex2f(-width/2, height/2);
        gl.glEnd();
        gl.glFlush();

        gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);

        gl.glRotatef(-rotation, 0, 0, 1);
        gl.glTranslatef(-x, -y, 0);

    }

    public static void DrawImageAsCircle(ImageResource image, float x, float y, float diameter) {
        GL2 gl = Eventlistener.gl;

        Texture tex = image.GetTexture();
        if (tex != null) {
            gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
        }

        gl.glTranslatef(x, y, 0);
        gl.glRotatef(rotation, 0, 0, 1);
        gl.glColor4f(red, green, blue, alpha);

        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        gl.glTexCoord2f(0.5f, 0.5f); // Center of the texture
        gl.glVertex2f(0, 0); // Center of the circle

        int numSegments = 10; // Increase for smoother circle, decrease for performance
        
     // Modify the diameter to make the circle smaller
        float smallerDiameter = diameter * 0.3f; // Adjust the scaling factor  as needed
        // Draw the circle with the smaller diameter
        for (int i = 0; i <= numSegments; i++) {
            double angle = 2.0 * Math.PI * i / numSegments;
            double xCoord = Math.cos(angle) * smallerDiameter / 2;
            double yCoord = Math.sin(angle) * smallerDiameter / 2;
            gl.glTexCoord2f((float) (Math.cos(angle) * 0.5f + 0.5f), (float) (Math.sin(angle) * 0.5f + 0.5f));
            gl.glVertex2d(xCoord, yCoord);
        }
        gl.glEnd();

        gl.glFlush();
        gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);

        gl.glRotatef(-rotation, 0, 0, 1);
        gl.glTranslatef(-x, -y, 0);
    }



    public static void SetColors(float r ,float g,float b,float a) {
        red=Math.max(0, Math.min(1, r));
        green=Math.max(0, Math.min(1, g));;
        blue=Math.max(0, Math.min(1, b));;
        alpha=Math.max(0, Math.min(1, a));;
    }
    public static void SetRotation(float r) {
        rotation=r;
    }


}