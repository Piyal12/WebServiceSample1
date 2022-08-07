package primary.catalogue;

import java.io.File;
import java.util.HashMap;

import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.im.service.common.Annotation;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider; 
import com.im.service.util.ws.Ws;

import common.TestBase;
import io.restassured.module.jsv.JsonSchemaValidator;

public class AddProductGroups extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(AddProductGroups.class);
    public static final String SERVICE_NAME = "addProductGroups";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"positive","sanity","regression"},description = "Pass valid  product_group_name and product_category_alias_id in the body")  
    @Annotation.TestRun(serviceGroup = ServiceGroup.CATALOG, serviceName = AddProductGroups.SERVICE_NAME, testName = "addProdGroups", testGroup = "p0")
    public void addProductGrpTest(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.CATALOG, AddProductGroups.SERVICE_NAME, TestBase.ENV, data,TestBase.TOKEN);
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Add Product groups() failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
}
