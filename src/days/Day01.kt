package days

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()

    println("Solution: ${solveDay1(input)}")
    println("Solution2: ${solveTwo(input)}")
}

fun solveDay1(input : List<String>): Int =
    input.sumOf { getCalibrationValue(it) }

fun getCalibrationValue(line:String): Int =
    "${line.first { it.isDigit() }}${line.last { it.isDigit() }}".toInt()

fun solveTwo(input: List<String>): Int =
    input.sumOf { getCalibrationValueTwo(it) }

fun getCalibrationValueTwo(line: String): Int {
    val number = "${findNumber(line, StartsFrom.BEGINNING)}${findNumber(line, StartsFrom.END)}".toInt()
    println(line)
    println(number)
    return number
}

enum class StartsFrom {BEGINNING, END}
fun findNumber(line: String, startsFrom: StartsFrom): Int{
    val indices = when(startsFrom) {
        StartsFrom.BEGINNING -> line.indices
        StartsFrom.END -> line.lastIndex downTo 0
    }
    for (index in indices){
        if (line[index].isDigit()) return line[index].digitToInt()
        val subString = if (startsFrom == StartsFrom.BEGINNING) line.substring(startIndex = index) else line.substring(startIndex = index)
        println(subString)
        return when{
            subString.startsWith("one") -> 1
            subString.startsWith("two") -> 2
            subString.startsWith("three") -> 3
            subString.startsWith("four") -> 4
            subString.startsWith("five") -> 5
            subString.startsWith("six") -> 6
            subString.startsWith("seven") -> 7
            subString.startsWith("eight") -> 8
            subString.startsWith("nine") -> 9
            else -> continue
        }
    }
    error("couldn't find number!")
}
