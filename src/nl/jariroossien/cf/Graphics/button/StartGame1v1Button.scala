package nl.jariroossien.cf
package Graphics.button
import nl.jariroossien.cf.entity.GameInstance
import nl.jariroossien.cf.scenes.BoardGameScene
import processing.core.PImage

class StartGame1v1Button(connectFourGame: ConnectFourGame) extends Button {
    override def onHoverEnter(): Unit = {}

    override def onHoverExit(): Unit = {}

    override def onClick(): Unit = {
        connectFourGame.currentScene = new BoardGameScene(new GameInstance(connectFourGame, false, 6))
        connectFourGame.currentScene.initialize(connectFourGame)
    }

    override val x: Int = 50
    override val y: Int = 100
    override val width: Int = 400
    override val height: Int = 600
    override val boxWidth: Int = 400
    override val boxHeight: Int = 600
    override val drawingOffsetX: Int = 0
    override val drawingOffsetY: Int = 0

    override def getImage(): PImage = connectFourGame.imageProvider.get("1v1button")
}
