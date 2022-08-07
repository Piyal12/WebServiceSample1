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
import primary.customerService.GetCustomerRepDetailsById;
import java.util.HashMap;


/*
 *
 * This class will fetch Negative scenarios to test Customer Representative Details by using Rep ID
 * @author Dharini H M
 */
public class GetCustomerRepDetailsByIdNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetCustomerRepDetailsById. class);
    public static final String SERVICE_NAME = "getCustomerRepDetailsById";

    //Pass Enterprise rep ID to get Retail customer rep details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Enterprise rep ID to get Retail customer rep details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerRepDetailsByIdNegative.SERVICE_NAME, testName = "GetCustomerRepDetailsUsingEnterpriseRepID", testGroup = "p1")
    public void GetCustomerRepDetailsUsingEnterpriseRepIDTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerRepDetailsByIdNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Fetching Rep details even for Enterprise Rep ID");
    }

    //Pass Enterprise as relationship data to get Retail customer rep details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Enterprise as relationship data to get Retail customer rep details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerRepDetailsByIdNegative.SERVICE_NAME, testName = "GetCustomerRepDetailsEnterpriseRelshpType", testGroup = "p1")
    public void GetCustomerRepDetailsEnterpriseRelshpTypeTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerRepDetailsByIdNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Fetching Rep details even for Enterprise Rep ID");
    }

    //Pass Invalid datatype as relationship type to get Retail customer rep details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid datatype as relationship type to get Retail customer rep details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerRepDetailsByIdNegative.SERVICE_NAME, testName = "GetCustomerRepDetailsForInvalidDatatypeRelshpType", testGroup = "p1")
    public void GetCustomerRepDetailsForInvalidDatatypeRelshpTypeTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerRepDetailsByIdNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Fetching Rep details even for Invalid Relationship type");
    }

    //Pass empty field for relationship type to get Retail customer rep details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass empty field for relationship type to get Retail customer rep details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerRepDetailsByIdNegative.SERVICE_NAME, testName = "GetCustomerRepDetailsForEmptyRelshpType", testGroup = "p1")
    public void GetCustomerRepDetailsForEmptyRelshpTypeTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerRepDetailsByIdNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Fetching Rep details even for Empty Relationship type");
    }


    //Pass invalid http method to get Retail customer rep details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass invalid http method to get Retail customer rep details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerRepDetailsByIdNegative.SERVICE_NAME, testName = "getCustomerRepDetailsById", testGroup = "p0")
    public void GetCustomerRepDetailsUsingInvalidHttpMethodTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.delete(ServiceGroup.CUSTOMER, GetCustomerRepDetailsByIdNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
    }
}