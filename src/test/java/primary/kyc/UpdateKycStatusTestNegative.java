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

public class UpdateKycStatusTestNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(UpdateKycStatusTestNegative.class);
    public static final String SERVICE_NAME = "updateKycStatus";

    @Annotation.TestData(attributeName = "kyc_id",value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Numeric kyc ID to check if the ID is updated")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = UpdateKycStatusTestNegative.SERVICE_NAME, testName = "updateKycStatus", testGroup = "p0",dataType = DataType.NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "kyc_id")
    public void passNumericKycId(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, UpdateKycStatusTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Update KYC Status failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
    @Annotation.TestData(attributeName = "kyc_id",value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass alphanumeric kyc ID to check if the ID is updated")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = UpdateKycStatusTestNegative.SERVICE_NAME, testName = "updateKycStatus", testGroup = "p0",dataType = DataType.ALPHA_NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "kyc_id")
    public void passAlphaNumericKycId(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, UpdateKycStatusTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Update KYC Status failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Annotation.TestData(attributeName = "status",value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Numeric status to check if the ID is updated")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = UpdateKycStatusTestNegative.SERVICE_NAME, testName = "updateKycStatus", testGroup = "p0",dataType = DataType.NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "kyc_id")
    public void passNumericStatus(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, UpdateKycStatusTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Update KYC Status failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Annotation.TestData(attributeName = "kyc_id",value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass alphaNumeric status to check if the ID is updated")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = UpdateKycStatusTestNegative.SERVICE_NAME, testName = "updateKycStatus", testGroup = "p0",dataType = DataType.NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "kyc_id")
    public void passAlphaNumericStatus(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, UpdateKycStatusTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Update KYC Status failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass null values to check if the ID is updated")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = UpdateKycStatusTestNegative.SERVICE_NAME, testName = "updateKycStatus", testGroup = "p0",dataType = DataType.NULL, dataConstraint = DataConstraint.ONE_BY_ONE, attributeName = "kyc_id")
    public void passNullValue(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, UpdateKycStatusTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Update KYC Status failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Unassigned values to check if the ID is updated")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = UpdateKycStatusTestNegative.SERVICE_NAME, testName = "updateKycStatus", testGroup = "p0",dataType = DataType.UNASSIGNED, dataConstraint = DataConstraint.ONE_BY_ONE)
    public void passUnassignedValue(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, UpdateKycStatusTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Update KYC Status failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

}
