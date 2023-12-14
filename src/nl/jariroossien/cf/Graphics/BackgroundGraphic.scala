package nl.jariroossien.cf
package Graphics
import processing.core.PImage

class BackgroundGraphic(image: PImage) extends CFGraphics {
    override val x: Int = 0
    override val y: Int = 0
    override val width: Int = 1000
    override val height: Int = 800
    override val boxWidth: Int = 1000
    override val boxHeight: Int = 800
    override val drawingOffsetX: Int = 0
    override val drawingOffsetY: Int = 0

    override def getImage(): PImage = image
}
