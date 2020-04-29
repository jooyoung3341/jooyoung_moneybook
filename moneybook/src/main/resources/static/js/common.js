//가계부 타입 가져오기
var moneybook_type = $("#moneybook_type").val();

var sort_flag = "up";
var sort = ""
//가계부 내역 목록 정렬
$(document).on("click","th[name=sort]",function(){
 	sort = $(this).attr("id");
 	if(sort_flag == "up"){
 		sort_flag = "down";
	}else if(sort_flag == "down"){
		sort_flag = "up";
	}
	moneybookSelect(sort, sort_flag);
})
 	
 	
//가계부 내역 가져오기
function moneybookSelect(sort, sort_flag){
	//정렬 클릭 안했을 경우 정렬변수는 null로 값을 보냄
	if(sort == null && sort_flag == null){
		sort = null;
		sort_flag = null;
	} 
	var indate = $("#indate").val();
	$.ajax({
		url : moneybook_type+"/select",
		data : {"indate" : indate,
			   	   "sort" : sort,
			   	   "sort_flag" : sort_flag},
		dataType : "json",
		success : function(data){
			getMoneybook(data);
		},
		error : function(request, error){
			alert("실패");
			//error 코드와 메시지 보기위한 
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	})
}

//내역 삭제
var delete_check = false;
	$("#moneybook_delete").click(function(){
		var confirm_val = confirm("삭제 하시겠습니까?");
		if(confirm_val){
			var checkArr = new Array();
			$("input[name=checkRow]:checked").each(function(){
				checkArr.push($(this).val())
				delete_check = true;
			});
		if(delete_check == true){
		$.ajax({
				url : moneybook_url+"/delete",
				data : {"checkArr" : checkArr},
				//배열값을 넘기기 위한 설정
				traditional : true,
				dateType : "json",
				success : function(){
					moneybookSelect();
				},
				error : function(request, error){
					alert("실패");
					//error 코드와 메시지 보기위한 
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			})
		}
	}
})






	
 	