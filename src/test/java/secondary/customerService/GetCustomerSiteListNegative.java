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

public class GetCustomerSiteListNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetCustomerSiteListNegative. class);
    public static final String SERVICE_NAME = "getCustomerSiteList";

    //Pass Enterprise as relationship type to get Retail customer Site list
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative","regression"}, description = "Pass Enterprise as relationship type to get Retail customer Site list")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerSiteListNegative.SERVICE_NAME, testName = "getCustomerSiteListForEnterprise", testGroup = "p1")
    public void getCustomerSiteListForEnterpriseTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerSiteListNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + "Actual status code: " + rest.getStatus());
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.data"), null, "getting Customer site list even for Enterprise Relationship type");
    }


    //Pass Invalid branch ID to get customer Site list
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative","regression"}, description = "Pass Invalid branch ID to get customer Site list")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerSiteListNegative.SERVICE_NAME, testName = "getCustomerSiteListForInvalidBranchID", testGroup = "p1")
    public void getCustomerSiteListForInvalidBranchIDTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerSiteListNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + "Actual status code: " + rest.getStatus());
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.data"), null, "getting Customer site list even for Invalid BranchID");
    }

    //Pass Invalid datatype as branch ID to get customer Site list
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative","regression"}, description = "Pass Invalid datatype as branch ID to get customer Site list")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerSiteListNegative.SERVICE_NAME, testName = "getCustomerSiteListForInvalidDatatypeBranchID", testGroup = "p1")
    public void getCustomerSiteListForInvalidDatatypeBranchIDTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerSiteListNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + "Actual status code: " + rest.getStatus());
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.data"), null, "getting Customer site list even for Invalid BranchID");
    }

    //Pass Invalid datatype as branch ID with valid one to get customer Site list
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative","regression"}, description = "Pass Invalid datatype as branch ID with valid one to get customer Site list")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerSiteListNegative.SERVICE_NAME, testName = "getCustomerSiteListForInvalidDatatypeBranchIDWithValidOne", testGroup = "p1")
    public void getCustomerSiteListForInvalidDatatypeBranchIDWithValidOneTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerSiteListNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + "Actual status code: " + rest.getStatus());
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.data"), null, "getting Customer site list even for Invalid BranchIDs");
    }


    //Pass Invalid datatype as relationship type to get customer Site list
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative","regression"}, description = "Pass Invalid datatype as relationship type to get customer Site list")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerSiteListNegative.SERVICE_NAME,
            testName ="getCustomerSiteListForInvalidDatatypeForRelshp", testGroup = "p1")
    public void getCustomerSiteListForInvalidDatatypeForRelshpTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerSiteListNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + "Actual status code: " + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "getting Customer site list even for Invalid Relationship param");
    }

    //Pass empty as relationship type to get customer Site list
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative","regression"}, description = "Pass empty as relationship type to get customer Site list")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerSiteListNegative.SERVICE_NAME,
            testName ="getCustomerSiteListForEmptyForRelshp", testGroup = "p1")
    public void getCustomerSiteListForEmptyForRelshpTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerSiteListNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + "Actual status code: " + rest.getStatus());
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "getting Customer site list even for empty Relationship param");
    }

    //Pass Invalid http method to get customer Site list
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative","regression"}, description = "Pass Invalid http method to get customer Site list")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerSiteListNegative.SERVICE_NAME,
            testName ="getCustomerSiteListForInvalidHttpMethod", testGroup = "p1")
    public void getCustomerSiteListForInvalidHttpMethodTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.post(ServiceGroup.CUSTOMER, GetCustomerSiteListNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + "Actual status code: " + rest.getStatus());
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 412, "The expected status is " + 412 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "getting Customer site list even for Invalid Http method");
    }
}