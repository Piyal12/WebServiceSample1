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

public class UpdateCreditInfoTest extends TestBase
{
    private static final Logger LOG = LoggerFactory.getLogger(UpdateCreditInfoTest.class);
    public static final String SERVICE_NAME = "creditInfo";

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass total credit limit with special characters for update credit info by ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateCreditInfoTest.SERVICE_NAME, testName="total_credit_with_special_character", testGroup="p0")
    public void total_credit_with_special_character (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.put(ServiceGroup.CREDIT, UpdateCreditInfoTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass invalid data type for total credit limit for update credit info by ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateCreditInfoTest.SERVICE_NAME, testName="invalid_total_credit_datatype", testGroup="p0")
    public void invalid_total_credit_datatype (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.put(ServiceGroup.CREDIT, UpdateCreditInfoTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "PPass invalid data for total credit limit for update credit info by ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateCreditInfoTest.SERVICE_NAME, testName="blank_total_credit", testGroup="p0")
    public void blank_total_credit (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.put(ServiceGroup.CREDIT, UpdateCreditInfoTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass invalid data type for available credit limit for update credit info by ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateCreditInfoTest.SERVICE_NAME, testName="invalid_available_credit_datatype", testGroup="p0")
    public void invalid_available_credit_datatype (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.put(ServiceGroup.CREDIT, UpdateCreditInfoTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass invalid data for available credit limit for update credit info by ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateCreditInfoTest.SERVICE_NAME, testName="blank_available_credit", testGroup="p0")
    public void blank_available_credit (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.put(ServiceGroup.CREDIT, UpdateCreditInfoTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass wrong HTTP method(POST) for update credit info by ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateCreditInfoTest.SERVICE_NAME, testName="creditinfo", testGroup="p0")
    public void wrong_http_method (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, UpdateCreditInfoTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is "+405+". But actual is "+rest.getStatus()+".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

}
