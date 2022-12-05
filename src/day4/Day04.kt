package day4

import readInput

fun main() {

    fun String.toIntRange(): IntRange {
        val (first, second) = this.split("-")
        return first.toInt()..second.toInt()
    }

    fun ClosedRange<Int>.containedIn(other: ClosedRange<Int>) =
        other.contains(this.start) && other.contains(this.endInclusive)

    fun List<String>.findContainedRange(): List<Pair<IntRange, IntRange>> {
        return this.mapNotNull {
            val (first, second) = it.split(",")
            val firstRange = first.toIntRange()
            val secondRange = second.toIntRange()
            if (firstRange.containedIn(secondRange) || secondRange.containedIn(firstRange)) {
                firstRange to secondRange
            } else {
                null
            }
        }
    }

    fun part1(input: List<String>): Int {
        return input.findContainedRange().size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(day = 4, name = "Day04_test")
    check(part1(testInput) == 2)

    val input = readInput(day = 4, name = "Day04")
    println(part1(input))
}
