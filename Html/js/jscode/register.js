window.onload = function () {

    var form  = document.getElementById("form");
    form.onsubmit = function () {
        return checkUserName() && checkPass();
    };
    var userName = document.getElementById("username");

    userName.onblur = checkUserName;

    var pass = document.getElementById("passwd");
    pass.onblur = checkPass;

    // 校验用户名
    function checkUserName() {
        var userName = document.getElementById("username");
            var text = userName.value;
            var reg = new RegExp("^\\w{6,12}$");
        var s_username = document.getElementById("s_username");
        if (reg.test(text)) {
            s_username.innerHTML = "<img width='35' height='35' src='img/gou.png'>";
        } else {
            s_username.innerHTML = "用户名格式有误";
        }

        return reg.test(text);

    };

    // 校验用户名
    function checkPass() {
        var passwd = document.getElementById("passwd");
        var text1 = passwd.value;
        var reg1 = new RegExp("^\\w{6,12}$");
        var s_passwd = document.getElementById("s_passwd");
        if (reg1.test(text1)) {
            s_passwd.innerHTML = "<img width='35' height='35' src='img/gou.png'>";
        } else {
            s_passwd.innerHTML = "密码格式有误";
        }
        return reg1.test(text1);
    }

};