package day2

import readInput

const val wonScore = 6
const val drawScore = 3

enum class Move(val letter: String, val score: Int) {
    Rock("A", 1),
    Paper("B", 2),
    Scissors("C", 3),

}

enum class MyMove(val letter: String, val score: Int) {
    MyRock("X", 1),
    MyPaper("Y", 2),
    MyScissors("Z", 3)
}

fun String.toMove(): Move {
    return Move.values().first { it.letter == this }
}

fun String.toMyMove(): MyMove {
    return MyMove.values().first { it.letter == this }
}

fun main() {
    val winPairs = listOf(
        Move.Rock to MyMove.MyPaper,
        Move.Paper to MyMove.MyScissors,
        Move.Scissors to MyMove.MyRock
    )

    fun totalScore(input: List<String>): Int {
        return input.sumOf {
            val game = it.split(" ")
            val pair = game.first().toMove() to game.last().toMyMove()
            pair.second.score + if (winPairs.contains(pair)) {
                wonScore
            } else if (pair.first.score == pair.second.score) {
                drawScore
            } else {
                0
            }
        }
    }

    fun part1(input: List<String>): Int {
        return totalScore(input = input)
    }

    fun part2(input: List<String>): Int {
        return totalScore(input = input)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(day = 2, name = "Day02_test")
    check(part1(testInput) == 19)

    val input = readInput(day = 2, name = "Day02")
    println(part1(input))
}
