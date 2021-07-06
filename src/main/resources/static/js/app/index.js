var main = {

    /**main = function() 이렇게 안하고 변수의 속성으로  추가
     * >> 나중에 로딩된 js가 기존의 init,save 를 덮어쓰기 때문에 해당 파일 내
     * 유효 범위를 설정해주기 위함.
    */

    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function(){
            _this.delete();
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
               contentType:'application/json; charset=utf-8',
               data: JSON.stringify(data)
           }).done(function() {
               alert('글이 등록되었습니다.');
               window.location.href = '/';
           }).fail(function (error) {
               alert(JSON.stringify(error));
           });
       },
       update : function () {
           var data = {
               title: $('#title').val(),
               content: $('#content').val()
           };

           var id = $('#id').val();

           $.ajax({
               type: 'PUT',
               url: '/api/v1/posts/'+id,
               dataType: 'json',
               contentType:'application/json; charset=utf-8',
               data: JSON.stringify(data)
           }).done(function() {
               alert('글이 수정되었습니다.');
               window.location.href = '/';
           }).fail(function (error) {
               alert(JSON.stringify(error));
           });
       },
       delete : function () {
           var id = $('#id').val();

           $.ajax({
               type: 'DELETE',
               url: '/api/v1/posts/'+id,
               dataType: 'json',
               contentType:'application/json; charset=utf-8'
           }).done(function() {
               alert('글이 삭제되었습니다.');
               window.location.href = '/';
           }).fail(function (error) {
               alert(JSON.stringify(error));
           });
       }

   };

   main.init();