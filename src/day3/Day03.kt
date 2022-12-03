package day3

import readInput
import java.lang.IllegalArgumentException

fun main() {

    fun totalPriorities(input: List<String>) : Int {
        return input.sumOf { rucksack ->
            val compartments = rucksack.chunked(rucksack.length.div(2))
            val commonElements = compartments.first().toCharArray().toSet()
                .intersect(compartments.last().toCharArray().toSet())

            commonElements.sumOf {
                if (it.isUpperCase()) {
                    it.code - 38
                } else {
                    it.code - 96
                }
            }
        }
    }

    fun part1(input: List<String>): Int {
        return totalPriorities(input = input)
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(day = 3, name = "Day03_test")
    check(part1(testInput) == 157)

    val input = readInput(day = 3, name = "Day03")
    println(part1(input))
}
