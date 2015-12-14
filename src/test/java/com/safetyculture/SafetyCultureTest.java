package com.safetyculture;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.safetyculture.exception.SafetyCultureException;
import com.safetyculture.model.Audit;
import com.safetyculture.model.Results;
import com.safetyculture.net.RequestOptions;
import com.safetyculture.net.RequestOptions.RequestOptionsBuilder;

/**
 * Unit test for simple App.
 */
@SuppressWarnings("deprecation")
public class SafetyCultureTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SafetyCultureTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SafetyCultureTest.class );
    }

    /**
     * Test Get Audit Call
     */
    
	public void testGetAudit()
    {
        RequestOptions requestOptions = (new RequestOptionsBuilder()).setApiKey("f091b6e0325cb79372a14885c6e2890999fca92065bcea8b569aac6532743d0f").build();
        Map<String, Object> auditMap = new HashMap<String, Object>();
        auditMap.put(RequestOptions.AUDIT_ID,"audit_ddc93c387ca3483ea11b9fcd27dd5f8f");
        try {
            Audit audit=Audit.get(null,auditMap,requestOptions);
            Assert.assertNotNull(audit);
            Assert.assertEquals(audit.getAudit_id(), "audit_ddc93c387ca3483ea11b9fcd27dd5f8f");
        } catch (SafetyCultureException e) {
           // e.printStackTrace();
            fail();
        }
    }
	
	/**
     * Test Search Audit Call
     */
    
	public void testSearchAudit()
    {
        RequestOptions requestOptions = (new RequestOptionsBuilder()).setApiKey("f091b6e0325cb79372a14885c6e2890999fca92065bcea8b569aac6532743d0f").build();
        Map<String, Object> auditMap = new HashMap<String, Object>();
        List<String> values=new ArrayList<String>();
        values.add("audit_id");
        values.add("modified_at");
        auditMap.put("field",values);
        try {
            Results results=Audit.search(auditMap,null,requestOptions);
            Assert.assertNotNull(results);
            Assert.assertEquals(results.getCount(), 3);
        } catch (SafetyCultureException e) {
            e.printStackTrace();
            fail();
        }
    }


	/**
     * Test Get Media Audit Call
     */
    
	public void testGetMediaAudit()
    {
        RequestOptions requestOptions = (new RequestOptionsBuilder()).setApiKey("f091b6e0325cb79372a14885c6e2890999fca92065bcea8b569aac6532743d0f").build();
        Map<String, Object> pathParams = new HashMap<String, Object>();
        pathParams.put(RequestOptions.AUDIT_ID,"audit_20d402b0a98e43a68542574846c3bbe9");
        pathParams.put(RequestOptions.MEDIA_ID,"c7045a60-8bde-11e5-aa93-45aaaf188ddf");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("filepath", "test1.png");
        try {
        	Audit.getMedia(params,pathParams,requestOptions);
        	File file=new File("test1.png");
        	Assert.assertNotNull(file);
        } catch (SafetyCultureException e) {
            e.printStackTrace();
            fail();
        }
    }
}
