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
* This class will add kyc to the Supplier
*  @author Yashas
*/

public class AddSupplierKycTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(AddSupplierKycTest.class);
    public static final String SERVICE_NAME = "addSupplierKyc";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"regression","sanity","positive"},description = "AddSupplierKycTest with all valid params")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = AddSupplierKycTest.SERVICE_NAME, testName = "addSupplierKyc", testGroup = "p0")
    public void addSupplierKyc_test(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, AddSupplierKycTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Add Supplier Kyc test() failed");
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
}
