package jvm.exercise.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InspectorJTest {

  @Test
  public void maxIntTest() {
    String source = "fRETre3445 43#$% 5п32424234 #$@$34 2323";
    Assertions.assertEquals(32424234, InspectorJ.maxInt(source));
  }
}
