<template>
	<view :style='{"padding":"0","flexWrap":"wrap","background":"#F6F7F9","display":"flex","width":"100%","position":"relative","height":"100%"}'>
		<view class="title" :style='{"padding":"10rpx 0","color":"#000","textAlign":"center","background":"#fff","width":"100%","lineHeight":"1.5","fontSize":"32rpx","fontWeight":"bold"}'>{{detail.title}}</view>
		
		<view :style='{"width":"100%","padding":"10rpx 20rpx","alignItems":"center","background":"#fff","justifyContent":"space-between","display":"flex"}'>
		  <view :style='{"padding":"0"}'>
		    <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"22rpx","color":"#8D8D8D"}'></text>
		    <text :style='{"color":"#8D8D8D","lineHeight":"1.5","fontSize":"22rpx"}'>发布时间：{{detail.addtime}}</text>
		  </view>
		  <view :style='{"padding":"0"}'>
		    <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"22rpx","color":"#8D8D8D"}'></text>
		    <text :style='{"color":"#8D8D8D","lineHeight":"1.5","fontSize":"22rpx"}'>{{detail.name}}</text>
		  </view>
		  <view :style='{"padding":"0"}'>
		    <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"22rpx","color":"#8D8D8D"}'></text>
		    <text :style='{"color":"#8D8D8D","lineHeight":"1.5","fontSize":"22rpx"}'>{{detail.thumbsupnum}}</text>
		  </view>
		  <view :style='{"padding":"0"}'>
		    <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"22rpx","color":"#8D8D8D"}'></text>
		    <text :style='{"color":"#8D8D8D","lineHeight":"1.5","fontSize":"22rpx"}'>{{detail.storeupnum}}</text>
		  </view>
		  <view :style='{"padding":"0"}'>
		    <text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"22rpx","color":"#8D8D8D"}'></text>
		    <text :style='{"color":"#8D8D8D","lineHeight":"1.5","fontSize":"22rpx"}'>{{detail.clicknum}}</text>
		  </view>
		</view>
		
		<view :style='{"overflow":"hidden","borderRadius":"0 0 40rpx 40rpx","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","order":"3"}'>
		  <view :style='{"width":"50%","background":"#FFD128","justifyContent":"center","display":"flex"}' @click="likeClick">
		    <text class="icon iconfont" :style='{"margin":"0 8rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#fff"}' :class="likeType?'icon-zan10':'icon-zan10'"></text>
		    <text :style='{"color":"#fff","lineHeight":"60rpx","fontSize":"28rpx"}'>{{likeType?'已':''}}赞</text>
		  </view>
		  <view :style='{"width":"50%","background":"#D8D8D8","justifyContent":"centert","display":"flex"}' @click="collectClick">
		    <text class="icon iconfont" :style='{"margin":"0 8rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#000"}' :class="collectType?'icon-shoucang10':'icon-shoucang10'"></text>
		    <text :style='{"color":"#000","lineHeight":"60rpx","fontSize":"28rpx"}'>{{collectType?'已':''}}收藏</text>
		  </view>
		</view>
		
		<view class="content" :style='{"width":"100%","padding":"10rpx 20rpx","background":"#fff","height":"auto","order":"1"}'>
			<rich-text class="ql-snow ql-editor" :nodes="detail.content"></rich-text>
		</view>
		
		<div :style='{"padding":"20rpx","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
		  <div @click="prepDetailClick" :style='{"color":"#000","borderRadius":"60rpx","textAlign":"center","background":"#D8D8D8","width":"40%","lineHeight":"60rpx","fontSize":"28rpx"}'>上一篇：prev</div>
		  <div @click="nextDetailClick" :style='{"color":"#fff","borderRadius":"60rpx","textAlign":"center","background":"#FFD128","width":"calc(60% - 40rpx)","lineHeight":"60rpx","fontSize":"28rpx"}'>下一篇：next</div>
		</div>
		

		<!-- 热门 -->
		<view class="hot" :style='{"width":"100%","overflow":"hidden","borderRadius":"20rpx","background":"none","height":"auto","order":"5"}'>
		  <view :style='{"padding":"0 0 0 40rpx","color":"#fff","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250214/607fdecc1a9b45e7a35d80592775c303.png) center center/100% 100%","width":"100%","lineHeight":"100rpx","fontSize":"32rpx","fontWeight":"bold"}'>热门信息</view>
		  <view :style='{"padding":"20rpx ","flexWrap":"wrap","background":"#F6F7F9","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		    <view v-for="(item,index) in hotList" :key="index" :style='{"padding":" 20rpx 20rpx","margin":"0 0 20rpx","borderRadius":"20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"49%","height":"auto"}' @click="toDetail(item.id)">
			  <image :style='{"width":"100%","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"220rpx","order":"1"}' mode="aspectFill" :src="baseUrl + item.picture"></image>
		      <view :style='{"padding":"0 8rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","textAlign":"center","width":"100%","lineHeight":"1.5","fontSize":"30rpx","textOverflow":"ellipsis","fontWeight":"bold"}'>{{ item.title }}</view>
		      <view :style='{"width":"100%","padding":"0 8rpx","lineHeight":"2","fontSize":"24rpx","color":"#959595","textAlign":"center"}'>{{ item.addtime }}</view>
		    </view>
		  </view>
		</view>
		<!-- 推荐 -->
		<view class="recommend" :style='{"width":"100%","overflow":"hidden","borderRadius":"20rpx","background":"none","height":"auto","order":"7"}'>
		  <view :style='{"padding":"0 0 0 40rpx","color":"#fff","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250214/607fdecc1a9b45e7a35d80592775c303.png) center center/100% 100%","width":"100%","lineHeight":"100rpx","fontSize":"32rpx","fontWeight":"bold"}'>推荐信息</view>
		  <view :style='{"padding":"20rpx ","flexWrap":"wrap","background":"#F6F7F9","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		    <view v-for="(item,index) in recommendList" :key="index" :style='{"padding":"30rpx 20rpx","margin":"0 0 20rpx","borderRadius":"20rpx","flexWrap":"wrap","background":"#fff","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center","height":"180rpx"}' @click="toDetail(item.id)">
		      <image :style='{"width":"140rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"120rpx","order":"1"}' mode="aspectFill" :src="baseUrl + item.picture"></image>
			  <view :style='{"padding":"0 8rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","textAlign":"left","width":"calc(100% - 140rpx)","lineHeight":"1.5","fontSize":"30rpx","textOverflow":"ellipsis","fontWeight":"bold"}'>{{ item.title }}</view>
		      <view :style='{"width":"calc(100% - 140rpx)","padding":"0 8rpx","lineHeight":"2","fontSize":"24rpx","color":"#959595","textAlign":"left"}'>{{ item.addtime }}</view>
		    </view>
		  </view>
		</view>

	</view>
</template>
<script>
	export default {
		data() {
			return {
				detail: {},
				id: '',
				likeType: false,
				likeForm: {},
				collectType: false,
				collectForm: {},
				allList: [],
				currentIndex: 0,
				hotList: [],
				recommendList: [],
			}
		},
		async onLoad(options) {
			this.id = options.id;
			this.getInfo()
			
			this.getHotList()
			this.getRecommendList()
		},
		computed:{
			baseUrl() {
				return this.$base.url;
			},
			userid(){
				return uni.getStorageSync('appUserid')
			}
		},
		methods: {
			async getInfo(){
				let res = await this.$api.info('news', this.id)
				res.data.content = res.data.content.replace(/<img/g,'<img style="width: 100%;"');
				this.detail = res.data;
				uni.pageScrollTo({
					scrollTop: 0,
					duration: 100,
				})
				this.getLike()
				this.getCollect()
				res = await this.$api.list('news',{page:1,limit:100,sort:'addtime',order:'desc'})
				for(let x in res.data.list){
					if(res.data.list[x].id == this.id){
						this.currentIndex = Number(x)
						break
					}
				}
				this.allList = res.data.list
				
			},
			// 获取点赞状态
			async getLike() {
				let res = await this.$api.list('storeup', {
					page: 1,
					limit: 1,
					type: '21',
					userid: uni.getStorageSync('appUserid'),
					refid: this.id,
					tablename: 'news'
				})
				if (res.data.list.length) {
					this.likeType = true
					this.likeForm = res.data.list[0]
				} else {
					this.likeType = false
					this.likeForm = {}
				}
			},
			// 获取热门列表
			async getHotList(){
				let res = await this.$api.recommend('news',{page:1, limit: 4,sort:'addtime',order:'desc'})
				this.hotList = res.data.list;
			},
			// 获取推荐列表	
			async getRecommendList(){
				let res;
				if(uni.getStorageSync("appUserid")){
					res = await this.$api.recommend2('news',{page:1, limit: 4,sort:'addtime',order:'desc'})
				}else{
					res = await this.$api.recommend('news',{page:1, limit: 4,sort:'addtime',order:'desc'})
				}
				
				this.recommendList = res.data.list;
			},
			// 上一篇
			prepDetailClick(){
				if(this.currentIndex == 0){
					this.$utils.msg('已经是第一篇了')
					return false
				}
				this.currentIndex--
				this.id = this.allList[this.currentIndex].id
				this.getInfo()
			},
			// 下一篇
			nextDetailClick(){
				if(this.currentIndex == this.allList.length - 1){
					this.$utils.msg('已经是最后一篇了')
					return false
				}
				this.currentIndex++
				this.id = this.allList[this.currentIndex].id
				this.getInfo()
			},
			toDetail(id){
				this.id = id
				this.getInfo()
			},
			// 获取收藏状态
			async getCollect() {
				let res = await this.$api.list('storeup', {
					page: 1,
					limit: 1,
					type: '1',
					userid: uni.getStorageSync('appUserid'),
					refid: this.id,
					tablename: 'news'
				})
				if (res.data.list.length) {
					this.collectType = true
					this.collectForm = res.data.list[0]
				} else {
					this.collectType = false
					this.collectForm = {}
				}
			},
			// 点赞按钮
			async likeClick() {
				let that = this
				if (this.likeType) {
					uni.showModal({
						title: '提示',
						content: '是否取消点赞？',
						async success(res) {
							if (res.confirm) {
								await that.$api.del('storeup', JSON.stringify([that.likeForm.id]))
								that.$utils.msg('取消成功')
								that.detail.thumbsupnum--
								await that.$api.update('news', that.detail)
								that.getLike()
							}
						}
					})
				} else {
					await that.$api.add('storeup', {
						userid: uni.getStorageSync('appUserid'),
						refid: this.id,
						type: '21',
						name: this.detail.title,
						picture: this.detail.picture,
						tablename: 'news',
					})
					this.$utils.msg('点赞成功')
					that.detail.thumbsupnum++
					await that.$api.update('news', that.detail)
					this.getLike()
				}
			},
			// 收藏按钮
			async collectClick() {
				let that = this
				if (this.collectType) {
					uni.showModal({
						title: '提示',
						content: '是否取消收藏？',
						async success(res) {
							if (res.confirm) {
								await that.$api.del('storeup', JSON.stringify([that.collectForm.id]))
								that.$utils.msg('取消成功')
								that.detail.storeupnum--
								await that.$api.update('news', that.detail)
								that.getCollect()
							}
						}
					})
				} else {
					await that.$api.add('storeup', {
						userid: uni.getStorageSync('appUserid'),
						refid: this.id,
						type: '1',
						name: this.detail.title,
						picture: this.detail.picture,
						tablename: 'news',
					})
					this.$utils.msg('收藏成功')
					that.detail.storeupnum++
					await that.$api.update('news', that.detail)
					this.getCollect()
				}
			},
		}
	}
</script>

<style scoped lang="scss">
	page {
		background: #FFFFFF;
	}
</style>
