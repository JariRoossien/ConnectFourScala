package nl.jariroossien.cf

import Graphics.button.Button
import scenes.{ GameScene, SelectGameScene}
import processing.core.PApplet
import processing.event.MouseEvent


class ConnectFourGame extends PApplet {

    val WIDTH: Int = 1000
    val HEIGHT: Int = 800

    var oldX: Int = -1
    var oldY: Int = -1

    var paintingCanvas: Array[Array[Boolean]] = Array.fill(HEIGHT)(Array.fill(WIDTH)(false))
    var currentScene: GameScene = new SelectGameScene()
    val imageProvider: ImageProvider = new ImageProvider

    override def draw(): Unit = {
        image(imageProvider.get("background"), 0, 0)
//        fill(0, 0, 0, 255)

        for (graphics <- currentScene.sceneGraphics.filter(_.active)) {
            image(
                graphics.getImage(),
                graphics.x + graphics.drawingOffsetX,
                graphics.y + graphics.drawingOffsetY,
                graphics.width,
                graphics.height
            )
        }

        for (textGraph <- currentScene.textGraphic.filter(_.active)) {
            text(textGraph.content, textGraph.x, textGraph.y)
        }
    }

    override def mouseMoved(event: MouseEvent): Unit = {
        val newX = event.getX
        val newY = event.getY
        if (newX == oldX && newY == newX) return
        for (button <- currentScene.sceneGraphics.filter(a => a.isInstanceOf[Button]).map(_.asInstanceOf[Button])) {
            val oldInField = button.isInField(oldX, oldY)
            val newInField = button.isInField(newX, newY)
            if (oldInField != newInField) {
                if (newInField) {
                    button.onHoverEnter()
                } else {
                    button.onHoverExit()
                }
            }

        }
        oldX = newX
        oldY = newY

    }

    override def mouseClicked(event: MouseEvent): Unit = {
        for (button <- currentScene.sceneGraphics.filter(a => a.isInstanceOf[Button]).map(_.asInstanceOf[Button])) {
            if (button.isInField(event.getX, event.getY)) {
                button.onClick()
                return
            }
        }
    }

    override def setup(): Unit = {
        imageProvider.fillMap(this)
        currentScene.initialize(this)
        textFont(createFont("Arial", 50))
    }

    override def settings(): Unit = {
        size(WIDTH, HEIGHT)

    }
}

object ConnectFourGame {
    def main(args: Array[String]): Unit = {
        PApplet.main("nl.jariroossien.cf.ConnectFourGame")
    }
}
