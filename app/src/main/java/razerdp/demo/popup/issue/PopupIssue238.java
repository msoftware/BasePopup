package razerdp.demo.popup.issue;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;

import androidx.annotation.Nullable;
import butterknife.BindView;
import razerdp.basepopup.BaseLazyPopupWindow;
import razerdp.basepopup.R;
import razerdp.demo.utils.ButterKnifeUtil;
import razerdp.demo.utils.UIHelper;

/**
 * Created by 大灯泡 on 2020/02/26.
 */
public class PopupIssue238 extends BaseLazyPopupWindow {
    private boolean isEdit;

    @Nullable
    @BindView(R.id.ed_input)
    EditText edInput;

    public PopupIssue238(Context context, boolean isEdit) {
        super(context);
        this.isEdit = isEdit;
    }

    @Override
    public void onViewCreated(View contentView) {
        ButterKnifeUtil.bind(this, contentView);
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.toast("点击ContentView");
            }
        });
        if (isEdit) {
            setAutoShowInputMethod(true);
            setAdjustInputMethod(true);
        }
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(isEdit ? R.layout.popup_issue_238_with_edittext : R.layout.popup_issue_238);
    }

    @Override
    protected Animation onCreateShowAnimation() {
        return getTranslateVerticalAnimation(1f, 0f, 500);
    }


    @Override
    protected Animation onCreateDismissAnimation() {
        return getTranslateVerticalAnimation(0f, 1f, 500);
    }
}
