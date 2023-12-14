package nl.jariroossien.cf
package Graphics.button

import Graphics.{CFGraphics, Clickable, Hoverable}
import processing.core.PImage

abstract class Button extends CFGraphics() with Clickable with Hoverable {

    def isInField(clickX: Int, clickY: Int): Boolean = {
        clickX >= x &&
            clickX <= x + boxWidth &&
            clickY >= y &&
            clickY <= y + boxHeight
    }
}
