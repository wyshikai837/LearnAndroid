package com.sky.reviewandroid;

import android.os.Parcel;
import android.os.Parcelable;

public class MessageBean implements Parcelable {

    private String content;
    private int level;

    public MessageBean() {
    }

    public MessageBean(String content, int level) {
        this.content = content;
        this.level = level;
    }

    public MessageBean(Parcel source) {
        this.content = source.readString();
        this.level = source.readInt();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.content);
        dest.writeInt(this.level);
    }

    public void readFromParcel(Parcel source) {
        this.content = source.readString();
        this.level = source.readInt();
    }

    public static final Creator<MessageBean> CREATOR = new Creator<MessageBean>() {
        @Override
        public MessageBean createFromParcel(Parcel source) {
            return new MessageBean(source);
        }

        @Override
        public MessageBean[] newArray(int size) {
            return new MessageBean[size];
        }
    };

    @Override
    public String toString() {
        return "MessageBean{" +
                "content='" + content + '\'' +
                ", level=" + level +
                '}';
    }
}
