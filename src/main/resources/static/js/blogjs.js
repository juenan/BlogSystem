
function getIndex() {
    'use strict';

    var i = 0;
    getIndex = function () {
        return i++;
    };
    return i++;

}

function showBlogList() {
    var index = getIndex() + 1;
    var blog_count = 5;
    $.getJSON("/blog?blog_count=" + blog_count + "&page_count=" + index, function (data, status) {
        if (data.code == 1) {
            alert(data.message);
            return;
        }

        for (var i = 0; i < data.list.length; i++) {
            var href =
            $("#blog_list").append("<a href='/blog/"+data.list[i].id+"'><h3 class='text-primary'>" + data.list[i].title + "</h3></a>");
        }

        if (data.blog_count <= index * blog_count) {
            $("#more").hide();
        }
    })

}

function showBlog(id) {
    $.getJSON("api/blog/" + id, function (data) {
        if (data.code == 1) {
            alert(data.message);
            return;
        }
        $("#title").append(data.title);
        $("#content").append(data.content);
        $("#author").append(data.createBy);
        $("#create_time").append(data.createTime);
    })
}


function deleteBlog(id) {
    $.ajax({
        url: "/api/blog",
        type: "DELETE",
        success: function (data) {
            if (data.code == 1) {
                alert("删除失败:" + data.message);
            } else {
                alert("删除成功");
            }
        }
    })
}

