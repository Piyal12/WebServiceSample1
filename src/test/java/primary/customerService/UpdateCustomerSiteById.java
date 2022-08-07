package primary.customerService;

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
 * This class will update customer Site for a particular site ID
 * @author Dharini H M
 */
public class UpdateCustomerSiteById extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(UpdateCustomerSiteById.class);
    public static final String SERVICE_NAME = "updateCustomerSiteById";

    //Pass all valid details for Edit customer site
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"positive","regression","sanity"},description = "Pass all valid details for Edit customer Office")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = UpdateCustomerSiteById.SERVICE_NAME, testName = "updateCustomerSiteById", testGroup = "p0")
    public void updateCustomerSiteByIdTest(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.put(ServiceGroup.CUSTOMER,UpdateCustomerSiteById.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Failed to edit customer site");
    }
}