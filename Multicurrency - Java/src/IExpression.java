public interface IExpression {

    Money reduce(Bank bank, String to);

    IExpression plus(IExpression addend);

    IExpression times(int multiplier);
}
