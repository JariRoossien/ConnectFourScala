package nl.jariroossien.cf
package scenes

import Graphics.button.{BoardPlaceButton, ResetButton}
import Graphics.{CFBoardGraphic, CFBoardStoneGraphic, CFGraphics, GameOverGraphic, TextGraphic}
import nl.jariroossien.cf.entity.GameInstance

import scala.collection.mutable.ListBuffer

class BoardGameScene(instance: GameInstance) extends GameScene {

    override var sceneGraphics: ListBuffer[CFGraphics] = ListBuffer.empty

    override def initialize(cfGame: ConnectFourGame): Unit = {
        val winnerGraphic = new TextGraphic("", false)
        val gameOverGraphic = new GameOverGraphic(
            cfGame.imageProvider.get("gameover")
        )
        textGraphic.append(winnerGraphic)
        for (i <- 0 until 7) {
            sceneGraphics.append(
                new BoardPlaceButton(
                    cfGame.imageProvider,
                    i,
                    instance,
                    winnerGraphic,
                    gameOverGraphic
                )
            )
        }

        for (x <- 0 until 7)
            for (y <- 0 until 6) {
                sceneGraphics.append(
                    new CFBoardStoneGraphic(
                        x,
                        y,
                        instance.board,
                        cfGame.imageProvider
                    )
                )
            }
        sceneGraphics.append(
            ResetButton(
                cfGame.imageProvider.get("reset_button"),
                cfGame.imageProvider.get("reset_button_hover"),
                cfGame)
        )
        sceneGraphics.append(
            CFBoardGraphic(
                cfGame.imageProvider.get("cfboard")
            )
        )
        sceneGraphics.append(
            gameOverGraphic
        )
    }

}
