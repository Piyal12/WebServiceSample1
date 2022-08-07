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
 * This class will provides Negative Scenarios for get Customer List API
 * @author Dharini H M
 */
public class GetCustomerListNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetCustomerListNegative.class);
    public static final String SERVICE_NAME = "getCustomerList";

    //Pass Invalid Http method to fetch Customer List
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid Http method to fetch Customer List")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerListNegative.SERVICE_NAME, testName = "getCustomerList", testGroup = "p0")
    public void getCustomerListWithWrongHttpMethodTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.delete(ServiceGroup.CUSTOMER, GetCustomerListNegative.SERVICE_NAME, TestBase.ENV, data);
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
    }


    //Pass Invalid Relationship type data to fetch Customer List
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid Relationship type data to fetch Customer List")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerListNegative.SERVICE_NAME, testName = "getCustomerListForInvalidRelType", testGroup = "p1")
    public void getCustomerListForInvalidRelTypeTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerListNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()), data);
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        LOG.info("\n" + "Actual status code: " + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.data"), null, "getting Customer list  even for Invalid Relationship type");
    }

    //Pass Empty Relationship type data to fetch Customer List
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Empty Relationship type data to fetch Customer List")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerListNegative.SERVICE_NAME, testName = "getCustomerListForEmptyRelType", testGroup = "p1")
    public void getCustomerListForEmptyRelTypeTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerListNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()), data);
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        LOG.info("\n" + "Actual status code: " + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.data"), null, "getting Customer list  even for Invalid Relationship type");
    }



    //Pass Invalid Customer type data to fetch Customer List
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid Customer type data to fetch Customer List")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerListNegative.SERVICE_NAME, testName = "getCustomerListForInvalidCustomerType", testGroup = "p1")
    public void getCustomerListForInvalidCustomerTypeTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerListNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.data"), null, "getting Customer list even for Invalid Relationship type");
    }

    //Pass Empty Customer type data to fetch Customer List
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Empty Customer type data to fetch Customer List")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerListNegative.SERVICE_NAME, testName = "getCustomerListForEmptyCustomerType", testGroup = "p1")
    public void getCustomerListForEmptyCustomerTypeTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerListNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.data"), null, "getting Customer list even for Invalid Relationship type");
    }
}