package nl.jariroossien.cf
package Graphics

import processing.core.{PApplet, PImage}

case class CFBoardGraphic(pImage: PImage) extends CFGraphics {
    override val x: Int = 100
    override val y: Int = 100
    override val width: Int = 800
    override val height: Int = 700
    override val boxWidth: Int = width
    override val boxHeight: Int = height
    override val drawingOffsetX: Int = 0
    override val drawingOffsetY: Int = 0

    override def getImage(): PImage = pImage
}
