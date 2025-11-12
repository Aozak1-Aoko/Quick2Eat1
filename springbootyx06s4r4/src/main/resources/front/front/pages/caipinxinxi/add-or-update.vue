<template>
<view class="content">
	<view :style='{"minHeight":"100%","width":"100%","padding":"0","position":"relative","background":"#F6F7F9","height":"auto"}'>
		<form :style='{"width":"100%","padding":"24rpx","background":"none","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"12rpx 0","margin":"0 0 10rpx","borderColor":"#ccc","alignItems":"flex-start","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"left"}' class="title">菜品编号</view>
				<view :style='{"border":"2rpx solid #3D3D3D","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","lineHeight":"80rpx","fontSize":"28rpx"}' class="right-input">
					{{ruleForm.caipinbianhao}}
				</view>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 10rpx","borderColor":"#ccc","alignItems":"flex-start","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"left"}' class="title">菜品名称</view>
				<input :style='{"border":"2rpx solid #3D3D3D","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.caipinmingcheng" v-model="ruleForm.caipinmingcheng" placeholder="菜品名称"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 10rpx","borderColor":"#ccc","alignItems":"flex-start","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"left"}' class="title">菜品分类</view>
				<picker :disabled="ro.caipinfenlei" :style='{"border":"2rpx solid #3D3D3D","width":"100%","padding":"0 24rpx","borderRadius":"8rpx","flex":"1","height":"auto"}' @change="caipinfenleiChange" :value="caipinfenleiIndex" :range="caipinfenleiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#000"}' class="uni-input">{{ruleForm.caipinfenlei?ruleForm.caipinfenlei:"请选择菜品分类"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 10rpx","borderColor":"#ccc","alignItems":"flex-start","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="tupianTap">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"left"}' class="title">图片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.tupian" :src="baseUrl+ruleForm.tupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 10rpx","borderColor":"#ccc","alignItems":"flex-start","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"left"}' class="title">口味偏好</view>
				<input :style='{"border":"2rpx solid #3D3D3D","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.kouweipianhao" v-model="ruleForm.kouweipianhao" placeholder="口味偏好"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 10rpx","borderColor":"#ccc","alignItems":"flex-start","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"left"}' class="title">商家账号</view>
				<input :style='{"border":"2rpx solid #3D3D3D","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.shangjiazhanghao" v-model="ruleForm.shangjiazhanghao" placeholder="商家账号"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 10rpx","borderColor":"#ccc","alignItems":"flex-start","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"left"}' class="title">店铺名</view>
				<input :style='{"border":"2rpx solid #3D3D3D","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.dianpuming" v-model="ruleForm.dianpuming" placeholder="店铺名"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 10rpx","borderColor":"#ccc","alignItems":"flex-start","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"left"}' class="title">联系方式</view>
				<input :style='{"border":"2rpx solid #3D3D3D","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.lianxifangshi" v-model="ruleForm.lianxifangshi" placeholder="联系方式"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 10rpx","borderColor":"#ccc","alignItems":"flex-start","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"left"}' class="title">店铺位置</view>
				<input :style='{"border":"2rpx solid #3D3D3D","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.dianpuweizhi" v-model="ruleForm.dianpuweizhi" placeholder="店铺位置"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 10rpx","borderColor":"#ccc","alignItems":"flex-start","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"left"}' class="title">单限</view>
				<input :style='{"border":"2rpx solid #3D3D3D","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.onelimittimes" v-model.number="ruleForm.onelimittimes" placeholder="单限" type="number"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 10rpx","borderColor":"#ccc","alignItems":"flex-start","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"left"}' class="title">库存</view>
				<input :style='{"border":"2rpx solid #3D3D3D","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.alllimittimes" v-model.number="ruleForm.alllimittimes" placeholder="库存" type="number"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 10rpx","borderColor":"#ccc","alignItems":"flex-start","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"left"}' class="title">价格</view>
				<input :style='{"border":"2rpx solid #3D3D3D","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.price" v-model.number="ruleForm.price" placeholder="价格" type="digit"></input>
			</view>
                
			<view :style='{"padding":"12rpx 0","margin":"0 0 10rpx","borderColor":"#ccc","alignItems":"flex-start","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"left"}' class="title">简介</view>
				<xia-editor ref="jianjie" :style='{"minHeight":"300rpx","border":"2rpx solid #3D3D3D","width":"100%","padding":"20rpx","borderRadius":"8rpx","height":"auto"}' v-model="ruleForm.jianjie" placeholder="简介" @editorChange="jianjieChange"></xia-editor>
			</view>
			
			<view :style='{"width":"100%","padding":"10rpx 0","flexWrap":"wrap","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0 0 20rpx","color":"rgb(255, 255, 255)","borderRadius":"8rpx","background":"#FFD128","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
	import xiaEditor from '@/components/xia-editor/xia-editor';
	import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				caipinbianhao: this.getUUID(),
				caipinmingcheng: '',
				caipinfenlei: '',
				tupian: '',
				kouweipianhao: '',
				jianjie: '',
				shangjiazhanghao: '',
				dianpuming: '',
				lianxifangshi: '',
				dianpuweizhi: '',
					onelimittimes: Number('-1') ,
					alllimittimes: Number('-1') ,
				discussnum: '',
				price: '',
				onshelves: '',
				storeupnum: '',
				},
				caipinfenleiOptions: [],
				caipinfenleiIndex: 0,
				// 登录用户信息
				user: {},
				ro:{
				   caipinbianhao : false,
				   caipinmingcheng : false,
				   caipinfenlei : false,
				   tupian : false,
				   kouweipianhao : false,
				   jianjie : false,
				   shangjiazhanghao : false,
				   dianpuming : false,
				   lianxifangshi : false,
				   dianpuweizhi : false,
				   onelimittimes : false,
				   alllimittimes : false,
				   discussnum : false,
				   price : false,
				   onshelves : false,
				   storeupnum : false,
				},
				virtualPay: false,
			}
		},
		components: {
			wPicker,
			xiaEditor,
			multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
			if(options.virtualPay){
				this.virtualPay = true
			}
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.shangjiazhanghao = this.user.shangjiazhanghao
			this.ro.shangjiazhanghao = true;
			this.ruleForm.dianpuming = this.user.dianpuming
			this.ro.dianpuming = true;
			this.ruleForm.lianxifangshi = this.user.lianxifangshi
			this.ro.lianxifangshi = true;
			this.ruleForm.dianpuweizhi = this.user.dianpuweizhi
			this.ro.dianpuweizhi = true;


			// 下拉框
			res = await this.$api.option(`caipinfenlei`,`caipinfenlei`,{});
			this.caipinfenleiOptions = res.data;
			this.caipinfenleiOptions.unshift("请选择菜品分类");

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`caipinxinxi`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='caipinbianhao'){
						this.ruleForm.caipinbianhao = obj[o];
						this.ro.caipinbianhao = true;
						continue;
					}
					if(o=='caipinmingcheng'){
						this.ruleForm.caipinmingcheng = obj[o];
						this.ro.caipinmingcheng = true;
						continue;
					}
					if(o=='caipinfenlei'){
						this.ruleForm.caipinfenlei = obj[o];
						this.ro.caipinfenlei = true;
						continue;
					}
					if(o=='tupian'){
						this.ruleForm.tupian = obj[o].split(",")[0];
						this.ro.tupian = true;
						continue;
					}
					if(o=='kouweipianhao'){
						this.ruleForm.kouweipianhao = obj[o];
						this.ro.kouweipianhao = true;
						continue;
					}
					if(o=='jianjie'){
						this.ruleForm.jianjie = obj[o];
						this.ro.jianjie = true;
						continue;
					}
					if(o=='shangjiazhanghao'){
						this.ruleForm.shangjiazhanghao = obj[o];
						this.ro.shangjiazhanghao = true;
						continue;
					}
					if(o=='dianpuming'){
						this.ruleForm.dianpuming = obj[o];
						this.ro.dianpuming = true;
						continue;
					}
					if(o=='lianxifangshi'){
						this.ruleForm.lianxifangshi = obj[o];
						this.ro.lianxifangshi = true;
						continue;
					}
					if(o=='dianpuweizhi'){
						this.ruleForm.dianpuweizhi = obj[o];
						this.ro.dianpuweizhi = true;
						continue;
					}
					if(o=='onelimittimes'){
						this.ruleForm.onelimittimes = obj[o];
						this.ro.onelimittimes = true;
						continue;
					}
					if(o=='alllimittimes'){
						this.ruleForm.alllimittimes = obj[o];
						this.ro.alllimittimes = true;
						continue;
					}
					if(o=='discussnum'){
						this.ruleForm.discussnum = obj[o];
						this.ro.discussnum = true;
						continue;
					}
					if(o=='price'){
						this.ruleForm.price = obj[o];
						this.ro.price = true;
						continue;
					}
					if(o=='onshelves'){
						this.ruleForm.onshelves = obj[o];
						this.ro.onshelves = true;
						continue;
					}
					if(o=='storeupnum'){
						this.ruleForm.storeupnum = obj[o];
						this.ro.storeupnum = true;
						continue;
					}
				}
			}
			this.styleChange()
			this.$forceUpdate()
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap()
				}, 300)
			}
		},
		methods: {
			jianjieChange(e) {
				this.ruleForm.jianjie = e
			},
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数



			// 下拉变化
			caipinfenleiChange(e) {
				this.caipinfenleiIndex = e.target.value
				this.ruleForm.caipinfenlei = this.caipinfenleiOptions[this.caipinfenleiIndex]
			},

			tupianTap() {
				let _this = this;
				if(this.ro.tupian){
					return false
				}
				this.$api.upload(function(res) {
					_this.ruleForm.tupian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
				let that = this
				if(this.ruleForm.caipinbianhao){
					this.ruleForm.caipinbianhao = String(this.ruleForm.caipinbianhao)
				}
				//跨表计算判断
				var obj;
				if(this.ruleForm.onelimittimes&&(!this.$validate.isIntNumer(this.ruleForm.onelimittimes))){
					this.$utils.msg(`单限应输入整数`);
					return
				}
				if(this.ruleForm.alllimittimes&&(!this.$validate.isIntNumer(this.ruleForm.alllimittimes))){
					this.$utils.msg(`库存应输入整数`);
					return
				}
				if(this.ruleForm.discussnum&&(!this.$validate.isIntNumer(this.ruleForm.discussnum))){
					this.$utils.msg(`评论数应输入整数`);
					return
				}
				if((!this.ruleForm.price)){
					this.$utils.msg(`价格不能为空`);
					return
				}
				if(this.ruleForm.price&&(!this.$validate.isNumber(this.ruleForm.price))){
					this.$utils.msg(`价格应输入数字`);
					return
				}
				if(this.ruleForm.onshelves&&(!this.$validate.isIntNumer(this.ruleForm.onshelves))){
					this.$utils.msg(`是否上架(1:上架，0:下架)应输入整数`);
					return
				}
				if(this.ruleForm.storeupnum&&(!this.$validate.isIntNumer(this.ruleForm.storeupnum))){
					this.$utils.msg(`收藏数应输入整数`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
						if(!obj) {
							obj = uni.getStorageSync('crossObj');
						}
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
							   crossuserid=Number(uni.getStorageSync('appUserid'));
							   crossrefid=obj['id'];
							   crossoptnum=uni.getStorageSync('statusColumnName');
							   crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`caipinxinxi`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`caipinxinxi`, this.ruleForm);
						}else{
							oet = await this.$api.add(`caipinxinxi`, this.ruleForm);
						}
						if(this.cross){
							uni.setStorageSync('crossCleanType',true);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
				//跨表计算
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`caipinxinxi`, this.ruleForm);
					}else{
						oet = await this.$api.add(`caipinxinxi`, this.ruleForm);
					}
					if(this.cross){
						uni.setStorageSync('crossCleanType',true);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
