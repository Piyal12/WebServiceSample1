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


public class AddProductGroups extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(AddProductGroups.class);
    public static final String SERVICE_NAME = "addProductGroups";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass null value for product_group_name in the body")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CATALOG, serviceName = AddProductGroups.SERVICE_NAME, testName = "addProdGroupsNameNullTest", testGroup = "p1",
    		attributeName = "productGroupName",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NULL)
    public void addProdGroupsNameNullTest(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.CATALOG, AddProductGroups.SERVICE_NAME, TestBase.ENV, data,TestBase.TOKEN);
       

		LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
		LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
		Assert.assertEquals(rest.getStatus(), 400,
				"The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
	}
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass invalid Product_category_alias_id in the body")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CATALOG, serviceName = AddProductGroups.SERVICE_NAME, testName = "addProdGroupsInvalidIdTest", testGroup = "p1")
    public void addProdGroupsInvalidIdTest(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.CATALOG, AddProductGroups.SERVICE_NAME, TestBase.ENV, data,TestBase.TOKEN);
       

		LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
		LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
		Assert.assertEquals(rest.getStatus(), 400,
				"The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
	}
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass null value for Product_category_alias_id in the body")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CATALOG, serviceName = AddProductGroups.SERVICE_NAME, testName = "addProdGroupsNullIdTest", testGroup = "p1",
    		attributeName = "productGroupName",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NULL)
    public void addProdGroupsNullIdTest(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.CATALOG, AddProductGroups.SERVICE_NAME, TestBase.ENV, data,TestBase.TOKEN);
       

		LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
		LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
		Assert.assertEquals(rest.getStatus(), 400,
				"The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
	}
}


