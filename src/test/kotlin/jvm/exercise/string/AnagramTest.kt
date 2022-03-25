package jvm.exercise.string

import org.junit.jupiter.api.Test

class AnagramTest {

  @Test
  fun simpleTest() {
    val source = listOf("cat", "act", "dinosaur", "testing", "setting")

    println(Anagram.anagrams(source))
  }
}