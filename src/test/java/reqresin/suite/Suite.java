package reqresin.suite;

import org.junit.runner.RunWith;
import reqres.rest.tests.LoginTest;
import reqres.rest.tests.RegisterTest;
import reqres.rest.tests.UsersTest;

@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({
        LoginTest.class,
        RegisterTest.class,
        UsersTest.class
})
public class Suite {
}
