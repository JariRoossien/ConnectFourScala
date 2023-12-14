package nl.jariroossien.cf.entity

import nl.jariroossien.cf.{ConnectFourAI, ConnectFourGame}

class GameInstance(cfGame: ConnectFourGame, val usesAI: Boolean, difficulty: Int) {

    val playerOne: BoardPlayer = new BoardPlayer("Player One", cfGame.imageProvider.get("red_stone"))
    val playerTwo: BoardPlayer = new BoardPlayer(
        if (usesAI) "AI" else "Player Two",
        cfGame.imageProvider.get("yellow_stone")
    )

    val board: CFBoard = new CFBoard()

    var playerOnePlaying = true

    def insertPiece(column: Int): Boolean = {
        if (playerOnePlaying) {
            if (!board.insertPiece(1, column)) return false
            if (usesAI) {
                val aiChoice = new ConnectFourAI().nextMove(board, difficulty)
                board.insertPiece(-1, aiChoice)
                return true
            }
            playerOnePlaying = false
            return true
        } else {
            if (!board.insertPiece(-1, column)) return false
            playerOnePlaying = true
            return true
        }
        false
    }
}
