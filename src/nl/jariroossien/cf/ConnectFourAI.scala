package nl.jariroossien.cf

import nl.jariroossien.cf.entity.CFBoard

class ConnectFourAI {

    val MAX_DEPTH = 6

    def nextMove(board: CFBoard, depth: Int): Int = {
        val finalDepth = Math.min(depth, MAX_DEPTH)
        var bestScore: Int = Int.MinValue
        var bestMove: Int = -1
        for (i <- 0 until board.WIDTH) {
            val tempBoard = board.clone()
            if (tempBoard.insertPiece(-1, i)) {
                val miniScore = miniMax(tempBoard, finalDepth, 1, Integer.MIN_VALUE, Integer.MAX_VALUE)
                if (bestScore < miniScore) {
                    bestScore = miniScore
                    bestMove = i
                }
            }
        }

        bestMove
    }

    def miniMax(board: CFBoard, depth: Int, player: Int, alpha: Int, beta: Int): Int = {
        var localAlpha = alpha
        var localBeta = beta

        if (depth == 0) return getBoardScore(board)
        if (board.getWinner != 0) return (board.getWinner * -100000) + depth
        // If player is AI, choose the option that gives the highest score.
        var bestScore = 0
        if (player == -1) {
            bestScore = Integer.MIN_VALUE
            for (i <- 0 until board.WIDTH) {
                if (localBeta > localAlpha) {
                    val temp = board.clone()
                    if (temp.insertPiece(-1, i)) {
                        val miniMaxScore = miniMax(temp, depth - 1, player * -1, alpha, beta)
                        bestScore = Math.max(miniMaxScore, bestScore)
                        localAlpha = Math.max(bestScore, localAlpha)
                    }
                }
            }
            // Otherwise, the player would choose the score that gives the lowest points.
        }
        else {
            bestScore = Integer.MAX_VALUE
            for (i <- 0 until board.WIDTH) {
                if (localBeta > localAlpha) {
                    val temp = board.clone
                    if (temp.insertPiece(1, i)) {
                        val miniMaxScore = miniMax(temp, depth - 1, player * -1, alpha, beta)
                        bestScore = Math.min(miniMaxScore, bestScore)
                        localBeta = Math.min(bestScore, localBeta)
                    }
                }
            }
        }
        bestScore
    }

    def getBoardScore(board: CFBoard): Int = {
        var heur = 0
        val field = board.board
        for (y <- 0 until board.HEIGHT) {
            for (x <- 0 until board.WIDTH) {
                heur += getHeuristicFor(field, -1, x, y)
                heur -= getHeuristicFor(field, 1, x, y)
            }
        }
        heur
    }

    private def getHeuristicFor(field: Array[Array[Int]], player: Int, x: Int, y: Int) = {
        var heur = 0
        try {
            if (field(y)(x) == field(y)(x + 1) && field(y)(x) == player) heur += 10
            if (field(y)(x) == field(y)(x + 1) && field(y)(x) == field(y)(x + 2) && field(y)(x) == player) heur += 100
            if (field(y)(x) == field(y)(x + 1) && field(y)(x) == field(y)(x + 2) && field(y)(x) == field(y)(x + 3) && field(y)(x) == player) heur += 10000
        } catch {
            case ignored: Exception =>

        }
        try {
            if (field(y)(x) == field(y + 1)(x) && field(y)(x) == player) heur += 10
            if (field(y)(x) == field(y + 1)(x) && field(y)(x) == field(y + 2)(x) && field(y)(x) == player) heur += 100
            if (field(y)(x) == field(y + 1)(x) && field(y)(x) == field(y + 2)(x) && field(y)(x) == field(y + 3)(x) && field(y)(x) == player) heur += 10000
        } catch {
            case ignored: Exception =>

        }
        try {
            if (field(y)(x) == field(y + 1)(x + 1) && field(y)(x) == player) heur += 10
            if (field(y)(x) == field(y + 1)(x + 1) && field(y)(x) == field(y + 2)(x + 2) && field(y)(x) == player) heur += 100
            if (field(y)(x) == field(y + 1)(x + 1) && field(y)(x) == field(y + 2)(x + 2) && field(y)(x) == field(y + 3)(x + 3) && field(y)(x) == player) heur += 10000
        } catch {
            case ignored: Exception =>

        }
        try {
            if (field(y)(x) == field(y + 1)(x + 1) && field(y)(x) == player) heur += 10
            if (field(y)(x) == field(y - 1)(x + 1) && field(y)(x) == field(y - 2)(x + 2) && field(y)(x) == player) heur += 100
            if (field(y)(x) == field(y - 1)(x + 1) && field(y)(x) == field(y - 2)(x + 2) && field(y)(x) == field(y - 3)(x + 3) && field(y)(x) == player) heur += 10000
        } catch {
            case ignored: Exception =>

        }
        heur
    }


}
