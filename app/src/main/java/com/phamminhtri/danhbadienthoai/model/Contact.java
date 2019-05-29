package com.phamminhtri.danhbadienthoai.model;

public class Contact {
    private boolean mAvatar;
    private String mName;
    private String mNumber;

    public Contact(boolean mAvatar, String mName, String mNumber) {
        this.mAvatar = mAvatar;
        this.mName = mName;
        this.mNumber = mNumber;
    }

    public boolean ismAvatar() {
        return mAvatar;
    }

    public void setmAvatar(boolean mAvatar) {
        this.mAvatar = mAvatar;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }
}
