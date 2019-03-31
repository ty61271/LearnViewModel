package com.example.learnviewmodel.views;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.learnviewmodel.R;
import com.example.learnviewmodel.models.Todo;

public class TodoView extends ConstraintLayout {
    private CheckBox completeCheckBox;
    private TextView descriptionView;

    public TodoView(Context context) {
        super(context);
    }

    public TodoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TodoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView(Todo todo) {
        completeCheckBox = findViewById(R.id.completeCheckBox);
        descriptionView = findViewById(R.id.descriptionView);

        descriptionView.setText(todo.getDescription());
        completeCheckBox.setChecked(todo.isComplete());
        if (todo.isComplete()) {
            creatStrikeThough();
        }

        setCheckStateListener();
    }

    private void setCheckStateListener() {
        completeCheckBox.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if (isChecked) {
                creatStrikeThough();
            } else {
                removeStrikeThough();
            }
        }));
    }

    private void creatStrikeThough() {
        descriptionView.setPaintFlags(descriptionView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

    }

    private void removeStrikeThough() {
        descriptionView.setPaintFlags(descriptionView.getPaintFlags() & ~(Paint.STRIKE_THRU_TEXT_FLAG));
    }
}
