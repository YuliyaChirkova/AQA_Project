package tests;

import org.junit.runner.RunWith;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.runner.JUnitPlatform;


@RunWith(JUnitPlatform.class)
@SelectClasses({LoginTest.class, SignOutTest.class})
public class TestSuitsClasses {

}
/* Вопрос: здесь тесты вроде бы проходят, но в консоли видно, что в классе LoginTest
дважды запускается тест "Testing of Login page", один из которых не выполняется.
 Не могу понять, почему он запускается дважды и один не выполняется.
 И в целом, выполняются ли тесты, учитывая, что время выполнения у всех 0 милисекунд*/