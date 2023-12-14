package nl.jariroossien.cf
package scenes

import Graphics.{CFGraphics, TextGraphic}

import scala.collection.mutable.ListBuffer

abstract class GameScene {
    var sceneGraphics: ListBuffer[CFGraphics]
    var textGraphic: ListBuffer[TextGraphic] = new ListBuffer[TextGraphic]

    def initialize(cfGame: ConnectFourGame): Unit
}
