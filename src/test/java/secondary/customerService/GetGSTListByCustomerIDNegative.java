package secondary.customerService;

import com.im.service.common.Annotation;
import com.im.service.common.DataConstraint;
import com.im.service.common.DataType;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;
import common.TestBase;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import primary.customerService.GetGSTListByCustomerID;

import java.io.File;
import java.util.HashMap;

public class GetGSTListByCustomerIDNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetGSTListByCustomerIDNegative.class);
    public static final String SERVICE_NAME = "getGSTListByCustomerID";

    //Pass Invalid customer ID to get GST List
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative","regression"}, description = "Pass Invalid customer ID to get GST List")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetGSTListByCustomerIDNegative.SERVICE_NAME, testName = "getGSTListByInvalidCustomerID", testGroup = "p1")
    public void getGSTListByInvalidCustomerIDTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetGSTListByCustomerIDNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("Actual Status code: " + rest.getStatus());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.data"), null, "Fetching GST list of a customer for Invalid customer ID");
    }

    //Pass Invalid datatype for customer ID to get GST List
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative","regression"}, description = "Pass Invalid datatype for customer ID to get GST List")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetGSTListByCustomerIDNegative.SERVICE_NAME, testName = "getGSTListByInvalidDatatypeCustomerID", testGroup = "p1",
            attributeName = "customer_alias_id",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.ALPHABET)
    public void getGSTListByInvalidDatatypeCustomerIDTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetGSTListByCustomerIDNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("Actual Status code: " + rest.getStatus());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertEquals(rest.getResponse().body().jsonPath().getString("x.data"), null, "Fetching GST list of a customer for Invalid customer ID");
    }

    //Pass Invalid http method to get GST List
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative","regression"}, description = "Pass Invalid http method to get GST List")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetGSTListByCustomerIDNegative.SERVICE_NAME, testName = "getGSTListByCustomerID", testGroup = "p0")
    public void getGSTListForInvalidHttpMethodTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.delete(ServiceGroup.CUSTOMER, GetGSTListByCustomerIDNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("Actual Status code: " + rest.getStatus());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
    }
}