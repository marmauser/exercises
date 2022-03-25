package jvm.exercise.string

class Anagram {
  companion object {
    /**
     * Finding anagrams in [source] words.
     * First collect map of chars to their quantity in each word and take its hash
     * Then group hash values to find those having more than 1 in group
     * Finally take words from previous collection
     */
    fun anagrams(source: List<String>): List<String> {
      val hashed = source.map { word ->
        word to word.groupBy { it }.map { (c,list) -> c to list.size }.toMap().hashCode()
      }

      val anagrams = hashed.groupBy { entry -> entry.second }.filter { (_,list) -> list.size > 1 }

      return anagrams.flatMap { (_,list) -> list.map { it.first } }
    }
  }
}