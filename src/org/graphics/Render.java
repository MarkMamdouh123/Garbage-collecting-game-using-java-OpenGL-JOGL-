package org.graphics;

import org.input.keyinput;
import org.input.mouseinput;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Render {
    public static GLWindow window=null;
    public static int width =640;
    public static int height =360;
    public static int UnitWide =10;
    private static GLProfile profile;
    public static void  init() {
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps =new GLCapabilities(profile);
        window=GLWindow.create(caps);
        window.setVisible(true);
        window.setResizable(true);
        window.setSize(width, height);
        window.addGLEventListener(new Eventlistener());
        window.addKeyListener(new keyinput());
        window.setTitle("Garbage Collector");

        FPSAnimator animator=new FPSAnimator(window,60);
        animator.start();



    }
    public static void main(String[] args) {
    	 
    
        init();
     
        
    }
    
  

    public static int getWindowWidth() {
        return window.getWidth();
    }
    public static int getWindowHeight() {
        return window.getHeight();
    }
    public static GLProfile getProfile() {
        return profile;
    }

}