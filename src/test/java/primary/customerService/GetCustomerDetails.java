package primary.customerService;

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
 * This class will fetch Customer details using Customer ID
 * @author Dharini H M
 */
public class GetCustomerDetails extends TestBase{
    private static final Logger LOG = LoggerFactory.getLogger(GetCustomerDetails. class);
    public static final String SERVICE_NAME = "getCustomerDetails";

    //Pass all valid details for query params
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"positive","regression","sanity"},description = "Pass all valid details for query params")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerDetails.SERVICE_NAME, testName = "getCustomerDetails", testGroup = "p0")
    public void getCustomerDetailsByIdTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerDetails.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "getting Customer details is failed");
    }
}