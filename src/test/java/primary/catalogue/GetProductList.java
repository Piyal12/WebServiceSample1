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


public class GetProductList extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(GetProductList. class);
    public static final String SERVICE_NAME = "getProductList";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"positive","sanity","regression"},description = "Pass valid product_group_alias id and customer_site_alias_id")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CATALOG, serviceName = GetProductList.SERVICE_NAME, testName = "getProdList", testGroup = "p0")
    public void getProdListTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CATALOG, GetProductList.SERVICE_NAME, TestBase.ENV,data);
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "getting product list failed");
    }
}


