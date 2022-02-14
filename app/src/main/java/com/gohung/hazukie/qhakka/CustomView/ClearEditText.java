package com.gohung.hazukie.qhakka.CustomView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.gohung.hazukie.qhakka.R;

public class ClearEditText extends androidx.appcompat.widget.AppCompatEditText implements View.OnTouchListener,View.OnFocusChangeListener, TextWatcher {

    private Drawable mClearTextIcon;
    private OnFocusChangeListener mOnFocusChangeListener;
    private OnTouchListener mOnTouchListener;

    public ClearEditText(final Context context) {
        super(context);
    }
    public ClearEditText(final Context context, final AttributeSet attrs){
        super(context,attrs);
        init(context);
    }

    public ClearEditText(final Context context,final AttributeSet attrs, final int defStyleAttr){
        super(context,attrs,defStyleAttr);
        init(context);
    }


    private void init(final Context context){
        final Drawable drawable= ContextCompat.getDrawable(context, R.drawable.icon_app_close);
        final Drawable wrappedDrawable= DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrappedDrawable,getCurrentHintTextColor());
        mClearTextIcon=wrappedDrawable;
        mClearTextIcon.setBounds(0,0,mClearTextIcon.getIntrinsicHeight(),mClearTextIcon.getIntrinsicHeight());
        setClearIconVisible(false);
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }


    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener l){
        mOnFocusChangeListener=l;
    }

    @Override
    public void setOnTouchListener(OnTouchListener lk){
        mOnTouchListener=lk;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
     if(hasFocus()) setClearIconVisible(getText().length()>0);
     else setClearIconVisible(false);

     if(mOnFocusChangeListener!=null) mOnFocusChangeListener.onFocusChange(view,hasFocus());

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        final int x=(int) motionEvent.getX();
        if(mClearTextIcon.isVisible()&&x>getWidth()-getPaddingRight()-mClearTextIcon.getIntrinsicWidth()){
            if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                setError(null);
                setText("");
            }
            return true;
        }
        return mOnTouchListener!=null&&mOnTouchListener.onTouch(view,motionEvent);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(isFocused()){
                setClearIconVisible(charSequence.length()>0);
            }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    private void setClearIconVisible(final boolean visible){
        mClearTextIcon.setVisible(visible,false);
        final Drawable[] compoundDrawables=getCompoundDrawables();
        setCompoundDrawables(
                compoundDrawables[0],
                compoundDrawables[1],
                visible?mClearTextIcon:null,
                compoundDrawables[3]
        );
    }


}
