package nl.jariroossien.cf
package Graphics
import processing.core.PImage

class GameOverGraphic(val image: PImage) extends CFGraphics {
    override val x: Int = 300
    override val y: Int = 200
    override val width: Int = 400
    override val height: Int = 300
    override val boxWidth: Int = width
    override val boxHeight: Int = height
    override val drawingOffsetX: Int = 0
    override val drawingOffsetY: Int = 0

    override def getImage(): PImage = image

    active = false
}
