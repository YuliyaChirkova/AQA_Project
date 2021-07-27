package tests;

import org.junit.runner.RunWith;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.runner.JUnitPlatform;


@RunWith(JUnitPlatform.class)
@SelectClasses({LoginTest.class, SignOutTest.class})
public class TestSuitsClasses {

}
