package ua.ithillel.jcf.calculator;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class ArithmeticUtil {
    // 1 - 2
    // 1 + 4
    // 3 * 4
    // a operation b
    public static <T> T doBinaryOperation(T op1, T op2, BinaryOperator<T> operator) {
        return operator.apply(op1, op2);
    }

    // -1
    // sin(45)
    // |-34|
    // operation a

    public static <T> T doUnaryOperation(T op, UnaryOperator<T> operator) {
        return operator.apply(op);
    }
}
