package example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionSexDeterminationTest {

    @Mock
    Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters(name = "Тестовые данные: {1} {2}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Parameterized.Parameter(0)
    public String sex;

    @Parameterized.Parameter(1)
    public boolean result;

    @Test
    public void haveManeWithDifferentSex() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(result, lion.doesHaveMane());
    }

}