package org.input;

import org.graphics.Eventlistener;
import org.graphics.Render;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class keyinput implements KeyListener {
  
  @Override
  public void keyPressed(KeyEvent e) {
    
    
 
      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        if (Eventlistener.xTrash + .5 <= (Render.UnitWide / 2) - 0.000002) {
          Eventlistener.xTrash += .1;

        }
      }
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        if (Eventlistener.xTrash - .5 >= -((Render.UnitWide / 2) - 0.000002) ) {
          Eventlistener.xTrash -= .1;

        }
      }

    
    
    
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }

}