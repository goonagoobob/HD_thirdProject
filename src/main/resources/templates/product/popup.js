// var $delivery_progress = false;//바로구매로 수령 매장 팝업 호출 여부
;(function ( $ ) {
	// $(document).ready(function() {//181015 삭제
	// 	$(document).on('click', '.btn_popup_trigger', function(){//페이지 로딩 완료 전 클릭했을 때 링크 실행 prevent
	// 		return false;
	// 	});
	// 	$(document).on('click', '.btn_popup_btot', function(){//페이지 로딩 완료 전 클릭했을 때 링크 실행 prevent
	// 		return false;
	// 	});
	// });

		/* 20181023 수정 : 스크립트 실행 위치 이동 S */ 
		var win_scroll_pos;
		var pop_open_cnt;//팝업 open 횟수
		var pop_z_index; //레이어 팝업 z-index 기본값
		var pre_pop_z_index; //레이어 팝업 z-index 초기화 값
		var cur_pop_z_index; //레이어 팝업 z-index 값
		var cur_pop_open_cnt;//레이어 팝업 여러 개 열었을 때 z-index 에 더해지는 값

		$(document).on('click', '.btn_popup_trigger', function(){
			//181008 추가 시작 | 레이어 팝업의 z-index이 2씩 더해짐
			var $popup = $(this).attr('href');
			
			if($(this).attr("flag")=="sns_pop") {
			    pre_pop_z_index = $('.hsome_layerpop_contents').css('z-index')*1;//레이어 팝업 z-index 기본값
			}
			
			cur_pop_z_index = pre_pop_z_index + cur_pop_open_cnt;
			// console.log(cur_pop_z_index);
			$($popup).css({ zIndex: cur_pop_z_index });
			if ($popup.indexOf('sns_comment_pop') != -1) {//댓글쓰기 버튼 클릭했으면 댓글쓰기 영역 z-index 값 적용
				$('.sns_comment_ipt_pop .sns-comment-ipt').css('z-index', cur_pop_z_index + 1);
			}
			cur_pop_open_cnt = cur_pop_open_cnt + 2;
			//181008 추가 끝

			pop_open_cnt++;
			// console.log(pop_open_cnt);
			win_scroll_pos = $(window).scrollTop();

			// var $popup = $(this).attr('href');//181008 위치 이동


			// if (pop_open_cnt > 1) {//181008 삭제
			// 	$($popup).css({ zIndex: $($popup).css('z-index')*1 + pop_open_cnt });//1000 1001 1002
			// }

			$($popup).addClass('visible');

			if($(this).hasClass('delay') == false){ // 시간 delay있는 팝업 delay 클래스 추가 후 별도 제어
				setTimeout(function(){
					$($popup).addClass('active')
				}, 0);
				setTimeout(function(){
					// $('body').removeClass('hidden');
					// $('.hsome_allContents').css({ transform: 'translateY(' + (win_scroll_pos*-1) + 'px' });
					// $('.hsome_allContents').css({ top: win_scroll_pos*-1 });
					// $('.hsome_allContents').addClass('disabled');

					$($popup).addClass('activated');
				}, 400);
			} // 180709 if문 추가
			
			var varUA = navigator.userAgent.toLowerCase();/*아이폰에서 커서 밖으로 나가는 현상190717*/
            if($(this).hasClass('write_review1907')){
                if (varUA.indexOf("iphone")>-1||varUA.indexOf("ipad")>-1||varUA.indexOf("ipod")>-1) {
                    //IOS 일때 처리
                    $('.product_view_wrap').hide();
                    $('.hsome_contents').css({'height':0,'min-height':0})
                    $('.product_header').css('opacity',0);
                    $('.product_comment_write_pop1905').css('position','relative');
                    $(window).scrollTop(0);
                }
            }else{
                $('body').addClass('hidden');
            }
            
            var $popupTab = $(this).attr('tab');
            
            if($popupTab != null && $popupTab != '') {
                if($popupTab == 'All') {
                    $('#brandTab').click();
                } else {
                    $('#brandTab').click();
                    $('#'+$popupTab+'_oneDepth').click();
                }
            }
            

      return false;
		});
		//레이어 팝업 열기 끝
		/* 20181023 수정 : 스크립트 실행 위치 이동 E */

	// $(window).load(function(){
	$(document).ready(function(){//181015 수정

		////////////////////////////////레이어 팝업(우->좌로 슬라이딩) 시작 180627 수정
		//레이어 팝업 열기 시작
		/* 20181023 수정 : 변수 상단 선언으로 var 선언은 제거 S */
		win_scroll_pos = 0;
		pop_open_cnt = 0;//팝업 open 횟수

		//181008 추가 시작
		pop_z_index = $('.hsome_layer_popup').css('z-index')*1;//레이어 팝업 z-index 기본값
		pre_pop_z_index = pop_z_index;//레이어 팝업 z-index 초기화 값
		cur_pop_z_index = 0;//레이어 팝업 z-index 값
		cur_pop_open_cnt = 0;//레이어 팝업 여러 개 열었을 때 z-index 에 더해지는 값
		//181008 추가 끝
		/* 20181023 수정 : 변수 상단 선언으로 var 선언은 제거 E */

		//레이어 팝업 닫기 시작
		$('.hsome_layer_popup .pop-comm-cls').click(function(){
			// console.log($(this).closest('.hsome_layer_popup').css('z-index')*1);
			pop_open_cnt--;
			cur_pop_open_cnt = cur_pop_open_cnt - 2;//181008 추가 | 레이어 팝업이 닫힐 때 마다 z-index이 2씩 감해짐
			// console.log('닫기 눌렀음 : ' + pop_open_cnt);
			var $popup = $(this).closest('.hsome_layer_popup');
			$popup.removeClass('activated');
			$popup.removeClass('active');

			if (pop_open_cnt <= 0) {
				$(window).scrollTop(win_scroll_pos);
				$('body').removeClass('hidden');
				cur_pop_z_index = pre_pop_z_index;//181008 추가 | 레이어 팝업 z-index값 초기화
				cur_pop_open_cnt = 0;//181008 추가 | 레이어 팝업 z-index 에 더해지는 값 초기화
			}

			setTimeout(function(){
				$popup.removeClass('visible');
			}, 400);
			
			var varUA = navigator.userAgent.toLowerCase();/*아이폰에서 커서 밖으로 나가는 현상190717*/
            if($(this).hasClass('write_review1907_close')){
                if (varUA.indexOf("iphone")>-1||varUA.indexOf("ipad")>-1||varUA.indexOf("ipod")>-1) {
                    //IOS 일때 처리
                    $('.product_view_wrap').show();
                    $('.hsome_contents').css({'height':'auto','min-height':'330px'})
                    $('.product_header').css('opacity',1);
                    $('.product_comment_write_pop1905').css('position','fixed');
                }
            }
			return false;
		});
		//레이어 팝업 닫기 끝
		////////////////////////////////레이어 팝업(우->좌로 슬라이딩) 끝 180627 수정

		////////////////////////////////레이어 팝업(아래->위로 슬라이딩) 시작
		//레이어 팝업 열기 시작
		$(document).on('click', '.btn_popup_btot', function(){
			var $popup = $(this).attr('href');

			$($popup).addClass('visible');
			setTimeout(function(){
				$($popup).addClass('active');
			}, 0);

			$('.hs_pro_view_layer').fadeIn('fast');

      		return false;
		});
		//레이어 팝업 열기 끝

		//레이어 팝업 닫기 시작
		$('.hsome_layer_popup02 .pop-comm-cls').click(function(){
			$(this).parents('.hsome_layer_popup02').removeClass('active');
			$(this).parents('.hsome_layer_popup02').addClass('disabled');
			$('.hs_pro_view_layer').fadeOut('fast');

			setTimeout(function(){
				$('.hsome_layer_popup02').removeClass('disabled');
			}, 400);

			return false;

		});
		//레이어 팝업 닫기 끝
		////////////////////////////////레이어 팝업(아래->위로 슬라이딩) 끝

		// 180627추가 레이어 팝업 닫기 시작
		$('.hsome_layer_popup03 .pop-comm-cls').click(function(){
			$('.hsome_layer_popup03').removeClass('active');
			$('.hsome_layer_popup03').addClass('disabled');
			$('.hs_pro_view_layer').fadeOut('fast');

			setTimeout(function(){
				$('.hsome_layer_popup03').removeClass('disabled');
			}, 400);

			return false;

		});
		// 180627추가 레이어 팝업 닫기 끝
		
		//20200420 추가 
//		$('.hsome_layer_popup04 .pop-comm-cls').click(function(){
//            $('.hsome_layer_popup04').removeClass('active');
//            $('.hsome_layer_popup04').addClass('disabled');
//            $('.hs_pro_view_layer').fadeOut('fast');
//
//            setTimeout(function(){
//                $('.hsome_layer_popup04').removeClass('disabled');
//            }, 400);
//
//            return false;
//
//        });
        //20200420 추가 

	});

})( jQuery );
