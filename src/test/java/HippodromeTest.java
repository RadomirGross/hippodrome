import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class HippodromeTest {

    //a
    @Test
    public void testConstructorWithNullThrowsIllegalArgumentException()
    {
        Assertions.assertThrows(IllegalArgumentException.class,()->new Hippodrome(null));
    }
    @Test
    public void testMessageIfConstructorThrowsIllegalArgumentException()
    {
        Throwable exception=Assertions.assertThrows(IllegalArgumentException.class,()->new Hippodrome(null));
        String actual=exception.getMessage();
        String expected="Horses cannot be null.";
        Assertions.assertEquals(actual,expected);
    }
    @Test
    public void testConstructorWithBlankThrowsIllegalArgumentException()
    {
        Assertions.assertThrows(IllegalArgumentException.class,()->new Hippodrome(Collections.emptyList()));
    }

    @Test
    public void testMessageIfConstructor_ThrowsIllegalArgumentException()
    {
        Throwable exception=Assertions.assertThrows(IllegalArgumentException.class,()-> new Hippodrome(Collections.emptyList()));
        String expected="Horses cannot be empty.";
        String actual=exception.getMessage();
        Assertions.assertEquals(actual,expected);
}
//b
    @Test
    public void testMethodGetHorses(){
        List<Horse> horses=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse(i+"",i));
        }
        Hippodrome hippodrome=new Hippodrome(horses);
List<Horse> getHorses=hippodrome.getHorses();
Assertions.assertIterableEquals(horses,getHorses);
    }
    //c
    @Test
    public void testMethodMove(){
List<Horse> mockHorses=new ArrayList<>();
        for (int i = 0; i <50; i++) {
                Horse mockHorse= Mockito.mock(Horse.class);
                mockHorses.add(mockHorse);
        }
        Hippodrome hippodrome=new Hippodrome(mockHorses);
        hippodrome.move();
        for (Horse mockHorse:mockHorses) {
Mockito.verify(mockHorse,Mockito.times(1)).move();
        }
    }
//d
    @Test
    public void testFirst_MethodGetWinner()
    {
        List<Horse> horses=new ArrayList<>();
        Horse horse1=new Horse("1",1,1);
        Horse horse2=new Horse("2",1,10);
        Horse horse3=new Horse("3",1,100);
horses.add(horse1);
horses.add(horse2);
horses.add(horse3);
        Hippodrome hippodrome=new Hippodrome(horses);
        Horse winner=hippodrome.getWinner();
        Assertions.assertSame(winner,horse3);

    }
    @Test
    public void testSecond_MethodGetWinner()
    {
        List<Horse> horses=new ArrayList<>();
        Horse horse1=new Horse("3",10,1);
        Horse horse2=new Horse("2",10,100000);
        Horse horse3=new Horse("1",10,100);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        Hippodrome hippodrome=new Hippodrome(horses);
        Horse winner=hippodrome.getWinner();
        Assertions.assertEquals(winner,horse2);
    }


}
