package com.strikalov.unittestinghomework.unit;

import com.strikalov.unittestinghomework.model.entity.Calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    public Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void correctAdditionTest(){
        Assert.assertEquals(5, calculator.addition(2,3));
    }

    @Test
    public void wrongAdditionTest(){
        Assert.assertNotEquals(6,calculator.addition(2,2));
    }

}
