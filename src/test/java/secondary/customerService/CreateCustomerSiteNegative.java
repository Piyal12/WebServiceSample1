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
 * This class will provides Negative Scenarios to Create Customer Site
 * @author Dharini H M
 */
public class CreateCustomerSiteNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateCustomerSiteNegative. class);
    public static final String SERVICE_NAME = "createCustomerSite";

    //Pass Mandatory fields as empty for Customer site creation
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Mandatory fields as empty for Customer site creation")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = CreateCustomerSiteNegative.SERVICE_NAME, testName = "createSiteEmptyMandateFields", testGroup = "p1",
            attributeName = "name",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NULL)
    public void createSiteEmptyMandateFieldsTest(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.CUSTOMER, CreateCustomerSiteNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Actual Response code: "+rest.getStatus());
        LOG.info("ResponseBody: " + rest.getResponse().getBody().prettyPrint());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
    }

    //Pass Invalid data as Mandatory fields for Customer site creation
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid data as Mandatory fields for Customer site creation")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = CreateCustomerSiteNegative.SERVICE_NAME, testName = "createSiteForInvalidMandateFields", testGroup = "p1")
    public void createSiteForInvalidMandateFieldsTest(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.CUSTOMER, CreateCustomerSiteNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Actual Response code: "+rest.getStatus());
        LOG.info("ResponseBody: " + rest.getResponse().getBody().prettyPrint());
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
    }
}