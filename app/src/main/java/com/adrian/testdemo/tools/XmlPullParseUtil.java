package com.adrian.testdemo.tools;

import com.adrian.testdemo.models.ErrorXmlBean;
import com.adrian.testdemo.models.IdentityXmlBean;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qing on 2017/9/30 0030.
 */

public class XmlPullParseUtil {

    public static ErrorXmlBean parseError(InputStream errorInput) {
        ErrorXmlBean errorBean = null;
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser pullParser = factory.newPullParser();
            pullParser.setInput(errorInput, "UTF-8");
            int eventType = pullParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        errorBean = new ErrorXmlBean();
                        break;
                    case XmlPullParser.START_TAG:
                        String name = pullParser.getName();
                        if ("Code".equals(name)) {
                            errorBean.setCode(pullParser.nextText());
                        }
                        if ("Timestamp".equals(name)) {
                            errorBean.setTimestamp(pullParser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                eventType = pullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return errorBean;
    }

    public static IdentityXmlBean parseIdentityInfo(InputStream errorInput) {
        IdentityXmlBean identityXmlBean = null;
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser pullParser = factory.newPullParser();
            pullParser.setInput(errorInput, "UTF-8");
            int eventType = pullParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        identityXmlBean = new IdentityXmlBean();
                        break;
                    case XmlPullParser.START_TAG:
                        String name = pullParser.getName();
                        if ("AccountID".equals(name)) {
                            identityXmlBean.setAccountId(pullParser.nextText());
                        }
                        if ("Username".equals(name)) {
                            identityXmlBean.setUserName(pullParser.nextText());
                        }
                        if ("DeviceID".equals(name)) {
                            identityXmlBean.setDeviceId(pullParser.nextText());
                        }
                        if ("verified".equals(name)) {
                            identityXmlBean.setVerified(pullParser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                eventType = pullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return identityXmlBean;
    }
}
