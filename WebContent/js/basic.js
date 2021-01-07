let header = new Vue({
	el:"#header",//这个Vue对象的作用范围
	data:{
		types:[],//所有的类型
		onlogin:false,//记录是否已经登录
		memberInfo:{}//当前登录的对象
	},
	mounted:function(){//vue渲染完成后要执行的方法
		//发送一个请求获取所有店铺类型信息，跟$.get()相似，axios.get(请求地址,请求参数).then(回调函数)
		axios.get("type", {params:{op:"finds"}}).then( rt =>{
			//console.log(rt);
			if(rt.status == 200){//说明请求成功
				this.types = rt.data;//注意：this不能少，说明是取当前这个Vue对象中data里面的types属性
			}
		} )
		//发送一个请求去获取用户登录信息
		axios.get("member",{params:{op:"check"}}).then(rt => {
			if(rt.status == 200 && rt.data.code == 200){
				this.onlogin = true;
				this.memberInfo = rt.data.data;
			}else{
				this.onlogin = false;
				this.memberInfo = {};
			}
		})
	},
	methods:{
		findByTid: function(tid){
			console.info(tid);
		}
	}
})
function showMsg(msg, color, callback){
	$("#popup_info").text(msg).css("color",color);
	$(".popup_con").fadeIn('fast',function(){
		setTimeout(function(){
			$(".popup_con").fadeOut('fast', callback);
		},2000);
	})
}