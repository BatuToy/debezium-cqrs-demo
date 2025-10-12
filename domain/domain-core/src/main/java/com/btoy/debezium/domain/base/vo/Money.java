package com.btoy.debezium.domain.base.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {

    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN; // for banking application!
    private static final Integer SCALE = 2;

    public static final Money ZERO = new Money(BigDecimal.valueOf(0L));

    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = scaleDecimal(amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public static Money of(BigDecimal amount) {
        Objects.requireNonNull(amount);
        return new Money(amount);
    }

    public Money add(Money added) {
        return scaleMoney(new Money(this.amount.add(added.getAmount())));
    }

    public Money subtract(Money subtracted) {
        return scaleMoney(new Money(this.amount.subtract(subtracted.getAmount())));
    }

    public Money multiply(Money multiplicand) {
        return scaleMoney(new Money(this.amount.multiply(multiplicand.getAmount())));
    }

    public boolean isGreaterThen(Money then) {
        return this.amount.compareTo(then.getAmount()) > 0;
    }

    public boolean isLowerThen(Money then) {
        return this.amount.compareTo(then.getAmount()) < 0;
    }

    public boolean isEqualTo(Money to) {
        return this.amount.compareTo(to.getAmount()) == 0;
    }

    private static Money scaleMoney(Money input) {
        Objects.requireNonNull(input);
        return new Money(input.getAmount().setScale(SCALE, ROUNDING_MODE));
    }

    private static BigDecimal scaleDecimal(BigDecimal input) {
        Objects.requireNonNull(input);
        return input.setScale(SCALE, ROUNDING_MODE);
    }
}
