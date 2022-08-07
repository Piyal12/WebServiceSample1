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
* This class will fetch all pickup location Product services details
* @author Piyal
* */
public class GetPickupLocationProductServicesTest extends TestBase {

    private static final Logger LOG = LoggerFactory.getLogger(GetPickupLocationProductServicesTest.class);
    public static final String SERVICE_NAME = "getPickupLocationProductServices";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"regression","sanity","positive"},description = "GetPickupLocationProductServicesTest with all valid params")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = GetPickupLocationProductServicesTest.SERVICE_NAME, testName = "pickuplocationproductservice_valid_data_test", testGroup = "p0")
    public void getPickupLocationProductServices_test(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.SUPPLIER, GetPickupLocationProductServicesTest.SERVICE_NAME, TestBase.ENV, TestBase.TOKEN, data);
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Get Pickup Location Product Groups Test failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());

    }
}
