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

public class CreateCreditApplicationEnterpriseTest extends TestBase
{
    private static final Logger LOG = LoggerFactory.getLogger(CreateCreditApplicationEnterpriseTest.class);
    public static final String SERVICE_NAME = "creditEnterprise";

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid customer alias ID for create credit application enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = CreateCreditApplicationEnterpriseTest.SERVICE_NAME, testName="invalid_customer_alias_id", testGroup="p0")
    public void invalid_customer_alias_id (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, CreateCreditApplicationEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid customer rep alias ID for create credit application enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = CreateCreditApplicationEnterpriseTest.SERVICE_NAME, testName="invalid_customer_rep_alias_id", testGroup="p0")
    public void invalid_customer_rep_alias_id (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, CreateCreditApplicationEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass credit group name as retailer for create credit application enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = CreateCreditApplicationEnterpriseTest.SERVICE_NAME, testName="group_name_retailer", testGroup="p0")
    public void group_name_retailer (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, CreateCreditApplicationEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is "+500+". But actual is "+rest.getStatus()+".");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass KYC ID as blank for create credit application enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = CreateCreditApplicationEnterpriseTest.SERVICE_NAME, testName="blank_KYC_id", testGroup="p0")
    public void blank_KYC_id (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, CreateCreditApplicationEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass invalid data type for all integer values for create credit application enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = CreateCreditApplicationEnterpriseTest.SERVICE_NAME, testName="inavlid_data_type", testGroup="p0")
    public void inavlid_data_type (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, CreateCreditApplicationEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass KYC ID with special characters for create credit application enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = CreateCreditApplicationEnterpriseTest.SERVICE_NAME, testName="special_characted_kyc_id", testGroup="p0")
    public void special_characted_kyc_id (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, CreateCreditApplicationEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass all Mandatory fields as empty for create credit application enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = CreateCreditApplicationEnterpriseTest.SERVICE_NAME, testName="mandatory_fields_empty", testGroup="p0")
    public void mandatory_fields_empty (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, CreateCreditApplicationEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass wrong HTTP method(GET) for create credit application enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = CreateCreditApplicationEnterpriseTest.SERVICE_NAME, testName="create_credit_enterprise", testGroup="p0")
    public void wrong_http_method (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, CreateCreditApplicationEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
    }
}
