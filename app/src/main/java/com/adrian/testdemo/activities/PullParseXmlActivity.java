package com.adrian.testdemo.activities;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.adrian.testdemo.R;
import com.adrian.testdemo.models.ErrorXmlBean;
import com.adrian.testdemo.models.IdentityXmlBean;
import com.adrian.testdemo.tools.XmlPullParseUtil;

import java.io.IOException;
import java.io.InputStream;

public class PullParseXmlActivity extends AppCompatActivity {

    private TextView mErrorTV;
    private TextView mIdentityTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_parse_xml);
        mErrorTV = (TextView) findViewById(R.id.tv_error);
        mIdentityTV = (TextView) findViewById(R.id.tv_identity);

        parseError();
        parseIdentity();
    }

    private void parseError() {
        AssetManager am = getAssets();
        try {
            InputStream is = am.open("xml/error.xml");
            ErrorXmlBean errorXmlBean = XmlPullParseUtil.parseError(is);
            mErrorTV.setText("ErrorXml:" + errorXmlBean.toString());
            Log.e("ERROR:", errorXmlBean.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseIdentity() {
        AssetManager am = getAssets();
        try {
            InputStream is = am.open("xml/identity.xml");
            IdentityXmlBean identityXmlBean = XmlPullParseUtil.parseIdentityInfo(is);
            mIdentityTV.setText("IdentityInfo:" + identityXmlBean.toString());
            Log.e("Identity:", identityXmlBean.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
