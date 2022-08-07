package secondary.catalogue;

import java.io.File;
import java.util.HashMap;

import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.im.service.common.Annotation;
import com.im.service.common.DataConstraint;
import com.im.service.common.DataType;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;

import common.TestBase;
import io.restassured.module.jsv.JsonSchemaValidator;


public class GetProductList extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(GetProductList. class);
    public static final String SERVICE_NAME = "getProductList";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass invalid product_group_alias_id in the query params")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CATALOG, serviceName = GetProductList.SERVICE_NAME, testName = "getProdListInvalidGrpIdTest", testGroup = "p1")
    public void getProdListInvalidGrpIdTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CATALOG, GetProductList.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
		LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
		Assert.assertEquals(rest.getStatus(), 200,
				"The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
		Assert.assertEquals(rest.getResponse().body().jsonPath().getString("data"), null, "get prod list failed");
	}
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass product_group_alias_id as null value")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CATALOG, serviceName = GetProductList.SERVICE_NAME, testName = "getProdListNullGrpIdTest", testGroup = "p1",
    		attributeName = "prodGrpID",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NULL)
    public void getProdListNullGrpIdTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CATALOG, GetProductList.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
		LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
		Assert.assertEquals(rest.getStatus(), 400,
				"The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
	}

}


