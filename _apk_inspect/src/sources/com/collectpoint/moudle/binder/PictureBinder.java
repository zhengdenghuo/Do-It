package com.collectpoint.moudle.binder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.collectpoint.MyApp;
import com.collectpoint.bean.item.AlbumItem;
import com.collectpoint.databinding.ItemPictureBinding;
import com.collectpoint.moudle.binder.PictureBinder;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.PictureUtils;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.liuwq.base.image.ImgLoaderManager;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.api.ImageMultipleWrapper;
import com.yanzhenjie.album.api.ImageSingleWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.drakeet.multitype.ItemViewBinder;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class PictureBinder extends ItemViewBinder<AlbumItem, ViewHolder> {
    private int MAX_PICTURE;
    private OnPictureClickListener listener;
    private ArrayList<AlbumFile> mAlbumList;
    private int mHeight;
    private boolean mIsHideDelete;
    private boolean mIsSingle;
    private PictureBinderOnClickListener mListener;
    private int mWidth;
    private int type;

    /* renamed from: com.collectpoint.moudle.binder.PictureBinder$2, reason: invalid class name */
    class AnonymousClass2 implements Action<ArrayList<AlbumFile>> {
        AnonymousClass2() {
        }

        static /* synthetic */ boolean lambda$onAction$0(Object obj) {
            return (!(obj instanceof AlbumItem) || ((AlbumItem) obj).isAdd() || TextUtils.isEmpty(((AlbumItem) obj).getUrl())) ? false : true;
        }

        public void onAction(int i, ArrayList<AlbumFile> arrayList) {
            if (EmptyUtils.isNotEmpty(arrayList)) {
                if (PictureBinder.this.listener != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<AlbumFile> it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next().getPath());
                    }
                    PictureBinder.this.listener.onPictureSuccess(arrayList2, PictureBinder.this.type);
                    return;
                }
                List<AlbumItem> items = PictureBinder.this.getAdapter().getItems();
                ArrayList arrayList3 = new ArrayList(Collections2.filter(PictureBinder.this.getAdapter().getItems(), new Predicate() { // from class: com.collectpoint.moudle.binder.PictureBinder$2$$ExternalSyntheticLambda0
                    public final boolean apply(Object obj) {
                        return PictureBinder.AnonymousClass2.lambda$onAction$0(obj);
                    }
                }));
                items.clear();
                if (EmptyUtils.isNotEmpty(arrayList3)) {
                    items.addAll(arrayList3);
                }
                Iterator<AlbumFile> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    AlbumFile next = it2.next();
                    if (items.size() < PictureBinder.this.MAX_PICTURE) {
                        items.add(new AlbumItem(1, next.getPath(), 2));
                    }
                }
                if (items.size() < PictureBinder.this.MAX_PICTURE) {
                    items.add(new AlbumItem(true, 1));
                }
                if (PictureBinder.this.mListener != null) {
                    PictureBinder.this.mListener.Picture(items);
                }
                PictureBinder.this.getAdapter().notifyDataSetChanged();
                PictureBinder.this.mAlbumList = arrayList;
            }
        }
    }

    public interface OnPictureClickListener {
        void onPictureSuccess(List<String> list, int i);
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

    public PictureBinder(int i, int i2, OnPictureClickListener onPictureClickListener) {
        this.MAX_PICTURE = 3;
        this.type = 1;
        this.mIsSingle = true;
        this.mIsSingle = false;
        this.mIsHideDelete = false;
        this.type = i2;
        this.MAX_PICTURE = i;
        this.listener = onPictureClickListener;
        this.mWidth = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mHeight = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mAlbumList = new ArrayList<>();
    }

    public PictureBinder(int i, OnPictureClickListener onPictureClickListener) {
        this.MAX_PICTURE = 3;
        this.type = 1;
        this.mIsSingle = true;
        this.mIsSingle = false;
        this.mIsHideDelete = false;
        this.MAX_PICTURE = i;
        this.listener = onPictureClickListener;
        this.mWidth = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mHeight = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mAlbumList = new ArrayList<>();
    }

    public PictureBinder(boolean z) {
        this.MAX_PICTURE = 3;
        this.type = 1;
        this.mIsSingle = true;
        this.mIsHideDelete = z;
        this.mWidth = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mHeight = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
    }

    public PictureBinder(boolean z, int i, int i2) {
        this.MAX_PICTURE = 3;
        this.type = 1;
        this.mIsSingle = true;
        this.mIsHideDelete = z;
        this.mWidth = i;
        this.mHeight = i2;
    }

    public PictureBinder(boolean z, int i, boolean z2) {
        this.MAX_PICTURE = 3;
        this.type = 1;
        this.mIsSingle = true;
        this.mIsHideDelete = z;
        this.MAX_PICTURE = i;
        this.mIsSingle = z2;
        this.mWidth = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mHeight = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mAlbumList = new ArrayList<>();
    }

    public PictureBinder(boolean z, int i, boolean z2, PictureBinderOnClickListener pictureBinderOnClickListener) {
        this.MAX_PICTURE = 3;
        this.type = 1;
        this.mIsSingle = true;
        this.mIsSingle = z2;
        this.mIsHideDelete = z;
        this.MAX_PICTURE = i;
        this.mListener = pictureBinderOnClickListener;
        this.mWidth = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mHeight = (int) ((ScreenUtils.getScreenWidth() - (MyApp.getContext().getResources().getDimension(2131165363) * 2.0f)) / 3.0f);
        this.mAlbumList = new ArrayList<>();
    }

    private void clickAdd(final AlbumItem albumItem, Context context) {
        if (this.mIsSingle) {
            ((ImageSingleWrapper) Album.image(context).singleChoice()).widget(PictureUtils.getAlbumUI(context, 2131820959)).camera(true).columnCount(4).afterFilterVisibility(true).onResult(new Action<ArrayList<AlbumFile>>() { // from class: com.collectpoint.moudle.binder.PictureBinder.1
                public void onAction(int i, ArrayList<AlbumFile> arrayList) {
                    if (arrayList.size() > 0) {
                        String path = arrayList.get(0).getPath();
                        if (PictureBinder.this.listener != null) {
                            PictureBinder.this.listener.onPictureSuccess(Collections.singletonList(path), PictureBinder.this.type);
                            return;
                        }
                        albumItem.setLocalUrl(path);
                        albumItem.setAdd(false);
                        List<AlbumItem> items = PictureBinder.this.getAdapter().getItems();
                        if (items.size() < PictureBinder.this.MAX_PICTURE) {
                            items.add(new AlbumItem(true, 1));
                        }
                        if (PictureBinder.this.mListener != null) {
                            PictureBinder.this.mListener.Picture(items);
                        }
                        PictureBinder.this.getAdapter().notifyDataSetChanged();
                    }
                }
            }).start();
        } else {
            ((ImageMultipleWrapper) Album.image(context).multipleChoice()).widget(PictureUtils.getAlbumUI(context, 2131820959)).camera(true).columnCount(4).selectCount(this.MAX_PICTURE).checkedList(this.mAlbumList).afterFilterVisibility(true).onResult(new AnonymousClass2()).start();
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

    /* renamed from: lambda$onBindViewHolder$0$com-collectpoint-moudle-binder-PictureBinder, reason: not valid java name */
    /* synthetic */ void m155x7978067b(AlbumItem albumItem, Context context, View view) {
        clickAdd(albumItem, context);
    }

    /* renamed from: lambda$onBindViewHolder$1$com-collectpoint-moudle-binder-PictureBinder, reason: not valid java name */
    /* synthetic */ void m156x32ef941a(ViewHolder viewHolder, View view) {
        clickDelete(viewHolder);
    }

    /* renamed from: lambda$onBindViewHolder$2$com-collectpoint-moudle-binder-PictureBinder, reason: not valid java name */
    /* synthetic */ void m157xec6721b9(ViewHolder viewHolder, Context context, boolean z, View view) {
        clickPicture(viewHolder, context, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBindViewHolder(final ViewHolder viewHolder, final AlbumItem albumItem) {
        final Context context = viewHolder.itemView.getContext();
        String url = albumItem.getUrl();
        String localUrl = albumItem.getLocalUrl();
        String smallFilePath = albumItem.getSmallFilePath();
        final boolean zIsAdd = albumItem.isAdd();
        if (zIsAdd) {
            viewHolder.mBinding.ivAdd.setVisibility(0);
            viewHolder.mBinding.ivAvatar.setVisibility(8);
            viewHolder.mBinding.ivDelete.setVisibility(8);
        } else {
            viewHolder.mBinding.ivAdd.setVisibility(8);
            viewHolder.mBinding.ivAvatar.setVisibility(0);
            viewHolder.mBinding.ivDelete.setVisibility(0);
        }
        if (EmptyUtils.isNotEmpty(localUrl)) {
            ImgLoaderManager.get().loadDrawable(viewHolder.mBinding.ivAvatar, localUrl);
        } else if (EmptyUtils.isNotEmpty(smallFilePath)) {
            ImgLoaderManager.get().loadDrawable(viewHolder.mBinding.ivAvatar, CacheUtils.getInstance().getUserBean().getShowImgUrl() + smallFilePath);
        } else {
            ImgLoaderManager.get().loadDrawable(viewHolder.mBinding.ivAvatar, CacheUtils.getInstance().getUserBean().getShowImgUrl() + url);
        }
        viewHolder.mBinding.ivAdd.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.binder.PictureBinder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m155x7978067b(albumItem, context, view);
            }
        });
        viewHolder.mBinding.ivDelete.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.binder.PictureBinder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m156x32ef941a(viewHolder, view);
            }
        });
        setLayoutParams(viewHolder);
        if (this.mIsHideDelete) {
            viewHolder.mBinding.ivDelete.setVisibility(8);
        }
        viewHolder.mBinding.ivAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.binder.PictureBinder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m157xec6721b9(viewHolder, context, zIsAdd, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(DataBindingUtil.inflate(layoutInflater, 2131493037, viewGroup, false));
    }

    public void setData(List<AlbumFile> list) {
        if (EmptyUtils.isNotEmpty(list)) {
            list.clear();
            this.mAlbumList.addAll(list);
        }
    }
}
