package day3

import readInput

fun main() {

    fun Char.toPriority() = if (this.isUpperCase()) {
        this.code - 38
    } else {
        this.code - 96
    }

    fun String.toCharSet(): Set<Char> = toCharArray().toSet()

    fun List<String>.findIntersection(): Set<Char> {
        return foldIndexed(setOf()) { index, acc, s ->
            if (index == 0) {
                acc + s.toCharSet()
            } else {
                acc.intersect(s.toCharSet())
            }
        }
    }

    fun List<String>.findPriority(): Int = findIntersection()
        .first()
        .toPriority()

    fun part1(input: List<String>): Int {
        return input.sumOf { rucksack ->
            rucksack
                .chunked(rucksack.length.div(2))
                .findPriority()
        }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3).sumOf { rucksack ->
            rucksack
                .findPriority()
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(day = 3, name = "Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput(day = 3, name = "Day03")
    println(part1(input))
    println(part2(input))
}
