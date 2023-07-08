package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private final String sex="Самец";
    @Mock
    Feline feline;
    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(13);
        assertEquals(13, lion.getKittens());
    }
    @Test
    public void doesHaveManeExceptionTest() {
        Exception actualException = Assert.assertThrows(Exception.class, () -> new Lion("Несамец", feline));
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", actualException.getMessage());
    }
    @Test
    public void getFoodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        assertEquals(expected, lion.getFood());
    }
}