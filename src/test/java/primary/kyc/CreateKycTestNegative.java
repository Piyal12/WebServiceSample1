package primary.kyc;

import com.google.gson.Gson;
import com.im.service.common.Annotation;
import com.im.service.common.DataConstraint;
import com.im.service.common.DataType;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;
import common.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
/*
*/

public class CreateKycTestNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateKycTestNegative.class);
    public static final String SERVICE_NAME = "createKyc";


    @Annotation.TestData(attributeName = "kyc_type",value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass numeric KYC Type to check if ID is created")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = CreateKycTestNegative.SERVICE_NAME, testName = "createKyc", testGroup = "p0",dataType = DataType.NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "kyc_type")
    public void passNumericValueKycType(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, CreateKycTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Create KYC failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
    @Annotation.TestData(attributeName = "kyc_type",value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Alphanumeric KYC Type to check if ID is created")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = CreateKycTestNegative.SERVICE_NAME, testName = "createKyc", testGroup = "p0",dataType = DataType.ALPHA_NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "kyc_type")
    public void passAlphaNumericValueKycType(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, CreateKycTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Create KYC failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Annotation.TestData(attributeName = "$identification_no",value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass numeric KYC ID to check if ID is created")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = CreateKycTestNegative.SERVICE_NAME, testName = "createKyc", testGroup = "p0",dataType = DataType.NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "identification_no")
    public void passNumericValueIdentificationType(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, CreateKycTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Create KYC failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Annotation.TestData(attributeName = "$identification_no",value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass alphanumeric KYC ID to check if ID is created")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = CreateKycTestNegative.SERVICE_NAME, testName = "createKyc", testGroup = "p0",dataType = DataType.ALPHA_NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "identification_no")
    public void passAlphaNumericValueIdentificationType(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, CreateKycTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Create KYC failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass null values to check if ID is created")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = CreateKycTestNegative.SERVICE_NAME, testName = "createKyc", testGroup = "p0",dataType = DataType.NULL, dataConstraint = DataConstraint.ONE_BY_ONE)
    public void passNullValue(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, CreateKycTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Create KYC failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass unassigned values to check if ID is created")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = CreateKycTestNegative.SERVICE_NAME, testName = "createKyc", testGroup = "p0",dataType = DataType.UNASSIGNED, dataConstraint = DataConstraint.ONE_BY_ONE)
    public void passUnassignedValue(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, CreateKycTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Create KYC failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

}
