package nl.jariroossien.cf
package Graphics.button

import nl.jariroossien.cf.Graphics.{GameOverGraphic, TextGraphic}
import nl.jariroossien.cf.entity.GameInstance
import processing.core.PImage

class BoardPlaceButton(imageProvider: ImageProvider, column: Int, gameInstance: GameInstance, winnerGraphic: TextGraphic, gameoverGraphic: GameOverGraphic) extends Button {

    var hovering: Boolean = false

    override def onClick(): Unit = {
        if (gameInstance.insertPiece(column)) {
            println("Insert succesful.")
            if (gameInstance.board.getWinner != 0) {
                println("GAME OVER")
                winnerGraphic.active = true
                gameoverGraphic.active = true
                if (gameInstance.board.getWinner == 1) {
                    winnerGraphic.content = "Player One won!"
                } else {
                    if (gameInstance.usesAI) {
                        winnerGraphic.content = "AI Won!"
                    } else {
                        winnerGraphic.content = "Player Two won!"
                    }
                }
            }
        }
    }

    override def onHoverEnter(): Unit = hovering = true

    override def onHoverExit(): Unit = hovering = false

    override val x: Int = 150 + 100 * column
    override val y: Int = 0
    override val width: Int = 100
    override val height: Int = 100
    override val boxWidth: Int = 100
    override val boxHeight: Int = 800
    override val drawingOffsetX: Int = 0
    override val drawingOffsetY: Int = 0

    override def getImage(): PImage = {
        if (hovering) {
            if (gameInstance.playerOnePlaying) {
                return gameInstance.playerOne.getImage
            } else {
                return gameInstance.playerTwo.getImage
            }
        }
        imageProvider.get("default")
    }
}
