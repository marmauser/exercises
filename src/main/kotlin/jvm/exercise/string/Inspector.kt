package jvm.exercise.string

/**
 * Split string to list of integers filtering out other chars
 */
fun String.toIntegers() = this.map { c -> if (c.isDigit()) c else ':' }
  .joinToString("")
  .split(":").filter { it.isNotBlank() }
  .map { it.toInt() }
