package secondary.supplier;

import com.im.service.common.Annotation;
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
* This class will edit Pickup Location Product Services details
* @author Piyal
* */
public class PutPickupLocationProductServicesTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(PutPickupLocationProductServicesTest.class);
    public static final String SERVICE_NAME = "putPickupLocationProductServices";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "PutPickupLocationProductServicesTest with service Alias Id as null")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = PutPickupLocationProductServicesTest.SERVICE_NAME, testName = "serviceAliasIDAsnull_test", testGroup = "p1")
    public void serviceAliasIDAsnull_test(HashMap<String, String> data) {
        WebService rest = Ws.put(ServiceGroup.SUPPLIER, PutPickupLocationProductServicesTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "PutPickupLocationProductServicesTest with service alias Id as Blank")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = PutPickupLocationProductServicesTest.SERVICE_NAME, testName = "serviceAliasIDAsBlank_test", testGroup = "p2")
    public void serviceAliasIDAsBlank_test(HashMap<String, String> data) {
        WebService rest = Ws.put(ServiceGroup.SUPPLIER, PutPickupLocationProductServicesTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "PutPickupLocationProductServicesTest with value as blank")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = PutPickupLocationProductServicesTest.SERVICE_NAME, testName = "passValueAsBlank_test", testGroup = "p3")
    public void passValueAsBlank_test(HashMap<String, String> data) {
        WebService rest = Ws.put(ServiceGroup.SUPPLIER, PutPickupLocationProductServicesTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "PutPickupLocationProductServicesTest with invalid http method")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = PutPickupLocationProductServicesTest.SERVICE_NAME, testName = "putpickuplocation_valid_data_test", testGroup = "p0")
    public void invalid_HttpMethod_test(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, PutPickupLocationProductServicesTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
}

