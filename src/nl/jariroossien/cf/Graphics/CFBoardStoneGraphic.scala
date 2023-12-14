package nl.jariroossien.cf
package Graphics

import nl.jariroossien.cf.entity.CFBoard
import processing.core.PImage

class CFBoardStoneGraphic(row: Int, col: Int, board: CFBoard, imageProvider: ImageProvider) extends CFGraphics {

    override val x: Int = 150 + 100 *row
    override val y: Int = 110 + 100 * col
    override val width: Int = 100
    override val height: Int = 100
    override val boxWidth: Int = 100
    override val boxHeight: Int = 100
    override val drawingOffsetX: Int = 0
    override val drawingOffsetY: Int = 0

    override def getImage(): PImage = {
        val stoneValue = board.board(row)(col)
        stoneValue match {
            case 1 => imageProvider.get("red_stone")
            case -1 => imageProvider.get("yellow_stone")
            case _ => imageProvider.empty
        }
    }
}
