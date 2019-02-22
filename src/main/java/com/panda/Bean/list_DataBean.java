package com.panda.Bean;

import java.util.List;

public class list_DataBean {
	    private List<list_ItemsBean> items;
	    private int total;
	    public List<list_ItemsBean> getItems() {
			return items;
		}
		public void setItems(List<list_ItemsBean> items) {
			this.items = items;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public List<list_BannersBean> getBanners() {
			return banners;
		}
		public void setBanners(List<list_BannersBean> banners) {
			this.banners = banners;
		}
		private List<list_BannersBean> banners;
		@Override
		public String toString() {
			return "list_DataBean [items=" + items + ", total=" + total + ", banners=" + banners + "]";
		}
		
}
