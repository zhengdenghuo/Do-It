package com.collectpoint.moudle.product.category.entity;

import java.io.Serializable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes15.dex */
public class GoodsListBean implements Serializable {
    private List<DataEntity> data;

    public static class DataEntity {
        private GoodscatrgoryEntity goodscatrgory;

        public static class GoodscatrgoryEntity {
            private int bugNum;
            private List<GoodsitemEntity> goodsitem;
            private String name;

            public static class GoodsitemEntity {
                private String goodsImgUrl;
                private int id;
                private String introduce;
                private boolean moreStandard;
                private String name;
                private int price;

                public String getGoodsImgUrl() {
                    return this.goodsImgUrl;
                }

                public int getId() {
                    return this.id;
                }

                public String getIntroduce() {
                    return this.introduce;
                }

                public String getName() {
                    return this.name;
                }

                public int getPrice() {
                    return this.price;
                }

                public boolean isMoreStandard() {
                    return this.moreStandard;
                }

                public void setGoodsImgUrl(String str) {
                    this.goodsImgUrl = str;
                }

                public void setId(int i) {
                    this.id = i;
                }

                public void setIntroduce(String str) {
                    this.introduce = str;
                }

                public void setMoreStandard(boolean z) {
                    this.moreStandard = z;
                }

                public void setName(String str) {
                    this.name = str;
                }

                public void setPrice(int i) {
                    this.price = i;
                }
            }

            public int getBugNum() {
                return this.bugNum;
            }

            public List<GoodsitemEntity> getGoodsitem() {
                return this.goodsitem;
            }

            public String getName() {
                return this.name;
            }

            public void setBugNum(int i) {
                this.bugNum = i;
            }

            public void setGoodsitem(List<GoodsitemEntity> list) {
                this.goodsitem = list;
            }

            public void setName(String str) {
                this.name = str;
            }
        }

        public GoodscatrgoryEntity getGoodscatrgory() {
            return this.goodscatrgory;
        }

        public void setGoodscatrgory(GoodscatrgoryEntity goodscatrgoryEntity) {
            this.goodscatrgory = goodscatrgoryEntity;
        }
    }

    public List<DataEntity> getData() {
        return this.data;
    }

    public void setData(List<DataEntity> list) {
        this.data = list;
    }
}
