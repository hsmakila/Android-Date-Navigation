package com.example.akila.datenavigationbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomView extends LinearLayout {

    @StyleableRes
    int index0 = 0;
    @StyleableRes
    int index1 = 1;
    @StyleableRes
    int index2 = 2;

    TextView artistText;
    TextView trackText;
    Button buyButton;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.custom_view, this);

        int[] sets = {R.attr.artistText, R.attr.trackText, R.attr.buyButton};
        TypedArray typedArray = context.obtainStyledAttributes(attrs, sets);
        CharSequence artist = typedArray.getText(index0);
        CharSequence track = typedArray.getText(index1);
        CharSequence buyButton = typedArray.getText(index2);
        typedArray.recycle();

        initComponents();

        setArtistText(artist);
        setTrackText(track);
        setButton(buyButton);
    }

    private void initComponents() {
        artistText = findViewById(R.id.artist_Text);
        trackText = findViewById(R.id.track_Text);
        buyButton = findViewById(R.id.buy_Button);
        buyButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mONOnLoadingButtonClickListener != null)
                    mONOnLoadingButtonClickListener.onLoadingButtonClickListener("asdf");
            }
        });
    }

    public CharSequence getArtistText() {
        return artistText.getText();
    }

    public void setArtistText(CharSequence value) {
        artistText.setText(value);
    }

    public CharSequence getTrackText() {
        return trackText.getText();
    }

    public void setTrackText(CharSequence value) {
        trackText.setText(value);
    }

    public CharSequence getButton() {
        return buyButton.getText();
    }

    public void setButton(CharSequence value) {
        buyButton.setText(value);
    }

    public interface OnLoadingButtonClickListener {
        void onLoadingButtonClickListener(String title);
    }

    private OnLoadingButtonClickListener mONOnLoadingButtonClickListener;

    public void setOnLoadingClickListener(OnLoadingButtonClickListener onLoadingClickListener) {
        mONOnLoadingButtonClickListener = onLoadingClickListener;
    }

}