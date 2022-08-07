package secondary.supplier;

import com.google.gson.Gson;
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

import java.io.File;
import java.util.HashMap;

/*
*
* This class will edit Pickup Location Product Groups Details
* @author Piyal
*/
public class PutPickupLocationProductGroupsTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(PutPickupLocationProductGroupsTest.class);
    public static final String SERVICE_NAME = "putPickupLocationProductGroups";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "PutPickupLocationProductGroupsTest with invalid product brand alias id")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = PutPickupLocationProductGroupsTest.SERVICE_NAME, testName = "invalidProductBrandAliasID_test", testGroup = "p1")
    public void invalidProductBrandAliasID_test(HashMap<String, String> data) {
        WebService rest = Ws.put(ServiceGroup.SUPPLIER, PutPickupLocationProductGroupsTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "PutPickupLocationProductGroupsTest with invalid alloted capacity")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = PutPickupLocationProductGroupsTest.SERVICE_NAME, testName = "invalidAllotedCapacity_test", testGroup = "p2")
    public void invalidAllotedCapacity_test(HashMap<String, String> data) {
        WebService rest = Ws.put(ServiceGroup.SUPPLIER, PutPickupLocationProductGroupsTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "PutPickupLocationProductGroupsTest with invalid http method")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = PutPickupLocationProductGroupsTest.SERVICE_NAME, testName = "putpickuplocation_valid_data_test", testGroup = "p0")
    public void invalid_HttpMethod_test(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, PutPickupLocationProductGroupsTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
}
