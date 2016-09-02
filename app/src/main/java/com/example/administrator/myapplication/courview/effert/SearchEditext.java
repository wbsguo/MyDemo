package com.example.administrator.myapplication.courview.effert;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

/**
 */
public class SearchEditext extends FrameLayout implements TextWatcher, OnClickListener, View.OnFocusChangeListener {
    private EditText editText;
    private TextView cancel, delContent;
    private TextWatcher textWatcher;

    public SearchEditext(Context context) {
        this(context, null);
    }

    public SearchEditext(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchEditext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.edittext_search, null);
        addView(v);
        editText = (EditText) v.findViewById(R.id.search_content);
        cancel = (TextView) v.findViewById(R.id.cancel);
        delContent = (TextView) v.findViewById(R.id.del_content);
        editText.addTextChangedListener(this);
        cancel.setOnClickListener(this);
        delContent.setOnClickListener(this);
        editText.setOnFocusChangeListener(this);
    }
    public void setHint(String hintText){
        editText.setHint(hintText);
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if (textWatcher != null) {
            textWatcher.beforeTextChanged(s, start, count, after);
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (textWatcher != null) {
            textWatcher.onTextChanged(s, start, before, count);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        final String string = s.toString().trim();
        if (TextUtils.isEmpty(string)) {
            delContent.setVisibility(GONE);
        } else {
            delContent.setVisibility(VISIBLE);
            cancel.setVisibility(VISIBLE);
        }
        if (textWatcher != null) {
            textWatcher.afterTextChanged(s);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == cancel) {
            editText.setText("");
            hideKeybord(editText);
//            editText.clearFocus();
            delContent.setVisibility(GONE);
            cancel.setVisibility(GONE);
        } else if (v == delContent) {
            editText.setText("");
            delContent.setVisibility(GONE);
        }
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        this.textWatcher = textWatcher;
    }

    public void onPause() {
        hideKeybord(editText);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v == editText && hasFocus) {
            cancel.setVisibility(VISIBLE);
        }
    }
    /**
     * 隐藏键盘
     */
    public void hideKeybord(EditText editText) {
        editText.clearFocus();
        InputMethodManager imm = (InputMethodManager) editText.getContext().
                getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
