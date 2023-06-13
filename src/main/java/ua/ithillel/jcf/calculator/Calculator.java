package ua.ithillel.jcf.calculator;

public class Calculator {
    public double add(double op1, double op2) {
        return ArithmeticUtil.doBinaryOperation(op1, op1, (o1, o2) -> o1 + o2);
    }

    public double subtract(double op1, double op2) {
        return ArithmeticUtil.doBinaryOperation(op1, op1, (o1, o2) -> o1 - o2);
    }

    public double sin(double radian) {
//        return ArithmeticUtil.doUnaryOperation(radian, op -> Math.sin(op));
        return ArithmeticUtil.doUnaryOperation(radian, Math::sin);
    }

    public double cos(double radian) {
        return ArithmeticUtil.doUnaryOperation(radian, this::myCos);
    }

    public double myCos(double radian) {
        return Math.cos(radian);
    }
}
