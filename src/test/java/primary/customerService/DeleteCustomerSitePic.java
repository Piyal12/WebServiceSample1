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
 * This class will delete the Location images by using their ID
 *   @author Dharini H M
 */
public class DeleteCustomerSitePic extends TestBase {
    public static final Logger LOG = LoggerFactory.getLogger(DeleteCustomerSitePic.class);
    public static final String SERVICE_NAME = "deleteCustomerSitePic";

    //Pass all valid details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"positive","regression","sanity"},description = "Pass all valid details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER,serviceName = DeleteCustomerSitePic.SERVICE_NAME, testName = "deleteCustomerSitePic",testGroup = "p0")
    public void deleteCustomerSitePicTest(HashMap<String,String> data){
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.delete(ServiceGroup.CUSTOMER,DeleteCustomerSitePic.SERVICE_NAME,TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Failed to delete Site Pic");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
}