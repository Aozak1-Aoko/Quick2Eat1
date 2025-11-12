<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'" label="菜品编号" prop="caipinbianhao" >
					<el-input v-model="ruleForm.caipinbianhao" placeholder="菜品编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.caipinbianhao" label="菜品编号" prop="caipinbianhao" >
					<el-input v-model="ruleForm.caipinbianhao" placeholder="菜品编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="菜品名称" prop="caipinmingcheng" >
					<el-input v-model="ruleForm.caipinmingcheng" placeholder="菜品名称" clearable  :readonly="ro.caipinmingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="菜品名称" prop="caipinmingcheng" >
					<el-input v-model="ruleForm.caipinmingcheng" placeholder="菜品名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="菜品分类" prop="caipinfenlei" >
					<el-select :disabled="ro.caipinfenlei" v-model="ruleForm.caipinfenlei" placeholder="请选择菜品分类" >
						<el-option
							v-for="(item,index) in caipinfenleiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="菜品分类" prop="caipinfenlei" >
					<el-input v-model="ruleForm.caipinfenlei"
						placeholder="菜品分类" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.tupian" label="图片" prop="tupian" >
					<file-upload
						tip="点击上传图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
						@change="tupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.tupian" label="图片" prop="tupian" >
					<img v-if="ruleForm.tupian.substring(0,4)=='http'&&ruleForm.tupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupian" width="100" height="100">
					<img v-else-if="ruleForm.tupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="口味偏好" prop="kouweipianhao" >
					<el-input v-model="ruleForm.kouweipianhao" placeholder="口味偏好" clearable  :readonly="ro.kouweipianhao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="口味偏好" prop="kouweipianhao" >
					<el-input v-model="ruleForm.kouweipianhao" placeholder="口味偏好" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="商家账号" prop="shangjiazhanghao" >
					<el-input v-model="ruleForm.shangjiazhanghao" placeholder="商家账号" clearable  :readonly="ro.shangjiazhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="商家账号" prop="shangjiazhanghao" >
					<el-input v-model="ruleForm.shangjiazhanghao" placeholder="商家账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="店铺名" prop="dianpuming" >
					<el-input v-model="ruleForm.dianpuming" placeholder="店铺名" clearable  :readonly="ro.dianpuming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="店铺名" prop="dianpuming" >
					<el-input v-model="ruleForm.dianpuming" placeholder="店铺名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="联系方式" prop="lianxifangshi" >
					<el-input v-model="ruleForm.lianxifangshi" placeholder="联系方式" clearable  :readonly="ro.lianxifangshi"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="联系方式" prop="lianxifangshi" >
					<el-input v-model="ruleForm.lianxifangshi" placeholder="联系方式" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="店铺位置" prop="dianpuweizhi" >
					<el-input v-model="ruleForm.dianpuweizhi" placeholder="店铺位置" clearable  :readonly="ro.dianpuweizhi"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="店铺位置" prop="dianpuweizhi" >
					<el-input v-model="ruleForm.dianpuweizhi" placeholder="店铺位置" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="单限" prop="onelimittimes" >
					<el-input v-model.number="ruleForm.onelimittimes" placeholder="单限" clearable  :readonly="ro.onelimittimes"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="单限" prop="onelimittimes" >
					<el-input v-model="ruleForm.onelimittimes" placeholder="单限" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="库存" prop="alllimittimes" >
					<el-input v-model.number="ruleForm.alllimittimes" placeholder="库存" clearable  :readonly="ro.alllimittimes"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="库存" prop="alllimittimes" >
					<el-input v-model="ruleForm.alllimittimes" placeholder="库存" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="价格" prop="price" >
					<el-input-number v-model="ruleForm.price" placeholder="价格" :disabled="ro.price"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="价格" prop="price" >
					<el-input v-model="ruleForm.price" placeholder="价格" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item v-if="type!='info'"  label="简介" prop="jianjie" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.jianjie" 
					class="editor"
					myQuillEditor="jianjie"
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.jianjie" label="简介" prop="jianjie" >
				<span class="text ql-snow ql-editor" v-html="ruleForm.jianjie"></span>
			</el-form-item>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isNumber,
		isIntNumer,
	} from "@/utils/validate";
	export default {
		data() {
			var validateNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isNumber(value)) {
					callback(new Error("请输入数字"));
				} else {
					callback();
				}
			};
			var validateIntNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isIntNumer(value)) {
					callback(new Error("请输入整数"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
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
					onelimittimes: Number('-1'),
					alllimittimes: Number('-1'),
					price: '',
					onshelves: 1,
				},
				caipinfenleiOptions: [],

				rules: {
					caipinbianhao: [
					],
					caipinmingcheng: [
					],
					caipinfenlei: [
					],
					tupian: [
					],
					kouweipianhao: [
					],
					jianjie: [
					],
					shangjiazhanghao: [
					],
					dianpuming: [
					],
					lianxifangshi: [
					],
					dianpuweizhi: [
					],
					onelimittimes: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					alllimittimes: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					discussnum: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					price: [
						{ required: true, message: '价格不能为空', trigger: 'blur' },
						{ validator: validateNumber, trigger: 'blur' },
					],
					onshelves: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					storeupnum: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
				},
			};
		},
		props: ["parent"],
		computed: {



		},
		components: {
		},
		created() {
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
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
							this.ruleForm.tupian = obj[o];
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
					this.ruleForm.onelimittimes = Number('-1'); 					this.ruleForm.alllimittimes = Number('-1'); 				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.shangjiazhanghao!=''&&json.shangjiazhanghao) || json.shangjiazhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.shangjiazhanghao = json.shangjiazhanghao
							this.ro.shangjiazhanghao = true;
						}
						if(((json.dianpuming!=''&&json.dianpuming) || json.dianpuming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.dianpuming = json.dianpuming
							this.ro.dianpuming = true;
						}
						if(((json.lianxifangshi!=''&&json.lianxifangshi) || json.lianxifangshi==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.lianxifangshi = json.lianxifangshi
							this.ro.lianxifangshi = true;
						}
						if(((json.dianpuweizhi!=''&&json.dianpuweizhi) || json.dianpuweizhi==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.dianpuweizhi = json.dianpuweizhi
							this.ro.dianpuweizhi = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
				this.$http({
					url: `option/caipinfenlei/caipinfenlei`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.caipinfenleiOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `caipinxinxi/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
						this.ruleForm.jianjie = this.ruleForm.jianjie.replace(reg,'../../../springbootyx06s4r4/upload');
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.caipinbianhao) {
						this.ruleForm.caipinbianhao = String(this.ruleForm.caipinbianhao)
					}
					if(this.ruleForm.tupian!=null) {
						this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
					}
					if(this.ruleForm.price<0){
						this.$message.error("价格不能输入负数");
						return
					}
					if(this.ruleForm.alllimittimes<0){
						this.$message.error("库存不能输入负数");
						return
					}
					if(this.ruleForm.onelimittimes<0){
						this.$message.error("单次购买不能输入负数");
						return
					}
					var objcross = this.$storage.getObj('crossObj');
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `caipinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.caipinxinxiCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.caipinxinxiCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			tupianUploadChange(fileUrls) {
				this.ruleForm.tupian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 30px;
	}
	.add-update-preview {
		padding: 40px 30% 40px 10%;
		background: url(http://codegen.caihongy.cn/20250312/b9712448801d4664b72de26e917dcd3f.jpg) no-repeat center center / cover;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 100%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #6e6e6e;
		font-weight: 500;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		border: 1px solid #E8E8E8;
		padding: 6px 10px;
		color: #333;
		background: #fff;
		font-weight: 500;
		display: inline-block;
		font-size: 16px;
		line-height: 24px;
		min-width: 100%;
	}
	
	.add-update-preview .el-input {
		width: auto;
		min-width: 50%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #E8E8E8;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: auto;
		min-width: 50%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #E8E8E8;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: auto;
		min-width: 50%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 1px solid #E8E8E88;
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0px solid #E8E8E8;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 15px;
		height: 34px;
	}
	.add-update-preview .el-date-editor {
		width: auto;
		min-width: 50%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #E8E8E8;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 0px;
		margin: 0 20px 0 0;
		outline: none;
		color: #999;
		background: none;
		width: auto;
		font-size: 15px;
		line-height: 40px;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 12px;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 16px;
		min-width: 400px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0px solid #E8E8E8;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: none;
				width: auto;
				font-size: 15px;
				min-width: 400px;
				height: auto;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 6px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #FCBB78;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 6px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #FF8E5A;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 6px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #E49917;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 6px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #B59374;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 6px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #AC9C7C;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
