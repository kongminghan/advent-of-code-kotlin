fun main() {
    fun highestSumCalories(input: List<String>): Int {
        return input
            .foldIndexed(mutableListOf<MutableList<Int>>(mutableListOf())) { _, acc, item ->
                if (item == "") {
                    acc.add(mutableListOf())
                } else {
                    acc.last().add(item.toInt())
                }
                acc
            }.maxOf { it.sum() }
    }

    fun part1(input: List<String>): Int {
        return highestSumCalories(input)
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 9)

    val input = readInput(name = "Day01")
    println(part1(input))
}
