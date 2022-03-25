package jvm.exercise.string;

public class InspectorJ {

  public static int maxInt(String source) {
    int result = 0;
    int current = 0;
    for (Character c : source.toCharArray()) {
      if (isDigit(c)) {
        current = current * 10 + c - '0';
      } else {
        if (current > 0) {
          result = Math.max(result, current);
          current = 0;
        }
      }
    }

    return result;
  }

  public static boolean isDigit(char c) {
    return '0' <= c && c <= '9';
  }
}
