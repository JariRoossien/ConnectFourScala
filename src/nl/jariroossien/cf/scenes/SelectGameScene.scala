package nl.jariroossien.cf
package scenes
import Graphics.CFGraphics

import nl.jariroossien.cf.Graphics.button.{EasyAIButton, HardAIButton, MedAIButton, StartGame1v1Button}

import scala.collection.mutable.ListBuffer

class SelectGameScene extends GameScene {
    override var sceneGraphics: ListBuffer[CFGraphics] = ListBuffer.empty

    override def initialize(cfGame: ConnectFourGame): Unit = {
        sceneGraphics.append(new StartGame1v1Button(cfGame))
        sceneGraphics.append(new EasyAIButton(cfGame))
        sceneGraphics.append(new MedAIButton(cfGame))
        sceneGraphics.append(new HardAIButton(cfGame))
    }
}
