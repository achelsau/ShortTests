import java.util.Stack;

public class Paranthesis {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (Character c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (c == '[') {
        stack.push(']');
      } else if (c == '{') {
        stack.push('}');
      } else if (stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    Paranthesis p = new Paranthesis();
    p.isValid("()");
  }
}
