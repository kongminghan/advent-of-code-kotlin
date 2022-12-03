package day01

import readInput

fun main() {
    fun highestSumCalories(input: List<String>, limit: Int): Int {
        return input
            .foldIndexed(mutableListOf<MutableList<Int>>(mutableListOf())) { _, acc, item ->
                if (item == "") {
                    acc.add(mutableListOf())
                } else {
                    acc.last().add(item.toInt())
                }
                acc
            }
            .asSequence()
            .map { it.sum() }
            .sortedDescending()
            .take(limit)
            .sum()
    }

    fun part1(input: List<String>): Int {
        return highestSumCalories(input, limit = 1)
    }

    fun part2(input: List<String>): Int {
        return highestSumCalories(input = input, limit = 3)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 9)
    check(part2(testInput) == 21)

    val input = readInput(name = "Day01")
    println(part1(input))
    println(part2(input))
}
