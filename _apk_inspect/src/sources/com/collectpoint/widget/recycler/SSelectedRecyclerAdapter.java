package com.collectpoint.widget.recycler;

import android.app.Activity;
import com.collectpoint.widget.recycler.SSelectable;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public abstract class SSelectedRecyclerAdapter<T extends SSelectable> extends SSimpleRecyclerAdapter<T> {
    protected SelectedMode mode;

    /* renamed from: com.collectpoint.widget.recycler.SSelectedRecyclerAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$collectpoint$widget$recycler$SSelectedRecyclerAdapter$SelectedMode;

        static {
            int[] iArr = new int[SelectedMode.values().length];
            $SwitchMap$com$collectpoint$widget$recycler$SSelectedRecyclerAdapter$SelectedMode = iArr;
            try {
                iArr[SelectedMode.SINGLE_MUST_ONE_SELECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$collectpoint$widget$recycler$SSelectedRecyclerAdapter$SelectedMode[SelectedMode.MULTI_MUST_ONE_SELECTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$collectpoint$widget$recycler$SSelectedRecyclerAdapter$SelectedMode[SelectedMode.SINGLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$collectpoint$widget$recycler$SSelectedRecyclerAdapter$SelectedMode[SelectedMode.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public enum SelectedMode {
        SINGLE_MUST_ONE_SELECTED,
        SINGLE,
        MULTI_MUST_ONE_SELECTED,
        MULTI
    }

    public SSelectedRecyclerAdapter(Activity activity) {
        super(activity);
        this.mode = SelectedMode.SINGLE;
    }

    private void onMustOneSeleced(List<T> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        switch (AnonymousClass1.$SwitchMap$com$collectpoint$widget$recycler$SSelectedRecyclerAdapter$SelectedMode[this.mode.ordinal()]) {
            case 1:
                list.get(0).setSelected(true);
                break;
            case 2:
                list.get(0).setSelected(true);
                break;
        }
    }

    private void selectItemMulti(int i) {
        getItem(i).setSelected(!getItem(i).isSelected());
        notifyDataSetChanged();
    }

    private void selectItemMultiMustOne(int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < getCount(); i4++) {
            if (getItem(i4).isSelected()) {
                i3 = i4;
                i2++;
            }
        }
        if (i2 == 1 && i == i3) {
            return;
        }
        getItem(i).setSelected(true ^ getItem(i).isSelected());
        notifyDataSetChanged();
    }

    private void selectItemSingle(int i) {
        for (int i2 = 0; i2 < getCount(); i2++) {
            if (i2 != i) {
                getItem(i2).setSelected(false);
            } else {
                getItem(i2).setSelected(!getItem(i2).isSelected());
            }
        }
        notifyDataSetChanged();
    }

    private void selectItemSingleMustOne(int i) {
        if (getItem(i).isSelected()) {
            return;
        }
        cleanAllSelected();
        getItem(i).setSelected(true);
        notifyDataSetChanged();
    }

    public void cleanAllSelected() {
        if (getList() == null) {
            return;
        }
        Iterator<T> it = getList().iterator();
        while (it.hasNext()) {
            it.next().setSelected(false);
        }
        notifyDataSetChanged();
    }

    public void cleanAllSelected(List<T> list) {
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            it.next().setSelected(false);
        }
    }

    public int getSelectedCount() {
        int i = 0;
        if (getList() != null) {
            Iterator<T> it = getList().iterator();
            while (it.hasNext()) {
                if (it.next().isSelected()) {
                    i++;
                }
            }
        }
        return i;
    }

    public boolean isSelectAllSelected() {
        boolean z = false;
        if (getList() != null) {
            Iterator<T> it = getList().iterator();
            while (it.hasNext()) {
                if (!it.next().isSelected()) {
                    z = true;
                }
            }
        }
        return !z;
    }

    public void selectAllSelected() {
        if (getList() != null) {
            Iterator<T> it = getList().iterator();
            while (it.hasNext()) {
                it.next().setSelected(true);
            }
        }
        notifyDataSetChanged();
    }

    public void selectItem(int i) {
        switch (AnonymousClass1.$SwitchMap$com$collectpoint$widget$recycler$SSelectedRecyclerAdapter$SelectedMode[this.mode.ordinal()]) {
            case 1:
                selectItemSingleMustOne(i);
                break;
            case 2:
                selectItemMultiMustOne(i);
                break;
            case 3:
                selectItemSingle(i);
                break;
            case 4:
                selectItemMulti(i);
                break;
        }
    }

    @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
    public void setData(List<T> list) {
        onMustOneSeleced(list);
        super.setData(list);
    }

    @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
    public void setData(List<T> list, int i) {
        onMustOneSeleced(list);
        super.setData(list, i);
    }

    public void setDataClear(List<T> list) {
        cleanAllSelected(list);
        onMustOneSeleced(list);
        super.setData(list);
    }

    public void setMode(SelectedMode selectedMode) {
        this.mode = selectedMode;
    }
}
