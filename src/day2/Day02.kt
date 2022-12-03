package day2

import readInput
import java.lang.IllegalArgumentException

const val wonScore = 6
const val drawScore = 3

enum class Move(val score: Int) {
    Rock(1),
    Paper(2),
    Scissors(3)
}

data class Play(
    val letter: String,
    val move: Move
)

fun main() {
    val winPairs = mapOf(
        Move.Rock to Move.Paper,
        Move.Paper to Move.Scissors,
        Move.Scissors to Move.Rock
    )

    val loseMap = mapOf(
        Move.Rock to Move.Scissors,
        Move.Paper to Move.Rock,
        Move.Scissors to Move.Paper
    )

    val moveMap = mapOf(
        "A" to Move.Rock,
        "X" to Move.Rock,
        "B" to Move.Paper,
        "Y" to Move.Paper,
        "C" to Move.Scissors,
        "Z" to Move.Scissors,
    )

    val Lose = "X"
    val Draw = "Y"
    val Win = "Z"

    fun List<String>.sumOfGame(transform: (Pair<Play, Play>) -> Int) = this.sumOf {
        val game = it.split(" ")
        val opponent = game.first()
        val me = game.last()
        transform(
            Play(opponent, moveMap[opponent]!!) to Play(me, moveMap[me]!!)
        )
    }

    fun totalScore(input: List<String>): Int {
        return input.sumOfGame { pair ->
            pair.second.move.score + if (winPairs[pair.first.move] == pair.second.move) {
                wonScore
            } else if (pair.first.move.score == pair.second.move.score) {
                drawScore
            } else {
                0
            }
        }
    }

    fun totalScoreWithoutGamePlay(input: List<String>): Int {
        return input.sumOfGame {
            when (it.second.letter) {
                Lose -> loseMap[it.first.move]!!.score
                Win -> winPairs[it.first.move]!!.score + wonScore
                Draw -> it.first.move.score + drawScore
                else -> throw IllegalArgumentException()
            }
        }
    }

    fun part1(input: List<String>): Int {
        return totalScore(input = input)
    }

    fun part2(input: List<String>): Int {
        return totalScoreWithoutGamePlay(input = input)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(day = 2, name = "Day02_test")
    check(part1(testInput) == 19)
    check(part2(testInput) == 16)

    val input = readInput(day = 2, name = "Day02")
    println(part1(input))
    println(part2(input))
}
