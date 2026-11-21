package com.collectpoint.moudle.binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.collectpoint.MyApp;
import com.collectpoint.bean.Picker;
import com.collectpoint.bean.item.AlbumItem;
import com.collectpoint.databinding.ItemPictureBinding;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.PictureUtils;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.api.ImageCameraWrapper;
import com.yanzhenjie.album.api.ImageSingleWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.drakeet.multitype.ItemViewBinder;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class PictureTypeBinder extends ItemViewBinder<AlbumItem, ViewHolder> {
    private int MAX_PICTURE;
    private OnPictureClickListener listener;
    private ArrayList<AlbumFile> mAlbumList;
    private int mHeight;
    private boolean mIsHideDelete;
    private List<Picker> mList;
    private PictureBinderOnClickListener mListener;
    private List<List<Picker>> mLists;
    private String mState;
    private int mWidth;

    public interface OnPictureClickListener {
        void onPictureSuccess(String str, String str2, String str3, String str4);
    }

    public interface PictureBinderOnClickListener {
        void Picture(List<AlbumItem> list);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemPictureBinding mBinding;

        ViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.mBinding = (ItemPictureBinding) viewDataBinding;
        }
    }

    public PictureTypeBinder(boolean z) {
        this.MAX_PICTURE = 3;
        this.mState = "";
        this.mIsHideDelete = z;
        this.mWidth = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mHeight = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
    }

    public PictureTypeBinder(boolean z, int i, OnPictureClickListener onPictureClickListener) {
        this.MAX_PICTURE = 3;
        this.mState = "";
        this.mIsHideDelete = z;
        this.MAX_PICTURE = i;
        this.listener = onPictureClickListener;
        this.mWidth = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mHeight = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mAlbumList = new ArrayList<>();
    }

    public PictureTypeBinder(boolean z, int i, String str, OnPictureClickListener onPictureClickListener) {
        this.MAX_PICTURE = 3;
        this.mState = "";
        this.mIsHideDelete = z;
        this.MAX_PICTURE = i;
        this.mState = str;
        this.listener = onPictureClickListener;
        this.mWidth = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mHeight = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mAlbumList = new ArrayList<>();
    }

    public PictureTypeBinder(boolean z, int i, String str, List<Picker> list, List<List<Picker>> list2, OnPictureClickListener onPictureClickListener) {
        this.MAX_PICTURE = 3;
        this.mState = "";
        this.mIsHideDelete = z;
        this.MAX_PICTURE = i;
        this.mState = str;
        this.mList = list;
        this.mLists = list2;
        this.listener = onPictureClickListener;
        this.mWidth = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mHeight = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mAlbumList = new ArrayList<>();
    }

    public PictureTypeBinder(boolean z, int i, List<Picker> list) {
        this.MAX_PICTURE = 3;
        this.mState = "";
        this.mIsHideDelete = z;
        this.MAX_PICTURE = i;
        this.mList = list;
        this.mWidth = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mHeight = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mAlbumList = new ArrayList<>();
    }

    public PictureTypeBinder(boolean z, int i, List<Picker> list, List<List<Picker>> list2, OnPictureClickListener onPictureClickListener) {
        this.MAX_PICTURE = 3;
        this.mState = "";
        this.mIsHideDelete = z;
        this.MAX_PICTURE = i;
        this.mList = list;
        this.mLists = list2;
        this.listener = onPictureClickListener;
        this.mWidth = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mHeight = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mAlbumList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickAdd(final AlbumItem albumItem, Context context, final String str, final String str2, boolean z) {
        if (z) {
            ((ImageSingleWrapper) Album.image(context).singleChoice()).widget(PictureUtils.getAlbumUI(context, 2131820959)).camera(false).columnCount(4).afterFilterVisibility(true).onResult(new Action<ArrayList<AlbumFile>>() { // from class: com.collectpoint.moudle.binder.PictureTypeBinder.1
                public void onAction(int i, ArrayList<AlbumFile> arrayList) {
                    if (arrayList.size() > 0) {
                        String path = arrayList.get(0).getPath();
                        if (PictureTypeBinder.this.listener != null) {
                            PictureTypeBinder.this.listener.onPictureSuccess(path, str, str2, PictureTypeBinder.this.mState);
                            return;
                        }
                        albumItem.setLocalUrl(path);
                        albumItem.setAdd(false);
                        albumItem.setFileSource(str);
                        albumItem.setFileType(str2);
                        List<AlbumItem> items = PictureTypeBinder.this.getAdapter().getItems();
                        if (items.size() < PictureTypeBinder.this.MAX_PICTURE) {
                            items.add(new AlbumItem(true, 1));
                        }
                        if (PictureTypeBinder.this.mListener != null) {
                            PictureTypeBinder.this.mListener.Picture(items);
                        }
                        PictureTypeBinder.this.getAdapter().notifyDataSetChanged();
                    }
                }
            }).start();
        } else {
            ((ImageCameraWrapper) Album.camera(context).image()).onResult(new Action<String>() { // from class: com.collectpoint.moudle.binder.PictureTypeBinder.2
                public void onAction(int i, String str3) {
                    if (PictureTypeBinder.this.listener != null) {
                        PictureTypeBinder.this.listener.onPictureSuccess(str3, str, str2, PictureTypeBinder.this.mState);
                        return;
                    }
                    albumItem.setLocalUrl(str3);
                    albumItem.setAdd(false);
                    albumItem.setFileSource(str);
                    albumItem.setFileType(str2);
                    List<AlbumItem> items = PictureTypeBinder.this.getAdapter().getItems();
                    if (items.size() < PictureTypeBinder.this.MAX_PICTURE) {
                        items.add(new AlbumItem(true, 1));
                    }
                    if (PictureTypeBinder.this.mListener != null) {
                        PictureTypeBinder.this.mListener.Picture(items);
                    }
                    PictureTypeBinder.this.getAdapter().notifyDataSetChanged();
                }
            }).start();
        }
    }

    private void clickDelete(ViewHolder viewHolder) {
        List items = getAdapter().getItems();
        if (!((AlbumItem) items.get(items.size() - 1)).isAdd()) {
            items.add(new AlbumItem(true, 1));
        }
        AlbumItem albumItem = (AlbumItem) getAdapter().getItems().get(viewHolder.getAdapterPosition());
        if (EmptyUtils.isNotEmpty(this.mAlbumList)) {
            Iterator<AlbumFile> it = this.mAlbumList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AlbumFile next = it.next();
                if (next.getPath().equals(albumItem.getLocalUrl())) {
                    this.mAlbumList.remove(next);
                    break;
                }
            }
        }
        getAdapter().getItems().remove(albumItem);
        getAdapter().notifyDataSetChanged();
    }

    private void clickPicture(ViewHolder viewHolder, Context context, boolean z) {
        if (z) {
            return;
        }
        List items = getAdapter().getItems();
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (obj instanceof AlbumItem) {
                AlbumItem albumItem = (AlbumItem) obj;
                String url = albumItem.getUrl();
                String localUrl = albumItem.getLocalUrl();
                if (EmptyUtils.isNotEmpty(localUrl)) {
                    arrayList.add(localUrl);
                } else if (EmptyUtils.isNotEmpty(url)) {
                    arrayList.add(CacheUtils.getInstance().getUserBean().getShowImgUrl() + url);
                }
            }
        }
        Album.gallery(context).checkedList(arrayList).checkable(false).currentPosition(viewHolder.getAdapterPosition()).start();
    }

    private void setLayoutParams(ViewHolder viewHolder) {
        viewHolder.mBinding.rlContent.setLayoutParams(new ViewGroup.LayoutParams(this.mWidth, this.mHeight));
    }

    private void showType(final Context context, final List<Picker> list, final List<List<Picker>> list2, final AlbumItem albumItem) {
        OptionsPickerView optionsPickerViewBuild = new OptionsPickerBuilder(context, new OnOptionsSelectListener() { // from class: com.collectpoint.moudle.binder.PictureTypeBinder.3
            public void onOptionsSelect(int i, int i2, int i3, View view) {
                if (((Picker) list.get(i)).getId().equals("PZ")) {
                    PictureTypeBinder.this.clickAdd(albumItem, context, ((Picker) list.get(i)).getId(), ((Picker) ((List) list2.get(i)).get(i2)).getId(), false);
                } else {
                    PictureTypeBinder.this.clickAdd(albumItem, context, ((Picker) list.get(i)).getId(), ((Picker) ((List) list2.get(i)).get(i2)).getId(), true);
                }
            }
        }).build();
        optionsPickerViewBuild.setPicker(list, list2);
        optionsPickerViewBuild.show();
    }

    /* renamed from: lambda$onBindViewHolder$0$com-collectpoint-moudle-binder-PictureTypeBinder, reason: not valid java name */
    /* synthetic */ void m159x92deddd5(Context context, AlbumItem albumItem, View view) {
        showType(context, this.mList, this.mLists, albumItem);
    }

    /* renamed from: lambda$onBindViewHolder$1$com-collectpoint-moudle-binder-PictureTypeBinder, reason: not valid java name */
    /* synthetic */ void m160x848883f4(ViewHolder viewHolder, View view) {
        clickDelete(viewHolder);
    }

    /* renamed from: lambda$onBindViewHolder$2$com-collectpoint-moudle-binder-PictureTypeBinder, reason: not valid java name */
    /* synthetic */ void m161x76322a13(ViewHolder viewHolder, Context context, boolean z, View view) {
        clickPicture(viewHolder, context, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(final com.collectpoint.moudle.binder.PictureTypeBinder.ViewHolder r12, final com.collectpoint.bean.item.AlbumItem r13) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.collectpoint.moudle.binder.PictureTypeBinder.onBindViewHolder(com.collectpoint.moudle.binder.PictureTypeBinder$ViewHolder, com.collectpoint.bean.item.AlbumItem):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(DataBindingUtil.inflate(layoutInflater, 2131493037, viewGroup, false));
    }
}
