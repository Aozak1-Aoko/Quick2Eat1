<!-- front/pages/shitangshangjia/map/storeMap.vue -->
<template>
  <view style="padding: 30rpx;">
    <text>店铺位置地图</text>
    <!-- 加载对应店铺的地图图片（需提前将图片放入 static 目录） -->
    <image 
      :src="'/static/shitangshangjia/map/store' + storeId + '.png'" 
      mode="widthFix" 
      style="width: 100%; margin-top: 20rpx;"
    ></image>
  </view>
</template>
<script>
export default {
  onLoad(options) {
    // 接收从详情页传递的店铺ID
    this.storeId = options.id;
  },
  data() {
    return {
      storeId: ''
    }
  }
}
</script>