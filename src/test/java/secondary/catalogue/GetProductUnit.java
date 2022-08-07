package secondary.catalogue;

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

public class GetProductUnit extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(GetProductUnit. class);
    public static final String SERVICE_NAME = "getProductUnit";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass invalid product_alias_ids in query param")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CATALOG, serviceName = GetProductUnit.SERVICE_NAME, testName = "getProdUnitInvalidProdId", testGroup = "p1")
    public void getProdUnitInvalidProdId(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CATALOG, GetProductUnit.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
		LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
		Assert.assertEquals(rest.getStatus(), 400,
				"The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
	}
    

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass invalid customer_site_alias_id in query param")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CATALOG, serviceName = GetProductUnit.SERVICE_NAME, testName = "getProdUnitInvalidSiteId", testGroup = "p1")
    public void getProdUnitInvalidSiteId(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CATALOG, GetProductUnit.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
		LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
		Assert.assertEquals(rest.getStatus(), 400,
				"The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
	}
}


  
    

