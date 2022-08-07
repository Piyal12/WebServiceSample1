package secondary.customerService;

import com.im.service.common.Annotation;
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
 * This class will provide different Negative scenarios to fetch Office Details
 * @author Dharini H M
 */
public class GetCustomerOfficeNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetCustomerOfficeNegative. class);
    public static final String SERVICE_NAME = "getCustomerOffice";


    //Pass Invalid relationship datatype to get Customer office details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid relationship datatype to get Customer office details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerOfficeNegative.SERVICE_NAME, testName = "getCustomerOfficeForInvalidRelDataType", testGroup = "p1")
    public void getCustomerOfficeForInvalidRelDataTypeTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerOfficeNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.phone_number"), null, "getting Office details even for Empty Relationship type");
    }


    //Pass empty relationship datatype to get Customer office details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass empty relationship datatype to get Customer office details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerOfficeNegative.SERVICE_NAME, testName = "getCustomerOfficeForEmptyRelship", testGroup = "p1")
    public void getCustomerOfficeForEmptyRelshipTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerOfficeNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.phone_number"), null, "getting Office details even for Empty Relationship type");
    }


    //Pass Invalid http method to get Customer office details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid http method to get Customer office details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerOfficeNegative.SERVICE_NAME, testName = "getCustomerOfficeWithoutRelship", testGroup = "p1")
    public void getCustomerOfficeInvalidHttpMethodTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.delete(ServiceGroup.CUSTOMER, GetCustomerOfficeNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
    }
}