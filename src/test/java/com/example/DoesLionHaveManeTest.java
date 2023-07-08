package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DoesLionHaveManeTest {
    private final String sex;
    private final boolean expected;
    Feline feline;

    public DoesLionHaveManeTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeLionTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals("Пареметр sex может быть 'Самец' или 'Самка'", expected, lion.doesHaveMane());
    }
}
