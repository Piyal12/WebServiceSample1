package primary.customerService;

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
 * This class will create customer Representative
 * @author Dharini H M
 */
public class CreateCustomerRepresentative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateCustomerRepresentative. class);
    public static final String SERVICE_NAME = "createCustomerRepresentative";

    //Pass all valid details in request body
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"positive","regression","sanity"},description = "Pass all valid details in request body")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = CreateCustomerRepresentative.SERVICE_NAME, testName = "createCustomerRepresentative", testGroup = "p0",
            attributeName = "phoneNumber",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NUMERIC)
    public void createCustomerRepresentativeTest(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.CUSTOMER, CreateCustomerRepresentative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Failed to create customer representative");
    }
}