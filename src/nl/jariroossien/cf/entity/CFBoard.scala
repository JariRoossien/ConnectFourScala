package nl.jariroossien.cf.entity

class CFBoard {

    val HEIGHT: Int = 6
    val WIDTH: Int = 7
    var board: Array[Array[Int]] = Array.fill(WIDTH)(Array.fill(HEIGHT)(0))

    var opponent: Boolean = false

    def insertPiece(value: Int, column: Int): Boolean = {
        if (column < 0 || column >= board.length) return false
        if (getWinner != 0) return false
        val columnData = board(column)
        if (columnData(0) != 0) return false

        for (i <- columnData.length - 1 to 0 by -1) {
            if (columnData(i) == 0) {
                if (opponent) {
                    columnData(i) = -value
                } else
                    columnData(i) = value
                return true
            }
        }
        true
    }

    def getWinner: Int = {

        // Horizontal win check.
        for (y <- 0 until HEIGHT) {
            for (x <- 0 to WIDTH - 4) {
                val sum = board(x)(y) + board(x+1)(y) + board(x+2)(y) + board(x+3)(y)
                if (Math.abs(sum) == 4) return sum / 4
            }
        }

        for (y <- 0 to HEIGHT - 4) {
            for (x <- 0 until WIDTH) {
                val sum = board(x)(y) + board(x)(y + 1) + board(x)(y + 2) + board(x)(y + 3)
                if (Math.abs(sum) == 4) return sum / 4
            }
        }
        for (y <- 0 to HEIGHT - 4) {
            for (x <- 0 to WIDTH - 4) {
                var sum = board(x)(y) + board(x + 1)(y + 1) + board(x + 2)(y + 2) + board(x + 3)(y + 3)
                if (Math.abs(sum) == 4) return sum / 4
                sum = board(x + 3)(y) + board(x + 2)(y + 1) + board(x + 1)(y + 2) + board(x)(y + 3)
                if (Math.abs(sum) == 4) return sum / 4
            }
        }

        0
    }

    def resetBoard(): Unit = {
        board = Array.fill(WIDTH)(Array.fill(HEIGHT)(0))
        opponent = false
    }

    override def clone(): CFBoard = {
        val newBoard = new CFBoard()
        newBoard.opponent = opponent
        for (y <- 0 until HEIGHT) {
            for (x <- 0 until WIDTH) {
                newBoard.board(x)(y) = board(x)(y)
            }
        }
        newBoard
    }
}
