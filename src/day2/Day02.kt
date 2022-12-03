package day2

import readInput

const val wonScore = 6
const val drawScore = 3

enum class Move(val score: Int) {
    Rock(1),
    Paper(2),
    Scissors(3)
}

fun main() {
    val winPairs = listOf(
        Move.Rock to Move.Paper,
        Move.Paper to Move.Scissors,
        Move.Scissors to Move.Rock
    )

    val moveMap = mapOf(
        "A" to Move.Rock,
        "X" to Move.Rock,
        "B" to Move.Paper,
        "Y" to Move.Paper,
        "C" to Move.Scissors,
        "Z" to Move.Scissors,
    )

    fun totalScore(input: List<String>): Int {
        return input.sumOf {
            it[0].code
            val game = it.split(" ")
            val pair = moveMap[game.first()]!! to moveMap[game.last()]!!

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
