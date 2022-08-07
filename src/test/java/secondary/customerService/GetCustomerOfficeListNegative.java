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
 * This class will provide different Negative scenarios to test Get list of Customer offices API
 * @author Dharini H M
 */
public class GetCustomerOfficeListNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetCustomerOfficeListNegative.class);
    public static final String SERVICE_NAME = "getCustomerOfficeList";


    //Pass empty relationship type to get Customer office List
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass empty relationship type to get Customer office List")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerOfficeListNegative.SERVICE_NAME, testName = "getCustomerOfficeListForEmptyRelship", testGroup = "p1")
    public void getCustomerOfficeListForEmptyRelshipTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerOfficeListNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.data"), null, "getting Customer list  even for Empty Relationship type");
    }

    //Pass Invalid relationship type to get Customer office List
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid relationship type to get Customer office List")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerOfficeListNegative.SERVICE_NAME, testName = "getCustomerOfficeListForInvalidRelship", testGroup = "p1")
    public void getCustomerOfficeListForInvalidRelshipTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerOfficeListNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.data"), null, "getting Customer list for Invalid Relationship type");
    }


    //Pass Invalid http method to get Customer office List
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid http method to get Customer office List")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerOfficeListNegative.SERVICE_NAME, testName = "getCustomerOfficeListEnterprise", testGroup = "p1")
    public void getCustomerOfficeListInvalidHttpMethodTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.delete(ServiceGroup.CUSTOMER, GetCustomerOfficeListNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
    }
}