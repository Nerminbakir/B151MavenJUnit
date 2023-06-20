package techproed.day08_JUnit;
import org.junit.*;
public class C02_BeforeClassAfterClass {
 /*
    @BeforeClass class'da en once calısan methoddur.
    @AfterClass class'da en son calısan methoddur.

    @BeforeClass ve @AfterClass methodları sadece static methodlar ile calısır.
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Class'da en once calısan methoddur bir kez calısır");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Class'da en son calısan methoddur bir kez calısır");
    }


    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan once calısır");
    }


    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra calısır");
    }


    @Test
    public void test01() {
        System.out.println("ilk test");
    }


    @Test
    public void test02() {
        System.out.println("ikinci test");
    }
}
