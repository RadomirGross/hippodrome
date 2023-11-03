import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

public class HorseTest {
    //a
    @Test
    public void testConstructorWithNullParameterThrowsIllegalArgumentException()
    {
        Assertions.assertThrows(IllegalArgumentException.class,()->new Horse(null,3));
    }
    @Test
    public void testMessageIfConstructorThrowsIllegalArgumentException()
    {
        Throwable exception=Assertions.assertThrows(IllegalArgumentException.class,()->new Horse(null,1));
        String expected="Name cannot be null.";
        String actual=exception.getMessage();
        Assertions.assertEquals(expected,actual);
    }
    @ParameterizedTest
    @ValueSource(strings={""," ","\t","\n","\t\n"," \t"," \n"})
void testConstructorWithEmptyOrBlankNameThrowsIllegalArgumentException(String name)
    {
Assertions.assertThrows(IllegalArgumentException.class,()->new Horse(name,1));
    }
    @ParameterizedTest
    @ValueSource(strings={""," ","\t","\n","\t\n"," \t"," \n"})
    void testMessageWithEmptyOrBlankNameWhenThrowsIllegalArgumentException(String name)
    {
        Throwable exception=Assertions.assertThrows(IllegalArgumentException.class,()->new Horse(name,1));
        String expected="Name cannot be blank.";
        String actual= exception.getMessage();
        Assertions.assertEquals(expected,actual);
    }
    @ParameterizedTest
    @ValueSource(ints={-1000000,-1000,-100,-10,-1})
    public void testConstructorWithNegativeSpeedThrowsIllegalArgumentException(int speed)
    {Assertions.assertThrows(IllegalArgumentException.class,()->new Horse("H",speed));
    }
    @ParameterizedTest
    @ValueSource(ints={-1000000,-1000,-100,-10,-1})
    public void testMessageWithNegativeSpeedThrowsIllegalArgumentException(int speed)
    {
        Throwable exception=Assertions.assertThrows(IllegalArgumentException.class,()->new Horse("H",speed));
        String expected="Speed cannot be negative.";
        String actual=exception.getMessage();
        Assertions.assertEquals(expected,actual);

    }
    @ParameterizedTest
    @ValueSource(ints={-1000000,-1000,-100,-10,-1})
    public void testConstructorWithNegativeDistanceThrowsIllegalArgumentException(int distance)
    {Assertions.assertThrows(IllegalArgumentException.class,()->new Horse("H",1,distance));}

    @ParameterizedTest
    @ValueSource(ints={-1000000,-1000,-100,-10,-1})
    public void testMessageWithNegativeDistanceThrowsIllegalArgumentException(int distance) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("H", 1, distance));
        String actual = exception.getMessage();
        String expected="Distance cannot be negative.";
Assertions.assertEquals(expected,actual);
    }
    //b
@ParameterizedTest
    @ValueSource(strings = {"Speed","Funny Horse","Broken Fate"})
    public void testMethodGetNameShouldReturnCorrectly(String name)
{
Horse horse=new Horse(name,1);
Assertions.assertEquals(name,horse.getName());
}

//c
@ParameterizedTest
@ValueSource(doubles = {0.1,0.5,0.6,1.2,1.8,2.0}
)
public void testMethodGetSpeedShouldReturnCorrectly(double speed)
{
    Horse horse=new Horse("name",speed);
    Assertions.assertEquals(speed,horse.getSpeed());
}


//d

    @ParameterizedTest
    @ValueSource(doubles = {0.1,1.1,30.1,1.2,1.8,100.0}
    )
    public void testMethodGetDistanceShouldReturnCorrectly(double distance)
    {
        Horse horse=new Horse("name",1,distance);
        Assertions.assertEquals(distance,horse.getDistance());
    }

   @Test

    public void testMethodGetDistanceWithConstructorWithTwoParamsShouldReturnZero()
    {
        Horse horse=new Horse("name",1);
        Assertions.assertEquals(0,horse.getDistance());
    }

//e
@ExtendWith(MockitoExtension.class)
    public class Mockito
}
