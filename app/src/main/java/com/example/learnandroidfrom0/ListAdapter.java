package com.example.learnandroidfrom0;

/**
 * Created by Bich Hoang on 12/15/2020.
 */
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<String> {
    customButtonListener customListner;

    public interface customButtonListener {
        public void onButtonClickListner(int position,String value);
    }

    public void setCustomButtonListner(customButtonListener listener) {
        this.customListner = listener;
    }

    private Context context;
    private ArrayList<String> data = new ArrayList<String>();

    public ListAdapter(Context context, ArrayList<String> dataItem) {
        super(context, R.layout.layout_item, dataItem);
        this.data = dataItem;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.layout_item, null);
            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) convertView
                    .findViewById(R.id.childTextView);
            viewHolder.button = (Button) convertView
                    .findViewById(R.id.childButton);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final String temp = getItem(position);
        viewHolder.text.setText(temp);
        viewHolder.button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (customListner != null) {
                    customListner.onButtonClickListner(position,temp);
                }

            }
        });

        return convertView;
    }

    public class ViewHolder {
        TextView text;
        Button button;
    }
}
