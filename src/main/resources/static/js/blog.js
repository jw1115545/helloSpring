$(document).ready(function () {
    $("button").click(function () {
        let keyword = $("#keyword").val();
        $.getJSON("/api/v1/blogmenu?keyword="+keyword, function (result) {
            let html = "<h4>검색 결과</h4>";
            $.each(result.items, function (i, field) {
                // $("div").append(field + " ");
                console.log(field.title);
                // console.log(field['price']);
                // console.log(field.img);
                html += "<a href='" + field.link + "' target='_blank'>" + field.title + "</a><br>";
                // html += "<h5>"+field.price+"</h5>";
                // html += "<img src='"+field.img+"'>";
            });
            $("#bloglist").html(html);
        });
    });
});
