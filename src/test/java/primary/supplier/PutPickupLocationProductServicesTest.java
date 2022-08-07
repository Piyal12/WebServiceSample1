package primary.supplier;

import com.google.gson.Gson;
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

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"regression","sanity","positive"},description = "PutPickupLocationProductServicesTest with all valid params")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = PutPickupLocationProductServicesTest.SERVICE_NAME, testName = "putpickuplocation_valid_data_test", testGroup = "p0")
    public void putPickupLocationProductServices_test(HashMap<String, String> data) {
        WebService rest = Ws.put(ServiceGroup.SUPPLIER, PutPickupLocationProductServicesTest.SERVICE_NAME, TestBase.ENV, data);
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Put pickup location product service test() failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
}

