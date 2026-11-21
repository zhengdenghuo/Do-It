package com.collectpoint.moudle.product.category.event;

import com.collectpoint.moudle.product.category.entity.GoodsListBean;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class MessageEvent {
    public List<GoodsListBean.DataEntity.GoodscatrgoryEntity.GoodsitemEntity> goods;
    public int num;
    public int price;

    public MessageEvent(int i, int i2, List<GoodsListBean.DataEntity.GoodscatrgoryEntity.GoodsitemEntity> list) {
        this.num = i;
        this.price = i2;
        this.goods = list;
    }
}
