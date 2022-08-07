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
import primary.customerService.GetCustomerSiteDetailsById;
import java.util.HashMap;

public class GetCustomerSiteDetailsByIdNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetCustomerSiteDetailsById.class);
    public static final String SERVICE_NAME = "getCustomerSiteDetailsById";

    //Pass Enterprise office ID to get Retail customer Site details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative", "regression"}, description = "Pass Enterprise office ID to get Retail customer Site details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerSiteDetailsById.SERVICE_NAME, testName = "getCustomerSiteDetailsForEnterpriseOffID", testGroup = "p1")
    public void getCustomerSiteDetailsForEnterpriseOffIDTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerSiteDetailsById.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "fetching customer site details even for Enterprise site ID");
    }

    //Pass Enterprise as relationship type to get Retail customer Site details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative", "regression"}, description = "Pass Enterprise as relationship type to get Retail customer Site details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerSiteDetailsById.SERVICE_NAME, testName = "getCustomerSiteDetailsForEnterpriseRelationship", testGroup = "p1")
    public void getCustomerSiteDetailsForEnterpriseRelationshipTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerSiteDetailsById.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "fetching customer site details even for Enterprise site ID");
    }

    //Pass Invalid data as relationship type to get Retail customer Site details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative", "regression"}, description = "Pass Invalid data as relationship type to get Retail customer Site details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerSiteDetailsById.SERVICE_NAME, testName = "getCustomerSiteDetailsForInvalidRelationship", testGroup = "p1")
    public void getCustomerSiteDetailsForInvalidRelationshipTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerSiteDetailsById.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "fetching customer site details even for Invalid Relationship type");
    }

    //Pass empty data as relationship type to get Retail customer Site details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative", "regression"}, description = "Pass empty data as relationship type to get Retail customer Site details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerSiteDetailsById.SERVICE_NAME, testName = "getCustomerSiteDetailsForEmptyRelationshipType", testGroup = "p1")
    public void getCustomerSiteDetailsForEmptyRelationshipTypeTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerSiteDetailsById.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "fetching customer site details even for Empty Relationship type");
    }

    //Pass invalid http method to get Retail customer Site details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative", "regression"}, description = "Pass invalid http method to get Retail customer Site details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerSiteDetailsById.SERVICE_NAME, testName = "getCustomerSiteDetailsById", testGroup = "p0")
    public void getCustomerSiteDetailsForInvalidHttpMethodTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.delete(ServiceGroup.CUSTOMER, GetCustomerSiteDetailsById.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
    }
}