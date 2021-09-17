// function对象，函数对象
// 1. 创建方式 function 方法名称(形参列表){} 不用写形参的类行
// 2. 方式是对象，定义名称相同时会被覆盖

function myfunc(a, b) {
    // alert(a+b);
}

myfunc(1,2);

var func3 = function (a, b) {
    return a + b;
}

document.write(func3(2,3));

function add() {
    var sum = 0;
    for (var i = 0; i < arguments.length; i++) {
        sum += arguments[i];
    }
    return sum;
}

document.write(add(1,2,3,4,5,6,7,78,8,9));

// 数组
var arr = new Array(6);
var arr1 = new Array(1,2,3,4,5,6);

var arr2 = [1,2,3,4,5,6];
document.write(arr+"<br>");
document.write(arr1+"<br>");

document.write(arr1.join("-")+"<br>");
arr2.push("aaa");
arr2[10] = true;
document.write(arr2+"<br>");

// MATH

document.write(Math.PI+"<br>");
document.write(Math.ceil(3.14)+"<br>");
document.write(Math.floor(3.14)+"<br>");
document.write(Math.round(3.14)+"<br>");

// DATE
var date = new Date();
document.write(date+"<br>");
document.write(date.toJSON()+"<br>");


// 正则表达式

var reg = /^\d{10}$/;
var reg1 = new RegExp("\\d{10}");

document.write(reg1.test("1234567890")+"<br>");


// Gloable对象，对象中封装的方法不需要对象就可以直接调用
document.write(encodeURI("孙萌和崔希")+"<br>");
document.write(encodeURIComponent("孙萌和崔希")+"<br>");
document.write(decodeURI(encodeURI("孙萌和崔希"))+ "<br>");






