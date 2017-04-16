$(function(){
	$("#dd").hide();
	$.datagrid({
	    id:"dg",
		url:"api/userinfo/list",
	    columns:[[
	    	{field:'id',checkbox:true},
	        {field:'userName',title:'用户名',width:100},
	        {field:'nickName',title:'昵称',width:100},
	        {field:'name',title:'姓名',width:100,align:'right'},
	        {field:'opr',width:100,title:'操作',
	        	formatter:function(value,row,index){
	        		//console.info(row);
	        		return "<a href='javascript:void(0);' onclick='fun("+index+")'>修改</a>" +
	        				"&nbsp;&nbsp;<a href='javascript:void(0);' onclick='fun("+index+",1)'>查看</a>";
	        	}
	        }
	    ]],
	    toolbar: [{
			iconCls: 'icon-add',
			text:"添加用户",
			handler: function(){
				$("#userForm").form('clear');
				$('#dd').dialog({
				    title: '添加用户',
				    width: 400,
				    height: 250,
				    closed: false,
				    cache: false,
				    modal: true
				});
			}
		},'-',{
			iconCls: 'icon-remove',
			text:"删除用户",
			handler: function(){
				var _checkedRows = $("#dg").datagrid("getChecked");
				if(_checkedRows.length!=1){
					$.messager.alert('提示信息','只能选择一行');
					return false;
				}
				var _url = "api/userinfo/"+_checkedRows[0].id+"/remove";
				$.messager.confirm('提示信息', '确定删除吗？', function(r){
					if (r){
						$.hnyj.ajax({
							url:_url,
							type:"delete",
							success:function(data){
								$('#dd').dialog('close');
								$.messager.show({
									title:'提示信息',
									msg:_msg,
									timeout:3000,
									showType:'slide'
								});
								$("#dg").datagrid("load");
							}
						});
						$.messager.show({
							title:'提示信息',
							msg:"删除成功",
							timeout:3000,
							showType:'slide'
						});
						$("#dg").datagrid("load");
					}
				});
			}
		},'-',{
			iconCls: 'icon-edit',
			text:"修改用户",
			handler: function(){
				fun();
			}
		}]
	});

	// 添加或修改
	$("#btnSave").click(function(){
		var data = $("#userForm").serializeObj();
		var _type = "post";
		var _url = "api/userinfo/add";
		var _msg = '用户添加成功';
		if(data.id){
			_type = "put";
			_url = "api/userinfo/modify";
			_msg = "用户修改成功";
		}
		$.hnyj.ajax({
			url:_url,
			data:$("#userForm").serializeObj(),
			type:_type,
			success:function(data){
				$('#dd').dialog('close');
				$.messager.show({
					title:'提示信息',
					msg:_msg,
					timeout:3000,
					showType:'slide'
				});
				$("#dg").datagrid("load");
			}
		});
	});
	
	// 关闭dialog
	$("#btnClose").bind("click",function(){
		$('#dd').dialog('close');
	});
	
});

/**
 * 修改用户
 * @param index
 * @returns
 */
function fun(index,o){
	var _checkedRow;
	
	if(index!= undefined){
		_checkedRow =$("#dg").datagrid("getRows")[index];
		if(o){
			$("#btnSave").hide();
		}else{
			$("#btnSave").show();
		}
	}else{
		var _checkedRows = $("#dg").datagrid("getChecked");
		if(_checkedRows.length!=1){
			$.messager.alert('提示信息','只能选择一行');
			return false;
		}
		_checkedRow = _checkedRows[0];
	}
	
	/* 通过请求后台加载数据
	var _data = {};
	$.hnyj.ajax({
		url:"api/userinfo/"+_checkedRow.id+"/query",
		async:false,// 同步请求，默认异步
		success:function(data){
			_data = data.data;
			console.info(_data);
		}
	});
	$("#userForm").form('load',_data);
	*/
	$("#userForm").form('load',_checkedRow);
	$('#dd').dialog({
	    title: '修改用户',
	    width: 400,
	    height: 250,
	    closed: false,
	    cache: false,
	    modal: true
	});
}