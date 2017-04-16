(function($){
	
	// 封装ajax请求
	$.hnyj = {
		ajax : function(options){
			options.beforeSend = function(XHR){
				XHR.setRequestHeader("token","123456");
				/*if(options.data){
					var sign = MD5.encode(JSON.stringify(options.data));
					options.data.sign = sign;
				}*/
			};
			$.ajax(options);
		}
	} 
	
	/**
	 * 扩展序列化函数
	 */
	$.fn.serializeObj = function() {
		var serializeObj = {};
		var array = this.serializeArray();
		var str = this.serialize();
		$(array).each(
				function() {
					if (serializeObj[this.name]) {
						if ($.isArray(serializeObj[this.name])) {
							if (this.value) {
								serializeObj[this.name].push(this.value);
							}
						} else {
							if (this.value) {
								serializeObj[this.name] = [
										serializeObj[this.name], this.value ];
							}
						}
					} else {
						if (this.value) {
							serializeObj[this.name] = this.value;
						}
					}
				});
		return serializeObj;
	};
}(jQuery))