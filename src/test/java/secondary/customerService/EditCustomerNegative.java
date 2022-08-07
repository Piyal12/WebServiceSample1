package secondary.customerService;
import com.google.gson.Gson;
import com.im.service.common.Annotation;
import com.im.service.common.DataConstraint;
import com.im.service.common.DataType;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;
import common.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;

/*
 *
 * This class will provides Negative Scenarios for Edit Customer API
 * @author Dharini H M
 */
public class EditCustomerNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(EditCustomerNegative.class);
    public static final String SERVICE_NAME = "editCustomer";

    //Pass enterprise customer ID for edit customer
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass enterprise customer ID for edit customer")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = EditCustomerNegative.SERVICE_NAME, testName = "editCustomerForEnterpriseCustID", testGroup = "p1")
    public void editCustomerForEnterpriseCustIDTest(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.put(ServiceGroup.CUSTOMER, EditCustomerNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Able to update the customer with Enterprise custID");
    }

    //Pass Invalid Http method for edit customer
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid Http method for edit customer")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = EditCustomerNegative.SERVICE_NAME, testName = "editCustomerForEnterpriseCustID", testGroup = "p1")
    public void editCustomerWithInvalidHttpTest(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, EditCustomerNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Able to update the customer with Enterprise custID");
    }


    //Pass Mandate fields as empty for edit customer
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Mandate fields as empty for edit customer")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = EditCustomerNegative.SERVICE_NAME, testName = "editCustomerWithMandateEmpty", testGroup = "p1",
            attributeName = "phoneNumber",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NULL)
    public void editCustomerWithMandateEmptyTest(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.put(ServiceGroup.CUSTOMER, EditCustomerNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Able to update the customer even with mandatory fields empty");
    }
}