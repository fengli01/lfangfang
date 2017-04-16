(function ($) {
	
	// 默认值
	var defaluts = {
		method:"get",
		pagination:true,
		pageNumber:1,
		loadFilter:function(data){
	    	var _data = data.data;
	    	_data.rows = _data.list;
	    	_data.list = undefined;
	    	return _data;
	    },
	    onBeforeLoad:function(param){
	    	param.pageNumber = param.page;
	    	param.pageSize = param.rows;
	    	param.page = undefined;
	    	param.rows = undefined;
	    	return param;
	    }
	}
	$.datagrid = function(options){
		
		// 遍历默认值对象，设置默认值
		$.each(defaluts,function(key,value){
			if(options[key]==undefined){
				options[key] = value;
			}
		});
		$("#"+options.id).datagrid(options);
	}

})(jQuery);