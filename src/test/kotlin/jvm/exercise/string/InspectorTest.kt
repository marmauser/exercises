package jvm.exercise.string

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class InspectorTest {

  @Test
  fun maxIntTest() {
    val source = "fRETre3445 43#\$% 5п32424234 #\$@\$34 2323"
    Assertions.assertEquals(32424234, source.toIntegers().maxOrNull())
  }

  @Test
  fun sumIntTest() {
    val source = "fRETre3445 43#\$% 5п32424234 #\$@\$34 2323"
    Assertions.assertEquals(32430084, source.toIntegers().sum())
  }
}