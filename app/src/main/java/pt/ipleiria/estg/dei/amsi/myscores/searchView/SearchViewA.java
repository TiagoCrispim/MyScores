package pt.ipleiria.estg.dei.amsi.myscores.searchView;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.CollapsibleActionView;
import android.widget.LinearLayout;

public class SearchViewA extends LinearLayout implements CollapsibleActionView {
    public SearchViewA(Context context) {
        super(context);
    }

    public SearchViewA(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SearchViewA(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SearchViewA(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onActionViewExpanded() {

    }

    @Override
    public void onActionViewCollapsed() {

    }
}
