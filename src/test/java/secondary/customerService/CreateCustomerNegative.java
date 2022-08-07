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
 * This class will provides Negative Scenarios for create New Customer API
 * @author Dharini H M
 */
public class CreateCustomerNegative extends TestBase {

    private static final Logger LOG = LoggerFactory.getLogger(CreateCustomerNegative.class);
    public static final String SERVICE_NAME = "createCustomer";

    //Pass Invalid Http method
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid Http method")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = CreateCustomerNegative.SERVICE_NAME)
    public void createCustomerWithInvalidHttpMethodTest(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.delete(ServiceGroup.CUSTOMER, CreateCustomerNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Actual Status code: " + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
    }

    //Pass existing customer KYC for customer creation
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass existing customer KYC for customer creation")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = CreateCustomerNegative.SERVICE_NAME, testName = "createCustomerWithExistingKYCDetails", testGroup = "p1")
    public void createCustomerWithExistingKYCDetailsTest(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.CUSTOMER, CreateCustomerNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Response Body: " + rest.getResponse().body().asString());
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        // Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Customer created with Existing KYC Details");
    }



    //Pass Mandatory fields as empty for customer creation
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Mandatory fields as empty for customer creation")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = CreateCustomerNegative.SERVICE_NAME, testName = "createCustomerWithMandateFields", testGroup = "p1",
            attributeName = "phoneNumber", dataConstraint = DataConstraint.FOR_SPECIFIED, dataType = DataType.NULL)
    public void createCustomerWithMandateFieldsEmptyTest(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.CUSTOMER, CreateCustomerNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Actual Status code: " + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        // Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Customer created even with mandatory fields as empty");
    }

    //Pass Invalid phone number for customer creation
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Mandatory fields as empty for customer creation")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = CreateCustomerNegative.SERVICE_NAME, testName = "createCustomerWithInvalidPhoneNo",
            testGroup = "p1", attributeName = "phoneNumber", dataConstraint = DataConstraint.FOR_SPECIFIED, dataType = DataType.ALPHA_NUMERIC)
    public void createCustomerWithInvalidPhoneNoTest(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.CUSTOMER, CreateCustomerNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Actual Status code: " + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
       // Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Customer created even with Invalid Phone number");
    }
}