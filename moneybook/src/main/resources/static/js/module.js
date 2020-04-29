 //실시간 콤마 찍기
function comma(){
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
             return ( price_comma == 0 ) ? "" : price_comma.toLocaleString( "en" );
         });
 	})
}

//콤마 삭제
function uncomma(num){
	var num = String(num);
	return num.replace(/[^\d]+/g, "");
}


/* 
.attr() : element가 가지는 속성값이나 정보를 조회하거나 세팅하는 형식의 업무
.prop() : element가 가지는 실제적인 상태(활성화, 체크, 선택여부 등)를 제어하는 업무
*/
//체크박스 전체선택, 전체해제
function checkAll(){
	if( $("#customCheck").is(":checked")){
		$("input[name=checkRow]").prop("checked", true);
	}else{
		$("input[name=checkRow]").prop("checked", false);
	}
}
