package secondary.credit;

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

public class GetCreditApplicationDetailsByIdTest extends TestBase
{
    private static final Logger LOG = LoggerFactory.getLogger(GetCreditApplicationDetailsByIdTest.class);
    public static final String SERVICE_NAME = "creditapplicationdetailsId";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass wrong HTTP method(DELETE) for get credit application details by ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditApplicationDetailsByIdTest.SERVICE_NAME,testName = "credit_details_by_id", testGroup = "p0")
    public void wrong_http_method(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.delete(ServiceGroup.CREDIT, GetCreditApplicationDetailsByIdTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }
}
