package com.ak.whatanimalareyou.model;

/**
 * Created by AK on 07/03/2017.
 */

public class Statement {

    private String mText;
    private int mMark;
    private int mImageId;

    public String getAnimal() {
        return mAnimal;
    }

    public void setAnimal(String animal) {
        mAnimal = animal;
    }

    private String mAnimal;
    private boolean mIsFinal;

    public Statement(){
        mText="";
        mMark =-1;
        mImageId=0;
        mAnimal="";
        mIsFinal=false;
    }
    public Statement(String text, int choice, int image, String animal, boolean isFinal){
        mText=text;
        mMark =choice;
        mImageId=image;
        mAnimal=animal;
        mIsFinal=isFinal;

    }
    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }



    public boolean isFinal() {
        return mIsFinal;
    }

    public void setFinal(boolean aFinal) {
        mIsFinal = aFinal;
    }



    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getMark() {
        return mMark;
    }

    public void setMark(int mark) {
        mMark = mark;
    }
    @Override
    public String toString(){
        return mText;
    }
}
