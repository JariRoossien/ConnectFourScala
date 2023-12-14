package nl.jariroossien.cf.entity

import processing.core.PImage


class BoardPlayer(val name: String, val stone: PImage) {

    def getImage: PImage = {
        stone
    }

}
