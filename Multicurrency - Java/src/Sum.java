import java.beans.Expression;

public class Sum implements IExpression {

    IExpression augend;
    IExpression addend;

    public Sum(IExpression augend, IExpression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to){
        int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    public IExpression plus(IExpression addend) {
        return new Sum(this, addend);
    }

    public IExpression times(int multiplier){
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
