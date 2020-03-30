	
	document.getElementById("status_date").valueAsDate = new Date();
	
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
				disp += "지출 : <p class='text-primary' style='height: 5px;'>"+AddComma(Math.floor(item.status))+" 원</p>";
				disp += "</li>";
			}else if(idx == 1){
				disp += "<li class='list-group-item d-flex justify-content-between align-items-center' style='width=5px;'>";
				disp += "수입 : <p class='text-primary' style='height: 5px;'>"+AddComma(Math.floor(item.status))+" 원</p>";
				disp += "</li>";
			}else if(idx == 2){
				disp += "<li class='list-group-item d-flex justify-content-between align-items-center' style='width=5px;'>";
				disp += "자산 : <p class='text-primary' style='height: 5px;'>"+AddComma(Math.floor(item.status))+" 원</p>";
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
	
	
	 var price_comma = $("form[name='form']").find("input[name='price']");
	 price_comma.on("keyup", function(event){
	 	    // 입력 된 값을 price_comma에 넣어준다
	         var $this = $( this );
	         var price_comma= $this.val();
	         //특수문자, 공백 등 제거하는 정규식
	         var price_comma = price_comma.replace(/[\D\s\._\-]+/g, "");
	         //text를 정수로 변환한다. parseInt함수를 사용하여 Number 타입으로 변환
	         price_comma = price_comma ? parseInt( price_comma, 10 ) : 0;
	         // 1,000 단위별로 comma를 추가하기 위해 toLocaleString 함수 적용
	         //
	         $this.val( function() {
	             return ( price_comma == 0 ) ? "" : price_comma.toLocaleString( "en-US" );
	         });
	 })
	 
	  var modal_comma = $("form[name='modal_form']").find("input[name='modal_price']");
	 modal_comma.on("keyup", function(event){
	 	    // 입력 된 값을 price_comma에 넣어준다
	         var $this = $( this );
	         var modal_comma= $this.val();
	         //특수문자, 공백 등 제거하는 정규식
	         var modal_comma = modal_comma.replace(/[\D\s\._\-]+/g, "");
	         //text를 정수로 변환한다. parseInt함수를 사용하여 Number 타입으로 변환
	         modal_comma = modal_comma ? parseInt( modal_comma, 10 ) : 0;
	         // 1,000 단위별로 comma를 추가하기 위해 toLocaleString 함수 적용
	         //
	         $this.val( function() {
	             return ( modal_comma == 0 ) ? "" : modal_comma.toLocaleString( "en-US" );
	         });
	 })
