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
* This class will create the new Supplier Rep details
*  @author Piyal
*/

public class CreateSupplierRepTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateSupplierRepTest.class);
    public static final String SERVICE_NAME = "createSupplierRep";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"regression","sanity","positive"},description = "CreateSupplierRepTest with all valid params")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierTest.SERVICE_NAME, testName = "createSupplier", testGroup = "p0")
    public void createSupplier_test(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierTest.SERVICE_NAME, TestBase.ENV, data);
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Create supplier test() failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
}