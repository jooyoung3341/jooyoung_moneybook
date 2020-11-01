	
	document.getElementById("status_date").valueAsDate = new Date();
	
	//가계부 현황 엑셀 다운로드 받기
	$("#excel").click(function(){
		var status_date = $("#status_date").val();
		location.href="excel?status_date="+status_date;
	})
	
	//가계부현황 조회
	function statusSelect(){
		var status_date = $("#status_date").val();
		$.ajax({
			url : "status/select",
			data : {"insert_date" : status_date},
			dataType : "json",
			success : function(data){
				getStatus(data)
			}
		})
	}
	
	//가계부 현황 표
	function getStatus(data){
		var disp = "";
		disp += "<ul class='list-group'>";
		$(data).each(function(idx, item){
			if(idx == 0){
				disp += "<li class='list-group-item d-flex justify-content-between align-items-center' style='width=5px;'>";
				disp += "지출 : <p class='text-primary' style='height: 5px;'>"+Number(item.status).toLocaleString('en')+" 원</p>";
				disp += "</li>";
			}else if(idx == 1){
				disp += "<li class='list-group-item d-flex justify-content-between align-items-center' style='width=5px;'>";
				disp += "수입 : <p class='text-primary' style='height: 5px;'>"+Number(item.status).toLocaleString('en')+" 원</p>";
				disp += "</li>";
			}else if(idx == 2){
				disp += "<li class='list-group-item d-flex justify-content-between align-items-center' style='width=5px;'>";
				disp += "자산 : <p class='text-primary' style='height: 5px;'>"+Number(item.status).toLocaleString('en')+" 원</p>";
				disp += "</li>";
			}
		});
		disp += "</ul>";
		document.getElementById("getStatus").innerHTML = disp;
	} 
	
	//가계부 현황 페이지 리로드
	function refresh(){
		location.reload();
	}
	
	

/*	  var modal_comma = $("form[name='modal_form']").find("input[name='modal_price']");
	 
	 modal_comma.on("keyup", function(event){*/

