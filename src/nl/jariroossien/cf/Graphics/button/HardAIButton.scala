package nl.jariroossien.cf
package Graphics.button

import nl.jariroossien.cf.entity.GameInstance
import scenes.BoardGameScene
import processing.core.PImage

class HardAIButton(connectFourGame: ConnectFourGame) extends Button {

    override def onHoverEnter(): Unit = {}

    override def onHoverExit(): Unit = {}

    override def onClick(): Unit = {
        connectFourGame.currentScene = new BoardGameScene(new GameInstance(connectFourGame, true, 6))
        connectFourGame.currentScene.initialize(connectFourGame)

    }

    override val x: Int = 500
    override val y: Int = 520
    override val width: Int = 400
    override val height: Int = 180
    override val boxWidth: Int = 400
    override val boxHeight: Int = 180
    override val drawingOffsetX: Int = 0
    override val drawingOffsetY: Int = 0

    override def getImage(): PImage = connectFourGame.imageProvider.get("hardAIButton")
}
