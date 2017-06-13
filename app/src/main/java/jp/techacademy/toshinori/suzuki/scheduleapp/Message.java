package jp.techacademy.toshinori.suzuki.scheduleapp;

import java.io.Serializable;

/**
 * Created by Tony on 2017/06/08.
 */

public class Message implements Serializable {
    private String mMessageid;
    private String mAuthor;
    private String mContents;

    public Message(String messageid, String author, String contents) {
        mMessageid = messageid;
        mAuthor = author;
        mContents = contents;
    }

    public String getmMessageid() {
        return mMessageid;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmContents() {
        return mContents;
    }

}
