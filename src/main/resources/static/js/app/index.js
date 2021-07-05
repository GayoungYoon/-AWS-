var main = {
    /**main = function() 이렇게 안하고 변수의 속성으로  추가
     * >> 나중에 로딩된 js가 기존의 init,save 를 덮어쓰기 때문에 해당 파일 내
     * 유효 범위를 설정해주기 위함.
    */

    init : function () {
        var _this = this;
        $('#btn-save').on('click', function(){
            _this.save();
        });
    },

    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };


        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href='/'; // 글 등록이 성공하면 메인 페이지로 이동함.
        }).fail(function(){
            alert(JSON.stringify(error));
        });
    }
};

main.init();