package nl.jariroossien.cf
package Graphics

import processing.core.PImage

abstract class CFGraphics() {
    val x: Int
    val y: Int
    val width: Int
    val height: Int
    val boxWidth: Int
    val boxHeight: Int
    val drawingOffsetX: Int
    val drawingOffsetY: Int
    var active: Boolean = true
    def getImage(): PImage

    def this(isActive: Boolean) = {
        this()
        this.active = isActive
    }
}
