package nl.jariroossien.cf

import processing.core.PImage

import scala.collection.mutable

class ImageProvider {

    var imageMap: mutable.Map[String, PImage] = mutable.Map.empty

    def fillMap(connectFourGame: ConnectFourGame): Unit = {
        imageMap("red_stone") = connectFourGame.loadImage("images\\RedStone.png")
        imageMap("yellow_stone") = connectFourGame.loadImage("images\\YellowStone.png")
        imageMap("cfboard") = connectFourGame.loadImage("images\\CFBoard.png")
        imageMap("reset_button_hover") = connectFourGame.loadImage("images\\ResetHover.png")
        imageMap("reset_button") = connectFourGame.loadImage("images\\Reset.png")
        imageMap("background") = connectFourGame.loadImage("images\\Background.png")
        imageMap("1v1button") = connectFourGame.loadImage("images\\Start1v1.png")
        imageMap("easyAIButton") = connectFourGame.loadImage("images\\EasyAI.png")
        imageMap("medAIButton") = connectFourGame.loadImage("images\\MedAI.png")
        imageMap("hardAIButton") = connectFourGame.loadImage("images\\HardAI.png")
        imageMap("gameover") = connectFourGame.loadImage("images\\GameOverScreen.png")
        imageMap("default") = connectFourGame.loadImage("images\\Empty.png")
    }

    def get(key: String): PImage = {
        if (imageMap.contains(key))
            imageMap(key)
        else
            imageMap("default")
    }

    def empty: PImage = imageMap("default")
}
