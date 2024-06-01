package org.graphics;

import java.util.Random;
import java.awt.Font;
import javax.swing.JOptionPane;
import com.jogamp.opengl.util.awt.TextRenderer;
import java.awt.Color;
import org.resource.ImageResource;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Eventlistener implements GLEventListener {
	
	
    public static GL2 gl =null;
    public static float xPaper = 0, yPaper = 2;
    public static float xTrash = -2F, yTrash = -2F;
    public static float unitstall=0;
    public static ImageResource image;
    private int score = 0;
    private float paperRotation = 0.0f; 
    private TextRenderer textRenderer; 
    private Random random = new Random(); 
    
    private boolean checkCollision(float x1, float y1, float w1, float h1, float x2, float y2, float w2, float h2) {
        return x1 < (x2 + w2) && (x1 + w1) > x2 && y1 < (y2 + h2) && y1 + h1 > y2;
    }
    
    
    
    
    
    public void display(GLAutoDrawable drawable) {
    	
        
        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        
        image = new ImageResource("/res/bg.jpg");
        Graphics.SetColors(1, 1, 1, 0.5f);
        Graphics.DrawImage(image, 0, 0, Render.UnitWide, unitstall);

       
        image = new ImageResource("/res/trash.png");
        Graphics.SetColors(1, 1, 1, 0.5f);
        Graphics.DrawImage(image, xTrash, yTrash, Render.UnitWide / 8, unitstall / 8);

        
        
        
        image = new ImageResource("/res/paper.png");
        
        Graphics.SetRotation(paperRotation); 
        
        Graphics.DrawImageAsCircle(image, xPaper, yPaper,  1.5f);
        
        Graphics.SetRotation(0); 
        
        paperRotation += 50.0f; 
        
        
        if ((yPaper - (unitstall / 18.5f) / 2) < unitstall / 2) {
            yPaper -= .3;
        } 
        
        
        

        
        if (checkCollision(xPaper, yPaper, Render.UnitWide / 18.5f, unitstall / 18.5f, xTrash, yTrash, Render.UnitWide / 8,
                unitstall / 8)) {
            
            score += 10;
            // Reset paper position
            xPaper = (float) (random.nextDouble() * (Render.UnitWide - Render.UnitWide / 18.5f) - Render.UnitWide / 2);
            yPaper = unitstall / 2;
        }

        
        textRenderer.beginRendering(drawable.getSurfaceWidth(), drawable.getSurfaceHeight());
        textRenderer.draw("Score: " + score, 10, drawable.getSurfaceHeight() - 30);
        textRenderer.endRendering();

        // Check if paper falls beyond the trash
        if (yPaper < yTrash - unitstall / 8) {
        	
        	   
          
        	JOptionPane.showMessageDialog(null, "Game Over! Your Score is: " + score);
        	
          
        	Render.window.destroy();
            System.exit(0);
            
      }

    }

    
        	
    

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub

    }

    @Override
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glEnable(GL2.GL_TEXTURE_2D);

        // Initialize the text renderer
        textRenderer = new TextRenderer(new Font("Arial", Font.PLAIN, 20), true, true);
        textRenderer.setColor(Color.WHITE);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int arg1, int arg2, int arg3, int arg4) {
        gl=drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        unitstall=Render.getWindowHeight()/(Render.getWindowWidth()/Render.UnitWide);
        gl.glOrtho(-Render.UnitWide/2, Render.UnitWide/2, -unitstall/2, unitstall/2, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);

    }

}