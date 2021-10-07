package calculator.MathOperations;

public interface Operation {
    String getSign();

    double operation(double member_one, double member_two);
}
