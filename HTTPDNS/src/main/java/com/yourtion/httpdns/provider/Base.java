package com.yourtion.httpdns.provider;

import com.yourtion.httpdns.Record;

/**
 * Created by Yourtion on 24/10/2016.
 */

abstract class Base {

    abstract Record parseResult(String data);
    abstract String getRequestString(String domain);

    private HTTPClient mClient = new HTTPClient();

    public Record requestRecord(String domain) {
        String url = getRequestString(domain);
        try {
            String result = this.mClient.get(url);
            return parseResult(result);
        } catch (Exception e) {
            return null;
        }
    }

}
