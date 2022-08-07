package secondary.catalogue;

import java.io.File;
import java.util.HashMap;

import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.im.service.common.Annotation;
import com.im.service.common.Annotation.TestRun;
import com.im.service.common.DataConstraint;
import com.im.service.common.DataType;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;

import common.TestBase;
import io.restassured.module.jsv.JsonSchemaValidator;

public class AddProductCategory extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(AddProductCategory.class);
    public static final String SERVICE_NAME = "addProductCategory";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass null value for product_category_name in the body")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CATALOG, serviceName = AddProductCategory.SERVICE_NAME, testName = "addProdCategoryNullTest", testGroup = "p1",
    		attributeName = "productCategoryName",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NULL)
    public void addProdCategoryNullTest(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.CATALOG, AddProductCategory.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
		LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
		Assert.assertEquals(rest.getStatus(), 400,
				"The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
		
	}
}
