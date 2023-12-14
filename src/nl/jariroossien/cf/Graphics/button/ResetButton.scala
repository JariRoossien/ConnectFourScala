package nl.jariroossien.cf
package Graphics.button

import nl.jariroossien.cf.scenes.SelectGameScene
import processing.core.{PApplet, PImage}


case class ResetButton(localImage: PImage, hoverImage: PImage, pApplet: ConnectFourGame) extends Button {
    override val x: Int = 0
    override val y: Int = 0
    override val width: Int = 50
    override val height: Int = 50
    override val boxWidth: Int = 50
    override val boxHeight: Int = 50
    override val drawingOffsetX: Int = 0
    override val drawingOffsetY: Int = 0

    var isHovering = false

    override def getImage(): PImage = {
        if (isHovering) hoverImage else localImage
    }

    override def onClick(): Unit = {
        pApplet.paintingCanvas = Array.fill(pApplet.HEIGHT)(Array.fill(pApplet.WIDTH)(false))
//        pApplet.board.resetBoard()
//        pApplet.board.opponent = false
        pApplet.currentScene = new SelectGameScene
        pApplet.currentScene.initialize(pApplet)
    }

    override def onHoverEnter(): Unit = isHovering = true

    override def onHoverExit(): Unit = isHovering = false

}
